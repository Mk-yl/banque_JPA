package fr.epsi.b3devc2.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "LIVRET_A")
public class LivretA extends Compte {
    private double taux;

    public LivretA() {}

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
