package tcc.cosangueapp.activities;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import tcc.cosangueapp.R;

public class Informacoes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao_custom);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.tb_informacao);
        mToolbar.setTitle("Doação de Sangue");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        if (getFragmentManager().findFragmentById(R.id.content_informacao) == null) {
            getFragmentManager().beginTransaction().replace(R.id.content_informacao, new SettingsFragment()).commit();
        }
    }

    public static class SettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.activity_informacoes);
        }
    }


}
