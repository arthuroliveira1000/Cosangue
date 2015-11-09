package tcc.cosangueapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import tcc.cosangueapp.R;
import tcc.cosangueapp.pojos.Acao;

public class DetalhesEventos extends AppCompatActivity {

    private TextView nomeEvento;
    private TextView descricaoEvento;
    private TextView localEvento;
    private TextView horaEvento;
    private TextView dataEvento;
    private TextView categoriaEvento;
    private TextView solicatacaoEvento;
    private Acao acao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_eventos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_detalhes_eventos);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        inicializaComponentes();

        //pega o bundle da activity
        // se não funcionar tem que jogar isso pra dentro de um método passando a ação como parametro numa UiThread
        acao = (Acao) getIntent().getExtras().getSerializable("acao");

        if (acao != null) {
            if (acao.getNome() != null) {
                nomeEvento.setText(acao.getNome());
            }
            if (acao.getDescricao() != null) {
                descricaoEvento.setText(acao.getDescricao());
            }
            if (acao.getEndereco() != null) {
                localEvento.setText(acao.getEndereco().getLogradouro() + ", " + acao.getEndereco().getNr() + ", " + acao.getEndereco().getBairro() + "- " + acao.getEndereco().getCidade());
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
            if (acao.getHemocomponente() != null || acao.getTipo() != null) {
                if (acao.getHemocomponente() != null && acao.getTipo() != null)
                    solicatacaoEvento.setText(acao.getHemocomponente() + " e" + acao.getTipo());
                else if (acao.getHemocomponente() != null && acao.getTipo() == null) {
                    solicatacaoEvento.setText(acao.getHemocomponente().toString());
                } else if (acao.getHemocomponente() == null && acao.getTipo() != null) {
                    solicatacaoEvento.setText(acao.getTipo().toString());
                }

            } else {
                //tirar os cards  da tela
            }


            // setar os text dos textview com os recebidos por parametro
            // só setar a açao do botao floating actionButton


        }


    }


    private void inicializaComponentes() {
        this.nomeEvento = (TextView) findViewById(R.id.tv_dado_nome_evento);
        this.descricaoEvento = (TextView) findViewById(R.id.tv_dado_descricao_evento);
        this.localEvento = (TextView) findViewById(R.id.tv_dado_local_evento);
        this.horaEvento = (TextView) findViewById(R.id.tv_dado_horario_evento);
        this.dataEvento = (TextView) findViewById(R.id.tv_dado_data_evento);
        this.categoriaEvento = (TextView) findViewById(R.id.tv_dado_categoria_evento);
        this.solicatacaoEvento = (TextView) findViewById(R.id.tv_dado_solicitacoes_evento);
        acao = new Acao();
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Bundle dados = intent.getExtras();
        if (dados != null) {
            if (dados.containsKey("acao")) {
                Toast.makeText(this, "Sim, tô recebendo uma açao!", Toast.LENGTH_SHORT).show();
                acao = (Acao) dados.getSerializable("acao");
                // chama metodo preenchecampos aqui
            }
        } else {
            Toast.makeText(this, "ihh, tô recebendo nada não amigo!", Toast.LENGTH_SHORT).show();
        }
    }


    // método chamado dentro de um UiThread
    private void preencheCampos(Acao acao) {
        if (acao != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Acao acao = (Acao) getIntent().getExtras().getSerializable("acao");
                    if (acao.getNome() != null) {
                        nomeEvento.setText(acao.getNome());
                    }
                    if (acao.getDescricao() != null) {
                        descricaoEvento.setText(acao.getDescricao());
                    }
                    if (acao.getEndereco() != null) {
                        localEvento.setText(acao.getEndereco().getLogradouro() + ", " + acao.getEndereco().getNr() + ", " + acao.getEndereco().getBairro() + "- " + acao.getEndereco().getCidade());
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
                    if (acao.getHemocomponente() != null || acao.getTipo() != null) {
                        if (acao.getHemocomponente() != null && acao.getTipo() != null)
                            solicatacaoEvento.setText(acao.getHemocomponente() + " e" + acao.getTipo());
                        else if (acao.getHemocomponente() != null && acao.getTipo() == null) {
                            solicatacaoEvento.setText(acao.getHemocomponente().toString());
                        } else if (acao.getHemocomponente() == null && acao.getTipo() != null) {
                            solicatacaoEvento.setText(acao.getTipo().toString());
                        }

                    } else {
                        //tirar os cards  da tela
                    }


                }
            });
        }
    }
}
