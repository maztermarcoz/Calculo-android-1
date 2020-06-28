package com.example.calculodegastosbarroso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    private EditText Nombre;
    private EditText PuntoI;
    private EditText PuntoF;
    private EditText Hora;
    private EditText Costo;
    private EditText Distancia;
    private TextView Total;
    private TextView Horalbl;
    private Button Boton;


    private void iniciar (){
        Nombre =(EditText)findViewById(R.id.edtNombre);
        PuntoI = (EditText)findViewById(R.id.edtPSalida);
        PuntoF = (EditText)findViewById(R.id.edtPLlegada);
        Hora = (EditText)findViewById(R.id.edtTime);
        Costo = (EditText) findViewById(R.id.edtCosto);
        Distancia = (EditText)findViewById(R.id.edtDistancia);
        Boton = (Button)findViewById(R.id.btn1);
        Total = (TextView)findViewById(R.id.lblTotal);
        Horalbl = (TextView)findViewById(R.id.hora);





    }
    public void calcular (View view){
        //Puedes llamarlo por medio de una variable o con una el nombre mas .getText

        String Nom1 = Nombre.getText().toString();

        /*
        String PunA = PuntoI.getText().toString();
        String PunB = PuntoF.getText().toString();
        String Hora = PuntoF.getText().toString();

        */
        try {


            // validacion de llenar todos los espacios
            if (Nombre.length() == 0 || PuntoI.length() == 0 || PuntoF.length() == 0 ||
                    Hora.length()== 0 || Costo.length() == 0 || Distancia.length() == 0)
            {
            Toast.makeText(this, "Debes llenar todos los espacios", Toast.LENGTH_SHORT).show();
            } else{
                String valorHora = Hora.getText().toString();
                int ho1 = Integer.parseInt(valorHora);
                String dist = Distancia.getText().toString();
                double di1 = Double.parseDouble(dist);
                String dias = "";

                int dia = 0;
               // Hora.setText(String.valueOf(ho1));
                if (di1 <= 10){
                    ho1 = ho1 + 100;
                } else if (di1 > 10 & di1 <= 30 ){
                    ho1 = ho1 + 300;
                } else if (di1 > 30){
                    ho1 = ho1 + 1000;
                }

                while(ho1 > 2400  ){
                    dia = dia +1;
                    ho1 = ho1 - 2400;
                    //return;


                }
                if (dia != 0) {


                    switch (dia) {
                        case 1:
                            dias = "mañana";
                        case 2:
                            dias = "pasado mañana";
                        case 3:
                            dias = "traspasado mañana";

                            break;

                    }
                } else{
                    dias = "hoy";
                }


                float comb = Float.parseFloat(Costo.getText().toString());
                float dis = Float.parseFloat(Distancia.getText().toString());
                double CostoT = ((comb * dis)* 0.10) + 20;
                Total.setText(String.valueOf("Costo de: " + CostoT));
                Horalbl.setText(String.valueOf("Hora aprox " + ho1));

                Toast.makeText(this,
                        "Hola " + Nom1 + " vamos de " +
                        PuntoI.getText() + " a " + PuntoF.getText(),
                        Toast.LENGTH_LONG).show();
            }

        } catch (Exception e){
            Toast.makeText(this, "Error desconocido", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciar();
    }
}