package com.senac.cicero.testactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Exercicio04Activity extends AppCompatActivity {

    //Representa o componente de campos de texto e botao
    private EditText numero1, numero2, resultado;
    private Button botaoCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio04);

        //Binding dos componentes com os elementos do layout
        numero1         = findViewById(R.id.editTextNumero1);
        numero2         = findViewById(R.id.editTextNumero2);
        resultado       = findViewById(R.id.editTextResultado);
        botaoCalcular   = findViewById(R.id.buttonCalcular);

        //Define um listener de ação
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Instancia variáveis de tipo Double
                double numero1D = 0, numero2D=0;

                //Pega os valores em formato de textoo e converte para Double passando pelo Try/Catch
                try {
                    numero1D = Double.parseDouble(numero1.getText().toString());
                }catch (NumberFormatException e1 ){
                    showDialog("ERRO ","Numero 1 incorreto!");
                }
                try{
                    numero2D = Double.parseDouble(numero2.getText().toString());
                }catch (NumberFormatException e2){
                    showDialog("ERRO ","Numero 2 incorreto!");
                }

                //Soma os dois numeros em variável de resultado em Double
                double resultadoD = numero1D + numero2D;

                //Envia valor ao componente
                resultado.setText(String.valueOf(resultadoD));
            }
        };
        botaoCalcular.setOnClickListener(listener);
    }

    public void showDialog(String message, String title) {
        //Declara a instancia uma fabrica de construção de diálogos
        AlertDialog.Builder builder = new AlertDialog.Builder(Exercicio04Activity.this);
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
