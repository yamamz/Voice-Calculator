package com.app.yamamz.yamamzcalculator;

import android.annotation.TargetApi;
import android.content.DialogInterface;


import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{


    private static boolean btn1Click = false;
    private static boolean btn2Click = false;
    private static boolean btn3Click = false;
    private static boolean btn4Click = false;
    private static boolean btn5Click = false;
    private static boolean btn6Click = false;
    private static boolean btn7Click = false;
    private static boolean btn8Click = false;
    private static boolean btn9Click = false;
    private static boolean btn0Click = false;
    private static boolean btnPointClick = false;
    private static boolean podNegClick = false;
    private static boolean btnSqrtClick = false;
    private static boolean btnTanClick = false;
    private static boolean btnCosClick = false;
    private static boolean btnSinClick = false;
    private static boolean btnPowerClick = false;
    private static boolean btnOpenClick = false;
    private static boolean btnCloseClick = false;
    private static boolean btnPlusClick = false;
    private static boolean btnMinusClick = false;
    private static boolean btnMultiplyClick = false;
    private static boolean btnDivideClick = false;



    private static boolean isPlay=true;
    private double plusminus;
    //declare Button Variables
    private   Button btn1;
    private    Button btn2;
    private Button btn3;
    private   Button btn4;
    private   Button btn5;
    private   Button btn6;
    private Button btn7;
    private  Button btn8;
    private  Button btn9;
    private  Button btn0;
    private  Button btnsqrt;
    private Button btnPlus;
    private  Button btnMinus;
    private Button btnDivide;
    private Button btnMultiply;
    private Button btnPoint;
    private Button btnPosNeg;
    private  Button btnCancel;
    private Button btnTan;
    private  Button btnCos;
    private  Button btnSin;
    private Button btnEquals;
    private Button btnPower;
    private Button btnOpen;
    private Button btnClose;
    private Button btnFact;
    private Button btnMod;
    private Button btnLog;
    private Button btnSqr;
    private Button  btnPI;
    private Button btnDelete;

    private  TextView formulaText;
    private TextToSpeech t1;
    private SwitchCompat playPause1;
    private String StrToConcat="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



//
t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
    @Override
    public void onInit(int status) {

        if(status != TextToSpeech.ERROR) {
            t1.setLanguage(Locale.US);
            playPause1.setChecked(true);
        }

        else {
            playPause1.setChecked(false);
        }

    }
});

        playPause1=(SwitchCompat)findViewById(R.id.toggleButton);
        if (playPause1 != null) {
            playPause1.setOnCheckedChangeListener(this);
            playPause1.setChecked(true);
        }


        excuteButtonClick();


    }

    public void excuteButtonClick() {

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btn0 = (Button) findViewById(R.id.button0);
        btnsqrt = (Button) findViewById(R.id.btnSqrt);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnPoint = (Button) findViewById(R.id.btnPoint);
        btnPosNeg = (Button) findViewById(R.id.posNeg);
        btnCancel = (Button) findViewById(R.id.bntCancel);
        btnTan = (Button) findViewById(R.id.btnTan);
        btnCos = (Button) findViewById(R.id.btnCos);
        btnSin = (Button) findViewById(R.id.bntSin);
        btnEquals = (Button) findViewById(R.id.btnEqual);
        btnPower = (Button) findViewById(R.id.btnPower);
        formulaText = (TextView) findViewById(R.id.formula);
        btnOpen = (Button) findViewById(R.id.bntOpen);
        btnClose = (Button) findViewById(R.id.btnClose);
        btnFact = (Button) findViewById(R.id.btnFactorial);
        btnMod = (Button) findViewById(R.id.btnMod);
        btnLog = (Button) findViewById(R.id.bntLog);
        btnPI = (Button) findViewById(R.id.btnPI);
        btnSqr = (Button) findViewById(R.id.btnSquared);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(formulaText.getText().length()>0){
                    //displayText.setText("");
                    StrToConcat="";
                    formulaText.setText(deleteLastChar((String) formulaText.getText()));
                    setfalseButton();
                }
            }
        });



        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setfalseButton();
                podNegClick=true;
                try {
                    if(formulaText.getText().equals("")){
                        formulaText.setText(btnLog.getText()+"("+StrToConcat);
                        if(isPlay) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                                ttsGreater21("logarithm of" + StrToConcat);
                            } else {
                                ttsUnder20("logarithm of" + StrToConcat);
                            }

                        }
                    }
                    else if (!btnPlusClick){
                        formulaText.setText(formulaText.getText()+"x"+btnLog.getText()+"(");
                        //displayText.setText("");
                        StrToConcat="";
                        if(isPlay) {
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21("times logarithm of");
                            }
                            else{
                                ttsUnder20("times logarithm of");
                            }}
                    }

                    else {
                        formulaText.setText(formulaText.getText()+""+btnLog.getText()+"(");
                        if(isPlay) {
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21("logarithm of");
                            }
                            else{
                                ttsUnder20("logarithm of");
                            }}
                    }
                }
                catch(Exception e){
                    //This catch block catches all the exceptions
                }

            }
        });
        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setfalseButton();
                podNegClick=true;
                if(!formulaText.getText().equals("")){

                    formulaText.setText(formulaText.getText()+"%");
                    StrToConcat="";
                    // displayText.setText("");
                    if(isPlay) {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21("modulus of");
                        }
                        else{
                            ttsUnder20("modulus of");
                        }}
                }


            }
        });

        btnPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double PI;
                PI = Math.PI;
                if (btnPlusClick || btnMinusClick || btnMultiplyClick || btnDivideClick) {

                    setTrueButton();
                    podNegClick = true;
                    mdasClickfalse();
                    setTrueBtnTrigonometry();

                    formulaText.setText(formulaText.getText() + String.valueOf(PI));
                    if(isPlay) {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21("pi");
                        }
                        else{
                            ttsUnder20("pi");
                        }}
                }

                else if(formulaText.getText().equals("")){
                    formulaText.setText(formulaText.getText() + String.valueOf(PI));
                    if(isPlay) {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21("pi");
                        }
                        else{
                            ttsUnder20("pi");
                        }}
                }

                else {

                    formulaText.setText(formulaText.getText()+ " x " + String.valueOf(PI));
                    //  displayText.setText("");
                    StrToConcat="";
                    if(isPlay) {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21("times pi");
                        }
                        else{
                            ttsUnder20("times pi");
                        }}
                }

            }
        });
        btnSqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(formulaText.getText().equals("")){

                    formulaText.setText(StrToConcat+"^2");
                    if(isPlay) {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21(StrToConcat+"squared");
                        }
                        else{
                            ttsUnder20(StrToConcat+"squared");
                        }}

                }

                else{

                    formulaText.setText(formulaText.getText()+"^2");
                    if(isPlay) {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21("squared");
                        }
                        else{
                            ttsUnder20("squared");
                        }}
                }
            }

        });

        btnFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                podNegClick = true;

                try {


                    if (formulaText.getText().equals("")) {
                        formulaText.setText(StrToConcat+"" + btnFact.getText() + "");
                        if(isPlay) {
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21(StrToConcat+"factorial");
                            }
                            else{
                                ttsUnder20(StrToConcat+"factorial");
                            }}
                    } else {
                        formulaText.setText(formulaText.getText() + "" + btnFact.getText() + "");
                        StrToConcat="";
                        // displayText.setText("");
                        if(isPlay) {
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21("factorial");
                            }
                            else{
                                ttsUnder20("factorial");
                            }}
                    }
                } catch (Exception e) {
                    //This catch block catches all the exceptions
                }

            }
        });

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                char lastChar='y';

                String formula=formulaText.getText().toString();
                if (formula.length()!=0) {
                    lastChar = formula.charAt(formula.length() - 1);
                }
                podNegClick = true;
                try {

                    if (formulaText.getText().equals("")) {
                        formulaText.setText(StrToConcat + "" + btnOpen.getText() + "");


                    }

                    else if(lastChar=='x'||lastChar=='+'|| lastChar=='÷'|| lastChar=='-'){

                        formulaText.setText(formulaText.getText() + "" + btnOpen.getText() + "");

                    }

                    else {
                        StrToConcat="";
                        formulaText.setText(formulaText.getText() + "x" + btnOpen.getText
                                () + "");
                        setfalseButton();
                        if(isPlay) {
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21("times");
                            }
                            else{
                                ttsUnder20("times");
                            }}
                    }
                } catch (Exception e) {
                    //This catch block catches all the exceptions
                }        // TODO add your handling code here:
            }


        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                podNegClick=true;

                try {


                    if(formulaText.getText().equals("")){
                        formulaText.setText(StrToConcat+""+btnClose.getText()+"");
                    }
                    else{
                        formulaText.setText(formulaText.getText()+""+btnClose.getText()+"");
                    }
                }
                catch(Exception e){

                    Toast.makeText(MainActivity.this, "Syntax Error",
                            Toast.LENGTH_LONG).show();
                    //This catch block catches all the exceptions
                    // TODO add your handling code here:
                }}
        });
        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String word = formulaText.getText().toString();
                String lastChar;
                try {
                    if (word.length() <= 1) {
                        lastChar = word;
                    } else{
                        lastChar = word.substring(word.length() - 1);
                    }

                    setfalseButton();
                    podNegClick=true;



                    if(lastChar.contains("x")||lastChar.contains("+")||lastChar.contains("÷")||lastChar.contains("-")){
                        formulaText.setText(formulaText.getText()+""+btnSin.getText()+"(");
                        if(isPlay) {
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21("sine");
                            }
                            else{
                                ttsUnder20("sine");
                            }}
                    }
                    else if(formulaText.getText().equals("")||lastChar.contains("(")) {
                        formulaText.setText(formulaText.getText() + "" + btnSin.getText() + "(");
                        if(isPlay) {
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21("sine");
                            }
                            else{
                                ttsUnder20("sine");
                            }}
                    }
                    else if (lastChar.contains("1")||lastChar.contains("2")||lastChar.contains("3")||lastChar.contains("4")||lastChar.contains("5")||lastChar.contains("6")||lastChar.contains("7")||lastChar.contains("8")||lastChar.contains("9")||lastChar.contains("0")||lastChar.contains(")")){
                        formulaText.setText(formulaText.getText() + "x" + btnSin.getText() + "(");
                        StrToConcat="";
                        // displayText.setText("");
                        if(isPlay) {
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21("times sine");
                            }
                            else{
                                ttsUnder20("times sine");
                            }}
                    }


                }
                catch(Exception e){
                    //This catch block catches all the exceptions
                }          // TODO add your handling code here:


            }





        });

        btnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = formulaText.getText().toString();
                String lastChar;
                try {
                    if (word.length() <= 1) {
                        lastChar = word;
                    } else{
                        lastChar = word.substring(word.length() - 1);
                    }

                    setfalseButton();
                    podNegClick=true;



                    if(lastChar.contains("x")||lastChar.contains("+")||lastChar.contains("÷")||lastChar.contains("-")){
                        formulaText.setText(formulaText.getText()+""+btnCos.getText()+"(");
                        if(isPlay) {
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21("cosine");
                            }
                            else{
                                ttsUnder20("cosine");
                            }}
                    }
                    else if(formulaText.getText().equals("")) {
                        formulaText.setText(formulaText.getText() + "" + btnCos.getText() + "(");
                        if(isPlay) {
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21("cosine");
                            }
                            else{
                                ttsUnder20("cosine");
                            }}
                    }
                    else if (lastChar.contains("1")||lastChar.contains("2")||lastChar.contains("3")||lastChar.contains("4")||lastChar.contains("5")||lastChar.contains("6")||lastChar.contains("7")||lastChar.contains("8")||lastChar.contains("9")||lastChar.contains("0")||lastChar.contains(")")){

                        formulaText.setText(formulaText.getText() + "x" + btnCos.getText() + "(");
                        StrToConcat="";

                        //displayText.setText("");
                        if(isPlay) {
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21("times cosine");
                            }
                            else{
                                ttsUnder20("times cosine");
                            }}
                    }


                }
                catch(Exception e){
                    //This catch block catches all the exceptions
                }          // TODO add your handling code here:


            }






        });

        btnTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = formulaText.getText().toString();
                String lastChar;
                try {
                    if (word.length() <= 1) {
                        lastChar = word;
                    } else{
                        lastChar = word.substring(word.length() - 1);
                    }

                    setfalseButton();
                    podNegClick=true;
                    if(lastChar.contains("x")||lastChar.contains("+")||lastChar.contains("÷")||lastChar.contains("-")){
                        formulaText.setText(formulaText.getText()+""+btnTan.getText()+"(");
                        if(isPlay) {
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21("tangent");
                            }
                            else{
                                ttsUnder20("tangent");
                            }}
                    }
                    else if(formulaText.getText().equals("")) {
                        formulaText.setText(formulaText.getText() + "" + btnTan.getText() + "(");
                        if(isPlay) {
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21("tangent");
                            }
                            else{
                                ttsUnder20("tangent");
                            }}

                    }
                    else if (lastChar.contains("1")||lastChar.contains("2")||lastChar.contains("3")||lastChar.contains("4")||lastChar.contains("5")||lastChar.contains("6")||lastChar.contains("7")||lastChar.contains("8")||lastChar.contains("9")||lastChar.contains("0")||lastChar.contains(")")){
                        formulaText.setText(formulaText.getText() + "x" + btnTan.getText() + "(");
                        StrToConcat="";
                        // displayText.setText("");
                        if(isPlay) {
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21("times tangent");
                            }
                            else{
                                ttsUnder20("times tangent");
                            }}

                    }


                }
                catch(Exception e){
                    //This catch block catches all the exceptions
                }          // TODO add your handling code here:


            }





        });

        btnPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String word = formulaText.getText().toString();
                String last3Word;

                if (word.length() <= 1) {
                    last3Word = word;
                } else{
                    last3Word = word.substring(word.length() - 1);
                }

                setfalseButton();
                podNegClick=true;

                try {



                    if(last3Word.contains("1")||last3Word.contains("2")||last3Word.contains("3")||last3Word.contains("4")||last3Word.contains("5")||last3Word.contains("6")||last3Word.contains("7")||last3Word.contains("8")||last3Word.contains("9")||last3Word.contains("0")||last3Word.contains(")")){
                        formulaText.setText(formulaText.getText()+""+btnPower.getText()+"");
                        StrToConcat="";

                        //displayText.setText("");
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21("raise to the power of");
                        }
                        else{
                            ttsUnder20("raise to the power of");
                        }
                    }
                }
                catch(Exception e){
                    //This catch block catches all the exceptions
                }          // TODO add your handling code here
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!btn1Click) {

                    //  displayText.setText(displayText.getText()+""+btn1.getText());
                    StrToConcat=StrToConcat + btn1.getText();
                    if(isPlay) {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21(StrToConcat);
                        }
                        else{
                            ttsUnder20(StrToConcat);
                        }}
                    formulaText.setText(formulaText.getText()+""+btn1.getText());

                    mdasClickfalse();
                    setTrueBtnTrigonometry();

                }


            }





        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!btn2Click) {

                    //  displayText.setText(displayText.getText()+""+btn2.getText());
                    StrToConcat=StrToConcat + btn2.getText();
                    if(isPlay) {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21(StrToConcat);
                        }
                        else{
                            ttsUnder20(StrToConcat);
                        }}
                    formulaText.setText(formulaText.getText()+""+btn2.getText());

                    mdasClickfalse();
                    setTrueBtnTrigonometry();
                }


            }


        });

        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!btnPointClick) {

                    if (StrToConcat.equals("")) {
                        //  displayText.setText("0" + btnPoint.getText());
                        StrToConcat="0" + btnPoint.getText();
                        formulaText.setText("0" + btnPoint.getText());
                        if(isPlay) {
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21("zero point");
                            }
                            else{
                                ttsUnder20("zero point");
                            }}
                        btnPointClick=true;
                    } else {

                        // displayText.setText(displayText.getText() + "" + btnPoint.getText());
                        StrToConcat=StrToConcat + btnPoint.getText();
                        if(isPlay) {
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21("point");
                            }
                            else{
                                ttsUnder20("point");
                            }}
                        formulaText.setText(formulaText.getText() + "" + btnPoint.getText());
                        btnPointClick=true;
                    }
                }                 // TODO add your handling code here:


            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setfalseButton();
                // displayText.setText("");
                StrToConcat="";
                formulaText.setText("");
                if(isPlay) {
                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                        ttsGreater21("clear");
                    }
                    else{
                        ttsUnder20("clear");
                    }}


                mdasClickfalse();
                setFalseBtnTrigonometry();
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!btn3Click){
                    mdasClickfalse();
                    setTrueBtnTrigonometry();

                    //displayText.setText(displayText.getText()+""+btn3.getText());
                    StrToConcat=StrToConcat + btn3.getText();

                    if(isPlay) {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21(StrToConcat);
                        }
                        else{
                            ttsUnder20(StrToConcat);
                        }}
                    formulaText.setText(formulaText.getText()+""+btn3.getText());
                }


            }





        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!btn4Click){

                    // displayText.setText(displayText.getText()+""+btn4.getText());
                    StrToConcat=StrToConcat + btn4.getText();
                    if(isPlay) {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21(StrToConcat);
                        }
                        else{
                            ttsUnder20(StrToConcat);
                        }}
                    formulaText.setText(formulaText.getText()+""+btn4.getText());
                    mdasClickfalse();
                    setTrueBtnTrigonometry();
                }


            }





        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!btn5Click){

                    // displayText.setText(displayText.getText()+""+btn5.getText());
                    StrToConcat=StrToConcat + btn5.getText();
                    if(isPlay) {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21(StrToConcat);
                        }
                        else{
                            ttsUnder20(StrToConcat);
                        }}
                    formulaText.setText(formulaText.getText()+""+btn5.getText());
                    mdasClickfalse();
                    setTrueBtnTrigonometry();
                }


            }





        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!btn6Click){

                    //displayText.setText(displayText.getText()+""+btn6.getText());
                    StrToConcat=StrToConcat + btn6.getText();
                    if(isPlay) {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21(StrToConcat);
                        }
                        else{
                            ttsUnder20(StrToConcat);
                        }}
                    formulaText.setText(formulaText.getText()+""+btn6.getText());
                    mdasClickfalse();
                    setTrueBtnTrigonometry();
                }


            }





        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!btn7Click){

                    // displayText.setText(displayText.getText()+""+btn7.getText());
                    StrToConcat=StrToConcat + btn7.getText();
                    if(isPlay) {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21(StrToConcat);
                        }
                        else{
                            ttsUnder20(StrToConcat);
                        }}
                    formulaText.setText(formulaText.getText()+""+btn7.getText());
                    mdasClickfalse();
                    setTrueBtnTrigonometry();
                }


            }





        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!btn8Click){

                    // displayText.setText(displayText.getText()+""+btn8.getText());
                    StrToConcat=StrToConcat + btn8.getText();
                    if(isPlay) {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21(StrToConcat);
                        }
                        else{
                            ttsUnder20(StrToConcat);
                        }}
                    formulaText.setText(formulaText.getText()+""+btn8.getText());
                    mdasClickfalse();
                    setTrueBtnTrigonometry();
                }


            }





        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!btn9Click){

                    //  displayText.setText(displayText.getText()+""+btn9.getText());
                    StrToConcat=StrToConcat + btn9.getText();
                    if(isPlay) {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21(StrToConcat);
                        }
                        else{
                            ttsUnder20(StrToConcat);
                        }}
                    formulaText.setText(formulaText.getText()+""+btn9.getText());
                    mdasClickfalse();
                    setTrueBtnTrigonometry();
                }


            }





        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!btn0Click){

                    //  displayText.setText(displayText.getText()+""+btn0.getText());
                    StrToConcat=StrToConcat + btn0.getText();
                    if(isPlay) {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21(StrToConcat);
                        }
                        else{
                            ttsUnder20(StrToConcat);
                        }}
                    formulaText.setText(formulaText.getText()+""+btn0.getText());
                    mdasClickfalse();
                    setTrueBtnTrigonometry();
                }


            }





        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String word = formulaText.getText().toString();
                String last3Word;

                if (word.length() <= 1) {
                    last3Word = word;
                } else{
                    last3Word = word.substring(word.length() - 1);
                }

                if(last3Word.contains("x")||last3Word.contains("÷")||last3Word.contains("-")||last3Word.contains("+")){
                    if(isPlay) {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21("plus");
                        }
                        else{
                            ttsUnder20("plus");
                        }}
                    String deleteOperator=deleteLastChar((String) formulaText.getText());

                    formulaText.setText(String.format("%s%s", deleteOperator, btnPlus.getText()));
                    setFalseBtnTrigonometry();
                    setfalseButton();
                    podNegClick = true;
                    // displayText.setText("");
                    StrToConcat="";

                }
                else{
                    if(!formulaText.getText().equals("")){
                        if(isPlay) {
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21("plus");
                            }
                            else{
                                ttsUnder20("plus");
                            }}
                        formulaText.setText(formulaText.getText()+""+btnPlus.getText());

                        setFalseBtnTrigonometry();
                        setfalseButton();
                        podNegClick = true;
                        StrToConcat="";
                        // displayText.setText("");
                    }

                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String word = formulaText.getText().toString();
                String last3Word;

                if (word.length() <= 1) {
                    last3Word = word;
                } else{
                    last3Word = word.substring(word.length() - 1);
                }

                if(last3Word.contains("x")||last3Word.contains("÷")||last3Word.contains("-")||last3Word.contains("+")){
                    if(isPlay) {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21("minus");
                        }
                        else{
                            ttsUnder20("minus");
                        }}
                    String deleteOperator=deleteLastChar((String) formulaText.getText());

                    formulaText.setText(String.format("%s%s", deleteOperator, btnMinus.getText()));
                    setFalseBtnTrigonometry();
                    setfalseButton();
                    podNegClick = true;
                    // displayText.setText("");
                    StrToConcat="";
                }
                else{
                    if(!formulaText.getText().equals("")){
                        if(isPlay) {

                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21("minus");
                            }
                            else{
                                ttsUnder20("minus");
                            }}

                        formulaText.setText(formulaText.getText()+""+btnMinus.getText());

                        setFalseBtnTrigonometry();
                        setfalseButton();
                        podNegClick = true;
                        // displayText.setText("");
                        StrToConcat="";
                    }

                }
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String word = formulaText.getText().toString();
                String last3Word;

                if (word.length() <= 1) {
                    last3Word = word;
                } else{
                    last3Word = word.substring(word.length() - 1);
                }

                if(last3Word.contains("x")||last3Word.contains("÷")||last3Word.contains("-")||last3Word.contains("+")){
                    if(isPlay) {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21("divided by");
                        }
                        else{
                            ttsUnder20("divided by");
                        }}

                    String deleteOperator=deleteLastChar((String) formulaText.getText());

                    formulaText.setText(String.format("%s%s", deleteOperator, btnDivide.getText()));
                    setFalseBtnTrigonometry();
                    setfalseButton();
                    podNegClick = true;
                    //  displayText.setText("");
                    StrToConcat="";

                }
                else{
                    if(!formulaText.getText().equals("")){
                        if(isPlay) {
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21("divided by");
                            }
                            else{
                                ttsUnder20("divided by");
                            }}

                        formulaText.setText(formulaText.getText()+""+btnDivide.getText());

                        setFalseBtnTrigonometry();
                        setfalseButton();
                        podNegClick = true;
                        // displayText.setText("");
                        StrToConcat="";
                    }

                }
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String word = formulaText.getText().toString();
                String last3Word;

                if (word.length() <= 1) {
                    last3Word = word;
                } else{
                    last3Word = word.substring(word.length() - 1);
                }

                if(last3Word.contains("x")||last3Word.contains("÷")||last3Word.contains("-")||last3Word.contains("+")){
                    if(isPlay) {
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21("times");
                        }
                        else{
                            ttsUnder20("times");
                        }}
                    String deleteOperator=deleteLastChar((String) formulaText.getText());

                    formulaText.setText(String.format("%s%s", deleteOperator, btnMultiply.getText()));
                    setFalseBtnTrigonometry();
                    setfalseButton();
                    podNegClick = true;
                    // displayText.setText("");
                    StrToConcat="";

                }
                else{
                    if(!formulaText.getText().equals("")){
                        if(isPlay) {
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21("times");
                            }
                            else{
                                ttsUnder20("times");
                            }}
                        formulaText.setText(formulaText.getText()+""+btnMultiply.getText());

                        setFalseBtnTrigonometry();
                        setfalseButton();
                        podNegClick = true;
                        // displayText.setText("");
                        StrToConcat="";
                    }

                }

            }
        });


        btnPosNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    plusminus=(Double.parseDouble(String.valueOf(StrToConcat)));
                    if(!podNegClick){
                        plusminus=plusminus*(-1);
                        // displayText.setText(String.valueOf(plusminus));
                        StrToConcat=String.valueOf(plusminus);
                        formulaText.setText(StrToConcat);

                    }// TODO add your handling code here:
                }
                catch (Exception e){

                    Toast.makeText(MainActivity.this,"input number first",Toast.LENGTH_SHORT).show();
                }

            }

        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(formulaText.getText().length()>0){
                    setTrueButton();
                    mdasClickfalse();

                    podNegClick = false;
                    try {

                        double answer = eval(String.valueOf(formulaText.getText()));


                        double roundAnswer = Math.round(answer * 1000.0) / 1000.0;


                        DecimalFormat df = new DecimalFormat("###.##");


                        StrToConcat=(df.format(roundAnswer));

                        formulaText.setText(StrToConcat);
                        if(isPlay) {
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                ttsGreater21("equals "+formulaText.getText());
                            }
                            else{
                                ttsUnder20("equals "+formulaText.getText());
                            }}


                    } catch (Exception e) {
                        formulaText.setText("");
                        // displayText.setText("");
                        StrToConcat="";
                        setFalseBtnTrigonometry();
                        mdasClickTrue();
                        setfalseButton();
                        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                            ttsGreater21("syntax error");
                        }
                        else{
                            ttsUnder20("syntax error");
                        }

                        Toast.makeText(MainActivity.this, "Syntax Error",
                                Toast.LENGTH_SHORT).show();



                    }
                }
                else {

                    Toast.makeText(MainActivity.this,"No values to calculate",Toast.LENGTH_SHORT).show();
                    if(isPlay) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                            ttsGreater21("No values to calculate");
                        } else {
                            ttsUnder20("No values to calculate");
                        }
                    }
                }

            }
        });



        btnsqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!btnSqrtClick) {


                    try {
                        setfalseButton();
                        podNegClick = true;

                        if (formulaText.getText().equals("")) {
                            formulaText.setText(StrToConcat + "" +"√"+"");
                            if(isPlay) {
                                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                    ttsGreater21("squareroot of"+StrToConcat);
                                }
                                else{
                                    ttsUnder20("squareroot of"+StrToConcat);
                                }}

                        } else {
                            formulaText.setText(formulaText.getText() + "" +"√"+"");
                            if(isPlay) {
                                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                                    ttsGreater21("squareroot of");
                                }
                                else{
                                    ttsUnder20("squareroot of");
                                }}
                        }
                    } catch (Exception e) {


                    }
                }
            }
        });

    }





    private static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {

                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }


            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('x')) x *= parseFactor(); // multiplication
                    else if (eat('÷')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z'|| ch=='√') { // functions
                    while (ch >= 'a' && ch <= 'z'||ch=='√') nextChar();
                    String func = str.substring(startPos, this.pos);

                    Square square = new Square();
                    x = parseFactor();
                    switch (func) {
                        case "√":
                            x = Math.sqrt(x);
                            break;
                        case "sin":
                            x = Math.sin(Math.toRadians(x));
                            break;
                        case "cos":
                            x = Math.cos(Math.toRadians(x));
                            break;
                        case "tan":
                            x = Math.tan(Math.toRadians(x));
                            break;
                        case "log":
                            x = Math.log(x);
                            break;
                        case "sqr":
                            x = square.Square(x);
                            break;


//
                        default:
                            throw new RuntimeException("Unknown function: " + func);
                    }
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }
                Modulus modulus = new Modulus();
                Factorial factorialExample2 = new Factorial();
                if (eat('!')) x = factorialExample2.factorial(x);
                if (eat('^')) x = Math.pow(x, parseFactor());
                if (eat('%')) x = modulus.Modulus(x, parseFactor());
                // exponentiation
                return x;
            }
        }.parse();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void mdasClickTrue(){
        btnCloseClick=true;
        btnPlusClick=true;
        btnMinusClick=true;
        btnMultiplyClick=true;
        btnDivideClick=true;


    }

    public void mdasClickfalse(){
        btnCloseClick=true;
        btnPlusClick=false;
        btnMinusClick=false;
        btnMultiplyClick=false;
        btnDivideClick=false;


    }

    public void setTrueBtnTrigonometry(){

        btnSqrtClick=true;
        btnTanClick=true;
        btnCosClick=true;
        btnSinClick=true;
        btnPowerClick=true;



    }

    public void setFalseBtnTrigonometry(){

        btnSqrtClick=false;
        btnTanClick=false;
        btnCosClick=false;
        btnSinClick=false;
        btnPowerClick=false;


    }

    public void setfalseButton(){

        btn1Click=false;
        btn2Click=false;
        btn3Click=false;
        btn4Click=false;
        btn5Click=false;
        btn6Click=false;
        btn7Click=false;
        btn8Click=false;
        btn9Click=false;
        btn0Click=false;
        btnPointClick=false;

    }

    public void setTrueButton(){

        btn1Click=true;
        btn2Click=true;
        btn3Click=true;
        btn4Click=true;
        btn5Click=true;
        btn6Click=true;
        btn7Click=true;
        btn8Click=true;
        btn9Click=true;
        btn0Click=true;
        btnPointClick=true;

    }

    @SuppressWarnings("deprecation")
    private void ttsUnder20(String text){
        HashMap<String,String> map=new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID,"MessageId");
        t1.speak(text,TextToSpeech.QUEUE_FLUSH,map);
    }

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
private void ttsGreater21(String text){
    String utteranceId=this.hashCode()+"";
    t1.speak(text,TextToSpeech.QUEUE_FLUSH,null,utteranceId);
}


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MyDialogTheme);
            String positiveText = getString(android.R.string.ok);
            builder.setTitle(getString(R.string.dialog_title));

            builder.setMessage(getString(R.string.dialog_message1));


            builder.setPositiveButton(positiveText,new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // positive button logic
                } });

            AlertDialog dialog = builder.create();
