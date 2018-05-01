package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import org.json.JSONException;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    private TextView mMainName;
    private TextView mAlsoKnownAs;
    private TextView mPlaceOfOrigin;
    private TextView mDescription;
    private TextView mIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mDescription = findViewById(R.id.description_tv);
        mMainName = findViewById(R.id.name_tv);
        mAlsoKnownAs = findViewById(R.id.also_known_tv);
        mPlaceOfOrigin = findViewById(R.id.origin_tv);
        mIngredients = findViewById(R.id.ingredients_tv);

        ImageView ingredientsIv = findViewById(R.id.image_iv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = null;
        //TODO: Investigate exception handling
        //Am I handling my error correctly where the method is called, or do I need to handle in both locations? I logged and it did work correctly, however unsure if it is redundant running a try > catch in JsonUtils.class
        try {
            sandwich = JsonUtils.parseSandwichJson(json);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.v("ERROR", e.getMessage());
        }
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI();
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);

        setTitle(sandwich.getMainName());

        mMainName.setText(sandwich.getMainName());
        mDescription.setText(sandwich.getDescription());
        //Determined how to remove braces with Stackoverflow: https://stackoverflow.com/questions/7536154/remove-brackets-from-a-list-set-to-a-textview?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
        String alsoKnownAsWithoutBrackets = sandwich.getAlsoKnownAs().toString().replace("[","").replace("]","");
        mAlsoKnownAs.setText(alsoKnownAsWithoutBrackets);
        mPlaceOfOrigin.setText(sandwich.getPlaceOfOrigin());
        String ingredientsWithoutBrackets = sandwich.getIngredients().toString().replace("[","").replace("]","");
        mIngredients.setText(ingredientsWithoutBrackets);


    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI() {

    }
}
