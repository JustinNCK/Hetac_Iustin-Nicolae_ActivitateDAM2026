package com.seminar8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImagineAdapter extends BaseAdapter {
    private List<ImaginiDomeniu> lista = null;
    private Context ctx;
    private int resursaLayout;

    public ImagineAdapter(Context ctx, int resursaLayout, List<ImaginiDomeniu> lista) {
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
        this.lista = lista;
    }

    public ImagineAdapter(List<ImaginiDomeniu> lista, Context ctx, int resursaLayout) {
        this.lista = lista;
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(resursaLayout, parent, false);

        ImageView iv = v.findViewById(R.id.imagineIV);
        TextView tv = v.findViewById(R.id.text_TV);

        ImaginiDomeniu img = (ImaginiDomeniu) getItem(position);

        if (img.getImagine() != null) {
            iv.setImageBitmap(img.getImagine());
        }
        tv.setText(img.getTextAfisat());

        return v;
    }
}
