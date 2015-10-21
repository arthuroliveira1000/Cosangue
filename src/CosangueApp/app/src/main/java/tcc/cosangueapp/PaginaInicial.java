package tcc.cosangueapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import tcc.cosangueapp.pojos.Usuario;

public class PaginaInicial extends AppCompatActivity {

    Bundle bdUsuarioLogado;
    Usuario usuario;
    private Toolbar mToolbar;
    private Drawer navegationDrawer;
    private AccountHeader headerNavegationDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_inicial);

        mToolbar = (Toolbar) findViewById(R.id.tb_pagina_inicial);
        mToolbar.setTitle("Faça parte da Comunidade!");

        setSupportActionBar(mToolbar);

        criaHeaderParaNavegationDrawer();

        criaNavegationDrawer(savedInstanceState);

        addItemsNoNavegationDrawer();

    }


    public void inicializaComponentes() {
        bdUsuarioLogado = getIntent().getExtras();
        usuario = (Usuario) bdUsuarioLogado.getSerializable("usuario");
    }


    private void criaHeaderParaNavegationDrawer() {
        // HEADER OF THE NAVEGATION DRAWER

        // Create the AccountHeader
        headerNavegationDrawer = new AccountHeaderBuilder()
                .withActivity(this)
                        //diminue o tamanho do header, mostra compactado - > .withCompactStyle(true)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem().withName(usuario.getNome()).withEmail(usuario.getLogin()).withIcon(R.drawable.profile)
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {

                        //AQUI VAI A AÇÃO DE QUANDO ELE CLICA NO PROFILE QUE SERIA A IMAGEM DO LOGO, QUANDO ELE CLICAR LÁ
                        // ADICIONAMOS O EVENTO DO CLIQUE AQUI
                        // IR PARA CONFIGURAÇÕES DA CONTA OU PERFIL
                        // ABRIR ACTIVITY COM O NEGOCIO DE VOLTAR PARA TELA ANTERIOR , MAIS FACIL DE MEXER

                        return false;
                    }
                })
                .build();
    }

    private void criaNavegationDrawer(Bundle savedInstanceState) {
        // NAVEGATION DRAWER LEFT
        navegationDrawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .withAccountHeader(headerNavegationDrawer)
                .withDisplayBelowStatusBar(true)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.LEFT)
                .withSavedInstance(savedInstanceState)
                .withSelectedItem(0)
                .withActionBarDrawerToggle(true)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {


                        // FAZER MÉTODO PRA MUDAR O ICONE QUANDO SELECIONADO (icon_selected)
                        //e colocar a linha de baixo que é pra ele alterar mesmo
                        // navegationDrawerLeft.getAdapter().notifyDataSetChanged();
                        return false;
                    }
                })
                .withOnDrawerItemLongClickListener(new Drawer.OnDrawerItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(View view, int i, IDrawerItem iDrawerItem) {
                        return false;
                    }
                })
                .build();


        /*

   CASO PRECISEMOS USAR O BOTÃO DE CHECK, NESSE MÉTODO É SETADO O QUE ACONTECE QUANDO O BOTÃO É ALTERADO


   private OnCheckedChangeListener mOnOnCheckedChangeListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(IDrawerItem drawerItem, CompoundButton buttonView, boolean isChecked) {

            Toast.makeText(PaginaInicial.this, "OnCheckedChanged: " + (isChecked ? "true" : "false"), Toast.LENGTH_SHORT).show();
        }
    };
*/

    }

    private void addItemsNoNavegationDrawer() {
        // criar icones com cor diferenciada para quando estiver selecionada ex.: account_selected
        navegationDrawer.addItem(new PrimaryDrawerItem().withName("Perfil").withIcon(R.drawable.account));
        navegationDrawer.addItem(new PrimaryDrawerItem().withName("Hemocentro").withIcon(R.drawable.ambulance));
        navegationDrawer.addItem(new PrimaryDrawerItem().withName("Eventos").withIcon(R.drawable.calendar));
        navegationDrawer.addItem(new PrimaryDrawerItem().withName("Doações").withIcon(R.drawable.doacao));
        navegationDrawer.addItem(new DividerDrawerItem());
        navegationDrawer.addItem(new PrimaryDrawerItem().withName("Configurações").withIcon(R.drawable.settings));
        //navegationDrawerLeft.addItem(new SectionDrawerItem().withName("Só pra dividir, sem ação"));


        // Exemplo switchDrawerItem  -> navegationDrawerLeft.addItem(new SwitchDrawerItem().withName("Notificação").withChecked(true).withOnCheckedChangeListener(mOnOnCheckedChangeListener));
        //Exemplo ToggleDrawerItem - > navegationDrawerLeft.addItem(new ToggleDrawerItem().withName("News").withChecked(true).withOnCheckedChangeListener(mOnOnCheckedChangeListener));

    }

}

