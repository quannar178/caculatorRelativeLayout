package com.example.caculatorrelative;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import java.lang.StringBuilder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnNum0, btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7,
            btnNum8, btnNum9, btnEqual, btnPlus, btnMinus, btnMulti, btnDevide, btnDel,
            btnDot, btnPlusMinus, btnC, btnCE, btnOnePerX, btnSquare, btnSqrt,
            btnPercent, btnMC, btnMR, btnMPlus, btnMMinus, btnMS, btnM;

    TextView tvResult, tvShow;

    StringBuilder tmp1;
    int count = 0;
    int tmpCal;
    int tmpCalCount = 0;
    StringBuilder tmpOut;
    float a = 0;
    float b = 0;
    float preResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();

        tmp1 = new StringBuilder();
        tmp1.append('0');
        tmpOut = new StringBuilder();

        btnPlusMinus.setOnClickListener(this);
        btnNum0.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnNum1.setOnClickListener(this);
        btnNum2.setOnClickListener(this);
        btnNum3.setOnClickListener(this);

        btnMinus.setOnClickListener(this);
        btnDevide.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
    }

    private void Mapping() {
        btnPlusMinus = findViewById(R.id.btnPlusMinus);
        btnNum0 = findViewById(R.id.btnNum0);
        btnDot = findViewById(R.id.btnDot);
        btnEqual = findViewById(R.id.btnEqual);
        btnNum1 = findViewById(R.id.btnNum1);
        btnNum2 = findViewById(R.id.btnNum2);
        btnNum3 = findViewById(R.id.btnNum3);
        btnPlus = findViewById(R.id.btnPlus);
        btnNum4 = findViewById(R.id.btnNum4);
        btnNum5 = findViewById(R.id.btnNum5);
        btnNum6 = findViewById(R.id.btnNum6);
        btnMinus = findViewById(R.id.btnMinus);
        btnNum7 = findViewById(R.id.btnNum7);
        btnNum8 = findViewById(R.id.btnNum8);
        btnNum9 = findViewById(R.id.btnNum9);
        btnMulti = findViewById(R.id.btnMultiple);
        btnOnePerX = findViewById(R.id.btnOneDevX);
        btnSquare = findViewById(R.id.btnXSquare);
        btnSqrt = findViewById(R.id.btnXSqrt);
        btnDevide = findViewById(R.id.btnDevide);
        btnPercent = findViewById(R.id.btnPercent);
        btnCE = findViewById(R.id.btnCE);
        btnC = findViewById(R.id.btnC);
        btnDel = findViewById(R.id.btnDel);
        btnMC = findViewById(R.id.btnMC);
        btnMR = findViewById(R.id.btnMR);
        btnMPlus = findViewById(R.id.btnMPlus);
        btnMMinus = findViewById(R.id.btnMMinus);
        btnMS = findViewById(R.id.btnMS);
        btnM = findViewById(R.id.btnM);

        tvResult = findViewById(R.id.tvResult);
        tvShow = findViewById(R.id.tvShow);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnNum0: {tmp1.append("0"); showNum(); break;}
            case R.id.btnNum1: {tmp1.append("1"); showNum(); break;}
            case R.id.btnPlus: {tmpCal = 1; ; showCal() ; tmpCalCount = 1; break; }
            case R.id.btnMinus: {tmpCal = 2; showCal() ; tmpCalCount = 1; break; }
            case R.id.btnMultiple: {tmpCal = 3; showCal() ; tmpCalCount = 1; break; }
            case R.id.btnDevide: {tmpCal = 4; showCal() ; tmpCalCount = 1; break; }
            case R.id.btnEqual: showEqual(); break;
            default:
                break;
        }
    }

    private void showCal() {
        if(tmpOut.length() == 0 && tmp1.equals('0') ){
            tmpOut.append(a);
        }
        if (tmpCalCount == 0){
            tmpOut.append(a);
            if(tmpCal == 1){
                tmpOut.append('+');
            }
            if(tmpCal == 2){
                tmpOut.append('-');
            }
            if (tmpCal == 3){
                tmpOut.append('*');
            }
            if(tmpCal == 4){
                tmpOut.append('/');
            }
            b = a;
        }
        else {
            if (tmpCal == 1){
                tmpOut.setCharAt(tmpOut.length() - 1, '+');
            }
            if(tmpCal == 2){
                tmpOut.setCharAt(tmpOut.length() - 1, '-');
            }
            if(tmpCal == 3){
                tmpOut.setCharAt(tmpOut.length() - 1, '*');
            }
            if(tmpCal == 4){
                tmpOut.setCharAt(tmpOut.length() - 1, '/');
            }
        }
        tmp1 = new StringBuilder();
        tvResult.setText("" + tmpOut.toString());
    }

    private void showEqual() {

        tmpCalCount = 0;
        if(count != 0) b = preResult;
        if (tmpCal == 1){
            preResult = a + b;
            tvShow.setText("" + preResult);
            tvResult.setText(tmpOut.toString() + '=');
        }
        if(tmpCal == 2){
            preResult = b - a;
            tvShow.setText("" + preResult);
            tvResult.setText(tmpOut.toString() + '=');
        }
        if(tmpCal == 3){
            preResult = a * b;
            tvShow.setText("" + preResult);
            tvResult.setText(tmpOut.toString() + '=');
        }
        if(tmpCal == 4){
            preResult = b / a;
            tvShow.setText(String.format("%s", preResult));
            tvResult.setText(tmpOut.toString() + '=');
        }
        count++;

        
    }

    @SuppressLint("DefaultLocale")
    private void showNum(){
        tmpCalCount = 0;
        a = Integer.parseInt(tmp1.toString());
        Log.i("TMP1", "" + a);
        tvShow.setText(String.format("%.0f", a));
    }
}
