package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,LayoutExercise.class); //Intent is the gateway from one activity to another; has the capability top hold data from one activity and pass it to another
                startActivity(intent1);
            }
        });

        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,ButtonActivity.class); //Intent is the gateway from one activity to another; has the capability top hold data from one activity and pass it to another
                startActivity(intent1);
            }
        });

        btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,MyCalculator.class); //Intent is the gateway from one activity to another; has the capability top hold data from one activity and pass it to another
                startActivity(intent1);
            }
        });

        btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,BatchOne.class); //Intent is the gateway from one activity to another; has the capability top hold data from one activity and pass it to another
                startActivity(intent1);
            }
        });

        btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, PrefinalActivity.class); //Intent is the gateway from one activity to another; has the capability top hold data from one activity and pass it to another
                startActivity(intent1);
            }
        });
    }

}