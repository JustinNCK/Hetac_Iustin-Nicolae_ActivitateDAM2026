package com.laborator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Vehicul_spec_ai extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vehicul_spec_ai);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            View header = findViewById(R.id.header_LL);
            float d = getResources().getDisplayMetrics().density;
            header.setPadding((int) (24 * d), systemBars.top + (int) (32 * d), (int) (24 * d), (int) (56 * d));
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void salveazaVehicul(View view){
        EditText et = findViewById(R.id.marca_ET);
        CheckBox cb = findViewById(R.id.eElectric_CB);
        RadioGroup rg = findViewById(R.id.combustil_RG);
        Spinner sp = findViewById(R.id.culoare_SP);
        RatingBar rb = findViewById(R.id.sigranta_RB);
        Switch sw = findViewById(R.id.inmatriculat_SW);

        String marca = et.getText().toString();
        Boolean esteElectric = cb.isChecked();
        int idSelectat = rg.getCheckedRadioButtonId();
        RadioButton rbCombustibil = findViewById(idSelectat);
        String combustibil = rbCombustibil.getText().toString();
        String culoare = sp.getSelectedItem().toString();
        Integer siguranta = (int) rb.getRating();
        Boolean esteInmatriculat = sw.isChecked();

        Vehicul v = new Vehicul(marca, esteElectric, combustibil, culoare, siguranta, esteInmatriculat);
        Bundle raspuns = new Bundle();
        raspuns.putString("marca", v.getMarca());
        raspuns.putBoolean("eElectric", v.getEsteElectric());
        raspuns.putString("combustibil", v.getCombustibil());
        raspuns.putString("culoare", v.getCuloare());
        raspuns.putInt("siguranta", v.getSiguranta());
        raspuns.putBoolean("inmatriculat", v.getEsteInmatriculat());

        Intent it = new Intent();
        it.putExtras(raspuns);
        setResult(RESULT_OK, it);
        finish();
    }
}