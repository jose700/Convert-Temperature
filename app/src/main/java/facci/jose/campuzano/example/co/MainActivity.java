package facci.jose.campuzano.example.co;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
Button ansBtn, repetirBtn;
TextView showAns;
EditText valor;
RadioButton c2f, f2c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        Log.i("Aplicaciones Movil 1", "Jose Campuzano");


        setContentView( R.layout.activity_main );
        ansBtn = (Button)findViewById(R.id.ansBtn);
        repetirBtn =(Button) findViewById( R.id.repetirBtn );
        showAns = (TextView)findViewById(R.id.showAns);
        valor = (EditText)findViewById(R.id.valor);
        c2f = (RadioButton)findViewById(R.id.c2f);
        f2c =(RadioButton) findViewById(R.id.f2c);


        ansBtn.setOnClickListener( new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(valor.getText().toString().isEmpty()){
                    showAns.setText("Por favor ingresa el nùmero a convertir");
                }else{
                    //showAns.setText("Correcto");
                    double x = Double.parseDouble( String.valueOf( valor.getText() ) );
                    if(c2f.isChecked()){
                        x =(x*9)/5+32;

                        x = Double.parseDouble(new DecimalFormat("##.###").format( x ));
                       // mostramos el valor en grado Farenhei
                        showAns.setText(String.valueOf(x)+ "Grado Fº");

                    }else if(f2c.isChecked()){
                        x = (x-32)*5/9;
                        x = Double.parseDouble(new DecimalFormat("##.###").format( x ));
                        showAns.setText(String.valueOf(x) + "Grado Cº");
                    }else{
                        showAns.setText("Por favor selecciona una de las opciones");
                    }
                }
            }
        } );
        repetirBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAns.setText("0.0");
                valor.setText("");
                c2f.setChecked(false);
                f2c.setChecked(false);
            }
        } );
    }
}