package fr.epsi.b3devc2.entites;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "ASSURANCE_VIE")
public class AssuranceVie extends Compte {
    private LocalDateTime dateFin;
    private double taux;

    public AssuranceVie() {}

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
