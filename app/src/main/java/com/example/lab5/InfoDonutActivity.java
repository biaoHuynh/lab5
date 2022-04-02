package com.example.lab5;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoDonutActivity extends AppCompatActivity {

    TextView tvDonutName;
    TextView tvDonutDes;
    TextView tvDonutPrice;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_donut);
        tvDonutName = findViewById(R.id.tvDonutName);
        tvDonutDes = findViewById(R.id.tvDonutDes);
        tvDonutPrice = findViewById(R.id.tvDonutPrice);
        imageView = findViewById(R.id.imageView);

        String resourceId = getIntent().getStringExtra("resourceId");
        String name = getIntent().getStringExtra("name");
        String des = getIntent().getStringExtra("des");
        String price = getIntent().getStringExtra("price");

        imageView.setImageResource(Integer.valueOf(resourceId));
        tvDonutName.setText(name);tvDonutDes.setText(des);tvDonutPrice.setText(price);
    }
}