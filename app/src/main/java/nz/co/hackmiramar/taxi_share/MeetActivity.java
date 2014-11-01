package nz.co.hackmiramar.taxi_share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MeetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meet);
    }

    public void onMetPressed(View view) {
        startActivity(new Intent(this, RateActivity.class));
    }
}
