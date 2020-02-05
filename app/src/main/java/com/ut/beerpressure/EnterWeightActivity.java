package com.ut.beerpressure;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EnterWeightActivity extends AppCompatActivity {

    private Button nextButton;
    private EditText weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_weight);
        nextButton = findViewById(R.id.next_btn_username);
        weight = findViewById(R.id.weight);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (weight.getText() != null && weight.getText().toString().trim().length() > 0) {
                    Defaults.weight = Integer.parseInt(weight.getText().toString().trim());

                    Intent intent = new Intent(EnterWeightActivity.this, EnterWeightActivity.class);
                    startActivity(intent);
                } else
                    Toast.makeText(EnterWeightActivity.this, "Please type your weight!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
