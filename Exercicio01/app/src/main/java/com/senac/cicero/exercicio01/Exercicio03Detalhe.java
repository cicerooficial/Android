package com.senac.cicero.exercicio01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Exercicio03Detalhe extends AppCompatActivity {

    private EditText    textoRecebido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio03_detalhe);

        textoRecebido   = findViewById(R.id.editTextTextoRecebido);

                Intent intent = getIntent();
                String textoR = intent.getStringExtra("textoEnviado");
                textoRecebido.setText(textoR);


    }
}
