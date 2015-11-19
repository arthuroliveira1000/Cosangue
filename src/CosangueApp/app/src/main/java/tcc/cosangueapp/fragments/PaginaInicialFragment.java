package tcc.cosangueapp.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import tcc.cosangueapp.R;
import tcc.cosangueapp.activities.AdicionaEvento;
import tcc.cosangueapp.adapters.RVAdapter;
import tcc.cosangueapp.daos.UsuarioDAO;
import tcc.cosangueapp.pojos.Acao;
import tcc.cosangueapp.utils.Constantes;


public class PaginaInicialFragment extends Fragment {

    FloatingActionButton fabInseriAcao;
    private RecyclerView rv;
    private LinearLayoutManager llm;
    private RVAdapter adapter;
    private List<Acao> listaAcoes;
    private SharedPreferences spPreferencias;
    private SharedPreferences.Editor editarPreferencias;
    private String genero;
    private String nome;
    private String login;
    private Long id;
    private UsuarioDAO usuarioDAO;

    public PaginaInicialFragment() {
        // Required empty public constructor
    }

    private void inicializaComponentes(View view) {
        spPreferencias = getActivity().getSharedPreferences(Constantes.NOME_SHARED_PREFERENCIES, Context.MODE_APPEND);
        editarPreferencias = spPreferencias.edit();
        //nome = spPreferencias.getString("nome", null);
        //login = spPreferencias.getString("login", null);
        //genero = spPreferencias.getString("genero", null);
        id = Long.parseLong(spPreferencias.getString("id", null));
        rv = (RecyclerView) view.findViewById(R.id.rv);
        fabInseriAcao = (FloatingActionButton) view.findViewById(R.id.fab_inseri_acao);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pagina_inicial, container, false);
        inicializaComponentes(view);

        acaoFab();

      /* String registrationId = spPreferencias.getString(Constantes.PROPERTY_REG_ID, null);
        if (registrationId == null) {
            new HttpRequestTaskVerificaRegistrationId().execute(getActivity());
        }

      //new HttpRequestTaskGetAllAcoes().execute();*/
        return view;
    }

    public void acaoFab() {
        fabInseriAcao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AdicionaEvento.class);
                startActivity(intent);

              /*  Toast.makeText(getContext(), "entro no on click", Toast.LENGTH_LONG).show();
                replaceFragment(new InseriEventoFragment());*/
            }
        });
    }

    private void replaceFragment(Fragment frag) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fl_pagina_inicial, frag);
        ft.addToBackStack(null);
        ft.commit();
    }



}
