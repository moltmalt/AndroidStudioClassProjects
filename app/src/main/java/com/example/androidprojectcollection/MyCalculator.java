package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import com.google.android.material.button.MaterialButton;

public class MyCalculator extends AppCompatActivity implements View.OnClickListener{

    TextView tvres, tvsol;
    MaterialButton btnclear, btnsigns, btnmodulo, btndivide, btnmultiply, btnsubtract, btnadd, btnequal, btndot, btnallclear;
    MaterialButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;

    StackEvaluate letseval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_calculator);
        tvres = findViewById(R.id.tvRes);
        tvsol = findViewById(R.id.tvSol);

        assignId(btnclear, R.id.btnclear);
        assignId(btnallclear, R.id.btnallclear);
        assignId(btnsigns, R.id.btnclosep);
        assignId(btnsigns, R.id.btnopenp);
        assignId(btnmodulo, R.id.btnmodulo);
        assignId(btndivide, R.id.btndivide);
        assignId(btnmultiply, R.id.btnmultiply);
        assignId(btnsubtract, R.id.btnsubtract);
        assignId(btnadd, R.id.btnadd);
        assignId(btnequal, R.id.btnequal);
        assignId(btndot, R.id.btndot);
        assignId(btn7, R.id.btn7);
        assignId(btn8, R.id.btn8);
        assignId(btn9, R.id.btn9);
        assignId(btn4, R.id.btn4);
        assignId(btn5, R.id.btn5);
        assignId(btn6, R.id.btn6);
        assignId(btn1, R.id.btn1);
        assignId(btn2, R.id.btn2);
        assignId(btn3, R.id.btn3);

    }

    void assignId(MaterialButton btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MaterialButton btn = (MaterialButton) v;
        String btnText = btn.getText().toString();
        String dataToCalculate = tvsol.getText().toString();
        String finalRes = "";
        String sequentialRes = "";
        String [] buffer;

        System.out.println("First " + dataToCalculate);

        if (btnText.equals("AC")) {
            tvsol.setText("");
            tvres.setText("0");
            return;
        }

        if (btnText.equals("=")) {
            finalRes = String.valueOf(StackEvaluate.bigEvaluate(dataToCalculate));
            tvsol.setText(finalRes);
            tvres.setText(finalRes);
            return;
        }

        if (btnText.equals("C")) {
            dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
            tvsol.setText(dataToCalculate);
            return;
        } else {
            if (tvsol.getText() == "0") {
                tvsol.setText("");
                return;
            }

            if ((dataToCalculate.endsWith(".")) && btnText.equals(".")) {
                dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
                tvsol.setText(dataToCalculate);
                return;
            }

            if ((dataToCalculate.endsWith("+") || dataToCalculate.endsWith("-") || dataToCalculate.endsWith("*") ||
                    dataToCalculate.endsWith("/")) && (btnText.equals("+") || btnText.equals("-") || btnText.equals("*") ||
                    btnText.equals("/"))) {
                dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
                dataToCalculate += btnText;
                tvsol.setText(dataToCalculate);
                return;
            }

            if (btnText.equals(".")) {
                buffer = dataToCalculate.split("(?=[+\\-*/])|(?<=[+\\-*/])");
                if (!buffer[buffer.length-1].contains(".")) {
                    if (!dataToCalculate.endsWith("1") && !dataToCalculate.endsWith("2") && !dataToCalculate.endsWith("3")
                            && !dataToCalculate.endsWith("4") && !dataToCalculate.endsWith("5") && !dataToCalculate.endsWith("6")
                            && !dataToCalculate.endsWith("7") && !dataToCalculate.endsWith("8") && !dataToCalculate.endsWith("9")) {
                        if (!dataToCalculate.endsWith("0")) {
                            dataToCalculate += "0";
                        } else {
                            return;
                        }
                    }
                } else {
                    return;
                }

            }

            dataToCalculate += btnText;

            tvsol.setText(dataToCalculate);
            System.out.println(dataToCalculate);
            sequentialRes = String.valueOf(StackEvaluate.preEvaluate(dataToCalculate));

            tvres.setText(sequentialRes);
        }
    }
}