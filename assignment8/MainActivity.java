package com.example.assignment8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton milesB;
    private RadioButton kmB;
    private EditText textValue;
    private EditText textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        milesB = (RadioButton) findViewById(R.id.milesButton);
        kmB = (RadioButton) findViewById(R.id.kmButton);
        textValue = (EditText) findViewById(R.id.value);
        textResult = (EditText) findViewById(R.id.result);
    }

    private String MtoK(String miles){
        double m = Double.parseDouble(miles);
        double km = m*1.609;
        return String.valueOf(km);
    }
    private String KtoM(String kilometers){
        double km = Double.parseDouble(kilometers);
        double m = km/1.609;
        return String.valueOf(m);
    }

    public void onClick(View view){
        switch (view.getId()) {
            case R.id.convertB:
                String result = "";
                String value = textValue.getText().toString();
                if(value.length() == 0){
                    Context context = getApplicationContext();
                    CharSequence text = "Error: empty value";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else{
                    if (milesB.isChecked()) {
                        result = MtoK(value);
                    } else if (kmB.isChecked()) {
                        result = KtoM(value);
                    }
                    textResult.setText(result);
                }
                break;
            case R.id.reset:
                milesB.setChecked(true);
                kmB.setChecked(false);
                textValue.setText("");
                textResult.setText("");
                break;
        }
    }

}