package nz.co.hackmiramar.taxi_share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, ProfileActivity.class));
    }


}
