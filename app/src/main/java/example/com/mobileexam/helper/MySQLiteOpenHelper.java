package example.com.mobileexam.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.github.yuweiguocn.library.greendao.MigrationHelper;

import org.greenrobot.greendao.database.Database;

import example.com.mobileexam.model.local.CarDao;
import example.com.mobileexam.model.local.CarDetailsDao;
import example.com.mobileexam.model.local.DaoMaster;

/**
 * Created by kestrella on 11/16/17.
 * Helper class that will cater important events on our database
 */

public class MySQLiteOpenHelper extends DaoMaster.OpenHelper {
  public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
    super(context, name, factory);
  }

  @SuppressWarnings("unchecked")
  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {
      @Override
      public void onCreateAllTables(Database db, boolean ifNotExists) {
        DaoMaster.createAllTables(db, ifNotExists);
      }

      @Override
      public void onDropAllTables(Database db, boolean ifExists) {
        DaoMaster.dropAllTables(db, ifExists);
      }
    }, CarDao.class, CarDetailsDao.class);
  }

}
