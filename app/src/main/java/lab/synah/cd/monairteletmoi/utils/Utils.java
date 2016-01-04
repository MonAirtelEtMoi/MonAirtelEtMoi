package lab.synah.cd.monairteletmoi.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import lab.synah.cd.monairteletmoi.BuildConfig;

/**
 * Created by Michelo on 28/12/15.
 */
public class Utils {

    public static final String BACKEND_URL = "https://MonAirtelEtMoi.firebaseio.com";
    public static final String BACKEND_IMAGES_PATH="http://devfest.gdg-lome.org";
    public final static String FIREBASE_URL= BuildConfig.UNIQUE_FIREBASE_ROOT_URL;
    public static final String BACKEND_VENUE_PATH="venue";

    public static Boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null)
            return true;
        return false;
    }

}
