package com.senac.cicero.testactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Representa o componente de campo de texto do nome
    private EditText    textoNome;
    //Representa o botão de saudação
    private Button      botaoSaudar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding dos componetnes com os elementos do layout
        textoNome =     findViewById(R.id.textNome);
        botaoSaudar =   findViewById(R.id.buttonSaudar);

        //Define um listener de ação
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ação aqui
                showDialog("Olá " + textoNome.getText().toString() + " =)");
            }
        };

        //Associa o listener de ação com o botão
        botaoSaudar.setOnClickListener(listener);
    }

    public void showDialog(String message) {

        //Declara e instancia uma fábrica de construção de diálogos
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        //Configura o corpo da mensagem
        builder.setMessage(message);
        //Configura um botão de OK para fechamento (um
        // outro listener pode ser configurado no lugar do "null")
        builder.setPositiveButton("OK", null);
        //Cria efetivamente o diálogo
        AlertDialog dialog = builder.create();
        //faz com que o diálogo apareça na tela
        dialog.show();

    }

}
