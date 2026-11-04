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

public class Vehicul_spec extends AppCompatActivity {

    private int pozitie = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vehicul_spec);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent it = getIntent();
        if (it != null && it.hasExtra("vehicul_de_modificat")) {
            Vehicul v = it.getParcelableExtra("vehicul_de_modificat");
            pozitie = it.getIntExtra("pozitie", -1);

            if (v != null) {
                EditText et = findViewById(R.id.marca_ET);
                et.setText(v.getMarca());

                CheckBox cb = findViewById(R.id.eElectric_CB);
                cb.setChecked(v.getEsteElectric());

                RadioGroup rg = findViewById(R.id.combustil_RG);
                if ("Benzina".equalsIgnoreCase(v.getCombustibil())) {
                    rg.check(R.id.benzina_RB);
                } else if ("Motorina".equalsIgnoreCase(v.getCombustibil())) {
                    rg.check(R.id.motorina_RB);
                } else if ("Electricitate".equalsIgnoreCase(v.getCombustibil())) {
                    rg.check(R.id.electricitate_RB);
                }

                Spinner sp = findViewById(R.id.culoare_SP);
                String[] culori = getResources().getStringArray(R.array.culori);
                for (int i = 0; i < culori.length; i++) {
                    if (culori[i].equalsIgnoreCase(v.getCuloare())) {
                        sp.setSelection(i);
                        break;
                    }
                }

                RatingBar rb = findViewById(R.id.sigranta_RB);
                rb.setRating(v.getSiguranta());

                Switch sw = findViewById(R.id.inmatriculat_SW);
                sw.setChecked(v.getEsteInmatriculat());
            }
        }
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
//        Bundle raspuns = new Bundle();
//        raspuns.putString("marca", v.getMarca());
//        raspuns.putBoolean("eElectric", v.getEsteElectric());
//        raspuns.putString("combustibil", v.getCombustibil());
//        raspuns.putString("culoare", v.getCuloare());
//        raspuns.putInt("siguranta", v.getSiguranta());
//        raspuns.putBoolean("inmatriculat", v.getEsteInmatriculat());

        Intent it = new Intent();
        it.putExtra("vehicul", v);
        it.putExtra("pozitie", pozitie);
        setResult(RESULT_OK, it);
        finish();
    }

}