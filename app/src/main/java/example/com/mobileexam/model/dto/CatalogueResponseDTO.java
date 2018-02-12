package example.com.mobileexam.model.dto;

/**
 * Created by kestrella on 2/9/18.
 */

public class CatalogueResponseDTO {
  private CatalogueMetadata metadata;

  public CatalogueMetadata getMetadata() {
    return metadata;
  }

  public void setMetadata(CatalogueMetadata metadata) {
    this.metadata = metadata;
  }
}
