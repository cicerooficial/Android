package com.senac.cicero.exercicio01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Exercicio04Detalhe extends AppCompatActivity {

    Button botaoSomar, botaoSubtrair, botaoMultiplicar, botaoDividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio04_detalhe);

        botaoSomar          = findViewById(R.id.buttonSomar);
        botaoSubtrair       = findViewById(R.id.buttonSubtrair);
        botaoMultiplicar    = findViewById(R.id.buttonMultiplicar);
        botaoDividir        = findViewById(R.id.buttonDividir);

        View.OnClickListener listenerSomar = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();
                String numero1          = intent.getStringExtra("numero1");
                String numero2          = intent.getStringExtra("numero2");
                Double resultadodaSoma  = Double.parseDouble(numero1) + Double.parseDouble(numero2);

                Intent returnIntent = new Intent();
                returnIntent.putExtra("resultado", resultadodaSoma);
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        };
        botaoSomar.setOnClickListener(listenerSomar);

        View.OnClickListener listenerSubstrair = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();
                String numero1          = intent.getStringExtra("numero1");
                String numero2          = intent.getStringExtra("numero2");
                Double resultadodaSoma  = Double.parseDouble(numero1) - Double.parseDouble(numero2);

                Intent returnIntent = new Intent();
                returnIntent.putExtra("resultado", resultadodaSoma);
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        };
        botaoSubtrair.setOnClickListener(listenerSubstrair);

        View.OnClickListener listenerMultiplicar = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();
                String numero1          = intent.getStringExtra("numero1");
                String numero2          = intent.getStringExtra("numero2");
                Double resultadodaSoma  = Double.parseDouble(numero1) * Double.parseDouble(numero2);

                Intent returnIntent = new Intent();
                returnIntent.putExtra("resultado", resultadodaSoma);
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        };
        botaoMultiplicar.setOnClickListener(listenerMultiplicar);

        View.OnClickListener listenerDividir = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();
                String numero1          = intent.getStringExtra("numero1");
                String numero2          = intent.getStringExtra("numero2");
                Double resultadodaSoma  = Double.parseDouble(numero1) / Double.parseDouble(numero2);

                Intent returnIntent = new Intent();
                returnIntent.putExtra("resultado", resultadodaSoma);
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        };
        botaoDividir.setOnClickListener(listenerDividir);

    }
}
