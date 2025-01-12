package com.KenanHavicipia.example.models;

public class Employee {
    private int id;
    private String ime;
    private String pozicija;
    private String datumZaposlenja;
    private String korisnickoIme;
    private String lozinka;
    private String role;

    public Employee(int id, String ime, String pozicija, String datumZaposlenja, String korisnickoIme, String lozinka, String role) {
        this.id = id;
        this.ime = ime;
        this.pozicija = pozicija;
        this.datumZaposlenja = datumZaposlenja;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.role = role;
    }


    public Employee(String ime, String pozicija, String datumZaposlenja, String korisnickoIme, String lozinka, String role) {
        this.ime = ime;
        this.pozicija = pozicija;
        this.datumZaposlenja = datumZaposlenja;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.role = role;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public String getDatumZaposlenja() {
        return datumZaposlenja;
    }

    public void setDatumZaposlenja(String datumZaposlenja) {
        this.datumZaposlenja = datumZaposlenja;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getUloga() {
        return this.role;
    }
}
