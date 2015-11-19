package tcc.cosangueapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import tcc.cosangueapp.R;
import tcc.cosangueapp.pojos.Acao;
import tcc.cosangueapp.utils.Constantes;

public class DetalhesEventos extends AppCompatActivity {

    private TextView nomeEvento;
    private TextView descricaoEvento;
    private TextView localEvento;
    private TextView horaEvento;
    private TextView dataEvento;
    private TextView categoriaEvento;
    private Acao acao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_eventos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_descricao_eventos);
        toolbar.setTitle("");
        toolbar.setSubtitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        inicializaComponentes();

        acao = (Acao) getIntent().getExtras().getSerializable("acao");

        if (acao != null) {
            if (acao.getNome() != null) {
                nomeEvento.setText(acao.getNome());
            }
            if (acao.getDescricao() != null) {
                descricaoEvento.setText(acao.getDescricao());
            }
            if (acao.getEndereco().getEnderecoCompleto() != null) {
                localEvento.setText(acao.getEndereco().getEnderecoCompleto());
            }
            if (acao.getData() != null) {
                dataEvento.setText(acao.getData());
            }

            if (acao.getHorario() != null) {
                horaEvento.setText(acao.getHorario());
            }

            if (acao.getCategoria() != null) {
                categoriaEvento.setText(acao.getCategoria().toString());
            }


        } else {
            //tirar os cards  da tela
        }
    }

    private void inicializaComponentes() {
        this.nomeEvento = (TextView) findViewById(R.id.tv_dado_nome_evento);
        this.descricaoEvento = (TextView) findViewById(R.id.tv_dado_descricao_evento);
        this.localEvento = (TextView) findViewById(R.id.tv_dado_local_evento);
        this.horaEvento = (TextView) findViewById(R.id.tv_dado_horario_evento);
        this.dataEvento = (TextView) findViewById(R.id.tv_dado_data_evento);
        this.categoriaEvento = (TextView) findViewById(R.id.tv_dado_categoria_evento);
        acao = new Acao();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Bundle dados = intent.getExtras();
        if (dados != null) {
            if (dados.containsKey("acao")) {
                Log.i(Constantes.TAG, "Json acao recebido!");
                acao = (Acao) dados.getSerializable("acao");

            }
        } else {
            Log.i(Constantes.TAG, "Json acao não recebido!");
        }
    }
}
