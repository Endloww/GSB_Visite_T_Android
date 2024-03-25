package com.example.gsbvisitet;

public class Praticien {
    private String praticienId;
    private String nom;
    private String prenom;
    private String adresse;
    private String cp;

    public String getPraticienId() {
        return praticienId;
    }

    public void setPraticienId(String praticienId) {
        this.praticienId = praticienId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Praticien(String nom, String prenom, String adresse, String cp, String ville, String tel, String rue, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.cp = cp;
        this.ville = ville;
        this.tel = tel;
        this.rue = rue;
        this.email = email;
    }

    private String ville;
    private String tel;
    private String rue;
    private String email;

}
