package com.thangvnnc.androidoracleexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button _btnSelectOracle;
    private Button _btnSelectMSSQL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Activity self = this;
        _btnSelectOracle = findViewById(R.id.btnSelectOracle);
        _btnSelectOracle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OracleCon.getEmp(new Callback() {
                    @Override
                    public void result(final String result) {
                        self.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(self, result, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });
        _btnSelectMSSQL = findViewById(R.id.btnSelectMSSQL);
        _btnSelectMSSQL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MSSQLCon.getEmp(new Callback() {
                    @Override
                    public void result(final String result) {
                        self.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(self, result, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });
    }
}