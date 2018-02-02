package com.example.a2damm.proyectotelefono.modelo.rest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.a2damm.proyectotelefono.modelo.pojo.Llamada;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicioClienteRest extends Service {
    public ServicioClienteRest() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }
    @Override
    public int onStartCommand(final Intent intent, int flags,
                              int startId) {
        String phone=intent.getStringExtra("phone");
        String state=intent.getStringExtra("state");
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl("https://json-josemedinaruiz97.c9users.io")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        ApiServidorRest cliente = retrofit.create( ApiServidorRest.class);
        Call<Llamada> call = cliente.postLlamada(new Llamada(Calendar.getInstance().getTime().toString(),phone,state)); //post
        call.enqueue(new Callback<Llamada>() {
            @Override
            public void onResponse(Call<Llamada> call, Response<Llamada> response) {
                Llamada llamada=response.body();
            }

            @Override
            public void onFailure(Call<Llamada> call, Throwable t) {

            }
        });
        return START_REDELIVER_INTENT;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
