package example.com.mobileexam.model.local;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by kestrella on 2/11/18.
 */
@Entity(nameInDb = "car")
public class Car {

  @Id
  private String id;

  @Property
  private String images;

  @ToOne(joinProperty = "id")
  private CarDetails carDetails;

  /**
   * Used to resolve relations
   */
  @Generated(hash = 2040040024)
  private transient DaoSession daoSession;

  /**
   * Used for active entity operations.
   */
  @Generated(hash = 709963916)
  private transient CarDao myDao;

  @Generated(hash = 25171509)
  public Car(String id, String images) {
      this.id = id;
      this.images = images;
  }

  @Generated(hash = 625572433)
  public Car() {
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Generated(hash = 124766774)
  private transient String carDetails__resolvedKey;

  /**
   * To-one relationship, resolved on first access.
   */
  @Generated(hash = 1545595845)
  public CarDetails getCarDetails() {
    String __key = this.id;
    if (carDetails__resolvedKey == null || carDetails__resolvedKey != __key) {
      final DaoSession daoSession = this.daoSession;
      if (daoSession == null) {
        throw new DaoException("Entity is detached from DAO context");
      }
      CarDetailsDao targetDao = daoSession.getCarDetailsDao();
      CarDetails carDetailsNew = targetDao.load(__key);
      synchronized (this) {
        carDetails = carDetailsNew;
        carDetails__resolvedKey = __key;
      }
    }
    return carDetails;
  }

  /**
   * called by internal mechanisms, do not call yourself.
   */
  @Generated(hash = 1511367991)
  public void setCarDetails(CarDetails carDetails) {
    synchronized (this) {
      this.carDetails = carDetails;
      id = carDetails == null ? null : carDetails.getId();
      carDetails__resolvedKey = id;
    }
  }

  /**
   * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
   * Entity must attached to an entity context.
   */
  @Generated(hash = 128553479)
  public void delete() {
    if (myDao == null) {
      throw new DaoException("Entity is detached from DAO context");
    }
    myDao.delete(this);
  }

  /**
   * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
   * Entity must attached to an entity context.
   */
  @Generated(hash = 1942392019)
  public void refresh() {
    if (myDao == null) {
      throw new DaoException("Entity is detached from DAO context");
    }
    myDao.refresh(this);
  }

  /**
   * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
   * Entity must attached to an entity context.
   */
  @Generated(hash = 713229351)
  public void update() {
    if (myDao == null) {
      throw new DaoException("Entity is detached from DAO context");
    }
    myDao.update(this);
  }

  public String getImages() {
      return this.images;
  }

  public void setImages(String images) {
      this.images = images;
  }

  /** called by internal mechanisms, do not call yourself. */
  @Generated(hash = 679603784)
  public void __setDaoSession(DaoSession daoSession) {
      this.daoSession = daoSession;
      myDao = daoSession != null ? daoSession.getCarDao() : null;
  }

}
