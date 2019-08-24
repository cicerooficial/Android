package com.senac.cicero.testactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Exemplo02Activity extends AppCompatActivity {

    //Representa os componentes
    private EditText    editTextNome;
    private RadioButton radioButtonMasculino;
    private RadioButton radioButtonFeminino;
    private Button      buttonMostrarMensagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo02);

        //faz binding dos componentes (ligação com o XML)
        editTextNome =          findViewById(R.id.editTextNome);
        radioButtonMasculino =  findViewById(R.id.radioButtonMasculino);
        radioButtonFeminino =   findViewById(R.id.radioButtonFeminino);
        buttonMostrarMensagem = findViewById(R.id.buttonConfirmar);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editTextNome.getText().toString();
                if (!nome.trim().equals("")){
                    if (radioButtonMasculino.isChecked()){
                        showDialog("Bem-Vindo! ","Olá Sr. " + nome);
                    }
                    else if(radioButtonFeminino.isChecked()){
                        showDialog("Bem-Vindo! ","Olá Sra. " + nome);
                    }
                    else{
                        showDialog("Erro ","Você precisa selecionar um sexo");
                    }
                }else{
                    showDialog("Erro","Você precisa digitar um nome");
                }
            }
        };
        buttonMostrarMensagem.setOnClickListener(listener);

    }

    private void showDialog(String message, String title) {

        //Declara e instancia uma fábrica de construção de diálogos
        AlertDialog.Builder builder = new AlertDialog.Builder(Exemplo02Activity.this);
        //Configura o corpo da mensagem
        builder.setMessage(message);
        //Configura o título da mensagem
        builder.setTitle(title);
        //Impede que o botão seja cancelável (possa clicar
        //em voltar ou fora para fechar)
        builder.setCancelable(false);
        //Configura um botão de OK para fechamento (um
        //outro listener pode ser configurado no lugar do "null")
        builder.setPositiveButton("OK", null);
        //Cria efetivamente o diálogo
        AlertDialog dialog = builder.create();
        //Faz com que o diálogo apareça na tela
        dialog.show();

    }


}
