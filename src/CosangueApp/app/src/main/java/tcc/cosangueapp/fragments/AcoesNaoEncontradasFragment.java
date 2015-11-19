package tcc.cosangueapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tcc.cosangueapp.R;
import tcc.cosangueapp.activities.AdicionaEvento;


public class AcoesNaoEncontradasFragment extends Fragment {

    private FloatingActionButton facCadastroEvento;

    public AcoesNaoEncontradasFragment() {
        // Required empty public constructor
    }

    private void acaoFloatingActionButton(View view) {
        this.facCadastroEvento = (FloatingActionButton) view.findViewById(R.id.fab_abre_cadastro_evento);

        facCadastroEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AdicionaEvento.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_acoes_nao_encontradas, container, false);
        acaoFloatingActionButton(view);

        return view;
    }


}
