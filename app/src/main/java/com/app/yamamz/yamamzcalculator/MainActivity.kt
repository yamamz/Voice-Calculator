package com.app.yamamz.yamamzcalculator

import android.annotation.TargetApi
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SwitchCompat
import android.support.v7.widget.Toolbar
import android.text.Editable
import android.text.Spannable
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.Toast

import java.text.DecimalFormat
import java.util.HashMap
import java.util.Locale

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    private var isBtnEqualClick = false
    private var plusminus: Double = 0.toDouble()
    //declare Button Variables
    private var btn1: Button? = null
    private var btn2: Button? = null
    private var btn3: Button? = null
    private var btn4: Button? = null
    private var btn5: Button? = null
    private var btn6: Button? = null
    private var btn7: Button? = null
    private var btn8: Button? = null
    private var btn9: Button? = null
    private var btn0: Button? = null
    private var btnsqrt: Button? = null
    private var btnPlus: Button? = null
    private var btnMinus: Button? = null
    private var btnDivide: Button? = null
    private var btnMultiply: Button? = null
    private var btnPoint: Button? = null
    private var btnPosNeg: Button? = null
    private var btnCancel: Button? = null
    private var btnTan: Button? = null
    private var btnCos: Button? = null
    private var btnSin: Button? = null
    private var btnEquals: Button? = null
    private var btnPower: Button? = null
    private var btnOpen: Button? = null
    private var btnClose: Button? = null
    private var btnFact: Button? = null
    private var btnMod: Button? = null
    private var btnLog: Button? = null
    private var btnSqr: Button? = null
    private var btnPI: Button? = null
    private var btnDelete: Button? = null
    private var btnPercent: Button? = null
    private var formulaText: TextView? = null
    private var t1: TextToSpeech? = null
    private var playPause1: SwitchCompat? = null
    private var StrToConcat = ""
    private var strLimit: String? = null
    private var StrLim = 0
    private var strAfterDel: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)












        t1 = TextToSpeech(applicationContext, TextToSpeech.OnInitListener { status ->
            if (status != TextToSpeech.ERROR) {
                t1!!.language = Locale.US
                playPause1!!.isChecked = true
            } else {
                playPause1!!.isChecked = false
            }
        })
        playPause1 = findViewById(R.id.toggleButton) as SwitchCompat
        if (playPause1 != null) {
            playPause1!!.setOnCheckedChangeListener(this)
            playPause1!!.isChecked = true
        }


        excuteButtonClick()
        formulaText!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {


            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun afterTextChanged(editable: Editable) {

                if (formulaText!!.text.length >= 15) {
                    formulaText!!.textSize = 25f
                } else {
                    formulaText!!.textSize = 40f
                }
                val str = formulaText!!.text.toString()


                var i = str.length - 1
                while (i >= 0) {
                    if (isOperator(str[i])) {
                        strLimit = str.substring(i + 1, str.length)
                        StrLim = strLimit!!.length
                        strAfterDel = strLimit
                        break
                    } else {
                        strLimit = str
                        StrLim = strLimit!!.length
                        strAfterDel = strLimit
                    }
                    i--
                }
            }
        })

    }

    fun isOperator(str: Char): Boolean {
        return str == 'x' || str == '-' || str == '÷' || str == '+'
    }

    fun excuteButtonClick() {
        btn1 = findViewById(R.id.button1) as Button
        btn2 = findViewById(R.id.button2) as Button
        btn3 = findViewById(R.id.button3) as Button
        btn4 = findViewById(R.id.button4) as Button
        btn5 = findViewById(R.id.button5) as Button
        btn6 = findViewById(R.id.button6) as Button
        btn7 = findViewById(R.id.button7) as Button
        btn8 = findViewById(R.id.button8) as Button
        btn9 = findViewById(R.id.button9) as Button
        btn0 = findViewById(R.id.button0) as Button
        btnsqrt = findViewById(R.id.btnSqrt) as Button
        btnPlus = findViewById(R.id.btnPlus) as Button
        btnMinus = findViewById(R.id.btnMinus) as Button
        btnDivide = findViewById(R.id.btnDivide) as Button
        btnMultiply = findViewById(R.id.btnMultiply) as Button
        btnPoint = findViewById(R.id.btnPoint) as Button
        btnPosNeg = findViewById(R.id.posNeg) as Button
        btnCancel = findViewById(R.id.bntCancel) as Button
        btnTan = findViewById(R.id.btnTan) as Button
        btnCos = findViewById(R.id.btnCos) as Button
        btnSin = findViewById(R.id.bntSin) as Button
        btnEquals = findViewById(R.id.btnEqual) as Button
        btnPower = findViewById(R.id.btnPower) as Button
        formulaText = findViewById(R.id.formula) as TextView
        btnOpen = findViewById(R.id.bntOpen) as Button
        btnClose = findViewById(R.id.btnClose) as Button
        btnFact = findViewById(R.id.btnFactorial) as Button
        btnMod = findViewById(R.id.btnMod) as Button
        btnLog = findViewById(R.id.bntLog) as Button
        btnPI = findViewById(R.id.btnPI) as Button
        btnSqr = findViewById(R.id.btnSquared) as Button
        btnDelete = findViewById(R.id.btnDelete) as Button
        btnPercent = findViewById(R.id.btnPercent) as Button
        btnDelete!!.setOnClickListener {
            if (formulaText!!.text.isNotEmpty()) {
                isBtnEqualClick = false
                formulaText!!.setText(deleteLastChar(formulaText!!.text.toString()), TextView.BufferType.SPANNABLE)
                val str = formulaText!!.text.toString()
                var l = formulaText!!.length() - 1
                while (l >= 0) {
                    if (isOperator(str[l])) {
                        val s = formulaText!!.text as Spannable
                        s.setSpan(ForegroundColorSpan(0xFFFF0000.toInt()), l, l + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    }
                    l--
                }

                StrToConcat = strAfterDel!!

            }
        }



        btnLog!!.setOnClickListener {
            isBtnEqualClick = false
            var lastChar = 'x'
            val formula = formulaText!!.text.toString()
            if (formula.isNotEmpty()) {
                lastChar = formula[formula.length - 1]
            }

            podNegClick = true
            try {
                if (formulaText!!.length() > 0) {
                    if (lastChar == 'x' || lastChar == '÷' || lastChar == '-' || lastChar == '+') {
                        formulaText!!.text = formulaText!!.text.toString().plus(btnLog!!.text.toString().plus("("))
                        val str = formulaText!!.text.toString()
                        var l = formulaText!!.length() - 1

                        //Check each Char and Change color if Operator
                        while (l >= 0) {
                            if (isOperator(str[l])) {
                                val s = formulaText!!.text as Spannable
                                s.setSpan(ForegroundColorSpan(Color.MAGENTA), l, l + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                            }
                            l--
                        }
                        StrToConcat = ""
                        if (isPlay) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                                ttsGreater21("times logarithm of")
                            } else {
                                ttsUnder20("times logarithm of")
                            }
                        }
                    } else {
                        formulaText!!.text = formulaText!!.text.toString().plus("x").plus(btnLog!!.text.toString().plus("("))
                        val str = formulaText!!.text.toString()
                        var l = formulaText!!.length() - 1

                        //Check each Char and Change color if Operator
                        while (l >= 0) {
                            if (isOperator(str[l])) {
                                val s = formulaText!!.text as Spannable
                                s.setSpan(ForegroundColorSpan(0xFFFF0000.toInt()), l, l + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                            }
                            l--
                        }

                        StrToConcat = ""
                        if (isPlay) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                                ttsGreater21("times logarithm of")
                            } else {
                                ttsUnder20("times logarithm of")
                            }
                        }
                    }
                }

            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, e.toString(), Toast.LENGTH_SHORT).show()
            }

            if (formulaText!!.length() <= 0) {

                formulaText!!.append(btnLog!!.text.toString() + "(")

                StrToConcat = ""
                if (isPlay) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        ttsGreater21("logarithm of")
                    } else {
                        ttsUnder20("logarithm of")
                    }
                }

            }
            btnPointClick = false
        }
        btnMod!!.setOnClickListener {
            isBtnEqualClick = false

            podNegClick = true
            if (formulaText!!.text != "") {
                formulaText!!.append(" m ")
                StrToConcat = ""

                if (isPlay) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        ttsGreater21("modulus of")
                    } else {
                        ttsUnder20("modulus of")
                    }
                }
            }

            btnPointClick = false
        }

        btnPI!!.setOnClickListener {
            isBtnEqualClick = false
            val PI: Double = Math.PI

            formulaText!!.append(PI.toString())
            if (isPlay) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    ttsGreater21("pi")
                } else {
                    ttsUnder20("pi")
                }
            }
            if (formulaText!!.length() <= 0) {
                formulaText!!.append(PI.toString())
                if (isPlay) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        ttsGreater21("pi")
                    } else {
                        ttsUnder20("pi")
                    }
                }
            } else {
                formulaText!!.setText(formulaText!!.text.toString().plus(" x ").plus(PI.toString()), TextView.BufferType.SPANNABLE)
                val str = formulaText!!.text.toString()
                var l = formulaText!!.length() - 1


                while (l >= 0) {
                    if (isOperator(str[l])) {
                        val s = formulaText!!.text as Spannable
                        s.setSpan(ForegroundColorSpan(0xFFFF0000.toInt()), l, l + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    }
                    l--
                }

                StrToConcat = ""
                if (isPlay) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        ttsGreater21("times pi")
                    } else {
                        ttsUnder20("times pi")
                    }
                }
            }


        }
        btnSqr!!.setOnClickListener {
            isBtnEqualClick = false
            if (formulaText!!.text == "") {
                formulaText!!.text = StrToConcat.plus("^2")
                if (isPlay) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        ttsGreater21(StrToConcat + "squared")
                    } else {
                        ttsUnder20(StrToConcat + "squared")
                    }
                }

            } else {

                formulaText!!.append("^2")
                if (isPlay) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        ttsGreater21("squared")
                    } else {
                        ttsUnder20("squared")
                    }
                }
            }
            btnPointClick = false
        }

        btnFact!!.setOnClickListener {
            isBtnEqualClick = false
            podNegClick = true

            try {
                if (formulaText!!.text == "") {
                    formulaText!!.text = StrToConcat.plus(btnFact!!.text)
                    if (isPlay) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                            ttsGreater21(StrToConcat + "factorial")
                        } else {
                            ttsUnder20(StrToConcat + "factorial")
                        }
                    }
                } else {
                    formulaText!!.append(btnFact!!.text)
                    StrToConcat = ""

                    if (isPlay) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                            ttsGreater21("factorial")
                        } else {
                            ttsUnder20("factorial")
                        }
                    }
                }
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, e.toString(), Toast.LENGTH_SHORT).show()
            }
            btnPointClick = false
        }

        btnOpen!!.setOnClickListener {
            var lastChar = 'y'
            isBtnEqualClick = false
            val formula = formulaText!!.text.toString()
            if (formula.isNotEmpty()) {
                lastChar = formula[formula.length - 1]
            }
            podNegClick = true
            try {

                if (formulaText!!.length() <= 0) {

                    formulaText!!.append(btnOpen!!.text)
                } else if (lastChar == 'x' || lastChar == '+' || lastChar == '÷' || lastChar == '-') {

                    formulaText!!.append(btnOpen!!.text)

                } else {
                    StrToConcat = ""
                    formulaText!!.setText(formulaText!!.text.toString().plus("x").plus(btnOpen!!.text), TextView.BufferType.SPANNABLE)

                    if (isPlay) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            ttsGreater21("times")
                        } else {
                            ttsUnder20("times")
                        }
                    }
                }
            } catch (e: Exception) {

            }
            btnPointClick = false
        }

        btnClose!!.setOnClickListener {
            podNegClick = true
            isBtnEqualClick = false

            try {


                if (formulaText!!.text == "") {
                    formulaText!!.text = StrToConcat.plus(btnClose!!.text)
                } else {
                    formulaText!!.append(btnClose!!.text)
                }
            } catch (e: Exception) {

                Toast.makeText(this@MainActivity, "Syntax Error",
                        Toast.LENGTH_LONG).show()

            }
            btnPointClick = false
        }
        btnSin!!.setOnClickListener {
            val word: String = formulaText!!.text.toString()
            val lastChar: String
            try {
                if (word.length <= 1) {
                    lastChar = word
                } else {
                    lastChar = word.substring(word.length - 1)
                }


                podNegClick = true
                val lastCharPattern: String=getLastcharPattern(lastChar)

                if (formulaText!!.length() > 0) {

                    if (lastCharPattern=="operator") {
                        formulaText!!.append(btnSin!!.text.toString() + "(")
                        if (isPlay) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                                ttsGreater21("sine")
                            } else {
                                ttsUnder20("sine")
                            }
                        }

                        isBtnEqualClick = false
                    } else if (lastChar.contains("(")) {
                        formulaText!!.append(btnSin!!.text.toString() + "(")
                        if (isPlay) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                                ttsGreater21("sine")
                            } else {
                                ttsUnder20("sine")
                            }
                        }

                        isBtnEqualClick = false


                    } else if (lastCharPattern=="number") {
                        formulaText!!.text = formulaText!!.text.toString().plus("x").plus(btnSin!!.text).plus("(")
                        val str = formulaText!!.text.toString()
                        var l = formulaText!!.length() - 1


                        while (l >= 0) {
                            if (isOperator(str[l])) {
                                val s = formulaText!!.text as Spannable
                                s.setSpan(ForegroundColorSpan(0xFFFF0000.toInt()), l, l + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                            }
                            l--
                        }

                        StrToConcat = ""
                        // displayText.setText("");
                        if (isPlay) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                                ttsGreater21("times sine")
                            } else {
                                ttsUnder20("times sine")
                            }
                        }

                        isBtnEqualClick = false
                    }
                }

            } catch (e: Exception) {
                //This catch block catches all the exceptions
            }



            if (formulaText!!.length() <= 0) {
                formulaText!!.append(btnSin!!.text.toString() + "(")
                if (isPlay) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        ttsGreater21("sine")
                    } else {
                        ttsUnder20("sine")
                    }
                }
            }
            btnPointClick = false
        }

        btnCos!!.setOnClickListener {
            val word = formulaText!!.text.toString()
            val lastChar: String
            try {
                if (word.length <= 1) {
                    lastChar = word
                } else {
                    lastChar = word.substring(word.length - 1)
                }


                podNegClick = true

val lastCharPattern: String=getLastcharPattern(lastChar)
                if (formulaText!!.length() > 0) {
                    if (lastCharPattern=="operator") {
                        formulaText!!.append(btnCos!!.text.toString() + "(")
                        if (isPlay) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                                ttsGreater21("cosine")
                            } else {
                                ttsUnder20("cosine")
                            }
                        }
                        isBtnEqualClick = false
                    } else if (lastCharPattern=="number") {
                        formulaText!!.setText(formulaText!!.text.toString().plus("x").plus(btnCos!!.text).plus("("), TextView.BufferType.SPANNABLE)
                        val str = formulaText!!.text.toString()
                        var l = formulaText!!.length() - 1


                        while (l >= 0) {
                            if (isOperator(str[l])) {
                                val s = formulaText!!.text as Spannable
                                s.setSpan(ForegroundColorSpan(0xFFFF0000.toInt()), l, l + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                            }
                            l--
                        }

                        StrToConcat = ""

                        //displayText.setText("");
                        if (isPlay) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                                ttsGreater21("times cosine")
                            } else {
                                ttsUnder20("times cosine")
                            }
                        }

                        isBtnEqualClick = false
                    }

                }
            } catch (e: Exception) {

            }


            if (formulaText!!.length() <= 0) {
                formulaText!!.text = formulaText!!.text.toString().plus(btnCos!!.text).plus("(")
                if (isPlay) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        ttsGreater21("cosine")
                    } else {
                        ttsUnder20("cosine")
                    }
                }
                isBtnEqualClick = false
            }

            btnPointClick = false
        }

        btnTan!!.setOnClickListener {
            val word = formulaText!!.text.toString()
            val lastChar: String
            try {
                if (word.length <= 1) {
                    lastChar = word
                } else {
                    lastChar = word.substring(word.length - 1)
                }

val lastCharPattern: String=getLastcharPattern(lastChar)
                podNegClick = true
                if (formulaText!!.length() > 0) {
                    if (lastCharPattern=="operator") {
                        formulaText!!.append(btnTan!!.text.toString() + "(")
                        if (isPlay) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                ttsGreater21("tangent")
                            } else {
                                ttsUnder20("tangent")
                            }
                        }
                        isBtnEqualClick = false

                    } else if (lastCharPattern=="number") {
                        formulaText!!.setText(formulaText!!.text.toString().plus("x").plus(btnTan!!.text).plus("("), TextView.BufferType.SPANNABLE)

                        val str = formulaText!!.text.toString()
                        var l = formulaText!!.length() - 1


                        while (l >= 0) {
                            if (isOperator(str[l])) {
                                val s = formulaText!!.text as Spannable
                                s.setSpan(ForegroundColorSpan(0xFFFF0000.toInt()), l, l + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                            }
                            l--
                        }
                        StrToConcat = ""
                        if (isPlay) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                                ttsGreater21("times tangent")
                            } else {
                                ttsUnder20("times tangent")
                            }
                        }
                        isBtnEqualClick = false
                    }
                }

            } catch (e: Exception) {
                //This catch block catches all the exceptions
            }
            // TODO add your handling code here:
            if (formulaText!!.length() <= 0) {
                formulaText!!.text = formulaText!!.text.toString().plus(btnTan!!.text).plus("(")
                if (isPlay) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        ttsGreater21("tangent")
                    } else {
                        ttsUnder20("tangent")
                    }
                }
                isBtnEqualClick = false
            }
            btnPointClick = false
        }

        btnPercent!!.setOnClickListener {
            val word = formulaText!!.text.toString()
            val last3Word: String
            if (word.length <= 1) {
                last3Word = word
            } else {
                last3Word = word.substring(word.length - 1)
            }

            podNegClick = true

            try {


                val lastCharPattern: String=getLastcharPattern(last3Word)
                if (lastCharPattern=="number") {
                    formulaText!!.append(btnPercent!!.text)
                    StrToConcat = ""
                    isBtnEqualClick = false
                    //displayText.setText("");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        ttsGreater21("Percent of")
                    } else {
                        ttsUnder20("Percent of")
                    }
                }
            } catch (e: Exception) {
                //This catch block catches all the exceptions
            }
            btnPointClick = false
        }

        btnPower!!.setOnClickListener {
            val word = formulaText!!.text.toString()
            val last3Word: String
            if (word.length <= 1) {
                last3Word = word
            } else {
                last3Word = word.substring(word.length - 1)
            }

            podNegClick = true

            try {

val lastCharPattern: String=getLastcharPattern(last3Word)
                if (lastCharPattern=="number") {
                    formulaText!!.append(btnPower!!.text)
                    StrToConcat = ""
                    isBtnEqualClick = false
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        ttsGreater21("raise to the power of")
                    } else {
                        ttsUnder20("raise to the power of")
                    }
                }
            } catch (e: Exception) {
                //This catch block catches all the exceptions
            }
            btnPointClick = false
        }
        btn1!!.setOnClickListener {

            StrToConcat = StrToConcat + btn1!!.text
            if (isPlay && StrLim <= 15) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    ttsGreater21(StrToConcat)
                } else {
                    ttsUnder20(StrToConcat)
                }
            }
            if (formulaText!!.text != "0" && StrLim <= 15 && !isBtnEqualClick) {
                formulaText!!.append(btn1!!.text)
            } else if (formulaText!!.text == "0" || isBtnEqualClick) {
                formulaText!!.text = btn1!!.text
                isBtnEqualClick = false
            }

        }

        btn2!!.setOnClickListener {

            StrToConcat = StrToConcat + btn2!!.text
            if (isPlay && StrLim <= 15) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    ttsGreater21(StrToConcat)
                } else {
                    ttsUnder20(StrToConcat)
                }
            }
            if (formulaText!!.text != "0" && StrLim <= 15 && !isBtnEqualClick) {
                formulaText!!.append(btn2!!.text)
            } else if (formulaText!!.text == "0" || isBtnEqualClick) {
                formulaText!!.text = btn2!!.text
                isBtnEqualClick = false
            }


        }

        btnPoint!!.setOnClickListener {
            if (!btnPointClick) {

                if (StrToConcat == "" && formulaText!!.length() <= 0) {

                    StrToConcat = "0" + btnPoint!!.text
                    formulaText!!.setText(String.format("0%s", btnPoint!!.text))
                    if (isPlay) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                            ttsGreater21("zero point")
                        } else {
                            ttsUnder20("zero point")
                        }
                    }
                    btnPointClick = true
                } else {

                    // displayText.setText(displayText.getText() + "" + btnPoint.getText());
                    StrToConcat = StrToConcat + btnPoint!!.text
                    if (isPlay) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                            ttsGreater21("point")
                        } else {
                            ttsUnder20("point")
                        }
                    }
                    formulaText!!.text = formulaText!!.text.toString().plus(btnPoint!!.text)
                    btnPointClick = true
                }
            }
        }

        btnCancel!!.setOnClickListener {


            StrToConcat = ""
            formulaText!!.text = ""
            if (isPlay) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    ttsGreater21("clear")
                } else {
                    ttsUnder20("clear")
                }
            }
            isBtnEqualClick = false
            StrLim = 0

            btnPointClick = false

        }


        btn3!!.setOnClickListener {



            StrToConcat = StrToConcat + btn3!!.text

            if (isPlay && StrLim <= 15) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    ttsGreater21(StrToConcat)
                } else {
                    ttsUnder20(StrToConcat)
                }
            }
            if (formulaText!!.text != "0" && StrLim <= 15 && !isBtnEqualClick) {
                formulaText!!.append(btn3!!.text)
            } else if (formulaText!!.text == "0" || isBtnEqualClick) {
                formulaText!!.text = btn3!!.text
                isBtnEqualClick = false
            }
        }

        btn4!!.setOnClickListener {

            StrToConcat = StrToConcat + btn4!!.text
            if (isPlay && StrLim <= 15) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    ttsGreater21(StrToConcat)
                } else {
                    ttsUnder20(StrToConcat)
                }
            }
            if (formulaText!!.text != "0" && StrLim <= 15 && !isBtnEqualClick) {
                formulaText!!.append(btn4!!.text)
            } else if (formulaText!!.text == "0" || isBtnEqualClick) {
                formulaText!!.text = btn4!!.text
                isBtnEqualClick = false
            }


        }

        btn5!!.setOnClickListener {

            StrToConcat = StrToConcat + btn5!!.text
            if (isPlay && StrLim <= 15) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    ttsGreater21(StrToConcat)
                } else {
                    ttsUnder20(StrToConcat)
                }
            }
            if (formulaText!!.text != "0" && StrLim <= 15 && !isBtnEqualClick) {
                formulaText!!.append(btn5!!.text)
            } else if (formulaText!!.text == "0" || isBtnEqualClick) {
                formulaText!!.text = btn5!!.text
                isBtnEqualClick = false
            }


        }

        btn6!!.setOnClickListener {

            StrToConcat = StrToConcat + btn6!!.text
            if (isPlay && StrLim <= 15) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    ttsGreater21(StrToConcat)
                } else {
                    ttsUnder20(StrToConcat)
                }
            }
            if (formulaText!!.text != "0" && StrLim <= 15 && !isBtnEqualClick) {
                formulaText!!.append(btn6!!.text)
            } else if (formulaText!!.text == "0" || isBtnEqualClick) {
                formulaText!!.text = btn6!!.text
                isBtnEqualClick = false
            }

        }

        btn7!!.setOnClickListener {

            StrToConcat = StrToConcat + btn7!!.text
            if (isPlay && StrLim <= 15) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    ttsGreater21(StrToConcat)
                } else {
                    ttsUnder20(StrToConcat)
                }
            }
            if (formulaText!!.text != "0" && StrLim <= 15 && !isBtnEqualClick) {
                formulaText!!.append(btn7!!.text)
            } else if (formulaText!!.text == "0" || isBtnEqualClick) {
                formulaText!!.text = btn7!!.text
                isBtnEqualClick = false
            }

        }

        btn8!!.setOnClickListener {

            StrToConcat = StrToConcat + btn8!!.text
            if (isPlay && StrLim <= 15) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    ttsGreater21(StrToConcat)
                } else {
                    ttsUnder20(StrToConcat)
                }
            }
            if (formulaText!!.text != "0" && StrLim <= 15 && !isBtnEqualClick) {
                formulaText!!.append(btn8!!.text)
            } else if (formulaText!!.text == "0" || isBtnEqualClick) {
                formulaText!!.text = btn8!!.text
                isBtnEqualClick = false
            }

        }

        btn9!!.setOnClickListener {

            StrToConcat = StrToConcat + btn9!!.text
            if (isPlay && StrLim <= 15) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    ttsGreater21(StrToConcat)
                } else {
                    ttsUnder20(StrToConcat)
                }
            }
            if (formulaText!!.text != "0" && StrLim <= 15 && !isBtnEqualClick) {
                formulaText!!.append(btn9!!.text)
            } else if (formulaText!!.text == "0" || isBtnEqualClick) {
                formulaText!!.text = btn9!!.text
                isBtnEqualClick = false
            }

        }

        btn0!!.setOnClickListener {

            if (formulaText!!.text == "0" || formulaText!!.text == "" || isBtnEqualClick) {
                StrToConcat = ""
                formulaText!!.text = btn0!!.text
                isBtnEqualClick = false
            } else {
                StrToConcat = StrToConcat + btn0!!.text
                formulaText!!.append(btn0!!.text)

            }

            if (isPlay) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ttsGreater21(StrToConcat)
                } else {
                    ttsUnder20(StrToConcat)
                }
            }
        }
        btnPlus!!.setOnClickListener {
            val word = formulaText!!.text.toString()
            val last3Word: String

            if (word.length <= 1) {
                last3Word = word
            } else {
                last3Word = word.substring(word.length - 1)
            }

            val lastCharPattern: String=getLastcharPattern(last3Word)
            if (lastCharPattern=="operator") {
                if (isPlay) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        ttsGreater21("plus")
                    } else {
                        ttsUnder20("plus")
                    }
                }
                val deleteOperator = deleteLastChar(formulaText!!.text.toString())

                formulaText!!.setText(String.format("%s%s", deleteOperator, btnPlus!!.text), TextView.BufferType.SPANNABLE)

                val str = formulaText!!.text.toString()
                var l = formulaText!!.length() - 1


                while (l >= 0) {
                    if (isOperator(str[l])) {
                        val s = formulaText!!.text as Spannable
                        s.setSpan(ForegroundColorSpan(0xFFFF0000.toInt()), l, l + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    }
                    l--
                }

                StrLim = 0

                podNegClick = true
                isBtnEqualClick = false
                StrToConcat = ""

            } else {
                if (formulaText!!.text != "") {
                    if (isPlay) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                            ttsGreater21("plus")
                        } else {
                            ttsUnder20("plus")
                        }
                    }
                    formulaText!!.setText(String.format("%s%s", formulaText!!.text.toString(), btnPlus!!.text.toString()), TextView.BufferType.SPANNABLE)
                    val str = formulaText!!.text.toString()
                    var l = formulaText!!.length() - 1


                    while (l >= 0) {
                        if (isOperator(str[l])) {
                            val s = formulaText!!.text as Spannable
                            s.setSpan(ForegroundColorSpan(0xFFFF0000.toInt()), l, l + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                        }
                        l--
                    }


                    StrLim = 0


                    podNegClick = true
                    StrToConcat = ""
                    isBtnEqualClick = false
                }

            }
            btnPointClick = false
        }

        btnMinus!!.setOnClickListener {
            val word = formulaText!!.text.toString()
            val last3Word: String

            if (word.length <= 1) {
                last3Word = word
            } else {
                last3Word = word.substring(word.length - 1)
            }

            if (last3Word.contains("x") || last3Word.contains("÷") || last3Word.contains("-") || last3Word.contains("+")) {
                if (isPlay) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        ttsGreater21("minus")
                    } else {
                        ttsUnder20("minus")
                    }
                }
                val deleteOperator = deleteLastChar(formulaText!!.text.toString())

                formulaText!!.setText(String.format("%s%s", deleteOperator, btnMinus!!.text), TextView.BufferType.SPANNABLE)

                val str = formulaText!!.text.toString()
                var l = formulaText!!.length() - 1


                while (l >= 0) {
                    if (isOperator(str[l])) {
                        val s = formulaText!!.text as Spannable
                        s.setSpan(ForegroundColorSpan(0xFFFF0000.toInt()), l, l + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    }
                    l--
                }



                podNegClick = true
                isBtnEqualClick = false
                StrToConcat = ""
            } else {
                if (formulaText!!.text != "") {
                    if (isPlay) {

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                            ttsGreater21("minus")
                        } else {
                            ttsUnder20("minus")
                        }
                    }

                    formulaText!!.setText(String.format("%s%s", formulaText!!.text.toString(), btnMinus!!.text.toString()), TextView.BufferType.SPANNABLE)
                    val str = formulaText!!.text.toString()
                    var l = formulaText!!.length() - 1


                    while (l >= 0) {
                        if (isOperator(str[l])) {
                            val s = formulaText!!.text as Spannable
                            s.setSpan(ForegroundColorSpan(0xFFFF0000.toInt()), l, l + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                        }
                        l--
                    }


                    podNegClick = true
                    isBtnEqualClick = false
                    StrToConcat = ""
                }

            }

            btnPointClick = false
        }

        btnDivide!!.setOnClickListener {
            val word = formulaText!!.text.toString()
            val last3Word: String

            if (word.length <= 1) {
                last3Word = word
            } else {
                last3Word = word.substring(word.length - 1)
            }
            val lastWordPattern:String=getLastcharPattern(last3Word)
            if (lastWordPattern == "operator") {
                if (isPlay) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        ttsGreater21("divided by")
                    } else {
                        ttsUnder20("divided by")
                    }
                }

                val deleteOperator = deleteLastChar(formulaText!!.text.toString())

                formulaText!!.setText(String.format("%s%s", deleteOperator, btnDivide!!.text), TextView.BufferType.SPANNABLE)
                val str = formulaText!!.text.toString()
                var l = formulaText!!.length() - 1


                while (l >= 0) {
                    if (isOperator(str[l])) {
                        val s = formulaText!!.text as Spannable
                        s.setSpan(ForegroundColorSpan(0xFFFF0000.toInt()), l, l + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    }
                    l--
                }


                podNegClick = true
                isBtnEqualClick = false
                StrToConcat = ""

            } else {
                if (formulaText!!.text != "") {
                    if (isPlay) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                            ttsGreater21("divided by")
                        } else {
                            ttsUnder20("divided by")
                        }
                    }

                    formulaText!!.setText(String.format("%s%s", formulaText!!.text.toString(), btnDivide!!.text.toString()), TextView.BufferType.SPANNABLE)
                    val str = formulaText!!.text.toString()
                    var l = formulaText!!.length() - 1


                    while (l >= 0) {
                        if (isOperator(str[l])) {
                            val s = formulaText!!.text as Spannable
                            s.setSpan(ForegroundColorSpan(0xFFFF0000.toInt()), l, l + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                        }
                        l--
                    }


                    podNegClick = true
                    isBtnEqualClick = false
                    StrToConcat = ""
                }

            }

            btnPointClick = false
        }

        btnMultiply!!.setOnClickListener {
            val word = formulaText!!.text.toString()
            val last3Word: String

            if (word.length <= 1) {
                last3Word = word
            } else {
                last3Word = word.substring(word.length - 1)
            }
            val lastWordPattern:String=getLastcharPattern(last3Word)
            if (lastWordPattern == "operator"){
                if (isPlay) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        ttsGreater21("times")
                    } else {
                        ttsUnder20("times")
                    }
                }
                val deleteOperator = deleteLastChar(formulaText!!.text.toString())

                formulaText!!.setText(String.format("%s%s", deleteOperator, btnMultiply!!.text), TextView.BufferType.SPANNABLE)
                val str = formulaText!!.text.toString()
                var l = formulaText!!.length() - 1

                while (l >= 0) {
                    if (isOperator(str[l])) {
                        val s = formulaText!!.text as Spannable
                        s.setSpan(ForegroundColorSpan(0xFFFF0000.toInt()), l, l + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    }
                    l--
                }

                podNegClick = true
                isBtnEqualClick = false
                StrToConcat = ""

            } else {
                if (formulaText!!.text != "") {
                    if (isPlay) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                            ttsGreater21("times")
                        } else {
                            ttsUnder20("times")
                        }
                    }
                    formulaText!!.setText(formulaText!!.text.toString().plus(btnMultiply!!.text), TextView.BufferType.SPANNABLE)
                    val str = formulaText!!.text.toString()
                    var l = formulaText!!.length() - 1


                    while (l >= 0) {
                        if (isOperator(str[l])) {
                            val s = formulaText!!.text as Spannable
                            s.setSpan(ForegroundColorSpan(0xFFFF0000.toInt()), l, l + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                        }
                        l--
                    }

                    podNegClick = true
                    isBtnEqualClick = false
                    StrToConcat = ""
                }

            }
            btnPointClick = false
        }


        btnPosNeg!!.setOnClickListener {
            try {
                plusminus = java.lang.Double.parseDouble(StrToConcat)
                if (!podNegClick) {
                    plusminus = plusminus * -1

                    StrToConcat = plusminus.toString()
                    formulaText!!.setText(StrToConcat, TextView.BufferType.SPANNABLE)
                    val str = formulaText!!.text.toString()
                    var l = formulaText!!.length() - 1


                    while (l >= 0) {
                        if (isOperator(str[l])) {
                            val s = formulaText!!.text as Spannable
                            s.setSpan(ForegroundColorSpan(0xFFFF0000.toInt()), l, l + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                        }
                        l--
                    }

                    isBtnEqualClick = false
                }
            } catch (e: Exception) {

                Toast.makeText(this@MainActivity, "input number first", Toast.LENGTH_SHORT).show()
            }
        }

        btnEquals!!.setOnClickListener {
            if (formulaText!!.text.isNotEmpty()) {


                podNegClick = false
                try {

                    val answer = eval(formulaText!!.text.toString())
                    val roundAnswer = Math.round(answer * 1000.0) / 1000.0
                    val df = DecimalFormat("###.####")


                    StrToConcat = df.format(roundAnswer)

                    formulaText!!.text = StrToConcat
                    formulaText!!.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.colorAccent))
                    if (isPlay) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                            ttsGreater21("equals " + formulaText!!.text)
                        } else {
                            ttsUnder20("equals " + formulaText!!.text)
                        }
                    }
                    isBtnEqualClick = true
                    StrToConcat = ""

                } catch (e: Exception) {
                    formulaText!!.text = ""
                    // displayText.setText("");
                    StrToConcat = ""

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        ttsGreater21("syntax error")
                    } else {
                        ttsUnder20("syntax error")
                    }

                    Toast.makeText(this@MainActivity, "Syntax Error",
                            Toast.LENGTH_SHORT).show()


                }

            } else {

                Toast.makeText(this@MainActivity, "No values to calculate", Toast.LENGTH_SHORT).show()
                if (isPlay) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        ttsGreater21("No values to calculate")
                    } else {
                        ttsUnder20("No values to calculate")
                    }
                }
            }

            btnPointClick = false
        }



        btnsqrt!!.setOnClickListener {

            try {

                podNegClick = true

                if (formulaText!!.text == "") {
                    formulaText!!.text = StrToConcat.plus("√")
                    if (isPlay) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            ttsGreater21("squareroot of" + StrToConcat)
                        } else {
                            ttsUnder20("squareroot of" + StrToConcat)
                        }
                    }

                    isBtnEqualClick = false

                } else {
                    formulaText!!.append("√")
                    if (isPlay) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                            ttsGreater21("squareroot of")
                        } else {
                            ttsUnder20("squareroot of")
                        }
                    }
                    isBtnEqualClick = false
                }
            } catch (e: Exception) {


            }

        }

        btnPointClick = false
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    private fun ttsUnder20(text: String) {
        val map = HashMap<String, String>()
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MessageId")
        t1!!.speak(text, TextToSpeech.QUEUE_FLUSH, map)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun ttsGreater21(text: String) {
        val utteranceId = this.hashCode().toString() + ""
        t1!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {

            val builder = AlertDialog.Builder(this, R.style.MyDialogTheme)
            val positiveText = getString(android.R.string.ok)
            builder.setTitle(getString(R.string.dialog_title))
            builder.setMessage(getString(R.string.dialog_message1))
            builder.setPositiveButton(positiveText) { _, _ ->

            }

            val dialog = builder.create()
            dialog.show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    fun getLastcharPattern(lastChar: String): String{
        var ret: String=""
        when(lastChar){
            "x","+","-","÷" -> ret="operator"
           in "0".."9",")" -> ret= "number"
            "sin(","cos(","tan(","mod(","log" -> ret="trigo"
        }
      return ret
    }

    fun deleteLastChar(str: String): String {
        val word = str
        val last3Word: String
        try {
            if (word.length <= 4) {
                last3Word = word
            } else {
                last3Word = word.substring(word.length - 4)
            }
val lastCharPattern: String=getLastcharPattern(last3Word)
            if (lastCharPattern=="trigo") {
                return str.substring(0, str.length - 4)

            } else {
                return str.substring(0, str.length - 1)
            }
        } catch (e: Exception) {
            return word
        }

    }

    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        when (buttonView.id) {
            R.id.toggleButton ->

                isPlay = isChecked

            else -> {
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putBoolean("btnPointClick", btnPointClick)
        outState.putBoolean("podNegClick", podNegClick)
        outState.putString("Display", formulaText!!.text.toString())

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        btnPointClick = savedInstanceState.getBoolean("btnPointClick")
        formulaText!!.text = savedInstanceState.getString("Display")

    }

    companion object {


        private var btnPointClick = false
        private var podNegClick = false
        private var isPlay = true


        private fun eval(str: String): Double {
            return object : Any() {
                internal var pos = -1
                internal var ch: Int = 0

                internal fun nextChar() {

                    ch = if (++pos < str.length) str[pos].toInt() else -1
                }

                internal fun eat(charToEat: Char): Boolean {
                    while (ch.toChar() == ' ') nextChar()
                    if (ch.toChar() == charToEat) {
                        nextChar()
                        return true
                    }
                    return false
                }

                internal fun parse(): Double {
                    nextChar()
                    val x = parseExpression()
                    if (pos < str.length) throw RuntimeException("Unexpected: " + ch.toChar())
                    return x
                }


                internal fun parseExpression(): Double {
                    var x = parseTerm()
                    while (true) {
                        if (eat('+'))
                            x += parseTerm() // addition
                        else if (eat('-'))
                            x -= parseTerm() // subtraction
                        else
                            return x
                    }
                }

                internal fun parseTerm(): Double {
                    var x = parseFactor()
                    while (true) {
                        if (eat('x'))
                            x *= parseFactor() // multiplication
                        else if (eat('÷'))
                            x /= parseFactor() // division
                        else
                            return x
                    }
                }

                internal fun parseFactor(): Double {
                    if (eat('+')) return parseFactor() // unary plus
                    if (eat('-')) return -parseFactor() // unary minus

                    var x: Double
                    val startPos = this.pos
                    if (eat('(')) { // parentheses
                        x = parseExpression()
                        eat(')')
                    } else if (ch.toChar() in '0'..'9' || ch.toChar() == '.') { // numbers
                        while (ch.toChar() in '0'..'9' || ch.toChar() == '.') nextChar()
                        x = java.lang.Double.parseDouble(str.substring(startPos, this.pos))
                    } else if (ch.toChar() in 'a'..'z' || ch.toChar() == '√') { // functions
                        while (ch.toChar() in 'a'..'z' || ch.toChar() == '√') nextChar()
                        val func = str.substring(startPos, this.pos)


                        x = parseFactor()
                        when (func) {
                            "√" -> x = Math.sqrt(x)
                            "sin" -> x = Math.sin(Math.toRadians(x))
                            "cos" -> x = Math.cos(Math.toRadians(x))
                            "tan" -> x = Math.tan(Math.toRadians(x))
                            "log" -> x = Math.log(x)
                            "sqr" -> x = x.square(x)


                        //
                            else -> throw RuntimeException("Unknown function: " + func)
                        }
                    } else {
                        throw RuntimeException("Unexpected: " + ch.toChar())
                    }

                    if (eat('!')) x = factorial(x.toLong()).toDouble()
                    if (eat('^')) x = Math.pow(x, parseFactor())
                    if (eat('%')) x = parseFactor().percent(x)
                    if (eat('m')) x = x.modulus(parseFactor())


                    return x
                }
            }.parse()
        }
    fun Double.percent(double:Double)=this.times(double).div(100)
        fun Double.modulus(value:Double)=this.rem(value)
        fun Double.square(value:Double)=this.times(value)


            fun factorial(n: Long): Long {
                if (n == 0L)
                    return 1
                else
                    return n * factorial(n - 1)
            }


    }


}

