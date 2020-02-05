package com.ut.beerpressure;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EnterUsernameActivity extends AppCompatActivity {

    private EditText username;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_username);
        username = findViewById(R.id.username);
        nextButton = findViewById(R.id.next_btn_username);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText() != null && username.getText().toString().trim().length() > 0) {
                    Defaults.username = username.getText().toString().trim();
                    Intent intent = new Intent(EnterUsernameActivity.this, EnterGenderActivity.class);
                    startActivity(intent);
                } else
                    Toast.makeText(EnterUsernameActivity.this, "Please type your username!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
