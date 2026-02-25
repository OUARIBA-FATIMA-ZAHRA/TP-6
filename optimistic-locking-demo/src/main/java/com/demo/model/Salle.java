package com.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "salles")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private Integer capacite;

    public Salle() {}

    public Salle(String nom, Integer capacite) {
        this.nom = nom;
        this.capacite = capacite;
    }

    public Long getId() { return id; }

    public String getNom() { return nom; }

    public Integer getCapacite() { return capacite; }

    public void setNom(String nom) { this.nom = nom; }

    public void setCapacite(Integer capacite) { this.capacite = capacite; }

    @Override
    public String toString() {
        return "Salle{id=" + id + ", nom='" + nom + "'}";
    }
}
