package com.example.a2damm.proyectotelefono.modelo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.example.a2damm.proyectotelefono.modelo.rest.ServicioClienteRest;

public class ReceptorEstadoTelefono extends BroadcastReceiver {

    // Servicio Android: Ejecucion larga, sin interfaz de usuario,
    //  ejecucion indpendiente de la interfaz,
    //  cuando termina se autotermina
    private static boolean colgado=true;
    private static boolean entrante=false;
    private static boolean saliente=false;
    private static boolean cogido=false;


    @Override
    public void onReceive( Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String state = extras.getString(TelephonyManager.EXTRA_STATE);
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                colgado=false;
                entrante=true;

            } else if (state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                    if(colgado==true) {
                        saliente=true;
                    }else{
                        cogido=true;
                    }
            }
            else if(state.equals(TelephonyManager.EXTRA_STATE_IDLE)){
                String estado="";
                if(entrante && !cogido){
                    estado="Perdida";
                } else if(entrante && cogido){
                    estado="Entrante";
                }
                else if(saliente){
                    estado="saliente";
                }
                if(!estado.equals("")){
                    String phoneNumber = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                    Intent intente = new Intent(context, ServicioClienteRest.class);
                    intente.putExtra("state", estado);
                    intente.putExtra("phone", phoneNumber);
                    context.startService(intente);
                }
                colgado=true;
                entrante=false;
                saliente=false;
                cogido=false;
            }

        }
    }

}
