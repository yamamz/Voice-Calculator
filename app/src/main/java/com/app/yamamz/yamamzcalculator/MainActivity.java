package com.app.yamamz.yamamzcalculator;

import android.os.Bundle;
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

    private  TextView displayText;
    private  TextView formulaText;


    double plusminus;


    static boolean btn1Click=false;
    static boolean btn2Click=false;
    static boolean btn3Click=false;
    static boolean btn4Click=false;
    static boolean btn5Click=false;
    static boolean btn6Click=false;
    static boolean btn7Click=false;
    static boolean btn8Click=false;
    static boolean btn9Click=false;
    static boolean btn0Click=false;
    static boolean btnPointClick=false;
    static boolean podNegClick=false;
    static boolean btnSqrtClick=false;
    static boolean btnTanClick=false;
    static boolean btnCosClick=false;
    static boolean btnSinClick=false;
    static boolean btnPowerClick=false;
    static boolean btnOpenClick=false;
    static boolean btnCloseClick=false;
    static boolean btnPlusClick=false;
    static boolean btnMinusClick=false;
    static boolean btnMultiplyClick=false;
    static boolean btnDivideClick=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btn1=(Button) findViewById(R.id.button1);
        btn2=(Button) findViewById(R.id.button2);
    btn3=(Button) findViewById(R.id.button3);
     btn4=(Button) findViewById(R.id.button4);
       btn5=(Button) findViewById(R.id.button5);
        btn6=(Button) findViewById(R.id.button6);
      btn7=(Button) findViewById(R.id.button7);
       btn8=(Button) findViewById(R.id.button8);
         btn9=(Button) findViewById(R.id.button9);
         btn0=(Button) findViewById(R.id.button0);
   btnsqrt=(Button) findViewById(R.id.btnSqrt);
btnPlus=(Button) findViewById(R.id.btnPlus);
        btnMinus=(Button) findViewById(R.id.btnMinus);
        btnDivide=(Button) findViewById(R.id.btnDivide);
       btnMultiply=(Button) findViewById(R.id.btnMultiply);
       btnPoint=(Button) findViewById(R.id.btnPoint);
       btnPosNeg=(Button) findViewById(R.id.posNeg);
        btnCancel=(Button) findViewById(R.id.bntCancel);
       btnTan=(Button) findViewById(R.id.btnTan);
         btnCos=(Button) findViewById(R.id.btnCos);
        btnSin=(Button) findViewById(R.id.bntSin);
      btnEquals=(Button) findViewById(R.id.btnEqual);
       btnPower=(Button) findViewById(R.id.btnPower);
displayText=(TextView) findViewById(R.id.display);
       formulaText=(TextView) findViewById(R.id.formula);
        btnOpen= (Button)  findViewById(R.id.bntOpen);
        btnClose= (Button)  findViewById(R.id.btnClose);

//





