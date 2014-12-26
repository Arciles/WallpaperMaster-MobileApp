package com.arcileslab.arciles.duvarkagidiustasi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by esattahaibis on 26.12.2014.
 */
public class EnchangedDisplayPage extends Activity {

    ImageView displayview;
    String Url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enchanged_image_display);
        displayview = (ImageView) findViewById(R.id.ivDetayDisplay);

        Intent myIntent =getIntent();
        Url = myIntent.getStringExtra("URL");

        ImageLoader.getInstance().displayImage(Url,displayview);

    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
