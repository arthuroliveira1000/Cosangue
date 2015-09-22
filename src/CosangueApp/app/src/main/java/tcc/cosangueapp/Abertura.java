package tcc.cosangueapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;


public class Abertura extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abertura);

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(5000);
                Intent abreTelaCadastro = new Intent(Abertura.this, Inicio.class);
                startActivity(abreTelaCadastro);
            }
        }).start();

    }
    }
