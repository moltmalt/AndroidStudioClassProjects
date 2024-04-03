package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class PrefinalActivity extends AppCompatActivity implements View.OnClickListener {


    MaterialButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
    MaterialButton btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20;
    MaterialButton btn21, btn22, btn23, btn24, btn25;
    Button restart;
    TextView playerWho;

    static Integer [][] colorArray = new Integer[5][5];

    static boolean player1;

    MaterialButton [][] arrbuttons = new MaterialButton[5][5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefinal);

        playerWho = findViewById(R.id.playerWho);

        int index = 1;
        player1 = true;
        playerWho.setText("Player 1");
        playerWho.setTextColor(Color.BLUE);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int buttonId = getResources().getIdentifier("btn" + index, "id", getPackageName());
                arrbuttons[i][j] = findViewById(buttonId);
                index++;
                colorArray[i][j] = 1;
            }
        }

        restart = findViewById(R.id.restart);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PrefinalActivity.this, PrefinalActivity.class);
                startActivity(intent);
            }
        });

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            arrbuttons[0][i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (player1) {
                        if (colorArray[4][finalI] == 1) {
                            arrbuttons[4][finalI].setBackgroundColor(Color.BLUE);
                            colorArray[4][finalI] = 2;
                        } else if (colorArray[3][finalI] == 1) {
                            arrbuttons[3][finalI].setBackgroundColor(Color.BLUE);
                            colorArray[3][finalI] = 2;
                        } else if (colorArray[2][finalI] == 1) {
                            arrbuttons[2][finalI].setBackgroundColor(Color.BLUE);
                            colorArray[2][finalI] = 2;
                        } else if (colorArray[1][finalI] == 1) {
                            arrbuttons[1][finalI].setBackgroundColor(Color.BLUE);
                            colorArray[1][finalI] = 2;
                        } else if (colorArray[0][finalI] == 1) {
                            arrbuttons[0][finalI].setBackgroundColor(Color.BLUE);
                            colorArray[0][finalI] = 2;
                        }
                        player1 = false;
                        playerWho.setText("Player 2");
                        playerWho.setTextColor(Color.RED);
                    } else {
                        if (colorArray[4][finalI] == 1) {
                            arrbuttons[4][finalI].setBackgroundColor(Color.RED);
                            colorArray[4][finalI] = 2;
                            checkWin(4, finalI);
                        } else if (colorArray[3][finalI] == 1) {
                            arrbuttons[3][finalI].setBackgroundColor(Color.RED);
                            colorArray[3][finalI] = 2;
                        } else if (colorArray[2][finalI] == 1) {
                            arrbuttons[2][finalI].setBackgroundColor(Color.RED);
                            colorArray[2][finalI] = 2;
                        } else if (colorArray[1][finalI] == 1) {
                            arrbuttons[1][finalI].setBackgroundColor(Color.RED);
                            colorArray[1][finalI] = 2;
                        } else if (colorArray[0][finalI] == 1) {
                            arrbuttons[0][finalI].setBackgroundColor(Color.RED);
                            colorArray[0][finalI] = 2;
                        }
                        player1 = true;
                        playerWho.setText("Player 1");
                        playerWho.setTextColor(Color.BLUE);
                    }
                }
            });
        }
    }

    @Override
    public void onClick(View view) {

    }

    public boolean checkWin(int i, int j){
        return true;
    }
}