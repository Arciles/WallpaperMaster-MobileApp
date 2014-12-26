package com.arcileslab.arciles.duvarkagidiustasi;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.io.IOException;

import Adapters.ImageWriteRead;

/**
 * Created by esattahaibis on 26.12.2014.
 */
public class EnchangedDisplayPage extends Activity {

    ImageView displayview;
    String Url;
    String name;
    Button buttonSetWallpaper;
    String Path = "/data/data/duvarkagidiustasi/app_data/imageDir/";
    Bitmap image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enchanged_image_display);
        displayview = (ImageView) findViewById(R.id.ivDetayDisplay);
        buttonSetWallpaper = (Button) findViewById(R.id.btnSetWallpaper);
/*
* Bir önceki Activity ile gonderilen intent icindeki verileri cekiyoruz
* */

        Intent myIntent =getIntent();
        Url = myIntent.getStringExtra("URL");
        name = myIntent.getStringExtra("NAME");


        ImageLoader.getInstance().displayImage(Url,displayview, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                // Do whatever you want with Bitmap
                image = loadedImage;
            }
        });

        /*
        * Gelen verilerle once veriyi internetten indirerek bitmap haline getirdik sonrasinda ise internal storage a geri yazdik
        * */

        buttonSetWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WallpaperManager myWallpaperManager
                        = WallpaperManager.getInstance(getApplicationContext());
                try {
                    myWallpaperManager.setBitmap(image);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });



    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
