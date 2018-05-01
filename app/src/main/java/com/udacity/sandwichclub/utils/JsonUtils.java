package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        //How to handle if value is empty or null?
        //What is image is not loading? For instance, I went to the URL for "Shawarma" and the image loaded. However, within my app the image is not loading. I am unsure why and how to handle.

        JSONObject topObject = new JSONObject(json);
        JSONObject sandwichObject = topObject.getJSONObject("name");
        String mainName = sandwichObject.getString("mainName");
        String alsoKnownAs = sandwichObject.getString("alsoKnownAs");
        List<String> alsoKnownAsList = Arrays.asList(alsoKnownAs.split(","));
        String placeOfOrigin = topObject.getString("placeOfOrigin");
        String description = topObject.getString("description");
        String imageURL = topObject.getString("image");
        String ingredients = topObject.getString("ingredients");
        List<String> ingredientList = Arrays.asList(ingredients.split(","));

        Sandwich sandwich = new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, imageURL, ingredientList);

        return sandwich;
    }
}
