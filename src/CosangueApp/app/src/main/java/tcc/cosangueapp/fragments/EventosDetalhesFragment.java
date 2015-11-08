package tcc.cosangueapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import tcc.cosangueapp.R;
import tcc.cosangueapp.pojos.Acao;

public class EventosDetalhesFragment extends Fragment {

    EditText nomeEvento;
    EditText descricaoEvento;
    private EditText localEvento;
    private EditText horaEvento;
    private EditText dataEvento;
    private EditText categoriaEvento;
    private EditText solicatacaoEvento;

    public EventosDetalhesFragment() {
        // Required empty public constructor
    }

    private void inicializaComponentes() {
        this.nomeEvento = (EditText) getActivity().findViewById(R.id.tv_dado_nome_evento);
        this.descricaoEvento = (EditText) getActivity().findViewById(R.id.tv_dado_descricao_evento);
        this.localEvento = (EditText) getActivity().findViewById(R.id.tv_dado_local_evento);
        this.horaEvento = (EditText) getActivity().findViewById(R.id.tv_dado_horario_evento);
        this.dataEvento = (EditText) getActivity().findViewById(R.id.tv_dado_data_evento);
        this.categoriaEvento = (EditText) getActivity().findViewById(R.id.tv_dado_categoria_evento);
        this.solicatacaoEvento = (EditText) getActivity().findViewById(R.id.tv_dado_solicitacoes_evento);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_detalhes_eventos, container, false);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setHomeButtonEnabled(true);
        inicializaComponentes();

        //pega o bundle da activity
        Bundle dados = activity.getIntent().getExtras();
        if (dados != null) {
            Acao acao = (Acao) dados.getSerializable("acao");
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

       /* @Override ----> ver se ainda tem o botão de voltar, provavelmente sim
        public boolean onOptionsItemSelected(MenuItem item){
            switch (item.getItemId()) {
                case android.R.id.home:
                    getActivity().onBackPressed();
            }
            return super.onOptionsItemSelected(item);
        }*/
        return view;
    }
}