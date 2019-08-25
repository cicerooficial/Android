package com.senac.cicero.testactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Exercicio02Activity extends AppCompatActivity {

    //Representa o componente de campos de texto e botao
    EditText    nome;
    EditText    sobrenome;
    Button      botaoConfirmar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio02);

        //Binding dos componentes com os elementos do layout
        nome            = findViewById(R.id.editTextNome);
        sobrenome       = findViewById(R.id.editTextSobrenome);
        botaoConfirmar  = findViewById(R.id.buttonConfirmar);

        //Define um listener de ação
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ação aqui
                String nomeTela = nome.getText().toString();
                String sobrenomeTela = sobrenome.getText().toString();

                if (nomeTela.trim().equals("")) {
                    showDialog("ERRO ", "Você não inseriu um NOME!");
                }else if(sobrenomeTela.trim().equals("")) {
                    showDialog("ERRO ", "Você não inseriu um SOBRENOME!");

                }else if(!nomeTela.trim().equals("") && !sobrenomeTela.trim().equals("")){
                        showDialog("Olá " + nomeTela + " " + sobrenomeTela, " Boas Vindas!");
                }
            }
        };
        botaoConfirmar.setOnClickListener(listener);
    }

    public void showDialog(String message, String title) {
        //Declara a instancia uma fabrica de construção de diálogos
        AlertDialog.Builder builder = new AlertDialog.Builder(Exercicio02Activity.this);
        //Confirma o corpo da mensagem
        builder.setMessage(message);
        //Confirma o titulo da mensagem
        builder.setTitle(title);
        //Impede que o botão de OK para fechamento (um
        //outro listener pode ser configurado no lugar do "null")
        builder.setPositiveButton("OK", null);
        //Cria efetivamente o diálogo
        AlertDialog dialog = builder.create();
        //Faz com que o diálogo apareça na tela
        dialog.show();
    }


}
