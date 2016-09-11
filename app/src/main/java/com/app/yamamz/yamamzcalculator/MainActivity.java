package com.app.yamamz.yamamzcalculator;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


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
    double plusminus;
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
    private  TextView displayText;
    private  TextView formulaText;
    private Runnable ButtonClick = new Runnable() {
        public void run() {


      btnDelete.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            if(formulaText.getText().length()>0){
                displayText.setText("");
             formulaText.setText(deleteLastChar((String) formulaText.getText()));
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
                            formulaText.setText(btnLog.getText()+"("+displayText.getText());
                        }
                        else if (!btnPlusClick){
                            formulaText.setText(formulaText.getText()+"x"+btnLog.getText()+"(");
                        }

                        else {
                            formulaText.setText(formulaText.getText()+""+btnLog.getText()+"(");
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
                    }

                    else if(formulaText.getText().equals("")){
                        formulaText.setText(formulaText.getText() + String.valueOf(PI));

                    }

                    else {

                        formulaText.setText(formulaText.getText()+ "x" + String.valueOf(PI));
                    }

                }
            });
            btnSqr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(formulaText.getText().equals("")){

                        formulaText.setText(displayText.getText()+"^2");

                    }

                    else{

                        formulaText.setText(formulaText.getText()+"^2");
                    }
                    }

            });

            btnFact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    podNegClick = true;

                    try {


                        if (formulaText.getText().equals("")) {
                            formulaText.setText(displayText.getText()+"" + btnFact.getText() + "");
                        } else {
                            formulaText.setText(formulaText.getText() + "" + btnFact.getText() + "");
                        }
                    } catch (Exception e) {
                        //This catch block catches all the exceptions
                    }

                }
            });

            btnOpen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        podNegClick = true;

                        try {


                            if (formulaText.getText().equals("")) {
                                formulaText.setText(displayText.getText() + "" + btnOpen.getText() + "");
                            } else {
                                formulaText.setText(formulaText.getText() + "" + btnOpen.getText() + "");
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
                            formulaText.setText(displayText.getText()+""+btnClose.getText()+"");
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


                    setfalseButton();
                    podNegClick=true;
                    try {


                        if(formulaText.getText().equals("")){
                            formulaText.setText(displayText.getText()+""+btnSin.getText()+"(");
                        }
                        else if(btnPlusClick) {
                                formulaText.setText(formulaText.getText() + "" + btnSin.getText() + "(");
                            }
                         else   if(!btnPlusClick){
                                formulaText.setText(formulaText.getText() + "x" + btnSin.getText() + "(");
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
                    setfalseButton();
                    podNegClick=true;
                    try {


                        if(formulaText.getText().equals("")){
                            formulaText.setText(displayText.getText()+""+btnCos.getText()+"(");
                        }
                        else if(btnPlusClick) {
                            formulaText.setText(formulaText.getText() + "" + btnCos.getText() + "(");
                        }
                        else   if(!btnPlusClick){
                            formulaText.setText(formulaText.getText() + "x" + btnCos.getText() + "(");
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

                    setfalseButton();
                    podNegClick=true;
                    try {


                        if(formulaText.getText().equals("")){
                            formulaText.setText(displayText.getText()+""+btnTan.getText()+"(");
                        }
                        else if(btnPlusClick) {
                            formulaText.setText(formulaText.getText() + "" + btnTan.getText() + "(");
                        }
                        else   if(!btnPlusClick){
                            formulaText.setText(formulaText.getText() + "x" + btnTan.getText() + "(");
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

                        setfalseButton();
                        podNegClick=true;

                    try {


                        if(formulaText.getText().equals("")){
                            formulaText.setText(displayText.getText()+""+btnPower.getText()+"");
                        }
                        else{
                            formulaText.setText(formulaText.getText()+""+btnPower.getText()+"");
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

                        displayText.setText(displayText.getText()+""+btn1.getText());
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

                        displayText.setText(displayText.getText()+""+btn2.getText());
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
                        if (displayText.getText().equals("")) {
                            displayText.setText("0" + btnPoint.getText());
                            formulaText.setText("0" + btnPoint.getText());
                            btnPointClick=true;
                        } else {
                            displayText.setText(displayText.getText() + "" + btnPoint.getText());
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
                    displayText.setText("");
                    formulaText.setText("");



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

                        displayText.setText(displayText.getText()+""+btn3.getText());
                        formulaText.setText(formulaText.getText()+""+btn3.getText());
                    }


                }





            });

            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(!btn4Click){

                        displayText.setText(displayText.getText()+""+btn4.getText());
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

                        displayText.setText(displayText.getText()+""+btn5.getText());
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

                        displayText.setText(displayText.getText()+""+btn6.getText());
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

                        displayText.setText(displayText.getText()+""+btn7.getText());
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

                        displayText.setText(displayText.getText()+""+btn8.getText());
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

                        displayText.setText(displayText.getText()+""+btn9.getText());
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

                        displayText.setText(displayText.getText()+""+btn0.getText());
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

                        if(last3Word.contains("x")||last3Word.contains("/")||last3Word.contains("-")||last3Word.contains("+")){

                            String deleteOperator=deleteLastChar((String) formulaText.getText());

                            formulaText.setText(deleteOperator+btnPlus.getText());
                            setFalseBtnTrigonometry();
                            setfalseButton();
                            podNegClick = true;
                            displayText.setText("");

                        }
                    else{
                            if(!formulaText.getText().equals("")){

                                formulaText.setText(formulaText.getText()+""+btnPlus.getText());

                                setFalseBtnTrigonometry();
                                setfalseButton();
                                podNegClick = true;
                                displayText.setText("");
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

                    if(last3Word.contains("x")||last3Word.contains("/")||last3Word.contains("-")||last3Word.contains("+")){

                        String deleteOperator=deleteLastChar((String) formulaText.getText());

                        formulaText.setText(deleteOperator+btnMinus.getText());
                        setFalseBtnTrigonometry();
                        setfalseButton();
                        podNegClick = true;
                        displayText.setText("");

                    }
                    else{
                        if(!formulaText.getText().equals("")){

                            formulaText.setText(formulaText.getText()+""+btnMinus.getText());

                            setFalseBtnTrigonometry();
                            setfalseButton();
                            podNegClick = true;
                            displayText.setText("");
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

                    if(last3Word.contains("x")||last3Word.contains("/")||last3Word.contains("-")||last3Word.contains("+")){

                        String deleteOperator=deleteLastChar((String) formulaText.getText());

                        formulaText.setText(deleteOperator+btnDivide.getText());
                        setFalseBtnTrigonometry();
                        setfalseButton();
                        podNegClick = true;
                        displayText.setText("");

                    }
                    else{
                        if(!formulaText.getText().equals("")){

                            formulaText.setText(formulaText.getText()+""+btnDivide.getText());

                            setFalseBtnTrigonometry();
                            setfalseButton();
                            podNegClick = true;
                            displayText.setText("");
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

                    if(last3Word.contains("x")||last3Word.contains("/")||last3Word.contains("-")||last3Word.contains("+")){

                        String deleteOperator=deleteLastChar((String) formulaText.getText());

                        formulaText.setText(deleteOperator+btnMultiply.getText());
                        setFalseBtnTrigonometry();
                        setfalseButton();
                        podNegClick = true;
                        displayText.setText("");

                    }
                    else{
                        if(!formulaText.getText().equals("")){

                            formulaText.setText(formulaText.getText()+""+btnMultiply.getText());

                            setFalseBtnTrigonometry();
                            setfalseButton();
                            podNegClick = true;
                            displayText.setText("");
                        }

                    }
                }
            });


            btnPosNeg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                    plusminus=(Double.parseDouble(String.valueOf(displayText.getText())));
                    if(!podNegClick){
                        plusminus=plusminus*(-1);
                        displayText.setText(String.valueOf(plusminus));
                        formulaText.setText(displayText.getText());

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


                            double roundAnswer = Math.round(answer * 10000.0) / 10000.0;


                            DecimalFormat df = new DecimalFormat("###.####");


                            displayText.setText(df.format(roundAnswer));
                            formulaText.setTextColor(getResources().getColor(R.color.colorPressMDAS));
                            formulaText.setText(displayText.getText());

                        } catch (Exception e) {
                            formulaText.setText("");
                            displayText.setText("");
                            setFalseBtnTrigonometry();
                            mdasClickTrue();
                            setfalseButton();

                            Toast.makeText(MainActivity.this, "Syntax Error",
                                    Toast.LENGTH_SHORT).show();

                    }
                }
                else {

                    Toast.makeText(MainActivity.this,"No values to calculate",Toast.LENGTH_SHORT).show();
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
                                formulaText.setText(displayText.getText() + "" +"sqrt"+"(");
                            } else {
                                formulaText.setText(formulaText.getText() + "" +"sqrt"+"(");
                            }
                        } catch (Exception e) {


                        }
                    }
                }
            });
        }

};

    public static double eval(final String str) {
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

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

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
                    else if (eat('/')) x /= parseFactor(); // division
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
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);

                    Square square = new Square();
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else if (func.equals("log")) x = Math.log(x);
                    else if (func.equals("sqr")) x = square.Square(x);


//
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }
                Modulus modulus = new Modulus();
                FactorialExample2 factorialExample2 = new FactorialExample2();
                if (eat('!')) x = factorialExample2.factorial(x);
                if (eat('^')) x = Math.pow(x, parseFactor());
                if (eat('%')) x = modulus.Modulus(x, parseFactor());
                // exponentiation
                return x;
            }
        }.parse();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
        displayText = (TextView) findViewById(R.id.display);
        formulaText = (TextView) findViewById(R.id.formula);
        btnOpen = (Button) findViewById(R.id.bntOpen);
        btnClose = (Button) findViewById(R.id.btnClose);
        btnFact = (Button) findViewById(R.id.btnFactorial);
        btnMod = (Button) findViewById(R.id.btnMod);
        btnLog = (Button) findViewById(R.id.bntLog);
        btnPI = (Button) findViewById(R.id.btnPI);
        btnSqr = (Button) findViewById(R.id.btnSquared);
        btnDelete = (Button) findViewById(R.id.btnDelete);


//


        excuteButtonClick();


    }

    public void excuteButtonClick() {

        this.runOnUiThread(ButtonClick);

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
    public  String ReplaceLastChar(String str) {

                return str.substring(0, str.length() - 1);

    }


    public static class Square{
        public double Square(double x){

            return x * x;

        }

    }
public static class Modulus{
    public double Modulus(double x, double y){

        return x % y;

    }

}
    public static class FactorialExample2{
        public double factorial(double n){
            if (n == 0)
                return 1;
            else
                return(n * factorial(n-1));
        }

    }

}

