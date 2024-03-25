package com.example.gsbvisitet;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GSBServices {

    @POST("auth/login")
    Call<Visiteur> login(@Body Visiteur visiteur);

    @GET("visiteur/{id}")
    Call<Visiteur> getVisiteur(@Header ("Authorization") String token, @Path("id") String id);

}
