package com.emsi.microservice_commandes.service;

import com.emsi.microservice_commandes.Feign.ProduitClient;
import com.emsi.microservice_commandes.dao.CommandeRepository;
import com.emsi.microservice_commandes.exception.ResourceNotFoundException;
import com.emsi.microservice_commandes.model.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class CommandeServiceImpl implements CommandeService{

    private final CommandeRepository commandeRepository;

    @Autowired
    public CommandeServiceImpl(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public List<Commande> getCommandesFromDate(LocalDate fromDate) {
        return commandeRepository.findByDateAfter(fromDate);
    }


    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public Optional<Commande> getCommandeById(Long id) {
        return commandeRepository.findById(id);
    }

    @Override
    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande updateCommande(Long id, Commande commande) {
        Commande existingCommande = commandeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Commande not found with id: " + id));

        existingCommande.setDescription(commande.getDescription());
        existingCommande.setQuantite(commande.getQuantite());
        existingCommande.setDate(commande.getDate());
        existingCommande.setMontant(commande.getMontant());
        existingCommande.setIdProduit(commande.getIdProduit());

        return commandeRepository.save(existingCommande);
    }

    @Override
    public void deleteCommande(Long id) {
        Commande existingCommande = commandeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Commande not found with id: " + id));
        commandeRepository.delete(existingCommande);
    }


}
