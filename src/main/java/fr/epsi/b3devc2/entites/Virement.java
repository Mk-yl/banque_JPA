package fr.epsi.b3devc2.entites;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("V")
public class Virement extends Operation {
    private String beneficiaire;

    public Virement() {}

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}
