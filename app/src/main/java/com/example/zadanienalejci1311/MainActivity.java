package com.example.zadanienalejci1311;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    protected Button buttonZolty, buttonCzarny, buttonNastepny;
    protected ImageView imageView;

    protected LinearLayout main;
    ArrayList<Integer> obrazki;

    int aktualnyObraz = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        buttonCzarny = findViewById(R.id.buttonCzarny);
        buttonZolty = findViewById(R.id.buttonZolty);
        buttonNastepny = findViewById(R.id.buttonNastepny);
        imageView = findViewById(R.id.imageView);
        obrazki = new ArrayList<>();
        obrazki.add(R.drawable.centenario);
        obrazki.add(R.drawable.merc);
        obrazki.add(R.drawable.chiron);
        obrazki.add(R.drawable.veyron);

        buttonNastepny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aktualnyObraz >= obrazki.size()) {
                    aktualnyObraz = 0;
                    imageView.setImageResource(obrazki.get(aktualnyObraz));
                }
            }
        });

        buttonZolty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.setBackgroundColor(Color.parseColor("#FFFF00"));
            }
        });

        buttonCzarny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.setBackgroundColor(Color.parseColor("#000000"));
            }
        });
    }
}