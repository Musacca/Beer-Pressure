package com.ut.beerpressure;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EnterGenderActivity extends AppCompatActivity {

    private TextView spinner;
    ArrayList<String> genders;
    private Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_gender);
        nextButton = findViewById(R.id.next_btn_username);
        spinner = (TextView) findViewById(R.id.spinner);
        genders = new ArrayList<>();
        genders.add("Male");
        genders.add("Female");
        final Dialog dialog = new CustomCountryListDialog(EnterGenderActivity.this, genders);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimations_PauseDialogAnimation;

        spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // countryListSpinner.showSpinerDialog();
                dialog.show();

            }
        });

        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                spinner.setText(Defaults.gender);

            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinner.getText() != null && spinner.getText().toString().trim().length() > 0){
                    Defaults.gender = spinner.getText().toString().trim();
                    Intent intent = new Intent(EnterGenderActivity.this, EnterWeightActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(EnterGenderActivity.this, "Please select your gender!", Toast.LENGTH_SHORT).show();

            }
        });


    }


}
