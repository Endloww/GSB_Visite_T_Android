package com.example.gsbvisitet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.gsbvisitet.databinding.ActivityAccueilBinding;

import java.util.ArrayList;

public class Accueil extends AppCompatActivity {

    private Visiteur visiteur;
    private ActivityAccueilBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccueilBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        visiteur = (Visiteur) getIntent().getSerializableExtra("visiteur");
        binding.textViewName.setText("Bienvenue \n" + visiteur.getNom());

        ArrayList<Praticien> praticiens = new ArrayList<Praticien>();
        praticiens.add(new Praticien("Dr. Dupont", "Médecin généraliste", "1 rue de la paix", "75000", "Paris", "01 02 03 04 05", "12 Rue de Potier", "dupontlemedecin@gmail.com"));
        praticiens.add(new Praticien("Dr. Durand", "Dentiste", "2 rue de la liberté", "69000", "Lyon", "06 07 08 09 10", "5 Rue du prout", "durandledentiste@gmail.com"));

        binding.recyclerViewPraticien.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        binding.recyclerViewPraticien.setLayoutManager(layoutManager);
        binding.recyclerViewPraticien.setFocusable(false);

        RecyclerAdapter adapter = new RecyclerAdapter(praticiens);
        binding.recyclerViewPraticien.setAdapter(adapter);
    }
}