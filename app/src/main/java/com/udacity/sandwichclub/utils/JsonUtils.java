package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        JSONObject topObject = new JSONObject("name");
        JSONObject sandwichObject = topObject.getJSONObject(json);
        String mainName = sandwichObject.getString("mainName");
        JSONArray alsoKnownAs = new JSONArray("alsoKnownAs");
        String[] alsoKnownAsString = new String[alsoKnownAs.length()];
        for (int i = 0; i < alsoKnownAs.length(); i++){
            alsoKnownAsString[i] = alsoKnownAs.getJSONObject(i).getString("alsoKnownAs");
        }
        List<String> alsoKnownAsList = Arrays.asList(alsoKnownAsString);
        String placeOfOrigin = sandwichObject.getString("placeOfOrigin");
        String description = sandwichObject.getString("description");
        String imageURL = sandwichObject.getString("image");
        JSONArray ingredients = sandwichObject.getJSONArray("ingredients");
        String[] ingredientsString = new String[ingredients.length()];
        for (int i = 0; i < ingredients.length(); i++){
            ingredientsString[i] = ingredients.getJSONObject(i).getString("ingredients");
        }
        List<String> ingredientsList = Arrays.asList(ingredientsString);

        Sandwich sandwich = new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, imageURL, ingredientsList);

        return sandwich;
    }
}
