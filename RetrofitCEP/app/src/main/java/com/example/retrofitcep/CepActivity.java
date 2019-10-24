package com.example.retrofitcep;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.retrofitcep.retrofit.RetrofitConfig;
import com.example.retrofitcep.model.Cep;
import retrofit2.Call;
import retrofit2.Callback;


public class CepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_cep);


        final EditText cep              =   findViewById(R.id.textCep);
        final TextView resposta         =   findViewById(R.id.textResultado);
        Button buttonConsultar          =   findViewById(R.id.buttonConsultar);

        buttonConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Cep> call = new RetrofitConfig().getCEPService().buscarCEP(cep.getText().toString());
                call.enqueue(new Callback<Cep>() {

                    @Override
                    public void onResponse(Call<Cep> call, retrofit2.Response<Cep> response) {
                        Cep cep = response.body();
                        resposta.setText(cep.toString());
                    }

                    @Override
                    public void onFailure(Call<Cep> call, Throwable t) {
                        t.printStackTrace();
                        showDialog("CEPService   ", "Erro, CEP não encontrado:" +t.getMessage());
                        t.printStackTrace();
                    }

                    private void showDialog(String val, String title) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(CepActivity.this);
                        builder.setMessage(val);
                        builder.setTitle(title);
                        builder.setCancelable(false);
                        builder.setPositiveButton("OK", null);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });
            }
        });
    }

}