package example.com.mobileexam;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by kestrella on 2/9/18.
 */

public class App extends Application {
  private static final String TAG = App.class.getSimpleName();
  private static App appInstance = new App();
  private RequestQueue requestQueue;


  public static App getInstance() {
    return appInstance;
  }


  @Override
  public void onCreate() {
    super.onCreate();
    appInstance = this;

  }

  public RequestQueue getRequestQueue() {
    if (requestQueue == null) {
      requestQueue = Volley.newRequestQueue(getApplicationContext());
    }
    return requestQueue;
  }

}