// display dialog
            dialog.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

public  String deleteLastChar(String str) {
    String word = str;
    String last3Word;
    try {
        if (word.length() <= 4) {
            last3Word = word;
        } else{
            last3Word = word.substring(word.length() - 4);
        }

        if (last3Word.contains("sin(") || last3Word.contains("cos(") || last3Word.contains("tan(") || last3Word.contains("mod(") || last3Word.contains("log(")) {
            return str.substring(0, str.length() - 4);

        } else {
            return str.substring(0, str.length() - 1);
        }
    } catch (Exception e) {
return word;
    }
}

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.toggleButton:

                if(!isChecked){

                    isPlay=false;
                }
                else{

                    isPlay=true;
                }

                break;

            default:
                break;
        }
    }


    public static class Square{
        public double Square(double x){

            return x * x;

        }

    }
public static class Modulus{
    public double Modulus(double x, double y){

    return  x % y;

    }

}
    public static class Factorial{
        public double factorial(double n){
            if (n == 0)
                return 1;
            else
                return(n * factorial(n-1));
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setFalseBtnTrigonometry();
        mdasClickfalse();
        setfalseButton();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("btn1Click",btn1Click);
        outState.putBoolean("btn0Click",btn0Click);
        outState.putBoolean("btn2Click",btn2Click);
        outState.putBoolean("btn3Click",btn3Click);
        outState.putBoolean("btn4Click",btn4Click);
        outState.putBoolean("btn5Click",btn5Click);
        outState.putBoolean("btn6Click",btn6Click);
        outState.putBoolean("btn7Click",btn7Click);
        outState.putBoolean("btn8Click",btn8Click);
        outState.putBoolean("btn9Click",btn9Click);
        outState.putBoolean("btnPointClick",btnPointClick);
        outState.putBoolean("podNegClick",podNegClick);
        outState.putBoolean("btnSqrtClick",btnSinClick);
        outState.putBoolean("btnTanClick",btnTanClick);
        outState.putBoolean("btnCosClick",btnCosClick);
        outState.putBoolean("btnSinClick",btnSinClick);
        outState.putBoolean("btnPowerClick",btnPowerClick);
        outState.putBoolean(" btnOpenClick",btnOpenClick);
        outState.putBoolean("btnCloseClick",btnCloseClick);
        outState.putBoolean("btnPlusClick",btnPlusClick);
        outState.putBoolean(" btnMinusClick",btnMinusClick);
        outState.putBoolean("btnMultiplyClick",btnMultiplyClick);
        outState.putBoolean("btnDivideClick",btnDivideClick);
        outState.putString("Display",formulaText.getText().toString());
        Toast.makeText(this,"test1",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        btn1Click =savedInstanceState.getBoolean("btn1Click");
        btn2Click = savedInstanceState.getBoolean("btn2Click");
        btn3Click = savedInstanceState.getBoolean("btn3Click");
        btn4Click = savedInstanceState.getBoolean("btn4Click");
        btn5Click = savedInstanceState.getBoolean("btn5Click");
        btn6Click = savedInstanceState.getBoolean("btn6Click");
        btn7Click = savedInstanceState.getBoolean("btn7Click");
        btn8Click = savedInstanceState.getBoolean("btn8Click");
        btn9Click = savedInstanceState.getBoolean("btn9Click");
        btn0Click = savedInstanceState.getBoolean("btn0Click");
        btnPointClick = savedInstanceState.getBoolean("btnPointClick");
        podNegClick = savedInstanceState.getBoolean("podNegClick");
        btnSqrtClick =savedInstanceState.getBoolean(" btnSqrtClick");
        btnTanClick = savedInstanceState.getBoolean("btnTanClick");
        btnCosClick = savedInstanceState.getBoolean(" btnCosClick");
        btnSinClick = savedInstanceState.getBoolean(" btnSinClick");
        btnPowerClick = savedInstanceState.getBoolean("btnPowerClick");
        btnOpenClick = savedInstanceState.getBoolean("btnOpenClick");
        btnCloseClick = savedInstanceState.getBoolean(" btnCloseClick");
        btnPlusClick = savedInstanceState.getBoolean("btnPlusClick");
        btnMinusClick = savedInstanceState.getBoolean(" btnMinusClick");
        btnMultiplyClick = savedInstanceState.getBoolean("btnMultiplyClick");
        btnDivideClick = savedInstanceState.getBoolean(" btnDivideClick ");
        formulaText.setText(savedInstanceState.getString("Display"));
        Toast.makeText(this,"test",Toast.LENGTH_SHORT).show();
    }


}

