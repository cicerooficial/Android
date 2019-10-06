package com.senac.cicero.menu_cabecalho_exercicio1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class Exercicio3_PagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentos = new ArrayList<Fragment>();
    private List<String> titulos = new ArrayList<String>();

    public Exercicio3_PagerAdapter(FragmentManager fm) {
        super(fm);

        fragmentos.add(new Fragmento01());
        titulos.add("Fragmento 01");
        fragmentos.add(new Fragmento02());
        titulos.add("Fragmento02");
        fragmentos.add(new Fragmento03());
        titulos.add("Fragmento03");

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentos.get(position);
    }

    @Override
    public int getCount() {
        return fragmentos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titulos.get(position);
    }


}
