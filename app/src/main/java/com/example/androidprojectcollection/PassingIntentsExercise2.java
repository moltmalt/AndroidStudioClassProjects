package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PassingIntentsExercise2 extends AppCompatActivity {

    TextView txtPI2FName;
    TextView txtPI2LName;
    TextView txtPI2Gender ;
    TextView txtPI2StudID;
    TextView txtPI2Program;
    TextView txtPI2BirthDate;
    TextView txtPI2Email ;
    TextView txtPI2PhoneNum;
    TextView txtPI2YrLevel;
    TextView txtPI2Units;
    TextView txtPI2GWA;

    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);

         txtPI2FName = findViewById(R.id.txtPI2FName);
         txtPI2LName = findViewById(R.id.txt2PILName);
         txtPI2Gender = findViewById(R.id.txtPI2Gender);
         txtPI2StudID = findViewById(R.id.txtPI2StudID);
         txtPI2Program = findViewById(R.id.txtPI2Program);
         txtPI2BirthDate = findViewById(R.id.txtPI2BirthDate);
         txtPI2Email = findViewById(R.id.txtPI2Email);
         txtPI2PhoneNum = findViewById(R.id.txtPI2PhoneNum);
         txtPI2YrLevel = findViewById(R.id.txtPI2YrLevel);
         txtPI2Units = findViewById(R.id.txtPI2Units);
         txtPI2GWA = findViewById(R.id.txtPI2GWA);

         btnReturn = findViewById(R.id.btnReturn);

        Intent intent = getIntent();

        String fName = intent.getStringExtra("fName_key");
        String lName = intent.getStringExtra("lName_key");
        String gender = intent.getStringExtra("gender_key");
        String email = intent.getStringExtra("email_key");
        String studID = intent.getStringExtra("studID_key");
        String program = intent.getStringExtra("program_key");
        String yrLevel = intent.getStringExtra("yrLevel_key");
        String bDate  = intent.getStringExtra("bDate_key");
        String phoneNumber= intent.getStringExtra("phoneNumber_key");
        String units  = intent.getStringExtra("units_key");
        String GWA = intent.getStringExtra("GWA_key");

         txtPI2FName.setText(fName);
         txtPI2LName.setText(lName);
         txtPI2Gender.setText(gender);
         txtPI2YrLevel.setText(yrLevel);
         txtPI2StudID.setText(studID);
         txtPI2Program.setText(program);
         txtPI2BirthDate.setText(bDate);
         txtPI2Email.setText(email);
         txtPI2PhoneNum.setText(phoneNumber);
         txtPI2Units.setText(units);
         txtPI2GWA.setText(String.valueOf(GWA));

         btnReturn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(PassingIntentsExercise2.this, PassingIntentsExercise.class);
                 startActivity(intent);
             }
         });
    }
}