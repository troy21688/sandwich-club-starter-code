package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        JSONObject sandwichObject = new JSONObject(json);
        JSONArray alsoKnownAs = new JSONArray("alsoKnownAs");
        String[] alsoKnownAsString = alsoKnownAhdtdtydtdyd
        String mainName = sandwichObject.getString("mainName");
        String placeOfOrigin = sandwichObject.getString("placeOfOrigin");
        String description = sandwichObject.getString("description");
        String imageURL = sandwichObject.getString("image");
        JSONArray ingredients = sandwichObject.getJSONArray("ingredients");

//        Sandwich sandwich = new Sandwich();
//        sandwich.setAlsoKnownAs((List<String>) alsoKnownAs);

        Sandwich sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, imageURL, ingredients);




        return null;
    }
}
