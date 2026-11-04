package com.laborator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private List<Vehicul> lista;
    private VehiculAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        lista = getIntent().getParcelableArrayListExtra("listaVehicule");
        if(lista == null){
            lista = new ArrayList<>();
        }

        ListView lv = findViewById(R.id.vehicule_LV);
        //ArrayAdapter<Vehicul> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        adapter = new VehiculAdapter(lista, this, R.layout.item_vehicul);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(ListActivity.this, Vehicul_spec.class);
                it.putExtra("vehicul_de_modificat", lista.get(position));
                it.putExtra("pozitie", position);
                startActivityForResult(it, 200);
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                lista.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 200 && resultCode == RESULT_OK && data != null) {
            Vehicul vehiculModificat = data.getParcelableExtra("vehicul");
            int pozitie = data.getIntExtra("pozitie", -1);

            if (vehiculModificat != null && pozitie != -1) {
                lista.set(pozitie, vehiculModificat);
                adapter.notifyDataSetChanged();
            }
        }
    }
}