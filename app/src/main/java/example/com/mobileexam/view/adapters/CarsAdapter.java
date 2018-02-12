package example.com.mobileexam.view.adapters;

import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.mobileexam.R;
import example.com.mobileexam.helper.VolleyRequestHelper;
import example.com.mobileexam.model.dto.CatalogueResult;

/**
 * Created by kestrella on 2/9/18.
 */
public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.ViewHolder> {

  private Context context;
  private List<CatalogueResult> catalogueList;
  private CarItemListener carItemListener;

  public CarsAdapter(Context context, List<CatalogueResult> catalogueList, CarItemListener listener) {
    this.catalogueList = catalogueList;
    this.context = context;
    this.carItemListener = listener;
  }


  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View notificationListView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cars, parent, false);
    return new ViewHolder(notificationListView);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final CatalogueResult catalogueResult = catalogueList.get(position);
    ImageLoader imageLoader = new VolleyRequestHelper(context).getImageLoader();
    holder.nivCar.setImageUrl(catalogueResult.getImages().get(0).getUrl(), imageLoader);
    holder.tvCarName.setText(catalogueResult.getData().getName());
    holder.tvPrice.setText(catalogueResult.getData().getPrice());
    holder.tvBrand.setText(String.format(context.getString(R.string.brand), catalogueResult.getData().getBrand()));
    holder.tvBrandModel.setText(String.format(context.getString(R.string.brand_model), catalogueResult.getData().getBrand_model()));

    holder.cvItem.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        carItemListener.onCarClick(catalogueResult);
      }
    });
  }

  @Override
  public int getItemCount() {
    return catalogueList.size();
  }


  /**
   * DiffUtil helps us data anomalies and redundancies on our adapter
   * specially on recyclerview's case
   **/
  public void swap(List<CatalogueResult> catalogueList) {
    final CarsDiffCallback diffCallback = new CarsDiffCallback(this.catalogueList, catalogueList);
    final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

    this.catalogueList.clear();
    this.catalogueList.addAll(catalogueList);
    diffResult.dispatchUpdatesTo(this);
  }


  /**
   * View Holder class to hold the recycler view item widgets.
   */
  protected static class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.cv_car_item)
    View cvItem;
    @BindView(R.id.iv_car)
    NetworkImageView nivCar;
    @BindView(R.id.tv_car_name)
    TextView tvCarName;
    @BindView(R.id.tv_car_price)
    TextView tvPrice;
    @BindView(R.id.tv_brand)
    TextView tvBrand;
    @BindView(R.id.tv_brand_model)
    TextView tvBrandModel;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }


  public interface CarItemListener {

    void onCarClick(CatalogueResult clickedCar);

  }
}