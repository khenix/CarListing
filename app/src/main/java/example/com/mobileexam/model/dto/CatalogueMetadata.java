package example.com.mobileexam.model.dto;

import java.util.List;

/**
 * Created by kestrella on 2/9/18.
 */

public class CatalogueMetadata {
  private String product_count;
  private List<CatalogueResult> results;


  public String getProduct_count() {
    return product_count;
  }

  public void setProduct_count(String product_count) {
    this.product_count = product_count;
  }

  public List<CatalogueResult> getResults() {
    return results;
  }

  public void setResults(List<CatalogueResult> results) {
    this.results = results;
  }

}
