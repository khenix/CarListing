package example.com.mobileexam.model.local;

import android.support.annotation.NonNull;

import example.com.mobileexam.utils.AppExecutors;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kestrella on 2/12/18.
 */

public class CarLocalDetailsDataSource implements CarDetailsDataSource {


  private static volatile CarLocalDetailsDataSource INSTANCE;

  private CarDetailsDao carDetailsDao;

  private AppExecutors appExecutors;

  // Prevent direct instantiation.
  private CarLocalDetailsDataSource(@NonNull AppExecutors appExecutors,
                                    @NonNull CarDetailsDao carDetailsDao) {
    this.appExecutors = appExecutors;
    this.carDetailsDao = carDetailsDao;
  }

  public static CarLocalDetailsDataSource getInstance(@NonNull AppExecutors appExecutors,
                                                      @NonNull CarDetailsDao carDetailsDao) {
    if (INSTANCE == null) {
      synchronized (CarLocalDetailsDataSource.class) {
        if (INSTANCE == null) {
          INSTANCE = new CarLocalDetailsDataSource(appExecutors, carDetailsDao);
        }
      }
    }
    return INSTANCE;
  }

  @Override
  public void getCarDetails(@NonNull final String carDetailsId, @NonNull final GetCarDetailsCallback callback) {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        final CarDetails carDetails = carDetailsDao.load(carDetailsId);

        appExecutors.mainThread().execute(new Runnable() {
          @Override
          public void run() {
            if (carDetails != null) {
              callback.onCarDetailsLoaded(carDetails);
            } else {
              callback.onDataNotAvailable();
            }
          }
        });
      }
    };

    appExecutors.diskIO().execute(runnable);
  }

  @Override
  public void saveCarDetails(@NonNull final CarDetails carDetails) {
    checkNotNull(carDetails);
    Runnable saveRunnable = new Runnable() {
      @Override
      public void run() {
        carDetailsDao.insertOrReplace(carDetails);
      }
    };
    appExecutors.diskIO().execute(saveRunnable);
  }

  @Override
  public void refreshCarDetails() {

  }

  @Override
  public void deleteAllCarDetails() {
    Runnable deleteRunnable = new Runnable() {
      @Override
      public void run() {
        carDetailsDao.deleteAll();
      }
    };

    appExecutors.diskIO().execute(deleteRunnable);
  }

  @Override
  public void deleteCarDetails(@NonNull final String carDetailsId) {
    Runnable deleteRunnable = new Runnable() {
      @Override
      public void run() {
        carDetailsDao.deleteByKey(carDetailsId);
      }
    };

    appExecutors.diskIO().execute(deleteRunnable);
  }
}