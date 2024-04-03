package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class BatchOne extends AppCompatActivity implements View.OnClickListener{

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, rndm;

    Button [][] arrbuttons = new Button[3][3];
    static Integer [][] colorArray = new Integer[3][3];
    int[] colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch_one);

        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        rndm = findViewById(R.id.random);

        arrbuttons[0][0] = btn1;
        arrbuttons[0][1] = btn2;
        arrbuttons[0][2] = btn3;

        arrbuttons[1][0] = btn4;
        arrbuttons[1][1] = btn5;
        arrbuttons[1][2] = btn6;

        arrbuttons[2][0] = btn7;
        arrbuttons[2][1] = btn8;
        arrbuttons[2][2] = btn9;


        colors = new int[] {Color.BLUE,Color.RED,Color.YELLOW};


        Random random = new Random();

        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                int colorNum = random.nextInt(3);
                arrbuttons[i][j].setBackgroundColor(colors[colorNum]);
                colorArray[i][j] = colorNum;
            }
        }


        rndm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BatchOne.this, BatchOne.class);
                startActivity(intent);
            }
        });
        for(int i = 0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                int finalI = i;
                int finalJ = j;
                arrbuttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if(checkWin()){
                            return;
                        }
                        if(finalI-1>=0){
                            colorArray[finalI-1][finalJ] = (colorArray[finalI-1][finalJ]+1)%3;
                        }

                        if(finalJ-1>=0){
                            colorArray[finalI][finalJ-1] = (colorArray[finalI][finalJ-1]+1)%3;
                        }


                        if(finalI+1<3){
                            colorArray[finalI+1][finalJ] = (colorArray[finalI+1][finalJ]+1)%3;
//
                        }

                        if(finalJ+1<3){
                            colorArray[finalI][finalJ+1] = (colorArray[finalI][finalJ+1]+1)%3;
//
                        }

                        for(int i = 0; i<3; i++){
                            for(int j = 0; j<3; j++){
                                arrbuttons[i][j].setBackgroundColor(colors[colorArray[i][j]]);
//
                            }
                        }
                    }
                });
            }
        }



    }


    public static boolean checkWin() {

        int frstColor = colorArray[0][0];

        for (int i = 0; i < colorArray.length; i++) {
            for (int j = 0; j < colorArray[i].length; j++) {
                if (!colorArray[i][j].equals(colorArray)) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public void onClick(View view) {

    }
}