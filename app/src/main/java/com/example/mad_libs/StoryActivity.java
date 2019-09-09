package com.example.mad_libs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StoryActivity extends AppCompatActivity {
    private Intent x;
    private String nounOne, adjectiveOne, adjectiveTwo, verbOne, verbTwo, verbThree, verbFour, placeOne, placeTwo, placeThree, roomOne, timeOne, drinkOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        x = getIntent();
        nounOne = x.getStringExtra("nounOne").toUpperCase();
        adjectiveOne = x.getStringExtra("adjectiveOne").toUpperCase();
        adjectiveTwo = x.getStringExtra("adjectiveTwo").toUpperCase();
        verbOne = x.getStringExtra("verbOne").toUpperCase();
        verbTwo = x.getStringExtra("verbTwo").toUpperCase();
        verbThree = x.getStringExtra("verbThree").toUpperCase();
        verbFour = x.getStringExtra("verbFour").toUpperCase();
        placeOne = x.getStringExtra("placeOne").toUpperCase();
        placeTwo = x.getStringExtra("placeTwo").toUpperCase();
        placeThree = x.getStringExtra("placeThree").toUpperCase();
        roomOne = x.getStringExtra("roomOne").toUpperCase();
        timeOne = x.getStringExtra("timeOne").toUpperCase();
        drinkOne = x.getStringExtra("drinkOne").toUpperCase();
        TextView story = (TextView) findViewById(R.id.storyTextView);
        final String storyText = "T' was a " + adjectiveOne + ", boring October Day. Everything was boring. Even the " + nounOne + " was dull. I arrived at " + timeOne +
                " and went to " + placeOne + " to see if I could help Mrs. Denna with " + verbOne +". Mrs. Denna was " + adjectiveTwo + " that I was there. She had " +
                "me help her with " + verbTwo + ", " + verbThree + ", and " + verbFour + ". After that, I went to the " + placeThree +" to see if they had any " + drinkOne
                + " left. They didn't have any " + drinkOne + " left, so I went back to " + placeTwo + ". I entered my " + roomOne +" and went to bed. Maybe it was a boring day," +
                " but it was somewhat eventful.";
        story.setText(storyText);
        Button share = (Button) findViewById(R.id.shareButton);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, storyText);
                String intentTitle = getString(R.string.intent_title);
                Intent activity = Intent.createChooser(intent, intentTitle);
                startActivity(activity);
            }
        });

    }
}

