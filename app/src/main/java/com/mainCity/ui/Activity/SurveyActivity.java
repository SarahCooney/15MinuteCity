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
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.mainCity.R;

/**
 * This is the survey page after register page. This part is a simple survey and user can choose
 * which question they want answer.
 */
public class SurveyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        final Spinner ageChoose = (Spinner) findViewById(R.id.age_spinner);
        final Spinner eduChoose = (Spinner) findViewById(R.id.edu_spinner);
        final Spinner marrChoose = (Spinner) findViewById(R.id.marr_spinner);
        final Spinner emChoose = (Spinner) findViewById(R.id.em_spinner);
        final Spinner raceChoose = (Spinner) findViewById(R.id.race_spinner);
        Button signup = (Button) findViewById(R.id.submit_button);

        ArrayAdapter<CharSequence> age_type = ArrayAdapter.createFromResource(this,R.array.age_select,android.R.layout.simple_spinner_item);
        age_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageChoose.setAdapter(age_type);

        ageChoose.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Toast.makeText(SurveyActivity.this, ageChoose.getSelectedItem().toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> marr_type = ArrayAdapter.createFromResource(this,R.array.marr_select,android.R.layout.simple_spinner_item);
        marr_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        marrChoose.setAdapter(marr_type);

        marrChoose.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Toast.makeText(SurveyActivity.this, marrChoose.getSelectedItem().toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> em_type = ArrayAdapter.createFromResource(this,R.array.Employ_select,android.R.layout.simple_spinner_item);
        em_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        emChoose.setAdapter(em_type);

        emChoose.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Toast.makeText(SurveyActivity.this, emChoose.getSelectedItem().toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> race_type = ArrayAdapter.createFromResource(this,R.array.Ethnic_select,android.R.layout.simple_spinner_item);
        race_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        raceChoose.setAdapter(race_type);

        raceChoose.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Toast.makeText(SurveyActivity.this, raceChoose.getSelectedItem().toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> edu_type = ArrayAdapter.createFromResource(this,R.array.edu_select,android.R.layout.simple_spinner_item);
        edu_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eduChoose.setAdapter(edu_type);

        eduChoose.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Toast.makeText(SurveyActivity.this, eduChoose.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();

//                if(signUpCorrectly()){
//                    EditText usName = (EditText)findViewById(R.id.usernam_enter);
//                    EditText pw =(EditText)findViewById(R.id.password_enter);
//                    EditText pw2 = (EditText)findViewById(R.id.password_reenter);
//                    EditText email = (EditText)findViewById(R.id.email_enter);
//                    RadioGroup gender = (RadioGroup) findViewById(R.id.radioGroup);
//                }
            }
        });


    }

    /**
     * To show dialog for user to submit this survey.
     */
    public void showDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Survey");
        builder.setMessage("Do you want to submit your information to sign up?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(SurveyActivity.this, NaviActivity.class);
                startActivity(i);
            }
        }).setNegativeButton("Go back to check", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
            }
        });
        AlertDialog dialog=builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    /**
     * To check if the user sign up successfully.
     * @return if they sign up successfully
     */
    public boolean signUpCorrectly(){
        EditText usName = (EditText)findViewById(R.id.usernam_enter);
        EditText pw =(EditText)findViewById(R.id.password_enter);
        EditText pw2 = (EditText)findViewById(R.id.password_reenter);
        EditText email = (EditText)findViewById(R.id.email_enter);
        RadioGroup gender = (RadioGroup) findViewById(R.id.radioGroup);

        return false;
    }
}