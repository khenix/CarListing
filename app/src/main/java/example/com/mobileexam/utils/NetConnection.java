package example.com.mobileexam.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by kestrella on 2/11/18.
 */

public final class NetConnection {
  private NetConnection() {

  }

  public static boolean isConnected(Context context) {
    ConnectivityManager connMgr =
        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    if (connMgr != null) {
      NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
      return networkInfo != null && networkInfo.isConnected();

    }
    return false;
  }
}
