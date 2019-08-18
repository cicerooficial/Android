package br.senac.cicero;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Exemplo01 extends AppCompatActivity {
    //Variaveis para armazenamento dos respectivos elementos da tela
    private EditText txtNome;
    private EditText txtSobrenome;
    private Button btnSaudacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo01);
        //Referenciando variaiveis com ID de elementos da tela
        txtNome = findViewById(R.id.txtNome);
        txtSobrenome = findViewById(R.id.txtSobrenome);
        btnSaudacao = findViewById(R.id.btnSaudacao);

        View.OnClickListener listener  = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialog("Bem-vindo!", "Olá, " + txtNome.getText() + " " + txtSobrenome.getText());
            }
        };
        btnSaudacao.setOnClickListener(listener);
    }

    private void mostrarDialog(String titulo, String texto){
        AlertDialog.Builder builder  = new AlertDialog.Builder(Exemplo01.this);
        builder.setTitle(titulo);
        builder.setMessage(texto);
        builder.setPositiveButton("OK",null);
        //builder.create().show();
        //Aqui é a mesma coisa de cima, mas de forma separada chamando apra aparecer um dialogo
        AlertDialog dialog = builder.create();
        dialog.show();

    }

}
