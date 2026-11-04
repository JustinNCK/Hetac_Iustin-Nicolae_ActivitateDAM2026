package com.laborator;

import android.os.Parcelable;
import android.os.Parcel;
import android.text.BoringLayout;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Vehicul implements Parcelable {
    @Override
    public String toString() {
        return "Vehicul{" +
                "marca='" + marca + '\'' +
                ", esteElectric=" + esteElectric +
                ", combustibil='" + combustibil + '\'' +
                ", culoare='" + culoare + '\'' +
                ", siguranta=" + siguranta +
                ", esteInmatriculat=" + esteInmatriculat +
                '}';
    }

    private String marca;
    private Boolean esteElectric;
    private String combustibil;
    private String culoare;
    private Integer siguranta;
    private Boolean esteInmatriculat;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Boolean getEsteElectric() {
        return esteElectric;
    }

    public void setEsteElectric(Boolean esteElectric) {
        this.esteElectric = esteElectric;
    }

    public String getCombustibil() {
        return combustibil;
    }

    public void setCombustibil(String combustibil) {
        this.combustibil = combustibil;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public Integer getSiguranta() {
        return siguranta;
    }

    public void setSiguranta(Integer siguranta) {
        this.siguranta = siguranta;
    }

    public Boolean getEsteInmatriculat() {
        return esteInmatriculat;
    }

    public void setEsteInmatriculat(Boolean esteInmatriculat) {
        this.esteInmatriculat = esteInmatriculat;
    }

    public Vehicul(String marca, Boolean esteElectric, String combustibil, String culoare, Integer siguranta, Boolean esteInmatriculat) {
        this.marca = marca;
        this.esteElectric = esteElectric;
        this.combustibil = combustibil;
        this.culoare = culoare;
        this.siguranta = siguranta;
        this.esteInmatriculat = esteInmatriculat;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(marca);
        dest.writeByte((byte) (esteElectric ? 1 : 0));
        dest.writeString(combustibil);
        dest.writeString(culoare);
        dest.writeInt(siguranta);
        dest.writeByte((byte) (esteInmatriculat ? 1 : 0));
    }

    protected Vehicul(Parcel in){
        marca = in.readString();
        esteElectric = in.readByte() != 0;
        combustibil = in.readString();
        culoare = in.readString();
        siguranta = in.readInt();
        esteInmatriculat = in.readByte() != 0;
    }

    public static final Creator<Vehicul> CREATOR = new Creator<Vehicul>() {
        @Override
        public Vehicul createFromParcel(Parcel in) {
            return new Vehicul(in);
        }

        @Override
        public Vehicul[] newArray(int size) {
            return new Vehicul[size];
        }
    };
}
