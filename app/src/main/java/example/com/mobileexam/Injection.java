package example.com.mobileexam;

import android.content.Context;
import android.support.annotation.NonNull;

import example.com.mobileexam.model.local.CarDataSource;
import example.com.mobileexam.model.local.CarDetailsDataSource;
import example.com.mobileexam.model.local.CarDetailsRepository;
import example.com.mobileexam.model.local.CarLocalDataSource;
import example.com.mobileexam.model.local.CarLocalDetailsDataSource;
import example.com.mobileexam.model.local.CarsRepository;
import example.com.mobileexam.model.local.DaoSession;
import example.com.mobileexam.model.local.MyDb;
import example.com.mobileexam.utils.AppExecutors;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kestrella on 2/12/18.
 * Dependency injection at compile time for
 * {@link CarDataSource} and {@link CarDetailsDataSource}
 */

public class Injection {

  public static CarsRepository provideCarsRepository(@NonNull Context context) {
    checkNotNull(context);
    DaoSession database = MyDb.getDaoSession(context);
    return CarsRepository.getInstance(
        CarLocalDataSource.getInstance(new AppExecutors(),
            database.getCarDao()));
  }

  public static CarDetailsRepository provideCarDetailsRepository(@NonNull Context context) {
    checkNotNull(context);
    DaoSession database = MyDb.getDaoSession(context);
    return CarDetailsRepository.getInstance(
        CarLocalDetailsDataSource.getInstance(new AppExecutors(),
            database.getCarDetailsDao()));
  }

}
