package com.example.flooring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editWidth, editLength;
    TextView tvResult;


    private static final int CIS3334_REQUEST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editWidth = (EditText) findViewById(R.id.editTextWidth);
        editLength = (EditText) findViewById(R.id.editTextLength);
        tvResult = (TextView) findViewById(R.id.textViewResult);
    }

    public void onButtonClick(View view){
        Double width = Double.valueOf(editWidth.getText().toString());
        Double length = Double.valueOf(editLength.getText().toString());
        Double area = width * length;


        Intent flooringDetail = new Intent(this, FlooringDetail.class);
        flooringDetail.putExtra("Width", width);
        flooringDetail.putExtra("Length", length);
        flooringDetail.putExtra("Area", area);


        startActivityForResult(flooringDetail, CIS3334_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode == RESULT_OK && requestCode == CIS3334_REQUEST_CODE) {
            if (data.hasExtra("Results")) {
                String result = data.getExtras().getString("Results");
                if (result != null && result.length() > 0) {
                    tvResult.setText("Previous Data : " + result);
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
