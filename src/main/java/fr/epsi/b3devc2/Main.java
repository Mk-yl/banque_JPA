package fr.epsi.b3devc2;


import fr.epsi.b3devc2.entites.*;
import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque_JPA");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            //  Création des clients
            Client client1 = new Client();
            client1.setMontant(5000);
            client1.setMotif("Client principal");
            client1.setDate(LocalDateTime.now());

            Client client2 = new Client();
            client2.setMontant(3000);
            client2.setMotif("Client secondaire");
            client2.setDate(LocalDateTime.now());

            em.persist(client1);
            em.persist(client2);

            //  Création d'un compte Courant
            Courant compte1 = new Courant();
            compte1.setNumero("CPT12345");
            compte1.setSolde(10000);
            compte1.setDecouvert(500.0);

            em.persist(compte1);

            // Association avec les clients
            Set<Compte> comptesClient1 = new HashSet<>();
            comptesClient1.add(compte1);
            client1.setComptes(comptesClient1);

            Set<Compte> comptesClient2 = new HashSet<>();
            comptesClient2.add(compte1);
            client2.setComptes(comptesClient2);

            //  Création d'un client avec plusieurs comptes
            Client client3 = new Client();
            client3.setMontant(7000);
            client3.setMotif("Investisseur");
            client3.setDate(LocalDateTime.now());

            em.persist(client3);

            //  Création d'un compte Assurance Vie
            AssuranceVie assuranceVie = new AssuranceVie();
            assuranceVie.setNumero("AV123");
            assuranceVie.setSolde(15000);
            assuranceVie.setTaux(2.5);
            assuranceVie.setDateFin(LocalDateTime.of (2025, 12, 31, 23, 59, 59));

            assuranceVie.setClient(client3);
            em.persist(assuranceVie);

            // Création d'un compte Livret A
            LivretA livretA = new LivretA();
            livretA.setNumero("LA456");
            livretA.setSolde(5000);
            livretA.setTaux(1.2);

            livretA.setClient(client3);
            em.persist(livretA);

            // Création d'opérations de type Virement
            Virement virement1 = new Virement();
            virement1.setMontant(200);
            virement1.setMotif("Paiement facture");
            virement1.setDate(LocalDateTime.now());
            virement1.setBeneficiaire("Jean Dupont");
            virement1.setCompte(compte1);
            em.persist(virement1);

            Virement virement2 = new Virement();
            virement2.setMontant(500);
            virement2.setMotif("Remboursement");
            virement2.setDate(LocalDateTime.now());
            virement2.setBeneficiaire("Alice Martin");
            virement2.setCompte(compte1);
            em.persist(virement2);

            //  Création d'opérations de type Operation
            Operation operation1 = new Operation();
            operation1.setMontant(100);
            operation1.setMotif("Retrait ATM");
            operation1.setDate(LocalDateTime.now());
            operation1.setCompte(compte1);
            em.persist(operation1);

            Operation operation2 = new Operation();
            operation2.setMontant(50);
            operation2.setMotif("Achat supermarché");
            operation2.setDate(LocalDateTime.now());
            operation2.setCompte(compte1);
            em.persist(operation2);

            em.getTransaction().commit();
            System.out.println("Données insérées avec succès !");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}