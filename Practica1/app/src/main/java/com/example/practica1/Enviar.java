package com.example.practica1;
import android.os.AsyncTask;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;

public class Enviar extends AsyncTask<String,Void,Void>{
    Socket s;
    DataOutputStream dt;
    PrintWriter pw;
    private String[] Voids;

    @Override
    protected Void doInBackground(String... strings) {
        String mensaje=Voids[0];
        try{
            s=new Socket("192.168.0.15",8080);
            pw= new PrintWriter(s.getOutputStream());
            pw.write(mensaje);
            pw.flush();
            pw.close();
        }catch(Exception e){

        }
        return null;
    }
}
