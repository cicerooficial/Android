package com.senac.cicero.exercicio01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Exercicio04 extends AppCompatActivity {

    EditText textoNumero1, textoNumero2, textoResultado;
    Button botaoCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio04);

        botaoCalcular   = findViewById(R.id.buttonCalcular);
        textoNumero1    = findViewById(R.id.editTextNumero1);
        textoNumero2    = findViewById(R.id.editTextNumero2);
        textoResultado  = findViewById(R.id.editTextResultado);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exercicio04.this, Exercicio04Detalhe.class);
                intent.putExtra("numero1",textoNumero1.getText().toString());
                intent.putExtra("numero2",textoNumero2.getText().toString());

                startActivityForResult (intent, 1);
                startActivity(intent);
            }
        };
        botaoCalcular.setOnClickListener(listener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1){
            if(resultCode == RESULT_OK){
                Double resultado = data.getDoubleExtra("resultado",0);
                textoResultado.setText(" " + resultado);
            }
        }

    }
}
