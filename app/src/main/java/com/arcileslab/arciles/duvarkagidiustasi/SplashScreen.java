package com.arcileslab.arciles.duvarkagidiustasi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by esattahaibis on 27.12.2014.
 */
public class SplashScreen extends Activity {
    Timer timer = new Timer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splah_screen);


        timer.schedule(new TimerTask() {
            public void run() {
                Intent intent = new Intent(SplashScreen.this, StartPage.class);
                startActivity(intent);

            }
        }, 4000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
