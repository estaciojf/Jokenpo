package com.example.ads.estaciojf.jokenpo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnPapel;
    Button btnTesoura;
    Button btnPedra;
    ImageView imgPlayer1;
    ImageView imgPlayer2;
    TextView textPlacar;

    int pontuacaoPlayer1;
    int pontuacaoPlayer2;

    String btn;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = this;

        pontuacaoPlayer1 = 0;
        pontuacaoPlayer2 = 0;

        btnPapel = findViewById(R.id.btnPapel);
        btnTesoura = findViewById(R.id.btnTesoura);
        btnPedra = findViewById(R.id.btnPedra);
        imgPlayer1 = findViewById(R.id.imgPlayer1);
        imgPlayer2 = findViewById(R.id.imgPlayer2);
        textPlacar = findViewById(R.id.textPlacar);

        imgPlayer1.setVisibility(View.GONE);


        btnPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(getApplicationContext(), "Papel", Toast.LENGTH_LONG)
                        .show();

                Toast msg = Toast.makeText(getApplicationContext(), "Papel embrulha pedra!Você Venceu!!!", Toast.LENGTH_SHORT);
                msg.show();

                btn = "Papel";
                imgPlayer1.setImageResource(R.drawable.papel);
                imgPlayer1.setVisibility(View.VISIBLE);
                pontuacaoPlayer1 ++;

                textPlacar.setText(pontuacaoPlayer1 + " x " + pontuacaoPlayer2);

            }
        });

        btnTesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, "Tesoura", Toast.LENGTH_LONG).show();
                btn = "Tesoura";
                imgPlayer1.setImageResource(R.drawable.tesoura);
            }
        });

        btnPedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, "Pedra", Toast.LENGTH_LONG).show();
                btn = "Pedra";
                imgPlayer1.setImageResource(R.drawable.pedra);
            }
        });








    }
}
