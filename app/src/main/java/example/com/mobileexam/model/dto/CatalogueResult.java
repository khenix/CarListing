package example.com.mobileexam.model.dto;

import java.util.List;

/**
 * Created by kestrella on 2/9/18.
 */

public class CatalogueResult {
  private CatalogueData data;
  private String id;
  private List<CatalogueImage> images;


  public CatalogueData getData() {
    return data;
  }

  public void setData(CatalogueData data) {
    this.data = data;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<CatalogueImage> getImages() {
    return images;
  }

  public void setImages(List<CatalogueImage> images) {
    this.images = images;
  }

}
