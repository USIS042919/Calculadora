package com.ugb.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
// public View calcular () {
    //  TextView tempval = (TextView)findViewById(R.id.txtnum1);
    //        double num1 = Double.parseDouble(tempval.getText().toString());

    //         tempval = (TextView)findViewById(R.id.txtnum2);
    //         double num2 = Double.parseDouble(tempval.getText().toString());

    //        double respuesta = num1 + num2 ;
    //         tempval = (TextView)findViewById(R.id.lblresp);
    //          tempval.setText("Respuesta: "+ respuesta);
    // return null;


    public void procesar(View vista){
        try {
            RadioGroup optOperaciones = (RadioGroup) findViewById(R.id.optOperaciones);
            Spinner cboOperaciones = (Spinner)findViewById(R.id.cboOperaciones);

            TextView tempVal = (TextView) findViewById(R.id.txtnum1);
            double num1 = Double.parseDouble(tempVal.getText().toString());

            tempVal = (TextView) findViewById(R.id.txtnum2);
            double num2 = Double.parseDouble(tempVal.getText().toString());

            double respuesta = 0;
            //Este es para el radiogroup y los radiobuttons
            switch (optOperaciones.getCheckedRadioButtonId()) {
                case R.id.optSuma:
                    respuesta = num1 + num2;
                    break;
                case R.id.optResta:
                    respuesta = num1 - num2;
                    break;
                case R.id.optDivision:
                    respuesta = num1 / num2;
                    break;
                case R.id.optMultiplicar:
                    respuesta = num1 * num2;
                    break;
                case R.id.optExponenciacion:
                    respuesta = Math.pow(num1,num2) ;
                    break;
                case R.id.optPorcentaje:
                    respuesta = num1 * num2 / 100;
                    break;
                case R.id.optModulo:
                    respuesta = num1 % num2;
                    break;
                case R.id.optFactoreo:
                    double factor = 1;
                    while ( num1!=0 ) {
                        factor = factor * num1;
                        num1 --;
                        System.out.println(factor);
                        respuesta = num1;
                        break;
                    }
            }
            //Este es para el spinner... -> Combobox.
            switch (cboOperaciones.getSelectedItemPosition()){
                case 1: //suma
                    respuesta = num1 + num2;
                    break;
                case 2: //resta
                    respuesta = num1 - num2;
                    break;
                case 3: //multiplicacion
                    respuesta = num1 * num2;
                    break;
                case 4: //division
                    respuesta = num1 / num2;
                    break;
                case 5: //Porcentaje
                    respuesta = num1 * num2 / 100;
                    break;
                case 6: //Modulo
                    respuesta = num1 % num2;
                    break;
                case 7: //Exponenciacion
                    respuesta = Math.pow(num1, num2);
                    break;
                case 8: //facctoreo
                    double factorial = 1;
                    while (num1 != 0) {
                        factorial = factorial * num1;
                        num1--;
                        System.out.println(factorial);
                        respuesta = num1;
                        break;
                    }
            }
            tempVal = (TextView) findViewById(R.id.lblresp);
            tempVal.setText("Respuesta: " + respuesta);
        }catch (Exception err){
            TextView temp = (TextView) findViewById(R.id.lblresp);
            temp.setText("Por favor ingrese los numeros correspondientes.");

            Toast.makeText(getApplicationContext(),"Por favor ingrese los numeros.",Toast.LENGTH_LONG).show();
        }
    }
    }
