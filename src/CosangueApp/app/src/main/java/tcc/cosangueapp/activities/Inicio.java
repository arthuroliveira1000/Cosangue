package tcc.cosangueapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import tcc.cosangueapp.R;
import tcc.cosangueapp.daos.UsuarioDAO;
import tcc.cosangueapp.pojos.Usuario;
import tcc.cosangueapp.utils.Constantes;

public class Inicio extends AppCompatActivity {

    EditText etUsuario;
    EditText etSenha;
    Button btEntrar;
    TextView tvCadastrar;
    Button btEntrarComFacebook;
    UsuarioDAO usuarioDAO;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        inicializaComponentes();

        acaoBtCadastrar();
        acaoBtEntrar();
        acaoBtEntrarComFacebook();

    }

    private void inicializaComponentes() {
        etUsuario = (EditText) findViewById(R.id.et_user);
        etSenha = (EditText) findViewById(R.id.et_password);
        btEntrar = (Button) findViewById(R.id.btn_entrar);
        tvCadastrar = (TextView) findViewById(R.id.tv_cadastro_usuario);
        btEntrarComFacebook = (Button) findViewById(R.id.btn_entrar_com_facebook);
    }

    private void acaoBtCadastrar() {
        tvCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreTela = new Intent(Inicio.this, Cadastro.class);
                startActivity(abreTela);
            }
        });
    }

    private void acaoBtEntrar() {
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

    private void acaoBtEntrarComFacebook() {
        btEntrarComFacebook.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Inicio.this, "Em construção", Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean validaCampos(String login, String senha) {
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
                preferences = getApplicationContext().getSharedPreferences(Constantes.NOME_SHARED_PREFERENCIES, 0);
                editor = preferences.edit();

                editor.putString("id", Long.toString(usuario.getId()));
                editor.putString("login", usuario.getLogin());
                editor.putString("nome", usuario.getNome());
                editor.putString("genero", usuario.getGenero().toString());

                editor.commit();

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