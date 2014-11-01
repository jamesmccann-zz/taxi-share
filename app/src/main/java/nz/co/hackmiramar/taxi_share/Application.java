package nz.co.hackmiramar.taxi_share;

import android.content.Context;

import com.firebase.client.Firebase;

public class Application extends android.app.Application {

    private static Context mApplicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext = getApplicationContext();
        Firebase.setAndroidContext(this);
    }

    public static Context getAppContext() {
        return mApplicationContext;
    }

}
