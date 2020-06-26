package com.example.practica1;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void ComenzarJuego(View view){
        final TextView nombreInput;
        TextView nombreInput2;
        nombreInput=(TextView) findViewById(R.id.nombreInput);
        String nombre= nombreInput.getText().toString();
        Intent siguiente = new Intent(this,Juego.class);
        siguiente.putExtra("NombreUsuario",nombre);
        startActivity(siguiente);
    }

}
