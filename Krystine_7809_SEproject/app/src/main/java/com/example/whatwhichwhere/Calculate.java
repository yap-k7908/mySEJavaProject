package com.example.whatwhichwhere;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Calculate extends AppCompatActivity {

    public static double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText PackSize = (EditText) findViewById(R.id.txtboxPackSize);
        final EditText Price = (EditText) findViewById(R.id.txtboxPrice);
        final Spinner Unit = (Spinner) findViewById(R.id.spnUnit);
        final TextView unitPrice = (TextView) findViewById(R.id.txtUnitPrice);

        double price, size;
        String unit=Unit.getSelectedItem().toString();

        price=Double.parseDouble(Price.getText().toString());
        size=Double.parseDouble(PackSize.getText().toString());

        DecimalFormat currency = new DecimalFormat("$###,###.##");
        result = price/size;
        unitPrice.setText(currency.format(result) + " per " + unit);


    }


}