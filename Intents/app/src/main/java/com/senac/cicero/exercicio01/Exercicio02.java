package com.senac.cicero.exercicio01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Exercicio02 extends AppCompatActivity {

    private Button botaoAbrirURL;
    private EditText enderecoURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio02);

        botaoAbrirURL   = findViewById(R.id.buttonAbrirURL);
        enderecoURL     = findViewById(R.id.editTextURL);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+enderecoURL.getText().toString()));

                startActivity(intent);
            }
        };
        botaoAbrirURL.setOnClickListener(listener);


    }
}
