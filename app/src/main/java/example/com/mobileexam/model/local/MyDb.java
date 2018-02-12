package example.com.mobileexam.model.local;

import android.content.Context;

import com.github.yuweiguocn.library.greendao.MigrationHelper;

import example.com.mobileexam.helper.MySQLiteOpenHelper;


/**
 * Created by kestrella on 2/11/18.
 */

public abstract class MyDb {

  private static final Object sLock = new Object();
  private static DaoSession daoSession;


  public static DaoSession getDaoSession(Context context) {
    synchronized (sLock) {
      if (daoSession == null) {
        MySQLiteOpenHelper helper = new MySQLiteOpenHelper(context, "carmudiDB", null);
        MigrationHelper.DEBUG = true;
        DaoMaster daoMaster = new DaoMaster(helper.getWritableDatabase());
        daoSession = daoMaster.newSession();
      }
      return daoSession;

    }
  }

}
