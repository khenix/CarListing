package example.com.mobileexam.model.local;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by kestrella on 2/11/18.
 * Main entry point and blueprint for Car data access
 */

public interface CarDataSource {

  interface LoadCarsCallback {

    void onCarsLoaded(List<Car> carList);

    void onDataNotAvailable();
  }

  interface GetCarCallback {

    void onCarLoaded(Car car);

    void onDataNotAvailable();
  }

  void getCars(@NonNull LoadCarsCallback callback);

  void getCar(@NonNull String carId, @NonNull GetCarCallback callback);

  void saveCar(@NonNull Car car); // no callback for save actions as greendao swallows insertion error

  void refreshCars();

  void deleteAllCars();

  void deleteCar(@NonNull String carId);
}
