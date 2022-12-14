package com.yasindeger.qa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText number1;
    EditText number2;
    TextView result;
    TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.editTextNumberSigned);
        number2 = findViewById(R.id.editTextNumberSigned2);
        result = findViewById(R.id.textView4);
        errorMessage = findViewById(R.id.errorMessage);

    }

    public void getRandom(View view) {
        Random random = new Random();
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        int randomNumber;
        int firstBoundry;
        int secondBoundry;
        try {
            firstBoundry = Integer.parseInt(number1.getText().toString());
            secondBoundry = Integer.parseInt(number2.getText().toString());


            if (firstBoundry <= 0) {
                errorMessage.setText("First Number can not below or equal zero");
                result.setText("");
            } else if (secondBoundry <= 0) {
                errorMessage.setText("Second Number can not below or equal zero");
                result.setText("");
            } else if (firstBoundry >= secondBoundry) {
                errorMessage.setText("First Number can't be grater than second number");
                result.setText("");
            } else if (secondBoundry - firstBoundry == 1) {
                errorMessage.setText("First Number and Second Number very Close");
                result.setText("");
            } else {
                do {
                    randomNumber = random.nextInt(secondBoundry);
                } while (randomNumber <= firstBoundry);
                errorMessage.setText("");
                result.setText("" + randomNumber);
            }

        } catch (Exception e) {
            errorMessage.setText("Please enter valid value");
            result.setText("");
        }


    }
}