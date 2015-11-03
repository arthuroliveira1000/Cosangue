package tcc.cosangueapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import tcc.cosangueapp.R;
import tcc.cosangueapp.utils.Constantes;


public class Abertura extends AppCompatActivity {

    private SharedPreferences spPreferencias;
    private SharedPreferences.Editor editarPreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abertura);
        inicializaComponentes();
        inicializaAbertura();
    }

    private void inicializaComponentes() {
        spPreferencias = getApplicationContext().getSharedPreferences(Constantes.NOME_SHARED_PREFERENCIES, MODE_APPEND);
        editarPreferencias = spPreferencias.edit();
    }

    private void inicializaAbertura() {
        new Thread(new Runnable() {
            @Override
            public void run() {
               if (verificaSeUsuarioJaLogou()) {
                  startActivity(new Intent(Abertura.this, PaginaInicial.class));
               } else {
                    SystemClock.sleep(3000);
                    startActivity(new Intent(Abertura.this, Inicio.class));
                }
            }
        }).start();
    }

    private boolean verificaSeUsuarioJaLogou() {
        boolean logou = false;

        String strId = spPreferencias.getString("id", null);
        String strLogin = spPreferencias.getString("login", null);
        String strNome = spPreferencias.getString("nome", null);
        String strGenero = spPreferencias.getString("genero", null);

        if (strId != null || strNome != null ||  strGenero != null || strLogin != null) {
            logou = true;
        }
        return logou;
    }
}
