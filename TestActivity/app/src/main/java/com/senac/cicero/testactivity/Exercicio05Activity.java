package com.senac.cicero.testactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Exercicio05Activity extends AppCompatActivity {

    //Representa o componente de campos de texto e botao
    EditText numero1, numero2, resultado;
    Button botaoCalcular;
    RadioButton radioButtonSomar, radioButtonSubtrair, radioButtonMultiplicar, radioButtonDividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio05);

        //Binding dos componentes com os elementos do layout
        numero1 = findViewById(R.id.editTextNumero1);
        numero2 = findViewById(R.id.editTextNumero2);
        resultado = findViewById(R.id.editTextResultado);
        botaoCalcular = findViewById(R.id.buttonCalcular);
        radioButtonSomar = findViewById(R.id.radioButtonSomar);
        radioButtonSubtrair = findViewById(R.id.radioButtonSubtrair);
        radioButtonMultiplicar = findViewById(R.id.radioButtonMultiplicar);
        radioButtonDividir = findViewById(R.id.radioButtonDivorciado);

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

                if (radioButtonSomar.isChecked()) {
                    //Soma os dois numeros em variável de resultado em Double
                    double resultadoD = numero1D + numero2D;
                    //Envia valor ao componente
                    resultado.setText(String.valueOf(resultadoD));
                }else if(radioButtonSubtrair.isChecked()){
                    //Subtrai os dois numeros em variável de resultado em Double
                    double resultadoD = numero1D - numero2D;
                    //Envia valor ao componente
                    resultado.setText(String.valueOf(resultadoD));
                }else if(radioButtonMultiplicar.isChecked()){
                    //Soma os dois numeros em variável de resultado em Double
                    double resultadoD = numero1D * numero2D;
                    //Envia valor ao componente
                    resultado.setText(String.valueOf(resultadoD));
                }else if(radioButtonDividir.isChecked()){
                    //Divide os dois numeros em variável de resultado em Double
                    try{
                        double resultadoD = numero1D / numero2D;
                        //Envia valor ao componente
                        resultado.setText(String.valueOf(resultadoD));
                    }catch (ArithmeticException  e3){
                        showDialog("ERRO ","Não é permitido divisão com dois 0, tente outros números!");
                    }
                }else{
                    showDialog("ERRO ", "Você precisa selecionar uma operação matemática!");
                }
            }
        };
        botaoCalcular.setOnClickListener(listener);
    }

    public void showDialog(String message, String title) {
        //Declara a instancia uma fabrica de construção de diálogos
        AlertDialog.Builder builder = new AlertDialog.Builder(Exercicio05Activity.this);
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
