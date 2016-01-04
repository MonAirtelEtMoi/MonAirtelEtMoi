package lab.synah.cd.monairteletmoi;

import android.app.Application;
import android.content.res.Configuration;

import com.firebase.client.Firebase;

import lab.synah.cd.monairteletmoi.utils.Utils;

/**
 * Created by Michelo on 28/12/15.
 */
public class MonAirtelEtMoiApplication extends Application {

    public static Firebase monAirtelCongoBackend;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    @Override
    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
        monAirtelCongoBackend=new Firebase(Utils.BACKEND_URL);

    }

    @Override
    public void onLowMemory(){
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