excuteButtonClick();




    }

    public void excuteButtonClick(){

      this.runOnUiThread(ButtonClick);

    }

    private Runnable ButtonClick = new Runnable() {
        public void run() {

            btnOpen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        podNegClick = true;

                        try {


                            if (formulaText.getText().equals("")) {
                                formulaText.setText(displayText.getText() + " " + btnOpen.getText() + " ");
                            } else {
                                formulaText.setText(formulaText.getText() + " " + btnOpen.getText() + " ");
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
                            formulaText.setText(displayText.getText()+" "+btnClose.getText()+" ");
                        }
                        else{
                            formulaText.setText(formulaText.getText()+" "+btnClose.getText()+" ");
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
                    if(btnSinClick==false){

                    setfalseButton();
                    podNegClick=true;
                    try {


                        if(formulaText.getText().equals("")){
                            formulaText.setText(displayText.getText()+" "+btnSin.getText()+"(");
                        }
                        else{
                            formulaText.setText(formulaText.getText()+" "+btnSin.getText()+"(");
                        }
                    }
                    catch(Exception e){
                        //This catch block catches all the exceptions
                    }          // TODO add your handling code here:
                }}
            });

            btnCos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(btnCosClick==false){
                        setfalseButton();
                        podNegClick=true;


                    try {


                        if(formulaText.getText().equals("")){
                            formulaText.setText(displayText.getText()+" "+btnCos.getText()+"(");
                        }
                        else{
                            formulaText.setText(formulaText.getText()+" "+btnCos.getText()+"(");
                        }
                    }
                    catch(Exception e){
                        //This catch block catches all the exceptions
                    }          // TODO add your handling code here:
                }}
            });

            btnTan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(btnTanClick==false){
                        setfalseButton();
                        podNegClick=true;

                    try {


                        if(formulaText.getText().equals("")){
                            formulaText.setText(displayText.getText()+" "+btnTan.getText()+"(");
                        }
                        else{
                            formulaText.setText(formulaText.getText()+" "+btnTan.getText()+"(");
                        }
                    }
                    catch(Exception e){
                        //This catch block catches all the exceptions
                    }          // TODO add your handling code here:
                }}
            });

            btnPower.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(btnPowerClick==false){
                        setfalseButton();
                        podNegClick=true;

                    try {


                        if(formulaText.getText().equals("")){
                            formulaText.setText(displayText.getText()+" "+btnPower.getText()+" ");
                        }
                        else{
                            formulaText.setText(formulaText.getText()+" "+btnPower.getText()+" ");
                        }
                    }
                    catch(Exception e){
                        //This catch block catches all the exceptions
                    }          // TODO add your handling code here
                }}
            });
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(btn1Click==false){

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

                    if(btn2Click==false){

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

                    if (btnPointClick == false) {
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

                    if(btn3Click==false){
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

                    if(btn4Click==false){

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

                    if(btn5Click==false){

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

                    if(btn6Click==false){

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

                    if(btn7Click==false){

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

                    if(btn8Click==false){

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

                    if(btn9Click==false){

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

                    if (btnPlusClick == false) {
                        btnPlusClick = true;
                        btnPointClick = false;
                        setFalseBtnTrigonometry();
                        setfalseButton();
                        podNegClick = true;
                        try {


                            if (formulaText.getText().equals("")) {
                                formulaText.setText(displayText.getText() + " " + btnPlus.getText() + " ");
                            } else {
                                formulaText.setText(formulaText.getText() + " " + btnPlus.getText() + " ");
                            }
                        } catch (Exception e) {
                            //This catch block catches all the exceptions
                        }
                        displayText.setText("");

                    }
                }
            });

            btnMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (btnPlusClick == false) {
                        btnPlusClick = true;
                        btnPointClick = false;
                        setFalseBtnTrigonometry();
                        setfalseButton();
                        podNegClick = true;
                        try {


                            if (formulaText.getText().equals("")) {
                                formulaText.setText(displayText.getText() + " " + btnMinus.getText() + " ");
                            } else {
                                formulaText.setText(formulaText.getText() + " " + btnMinus.getText() + " ");
                            }
                        } catch (Exception e) {
                            //This catch block catches all the exceptions
                        }
                        displayText.setText("");
                    }
                }
            });

            btnDivide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btnPlusClick == false) {
                        btnPlusClick = true;
                        btnPointClick = false;
                        setFalseBtnTrigonometry();
                        setfalseButton();
                        podNegClick = true;
                        try {


                            if (formulaText.getText().equals("")) {
                                formulaText.setText(displayText.getText() + " " + btnDivide.getText() + " ");
                            } else {
                                formulaText.setText(formulaText.getText() + " " + btnDivide.getText() + " ");
                            }
                        } catch (Exception e) {
                            //This catch block catches all the exceptions
                        }
                        displayText.setText("");
                    }
                }
            });

            btnMultiply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btnPlusClick == false) {
                        btnPlusClick = true;
                        btnPointClick = false;
                        setFalseBtnTrigonometry();
                        setfalseButton();
                        podNegClick = true;
                        try {


                            if (formulaText.getText().equals("")) {
                                formulaText.setText(displayText.getText() + " " + btnMultiply.getText() + " ");
                            } else {
                                formulaText.setText(formulaText.getText() + " " + btnMultiply.getText() + " ");
                            }
                        } catch (Exception e) {
                            //This catch block catches all the exceptions
                        }
                        displayText.setText("");
                    }
                }
            });


            btnPosNeg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    plusminus=(Double.parseDouble(String.valueOf(displayText.getText())));
                    if(podNegClick==false){
                        plusminus=plusminus*(-1);
                        displayText.setText(String.valueOf(plusminus));
                        formulaText.setText(displayText.getText());

                    }// TODO add your handling code here:
                }
            });

            btnEquals.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setTrueButton();
                    mdasClickfalse();
                    podNegClick=false;
                    try{

                        double answer=eval(String.valueOf(formulaText.getText()));



                        double roundAnswer = Math.round(answer*100.0)/100.0;


                        DecimalFormat df = new DecimalFormat("###.####");


                        displayText.setText(df.format(roundAnswer));
                        formulaText.setText(displayText.getText());
                    }
                    catch (Exception e){
                        setTrueBtnTrigonometry();
                        mdasClickTrue();

                        Toast.makeText(MainActivity.this, "Syntax Error",
                                Toast.LENGTH_LONG).show();

                    }
                }
            });



            btnsqrt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btnSqrtClick == false) {

                        setfalseButton();
                        podNegClick = true;
                        try {


                            if (formulaText.getText().equals("")) {
                                formulaText.setText(displayText.getText() + " " + btnsqrt.getText() + " ");
                            } else {
                                formulaText.setText(formulaText.getText() + " " + btnsqrt.getText() + " ");
                            }
                        } catch (Exception e) {


                        }
                    }
                }
            });
        }

};
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


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
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
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
                    x = parseFactor();
                    if (func.equals("√")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}
