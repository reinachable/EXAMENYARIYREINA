package com.example.examenyariyreina;

// MainActivity.java

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listViewPlanets;
    private String[] planetNames = {"Mercurio", "Venus", "Tierra", "Marte", "Jupiter", "Saturno", "Urano", "Neptuno"};
    private int[] planetImages = {R.drawable.mercurio, R.drawable.venus, R.drawable.tierra, R.drawable.marte, R.drawable.jupiter, R.drawable.saturno, R.drawable.urani, R.drawable.neptuno};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewPlanets = findViewById(R.id.listViewPlanets);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planetNames);
        listViewPlanets.setAdapter(adapter);

        PlanetListAdapter planetListAdapter = new PlanetListAdapter(this, planetNames, planetImages);
        listViewPlanets.setAdapter((ListAdapter) planetListAdapter);

        listViewPlanets.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String planetName = planetNames[position];
                Intent intent = new Intent(MainActivity.this, PlanetDetailActivity.class);
                intent.putExtra("planetName", planetName);
                startActivity(intent);


            }
        });
    }
}
