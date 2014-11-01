package nz.co.hackmiramar.taxi_share;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences(Constants.APP_PREFERENCES, MODE_PRIVATE);
        if (prefs.contains(Constants.PREFS_PROFILE_NAME)) {
            startActivity(new Intent(this, PlaceActivity.class));
        } else {
            startActivity(new Intent(this, ProfileActivity.class));
        }
        finish();
    }


}
