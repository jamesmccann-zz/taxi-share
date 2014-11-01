package nz.co.hackmiramar.taxi_share;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class CheckinActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin);

        String destination = getIntent().getStringExtra("destination");
        TextView tvDestination = (TextView) findViewById(R.id.destination);
        tvDestination.setText(destination);
    }

}
