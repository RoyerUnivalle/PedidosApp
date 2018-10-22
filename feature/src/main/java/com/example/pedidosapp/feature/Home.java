package com.example.pedidosapp.feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity implements View.OnClickListener {

    Button btnInventarios;
    String name, passwd;
    EditText forName, forPassw;
    TextView tvContador;
    Integer contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //enlace
        btnInventarios = (Button) findViewById(R.id.btnInventario);
        //Escuchador
        btnInventarios.setOnClickListener(this);

        //Recibiendo los datos de la intención origen
        Bundle recibo = getIntent().getExtras();
        name=recibo.getString("user");
        passwd=recibo.getString("passwd");

        forName = (EditText) findViewById(R.id.forName);
        forPassw = (EditText) findViewById(R.id.forPasswd);
        tvContador = (TextView) findViewById(R.id.tvContador);

        forName.setText(name);
        forPassw.setText(passwd);

        if(savedInstanceState==null){
            contador=0;
        }else if (savedInstanceState.containsKey("contador")){
            contador=savedInstanceState.getInt("contador");
        }else{
            contador=0;
        }

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    ///////////////////////////menu------------
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    ///////////////////////////menu------------


    public  void volver(View h){
        Intent volver = new Intent(Home.this,MainActivity.class);
        volver.addFlags(volver.FLAG_ACTIVITY_CLEAR_TASK | volver.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(volver);
    }
    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btnInventario) {
            showInventario();
        }
    }

    public void showInventario(){
        Intent ir = new Intent(Home.this,Inventario.class);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TASK | ir.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ir);
    }

    public void sumar(View u){
            contador=contador+1;
            tvContador.setText(""+contador);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}