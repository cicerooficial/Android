package com.senac.cicero.cardviewapplication;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewGroup mensagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mensagens = findViewById(R.id.container);
        addItem("Título 1", "Exemplo de mensagem.");
    }

    private void addItem(String textoDoTitulo, String textoDaMensagem) {
        CardView cardView = (CardView) LayoutInflater.from(this).inflate(R.layout.card_message, mensagens, false);
        TextView titulo = cardView.findViewById(R.id.titulo);
        TextView mensagem = cardView.findViewById(R.id.mensagem);
        titulo.setText(textoDoTitulo);
        mensagem.setText(textoDaMensagem);
        mensagens.addView(cardView);
    }

}

