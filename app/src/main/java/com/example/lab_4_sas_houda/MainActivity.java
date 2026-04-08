package com.example.lab_4_sas_houda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnA, btnB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnA = findViewById(R.id.btnPanneauA);
        btnB = findViewById(R.id.btnPanneauB);

        // Afficher le panneau A au lancement
        if (savedInstanceState == null) {
            chargerPanneau(new PanneauA(), false);
        }

        btnA.setOnClickListener(v -> chargerPanneau(new PanneauA(), true));
        btnB.setOnClickListener(v -> chargerPanneau(new PanneauB(), true));
    }

    private void chargerPanneau(Fragment fragment, boolean ajouterPile) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.panneau_container, fragment);

        if (ajouterPile) {
            ft.addToBackStack(null);
        }

        ft.commit();
    }
}