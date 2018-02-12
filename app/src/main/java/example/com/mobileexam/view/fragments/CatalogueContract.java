package example.com.mobileexam.view.fragments;

import android.support.annotation.NonNull;

import java.util.List;

import example.com.mobileexam.BasePresenter;
import example.com.mobileexam.BaseView;
import example.com.mobileexam.model.dto.CatalogueResult;

/**
 * Created by kestrella on 2/9/18.
 */

public interface CatalogueContract {

  interface View extends BaseView<Presenter> {

    boolean isActive();

    void showLoader();

    void hideLoader();

    void showLoadingError();

    void showData(List<CatalogueResult> catalogueResults);

    void showDetail(String s);

    void showNoData();

    void resetData();
  }

  interface Presenter extends BasePresenter {

    void loadCarList(boolean willForceUpdate, int page);

    void openCarDetails(@NonNull CatalogueResult catalogueResult);

    void setSorting(String sorting);

    String getSorting();

  }
}
