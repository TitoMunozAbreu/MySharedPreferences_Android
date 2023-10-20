package com.example.mysharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre, email, movil;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instanciar componentes
        this.nombre = findViewById(R.id.nombre);
        this.email = findViewById(R.id.email);
        this.movil = findViewById(R.id.movil);
    }

    public void guardar(View view){
        //instanciar el sharedPreferences
        this.sharedPreferences = getSharedPreferences("SharePreferences", MODE_PRIVATE);
        //instanciar el editor
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        //almacenar los datos ingresados en el editor
        editor.putString("nombre", nombre.getText().toString());
        editor.putString("email", email.getText().toString());
        editor.putString("movil", movil.getText().toString());
        //notificar que ha sido guardado
        Toast.makeText(this, "Datos almacenados", Toast.LENGTH_SHORT).show();
        //guardar cambios realizados
        editor.commit();
        finish();
    }

    private void actualizarVista() {
        //actualizar los campos con los valores del alamcenados en editor
        this.nombre.setText(this.sharedPreferences.getString("nombre",""));
        this.email.setText(this.sharedPreferences.getString("email",""));
        this.movil.setText(this.sharedPreferences.getString("movil",""));
    }

    public void buscar(View view){
        //variable contiene el nombre guardado en el editor
        String nombreAlamcenado = this.sharedPreferences.getString("nombre","");
        //variable contiene el nombre ingresado a buscar
        String nombreABuscar = this.nombre.getText().toString();

        //comprobar que el nombreABuscar se encuentre en el Editor
        if(nombreABuscar.equals(nombreAlamcenado)){
            actualizarVista();
        }else {
            Toast.makeText(this,"NO existen datos asociados a ese nombre", Toast.LENGTH_SHORT).show();

        }

    }


}