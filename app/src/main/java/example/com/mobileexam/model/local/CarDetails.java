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
@Entity(nameInDb = "carDetails")
public class CarDetails {
  @Id
  private String id;

  @Property
  private String name;

  @Property
  private String price;

  @Property
  private String brand;

  @Property
  private String brand_model;

  @Property
  private String activated_at;

  @Property
  private String condition;

  @Property
  private String mileage;

  @Property
  private String transmission;

  @Property
  private String fuel;

  @Property
  private String location_latitude;

  @Property
  private String location_longitude;

  @Property
  private String google_formatted_address;

  @Property
  private String google_place_id;

  @Property
  private String fk_customer_address;

  @Property
  private String listing_region;

  @Property
  private String listing_city;

  @Property
  private String agency_address;

  @Property
  private String agency_city;

  @Property
  private String fk_country_region;

  @Property
  private String fk_country_region_city;

  @Property
  private String fk_country_region_city_area;

  @Property
  private String show_listing_address;

  @Property
  private String item_contact_name;

  @Property
  private String item_contact_email;

  @Property
  private String item_contact_mobile;

  @Property
  private String item_contact_homephone;

  @Property
  private String description;

  @ToOne(joinProperty = "id")
  private Car car;

  /**
   * Used to resolve relations
   */
  @Generated(hash = 2040040024)
  private transient DaoSession daoSession;

  /**
   * Used for active entity operations.
   */
  @Generated(hash = 62405507)
  private transient CarDetailsDao myDao;

