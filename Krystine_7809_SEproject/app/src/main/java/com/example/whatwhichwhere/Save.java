package com.example.whatwhichwhere;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Save extends AppCompatActivity {

    private Button saveBtn;
    private EditText PackSize, Price, Type, Brand, Location;
    private Spinner Unit;
    private TableLayout tableLayout;
    private DBManager dbMan;
    private DBManager dbManager;
    private ProgressDialog PD;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_view);

        final EditText PackSize = (EditText) findViewById(R.id.txtboxPackSize);
        final EditText Price = (EditText) findViewById(R.id.txtboxPrice);
        final EditText Type = (EditText) findViewById(R.id.txtboxProduct);
        final EditText Brand = (EditText) findViewById(R.id.txtboxBrand);
        final EditText Location = (EditText) findViewById(R.id.txtboxLocation);
        final Spinner Unit = (Spinner) findViewById(R.id.spnUnit);
        final Button Calculate = (Button) findViewById(R.id.btnCalculate);
        final Button Save = (Button) findViewById(R.id.btnSave);
        final TextView unitPrice = (TextView) findViewById(R.id.txtUnitPrice);
        final TableLayout tableLayout = (TableLayout) findViewById(R.id.tableLayout1);

        new MyAsync().execute();
        dbManager = new DBManager(this);
        BuildTable();
    }

    TableRow row = null;

    private void BuildTable() {
            dbManager.open();
            Cursor c = dbMan.fetch();

            int rows = c.getCount();
            int cols = c.getColumnCount();
            c.moveToFirst();

            for (int i = 0; i<rows;i++) {
                TableRow row = new TableRow(this);
                row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                for (int j = 0; j < cols; j++) {
                    TextView tv = new TextView(this);
                    tv.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
                    tv.setGravity(Gravity.CENTER);
                    tv.setTextSize(18);
                    tv.setPadding(0, 5, 0, 5);

                    tv.setText(c.getString(j));

                    row.addView(tv);

                }
                c.moveToNext();
                tableLayout.addView(row);
            }
            dbMan.close();
    }

    private class MyAsync extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tableLayout.removeAllViews();

            PD = new ProgressDialog(Save.this);
            PD.setTitle("Please Wait..");
            PD.setMessage("Loading...");
            PD.setCancelable(false);
            PD.show();
        }

        @Override
            protected Void doInBackground(Void... params) {
            double price = Double.parseDouble(Price.getText().toString());
            String prodType = Type.getText().toString();
            String brand = Brand.getText().toString();
            String unit = Unit.getSelectedItem().toString();
            String location = Location.getText().toString();
            double packSize = Double.parseDouble(PackSize.getText().toString());

                dbMan.open();
                dbMan.insert(prodType,brand,price,unit,packSize,location);
                return null;
            }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            BuildTable();
            PD.dismiss();
        }
    }
}
