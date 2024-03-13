package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.androidprojectcollection.R;

public class ButtonActivity extends AppCompatActivity {

    private Button btnclose, btntoast, btnchangeBG, btnchangebtn, btndisappear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        final LinearLayout linearLayout;

        btnclose = (Button) findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSecondPage();
            }
        });

        btntoast = (Button) findViewById(R.id.btntoast);
        btntoast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence text = "Hello toast!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(ButtonActivity.this, text, duration);
                toast.show();
            }
        });

        btnchangeBG = (Button) findViewById(R.id.btnchangebg);
        linearLayout = findViewById(R.id.linearmain);
        btnchangeBG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setBackgroundResource(R.color.cool);
            }
        });

        btnchangebtn = (Button) findViewById(R.id.btnchangebtn);
        btnchangebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnchangebtn.setBackgroundColor(getResources().getColor(R.color.cool));
            }
        });

        btndisappear = (Button) findViewById(R.id.btndisappear);
        btndisappear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btndisappear.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void openSecondPage(){
        Intent intent =  new Intent(this, ButtonActivitySecondPage.class);
        startActivity(intent);
    }
}