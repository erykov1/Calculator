package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        TextView text = findViewById(R.id.input);
        super.onSaveInstanceState(outState);
        outState.putString("KEY RESULT", text.getText().toString());
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        TextView text = findViewById(R.id.input);
        super.onRestoreInstanceState(savedInstanceState);
        String variable = savedInstanceState.getString("KEY RESULT", "0");
        text.setText(variable);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);
    }

    private void writeText(String strAdd) {
        String oldStr = display.getText().toString();
        int cursosPosition = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursosPosition);
        String rightStr = oldStr.substring(cursosPosition);
        display.setText(String.format("%s%s%s", leftStr, strAdd, rightStr));
        display.setSelection(cursosPosition + 1);

    }

    public void zeroBTN(View view) {
        writeText("0");
    }

    public void oneBTN(View view) {
        writeText("1");
    }

    public void twoBTN(View view) {
        writeText("2");
    }

    public void threeBTN(View view) {
        writeText("3");
    }

    public void fourBTN(View view) {
        writeText("4");
    }

    public void fiveBTN(View view) {
        writeText("5");
    }

    public void sixBTN(View view) {
        writeText("6");
    }

    public void sevenBTN(View view) {
        writeText("7");
    }

    public void eightBTN(View view) {
        writeText("8");
    }

    public void nineBTN(View view) {
        writeText("9");
    }

    public void allClearBTN(View view) {
        display.setText("");
    }

    public void divideBTN(View view) {
        writeText("/");
    }

    public void multiplyBTN(View view) {
        writeText("x");
    }

    public void percentBTN(View view) {
        writeText("%");
    }

    public void addBTN(View view) {
        writeText("+");
    }

    public void subtractBTN(View view) {
        writeText("-");
    }

    public void plusMinusBTN(View view) {
        writeText("-");
    }

    public void commaBTN(View view) {
        writeText(",");
    }

    public void log10BTN(View view) {
        writeText("log10()");
    }

    public void factorialBTN(View view) {
        writeText("!");
    }

    public void sqrtBTN(View view) {
        writeText("sqrt()");
    }

    public void toPower3BTN(View view) {
        writeText("^3");
    }

    public void toPower2BTN(View view) {
        writeText("^2");
    }

    public void equalsBTN(View view) {
        String userExpression = display.getText().toString();
        userExpression = userExpression.replaceAll("x","*");
        Expression exp = new Expression(userExpression);

        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());

        display.setSelection(result.length());
    }

}