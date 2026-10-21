package com.laborator;

import android.text.BoringLayout;

public class Vehicul {
    @Override
    public String toString() {
        return "Vehicul{" +
                "marca='" + marca + '\'' +
                ", esteElectriv=" + esteElectriv +
                ", combustibil='" + combustibil + '\'' +
                ", culoare='" + culoare + '\'' +
                ", siguranta=" + siguranta +
                ", esteInmatriculat=" + esteInmatriculat +
                '}';
    }

    private String marca;
    private Boolean esteElectriv;
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

    public Boolean getEsteElectriv() {
        return esteElectriv;
    }

    public void setEsteElectriv(Boolean esteElectriv) {
        this.esteElectriv = esteElectriv;
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

    public Vehicul(String marca, Boolean esteElectriv, String combustibil, String culoare, Integer siguranta, Boolean esteInmatriculat) {
        this.marca = marca;
        this.esteElectriv = esteElectriv;
        this.combustibil = combustibil;
        this.culoare = culoare;
        this.siguranta = siguranta;
        this.esteInmatriculat = esteInmatriculat;
    }


}
