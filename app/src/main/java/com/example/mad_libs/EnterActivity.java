package com.example.mad_libs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterActivity extends AppCompatActivity {
    private Button noun,adjective,verb,place,time,continueButton;
    private String nounOne, adjectiveOne, adjectiveTwo, verbOne, verbTwo, verbThree, verbFour, placeOne, placeTwo, placeThree, roomOne, timeOne, drinkOne;
    private Intent x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        noun =(Button) findViewById(R.id.nounButton);
        adjective = (Button) findViewById(R.id.adjectiveButton);
        verb = (Button) findViewById(R.id.verbButton);
        place = (Button) findViewById(R.id.placeButton);
        time = (Button) findViewById(R.id.timeButton);
        continueButton = (Button) findViewById(R.id.continueButton);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nounOne != null && adjectiveOne != null && adjectiveTwo !=  null && verbOne != null && verbTwo != null && verbThree != null && verbFour != null &&
                        placeOne != null && placeTwo != null && placeThree != null && roomOne != null && timeOne != null && drinkOne != null){
                    x = new Intent(EnterActivity.this, StoryActivity.class);
                    x.putExtra("nounOne", nounOne);
                    x.putExtra("adjectiveOne", adjectiveOne);
                    x.putExtra("adjectiveTwo", adjectiveTwo);
                    x.putExtra("verbOne", verbOne);
                    x.putExtra("verbTwo", verbTwo);
                    x.putExtra("verbThree", verbThree);
                    x.putExtra("verbFour", verbFour);
                    x.putExtra("placeOne", placeOne);
                    x.putExtra("placeTwo", placeTwo);
                    x.putExtra("placeThree", placeThree);
                    x.putExtra("roomOne", roomOne);
                    x.putExtra("timeOne", timeOne);
                    x.putExtra("drinkOne", drinkOne);
                    startActivity(x);
                }else{
                    Toast.makeText(EnterActivity.this, "Please fill out all the choices!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        noun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNounDialogBox();
            }
        });
        adjective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAdjectiveDialogBox();
            }
        });
        verb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addVerbDialogBox();
            }
        });
        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPlaceDialongBox();
            }
        });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTimeDialogBox();
            }
        });
    }

    private void addTimeDialogBox() {
        final Dialog dialog = new Dialog(EnterActivity.this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.time_dialog_box);
        final EditText timeEditTextOne = (EditText) dialog.findViewById(R.id.TimeEditTextOne);
        final EditText drinkEditTextTwo = (EditText) dialog.findViewById(R.id.DrinkEditTextTwo);
        final Button doneButton = (Button) dialog.findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeOne = timeEditTextOne.getText().toString().trim();
                drinkOne = drinkEditTextTwo.getText().toString().trim();

                if (timeOne.isEmpty()) {
                    timeEditTextOne.setError("Please enter in an Adjective!");
                    timeEditTextOne.requestFocus();
                    return;

                }

                if(drinkOne.isEmpty()){
                    drinkEditTextTwo.setError("Please enter in an Adjective");
                    drinkEditTextTwo.requestFocus();
                    return;
                }
                if(!timeOne.isEmpty() && !drinkOne.isEmpty()){
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    private void addPlaceDialongBox() {
        final Dialog dialog = new Dialog(EnterActivity.this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.place_dialog_box);
        final EditText placeEditTextOne = (EditText) dialog.findViewById(R.id.placeEditTextOne);
        final EditText placeEditTextTwo = (EditText) dialog.findViewById(R.id.placeEditTextTwo);
        final EditText placeEditTextThree = (EditText) dialog.findViewById(R.id.placeEditTextThree);
        final EditText roomEditTextOne = (EditText) dialog.findViewById(R.id.roomEditTextFour);
        final Button doneButton = (Button) dialog.findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                placeOne = placeEditTextOne.getText().toString().trim();
                placeTwo = placeEditTextTwo.getText().toString().trim();
                placeThree = placeEditTextThree.getText().toString().trim();
                roomOne = roomEditTextOne.getText().toString().trim();

                if (placeOne.isEmpty()) {
                    placeEditTextOne.setError("Please enter in an Adjective!");
                    placeEditTextOne.requestFocus();
                    return;

                }

                if(placeTwo.isEmpty()){
                    placeEditTextTwo.setError("Please enter in an Adjective");
                    placeEditTextTwo.requestFocus();
                    return;
                }
                if(placeThree.isEmpty()){
                    placeEditTextThree.setError("Please enter in an Adjective");
                    placeEditTextThree.requestFocus();
                    return;
                }
                if(roomOne.isEmpty()){
                    roomEditTextOne.setError("Please enter in an Adjective");
                    roomEditTextOne.requestFocus();
                    return;
                }
                if(!placeOne.isEmpty() && !placeTwo.isEmpty() && !placeThree.isEmpty() && !roomOne.isEmpty()){
                    dialog.dismiss();
                }
            }
        });
        dialog.show();

    }

    private void addVerbDialogBox() {
        final Dialog dialog = new Dialog(EnterActivity.this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.verb_dialog_box);
        final EditText verbEditTextOne = (EditText) dialog.findViewById(R.id.verbEditTextOne);
        final EditText verbEditTextTwo = (EditText) dialog.findViewById(R.id.verbEditTextTwo);
        final EditText verbEditTextThree = (EditText) dialog.findViewById(R.id.verbEditTextThree);
        final EditText verbEditTextFour = (EditText) dialog.findViewById(R.id.verbEditTextFour);
        final Button doneButton = (Button) dialog.findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verbOne = verbEditTextOne.getText().toString().trim();
                verbTwo = verbEditTextTwo.getText().toString().trim();
                verbThree = verbEditTextThree.getText().toString().trim();
                verbFour = verbEditTextFour.getText().toString().trim();

                if (verbOne.isEmpty()) {
                    verbEditTextOne.setError("Please enter in an Adjective!");
                    verbEditTextOne.requestFocus();
                    return;

                }

                if(verbTwo.isEmpty()){
                    verbEditTextTwo.setError("Please enter in an Adjective");
                    verbEditTextTwo.requestFocus();
                    return;
                }
                if(verbThree.isEmpty()){
                    verbEditTextThree.setError("Please enter in an Adjective");
                    verbEditTextThree.requestFocus();
                    return;
                }
                if(verbFour.isEmpty()){
                    verbEditTextFour.setError("Please enter in an Adjective");
                    verbEditTextFour.requestFocus();
                    return;
                }
                if(!verbOne.isEmpty() && !verbTwo.isEmpty() && !verbThree.isEmpty() && !verbFour.isEmpty()){
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    private void addAdjectiveDialogBox() {
        final Dialog dialog = new Dialog(EnterActivity.this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.adjective_dialog_box);
        final EditText adjectiveEditTextOne = (EditText) dialog.findViewById(R.id.AdjectiveEditTextOne);
        final EditText adjectiveEditTextTwo = (EditText) dialog.findViewById(R.id.AdjectiveEditTextTwo);
        final Button doneButton = (Button) dialog.findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adjectiveOne = adjectiveEditTextOne.getText().toString().trim();
                adjectiveTwo = adjectiveEditTextTwo.getText().toString().trim();

                if (adjectiveOne.isEmpty()) {
                    adjectiveEditTextOne.setError("Please enter in an Adjective!");
                    adjectiveEditTextOne.requestFocus();
                    return;

                }

                if(adjectiveTwo.isEmpty()){
                    adjectiveEditTextTwo.setError("Please enter in an Adjective");
                    adjectiveEditTextOne.requestFocus();
                    return;
                }
                if(!adjectiveOne.isEmpty() && !adjectiveTwo.isEmpty()){
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    private void addNounDialogBox(){
        final Dialog dialog = new Dialog(EnterActivity.this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.noun_dialog_box);
        final EditText nounEditText = (EditText) dialog.findViewById(R.id.nounEditTextOne);
        final Button doneButton = (Button) dialog.findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nounOne = nounEditText.getText().toString().trim();
                if(nounOne.isEmpty()){
                    nounEditText.setError("Please enter in a Noun!");
                    nounEditText.requestFocus();
                    return;
                }else{
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }
}
