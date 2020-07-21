package com.example.whatwhichwhere;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText PackSize = (EditText) findViewById(R.id.txtboxPackSize);
        final EditText Price = (EditText) findViewById(R.id.txtboxPrice);
        final EditText Type = (EditText) findViewById(R.id.txtboxProduct);
        final EditText Brand = (EditText) findViewById(R.id.txtboxBrand);
        final EditText Location = (EditText) findViewById(R.id.txtboxLocation);
        final Spinner Unit = (Spinner) findViewById(R.id.spnUnit);
        final TextView unitPrice = (TextView) findViewById(R.id.txtUnitPrice);

        final Button Calculate = (Button) findViewById(R.id.btnCalculate);
        final Button Save = (Button) findViewById(R.id.btnSave);
        final Button Compare = (Button) findViewById(R.id.btnCompare);
        final TableLayout tableLayout = (TableLayout) findViewById(R.id.tableLayout1);



        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calculate = new Intent(getApplicationContext(), Calculate.class);
                startActivity(calculate);
            }
        });

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent save = new Intent(getApplicationContext(), Save.class);
                startActivity(save);}
        });
    }


}
