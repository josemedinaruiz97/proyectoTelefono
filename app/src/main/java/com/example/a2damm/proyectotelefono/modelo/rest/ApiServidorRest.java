package com.example.a2damm.proyectotelefono.modelo.rest;

import com.example.a2damm.proyectotelefono.modelo.pojo.Llamada;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by 2damm on 24/1/18.
 */

public interface ApiServidorRest {
    //https.../persona - get-> listado de persona
    @GET("llamadas")
    Call<ArrayList<Llamada>> getLlamadas();
    //https.../persona - post- persona-> persona
    @POST("llamadas")
    Call<Llamada> postLlamada(@Body Llamada llamada);
}
