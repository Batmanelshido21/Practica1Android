package com.example.practica1;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Juego extends AppCompatActivity {

    private ProgressBar progressBar;
    private ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        String nombreUsuario=getIntent().getStringExtra("NombreUsuario");
        TextView nombreUsuarioL2;
        nombreUsuarioL2=(TextView)findViewById(R.id.nombreUsuarioL);
        nombreUsuarioL2.setText(nombreUsuario);

        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBar.setProgress(100);

        progressBar2=(ProgressBar)findViewById(R.id.progressBar2);
        progressBar2.setProgress(100);

    }

    public void atacante1(View view){
        int daño = (int) Math.floor(Math.random()*(10-25+1)+25);
        int vida=progressBar2.getProgress();
        vida=vida-daño;
        progressBar2.setProgress(vida);
        TextView jugador1=(TextView)findViewById(R.id.nombreUsuarioL);
        TextView accion=(TextView)findViewById(R.id.AccionText);
        accion.setText(jugador1.getText().toString()+" ha atacado al monstruo con un daño de "+daño);
        TextView barra2=(TextView)findViewById(R.id.barraVida2);
        if(vida<=0){
            accion.setText("Has ganado la partida");
            Button botonAtacar=(Button)findViewById(R.id.botonAtacar);
            botonAtacar.setEnabled(false);
            Button botonCurar=(Button)findViewById(R.id.botonCurar);
            botonCurar.setEnabled(false);
            Button botonRendirse=(Button)findViewById(R.id.botonRendirse);
            botonRendirse.setEnabled(false);
        }else{
            barra2.setText("%"+vida);
            int opcion =(int) (Math.random() * 2) + 1;
            if(opcion==1){
                int daño2 = (int) Math.floor(Math.random()*(10-25+1)+25);
                int vida2=progressBar.getProgress();
                vida2=vida2-daño2;
                progressBar.setProgress(vida2);
                accion.setText("El monstruo ha atacado a "+jugador1.getText().toString()+" con un daño de "+daño2);
                TextView barra1=(TextView)findViewById(R.id.barraVida1);
                barra1.setText("%"+vida2);
                if (vida2 <= 0) {
                    accion.setText("Has perdido la partida");
                    Button botonAtacar=(Button)findViewById(R.id.botonAtacar);
                    botonAtacar.setEnabled(false);
                    Button botonCurar=(Button)findViewById(R.id.botonCurar);
                    botonCurar.setEnabled(false);
                    Button botonRendirse=(Button)findViewById(R.id.botonRendirse);
                    botonRendirse.setEnabled(false);
                }
            }
            if(opcion==2){
                int curacion =(int) Math.floor(Math.random()*(5-20+1)+20);
                int vidaM=progressBar2.getProgress();
                vidaM=vidaM+curacion;
                progressBar2.setProgress(vidaM);
                accion.setText("El monstruo se ha curado un porcentaje %"+vidaM);
                TextView barraM=(TextView)findViewById(R.id.barraVida2);
                barraM.setText("%"+vidaM);
            }
        }
    }
    public void rendirse(View view){
        TextView accion=(TextView)findViewById(R.id.AccionText);
        accion.setText("Has perdido la partida");
        Button botonAtacar=(Button)findViewById(R.id.botonAtacar);
        botonAtacar.setEnabled(false);
        Button botonCurar=(Button)findViewById(R.id.botonCurar);
        botonCurar.setEnabled(false);
        Button botonRendirse=(Button)findViewById(R.id.botonRendirse);
        botonRendirse.setEnabled(false);
        TextView barra1=(TextView)findViewById(R.id.barraVida1);
        barra1.setText("%"+0);
        progressBar.setProgress(0);
    }

    public void curarVida(View view){
        TextView accion=(TextView)findViewById(R.id.AccionText);
        int curacion =(int) Math.floor(Math.random()*(5-20+1)+20);
        int vida=progressBar.getProgress();
        vida=vida+curacion;
        progressBar.setProgress(vida);
        accion.setText("Has aumentado un porcentaje de %"+vida);
        TextView barra=(TextView)findViewById(R.id.barraVida1);
        barra.setText("%"+vida);

        TextView jugador1=(TextView)findViewById(R.id.nombreUsuarioL);
        int opcion =(int) (Math.random() * 2) + 1;
        if(opcion==1){
            int daño2 = (int) Math.floor(Math.random()*(10-25+1)+25);
            int vida2=progressBar.getProgress();
            vida2=vida2-daño2;
            progressBar.setProgress(vida2);
            accion.setText("El monstruo ha atacado a "+jugador1.getText().toString()+" con un daño de "+daño2);
            TextView barra1=(TextView)findViewById(R.id.barraVida1);
            barra1.setText("%"+vida2);
            if(vida2<=0){
                accion.setText("Has perdido la partida");
                Button botonAtacar=(Button)findViewById(R.id.botonAtacar);
                botonAtacar.setEnabled(false);
                Button botonCurar=(Button)findViewById(R.id.botonCurar);
                botonCurar.setEnabled(false);
                Button botonRendirse=(Button)findViewById(R.id.botonRendirse);
                botonRendirse.setEnabled(false);
            }
        }
        if(opcion==2){
            int curacionM =(int) Math.floor(Math.random()*(5-20+1)+20);
            int vidaM=progressBar2.getProgress();
            vidaM=vidaM+curacionM;
            progressBar2.setProgress(vidaM);
            accion.setText("El monstruo se ha curado un porcentaje %"+vidaM);
            TextView barraM=(TextView)findViewById(R.id.barraVida2);
            barraM.setText("%"+vidaM);
        }
    }

    public void regresar(View view){
        Intent siguiente = new Intent(this,MainActivity.class);
        startActivity(siguiente);
    }

    public void reiniciar(View view){
        progressBar.setProgress(100);
        progressBar2.setProgress(100);
        TextView barra1=(TextView)findViewById(R.id.barraVida1);
        barra1.setText("%"+100);
        TextView barra2=(TextView)findViewById(R.id.barraVida2);
        barra2.setText("%"+100);

        TextView accion=(TextView)findViewById(R.id.AccionText);
        accion.setText("La partida se ha reiniciado");
        Button botonAtacar=(Button)findViewById(R.id.botonAtacar);
        botonAtacar.setEnabled(true);
        Button botonCurar=(Button)findViewById(R.id.botonCurar);
        botonCurar.setEnabled(true);
        Button botonRendirse=(Button)findViewById(R.id.botonRendirse);
        botonRendirse.setEnabled(true);
    }
}
