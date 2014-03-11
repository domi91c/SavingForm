package com.example.SavingForm;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

/**
 * Created by portodin on 3/10/2014.
 */
public class FormFragment extends Fragment {

    EditText name;
    EditText vol;
    EditText perc;
    EditText pri;
    AutoCompleteTextView quant;

    final FormValues fv = new FormValues();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.drinkform,
                container, true);



        name = (EditText) view.findViewById(R.id.etName);
        vol = (EditText) view.findViewById(R.id.etVol);
        perc = (EditText) view.findViewById(R.id.etPerc);
        pri = (EditText) view.findViewById(R.id.etPrice);
        quant = (AutoCompleteTextView) view.findViewById(R.id.etQuantity);



        initEditTexts();

        return view;
    }



    private void initEditTexts() {
        vol.setText("750");
        perc.setText("40");
        pri.setText("32");
        quant.setText("1");
    }
}