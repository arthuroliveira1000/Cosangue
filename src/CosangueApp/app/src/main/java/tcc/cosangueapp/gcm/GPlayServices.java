package tcc.cosangueapp.gcm;

import android.app.Activity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class GPlayServices {


    public static boolean checkPlayServices(Activity activity) {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
                GooglePlayServicesUtil.getErrorDialog(resultCode, activity, PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                //toast("Este aparelho não suporta o Google Play Services.");
                // resolver o que fazer quando o celular não tem suporte pro google play services, ele não receberá as notificações
                // dos eventos, terá que entrar no aplicativo para ver se tem novos eventos ou não
            }
            return false;
        }
        return true;
    }
}
