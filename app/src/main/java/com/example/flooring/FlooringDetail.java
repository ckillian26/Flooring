package com.example.flooring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FlooringDetail extends AppCompatActivity {

    TextView tvDescription;
    Double width, length, area;
    String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flooring_detail);

        tvDescription = (TextView) findViewById(R.id.textViewFlooringDesc);

        Bundle extras = getIntent().getExtras();
        width = extras.getDouble("Width");
        length = extras.getDouble("Length");
        area = extras.getDouble("Area");


        description = "The Width is " + width + " and the Length is " + length + "\nand the flooring needed is " + area;

        tvDescription.setText(description);
    }

    public void finish(){
        Intent intent = new Intent();
        intent.putExtra("Results", description);

        setResult(RESULT_OK, intent);
        super.finish();
    }
}
