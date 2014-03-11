package com.example.SavingForm;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class MyActivity extends Activity {

    EditText name;
    EditText vol;
    EditText perc;
    EditText pri;

    FormValues fv = new FormValues();



    int numOfDrinks = 0;
    int selectedForm = 0;

    FormFragment forms = new FormFragment();

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);




        final LinearLayout drinkSelectionContainer = (LinearLayout) findViewById(R.id.drinkSelectContainer);
        final Button newDrink[] = new Button[100];
              newDrink[0] = new Button(getBaseContext());
              newDrink[0].setText("Drink 1");
              newDrink[0].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
              drinkSelectionContainer.addView(newDrink[0]);

        final Button nextDrink = (Button) findViewById(R.id.bNextDrink);
        final Button crunkOut = (Button) findViewById(R.id.bCalc);

        nextDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numOfDrinks++;
                newDrink[numOfDrinks] = new Button(getBaseContext());
                newDrink[numOfDrinks].setOnClickListener(drinkSelectListener);
                newDrink[numOfDrinks].setId(numOfDrinks);
                newDrink[numOfDrinks].setText("Drink " + (numOfDrinks + 1));
                newDrink[numOfDrinks].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                drinkSelectionContainer.addView(newDrink[numOfDrinks]);
                forms = newInstance();
            }

        });





}



    public static FormFragment newInstance(int type) {
        FormFragment fragment = new FormFragment();
        Bundle args = new Bundle();
        args.putInt("numOfDrink", type);
        fragment.setArguments(args);
        return fragment;
    }

    public View.OnClickListener drinkSelectListener = new View.OnClickListener() {
        public void onClick(View v) {
            selectedForm = v.getId();
            // Do something depending on the value of the tag
            Log.v("Happened:", "Select Drink " + selectedForm + " button pressed.");
            Button v1 = (Button) findViewById(selectedForm);
//            v1.setText(mNames.get(selectedForm).toString());
            newInstance(1);

        }
    };

}