package com.example.ads.estaciojf.jokenpo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnPapel;
    Button btnTesoura;
    Button btnPedra;
    Button btnTeste;
    ImageView img;

    String btn;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = this;

        btnPapel = findViewById(R.id.btnPapel);
        btnTesoura = findViewById(R.id.btnTesoura);
        btnPedra = findViewById(R.id.btnPedra);
        btnTeste = findViewById(R.id.button4);
        img = findViewById(R.id.imageView);


        btnPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Papel", Toast.LENGTH_LONG).show();
                btn = "Papel";
                img.setImageResource(R.drawable.tesoura);

            }
        });

        btnTesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, "Tesoura", Toast.LENGTH_LONG).show();
                btn = "Tesoura";
            }
        });

        btnPedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, "Pedra", Toast.LENGTH_LONG).show();
                btn = "Pedra";
            }
        });


        btnTeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, btn, Toast.LENGTH_LONG).show();


            }
        });





    }
}
