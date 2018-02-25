package com.example.user.pradika_1202154132_modul3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    ImageView battery;
    int container = 1;

    //mengdeklarasikan  atribut yang ingin dituju
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView textView = findViewById(R.id.titleDetail);
        ImageView imageView = findViewById(R.id.header);
        TextView lorem = findViewById(R.id.detail);
        textView.setText(getIntent().getStringExtra("title"));
        imageView.setImageResource(getIntent().getIntExtra("image", 0));
        lorem.setText(getIntent().getStringExtra("detail"));
        battery = findViewById(R.id.imageView3);
        battery.setImageResource(R.drawable.ic_battery_20_black_24dp);
    }

    //untuk membuat button minus bisa berjalan, sehingga akan berkurang
    public void kurang (View view) {
        if (between(container--, 1, 3))
            level(container);
    }

    //untuk membuat button plus bisa digunakan, sehingga akan bertambah
    public void tambah (View view) {
        if (between(container++, 1, 3))
            level(container);
    }

    public boolean between(int i, int minValueInclusive, int maxValueInclusive) {
        if (i >= minValueInclusive && i <= maxValueInclusive)
            return true;
        else
            return false;
    }

    //method yang akan menampilkan gambar ketika kondisi air berada sesuai dengan plus & minusnya dijalankan
    //sehingga akan menampilkan toast text yang telah ditentukan
    public void level(int lvl) {
        switch (lvl) {
            case 1:
                battery.setImageResource(R.drawable.ic_battery_20_black_24dp);
                Toast.makeText(this, "Air Sedikit!", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                battery.setImageResource(R.drawable.ic_battery_50_black_24dp);
                break;
            case 3:
                battery.setImageResource(R.drawable.ic_battery_full_black_24dp);
                Toast.makeText(this, "Air Sudah Full!", Toast.LENGTH_SHORT).show();
                break;
            default:
                if (lvl > 3) {
                    container = 3;
                } else if(lvl < 1) {
                    container = 1;
                }
        }
    }

}