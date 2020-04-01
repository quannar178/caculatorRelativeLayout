package com.example.caculatorrelative;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import java.lang.StringBuilder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnNum0, btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7,
            btnNum8, btnNum9, btnEqual, btnPlus, btnMinus, btnMulti, btnDevide,
            btnDot, btnPlusMinus, btnC, btnCE, btnOnePerX, btnSquare, btnSqrt,
            btnPercent, btnMC, btnMR, btnMPlus, btnMMinus, btnMS, btnM;

    ImageButton btnDel;
    TextView tvResult, tvShow;

    int type = 0; // = 1: number ; = 2: +, -, *, /; = 3: C.
    StringBuilder tmpA;
    StringBuilder tmpShow;
    float a = 0, b = 0, result = 0;
    int codeCal = 0;
    int preCodeCal = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();

        MappingClick();

        tmpA = new StringBuilder();
        tmpShow = new StringBuilder();

        tmpA.append('0');
    }

    private void MappingClick() {
        btnPlusMinus.setOnClickListener(this);
        btnNum0.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnNum1.setOnClickListener(this);
        btnNum2.setOnClickListener(this);
        btnNum3.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnNum4.setOnClickListener(this);
        btnNum5.setOnClickListener(this);
        btnNum6.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnNum7.setOnClickListener(this);
        btnNum8.setOnClickListener(this);
        btnNum9.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnOnePerX.setOnClickListener(this);
        btnSquare.setOnClickListener(this);
        btnSqrt.setOnClickListener(this);
        btnDevide.setOnClickListener(this);
        btnPercent.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnMC.setOnClickListener(this);
        btnMR.setOnClickListener(this);
        btnMPlus.setOnClickListener(this);
        btnMMinus.setOnClickListener(this);
        btnMS.setOnClickListener(this);
        btnM.setOnClickListener(this);

        tvResult.setOnClickListener(this);
        tvShow.setOnClickListener(this);
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
            case R.id.btnNum0:
                tmpA.append('0');
                proccessNum();
                break;
            case R.id.btnNum1:
                tmpA.append('1');
                proccessNum();
                break;
            case R.id.btnNum2:
                tmpA.append('2');
                proccessNum();
                break;
            case R.id.btnNum3:
                tmpA.append('3');
                proccessNum();
                break;
            case R.id.btnNum4:
                tmpA.append('4');
                proccessNum();
                break;
            case R.id.btnNum5:
                tmpA.append('5');
                proccessNum();
                break;
            case R.id.btnNum6:
                tmpA.append('6');
                proccessNum();
                break;
            case R.id.btnNum7:
                tmpA.append('7');
                proccessNum();
                break;
            case R.id.btnNum8:
                tmpA.append('8');
                proccessNum();
                break;
            case R.id.btnNum9:
                tmpA.append('9');
                proccessNum();
                break;
            case R.id.btnPlus:
                codeCal = 1;
                proccessCal();
                break;
            case R.id.btnMinus:
                codeCal = 2;
                proccessCal();
                break;
            case R.id.btnMultiple:
                codeCal = 3;
                proccessCal();
                break;
            case R.id.btnDevide:
                codeCal = 4;
                proccessCal();
                break;
            case R.id.btnDel:
                if(tmpA.length() == 0){
                    tmpA.append("0");
                }else{
                    tmpA.deleteCharAt(tmpA.length() - 1);
                }

                tvShow.setText(tmpA.toString());
                break;
            case R.id.btnC:
                a = b = result = 0;
                tmpA = new StringBuilder();
                tmpA.append("0");
                tmpShow = new StringBuilder();
                type = 0;
                codeCal = 0;
                tvShow.setText(tmpA.toString());
                tvResult.setText("");
                break;
            case R.id.btnCE:
                tmpA = new StringBuilder();
                tmpA.append("0");
                tvShow.setText(tmpA.toString());
                break;
            case R.id.btnEqual:
                proccessEqual();
                break;
            default:
                break;
        }
    }

    private void proccessEqual() {
        a = Integer.parseInt(tmpA.toString());
        tmpA = new StringBuilder();
        tmpShow.append("" + a);
        if(preCodeCal == 1){
            result = a + b;
        }else if(preCodeCal == 2){
            result = b - a;
        }else if(preCodeCal == 3){
            result = b * a;
        }else if(preCodeCal == 4){
            result = b / a;
        }
        tmpShow.append(tmpA.toString() + "=");
        tvResult.setText(tmpShow.toString());
        tvShow.setText("" + result);
    }

    private void proccessCal() {
        if(tmpShow.equals("")){
            tmpShow.append("0");
        }
        if(type == 2){
            if(codeCal == 1){
                tmpShow.setCharAt(tmpShow.length() - 1,'+');
            }
            if(codeCal == 2){
                tmpShow.setCharAt(tmpShow.length() - 1,'-');
            }
            if(codeCal == 3){
                tmpShow.setCharAt(tmpShow.length() - 1,'*');
            }
            if(codeCal == 4){
                tmpShow.setCharAt(tmpShow.length() - 1,'/');
            }
        }
        else{
            a = Integer.parseInt(tmpA.toString());
            tmpA = new StringBuilder();
            tmpShow.append("" + a);
            if(codeCal == 1){
                tmpShow.append("+");
            }
            if(codeCal == 2){
                tmpShow.append("-");
            }
            if(codeCal == 3){
                tmpShow.append("*");
            }
            if(codeCal == 4){
                tmpShow.append("/");
            }
        }
        if(preCodeCal == 1){
            result = a + b;
        }else if(preCodeCal == 2){
            result = a - b;
        }else if(preCodeCal == 3){
            result = b * a;
        }else if(preCodeCal == 4){
            result = b / a;
        }
        b = a;
        preCodeCal = codeCal;
        tvResult.setText(tmpShow);
        type = 2;
    }

    private void proccessNum() {
        if(type != 1){
            int tmp = Integer.parseInt(tmpA.toString());
            tmpA = new StringBuilder();
            tmpA.append(tmp);
        }
        int tm = Integer.parseInt(tmpA.toString());
        tvShow.setText("" + tm);
        type = 1;
    }
}
