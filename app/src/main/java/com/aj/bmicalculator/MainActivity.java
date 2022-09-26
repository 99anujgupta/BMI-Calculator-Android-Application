package com.aj.bmicalculator;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editheightft,editheightin,editweight;
        Button button;
        TextView result;
        LinearLayout llMain;

        editheightft = findViewById(R.id.editheightft);
        editheightin = findViewById(R.id.editheightin);
        editweight = findViewById(R.id.editweight);
        button = findViewById(R.id.button);
        result = findViewById(R.id.result);
        llMain = findViewById(R.id.llMain);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int ft= Integer.parseInt(editheightft.getText().toString());
               int in= Integer.parseInt(editheightin.getText().toString());
               int wt= Integer.parseInt(editweight.getText().toString());

               int totalin= ft*12 + in;
               double totalcm= totalin*2.53;
               double totalM= totalcm/100;
               double bmi= wt/(totalM*totalM);

               if (bmi>25){
                   result.setText("YOU'RE OVERWIEGHT!");
                   llMain.setBackgroundColor(getResources().getColor(R.color.overwgt));
               } else if(bmi<18){
                   result.setText("YOU'RE UNDERWEIGHT!");
                   llMain.setBackgroundColor(getResources().getColor(R.color.underwgt));
               } else{
                   result.setText("YOU'RE HEALTHY!");
                   llMain.setBackgroundColor(getResources().getColor(R.color.hlthy));
               }


            }
        });
    }
}