package tcc.cosangueapp.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tcc.cosangueapp.R;
import tcc.cosangueapp.gcm.GCloudMessaging;
import tcc.cosangueapp.pojos.Usuario;
import tcc.cosangueapp.utils.Constantes;

public class DoacaoFragment extends Fragment {


    public DoacaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_doacao, container, false);
    }



/*

    private class HttpRequestTaskVerificaRegistrationId extends AsyncTask<Context, Void, String> {

        @Override
        protected String doInBackground(Context... params) {
            try {
                String registrationId = GCloudMessaging.register(params[0], Constantes.SENDER_ID);
                // adiciona o registration_id no shared preferences
                //editarPreferencias.putString(Constantes.PROPERTY_REG_ID, registrationId).commit();
                return registrationId;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String registrationId) {
            if (registrationId != null) {
                SharedPreferences preferences = getActivity().getSharedPreferences(Constantes.NOME_SHARED_PREFERENCIES, Context.MODE_APPEND);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(Constantes.PROPERTY_REG_ID, registrationId).apply();

                boolean ok = checkPlayServices();
                if (ok) {
                    // Já está registrado
                    Usuario usuario = new Usuario();
                    usuario.setId(id);
                    usuario.setregistrationId(preferences.getString(Constantes.PROPERTY_REG_ID, null));
                    new HttpRequestTaskInseriRegistrationId().execute(usuario.getId().toString(), usuario.getregistrationId());
                }
            }
        }


    }

*/



}
