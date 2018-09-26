package com.example.pedidosapp.feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btnIniciar;
    EditText edName, edPasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //enlazar componente
        btnIniciar = (Button)  findViewById(R.id.btnIniciar);
        edName = (EditText) findViewById(R.id.edName);
        edPasswd = (EditText) findViewById(R.id.edPasswd);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(MainActivity.this,Home.class);
                ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TASK | ir.FLAG_ACTIVITY_CLEAR_TOP);
                if(validar()){
                    Bundle datos = new Bundle();
                    datos.putString("user",edName.getText().toString().trim());
                    datos.putString("passwd",edPasswd.getText().toString().trim());
                    ir.putExtras(datos);
                    startActivity(ir);
                }else{
                    //Primer punto actividid. Mejorar notificación con botones de aceptr y cancelar
                    //HINT: **AlertDialog.Builder**
                    //Segundo punto actividad. Validar que los campos contengan valores especificos.
                    //Tercer punto: enviar los datos: Hint: **Bundle**
                    Toast.makeText(getApplicationContext(),"Deben diligenciar ambos campos",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean validar(){
        boolean res = true;
        if(edPasswd.getText().toString().matches("")){
            res=false;
        }else if (edName.getText().toString().matches("")){
            res=false;
        }
        return res;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG).show();
    }
}
