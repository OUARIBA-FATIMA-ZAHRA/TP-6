package com.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;

    @Column(unique = true)
    private String email;

    public Utilisateur() {}

    public Utilisateur(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public Long getId() { return id; }

    public String getNom() { return nom; }

    public String getPrenom() { return prenom; }

    public String getEmail() { return email; }

    public void setNom(String nom) { this.nom = nom; }

    public void setPrenom(String prenom) { this.prenom = prenom; }

    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Utilisateur{id=" + id + ", nom='" + nom + "', prenom='" + prenom + "'}";
    }
}