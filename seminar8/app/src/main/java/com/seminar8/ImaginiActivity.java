package com.seminar8;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ImaginiActivity extends AppCompatActivity {

    private List<ImaginiDomeniu> lista;
    private List<Bitmap> imagini = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_imagini);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<String> linkuriImagini = new ArrayList<>();
        linkuriImagini.add("https://images.unsplash.com/photo-1503376780353-7e6692767b70?w=600&q=80");
        linkuriImagini.add("https://images.unsplash.com/photo-1555215695-3004980ad54e?w=600&q=80");
        linkuriImagini.add("https://images.unsplash.com/photo-1606664515524-ed2f786a0bd6?w=600&q=80");
        linkuriImagini.add("https://images.unsplash.com/photo-1560958089-b8a1929cea89?w=600&q=80");
        linkuriImagini.add("https://images.unsplash.com/photo-1618843479313-40f8afb4b4d8?w=600&q=80");

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.myLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (String link : linkuriImagini) {
                    HttpURLConnection con = null;
                    Bitmap bitmap = null;
                    try {
                        URL url = new URL(link);
                        con = (HttpURLConnection) url.openConnection();
                        InputStream is = con.getInputStream();
                        bitmap = BitmapFactory.decodeStream(is);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (con != null) {
                            con.disconnect();
                        }
                    }
                    imagini.add(bitmap);
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        lista = new ArrayList<>();
                        lista.add(new ImaginiDomeniu("Porsche 911", imagini.get(0), "https://ro.wikipedia.org/wiki/Porsche_911"));
                        lista.add(new ImaginiDomeniu("BMW Seria 3", imagini.get(1), "https://ro.wikipedia.org/wiki/BMW_Seria_3"));
                        lista.add(new ImaginiDomeniu("Audi R8", imagini.get(2), "https://ro.wikipedia.org/wiki/Audi_R8"));
                        lista.add(new ImaginiDomeniu("Tesla Model 3", imagini.get(3), "https://ro.wikipedia.org/wiki/Tesla_Model_3"));
                        lista.add(new ImaginiDomeniu("Mercedes-Benz", imagini.get(4), "https://ro.wikipedia.org/wiki/Mercedes-Benz"));

                        ListView lv = findViewById(R.id.imagini);
                        ImagineAdapter adapter = new ImagineAdapter(getApplicationContext(), R.layout.imagine_layout, lista);
                        lv.setAdapter(adapter);

                        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Intent it = new Intent(getApplicationContext(), WebViewActivity.class);
                                it.putExtra("link", lista.get(i).getLink());
                                startActivity(it);
                            }
                        });
                    }
                });
            }
        });
    }
}
