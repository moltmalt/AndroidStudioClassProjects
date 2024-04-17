package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PassingIntentsExercise extends AppCompatActivity {

    EditText etxtFname;
    EditText etxtLName;
    RadioGroup radGenders;
    RadioButton [] rgGenders;
    RadioButton radMale;
    RadioButton radFemale;
    RadioButton radOthers;
    EditText etxtStudID;
    EditText etxtProgram;
    EditText etxtYrLevel;
    EditText etxtBirthDate;
    EditText etxtEmail;
    EditText etxtUnits;
    EditText etxtGWA;
    EditText etxtPhoneNumber;
    Button btnClearForm ;
    Button btnSubmitForm;

    String fName;
    String lName;
    String gender;
    String studID, email;
    String program;
    String yrLevel;
    String bDate;
    String phoneNumber;
    String units;
    String GWA;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);

         etxtFname = findViewById(R.id.etxtFName);
         etxtLName = findViewById(R.id.etxtLName);
         radGenders = findViewById(R.id.radGenders);
         radMale = findViewById(R.id.radMale);
         radFemale = findViewById(R.id.radFemale);
         radOthers = findViewById(R.id.radOthers);
         etxtStudID = findViewById(R.id.etxtStudID);
         etxtProgram = findViewById(R.id.etxtProgram);
         etxtYrLevel = findViewById(R.id.etxtYrLevel);
         etxtBirthDate = findViewById(R.id.etxtBirthDate);
         etxtEmail = findViewById(R.id.etxtEmail);
         etxtUnits = findViewById(R.id.etxtUnits);
         etxtGWA = findViewById(R.id.etxtGWA);
         etxtPhoneNumber = findViewById(R.id.etxtPhoneNumber);
         btnClearForm = findViewById(R.id.btnClearForm);
         btnSubmitForm = findViewById(R.id.btnSubmitForm);

        btnSubmitForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etxtFname.getText().toString().equals(null) && !etxtLName.getText().toString().equals(null) && !etxtStudID.getText().toString().equals(null) && !etxtProgram.getText().toString().equals(null) &&
                        !etxtYrLevel.getText().toString().equals(null) && !etxtBirthDate.getText().toString().equals(null) &&
                        !etxtPhoneNumber.getText().toString().equals(null) && !etxtEmail.getText().toString().equals(null) &&
                        !etxtUnits.getText().toString().equals(null) && !etxtGWA.getText().toString().equals(null)){

                    if(radMale.isSelected()){
                        gender = "Male";
                    }else if(radFemale.isSelected()){
                        gender ="Female";
                    }else if(radOthers.isSelected()){
                        gender ="Others";
                    }else{
                        gender ="Unspecified";
                    }

                    fName = etxtFname.getText().toString();
                    lName = etxtLName.getText().toString();
                    studID = etxtStudID.getText().toString();
                    email = etxtEmail.getText().toString();
                    program = etxtProgram.getText().toString();
                    yrLevel = etxtProgram.getText().toString();
                    bDate  = etxtBirthDate.getText().toString();
                    phoneNumber = etxtPhoneNumber.getText().toString();;
                    units = etxtUnits.getText().toString();
                    GWA = etxtGWA.getText().toString();

                    Intent intent = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);
                    intent.putExtra("fName_key", fName);
                    intent.putExtra("lName_key", lName);
                    intent.putExtra("gender_key", gender);
                    intent.putExtra("email_key", email);
                    intent.putExtra("studID_key", studID);
                    intent.putExtra("program_key", program);
                    intent.putExtra("yrLevel_key", yrLevel);
                    intent.putExtra("bDate_key", bDate);
                    intent.putExtra("phoneNumber_key", phoneNumber);
                    intent.putExtra("units_key", units);
                    intent.putExtra("GWA_key", GWA);

                    startActivity(intent);

                }
            }
        });

    }


}