package tcc.cosangueapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Inicio extends Activity {

    EditText etUsuario;
    EditText etSenha;
    Button btEntrar;
    Button btCadastrar;
    Button btEntrarComFacebook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        inicializaComponentes();

        //ação botão cadastrar
        btCadastrar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreTelaCadastro = new Intent(Inicio.this, Cadastro.class);
                startActivity(abreTelaCadastro);
            }
        });

        //ação botão entrar
        btEntrar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreTelaInicial = new Intent(Inicio.this, PaginaInicial.class);
                startActivity(abreTelaInicial);
            }
        });
    }

    public void inicializaComponentes() {
        etUsuario = (EditText) findViewById(R.id.et_usuario);
        etSenha = (EditText) findViewById(R.id.et_senha);
        btEntrar = (Button) findViewById(R.id.bt_entrar);
        btCadastrar = (Button) findViewById(R.id.bt_cadastre_se);
        btEntrarComFacebook = (Button) findViewById(R.id.bt_entrar_facebook);
    }
}
