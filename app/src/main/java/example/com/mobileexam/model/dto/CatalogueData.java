package example.com.mobileexam.model.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kestrella on 2/9/18.
 */

public class CatalogueData {
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getBrand_model() {
    return brand_model;
  }

  public void setBrand_model(String brand_model) {
    this.brand_model = brand_model;
  }

  public String getActivated_at() {
    return activated_at;
  }

  public void setActivated_at(String activated_at) {
    this.activated_at = activated_at;
  }

  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  public String getMileage() {
    return mileage;
  }

  public void setMileage(String mileage) {
    this.mileage = mileage;
  }

  public String getTransmission() {
    return transmission;
  }

  public void setTransmission(String transmission) {
    this.transmission = transmission;
  }

  public String getFuel() {
    return fuel;
  }

  public void setFuel(String fuel) {
    this.fuel = fuel;
  }

  public String getLocation_latitude() {
    return location_latitude;
  }

  public void setLocation_latitude(String location_latitude) {
    this.location_latitude = location_latitude;
  }

  public String getLocation_longitude() {
    return location_longitude;
  }

  public void setLocation_longitude(String location_longitude) {
    this.location_longitude = location_longitude;
  }

  public String getGoogle_formatted_address() {
    return google_formatted_address;
  }

  public void setGoogle_formatted_address(String google_formatted_address) {
    this.google_formatted_address = google_formatted_address;
  }

  public String getGoogle_place_id() {
    return google_place_id;
  }

  public void setGoogle_place_id(String google_place_id) {
    this.google_place_id = google_place_id;
  }

  public String getFk_customer_address() {
    return fk_customer_address;
  }

  public void setFk_customer_address(String fk_customer_address) {
    this.fk_customer_address = fk_customer_address;
  }

  public String getListing_region() {
    return listing_region;
  }

  public void setListing_region(String listing_region) {
    this.listing_region = listing_region;
  }

  public String getListing_city() {
    return listing_city;
  }

  public void setListing_city(String listing_city) {
    this.listing_city = listing_city;
  }

  public String getAgency_address() {
    return agency_address;
  }

  public void setAgency_address(String agency_address) {
    this.agency_address = agency_address;
  }

  public String getAgency_city() {
    return agency_city;
  }

  public void setAgency_city(String agency_city) {
    this.agency_city = agency_city;
  }

  public String getFk_country_region() {
    return fk_country_region;
  }

  public void setFk_country_region(String fk_country_region) {
    this.fk_country_region = fk_country_region;
  }

  public String getFk_country_region_city() {
    return fk_country_region_city;
  }

  public void setFk_country_region_city(String fk_country_region_city) {
    this.fk_country_region_city = fk_country_region_city;
  }

  public String getFk_country_region_city_area() {
    return fk_country_region_city_area;
  }

  public void setFk_country_region_city_area(String fk_country_region_city_area) {
    this.fk_country_region_city_area = fk_country_region_city_area;
  }

  public String getShow_listing_address() {
    return show_listing_address;
  }

  public void setShow_listing_address(String show_listing_address) {
    this.show_listing_address = show_listing_address;
  }

  public String getItem_contact_name() {
    return item_contact_name;
  }

  public void setItem_contact_name(String item_contact_name) {
    this.item_contact_name = item_contact_name;
  }

  public String getItem_contact_email() {
    return item_contact_email;
  }

  public void setItem_contact_email(String item_contact_email) {
    this.item_contact_email = item_contact_email;
  }

  public String getItem_contact_mobile() {
    return item_contact_mobile;
  }

  public void setItem_contact_mobile(String item_contact_mobile) {
    this.item_contact_mobile = item_contact_mobile;
  }

  public String getItem_contact_homephone() {
    return item_contact_homephone;
  }

  public void setItem_contact_homephone(String item_contact_homephone) {
    this.item_contact_homephone = item_contact_homephone;
  }

  public boolean isNew_product() {
    return new_product;
  }

  public void setNew_product(boolean new_product) {
    this.new_product = new_product;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  private String id;
  private String name;
  private String price;
  private String brand;
  private String brand_model;
  private String activated_at;
  private String condition;
  private String mileage;
  private String transmission;
  private String fuel;
  private String location_latitude;
  private String location_longitude;
  private String google_formatted_address;
  private String google_place_id;
  private String fk_customer_address;
  private String listing_region;
  private String listing_city;
  private String agency_address;
  private String agency_city;
  private String fk_country_region;
  private String fk_country_region_city;
  private String fk_country_region_city_area;
  private String show_listing_address;
  private String item_contact_name;
  private String item_contact_email;
  private String item_contact_mobile;
  private String item_contact_homephone;
  private String description;


  @SerializedName("new-product")
  private boolean new_product;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
