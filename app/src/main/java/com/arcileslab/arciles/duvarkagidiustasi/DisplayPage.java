package com.arcileslab.arciles.duvarkagidiustasi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import Adapters.GridViewAdapter;
import Adapters.JsonReader;

/**
 * Created by esattahaibis on 26.12.2014.
 */

public class DisplayPage extends Activity {

    GridView view ;
    ArrayList<HashMap<String, String>>list = new ArrayList<HashMap<String, String>>();
    ArrayList<String> names;
    ArrayList<String> urls;
    JsonReader reader;
    String dosyaIsmi;
    Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_display);
        view = (GridView) findViewById(R.id.gridView);
        urls = new ArrayList<String>();
        names = new ArrayList<String>();
        reader = new JsonReader(DisplayPage.this);

        /*
        * Assets klasorunde bulunan json formatindaki txt dosyalarini okumak icin jsonreader classini kullaniyoruz
        * */
        myIntent = getIntent();

        dosyaIsmi = myIntent.getStringExtra("name");

        try {
            list = reader.JsonParser(dosyaIsmi);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        Iterator myVeryOwnIterator;

        for(int i = 0 ; i < list.size() ; i++)
        {

            myVeryOwnIterator = list.get(i).keySet().iterator();
            int count = 0;
            while(myVeryOwnIterator.hasNext()) {
/*
*    Listten aldimiz verileri ArrayListin icine basıyoruz iterasyonlardan ilki url yi verirken ikinci iterasyon ise resmin adini getirmekte
*/
                int SDK_INT = android.os.Build.VERSION.SDK_INT;
                if (SDK_INT > 19 ) {
                    String key=(String)myVeryOwnIterator.next();
                    String value =list.get(i).get(key).toString();
                    if (count == 0 )
                        names.add(value);
                    else
                        urls.add(value);
                    count++;
                } else {
                    String key=(String)myVeryOwnIterator.next();
                    String value =list.get(i).get(key).toString();
                    if (count == 0 )
                        urls.add(value);
                    else
                        names.add(value);
                    count++;
                }

            }
        }
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
               start.putExtra("NAME",names.get(position));
               startActivity(start);
           }
       };
       return  mylistener;
   }
}
