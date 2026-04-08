package com.example.lab_4_sas_houda;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class PanneauB extends Fragment {

    private TextView texteB;
    private SeekBar sliderNiveau;
    private int niveau = 0;
    private static final String CLE_NIVEAU = "niveau";

    public PanneauB() {
        super(R.layout.fragment_panneau_b);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // D'abord, initialiser les vues
        texteB = view.findViewById(R.id.texteB);
        sliderNiveau = view.findViewById(R.id.sliderNiveau);

        // Ensuite, configurer le SeekBar
        sliderNiveau.setMax(100);

        // Restaurer l'état après rotation
        if (savedInstanceState != null) {
            niveau = savedInstanceState.getInt(CLE_NIVEAU, 0);
            sliderNiveau.setProgress(niveau);
            texteB.setText("Niveau : " + niveau);
        } else {
            texteB.setText("Niveau : 0");
        }

        // Configurer l'écouteur
        sliderNiveau.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int valeur, boolean fromUser) {
                niveau = valeur;
                texteB.setText("Niveau : " + valeur);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CLE_NIVEAU, niveau);
    }
}