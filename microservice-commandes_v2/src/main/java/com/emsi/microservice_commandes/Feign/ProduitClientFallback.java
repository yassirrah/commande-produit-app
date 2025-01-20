package com.emsi.microservice_commandes.Feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

public class ProduitClientFallback implements ProduitClient{
    private static final Logger log = LoggerFactory.getLogger(ProduitClientFallback.class);
    private final Throwable cause;

    // Constructeur acceptant la cause de la défaillance
    public ProduitClientFallback(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public Boolean checkIfProduitExists(Long id) {
        // Logique de fallback avec la cause de la défaillance
        log.warn("Fallback executed for checkIfProduitExists with id: {} due to: {}", id, cause.getMessage());
        // Retournez une valeur par défaut ou une logique alternative
        return false; // Par exemple, supposer que le produit n'existe pas en cas de défaillance
    }
}
