package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        JSONObject sandwichObject = new JSONObject(json);
        Sandwich sandwich = new Sandwich();

        JSONArray alsoKnownAs = new JSONArray("alsoKnownAs");
        sandwich.setAlsoKnownAs((List<String>) alsoKnownAs);



        return null;
    }
}
