package com.demo;

import com.demo.model.*;
import com.demo.service.*;

import javax.persistence.*;
import java.time.LocalDateTime;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("optimistic-locking-demo");

        ReservationService service = new ReservationServiceImpl(emf);

        // INITIALISATION
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Utilisateur u1 = new Utilisateur("El Idrissi", "Fatima", "fatima@email.com");
        Utilisateur u2 = new Utilisateur("Bennani", "Ali", "ali@email.com");

        Salle salle = new Salle("Salle Informatique B12", 40);

        em.persist(u1);
        em.persist(u2);
        em.persist(salle);

        Reservation r = new Reservation(
                LocalDateTime.now().plusDays(2),
                LocalDateTime.now().plusDays(2).plusHours(2),
                "Soutenance PFE"
        );

        r.setUtilisateur(u1);
        r.setSalle(salle);

        em.persist(r);
        em.getTransaction().commit();
        em.close();

        System.out.println("Reservation initiale : " + r);

        // Simulation conflit
        Reservation r1 = service.findById(1L).get();
        Reservation r2 = service.findById(1L).get();

        r1.setMotif("Modification par Thread 1");
        service.update(r1);

        try {
            r2.setMotif("Modification par Thread 2");
            service.update(r2);
        } catch (OptimisticLockException e) {
            System.out.println("Conflit détecté !");
        }

        emf.close();
    }
}
