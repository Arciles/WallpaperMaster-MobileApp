package com.arcileslab.arciles.duvarkagidiustasi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import java.util.ArrayList;
import Adapters.GridViewAdapter;

/**
 * Created by esattahaibis on 26.12.2014.
 */
public class DisplayPage extends Activity {

    GridView view ;
    ArrayList<String> urls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_display);
        view = (GridView) findViewById(R.id.gridView);
        urls = new ArrayList<String>();
        urls.add("http://wallpaperscraft.com/image/83882/1080x1920.jpg");
        urls.add("https://www.idevice.ro/wp-content/uploads/2014/10/Nissan-GTR-Sport-Car-Rain-iPhone-6-Plus-HD-Wallpaper.jpg");
        urls.add("http://www.umnet.com/pic/diy/screensaver/fd8b491b-0e12.jpg");
        urls.add("http://www.wallpaperawesome.com/wallpapers-awesome/wallpapers-samsung-galaxy-note-3-awesome/wallpaper-note-3-full-hd-1080-1920-supercar-blue.jpg");
        urls.add("http://wallpaperscraft.com/image/94056/1080x1920.jpg");
        GridViewAdapter adapter = new GridViewAdapter(DisplayPage.this,urls);
        view.setAdapter(adapter);
        view.setOnItemClickListener(myOnClickListener());

    }


   protected AdapterView.OnItemClickListener myOnClickListener () {
       AdapterView.OnItemClickListener mylistener = new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent start = new Intent(DisplayPage.this,EnchangedDisplayPage.class);
               start.putExtra("URL",urls.get(position));
               startActivity(start);
           }
       };
       return  mylistener;
   }
}
