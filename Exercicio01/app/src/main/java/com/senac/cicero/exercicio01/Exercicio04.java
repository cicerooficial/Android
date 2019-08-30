package com.senac.cicero.exercicio01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Exercicio04 extends AppCompatActivity {

    EditText textoNumero1, textoNumero2, textoResultado;
    Button botaoSomar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio04);

        botaoSomar      = findViewById(R.id.buttonCalcular);
        textoNumero1    = findViewById(R.id.editTextNumero1);
        textoNumero2    = findViewById(R.id.editTextNumero2);
        textoResultado  = findViewById(R.id.editTextResultado);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exercicio04.this, Exercicio04Detalhe.class);



            }
        };

        botaoSomar.setOnClickListener(listener);


    }
}
