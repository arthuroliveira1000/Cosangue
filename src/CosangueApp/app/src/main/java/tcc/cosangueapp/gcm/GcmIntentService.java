package tcc.cosangueapp.gcm;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import tcc.cosangueapp.activities.DetalhesEventos;
import tcc.cosangueapp.activities.PaginaInicial;
import tcc.cosangueapp.pojos.Acao;
import tcc.cosangueapp.pojos.Categoria;
import tcc.cosangueapp.pojos.Endereco;
import tcc.cosangueapp.pojos.Hemocomponentes;
import tcc.cosangueapp.pojos.TipoSanguineo;
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
        // pegar todos as tags do que vier e setar numa nova ção
        //ex:    Long id = extras.getLong("id");
        // faz isso pra todos os campos
        Acao acao = new Acao();
        Endereco endereco = new Endereco();

        if (extras.getString("id") != null) {
            acao.setId(Long.valueOf(extras.getString("id")));
        }

        if (extras.getString("nome") != null) {
            acao.setNome(extras.getString("nome"));
        } else {
            acao.setNome("Evento sem Nome!");
        }

        if (extras.getString("descricao") != null) {
            acao.setDescricao(extras.getString("descricao"));
        }

        if (extras.getString("data") != null) {
            acao.setData(extras.getString("data"));
        }
        if (extras.getString("horario") != null) {
            acao.setHorario(extras.getString("horario"));
        }
        if (extras.getString("categoria") != null) {
            acao.setCategoria(Categoria.fromString(extras.getString("categoria")));
        }
        if (extras.getString("hemocomponente") != null) {
            acao.setHemocomponente(Hemocomponentes.fromString(extras.getString("hemocomponente")));
        }

        if (extras.getString("tiposanguineo") != null) {
            acao.setTipo(TipoSanguineo.fromString(extras.getString("tiposanguineo")));
        }


        // SETANDO ENDEREÇO

        if (extras.getString("id_endereco") != null) {
            endereco.setId(Long.valueOf(extras.getString("id_endereco")));
        }
        if (extras.getString("logradouro") != null) {
            endereco.setLogradouro(extras.getString("logradouro"));
        }
        if (extras.getString("bairro") != null) {
            endereco.setBairro(extras.getString("bairro"));
        }
        if (extras.getString("numero") != null) {
            endereco.setNr(extras.getInt("numero"));
        }
        if (extras.getString("cidade") != null) {
            endereco.setCidade(extras.getString("cidade"));
        }
        if (extras.getString("uf") != null) {
            endereco.setUf(extras.getString("uf"));
        }
        if (extras.getString("latitude") != null) {
            endereco.setLatitude(extras.getString("latitude"));
        }
        if (extras.getString("longitude") != null) {
            endereco.setLongitude(extras.getString("longitude"));
        }
        if (endereco.getId() != null) {
            acao.setEndereco(endereco);
        }

        Log.d(TAG, acao.toString());
        //Log.d(TAG, endereco.toString());
        Intent intent = new Intent(this, DetalhesEventos.class);
        intent.putExtra("acao", acao);
        NotificationUtils.create(this, intent, "Novo Evento", acao.getNome(), 1);
    }
}