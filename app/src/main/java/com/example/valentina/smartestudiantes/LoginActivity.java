package com.example.valentina.smartestudiantes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Ingresar (View view){
         //SharedPreferences prefs;
         //SharedPreferences.Editor editor;
         //prefs = getPreferences(MODE_PRIVATE);
        // editor=prefs.edit();
        switch (view.getId()){
            case R.id.bIngresar:
                EditText campo= (EditText)findViewById(R.id.suario);
                String campoStr= campo.getText().toString();
                EditText contra= (EditText)findViewById(R.id.eContra);
                String campoContra= campo.getText().toString();
                if((campoStr != null && !campoStr.isEmpty())&&(contra != null && !campoContra.isEmpty())){
                    try{
                        editor.putString("suario", campoStr );
                        editor.putString("eContra",campoContra);
                        Toast.makeText(this,"Str put",Toast.LENGTH_SHORT);
                    }catch (Exception e){
                        Toast.makeText(this,"fail",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
        editor.commit();
        Toast.makeText(this,"commit",Toast.LENGTH_SHORT);
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);

    }
public void refreshPrefs(){
   // prefs = getPreferences(MODE_PRIVATE);
   // editor=prefs.edit();
    TextView data_char, data_int,data_boolean,data_string;
    data_string=(TextView) findViewById(R.id.contenedorPrincipal);
    String suario=prefs.getString("suario","root");
    String eContra=prefs.getString("eContra","root");
    data_string.setText(suario);
    data_string.setText(eContra);
}
}
