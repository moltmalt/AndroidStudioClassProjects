package com.example.androidprojectcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MenuExercise extends AppCompatActivity {

    Button btnChanger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_menuexercise, menu);

        btnChanger = findViewById(R.id.btnTransform);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mItemChange) {
            Toast.makeText(this, "Edit Object Item is clicked", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.mItemReset){
            btnChanger.setRotation(0);
            btnChanger.setBackgroundColor(Color.BLACK);
            btnChanger.setTextColor(Color.WHITE);
            btnChanger.setText("Hello World!");
            btnChanger.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Reset Object Item is clicked", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.mItemExit){
             finish();
        }else if(item.getItemId() == R.id.changeBGRed){
            btnChanger.setBackgroundColor(Color.RED);
        }else if(item.getItemId() == R.id.changeTextRed){
            btnChanger.setTextColor(Color.BLACK);
        }else if(item.getItemId() == R.id.changeRotation){
            btnChanger.setRotation(btnChanger.getRotation()+90);
        }else if(item.getItemId() == R.id.changeText){
            if(btnChanger.getText().equals("Hello World!")){
                btnChanger.setText("Goodbye World!");
            }else{
                btnChanger.setText("Hello World!");
            }
        }else if(item.getItemId() == R.id.changeVisibility){
            if(btnChanger.getVisibility() == View.VISIBLE){
                btnChanger.setVisibility(View.INVISIBLE);
            }else{
                btnChanger.setVisibility(View.VISIBLE);
            }
        }
        return true;
    }
}