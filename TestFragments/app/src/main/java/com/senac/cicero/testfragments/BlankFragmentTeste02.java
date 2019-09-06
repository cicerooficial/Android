package com.senac.cicero.testfragments;


import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragmentTeste02 extends Fragment {

    private Button botaoMensagem;

    public BlankFragmentTeste02() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment_teste02, container, false);

        botaoMensagem = view.findViewById(R.id.buttonMensagem);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessageDialog("Olá","Você está no fragmento02");
            }
        };
        botaoMensagem.setOnClickListener(listener);
        return view;
    }
    private void showMessageDialog(String tittle, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(tittle);
        builder.setMessage(message);
        builder.setPositiveButton("OK",null);
        builder.create().show();
    }


}
