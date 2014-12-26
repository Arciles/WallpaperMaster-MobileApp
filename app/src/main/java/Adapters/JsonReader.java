package Adapters;


import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by esattahaibis on 26.12.2014.
 */
public class JsonReader {
Context c;
    public JsonReader(Context con){
        c = con;
    }



    public ArrayList<HashMap<String, String>> JsonParser (String jsonFile) throws JSONException {

        JSONObject obj = new JSONObject(loadJSONFromAsset(jsonFile));

        JSONArray m_jArry = obj.getJSONArray("URLs");

        ArrayList<HashMap<String, String>> formList= new ArrayList<HashMap<String, String>>();

        HashMap<String, String> m_li;

        for (int i = 0; i < m_jArry.length(); i++)
        {
            JSONObject jo_inside = m_jArry.getJSONObject(i);
            String name = jo_inside.getString("name");
            String url = jo_inside.getString("url");

            //Add your values in your `ArrayList` as below:

            m_li=new HashMap<String, String>();
            m_li.put("name", name );
            m_li.put("url", url );

            formList.add(m_li);
            //Same way for other value...
        }
        return formList;
    }

    public String loadJSONFromAsset(String jsonFile) {
        String json = null;

        try {

            InputStream is = c.getAssets().open(jsonFile+".txt");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

}
