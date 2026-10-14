package com.seminar2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activitateNoua extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_noua);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void adaugaActivitate(View view) {

        Intent it = new Intent(this, activitateRezultat.class);

        Bundle bundle = new Bundle();
        bundle.putString("mesaj", "Numerele sunt");
        bundle.putInt("numar1", 5);
        bundle.putInt("numar2", 7);
        it.putExtras(bundle);

        startActivityForResult(it, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String mesaj = bundle.getString("mesaj", "");
            int suma = bundle.getInt("suma", 0);

            Toast.makeText(this, mesaj + " " + suma, Toast.LENGTH_SHORT).show();
        }
    }
}