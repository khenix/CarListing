package example.com.mobileexam.view.fragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import example.com.mobileexam.BuildConfig;
import example.com.mobileexam.helper.VolleyRequestHelper;
import example.com.mobileexam.model.dto.CatalogueData;
import example.com.mobileexam.model.dto.CatalogueImage;
import example.com.mobileexam.model.dto.CatalogueResponseDTO;
import example.com.mobileexam.model.dto.CatalogueResult;
import example.com.mobileexam.model.local.Car;
import example.com.mobileexam.model.local.CarDataSource;
import example.com.mobileexam.model.local.CarDetails;
import example.com.mobileexam.model.local.CarDetailsDataSource;
import example.com.mobileexam.model.local.CarDetailsRepository;
import example.com.mobileexam.model.local.CarsRepository;
import example.com.mobileexam.utils.NetConnection;

import static com.google.common.base.Preconditions.checkNotNull;
import static example.com.mobileexam.utils.Parser.parseGeneric;
import static example.com.mobileexam.utils.Parser.parseGenericList;

/**
 * Created by kestrella on 2/9/18.
 */


public class CataloguePresenter implements CatalogueContract.Presenter {

  private final CatalogueContract.View mCatalogueView;
  private VolleyRequestHelper volleyRequestHelper;
  private List<CatalogueResult> mCatalogueResults = new ArrayList<>();
  private List<CatalogueResult> localList = new ArrayList<>();
  private String sorting;
  private final Context context;
  private final CarsRepository carsRepository;
  private final CarDetailsRepository carDetailsRepository;
  private ModelMapper mapper = new ModelMapper();


  public CataloguePresenter(@NonNull CarsRepository carsRepository, @NonNull CarDetailsRepository carDetailsRepository,
                            Context context, @NonNull CatalogueContract.View catalogueView) {
    mCatalogueView = checkNotNull(catalogueView, "catalogueView cannot be null!");
    mCatalogueView.setPresenter(this);
    volleyRequestHelper = new VolleyRequestHelper(context, requestCompletedListener);
    this.context = context;
    this.carsRepository = carsRepository;
    this.carDetailsRepository = carDetailsRepository;
  }


  @Override
  public void start() {
    mCatalogueResults.clear();
    loadCarList(false, 1);
  }

  @Override
  public void loadCarList(boolean willForceUpdate, int page) {
    if (NetConnection.isConnected(context)) {
      String url;
      if (getSorting() == null)
        url = BuildConfig.API_URL + "/api/cars/page:" + page + "/maxitems:10/";
      else
        url = BuildConfig.API_URL + "/api/cars/page:" + page + "/maxitems:10/sort:" + getSorting();

      makeLog(url);
      mCatalogueView.showLoader();
      volleyRequestHelper.makeStringGETRequest(url, "cars");
    } else {
      localList.clear();
      carsRepository.getCars(new CarDataSource.LoadCarsCallback() {
        @Override
        public void onCarsLoaded(List<Car> carList) {

          for (final Car each : carList) {
            carDetailsRepository.getCarDetails(each.getId(), new CarDetailsDataSource.GetCarDetailsCallback() {
              @Override
              public void onCarDetailsLoaded(CarDetails carDetails) {
                CatalogueData catalogueData = mapper.map(carDetails, CatalogueData.class);
                CatalogueResult catalogueResult = new CatalogueResult();
                catalogueResult.setData(catalogueData);
                catalogueResult.setId(catalogueData.getId());
                localList.add(catalogueResult);
                mCatalogueView.showData(localList);

                List<CatalogueImage> imageList = parseGenericList(each.getImages(), CatalogueImage[].class);
                catalogueResult.setImages(imageList);
              }

              @Override
              public void onDataNotAvailable() {

              }
            });
          }
        }

        @Override
        public void onDataNotAvailable() {
          makeLog("no data e");
        }
      });
    }


  }

  @Override
  public void openCarDetails(@NonNull CatalogueResult catalogueResult) {
    checkNotNull(catalogueResult, "catalogueResult cannot be null!");
    mCatalogueView.showDetail(catalogueResult.getId());
  }

  @Override
  public void setSorting(String sorting) {
    this.sorting = sorting;
    makeLog("sorting: " + sorting);
    mCatalogueView.resetData();

  }

  @Override
  public String getSorting() {
    return sorting;
  }

  /* The request completed listener */
  private VolleyRequestHelper.OnRequestCompletedListener requestCompletedListener = new VolleyRequestHelper.OnRequestCompletedListener() {
    @Override
    public void onRequestCompleted(String requestName, boolean status,
                                   String response, String errorMessage) {
      mCatalogueView.hideLoader();
      if (status) {
        CatalogueResponseDTO catalogueResponseDTO = parseGeneric(response, CatalogueResponseDTO.class);
        mCatalogueResults.addAll(catalogueResponseDTO.getMetadata().getResults());
        mCatalogueView.showData(mCatalogueResults);

        for (CatalogueResult catalogueResult : catalogueResponseDTO.getMetadata().getResults()) {
          Car car = new Car();
          car.setId(catalogueResult.getId());
          car.setImages(new Gson().toJson(catalogueResult.getImages()));
          carsRepository.saveCar(car);
          CarDetails carDetails = mapper.map(catalogueResult.getData(), CarDetails.class);
          carDetailsRepository.saveCarDetails(carDetails);

        }
      }

    }
  };

  private void makeLog(String message) {
    Log.w("CataloguePresenter", "*****---->>> " + message);
  }
}
