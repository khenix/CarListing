package example.com.mobileexam.view.fragments;

import android.content.Context;


import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import example.com.mobileexam.model.dto.CatalogueData;
import example.com.mobileexam.model.dto.CatalogueResult;
import example.com.mobileexam.model.local.Car;
import example.com.mobileexam.model.local.CarDataSource;
import example.com.mobileexam.model.local.CarDetailsRepository;
import example.com.mobileexam.model.local.CarsRepository;
import example.com.mobileexam.utils.NetConnection;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by kestrella on 2/12/18.
 */
public class CataloguePresenterTest {

  private static List<CatalogueResult> CARS;

  @Mock
  private CarsRepository carsRepository;

  @Mock
  private CarDetailsRepository carDetailsRepository;

  @Mock
  private Context context;

  @Mock
  private CatalogueContract.View contractView;

  @Mock
  private ModelMapper mapper;

  @Mock
  CatalogueContract contract;

  /**
   * {@link ArgumentCaptor} is a powerful Mockito API to capture argument values and use them to
   * perform further actions or assertions on them.
   */
  @Captor
  private ArgumentCaptor<CarDataSource.LoadCarsCallback> loadCarsCallbackArgumentCaptor;

  private CataloguePresenter cataloguePresenter;

  @Before
  public void setupCarsPresenter() {
    // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
    // inject the mocks in the test the initMocks method needs to be called.
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    cataloguePresenter = new CataloguePresenter(carsRepository, carDetailsRepository, context, contractView);

    // The presenter won't update the view unless it's active.
    when(contractView.isActive()).thenReturn(true);


    //    lets mock data
    List<CatalogueResult> catalogueResultList = new ArrayList<>();

    CatalogueData catalogueData = new CatalogueData();
    catalogueData.setId("1");
    catalogueData.setName("Car A");
    catalogueData.setPrice("100000.00");
    catalogueData.setBrand("Mercedes-Benz");
    catalogueData.setBrand_model("C63 AMG");

    CatalogueResult catalogueResult = new CatalogueResult();
    catalogueResult.setId("1");
    catalogueResult.setData(catalogueData);

    catalogueResultList.add(catalogueResult);

    CARS = catalogueResultList;
  }

  @Test
  public void createPresenter_setsThePresenterToView() {
    // Get a reference to the class under test
    cataloguePresenter = new CataloguePresenter(carsRepository, carDetailsRepository, context, contractView);

    // Then the presenter is set to the view
    verify(contractView).setPresenter(cataloguePresenter);
  }

  @Test
  public void loadAllCarsFromRepositoryAndLoadIntoView() {
    // Given an initialized CataloguePresenter with initialized data
    // When loading of CARS is requested
    NetConnection.isConnected(context);
    cataloguePresenter.loadCarList(true, 1);

    // since we are testing from local repository, lets create new list that
    // will correspond to local data
    List<Car> mCars = new ArrayList<>();
    for (CatalogueResult each : CARS) {
      Car car = new Car();
      car.setId(each.getId());
      mCars.add(car);

    }

    // Callback is captured and invoked with stubbed cars
    verify(carsRepository).getCars(loadCarsCallbackArgumentCaptor.capture());
    loadCarsCallbackArgumentCaptor.getValue().onCarsLoaded(mCars);
    ArgumentCaptor<List> showCarsArgumentCaptor = ArgumentCaptor.forClass(List.class);

  }


}