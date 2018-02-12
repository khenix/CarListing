package example.com.mobileexam.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import example.com.mobileexam.R;
import example.com.mobileexam.model.dto.CatalogueResult;
import example.com.mobileexam.view.InfiniteScrollListener;
import example.com.mobileexam.view.adapters.CarsAdapter;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kestrella on 2/9/18.
 */

public class CarsFragment extends Fragment implements CatalogueContract.View {
  private static final String TAG = CarsFragment.class.getSimpleName();

  public CarsFragment() {
    // Requires empty public constructor
  }

  public static CarsFragment newInstance() {
    return new CarsFragment();
  }

  CatalogueContract.Presenter mPresenter;
  CarsAdapter carsAdapter;
  @BindView(R.id.rv_cars)
  RecyclerView rvCars;

  @BindView(R.id.cars_swipe_refresh_layout)
  SwipeRefreshLayout swipeRefreshLayout;

  @BindView(R.id.action_bar)
  View actionBar;

  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
  private InfiniteScrollListener infiniteScrollListener;


  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    carsAdapter = new CarsAdapter(getActivity(), new ArrayList<CatalogueResult>(0), mItemListener);
  }


  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.carlist_fg, container, false);

    setHasOptionsMenu(true);
    return root;

  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
    rvCars.setLayoutManager(linearLayoutManager);
    rvCars.setAdapter(carsAdapter);

    swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        resetData();
      }
    });

    infiniteScrollListener = new InfiniteScrollListener(linearLayoutManager) {
      @Override
      public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {

        makeLog("will load more... " + page);
        makeLog(mPresenter.getSorting());
        mPresenter.loadCarList(false, page);

      }
    };

    rvCars.addOnScrollListener(infiniteScrollListener);


  }

  @Override
  public void onResume() {
    super.onResume();
    mPresenter.start();
  }

  @Override
  public void setPresenter(@NonNull CatalogueContract.Presenter presenter) {
    mPresenter = checkNotNull(presenter);
  }

  @Override
  public boolean isActive() {
    return isAdded();
  }

  @Override
  public void showLoader() {
    swipeRefreshLayout.setRefreshing(true);
  }

  @Override
  public void hideLoader() {
    swipeRefreshLayout.setRefreshing(false);
  }

  @Override
  public void showLoadingError() {

  }

  @Override
  public void showData(List<CatalogueResult> catalogueResults) {
    carsAdapter.swap(catalogueResults);

  }

  @Override
  public void showDetail(String s) {
    Toast.makeText(getActivity(), "TODO: open car details, id is " + s, Toast.LENGTH_LONG).show();

  }

  @Override
  public void showNoData() {

  }

  @OnClick(R.id.action_sort)
  void showSortMenu() {
// todo
  }

  @Override
  public void resetData() {
    makeLog("refresh data");
    carsAdapter = new CarsAdapter(getActivity(), new ArrayList<CatalogueResult>(0), mItemListener);
    rvCars.setAdapter(carsAdapter);
    rvCars.invalidate();
    infiniteScrollListener.resetState();
    hideLoader();
    mPresenter.start();
  }

  /**
   * Listener for clicks on cars in the RecyclerView.
   */
  CarsAdapter.CarItemListener mItemListener = new CarsAdapter.CarItemListener() {
    @Override
    public void onCarClick(CatalogueResult clickedCar) {
      mPresenter.openCarDetails(clickedCar);
    }
  };

  private void makeLog(String message) {
    Log.w(TAG, "*****---->>> " + message);
  }

}
