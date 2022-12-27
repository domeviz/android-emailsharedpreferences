package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText)findViewById(R.id.txt_mail);

        //getSharedPreferences: Recupera los valores guardados
        //Ponemos el nombre del archivo de preferencias y el contexto
        SharedPreferences preferences=getSharedPreferences("datos", Context.MODE_PRIVATE);
        //Si no hay nada en el preferences se pone "" para que no este vacio
        et.setText(preferences.getString("mail", ""));
    }

    //Metodo para el boton guardar
    public void Guardar(View view){
        SharedPreferences preferencias= getSharedPreferences("datos",Context.MODE_PRIVATE);
        //Clase Editor: Permite guardar los archivos
        SharedPreferences.Editor obj_editor=preferencias.edit();
        //Guardamos dentro del objeto editor lo que esta en et
        obj_editor.putString("mail",et.getText().toString());
        //Confirmamos que queremos guardar
        obj_editor.commit();
        //Finalizamos el activity
        finish();
    }
}