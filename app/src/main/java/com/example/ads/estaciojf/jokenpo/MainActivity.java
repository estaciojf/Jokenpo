package com.example.ads.estaciojf.jokenpo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Elementos do layout
    Button btnPapel;
    Button btnTesoura;
    Button btnPedra;
    ImageView imgPlayer1;
    ImageView imgPlayer2;
    TextView textPlacar;

    //Pontuacoes
    int pontuacaoPlayer1;
    int pontuacaoPlayer2;

    String btnClickado;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = this;

        pontuacaoPlayer1 = 0;
        pontuacaoPlayer2 = 0;

        //Link dos elementos do layout com o Java
        btnPapel = findViewById(R.id.btnPapel);
        btnTesoura = findViewById(R.id.btnTesoura);
        btnPedra = findViewById(R.id.btnPedra);
        imgPlayer1 = findViewById(R.id.imgPlayer1);
        imgPlayer2 = findViewById(R.id.imgPlayer2);
        textPlacar = findViewById(R.id.textPlacar);

        //Ocultando elemento ImageView ao carregar o app
        imgPlayer1.setVisibility(View.GONE);
        imgPlayer2.setVisibility(View.GONE);


        //Acao botao Papel
        btnPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnClickado = "papel";
                imgPlayer1.setImageResource(R.drawable.papel);
                imgPlayer1.setVisibility(View.VISIBLE);

                String escolhaPlayer2 = jogadaPlayer2();
                calculaVitoria(btnClickado ,escolhaPlayer2);

                textPlacar.setText(pontuacaoPlayer1 + " x " + pontuacaoPlayer2);
            }
        });

        //Acao botao Tesoura
        btnTesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClickado = "tesoura";
                imgPlayer1.setImageResource(R.drawable.tesoura);
                imgPlayer1.setVisibility(View.VISIBLE);


                String escolhaPlayer2 = jogadaPlayer2();
                calculaVitoria(btnClickado ,escolhaPlayer2);

                textPlacar.setText(pontuacaoPlayer1 + " x " + pontuacaoPlayer2);
            }
        });

        //Acao botao Pedra
        btnPedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClickado = "pedra";
                imgPlayer1.setImageResource(R.drawable.pedra);
                imgPlayer1.setVisibility(View.VISIBLE);


                String escolhaPlayer2 = jogadaPlayer2();
                calculaVitoria(btnClickado ,escolhaPlayer2);

                textPlacar.setText(pontuacaoPlayer1 + " x " + pontuacaoPlayer2);
            }
        });

    }

//    Jogada do Player2 (Máquina)
//    Sorteia um número sendo: 0, 1 ou 2.
//    Retorna o valor da lista de opcoes daquele número sortiado
    private String jogadaPlayer2() {
        String[] opcoes = {"pedra", "papel", "tesoura"};
        Random random = new Random();
        int jogada = random.nextInt(3);

        // Mostro o elemento do player2
        imgPlayer2.setVisibility(View.VISIBLE);
        // Mostro a imagem da jogada do player2
        if (jogada == 0) imgPlayer2.setImageResource(R.drawable.pedra);
        if (jogada == 1) imgPlayer2.setImageResource(R.drawable.papel);
        if (jogada == 2) imgPlayer2.setImageResource(R.drawable.tesoura);

        return opcoes[jogada];
    }

    private int calculaVitoria(String jogadaPlayer1, String jogadaPlayer2) {

        // Se as duas jogadas forem iguais é empate, retorna 0;
        if(jogadaPlayer1 == jogadaPlayer2) return 0;

        // Aqui eu identifico todos os cenários onde o Player1 vence e retorno 1;
        if(jogadaPlayer1 == "papel" && jogadaPlayer2 == "pedra") {
            pontuacaoPlayer1 ++;
            return 1;
        }

        if(jogadaPlayer1 == "pedra" && jogadaPlayer2 == "tesoura") {
            pontuacaoPlayer1 ++;
            return 1;
        }
        if(jogadaPlayer1 == "tesoura" && jogadaPlayer2 == "papel") {
            pontuacaoPlayer1 ++;
            return 1;
        }

        // O contrário do cenário de empate e dos cenários onde o Player1 vence,
        //  ou seja, quando o Player2 vence, retorno -1;
        pontuacaoPlayer2 ++;
        return -1;

    }

}
