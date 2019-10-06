package com.senac.cicero.menu_cabecalho_exercicio1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        navigationView = findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                        if (menuItem.isChecked()) {
                            menuItem.setChecked(false);
                        } else {
                            menuItem.setChecked(true);
                        }

                        drawerLayout.closeDrawers();

                        if (menuItem.getItemId() == R.id.produto) {
                            Fragmento01 fragmento01 = new Fragmento01();
                            getSupportFragmentManager().beginTransaction().replace(
                                    R.id.frag_container, fragmento01).commit();
                            return true;
                        } else if (menuItem.getItemId() == R.id.cliente) {
                            Fragmento02 fragmento02 = new Fragmento02();
                            getSupportFragmentManager().beginTransaction().replace(
                                    R.id.frag_container, fragmento02).commit();
                            return true;
                        } else if (menuItem.getItemId() == R.id.usuario) {
                            Fragmento03 fragmento03 = new Fragmento03();
                            getSupportFragmentManager().beginTransaction().replace(
                                    R.id.frag_container, fragmento03).commit();
                            return true;
                        }
                        return false;
                    }
                }
        );

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.openDrawer, R.string.closeDrawer) {

        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Carrega o menu
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        if (id == R.id.Sobre) {
            Intent intent = new Intent(this, SobreActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.Sair) {
            finish();
        }

        return super.onOptionsItemSelected(item);

    }
}



