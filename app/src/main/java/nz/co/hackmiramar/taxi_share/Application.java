package nz.co.hackmiramar.taxi_share;

import android.content.Context;

public class Application extends android.app.Application {

    private static Context mApplicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return mApplicationContext;
    }

}
