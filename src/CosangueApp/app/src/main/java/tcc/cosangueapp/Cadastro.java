package tcc.cosangueapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.net.DatagramPacket;

import tcc.cosangueapp.daos.UsuarioDAO;
import tcc.cosangueapp.pojos.Usuario;


public class Cadastro extends AppCompatActivity {

    EditText etLogin;
    EditText etSenha;
    EditText etNome;
    EditText etIdade;
    RadioButton rbMasculino;
    RadioButton rbFeminino;
    boolean valid;
    Usuario usuario;
    UsuarioDAO usuarioDAO;
    private Toolbar mToolbar;
    Spinner spTipoSanguineo;
    DatePicker dpDataNascimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        inicializaComponentes();
        validaCampos();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_proximo) {
            efetuaCadastro();

        }

        return super.onOptionsItemSelected(item);
    }

    private void inicializaComponentes() {
        mToolbar = (Toolbar) findViewById(R.id.tb_cadastro);
        mToolbar.setTitle("Cadastre-se");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        etLogin = (EditText) findViewById(R.id.et_login);
        etSenha = (EditText) findViewById(R.id.et_senha);
        etNome = (EditText) findViewById(R.id.et_nome);
        etIdade = (EditText) findViewById(R.id.et_idade);
        rbMasculino = (RadioButton) findViewById(R.id.rb_masculino);
        rbFeminino = (RadioButton) findViewById(R.id.rb_feminino);
        spTipoSanguineo = (Spinner) findViewById(R.id.sp_tipo_sanguineo);
        dpDataNascimento = (DatePicker) findViewById(R.id.dt_nascimento);
        valid = true;
        usuario = new Usuario();

    }

   

    public String sexoSelecionado() {
        if (rbMasculino.isChecked()) {
            return "M";
        }
        if (rbFeminino.isChecked()) {
            return "F";
        }
        return null;
    }

    public Boolean validaCampos() {

        valid = true;
        // VERIFICANDO SE SENHA É MAIOR OU IGUAL A 4 DIGITOS
        etSenha.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (etSenha.length() > 0 && etSenha.length() < 4) {
                    etSenha.setError("Digite uma Senha Entre 4 e 30 Dígitos!");
                    valid = false;
                }

            }
        });

        // VERIFICANDO SE IDADE NÃO ESTA IGUAL A ZERO
        etIdade.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (etIdade.equals("00") || etIdade.equals("0")) {
                    etSenha.setError("Idade Inválida!");
                    valid = false;
                }
            }
        });


        // VERIFICANDO SE NOME CONTEM SÓ LETRAS
        etNome.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (etNome.length() > 0) {
                    if (!etNome.getText().toString().matches("[a-zA-Z ]*") || etNome.length() < 2) {
                        etNome.setError("Nome Inválido!");
                        valid = false;
                    }
                }
            }
        });

        // VERIFICANDO SE LOGIN É MAIOR QUE 5 DIGITOS
        etLogin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (etLogin.length() > 0) {
                    if (etLogin.length() < 5) {
                        etLogin.setError("Login deve ter no mínimo 5 caracteres!");
                        valid = false;
                    }
                }
            }
        });

        return valid;
    }

    public void efetuaCadastro() {
        if (sexoSelecionado() == null || validaCampos() == false) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show();
        } else {
            new HttpRequestTask().execute(novoUsuario());
        }
    }

    public Usuario novoUsuario() {
        usuario.setLogin(etLogin.getText().toString());
        usuario.setSenha(etSenha.getText().toString());
        usuario.setNome(etNome.getText().toString());
        usuario.setIdade(Integer.parseInt(etIdade.getText().toString()));
        usuario.setSexo(sexoSelecionado());
        return usuario;
    }

    private class HttpRequestTask extends AsyncTask<Usuario, String, Usuario> {

        @Override
        protected Usuario doInBackground(Usuario... params) {

            try {
                usuarioDAO = new UsuarioDAO();
                Usuario retorno = usuarioDAO.cadastro(params);
                return retorno;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Usuario usuario) {
            if (usuario != null) {
                Intent abreTelaInicial = new Intent(Cadastro.this, PaginaInicial.class);
                Bundle usuarioLogado = new Bundle();
                usuarioLogado.putSerializable("usuario", usuario);
                abreTelaInicial.putExtras(usuarioLogado);
                startActivity(abreTelaInicial);
            } else {
                Toast.makeText(Cadastro.this, "Escolha outro nome de usuário!", Toast.LENGTH_LONG).show();
            }
        }
    }
}