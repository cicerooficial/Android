package com.senac.cicero.testactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Exemplo01Activity extends AppCompatActivity {

    //Representa o componente de campo de texto do nome
    private EditText    nome;
    //Representa o botão de saudação
    private Button      botao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo01);

        //Binding dos componentes com os elementos do layout
        nome    =  findViewById(R.id.editTextNome);
        botao   = findViewById(R.id.buttonSaudar);

        //Define um listener de ação
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ação aqui
                showDialog("Olá " + nome.getText().toString(), " Boas Vindas!");
            }
        };
        //Associa o listener de ação com o botão
        botao.setOnClickListener(listener);
    }

    private void showDialog(String message, String title) {

        //Declara e instancia uma fábrica de construção de diálogos
        AlertDialog.Builder builder = new AlertDialog.Builder(Exemplo01Activity.this);
        //Configura o corpo da mensagem
        builder.setMessage(message);
        //COnfigura o título da mensagem
        builder.setTitle(title);

        //Impede que o botão seja cancelável (possa clicar
        //em voltar ou fora para fechar
        builder.setCancelable(false);
        //COnfigura um botão de OK para fechamento (um
        //outro listener pode ser cofigurado no lugar no "null")
        builder.setPositiveButton("OK", null);
        //Cria efetivamente o diálogo
        AlertDialog dialog = builder.create();
        //Faz com que o diálogo apareça na tela
        dialog.show();


    }

}
