package com.tp.GitConfig.web.controller;

import com.tp.GitConfig.configurations.ApplicationPropertiesConfiguration;
import com.tp.GitConfig.dao.ProductDao;
import com.tp.GitConfig.model.Product;
import com.tp.GitConfig.web.exceptions.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
public class ProductController implements HealthIndicator {
    @Autowired
    ProductDao productDao;
    @Autowired
    ApplicationPropertiesConfiguration appProperties;

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    // Affiche la liste de tous les produits disponibles
    @GetMapping(value = "/Produits")
    public List<Product> listeDesProduits() {
        System.out.println(" ********* ProductController listeDesProduits() ");
        List<Product> products = productDao.findAll();
        if (products.isEmpty()) throw new ProductNotFoundException("Aucun produit n'est disponible à la vente");
        List<Product> listeLimitee = products.subList(0, appProperties.getLimitDeProduits());
        return listeLimitee;
    }

    @GetMapping(value = "/Produits/{id}")
    public Optional<Product> recupererUnProduit(@PathVariable int id) {
        System.out.println(" ********* ProductController recupererUnProduit(@PathVariable int id) ");
        Optional<Product> product = productDao.findById(id);
        if (!product.isPresent())
            throw new ProductNotFoundException("Le produit correspondant à l'id " + id + " n'existe pas");
        return product;
    }

    @Override
    public Health health() {
        System.out.println("****** Actuator : ProductController health() ");
        List<Product> products = productDao.findAll();
        if (products.isEmpty()) {
            return Health.down().build();
        }
        return Health.up().build();
    }

    @GetMapping("/Produits/exists/{id}")
    public ResponseEntity<Boolean> checkIfProduitExists(@PathVariable Long id) {
        try {
            // Simule un délai de 10 secondes pour provoquer un timeout
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        boolean exists = productDao.existsById(Math.toIntExact(id));
        log.info("The id " + id + " exists: " + exists);
        return ResponseEntity.ok(exists);
    }
}
