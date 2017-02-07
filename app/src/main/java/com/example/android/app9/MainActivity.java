package com.example.android.app9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtNum1=(EditText) findViewById(R.id.edtNum1);
       final EditText edtNum2=(EditText) findViewById(R.id.edtNum2);
        final EditText edtNum3=(EditText) findViewById(R.id.edtNum3);
        Button btnGetMaximum=(Button) findViewById(R.id.btnMaximumValue);
        final TextView txtResult=(TextView) findViewById(R.id.txtResult);
        final Button btnSecureRandomNumbers=(Button) findViewById(R.id.btnSecureRandomNumbers);
        final TextView txtSecureRandomNumbers=(TextView) findViewById(R.id.txtSecureRandomNumbers);

        btnGetMaximum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1=Double.parseDouble(edtNum1.getText().toString());
                double num2=Double.parseDouble(edtNum2.getText().toString());
                double num3=Double.parseDouble(edtNum3.getText().toString());


               double result = getTheMaximum(num1,num2,num3);
                txtResult.setText(result + "");
            }
        });


        btnSecureRandomNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecureRandom secureRandomNumbers=new SecureRandom();
                String oldTxtSecureRandomNumbersValue=txtSecureRandomNumbers.getText().toString();
                if(txtSecureRandomNumbers.getText().toString().length()>=9){
                    btnSecureRandomNumbers.setVisibility(View.INVISIBLE);

                }
                int randomSecureNumber=secureRandomNumbers.nextInt(5);
                Log.i("LOG",randomSecureNumber + "");



            }
        });
    }

    public double getTheMaximum(double num1,double num2,double num3){

        double theMaximumValue=num1;
        if(num2>theMaximumValue){
            theMaximumValue=num2;
        }
        if(num3>theMaximumValue){
            theMaximumValue=num3;
        }
        return theMaximumValue;
    }


}
