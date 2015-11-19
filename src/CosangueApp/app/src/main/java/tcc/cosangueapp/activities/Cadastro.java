package tcc.cosangueapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import tcc.cosangueapp.R;
import tcc.cosangueapp.daos.UsuarioDAO;
import tcc.cosangueapp.pojos.Genero;
import tcc.cosangueapp.pojos.TipoSanguineo;
import tcc.cosangueapp.pojos.Usuario;
import tcc.cosangueapp.utils.Constantes;


public class Cadastro extends AppCompatActivity {

    EditText etLogin;
    EditText etSenha;
    EditText etNome;
    RadioButton rbMasculino;
    RadioButton rbFeminino;
    boolean valid;
    Usuario usuario;
    UsuarioDAO usuarioDAO;
    Spinner spTipoSanguineo;
    EditText etNascimento;
    ArrayAdapter<TipoSanguineo> adapter;
    private Toolbar mToolbar;

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
        mToolbar.setTitle("Cadastre-se!");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.up_indicator);
        etLogin = (EditText) findViewById(R.id.et_login);
        etSenha = (EditText) findViewById(R.id.et_senha);
        etNome = (EditText) findViewById(R.id.et_nome);
        rbMasculino = (RadioButton) findViewById(R.id.rb_masculino);
        rbFeminino = (RadioButton) findViewById(R.id.rb_feminino);
        spTipoSanguineo = (Spinner) findViewById(R.id.sp_tipo_sanguineo);
        etNascimento = (EditText) findViewById(R.id.et_nascimento);
        adapter = new ArrayAdapter<TipoSanguineo>(this, android.R.layout.simple_spinner_item, TipoSanguineo.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipoSanguineo.setAdapter(adapter);
        valid = true;
        usuario = new Usuario();
    }

    public String tipoSanguineoSelecionado() {
        String tipoSanguineoSelecionado = spTipoSanguineo.getSelectedItem().toString();
        return tipoSanguineoSelecionado;
    }

    public Genero generoSelecionado() {
        if (rbMasculino.isChecked()) {
            return Genero.MASCULINO;
        }
        if (rbFeminino.isChecked()) {
            return Genero.FEMININO;
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
        if (generoSelecionado() == null || validaCampos() == false || etSenha.getText().length() == 0 || etLogin.getText().length() == 0 || etNome.getText().length() == 0 || etNascimento.getText().length() == 0) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show();
        } else {
            new HttpRequestTask().execute(novoUsuario());
        }
    }

    public Usuario novoUsuario() {
        usuario.setLogin(etLogin.getText().toString());
        usuario.setSenha(etSenha.getText().toString());
        usuario.setNome(etNome.getText().toString());

        int idTipoSanguineo = (int) spTipoSanguineo.getSelectedItemId();
        TipoSanguineo tipoSelecionado = TipoSanguineo.values()[idTipoSanguineo];
        usuario.setTipoSanguineo(tipoSelecionado);
        usuario.setGenero(generoSelecionado());
        usuario.setDataNascimento(etNascimento.getText().toString());
        Log.i("DEBUG", usuario.getGenero().toString());
        Log.i("DEBUG", usuario.getDataNascimento().toString());
        Log.i("DEBUG", usuario.getTipoSanguineo().toString());

        return usuario;
    }

    public void abreTelaInicial(Usuario usuario) {
        Intent abreTelaInicial = new Intent(Cadastro.this, PaginaInicial.class);
        Bundle usuarioLogado = new Bundle();
        usuarioLogado.putSerializable("usuario", usuario);
        abreTelaInicial.putExtras(usuarioLogado);
        startActivity(abreTelaInicial);
    }

    private class HttpRequestTask extends AsyncTask<Usuario, String, Usuario> {

        @Override
        protected Usuario doInBackground(Usuario... params) {

            try {
                usuarioDAO = new UsuarioDAO();
                Usuario retorno = usuarioDAO.post(params);
                return retorno;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Usuario usuario) {
            if (usuario != null) {
                SharedPreferences preferences = getApplicationContext().getSharedPreferences(Constantes.NOME_SHARED_PREFERENCIES, 0);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString("id", Long.toString(usuario.getId()));
                editor.putString("login", usuario.getLogin());
                editor.putString("nome", usuario.getNome());
                editor.putString("genero", usuario.getGenero().toString());

                editor.commit();
                abreTelaInicial(usuario);
            } else {
                Toast.makeText(Cadastro.this, "Escolha outro nome de usuário!", Toast.LENGTH_LONG).show();
            }
        }
    }
}