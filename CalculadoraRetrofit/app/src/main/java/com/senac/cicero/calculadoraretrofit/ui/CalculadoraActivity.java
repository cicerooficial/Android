package com.senac.cicero.calculadoraretrofit.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.senac.cicero.calculadoraretrofit.R;
import com.senac.cicero.calculadoraretrofit.api.ApiCalculadora;
import com.senac.cicero.calculadoraretrofit.model.Calculadora;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CalculadoraActivity extends AppCompatActivity {

    EditText        editTextValor01, editTextValor02, editTextResultado;
    RadioButton     radioButtonSoma, radioButtonSubtracao, radioButtonMultiplicacao, radioButtonDivisao;
    Button          buttonCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        editTextValor01             =   findViewById(R.id.editTextValor01);
        editTextValor02             =   findViewById(R.id.editTextValor02);
        editTextResultado           =   findViewById(R.id.editTextResultado);
        radioButtonSoma             =   findViewById(R.id.radioButtonSoma);
        radioButtonSubtracao        =   findViewById(R.id.radioButtonSubtracao);
        radioButtonMultiplicacao    =   findViewById(R.id.radioButtonMultiplicacao);
        radioButtonDivisao          =   findViewById(R.id.radioButtonDivisao);
        buttonCalcular              =   findViewById(R.id.buttonCalcular);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Verifica se os dois valores que foram digitados são numéricos
                Double numero1  =   null;
                Double numero2  =   null;
                try {
                    numero1 =   Double.parseDouble(editTextValor01.getText().toString());
                    numero2 =   Double.parseDouble(editTextValor02.getText().toString());
                }catch (Exception e){
                    showDialog("Digite apenas valores numéricos","Erro");
                    return;
                }
                //Verifica se nenhum radioButton foi selecionado
                if(!radioButtonSoma.isChecked() && !radioButtonSubtracao.isChecked() && !radioButtonMultiplicacao.isChecked() && !radioButtonDivisao.isChecked()){
                    showDialog("Selecione uma operação", "Erro");
                    return;
                }

                //Faz o Build do retrofit com a URL que será acessada
                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://fabiohenriqueaf.online/").addConverterFactory(GsonConverterFactory.create()).build();

                //Retrofit faz implementação do método criado
                ApiCalculadora apiCalculadora = retrofit.create(ApiCalculadora.class);

                //Quando chamar o método de objeto getObject salvará no objeto calculadora *Esta ação é assincrona
                Call<Calculadora> call = apiCalculadora.getObject(numero1, numero2);

                Callback<Calculadora> callback = new Callback<Calculadora>(){

                    @Override
                    public void onResponse(Call<Calculadora> call, Response<Calculadora> response) {
                        Calculadora calculadora = response.body();
                        if(radioButtonSoma.isChecked()){
                            editTextResultado.setText(calculadora.getSoma().toString());
                        }else if (radioButtonSubtracao.isChecked()){
                            editTextResultado.setText(calculadora.getSub().toString());
                        }else if(radioButtonMultiplicacao.isChecked()){
                            editTextResultado.setText(calculadora.getMult().toString());
                        }else if(radioButtonDivisao.isChecked()){
                            editTextResultado.setText(calculadora.getDiv().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<Calculadora> call, Throwable t) {
                        showDialog("Erro de conexão", "Erro");
                        t.printStackTrace();//Mostra no console todo o descritivo do erro
                    }
                };

                call.enqueue(callback);

            }
        };
        buttonCalcular.setOnClickListener(listener);


    }

    //Cria uma função para iniciar diálogos de mensagem
    private void showDialog(String valor, String title){
        AlertDialog.Builder builder = new AlertDialog.Builder(CalculadoraActivity.this);
        builder.setMessage(valor);
        builder.setTitle(title);
        builder.setCancelable(false);
        builder.setPositiveButton("OK",null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
