package tcc.cosangueapp.gcm;


import android.content.Context;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.io.IOException;

import tcc.cosangueapp.utils.Constantes;

public class GCloudMessaging {

    public static String register(Context context, String projectNumber) {
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(context);
        try {
            Log.i(Constantes.TAG, ">> GCM.registrar(): " + projectNumber);
            String registrationId = gcm.register(projectNumber);

            Log.i(Constantes.TAG, "<< GCM.registrar() OK, registration id: " + registrationId);
            return registrationId;
        } catch (IOException e) {
            Log.i(Constantes.TAG, "<< GCM.registrar() ERRO: " + e.getMessage(), e);
        }
        return null;
    }


    public static void unregister(Context context) {
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(context);
        try {
            gcm.unregister();
            Log.i(Constantes.TAG, "GCM cancelado com sucesso.");
        } catch (IOException e) {
            Log.i(Constantes.TAG, "GCM erro ao desregistrar: " + e.getMessage(), e);
        }
    }
}

