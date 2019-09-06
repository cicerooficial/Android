package com.senac.cicero.testfragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AtividadeFragDinamico extends AppCompatActivity {

    private Button botaoFragmento01, botaoFragmento02;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade_frag_dinamico);

        botaoFragmento01    = findViewById(R.id.buttonFragmento01);
        botaoFragmento02    = findViewById(R.id.button2Fragmento02);

        botaoFragmento01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BlankFragmentTeste01 fragmento01 = new BlankFragmentTeste01();

                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmento01).commit();
            }
        });

        botaoFragmento02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BlankFragmentTeste02 fragmento02 = new BlankFragmentTeste02();

                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmento02).commit();

            }
        });

    }
}
