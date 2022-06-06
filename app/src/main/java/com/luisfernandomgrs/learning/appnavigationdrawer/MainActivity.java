package com.luisfernandomgrs.learning.appnavigationdrawer;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.luisfernandomgrs.learning.appnavigationdrawer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // configura barra de navegação
        setSupportActionBar(binding.appBarMain.toolbar);

        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Sua notificação poderá ser exibida aqui, :)", Snackbar.LENGTH_LONG)
                        .setAction("NoAction", null).show();
            }
        });

        // Cria uma referência para toda a àrea do NavigationDrawer
        DrawerLayout drawer = binding.drawerLayout;

        // Cria uma referência para a àrea de navegação
        NavigationView navigationView = binding.navView;

        // Define configurações do NavigationDrawer
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();

        // Cria referência para a àrea que irá carregar os fragments
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        // Configura o menu superir de navegação, ou o Menu de ações da ActionBar
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        // Configura a negação dentro das opções no NavigationView
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}