package com.example.examenyariyreina;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlanetDetailActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ImageView imageViewPlanet;
    private TextView textViewPlanetDescription;
    private Spinner spinnerPlanetInfo;

    private String[] planetInfoOptions = {"Clima", "Geografía", "Flora y fauna"};
    private int[] planetImages = {R.drawable.mercurio, R.drawable.venus, R.drawable.tierra, R.drawable.marte, R.drawable.jupiter, R.drawable.saturno, R.drawable.urani, R.drawable.neptuno};
    private String[] planetDescriptions = {
            "Mercurio es el planeta más pequeño y cercano al Sol en el Sistema Solar.",
            "Venus es el segundo planeta desde el Sol y el planeta más caliente de nuestro Sistema Solar.",
            "La Tierra es el tercer planeta desde el Sol y el único cuerpo celeste conocido que sustenta la vida..",
            "Marte es el cuarto planeta desde el Sol y a menudo se le llama el Planeta Rojo..",
            "Júpiter es el planeta más grande del Sistema Solar y es conocido por su Gran Mancha Roja.",
            "Saturno es el sexto planeta desde el Sol y es famoso por sus anillos prominentes.",
            "Urano es el séptimo planeta desde el Sol y se caracteriza por su eje inclinado.",
            "Neptuno es el octavo planeta desde el Sol y es conocido por su color azul."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_detail);

        imageViewPlanet = findViewById(R.id.imageViewPlanet);
        textViewPlanetDescription = findViewById(R.id.textViewPlanetDescription);
        spinnerPlanetInfo = findViewById(R.id.spinnerPlanetInfo);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                planetInfoOptions);
        spinnerPlanetInfo.setAdapter(spinnerAdapter);
        spinnerPlanetInfo.setOnItemSelectedListener(this);

        // Obtener los datos del intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String planetName = extras.getString("planetName");
            int planetIndex = getPlanetIndex(planetName);
            if (planetIndex != -1) {
                // Mostrar la imagen y la descripción del planeta
                imageViewPlanet.setImageResource(planetImages[planetIndex]);
                textViewPlanetDescription.setText(planetDescriptions[planetIndex]);
            }
        }

        Button buttonBack = findViewById(R.id.boton_regresar);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private int getPlanetIndex(String planetName) {
        Object[] planetNames = new Object[0];
        for (int i = 0; i < planetNames.length; i++) {
            if (planetNames[i].equals(planetName)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = parent.getItemAtPosition(position).toString();


        int planetIndex = getPlanetIndex(selectedItem);
        if (planetIndex != -1) {
            textViewPlanetDescription.setText(getPlanetCharacteristics(planetIndex));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    private String getPlanetCharacteristics(int planetIndex) {
        StringBuilder characteristics = new StringBuilder();

        switch (planetIndex) {
            case 0:
                characteristics.append("Clima de Mercury: ...");
                break;
            case 1:
                characteristics.append("Geografía de Venus: ...");
                break;
            case 2:
                characteristics.append("Flora y fauna de Tierra: ...");
                break;

            default:
                characteristics.append("Características no disponibles");
                break;
        }

        return characteristics.toString();
    }
}
