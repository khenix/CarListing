package example.com.mobileexam.helper;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import example.com.mobileexam.App;
import example.com.mobileexam.utils.LruBitmapCache;


/**
 * Created by kestrella on 2/9/18.
 */

public class VolleyRequestHelper {
  private static final String TAG = VolleyRequestHelper.class.getSimpleName();
  private Context context;

  private OnRequestCompletedListener mRequestCompletedListener;


  public VolleyRequestHelper(Context context) {
    this.context = context;
  }


  /**
   * Used to call web service and get response as JSON.
   *
   * @param context  - context of the activity.
   * @param callback - The callback reference.
   */
  public VolleyRequestHelper(Context context, OnRequestCompletedListener callback) {
    mRequestCompletedListener = callback;
    this.context = context;
  }


  /**
   * To get the ImageLoader class instance to load the network image in Image
   * view.
   *
   * @return ImageLoader instance.
   */
  public ImageLoader getImageLoader() {
    return new ImageLoader(App.getInstance().getRequestQueue(),
        new LruBitmapCache());
  }

  /**
   * A callback interface indicates the status about the completion of HTTP
   * request.
   */
  public interface OnRequestCompletedListener {
    /**
     * Called when the String request has been completed.
     *
     * @param requestName  the String refers the request name
     * @param status       the status of the request either success or failure
     * @param response     the String response returns from the Webservice. It may be
     *                     null if request failed.
     * @param errorMessage the String refers the error message when request failed to
     *                     get the response
     */
    void onRequestCompleted(String requestName, boolean status,
                            String response, String errorMessage);

  }


  // GET requests provider
  public void makeStringGETRequest(final String url, final String requestName) {
    RequestQueue rq = App.getInstance().getRequestQueue();


    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String response) {
            mRequestCompletedListener.onRequestCompleted(
                requestName, true, response, null);

          }
        },

        new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            String errorResponse = "";
            try {
              VolleyError responseError = new VolleyError(
                  new String(error.networkResponse.data));
              try {
                final JSONObject responseJson = new JSONObject(responseError.getMessage());
                errorResponse = new Gson().toJson(responseJson); // todo: format into meaningful error message
              } catch (Exception e) {
                errorResponse = "Unknown";
              }
            } catch (Exception e) {
              Log.e(TAG, e.toString());
            }
            mRequestCompletedListener.onRequestCompleted(
                requestName, false, null,
                errorResponse);
          }
        });

    rq.add(stringRequest);

  }

}


