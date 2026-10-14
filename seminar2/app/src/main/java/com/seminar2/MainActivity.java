package com.seminar2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
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

    public void descideActivitate(View view) {
        Intent it = new Intent(this, activitateRezultat.class);
        Bundle bundle = new Bundle();
        bundle.putString("mesaj", "Mesaj din prima activitate");
        bundle.putInt("numar1", 5);
        bundle.putInt("numar2", 7);
        it.putExtras(bundle);
        startActivityForResult(it, 70);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)   {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 70){
            if(resultCode == RESULT_OK){
                String mesaj = data.getStringExtra("mesaj");
                int suma = data.getIntExtra("suma", 0);
                StringBuilder sb = new StringBuilder(mesaj);
                sb.append(" ").append(suma);
                Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MainActivity", "onStart");
        Log.w("MainActivity", "onStart");
        Log.d("MainActivity", "onStart");
        Log.i("MainActivity", "onStart");
        Log.v("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MainActivity", "onResume");
        Log.w("MainActivity", "onResume");
        Log.d("MainActivity", "onResume");
        Log.i("MainActivity", "onResume");
        Log.v("MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MainActivity", "onPause");
        Log.w("MainActivity", "onPause");
        Log.d("MainActivity", "onPause");
        Log.i("MainActivity", "onPause");
        Log.v("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MainActivity", "onStop");
        Log.w("MainActivity", "onStop");
        Log.d("MainActivity", "onStop");
        Log.i("MainActivity", "onStop");
        Log.v("MainActivity", "onStop");
    }
}