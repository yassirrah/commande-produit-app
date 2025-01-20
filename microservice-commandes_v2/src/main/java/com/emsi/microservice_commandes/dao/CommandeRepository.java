package com.emsi.microservice_commandes.dao;

import com.emsi.microservice_commandes.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findByDateAfter(LocalDate date);
}
