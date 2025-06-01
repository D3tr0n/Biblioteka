package com.example.biblioteka;

public class Autor {
    private int idAutora;
    private String imieAutora;
    private String nazwiskoAutora;

    public Autor(int idAutora, String imieAutora, String nazwiskoAutora) {
        this.idAutora = idAutora;
        this.imieAutora = imieAutora;
        this.nazwiskoAutora = nazwiskoAutora;
    }

    public Autor(String imieAutora, String nazwiskoAutora) {
        this.imieAutora = imieAutora;
        this.nazwiskoAutora = nazwiskoAutora;
    }

    public int getIdAutora() {
        return idAutora;
    }

    public void setIdAutora(int idAutora) {
        this.idAutora = idAutora;
    }

    public String getImieAutora() {
        return imieAutora;
    }

    public void setImieAutora(String imieAutora) {
        this.imieAutora = imieAutora;
    }

    public String getNazwiskoAutora() {
        return nazwiskoAutora;
    }

    public void setNazwiskoAutora(String nazwiskoAutora) {
        this.nazwiskoAutora = nazwiskoAutora;
    }

    @Override
    public String toString() {
        return imieAutora + " " + nazwiskoAutora;
    }
}
