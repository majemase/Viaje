package com.majemase.viaje;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgDestino, rgTrans;
    RadioButton rDestino1, rTrans1;
    String destino = "", transporte = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgDestino = findViewById(R.id.rgDestino);
        rDestino1 = findViewById(R.id.rDestino1);
        rgTrans = findViewById(R.id.rgTrans);
        rTrans1 = findViewById(R.id.rTrans1);
        destino = rDestino1.getText().toString();
        transporte = rTrans1.getText().toString();
        rgDestino.setOnCheckedChangeListener((group, checkedId) -> destino = (checkedId != -1) ? ((RadioButton) group.findViewById(checkedId)).getText().toString() : "");
        rgTrans.setOnCheckedChangeListener((group, checkedId) -> transporte = (checkedId != -1) ? ((RadioButton) group.findViewById(checkedId)).getText().toString() : "");
        findViewById(R.id.btnInfo).setOnClickListener(v -> mostrarMensaje());
    }

    public void mostrarMensaje(){
        String str = "Me voy a " + destino + " en " + transporte;
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }
}