package com.example.practica_5_login;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    EditText editMail, editPassword;
    CheckBox cbRecordar;
    Button continuar;
    TextView tMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editMail = findViewById(R.id.editMail);
        editPassword = findViewById(R.id.editPassword);
        cbRecordar = findViewById(R.id.cbRecordar);
        continuar = findViewById(R.id.continuar);
        tMensaje = findViewById(R.id.tMensaje);

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = editMail.getText().toString().trim();
                String password = editPassword.getText().toString();

                if(mail.isEmpty() || password.isEmpty()){
                    tMensaje.setText("Debes rellenar todos los campos");
                }else if(!mail.contains("@") || !mail.contains(".")){
                    tMensaje.setText("Correo electronico no valido");
                }else if(mail.equals("correo@correo.com") && password.equals("1234")){
                    tMensaje.setText("Usuario y contraseña correctos!");
                    if(cbRecordar.isChecked()){
                        Toast.makeText(MainActivity.this, "Usuario recordado", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    tMensaje.setText("Usuario o contraseña incorrectos!");
                }
            }
        });
    }
}