  @Generated(hash = 437912323)
  public CarDetails(String id, String name, String price, String brand,
                    String brand_model, String activated_at, String condition,
                    String mileage, String transmission, String fuel,
                    String location_latitude, String location_longitude,
                    String google_formatted_address, String google_place_id,
                    String fk_customer_address, String listing_region, String listing_city,
                    String agency_address, String agency_city, String fk_country_region,
                    String fk_country_region_city, String fk_country_region_city_area,
                    String show_listing_address, String item_contact_name,
                    String item_contact_email, String item_contact_mobile,
                    String item_contact_homephone, String description) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.brand = brand;
    this.brand_model = brand_model;
    this.activated_at = activated_at;
    this.condition = condition;
    this.mileage = mileage;
    this.transmission = transmission;
    this.fuel = fuel;
    this.location_latitude = location_latitude;
    this.location_longitude = location_longitude;
    this.google_formatted_address = google_formatted_address;
    this.google_place_id = google_place_id;
    this.fk_customer_address = fk_customer_address;
    this.listing_region = listing_region;
    this.listing_city = listing_city;
    this.agency_address = agency_address;
    this.agency_city = agency_city;
    this.fk_country_region = fk_country_region;
    this.fk_country_region_city = fk_country_region_city;
    this.fk_country_region_city_area = fk_country_region_city_area;
    this.show_listing_address = show_listing_address;
    this.item_contact_name = item_contact_name;
    this.item_contact_email = item_contact_email;
    this.item_contact_mobile = item_contact_mobile;
    this.item_contact_homephone = item_contact_homephone;
    this.description = description;
  }

  @Generated(hash = 1517749497)
  public CarDetails() {
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPrice() {
    return this.price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getBrand() {
    return this.brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getBrand_model() {
    return this.brand_model;
  }

  public void setBrand_model(String brand_model) {
    this.brand_model = brand_model;
  }

  public String getActivated_at() {
    return this.activated_at;
  }

  public void setActivated_at(String activated_at) {
    this.activated_at = activated_at;
  }

  public String getCondition() {
    return this.condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  public String getMileage() {
    return this.mileage;
  }

  public void setMileage(String mileage) {
    this.mileage = mileage;
  }

  public String getTransmission() {
    return this.transmission;
  }

  public void setTransmission(String transmission) {
    this.transmission = transmission;
  }

  public String getFuel() {
    return this.fuel;
  }

  public void setFuel(String fuel) {
    this.fuel = fuel;
  }

  public String getLocation_latitude() {
    return this.location_latitude;
  }

  public void setLocation_latitude(String location_latitude) {
    this.location_latitude = location_latitude;
  }

  public String getLocation_longitude() {
    return this.location_longitude;
  }

  public void setLocation_longitude(String location_longitude) {
    this.location_longitude = location_longitude;
  }

  public String getGoogle_formatted_address() {
    return this.google_formatted_address;
  }

  public void setGoogle_formatted_address(String google_formatted_address) {
    this.google_formatted_address = google_formatted_address;
  }

  public String getGoogle_place_id() {
    return this.google_place_id;
  }

  public void setGoogle_place_id(String google_place_id) {
    this.google_place_id = google_place_id;
  }

  public String getFk_customer_address() {
    return this.fk_customer_address;
  }

  public void setFk_customer_address(String fk_customer_address) {
    this.fk_customer_address = fk_customer_address;
  }

  public String getListing_region() {
    return this.listing_region;
  }

  public void setListing_region(String listing_region) {
    this.listing_region = listing_region;
  }

  public String getListing_city() {
    return this.listing_city;
  }

  public void setListing_city(String listing_city) {
    this.listing_city = listing_city;
  }

  public String getAgency_address() {
    return this.agency_address;
  }

  public void setAgency_address(String agency_address) {
    this.agency_address = agency_address;
  }

  public String getAgency_city() {
    return this.agency_city;
  }

  public void setAgency_city(String agency_city) {
    this.agency_city = agency_city;
  }

  public String getFk_country_region() {
    return this.fk_country_region;
  }

  public void setFk_country_region(String fk_country_region) {
    this.fk_country_region = fk_country_region;
  }

  public String getFk_country_region_city() {
    return this.fk_country_region_city;
  }

  public void setFk_country_region_city(String fk_country_region_city) {
    this.fk_country_region_city = fk_country_region_city;
  }

  public String getFk_country_region_city_area() {
    return this.fk_country_region_city_area;
  }

  public void setFk_country_region_city_area(String fk_country_region_city_area) {
    this.fk_country_region_city_area = fk_country_region_city_area;
  }

  public String getShow_listing_address() {
    return this.show_listing_address;
  }

  public void setShow_listing_address(String show_listing_address) {
    this.show_listing_address = show_listing_address;
  }

  public String getItem_contact_name() {
    return this.item_contact_name;
  }

  public void setItem_contact_name(String item_contact_name) {
    this.item_contact_name = item_contact_name;
  }

  public String getItem_contact_email() {
    return this.item_contact_email;
  }

  public void setItem_contact_email(String item_contact_email) {
    this.item_contact_email = item_contact_email;
  }

  public String getItem_contact_mobile() {
    return this.item_contact_mobile;
  }

  public void setItem_contact_mobile(String item_contact_mobile) {
    this.item_contact_mobile = item_contact_mobile;
  }

  public String getItem_contact_homephone() {
    return this.item_contact_homephone;
  }

  public void setItem_contact_homephone(String item_contact_homephone) {
    this.item_contact_homephone = item_contact_homephone;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Generated(hash = 1603749849)
  private transient String car__resolvedKey;

  /**
   * To-one relationship, resolved on first access.
   */
  @Generated(hash = 417713704)
  public Car getCar() {
    String __key = this.id;
    if (car__resolvedKey == null || car__resolvedKey != __key) {
      final DaoSession daoSession = this.daoSession;
      if (daoSession == null) {
        throw new DaoException("Entity is detached from DAO context");
      }
      CarDao targetDao = daoSession.getCarDao();
      Car carNew = targetDao.load(__key);
      synchronized (this) {
        car = carNew;
        car__resolvedKey = __key;
      }
    }
    return car;
  }

  /**
   * called by internal mechanisms, do not call yourself.
   */
  @Generated(hash = 1489653394)
  public void setCar(Car car) {
    synchronized (this) {
      this.car = car;
      id = car == null ? null : car.getId();
      car__resolvedKey = id;
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

  /** called by internal mechanisms, do not call yourself. */
  @Generated(hash = 1550864587)
  public void __setDaoSession(DaoSession daoSession) {
      this.daoSession = daoSession;
      myDao = daoSession != null ? daoSession.getCarDetailsDao() : null;
  }
}

