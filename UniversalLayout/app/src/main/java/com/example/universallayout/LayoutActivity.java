package com.example.universallayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LayoutActivity extends AppCompatActivity {
    private ImageView object;
    private TextView description;
    private Button exit;
    private String objectName;

    private String str_plastic, str_can, str_card, str_cart, str_fruit, str_vegetable, str_paper, str_glass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        object = (ImageView) findViewById(R.id.object);
        description = (TextView) findViewById(R.id.description);
        exit = (Button) findViewById(R.id.exit_btn);
        objectName = MainActivity.buttonName;

        description();

        switch (objectName) {
            case "Plastic Bottle":
                object.setImageResource(R.drawable.plastic_bottle);
                description.setText(str_plastic);
                break;
            case "Can":
                object.setImageResource(R.drawable.can);
                description.setText(str_can);
                break;
            case "Cardboard":
                object.setImageResource(R.drawable.cardboard);
                description.setText(str_card);
                break;
            case "Carton":
                object.setImageResource(R.drawable.carton);
                description.setText(str_cart);
                break;
            case "Glass Bottle":
                object.setImageResource(R.drawable.glass_bottle);
                description.setText(str_glass);
                break;
            case "Paper":
                object.setImageResource(R.drawable.paper);
                description.setText(str_paper);
                break;
            case "Fruit":
                object.setImageResource(R.drawable.fruit);
                description.setText(str_fruit);
                break;
            case "Vegetable":
                object.setImageResource(R.drawable.vegetable);
                description.setText(str_vegetable);
                break;
        }

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LayoutActivity.this, MainActivity.class);
                finish();
            }
        });
    }

    public void description() {
        str_plastic = "Some Stats on Plastic";
        str_can = "Some Stats on Can";
        str_card = "Some Stats on Cardboard";
        str_cart = "Some Stats on Carton";
        str_glass = "Some Stats on Glass";
        str_paper = "Some Stats on Paper";
        str_fruit = "Some Stats on Fruit";
        str_vegetable = "Some Stats on Vegetable";
    }
}