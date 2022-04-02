package com.example.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<com.example.listviews.Donut> listDonut;
    private ListView listView;
    private ListAdapter listAdapter;
    private int positionSelect = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lvDonut);
        loadDataDonut();

        listAdapter = new ArrayAdapter<com.example.listviews.Donut>(this,0,listDonut){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.donut_items,null);

                TextView tvDonutName = convertView.findViewById(R.id.tvDonutName);
                TextView tvDonutDes = convertView.findViewById(R.id.tvDonutDes);
                TextView tvDonutPrice = convertView.findViewById(R.id.tvDonutPrice);
                ImageView lvDonut = convertView.findViewById(R.id.ivDonut);
                com.example.listviews.Donut donut =  listDonut.get(position);
                tvDonutName.setText(donut.getName());
                tvDonutDes.setText(donut.getDescription());
                tvDonutPrice.setText("$ "+donut.getPrice()+".00");
                lvDonut.setImageResource(donut.getResourceId());

                return convertView;
            }
        };
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDonut(position);
            }
        });
    }

    private void showDonut(int position) {
        com.example.listviews.Donut donut = listDonut.get(position);

        Intent i = new Intent(this, com.example.listviews.InfoDonutActivity.class);
        i.putExtra("resourceId",""+donut.getResourceId());
        i.putExtra("name",donut.getName());
        i.putExtra("des",donut.getDescription());
        i.putExtra("price","$ "+donut.getPrice()+".00");
        startActivity(i);
    }

    private void loadDataDonut() {
        listDonut = new ArrayList<>();
        listDonut.add(new com.example.listviews.Donut(R.drawable.donut_yellow_1,"Tasty Donut","Spicy tasty donut family",100));
        listDonut.add(new com.example.listviews.Donut(R.drawable.tasty_donut_1,"Pink Donut","Spicy tasty donut family",200));
        listDonut.add(new com.example.listviews.Donut(R.drawable.donut_red_1,"Floating Donut","Spicy tasty donut family",300));
        listDonut.add(new com.example.listviews.Donut(R.drawable.green_donut_1,"Tasty Donut","Spicy tasty donut family",400));
    }
}