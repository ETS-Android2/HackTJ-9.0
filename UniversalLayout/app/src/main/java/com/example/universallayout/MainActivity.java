package com.example.universallayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button plastic, can, cardboard, carton, glass, paper, fruit, vegetable;
    public static String buttonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Objects
        plastic = (Button) findViewById(R.id.plastic_btn);
        can = (Button) findViewById(R.id.can_btn);
        cardboard = (Button) findViewById(R.id.cardboard_btn);
        carton = (Button) findViewById(R.id.carton_btn);
        glass = (Button) findViewById(R.id.glass_btn);
        paper = (Button) findViewById(R.id.paper_btn);
        fruit = (Button) findViewById(R.id.fruit_btn);
        vegetable = (Button) findViewById(R.id.vegetable_btn);

        // SetOnClickListener
        plastic.setOnClickListener(this);
        can.setOnClickListener(this);
        cardboard.setOnClickListener(this);
        carton.setOnClickListener(this);
        glass.setOnClickListener(this);
        paper.setOnClickListener(this);
        fruit.setOnClickListener(this);
        vegetable.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, LayoutActivity.class);
        startActivity(intent);

        // Which Button Was Clicked
        switch (view.getId()) {
            case R.id.plastic_btn:
                btnClicked((String) plastic.getText());
                break;
            case R.id.can_btn:
                btnClicked((String) can.getText());
                break;
            case R.id.cardboard_btn:
                btnClicked((String) cardboard.getText());
                break;
            case R.id.carton_btn:
                btnClicked((String) carton.getText());
                break;
            case R.id.glass_btn:
                btnClicked((String) glass.getText());
                break;
            case R.id.paper_btn:
                btnClicked((String) paper.getText());
                break;
            case R.id.fruit_btn:
                btnClicked((String) fruit.getText());
                break;
            case R.id.vegetable_btn:
                btnClicked((String) vegetable.getText());
                break;
        }
    }

    public static void btnClicked (String name) {
        buttonName = name;
    }
}