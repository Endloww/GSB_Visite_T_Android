package com.example.gsbvisitet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.widget.Toast;

import com.example.gsbvisitet.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Visiteur visiteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visiteur = new Visiteur();
                visiteur.setEmail(binding.email.getText().toString());
                visiteur.setPassword(binding.mdp.getText().toString());

                GSBServices service = RetroFitClientInstance.getRetrofitInstance().create(GSBServices.class);
                Call<Visiteur> call = service.login(visiteur);

                call.enqueue(new Callback<Visiteur>() {
                    @Override
                    public void onResponse(Call<Visiteur> call, Response<Visiteur> response) {
                        if(response.isSuccessful()) {
                            visiteur = response.body();
                            Toast.makeText(MainActivity.this, "Connexion réussie", Toast.LENGTH_SHORT).show();

                            getVisiteur();
                        } else {
                            Toast.makeText(MainActivity.this, "Connexion échouée", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Visiteur> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Erreur de connexion", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
    public  void getVisiteur(){
        GSBServices service = RetroFitClientInstance.getRetrofitInstance().create(GSBServices.class);
        Call<Visiteur> call = service.getVisiteur("Bearer " + visiteur.getToken(),  visiteur.getVisiteurId());

        call.enqueue(new Callback<Visiteur>() {
            @Override
            public void onResponse(Call<Visiteur> call, Response<Visiteur> response) {
                Visiteur visiteurInfo = response.body();
                Intent intent = new Intent(MainActivity.this, Accueil.class);
                    intent.putExtra("visiteur", visiteurInfo);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Visiteur> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Une erreur est survenue lors de la récupération des informations du visiteur !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}