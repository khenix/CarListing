package example.com.mobileexam.model.local;

import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kestrella on 2/12/18.
 */

public class CarDetailsRepository implements CarDetailsDataSource {
  private static CarDetailsRepository INSTANCE = null;

  private final CarDetailsDataSource carDetailsSource;

  // Prevent direct instantiation.
  private CarDetailsRepository(@NonNull CarDetailsDataSource carDetailsSource) {
    this.carDetailsSource = checkNotNull(carDetailsSource);
  }

  /**
   * Returns the single instance of this class, creating it if necessary.
   *
   * @param carLocalDataSource the device storage data source
   * @return the {@link CarDetailsRepository} instance
   */
  public static CarDetailsRepository getInstance(CarDetailsDataSource carLocalDataSource) {
    if (INSTANCE == null) {
      INSTANCE = new CarDetailsRepository(carLocalDataSource);
    }
    return INSTANCE;
  }

  /**
   * Used to force {@link #getInstance(CarDetailsDataSource)} to create a new instance
   * next time it's called.
   */
  public static void destroyInstance() {
    INSTANCE = null;
  }

  @Override
  public void getCarDetails(@NonNull String carDetailsId, @NonNull final GetCarDetailsCallback callback) {
    carDetailsSource.getCarDetails(carDetailsId, new GetCarDetailsCallback() {
      @Override
      public void onCarDetailsLoaded(CarDetails carDetails) {
        callback.onCarDetailsLoaded(carDetails);
      }

      @Override
      public void onDataNotAvailable() {
        callback.onDataNotAvailable();
      }
    });
  }

  @Override
  public void saveCarDetails(@NonNull CarDetails carDetails) {
    carDetailsSource.saveCarDetails(carDetails);
  }

  @Override
  public void refreshCarDetails() {

  }

  @Override
  public void deleteAllCarDetails() {

  }

  @Override
  public void deleteCarDetails(@NonNull String carDetailsId) {

  }
}
