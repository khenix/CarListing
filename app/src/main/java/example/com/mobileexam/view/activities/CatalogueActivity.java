package example.com.mobileexam.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import example.com.mobileexam.R;
import example.com.mobileexam.utils.ActivityUtils;
import example.com.mobileexam.view.fragments.CarsFragment;
import example.com.mobileexam.view.fragments.CataloguePresenter;

public class CatalogueActivity extends AppCompatActivity {
  private static final String CURRENT_SORTING_KEY = "CURRENT_SORTING_KEY";

  CataloguePresenter cataloguePresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_catalogue);


    CarsFragment carListFragment =
        (CarsFragment) getSupportFragmentManager().findFragmentById(R.id.layout_content);
    if (carListFragment == null) {
      // Create the fragment
      carListFragment = CarsFragment.newInstance();
      ActivityUtils.addFragmentToActivity(
          getSupportFragmentManager(), carListFragment, R.id.layout_content);
    }
//

    // Create the presenter
    cataloguePresenter = new CataloguePresenter(this, carListFragment);


    // Load previously saved state, if available.
    if (savedInstanceState != null) {
      String currentSorting =
          (String) savedInstanceState.getSerializable(CURRENT_SORTING_KEY);
      cataloguePresenter.setSorting(currentSorting);
    }

  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    outState.putSerializable(CURRENT_SORTING_KEY, cataloguePresenter.getSorting());

    super.onSaveInstanceState(outState);
  }

}
