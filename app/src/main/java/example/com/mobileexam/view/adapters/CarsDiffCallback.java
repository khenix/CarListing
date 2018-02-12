package example.com.mobileexam.view.adapters;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import java.util.List;

import example.com.mobileexam.model.dto.CatalogueResult;


/**
 * DiffCallback allow us to avoid data anomalies when updating recycler view data
 */
public class CarsDiffCallback extends DiffUtil.Callback {

  private final List<CatalogueResult> mOldCatalogueResultList;
  private final List<CatalogueResult> mNewCatalogueResultList;

  public CarsDiffCallback(List<CatalogueResult> oldCatalogueResultList, List<CatalogueResult> newCatalogueResultList) {
    this.mOldCatalogueResultList = oldCatalogueResultList;
    this.mNewCatalogueResultList = newCatalogueResultList;
  }

  @Override
  public int getOldListSize() {
    return mOldCatalogueResultList.size();
  }

  @Override
  public int getNewListSize() {
    return mNewCatalogueResultList.size();
  }

  @Override
  public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
    return mOldCatalogueResultList.get(oldItemPosition).getId().equals(mNewCatalogueResultList.get(
        newItemPosition).getId());
  }

  @Override
  public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
    final CatalogueResult oldCatalogueResult = mOldCatalogueResultList.get(oldItemPosition);
    final CatalogueResult newCatalogueResult = mNewCatalogueResultList.get(newItemPosition);

    return oldCatalogueResult.getId().equals(newCatalogueResult.getId());
  }

  @Nullable
  @Override
  public Object getChangePayload(int oldItemPosition, int newItemPosition) {
    // Implement method if you're going to use ItemAnimator
    return super.getChangePayload(oldItemPosition, newItemPosition);
  }
}
