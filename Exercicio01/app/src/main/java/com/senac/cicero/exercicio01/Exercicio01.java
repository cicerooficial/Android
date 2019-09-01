package com.senac.cicero.exercicio01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Exercicio01 extends AppCompatActivity {

    private Button  botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio01);


       botao = findViewById(R.id.buttonCliqueAqui);

       //Define um listener de ação
        View.OnClickListener listener = new View.OnClickListener(){

            public void onClick(View view){

                Intent intent = new Intent(Exercicio01.this,Exercicio01Detalhe.class);

                startActivity(intent);

            }

        };
        botao.setOnClickListener(listener);

    }
}
