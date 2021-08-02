package com.course.meterstoinches;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText meterInput , inchInput;
    private Button convert, meterConvert;
    private TextView resultOutput,inchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        meterInput = (EditText) findViewById(R.id.metersEditText);
        convert = (Button) findViewById(R.id.convertID);
        resultOutput =(TextView) findViewById(R.id.resultID);


        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double multiplier = 39.37;
                double result = 0;



                if(meterInput.getText().toString().equals("")){

                    resultOutput.setVisibility(View.VISIBLE);
                    resultOutput.setText(R.string.error_message);
                    resultOutput.setTextColor(Color.RED);

                }else{

                    double meterData = Double.parseDouble(meterInput.getText().toString());

                    result = meterData * multiplier;

                    resultOutput.setVisibility(View.VISIBLE);
                    //resultOutput.setText(Double.toString(result) + "Inches");
                    resultOutput.setText((String.format("%.2f",result) + " Inches"));
                    resultOutput.setTextColor(Color.YELLOW);

                }

            }

        });

        inchInput = (EditText) findViewById(R.id.inputInch);
        meterConvert = (Button) findViewById(R.id.converttoMeter);
        inchResult = (TextView) findViewById(R.id.resultInch);

        meterConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double divisor = 39.36;
                double result = 0;

                if(meterConvert.getText().toString().equals("")){

                    inchResult.setVisibility(View.VISIBLE);
                    inchResult.setText("Please Enter a Valid Number");
                    inchResult.setTextColor(Color.RED);

                }else{

                    double inchData = Double.parseDouble(inchInput.getText().toString());

                    result = inchData / divisor;

                    inchResult.setVisibility((View.VISIBLE));
                    inchResult.setText((String.format("%.2f", result) + " Meter(s)"));
                    inchResult.setTextColor(Color.YELLOW);

                }


            }
        });

    }
}