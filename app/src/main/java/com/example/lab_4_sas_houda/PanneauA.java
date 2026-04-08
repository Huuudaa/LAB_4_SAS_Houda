package com.example.lab_4_sas_houda;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PanneauA extends Fragment {

    private TextView texteA;
    private Button btnSaluer;

    public PanneauA() {
        super(R.layout.fragment_panneau_a);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        texteA    = view.findViewById(R.id.texteA);
        btnSaluer = view.findViewById(R.id.btnSaluer);

        btnSaluer.setOnClickListener(v ->
                texteA.setText("Bienvenue dans le Panneau A !")
        );
    }

    @Override
    public void onResume() {
        super.onResume();
        android.util.Log.d("PanneauA", "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        android.util.Log.d("PanneauA", "onPause()");
    }
}