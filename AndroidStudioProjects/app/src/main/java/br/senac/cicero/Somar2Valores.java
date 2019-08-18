package br.senac.cicero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Somar2Valores extends AppCompatActivity {
    //Variaveis para armazenamento dos respectivos elementos da tela
    private EditText txtValor1;
    private EditText txtValomicro dorner2;
    private TextView txtViewResultado;
    private Button btnSomar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_somar2_valores);
        //Referenciando variaiveis com ID de elementos da tela
        txtValor1 = findViewById(R.id.txtValor1);
        txtValor2 = findViewById(R.id.txtValor2);
        txtViewResultado = findViewById(R.id.txtViewResultado);
        btnSomar = findViewById(R.id.btnSomar);

        View.OnClickListener listener  = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };
        btnSomar.setOnClickListener(listener);
    }

    private void somarValores(){

        String valor1String = txtValor1.getText().toString();
        double valor1Double = Double.parseDouble(valor1String);

        String valor2String = txtValor2.getText().toString();
        double valor2Double = Double.parseDouble(valor2String);

        double resultado = valor1Double + valor2Double;


    }



}
