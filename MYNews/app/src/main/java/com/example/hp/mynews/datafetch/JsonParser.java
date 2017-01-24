package com.example.hp.mynews.datafetch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ahmed akl on 1/24/2017.
 */

public class JsonParser {

    ArrayList<NewsData> data;

    public ArrayList<NewsData> JsonParsing(String jsonFile) {

        data = new ArrayList<>();

        try {

            JSONObject mainObject = new JSONObject(jsonFile);

            JSONArray jsonArray = mainObject.getJSONArray("articles");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject mainObjectArray = jsonArray.getJSONObject(i);

                NewsData encap = new NewsData(mainObjectArray.getString(JsonTags.urlKey),
                        mainObjectArray.getString(JsonTags.imgKey), mainObjectArray.getString(JsonTags.descKey), mainObjectArray.getString(JsonTags.titleKey));

                data.add(encap);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ArrayList<NewsData> getlist() {
        return data;
    }
}
