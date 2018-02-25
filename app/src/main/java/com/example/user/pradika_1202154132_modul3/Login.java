package com.example.user.pradika_1202154132_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    //method untuk mengambil username dan password
    //menunjukan bahwa username dan password sudah ditentukan sebelumnya
    //apabila gagal dan berhasil maka akan menampilkan message
    public void login(View view) {
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        String message;
        if (username.getText().toString().equals("EAD") && password.getText().toString().equals("MOBILE")) {
            message = "Berhasil login";
            startActivity(new Intent(this, MainActivity.class));
        } else {
            message = "Gagal login";
            finish();
            startActivity(getIntent());
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}