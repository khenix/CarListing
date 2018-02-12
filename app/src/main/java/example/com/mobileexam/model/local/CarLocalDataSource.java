package example.com.mobileexam.model.local;

import android.support.annotation.NonNull;

import java.util.List;


import example.com.mobileexam.utils.AppExecutors;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kestrella on 2/11/18.
 * Implementation of Car data source
 */

public class CarLocalDataSource implements CarDataSource {


  private static volatile CarLocalDataSource INSTANCE;

  private CarDao carDao;

  private AppExecutors appExecutors;

  // Prevent direct instantiation.
  private CarLocalDataSource(@NonNull AppExecutors appExecutors,
                             @NonNull CarDao carDao) {
    this.appExecutors = appExecutors;
    this.carDao = carDao;
  }

  public static CarLocalDataSource getInstance(@NonNull AppExecutors appExecutors,
                                               @NonNull CarDao carDao) {
    if (INSTANCE == null) {
      synchronized (CarLocalDataSource.class) {
        if (INSTANCE == null) {
          INSTANCE = new CarLocalDataSource(appExecutors, carDao);
        }
      }
    }
    return INSTANCE;
  }


  /**
   * Note: {@link LoadCarsCallback#onDataNotAvailable()} is fired if the database doesn't exist
   * or the table is empty.
   */
  @Override
  public void getCars(@NonNull final LoadCarsCallback callback) {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        final List<Car> carList = carDao.loadAll();
        appExecutors.mainThread().execute(new Runnable() {
          @Override
          public void run() {
            if (carList.isEmpty()) {
              // This will be called if the table is new or just empty.
              callback.onDataNotAvailable();
            } else {
              callback.onCarsLoaded(carList);
            }
          }
        });
      }
    };

    appExecutors.diskIO().execute(runnable);
  }


  /**
   * Note: {@link GetCarCallback#onDataNotAvailable()} is fired if the {@link Car} isn't
   * found.
   */
  @Override
  public void getCar(@NonNull final String carId, @NonNull final GetCarCallback callback) {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        final Car car = carDao.load(carId);

        appExecutors.mainThread().execute(new Runnable() {
          @Override
          public void run() {
            if (car != null) {
              callback.onCarLoaded(car);
            } else {
              callback.onDataNotAvailable();
            }
          }
        });
      }
    };

    appExecutors.diskIO().execute(runnable);
  }

  /**
   * If data is new, it will be saved to db
   * else, it will just update the current data
   * of the car
   */
  @Override
  public void saveCar(@NonNull final Car car) {
    checkNotNull(car);
    Runnable saveRunnable = new Runnable() {
      @Override
      public void run() {
        carDao.insertOrReplace(car);
      }
    };
    appExecutors.diskIO().execute(saveRunnable);
  }

  @Override
  public void refreshCars() {

  }

  @Override
  public void deleteAllCars() {
    Runnable deleteRunnable = new Runnable() {
      @Override
      public void run() {
        carDao.deleteAll();
      }
    };

    appExecutors.diskIO().execute(deleteRunnable);
  }

  @Override
  public void deleteCar(@NonNull final String carId) {
    Runnable deleteRunnable = new Runnable() {
      @Override
      public void run() {
        carDao.deleteByKey(carId);
      }
    };

    appExecutors.diskIO().execute(deleteRunnable);
  }
}
