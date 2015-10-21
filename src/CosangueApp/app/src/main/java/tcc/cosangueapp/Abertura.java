package tcc.cosangueapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;


public class Abertura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abertura);

        inicializaAbertura();
    }

    public void inicializaAbertura() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(4000);
                Intent abreTelaCadastro = new Intent(Abertura.this, Inicio.class);
                startActivity(abreTelaCadastro);
            }
        }).start();
    }
}
