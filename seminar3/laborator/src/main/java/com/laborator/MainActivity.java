package com.laborator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }

    public void deschideActivitate(View view) {
        Intent it = new Intent(this, Vehicul_spec.class);
        startActivityForResult(it, 1);
    }

    public void deschideActivitateAI(View view) {
        Intent it = new Intent(this, Vehicul_spec_ai.class);
        startActivityForResult(it, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == 1){
            Bundle bundle = data.getExtras();
            String marca = bundle.getString("marca", "");
            Boolean eElectric = bundle.getBoolean("eElectric", false);
            String combustibil = bundle.getString("combustibil", "");
            String culoare = bundle.getString("culoare", "");
            Integer siguranta = bundle.getInt("siguranta", 0);
            Boolean inmatriculat = bundle.getBoolean("inmatriculat", false);

            Vehicul v = new Vehicul(marca, eElectric, combustibil, culoare, siguranta, inmatriculat);

            Toast.makeText(this, v.toString(), Toast.LENGTH_LONG).show();
        }
    }
}