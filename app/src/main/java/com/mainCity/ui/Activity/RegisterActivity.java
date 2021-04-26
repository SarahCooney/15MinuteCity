package com.mainCity.ui.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.mainCity.Objects.User;
import com.mainCity.R;
import com.mainCity.ui.login.LoginActivity;

/**
 * This is the register page for user to register a new account.
 */
public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);
                Toast.makeText(getApplicationContext(), "You choose " + radbtn.getText(), Toast.LENGTH_LONG).show();
            }
        });

        Button signUp = (Button) findViewById(R.id.signup_button);
        signUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(RegisterActivity.this, SurveyActivity.class);
                startActivity(i);

            }


        });
    }



}