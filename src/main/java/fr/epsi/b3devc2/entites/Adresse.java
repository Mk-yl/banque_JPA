package fr.epsi.b3devc2.entites;

import jakarta.persistence.*;


@Entity
@Table(name = "ADRESSE")

public class Adresse {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String numero;
        private String rue;
        private String codePostal;
        private String ville;

        //constructeur vide
        public Adresse() {
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getNumero() {
                return numero;
        }

        public void setNumero(String numero) {
                this.numero = numero;
        }

        public String getRue() {
                return rue;
        }

        public void setRue(String rue) {
                this.rue = rue;
        }

        public String getCodePostal() {
                return codePostal;
        }

        public void setCodePostal(String codePostal) {
                this.codePostal = codePostal;
        }

        public String getVille() {
                return ville;
        }

        public void setVille(String ville) {
                this.ville = ville;
        }
}
