package tcc.cosangueapp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import tcc.cosangueapp.pojos.Usuario;

public class Inicio extends Activity {

    // mudar conforme a rede - endereço ipv4 - ipconfig - cmd
    final String URL = "http://192.168.0.103:8080/CosangueRESTful/usuario/login/{login}/{senha}";
    EditText etUsuario;
    EditText etSenha;
    Button btEntrar;
    TextView tvCadastrar;
    Button btEntrarComFacebook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        inicializaComponentes();

        //açao botao cadastrar-se
        tvCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreTela = new Intent(Inicio.this, Cadastro.class);
                startActivity(abreTela);
            }
        });

        //ação botão entrar
        btEntrar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                //executa a classe que se comunica com o ws em outra thread

                String login = etUsuario.getText().toString();
                String senha = etSenha.getText().toString();

                if (validaCampos(login, senha)) {
                    new HttpRequestTask().execute(login, senha);
                }
            }
        });

        //ação text view entrar com facebook
        btEntrarComFacebook.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreTela = new Intent(Inicio.this, PaginaInicial.class);
                startActivity(abreTela);
            }
        });

    }

    public void inicializaComponentes() {
        etUsuario = (EditText) findViewById(R.id.et_user);
        etSenha = (EditText) findViewById(R.id.et_password);
        btEntrar = (Button) findViewById(R.id.btn_entrar);
        tvCadastrar = (TextView) findViewById(R.id.tv_cadastro_usuario);
        btEntrarComFacebook = (Button) findViewById(R.id.btn_entrar_com_facebook);
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

        //retornará um usuário
        //ferramenta usada pra fazer toda a comunicação com ws através do framework do Spring para Android


        @Override
        protected Usuario doInBackground(String... params) {

            try {
                RestTemplate restTemplate = new RestTemplate();
                //utiliza a biblioteca do jackson para converter os dados recebidos e enviados
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                //ver o que faz
                restTemplate.setRequestFactory(
                        new HttpComponentsClientHttpRequestFactory());
                //url que será acessada, tipo do retorno e parametro que o método do ws determinda

                Usuario usuarioRetornado = restTemplate.getForObject(URL, Usuario.class, params);


                return usuarioRetornado;
            } catch (Exception e) {

            }

            return null;
        }


        //usuario do parametro abaixo é o retorno do metodo de cima, doInBackground
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