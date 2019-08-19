package br.senac.cicero;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Exemplo01 extends AppCompatActivity {
    //Variaveis para armazenamento dos respectivos elementos da tela
    EditText nome;
    Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo01);
        //Referenciando variaiveis com ID de elementos da tela
        nome = findViewById(R.id.textoNome);
        botao = findViewById(R.id.botaoSaudacao);

        View.OnClickListener listener  = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog("Olá, " + nome.getText().toString(),  "Boas Vindas! ");
            }
        };
        botao.setOnClickListener(listener);
    }

    private void showDialog(String message, String title){
        AlertDialog.Builder builder  = new AlertDialog.Builder(Exemplo01.this);
        builder.setTitle(message);
        builder.setMessage(title);
        builder.setCancelable(false);
        builder.setPositiveButton("OK",null);
        //builder.create().show();
        //Aqui é a mesma coisa de cima, mas de forma separada chamando apra aparecer um dialogo
        AlertDialog dialog = builder.create();
        dialog.show();

    }

}
