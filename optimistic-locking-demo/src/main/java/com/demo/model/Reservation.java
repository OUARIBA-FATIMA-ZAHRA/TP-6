package com.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private String motif;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Salle salle;

    @Version
    private Long version;

    public Reservation() {}

    public Reservation(LocalDateTime dateDebut, LocalDateTime dateFin, String motif) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.motif = motif;
    }

    public Long getId() { return id; }

    public LocalDateTime getDateDebut() { return dateDebut; }

    public LocalDateTime getDateFin() { return dateFin; }

    public String getMotif() { return motif; }

    public Long getVersion() { return version; }

    public void setMotif(String motif) { this.motif = motif; }

    public void setDateDebut(LocalDateTime dateDebut) { this.dateDebut = dateDebut; }

    public void setDateFin(LocalDateTime dateFin) { this.dateFin = dateFin; }

    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }

    public void setSalle(Salle salle) { this.salle = salle; }

    @Override
    public String toString() {
        return "Reservation{id=" + id + ", motif='" + motif + "', version=" + version + "}";
    }
}