package com.emsi.microservice_commandes.web;

import com.emsi.microservice_commandes.configurations.ApplicationPropertiesConfiguration;
import com.emsi.microservice_commandes.exception.ResourceNotFoundException;
import com.emsi.microservice_commandes.model.Commande;
import com.emsi.microservice_commandes.service.CommandeService;
import com.emsi.microservice_commandes.service.ProduitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CommandeController {
    private final CommandeService commandeService;

    private final ProduitService produitService;

    @Autowired
    ApplicationPropertiesConfiguration appProperties;


    @Autowired
    public CommandeController(CommandeService commandeService, ProduitService produitService) {
        this.commandeService = commandeService;
        this.produitService = produitService;
    }

    @GetMapping("/commandes")
    public List<Commande> getAllCommandes() {

        final Logger log = LoggerFactory.getLogger(CommandeController.class);

        log.info("access to /api/commandes");
        int lastDays = appProperties.getlastDaysCommandes(); // Get the number of days
        LocalDate fromDate = LocalDate.now().minusDays(lastDays); // Calculate the date `n` days ago
        log.info("Fetching commandes from date: {}", fromDate);

        List<Commande> commandes = commandeService.getCommandesFromDate(fromDate);
        log.info("passed the service get commandes from date");
        log.info("Commandes fetched: {}", commandes.size());
        if (commandes.isEmpty()) {
            throw new ResourceNotFoundException("No commandes found in the last " + lastDays + " days.");
        }
        log.info("passed the if statement");
        return commandes;
    }

    @GetMapping("/commandes/{id}")
    public Commande getCommandeById(@PathVariable Long id) {
        return commandeService.getCommandeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Commande not found with id: " + id));
    }

    @PostMapping("/commandes")
    public Commande createCommande(@RequestBody Commande commande) {
        if (!produitService.isProduitValid(commande.getIdProduit())) {
            throw new ResourceNotFoundException("Produit with ID " + commande.getIdProduit() + " not found.");
        }
        Commande savedCommande = commandeService.createCommande(commande);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCommande).getBody();
    }

    @PutMapping("/commandes/{id}")
    public Commande updateCommande(@PathVariable Long id, @RequestBody Commande commande) {
        if (!produitService.isProduitValid(commande.getIdProduit())) {
            throw new ResourceNotFoundException("Produit with ID " + commande.getIdProduit() + " not found.");
        }
        return commandeService.updateCommande(id, commande);
    }


    @DeleteMapping("/commandes/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
        return ResponseEntity.noContent().build();
    }
}
