package com.example.gsbvisitet;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://vigilant-bassoon-66x45w7v66wh4rpg-3000.app.github.dev/api/";
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)

                    .addConverterFactory(GsonConverterFactory.create())

                    .build();
        }
        return retrofit;
    }
}
