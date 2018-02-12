package example.com.mobileexam.model.local;

import android.support.annotation.NonNull;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kestrella on 2/11/18.
 * implementation to load tasks from the data sources into a cache
 * and vice versa, depends on connectivity status
 */

public class CarsRepository implements CarDataSource {
  private static CarsRepository INSTANCE = null;

  private final CarDataSource carDataSource;

  // Prevent direct instantiation.
  private CarsRepository(@NonNull CarDataSource carDataSource) {
    this.carDataSource = checkNotNull(carDataSource);
  }


  /**
   * Returns the single instance of this class, creating it if necessary.
   *
   * @param carLocalDataSource the device storage data source
   * @return the {@link CarsRepository} instance
   */
  public static CarsRepository getInstance(CarDataSource carLocalDataSource) {
    if (INSTANCE == null) {
      INSTANCE = new CarsRepository(carLocalDataSource);
    }
    return INSTANCE;
  }

  /**
   * Used to force {@link #getInstance(CarDataSource)} to create a new instance
   * next time it's called.
   */
  public static void destroyInstance() {
    INSTANCE = null;
  }

  @Override
  public void getCars(@NonNull final LoadCarsCallback callback) {
    carDataSource.getCars(new LoadCarsCallback() {
      @Override
      public void onCarsLoaded(List<Car> carList) {
        callback.onCarsLoaded(carList);
      }

      @Override
      public void onDataNotAvailable() {
        callback.onDataNotAvailable();
      }
    });
  }

  @Override
  public void getCar(@NonNull String carId, @NonNull final GetCarCallback callback) {
    carDataSource.getCar(carId, new GetCarCallback() {
      @Override
      public void onCarLoaded(Car car) {
        callback.onCarLoaded(car);
      }

      @Override
      public void onDataNotAvailable() {
        callback.onDataNotAvailable();
      }
    });
  }

  @Override
  public void saveCar(@NonNull Car car) {
    carDataSource.saveCar(car);
  }

  @Override
  public void refreshCars() {

  }

  @Override
  public void deleteAllCars() {

  }

  @Override
  public void deleteCar(@NonNull String carId) {

  }
}
