package com.senac.cicero.navigationviewtest;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentos = new ArrayList<Fragment>();
    private List<String> titulos = new ArrayList<String>();

    public TabPagerAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        fragmentos.add(new Fragmento01());
        titulos.add("Fragmento 01");
        fragmentos.add(new Fragmento02());
        titulos.add("Fragmento02");

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
