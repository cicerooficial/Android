package com.senac.cicero.testactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Exercicio03Activity extends AppCompatActivity {

    //Representa o componente de campos de texto e botao
    EditText    nome;
    EditText    sobrenome;
    Button      botaoConfirmar;
    RadioButton radioBotaoMasculino;
    RadioButton radioBotaoFeminino;
    RadioButton radioBotaoOutros;
    RadioButton radioBotaoSolteiro;
    RadioButton radioBotaoCasado;
    RadioButton radioBotaoSeparado;
    RadioButton radioBotaoDivorciado;
    RadioButton radioBotaoViuvo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio03);

        //Binding dos componentes com os elementos do layout
        nome                    = findViewById(R.id.editTextNome);
        sobrenome               = findViewById(R.id.editTextSobrenome);
        botaoConfirmar          = findViewById(R.id.buttonConfirmar);
        radioBotaoMasculino     = findViewById(R.id.radioButtonMasculino);
        radioBotaoFeminino      = findViewById(R.id.radioButtonFeminino);
        radioBotaoOutros        = findViewById(R.id.radioButtonOutros);
        radioBotaoSolteiro      = findViewById(R.id.radioButtonSolteiro);
        radioBotaoCasado        = findViewById(R.id.radioButtonCasado);
        radioBotaoSeparado      = findViewById(R.id.radioButtonSeparado);
        radioBotaoDivorciado    = findViewById(R.id.radioButtonDivorciado);
        radioBotaoViuvo         = findViewById(R.id.radioButtonViuvo);

        //Define um listener de ação
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ação aqui
                String nomeTela = nome.getText().toString();
                String sobrenomeTela = sobrenome.getText().toString();

                if (!nomeTela.trim().equals("")) {
                    if (!sobrenomeTela.trim().equals("")) {
                        if (radioBotaoMasculino.isChecked()) {
                            if (radioBotaoSolteiro.isChecked()) {
                                showDialog("Bem vindo ", " Olá Sr. " + nomeTela + " " + sobrenomeTela
                                        + "\n G: Masculino | E: Solteiro");
                            } else if (radioBotaoCasado.isChecked()) {
                                showDialog("Bem vindo ", " Olá Sr. " + nomeTela + " " + sobrenomeTela
                                        + "\n G: Masculino | E: Casado");
                            } else if (radioBotaoSeparado.isChecked()) {
                                showDialog("Bem vindo ", " Olá Sr. " + nomeTela + " " + sobrenomeTela
                                        + "\n G: Masculino | E: Separado");
                            } else if (radioBotaoDivorciado.isChecked()) {
                                showDialog("Bem vindo ", " Olá Sr. " + nomeTela + " " + sobrenomeTela
                                        + "\n G: Masculino | E: Divorciado");
                            } else if (radioBotaoViuvo.isChecked()) {
                                showDialog("Bem vindo ", " Olá Sr. " + nomeTela + " " + sobrenomeTela
                                        + "\n G: Masculino | E: Viúvo");
                            } else {
                                showDialog("ERRO ", "Você precisa Selecionar um Estado Civil!");
                            }
                        } else if (radioBotaoFeminino.isChecked()) {
                            if (radioBotaoSolteiro.isChecked()) {
                                showDialog("Bem vindo ", " Olá Sra. " + nomeTela + " " + sobrenomeTela
                                        + "\n G: Feminina | E: Solteira");
                            } else if (radioBotaoCasado.isChecked()) {
                                showDialog("Bem vindo ", " Olá Sra. " + nomeTela + " " + sobrenomeTela
                                        + "\n G: Feminina | E: Casada");
                            } else if (radioBotaoSeparado.isChecked()) {
                                showDialog("Bem vindo ", " Olá Sra. " + nomeTela + " " + sobrenomeTela
                                        + "\n G: Feminina | E: Separada");
                            } else if (radioBotaoDivorciado.isChecked()) {
                                showDialog("Bem vindo ", " Olá Sra. " + nomeTela + " " + sobrenomeTela
                                        + "\n G: Feminina | E: Divorciada");
                            } else if (radioBotaoViuvo.isChecked()) {
                                showDialog("Bem vindo ", " Olá Sra. " + nomeTela + " " + sobrenomeTela
                                        + "\n G: Feminina | E: Viúva");
                            } else {
                                showDialog("ERRO ", "Você precisa Selecionar um Estado Civil!");
                            }
                        } else if (radioBotaoOutros.isChecked()) {
                            if (radioBotaoSolteiro.isChecked()) {
                                showDialog("Bem vindo ", " Olá SrX. " + nomeTela + " " + sobrenomeTela
                                        + "\n G: Outro | E: SolteirX");
                            } else if (radioBotaoCasado.isChecked()) {
                                showDialog("Bem vindo ", " Olá SrX. " + nomeTela + " " + sobrenomeTela
                                        + "\n G: Outro | E: CasadX");
                            } else if (radioBotaoSeparado.isChecked()) {
                                showDialog("Bem vindo ", " Olá SrX. " + nomeTela + " " + sobrenomeTela
                                        + "\n G: Outro | E: SeparadX");
                            } else if (radioBotaoDivorciado.isChecked()) {
                                showDialog("Bem vindo ", " Olá SrX. " + nomeTela + " " + sobrenomeTela
                                        + "\n G: Outro | E: DivorciadX");
                            } else if (radioBotaoViuvo.isChecked()) {
                                showDialog("Bem vindo ", " Olá SrX. " + nomeTela + " " + sobrenomeTela
                                        + "\n G: Outro | E: ViúvX");
                            } else {
                                showDialog("ERRO ", "Você precisa Selecionar um Estado Civil!");
                            }
                        } else {
                            showDialog("ERRO ", "Você precisa Selecionar um Gênero!");
                        }
                    } else {
                        showDialog("ERRO ", "Você precisa digitar um Sobrenome!");
                    }
                } else {
                    showDialog("ERRO ", "Você precisa digitar um Nome!");
                }
            }
        };
        botaoConfirmar.setOnClickListener(listener);
    }

    public void showDialog(String message, String title) {
        //Declara a instancia uma fabrica de construção de diálogos
        AlertDialog.Builder builder = new AlertDialog.Builder(Exercicio03Activity.this);
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
