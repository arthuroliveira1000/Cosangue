package tcc.cosangueapp.gcm;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import tcc.cosangueapp.activities.PaginaInicial;
import tcc.cosangueapp.utils.Constantes;
import tcc.cosangueapp.utils.NotificationUtils;

public class GcmIntentService extends IntentService {
    private static final String TAG = "gcm";

    public GcmIntentService() {
        super(Constantes.SENDER_ID);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        Log.i(TAG, "GcmIntentService.onHandleIntent: " + extras);
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
        if (!extras.isEmpty()) {
            // Verifica o tipo da mensagem
            String messageType = gcm.getMessageType(intent);
            // O extras.isEmpty() precisa ser chamado para ler o bundle
            // Verifica o tipo da mensagem, no futuro podemos ter mais tipos
            if (GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR.equals(messageType)) {
                // Erro
                onError(extras);
            } else if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) {
                // Mensagem do tipo normal. Faz a leitura do parâmetro "msg"
                // enviado pelo servidor
                onMessage(extras);
            }
        }
        // Libera o wake lock, que foi bloqueado pela classe
        // "GcmBroadcastReceiver".
        GcmBroadcastReceiver.completeWakefulIntent(intent);
    }

    private void onError(Bundle extras) {
        Log.d(TAG, "Erro: " + extras.toString());
    }

    private void onMessage(Bundle extras) {
        // Lê a mensagem e mostra uma notificação
        String msg = extras.getString("msg");
        Log.d(TAG, msg);
        Intent intent = new Intent(this, PaginaInicial.class);
        //botar os dados aqui na intent pra pegar na tela
        intent.putExtra("msg", msg);
        NotificationUtils.create(this, intent, "Novo Evento", msg, 1);
    }
}