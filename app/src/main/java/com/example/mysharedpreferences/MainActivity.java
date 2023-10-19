package com.example.mysharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText email;
    private EditText movil;
    private Button btnGuardar;
    private Button btnBuscar;
    //constantes
    private static final String N = "nombre";
    private static final String E = "email";
    private static final String M = "movil";

    private String nombreGuardado;
    private String emailGuardado;
    private String movilGuardado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instanciar componentes
        this.nombre = findViewById(R.id.nombre);
        this.email = findViewById(R.id.email);
        this.movil = findViewById(R.id.movil);
        this.btnBuscar = findViewById(R.id.btnBuscar);
        this.btnGuardar = findViewById(R.id.btnGuardar);

    }



    public void guardar(View view){
        //instanciar el sharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("SharePreferences", MODE_PRIVATE);
        //instanciar el editor
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //establecer las variables que guardaran los datos
        editor.putString(N, nombre.getText().toString());
        editor.putString(E, email.getText().toString());
        editor.putString(M, movil.getText().toString());

        //notificar que ha sido guardado
        Toast.makeText(this, "Datos almacenados", Toast.LENGTH_SHORT).show();
        editor.apply();

    }

    public void cargarDatos(){
        //instanciar el sharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("SharePreferences", MODE_PRIVATE);

        //crear las variables que recibiran los datos que han sido guardados
        this.nombreGuardado = sharedPreferences.getString(N,"");
        this.emailGuardado = sharedPreferences.getString(E,"");
        this.movilGuardado = sharedPreferences.getString(M,"");

    }

    private void actualizarVista() {
        this.nombre.setText(this.nombreGuardado);
        this.email.setText(this.emailGuardado);
        this.movil.setText(this.movilGuardado);
    }

    public void buscar(View view){
        String nombreABuscar = this.nombre.getText().toString();
        cargarDatos();

        if(this.nombreGuardado.equals(nombreABuscar)){
            actualizarVista();
        }else {
            Toast.makeText(this,"NO existen datos asociados a ese nombre", Toast.LENGTH_SHORT).show();
        }
    }


}