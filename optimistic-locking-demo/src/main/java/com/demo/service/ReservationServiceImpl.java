package com.demo.service;

import com.demo.model.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

public class ReservationServiceImpl implements ReservationService {

    private final EntityManagerFactory emf;

    public ReservationServiceImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Reservation save(Reservation reservation) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(reservation);
        em.getTransaction().commit();
        em.close();
        return reservation;
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Reservation r = em.find(Reservation.class, id);
        em.close();
        return Optional.ofNullable(r);
    }

    @Override
    public void update(Reservation reservation) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(reservation);
        em.getTransaction().commit();
        em.close();
    }
}
