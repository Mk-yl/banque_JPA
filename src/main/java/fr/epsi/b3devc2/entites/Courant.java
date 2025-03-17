package fr.epsi.b3devc2.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "COURANT")
public class Courant extends Compte {
    private double decouvert;

    public Courant() {}

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
}
