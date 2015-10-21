package tcc.cosangueapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import tcc.cosangueapp.daos.UsuarioDAO;
import tcc.cosangueapp.pojos.Usuario;

public class Inicio extends AppCompatActivity {

    EditText etUsuario;
    EditText etSenha;
    Button btEntrar;
    TextView tvCadastrar;
    Button btEntrarComFacebook;
    UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        inicializaComponentes();

        acaoBtCadastrar();
        acaoBtEntrar();
        acaoBtEntrarComFacebook();

    }

    public void inicializaComponentes() {
        etUsuario = (EditText) findViewById(R.id.et_user);
        etSenha = (EditText) findViewById(R.id.et_password);
        btEntrar = (Button) findViewById(R.id.btn_entrar);
        tvCadastrar = (TextView) findViewById(R.id.tv_cadastro_usuario);
        btEntrarComFacebook = (Button) findViewById(R.id.btn_entrar_com_facebook);
    }

    public void acaoBtCadastrar() {
        tvCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreTela = new Intent(Inicio.this, Cadastro.class);
                startActivity(abreTela);
            }
        });
    }

    public void acaoBtEntrar() {
        btEntrar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                String login = etUsuario.getText().toString();
                String senha = etSenha.getText().toString();

                if (validaCampos(login, senha)) {
                    new HttpRequestTask().execute(login, senha);
                }
            }
        });
    }

    public void acaoBtEntrarComFacebook() {
        btEntrarComFacebook.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreTela = new Intent(Inicio.this, PaginaInicial.class);
                startActivity(abreTela);
            }
        });
    }

    public boolean validaCampos(String login, String senha) {
        boolean valid = true;

        if (senha.isEmpty() || senha.length() < 4) {
            etSenha.setError("Senha de 4 a 20 digitos alfanuméricos");
            valid = false;
        } else {
            etSenha.setError(null);
        }

        if (login.isEmpty() || login.length() < 4) {
            etUsuario.setError("Digite um nome de usuário válido!");
            valid = false;
        } else {
            etUsuario.setError(null);
        }


        return valid;
    }

    private class HttpRequestTask extends AsyncTask<String, String, Usuario> {

        @Override
        protected Usuario doInBackground(String... params) {

            try {
                usuarioDAO = new UsuarioDAO();
                Usuario retorno = usuarioDAO.login(params);
                return retorno;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Usuario usuario) {
            if (usuario != null) {
                Intent abreTelaInicial = new Intent(Inicio.this, PaginaInicial.class);
                Bundle usuarioLogado = new Bundle();
                usuarioLogado.putSerializable("usuario", usuario);
                abreTelaInicial.putExtras(usuarioLogado);
                startActivity(abreTelaInicial);
            } else {
                Toast.makeText(Inicio.this, "Login ou senha incorretos!", Toast.LENGTH_LONG).show();
            }
        }
    }
}