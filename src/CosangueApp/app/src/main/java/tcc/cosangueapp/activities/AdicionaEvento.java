package tcc.cosangueapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import java.util.List;

import tcc.cosangueapp.R;
import tcc.cosangueapp.adapters.PlaceAutocompleteAdapter;
import tcc.cosangueapp.daos.AcaoDAO;
import tcc.cosangueapp.daos.EnderecoDAO;
import tcc.cosangueapp.pojos.Acao;
import tcc.cosangueapp.pojos.Categoria;
import tcc.cosangueapp.pojos.Endereco;
import tcc.cosangueapp.utils.Constantes;

public class AdicionaEvento extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks {


    private static final LatLngBounds LIMITES_BRASIL = new LatLngBounds(
            new LatLng(-33.750833, -73.992222), new LatLng(5.272222, 34.791667));
    private static final int GOOGLE_API_CLIENT_ID = 0;
    private AutoCompleteTextView acLocalEvento;
    private GoogleApiClient googleApiClient;
    private PlaceAutocompleteAdapter mAdapter;
    private EditText etDescricaoEvento;
    private EditText etHorarioEvento;
    private EditText etDataEvento;
    private TextView tvCategoriaEvento;
    private EditText etNomeEvento;
    private Endereco endereco;
    private Acao acao;
    private FloatingActionButton fabInseri;
    private SharedPreferences spPreferencias;
    private SharedPreferences.Editor editarPreferencias;
    private Long idUsuario;


    private ResultCallback<PlaceBuffer> mUpdatePlaceDetailsCallback
            = new ResultCallback<PlaceBuffer>() {
        @Override
        public void onResult(PlaceBuffer places) {
            if (!places.getStatus().isSuccess()) {
                // Request did not complete successfully
                Log.e("Debug", "Place query did not complete. Error: " + places.getStatus().toString());
                places.release();
                return;
            }
            // Get the Place object from the buffer.
            final Place place = places.get(0);

            Geocoder geoCoder = new Geocoder(getApplicationContext());

            // Format details of the place for display and show it in a TextView.
            //PEGANDO DETALHES DE UM LOCAL

            endereco.setEnderecoCompleto(place.getAddress().toString());
            endereco.setLatitude(Double.toString(place.getLatLng().latitude));
            endereco.setLongitude(Double.toString(place.getLatLng().longitude));

            try {
                List<Address> geoCoderEndereco = geoCoder.getFromLocation(place.getLatLng().latitude, place.getLatLng().longitude, 1);

                Toast.makeText(getApplicationContext(),
                        "Endereço place: " + place.getAddress().toString(),
                        Toast.LENGTH_LONG).show();

                Toast.makeText(getApplicationContext(),
                        "Cidade: " + geoCoderEndereco.get(0).getLocality(),
                        Toast.LENGTH_LONG).show();


                Toast.makeText(getApplicationContext(),
                        "Estado: " + geoCoderEndereco.get(0).getAdminArea(),
                        Toast.LENGTH_LONG).show();

            } catch (java.io.IOException e) {
                e.printStackTrace();
            }

            Log.i("DEBUG", "Place details received: " + place.getName());

            places.release();
        }
    };
    private AdapterView.OnItemClickListener mAutocompleteClickListener
            = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            final PlaceAutocompleteAdapter.PlaceAutocomplete item = mAdapter.getItem(position);
            final String placeId = String.valueOf(item.placeId);

            PendingResult<PlaceBuffer> placeResult = Places.GeoDataApi
                    .getPlaceById(googleApiClient, placeId);
            placeResult.setResultCallback(mUpdatePlaceDetailsCallback);

            Log.i("Debug", "Called getPlaceById to get Place details for " + placeId);
        }
    };

    private static Spanned formatPlaceDetails(Resources res, CharSequence name, String id,
                                              CharSequence address, CharSequence phoneNumber, Uri websiteUri) {
        Log.e("DEBUG", res.getString(R.string.hello_world, name, id, address, phoneNumber,
                websiteUri));
        return Html.fromHtml(res.getString(R.string.hello_world, name, id, address, phoneNumber,
                websiteUri));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_evento);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_inserir_eventos);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        buildGoogleApiClient();
        inicializaComponentes();
        acaoBotaoInserir();
    }

    protected synchronized void buildGoogleApiClient() {
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, GOOGLE_API_CLIENT_ID /* clientId */, this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .build();
    }

    private Acao preencheAcao() {
        acao.setNome(etNomeEvento.getText().toString());
        acao.setDescricao(etDescricaoEvento.getText().toString());
        acao.setCategoria(Categoria.SOLICITACAO);
        acao.setHorario(etHorarioEvento.getText().toString());
        acao.setData(etDataEvento.getText().toString());
        return acao;
    }

    private void inicializaComponentes() {
        this.endereco = new Endereco();
        this.acao = new Acao();
        this.etDescricaoEvento = (EditText) findViewById(R.id.et_descricao_evento);
        this.etHorarioEvento = (EditText) findViewById(R.id.et_horario_evento);
        this.etDataEvento = (EditText) findViewById(R.id.et_data_evento);
        this.tvCategoriaEvento = (TextView) findViewById(R.id.categoria_evento);
        this.tvCategoriaEvento.setText(Categoria.SOLICITACAO.toString());
        this.etNomeEvento = (EditText) findViewById(R.id.et_nome_evento);
        this.fabInseri = (FloatingActionButton) findViewById(R.id.fab_inserir);
        this.mAdapter = new PlaceAutocompleteAdapter(this, android.R.layout.simple_list_item_1,
                googleApiClient, LIMITES_BRASIL, null);
        this.acLocalEvento = (AutoCompleteTextView) findViewById(R.id.auto_complete_local_evento);
        this.acLocalEvento.setAdapter(mAdapter);
        this.acLocalEvento.setOnItemClickListener(mAutocompleteClickListener);
        spPreferencias = getApplicationContext().getSharedPreferences(Constantes.NOME_SHARED_PREFERENCIES, MODE_APPEND);
        editarPreferencias = spPreferencias.edit();
        idUsuario = Long.parseLong(spPreferencias.getString("id", null));
    }

    private void acaoBotaoInserir() {
        fabInseri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etDescricaoEvento.getText().length() > 5 && etHorarioEvento.getText() != null && etDataEvento.getText() != null && etNomeEvento.getText() != null && acLocalEvento.getText() != null) {
                    preencheAcao();
                    new HttpRequestTaskSalvaAcao().execute(idUsuario, acao, endereco);
                } else {
                    Toast.makeText(AdicionaEvento.this, "Preencha todos os campos!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }


    private class HttpRequestTaskSalvaAcao extends AsyncTask<Object, Void, Void> {

        @Override
        protected Void doInBackground(Object... params) {
            if (params[1] != null) {
                AcaoDAO acaoDao = new AcaoDAO();
                EnderecoDAO enderecoDao = new EnderecoDAO();
                Acao acaoRetornada = acaoDao.post(params);
                Endereco enderecoRetornado = enderecoDao.post(params);
                if (acaoRetornada != null && enderecoRetornado != null) {
                    enderecoDao.atualizaEndereco(enderecoRetornado.getId().toString(), acaoRetornada.getId().toString());
                    acaoDao.put(acaoRetornada.getId().toString(), params[0].toString());
                    Toast.makeText(AdicionaEvento.this, "Evento criado!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AdicionaEvento.this, PaginaInicial.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(AdicionaEvento.this, "Erro ao criar o evento!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AdicionaEvento.this, PaginaInicial.class);
                    startActivity(intent);
                }
            }
            return null;
        }
    }

}
