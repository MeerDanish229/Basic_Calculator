package com.example.calculatorapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView resultTv,solutionTv;
    private String currentInput="";

    private double num1=0;
    private String operator="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTv = findViewById(R.id.resultTV);
        solutionTv = findViewById(R.id.solutionTV);

    }

    public void OnDigitClick(View view) {
        Button btn_txt = (Button) view;
        currentInput += btn_txt.getText().toString();
        currentResult();
    }
    public void onClearClick(View view) {
        currentInput = "";
        num1=0;
        operator = "";
        currentResult();
        finalResult();
    }
    public void onEqualsClick(View view) {
        if (!operator.isEmpty() && !currentInput.isEmpty()) {
            double num2 = Double.parseDouble(currentInput);
            double result = performOperation(num1,num2,operator);
            currentInput = String.valueOf(result);
            num1 = result;
            operator="";
            finalResult();
        }
    }

    public void onOperatorClick(View view) {
        operator = ((Button) view).getText().toString();
        num1 = Double.parseDouble(currentInput);
        currentInput = "";
    }
    private void finalResult() {
        if (currentInput.endsWith(".0")) {
            currentInput = currentInput.replace(".0","");
//            return currentInput;
            resultTv.setText(currentInput);
        }
    }

//    public void onBracketClick(View view) {
//        Button button = (Button) view;
//        String bracket = button.getText().toString();
//
//        if (bracket.equals("(")) {
//            currentInput += "(";
//        } else if (bracket.equals(")")) {
//            currentInput += ")";
//        }
//        currentResult();
//    }

    private double performOperation(double num1,double num2,String operator) {
        switch (operator) {
            case "+":
                return num1+num2;
            case "-":
                return num1-num2;
            case "*":
                return num1*num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    // Handle division by zero error
                    return Double.NaN;
                }
            default:
                return 0;
        }
    }
    private void currentResult() {
        solutionTv.setText(currentInput);
    }
}
