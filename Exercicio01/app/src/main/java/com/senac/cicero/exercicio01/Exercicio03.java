package com.senac.cicero.exercicio01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Exercicio03 extends AppCompatActivity {

    private EditText    textoEnviado;
    private Button      botaoEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio03);

        textoEnviado    = findViewById(R.id.editTextTextoEnviado);
        botaoEnviar     = findViewById(R.id.buttonEnviar);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intente = new Intent(Exercicio03.this,Exercicio03Detalhe.class);
                intente.putExtra("textoEnviado",textoEnviado.getText().toString());

                startActivity(intente);

            }
        };
    botaoEnviar.setOnClickListener(listener);

    }
}
