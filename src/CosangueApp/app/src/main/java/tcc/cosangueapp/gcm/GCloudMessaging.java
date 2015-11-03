package tcc.cosangueapp.gcm;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.io.IOException;

import tcc.cosangueapp.utils.Constantes;

public class GCloudMessaging {



    /*//Preferências para salvar o registration id
    private static SharedPreferences getGCMPreferences(Context context) {
        SharedPreferences sharedPreferences =  context.getSharedPreferences(Constantes.NOME_SHARED_PREFERENCIES, 0);
        return sharedPreferences;
    }*/

   /* //Retorna o registration id salvo nas prefs
    public static String getRegistrationId(Context context) {
        final SharedPreferences prefs = getGCMPreferences(context);
        String registrationId = prefs.getString(Constantes.PROPERTY_REG_ID, "");

        if (registrationId == null || registrationId.trim().length() == 0) {
            return null;
        }

        return registrationId;
    }*/

    /*//Salva o registration id nas prefs
    private static void saveRegistrationId(Context context, String registrationId) {
        final SharedPreferences prefs = getGCMPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(Constantes.PROPERTY_REG_ID, registrationId);
        editor.commit();
    }*/

    // Faz o registro no GCM
    public static String register(Context context, String projectNumber) {
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(context);
        try {
            Log.d(Constantes.TAG, ">> GCM.registrar(): " + projectNumber);
            String registrationId = gcm.register(projectNumber);

          //  if (registrationId != null) {
                // Salva nas prefs
                // saveRegistrationId(context, registrationId);
                //return registrationId;
            //}

            Log.d(Constantes.TAG, "<< GCM.registrar() OK, registration id: " + registrationId);
            return registrationId;
        } catch (IOException e) {
            Log.e(Constantes.TAG, "<< GCM.registrar() ERRO: " + e.getMessage(), e);
        }
        return null;
    }

    // Cancelar o registro no GCM
    public static void unregister(Context context) {
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(context);
        try {
            gcm.unregister();
            //saveRegistrationId(context, null);
            Log.d(Constantes.TAG, "GCM cancelado com sucesso.");
        } catch (IOException e) {
            Log.e(Constantes.TAG, "GCM erro ao desregistrar: " + e.getMessage(), e);
        }
    }
}

