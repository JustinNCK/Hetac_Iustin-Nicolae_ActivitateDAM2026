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

public class activitateRezultat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_rezultat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        String mesaj = bundle.getString("mesaj", "");
        Integer numar1 = bundle.getInt("numar1", 0);
        Integer numar2 = bundle.getInt("numar2", 0);

        StringBuilder sb = new StringBuilder(mesaj);
        sb.append(" ");
        sb.append(numar1);
        sb.append(" ");
        sb.append(numar2);

        Toast.makeText(this, sb, Toast.LENGTH_SHORT).show();

    }

    public void deschideActivitate(View view) {
        Bundle bundle = getIntent().getExtras();
        int numar1 = bundle.getInt("numar1", 0);
        int numar2 = bundle.getInt("numar2", 0);

        Bundle raspuns = new Bundle();
        raspuns.putString("mesaj", "Suma este");
        raspuns.putInt("suma", numar1 + numar2);

        Intent it = new Intent();
        it.putExtras(raspuns);
        setResult(RESULT_OK, it);
        finish();
    }

}