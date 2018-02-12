package example.com.mobileexam.model.local;

import android.support.annotation.NonNull;

/**
 * Note: CarDetailsId and Car Id has the same value as per API observation
 * Created by kestrella on 2/12/18.
 */

public interface CarDetailsDataSource {

  interface LoadCarDetailsCallback {

    void onCarDetailsLoaded(CarDetails carDetails);

    void onDataNotAvailable();
  }

  interface GetCarDetailsCallback {

    void onCarDetailsLoaded(CarDetails carDetails);

    void onDataNotAvailable();
  }

  void getCarDetails(@NonNull String carDetailsId, @NonNull GetCarDetailsCallback callback);

  void saveCarDetails(@NonNull CarDetails carDetails); // no callback for save actions as greendao swallows insertion error

  void refreshCarDetails();

  void deleteAllCarDetails();

  void deleteCarDetails(@NonNull String carDetailsId);
}
