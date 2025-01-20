package com.emsi.microservice_commandes.service;

import com.emsi.microservice_commandes.model.Commande;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CommandeService {
    List<Commande> getAllCommandes();
    Optional<Commande> getCommandeById(Long id);
    Commande createCommande(Commande commande);
    Commande updateCommande(Long id, Commande commande);
    void deleteCommande(Long id);
    List<Commande> getCommandesFromDate(LocalDate fromDate);
}
