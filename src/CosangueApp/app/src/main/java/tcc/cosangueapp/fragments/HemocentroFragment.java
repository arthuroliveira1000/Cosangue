package tcc.cosangueapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import tcc.cosangueapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HemocentroFragment extends Fragment implements OnMapReadyCallback {


    private GoogleMap googleMap;


    public HemocentroFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_hemocentro, container, false);
       SupportMapFragment mapFragment = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.mapa_hemocentros);
        mapFragment.getMapAsync(this);
        return view;
    }


        @Override
        public void onMapReady(GoogleMap googleMap) {
            this.googleMap = googleMap;

            //if(localizacao do evento != null) { executa tudo
            // ativa botão pra pegar localização atual
            googleMap.setMyLocationEnabled(true);

                                        //(evento.endereco.latitude, evento.endereco.longitudo)
            LatLng localizacao = new LatLng(-29.8002047, -51.124366899999984);


            //Posiciona o mapa na coordenada desejada (zoom = 13)
            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(localizacao, 13);
            googleMap.moveCamera(update);

            // Marcador no local que o mapa vai dar zoom
            googleMap.addMarker(new MarkerOptions().title("Minha casa").snippet("Isso é o snippet").position(localizacao));

            //tipo de mapa
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            
    }
}
