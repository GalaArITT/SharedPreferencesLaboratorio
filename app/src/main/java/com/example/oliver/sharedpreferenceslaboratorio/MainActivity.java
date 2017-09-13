package com.example.oliver.sharedpreferenceslaboratorio;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String NAME = "NAME";
    final String CELULAR = "CELULAR";
    final String DIRECCION = "DIRECCION";
    final String FECHA = "FECHA";
    final String HORA = "HORA";
    final String PLATILLOS = "PLATILLOS";
    final String POSTRES = "POSTRES";
    final String LUJO = "lUJO";
    final String BASICA = "BASICA";
    final String MESEROS = "MESEROS";

    EditText editText1,editText2,editText3,editText4,editText5,editText6,editText7;
    TextView textView;
    SeekBar seekBar;
    CheckBox checkBox1,checkBox2;
    Button btn_guardar, btn_mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText)findViewById(R.id.txt_cliente);
        editText2 = (EditText)findViewById(R.id.txt_celular);
        editText3 = (EditText)findViewById(R.id.txt_dire);
        editText4 = (EditText)findViewById(R.id.txt_fecha);
        editText5 = (EditText)findViewById(R.id.txt_fec);
        editText6 = (EditText)findViewById(R.id.txt_plat);
        editText7 = (EditText)findViewById(R.id.txt_post);

        checkBox1 = (CheckBox)findViewById(R.id.txt_lujo);
        checkBox2 =(CheckBox)findViewById(R.id.txt_basic);

        seekBar = (SeekBar)findViewById(R.id.seekBar);
        btn_guardar = (Button)findViewById(R.id.btn_guardar);
        btn_mostrar = (Button)findViewById(R.id.btn_leer);

        textView = (TextView)findViewById(R.id.textView);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor= getPreferences(MODE_PRIVATE).edit();

                editor.putString(NAME,editText1.getText().toString());
                editor.putString(CELULAR,editText2.getText().toString());
                editor.putString(DIRECCION,editText3.getText().toString());
                editor.putString(FECHA,editText4.getText().toString());
                editor.putString(HORA,editText5.getText().toString());
                editor.putString(PLATILLOS,editText6.getText().toString());
                editor.putString(POSTRES,editText7.getText().toString());
                editor.putBoolean(LUJO,checkBox1.isChecked());
                editor.putBoolean(BASICA,checkBox2.isChecked());
                editor.putInt(MESEROS,seekBar.getProgress());
                editor.commit();

            }
        });

        btn_mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                String nombre = sharedPreferences.getString(NAME,null);
                String celular= sharedPreferences.getString(CELULAR,null);
                String direccion = sharedPreferences.getString(DIRECCION,null);
                String fecha = sharedPreferences.getString(FECHA,null);
                String hora = sharedPreferences.getString(HORA,null);
                String platillos = sharedPreferences.getString(PLATILLOS,null);
                String postres = sharedPreferences.getString(POSTRES,null);
                Boolean lujo = sharedPreferences.getBoolean(LUJO,false);
                Boolean basica = sharedPreferences.getBoolean(BASICA,false);
                int meseros = sharedPreferences.getInt(MESEROS,0);

                textView.setText("--> "+nombre+"\n"+"--> "+celular+"\n"+"--> "+direccion
                        +"\n"+"--> "+fecha+"\n"+"--> "+hora+"\n"+"--> "+platillos
                        +"\n"+"--> "+postres+"\n"+"--> "+lujo
                        +"\n"+"--> "+basica+"\n"+"--> "+meseros);




            }
        });

    }
}
