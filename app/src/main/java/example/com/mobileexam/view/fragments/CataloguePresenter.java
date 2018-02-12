package example.com.mobileexam.view.fragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import example.com.mobileexam.model.dto.CatalogueResult;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kestrella on 2/9/18.
 */

public class CataloguePresenter implements CatalogueContract.Presenter {

  private final CatalogueContract.View mCatalogueView;
  private List<CatalogueResult> mCatalogueResults = new ArrayList<>();
  List<CatalogueResult> localList = new ArrayList<>();
  private final Context context;


  public CataloguePresenter(Context context, @NonNull CatalogueContract.View catalogueView) {
    mCatalogueView = checkNotNull(catalogueView, "catalogueView cannot be null!");
    mCatalogueView.setPresenter(this);
    this.context = context;
  }


  @Override
  public void start() {

  }

  @Override
  public void loadCarList(boolean willForceUpdate, int page) {

  }

  @Override
  public void setSorting(String sorting) {

  }

  @Override
  public String getSorting() {
    return null;
  }

  @Override
  public void openCarDetails(@NonNull CatalogueResult catalogueResult) {

  }
}
