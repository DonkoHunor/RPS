package com.example.rps;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView gepElet1;
    private ImageView gepElet2;
    private ImageView gepElet3;
    private ImageView jatekosElet3;
    private ImageView jatekosElet2;
    private ImageView jatekosElet1;
    private TextView TVdontetlen;
    private ImageView IVgep;
    private ImageView IVjatekos;
    private ImageView IVpaper;
    private ImageView IVrock;
    private ImageView IVscissors;
    private static  Random rnd = new Random();
    private int jatekos;
    private int gep;
    private int gepElet = 3;
    private int jatekosElet = 3;

    private int dontetlen = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        IVrock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IVjatekos.setImageResource(R.drawable.rock);
                jatekos = 0;
                Gep();
                if ( gep == 0)
                {
                    dontetlen++;
                    TVdontetlen.setText("Döntetlenek száma: "+dontetlen);
                }
                else if (gep == 1) {
                    jatekosElet();
                }
                else
                {
                    gepElet();
                }
            }
        });
        IVpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IVjatekos.setImageResource(R.drawable.paper);
                jatekos = 1;
                Gep();
                if ( gep == 1)
                {
                    dontetlen++;
                    TVdontetlen.setText("Döntetlenek száma: "+dontetlen);
                }
                else if (gep == 2) {
                    jatekosElet();
                }
                else
                {
                    gepElet();
                }
            }
        });
        IVscissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IVjatekos.setImageResource(R.drawable.scissors);
                jatekos = 2;
                Gep();
                if ( gep == 2)
                {
                    dontetlen++;
                    TVdontetlen.setText("Döntetlenek száma: "+dontetlen);
                }
                else if (gep == 0) {
                    jatekosElet();
                }
                else
                {
                    gepElet();
                }
            }
        });
    }

    public void Gep()
    {
        int r = rnd.nextInt(3);
        switch (r)
        {
            case 0:
                IVgep.setImageResource(R.drawable.rock);
                break;
            case 1:
                IVgep.setImageResource(R.drawable.paper);
                break;
            case 2:
                IVgep.setImageResource(R.drawable.scissors);
                break;
        }
        gep = r;
    }

    public void gepElet()
    {
        if (gepElet == 3)
        {
            gepElet3.setImageResource(R.drawable.heart1);
            gepElet--;
        }
        else if(gepElet == 2)
        {
            gepElet2.setImageResource(R.drawable.heart1);
            gepElet--;
        }
        else if (gepElet == 1)
        {
            gepElet1.setImageResource(R.drawable.heart1);
            gepElet--;
            Vege();
        }
    }

    public void jatekosElet()
    {
        if (jatekosElet == 3)
        {
            jatekosElet3.setImageResource(R.drawable.heart1);
            jatekosElet--;
        }
        else if(jatekosElet == 2)
        {
            jatekosElet2.setImageResource(R.drawable.heart1);
            jatekosElet--;
        }
        else if (jatekosElet == 1)
        {
            jatekosElet1.setImageResource(R.drawable.heart1);
            jatekosElet--;
            Vege();
        }
    }

    public void Vege()
    {
        String szoveg = "";
        if (gepElet == 0)
        {
            szoveg = "Nyertél! Szeretnél új játékot?";
        }
        else
        {
            szoveg = "Vesztettél! Szeretnél új játékot?";
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(szoveg)
                .setCancelable(false)
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dontetlen = 0;
                        TVdontetlen.setText("Döntetlenek száma: "+ dontetlen);
                        gepElet1.setImageResource(R.drawable.heart2);
                        gepElet2.setImageResource(R.drawable.heart2);
                        gepElet3.setImageResource(R.drawable.heart2);
                        jatekosElet1.setImageResource(R.drawable.heart2);
                        jatekosElet2.setImageResource(R.drawable.heart2);
                        jatekosElet3.setImageResource(R.drawable.heart2);
                    }
                })
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).show();
    }

    public void init()
    {
        gepElet1 = findViewById(R.id.gepElet1);
        gepElet2 = findViewById(R.id.gepElet2);
        gepElet3 = findViewById(R.id.gepElet3);

        jatekosElet1 = findViewById(R.id.jatekosElet1);
        jatekosElet2 = findViewById(R.id.jatekosElet2);
        jatekosElet3 = findViewById(R.id.jatekosElet3);

        TVdontetlen = findViewById(R.id.TVdontetlen);

        IVgep = findViewById(R.id.IVgep);
        IVjatekos = findViewById(R.id.IVjatekos);
        IVrock = findViewById(R.id.IVrock);
        IVpaper = findViewById(R.id.IVpaper);
        IVscissors = findViewById(R.id.IVscissors);
    }
}