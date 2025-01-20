package com.emsi.microservice_commandes.service;

import com.emsi.microservice_commandes.Feign.ProduitClient;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class ProduitService {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private ProduitClient produitClient;

    private static final Logger log = LoggerFactory.getLogger(ProduitService.class);

//    @Autowired
//    public ProduitService(ProduitClient produitClient) {
//        this.produitClient = produitClient;
//    }

    @CircuitBreaker(name = "productService", fallbackMethod = "productServiceFallback")
    public boolean isProduitValid(Long idProduit) {
        return produitClient.checkIfProduitExists(idProduit);
    }

    public boolean productServiceFallback(Long idProduit, Throwable throwable) {
        System.out.println("Fallback executed due to: " + throwable.getMessage());
        return false; // Return default response
    }

//    public boolean isProduitValid(Long idProduit) {
//        String url = "http://microservice-produit/Produits/exists/" + idProduit;
////        String url = "http://localhost:9001/Produits/exists/" + idProduit;
//
//
//        try {
//            System.out.println("Checking produit existence with URL: " + url);
//            ResponseEntity<Boolean> response = restTemplate.getForEntity(url, Boolean.class);
//            return response.getBody() != null && response.getBody();
//        } catch (HttpClientErrorException e) {
//            System.out.println("Client error: " + e.getMessage());
//            return false; // Client-side error
//        } catch (ResourceAccessException e) {
//            System.out.println("Service is unavailable: " + e.getMessage());
//            return false; // Network error
//        }
//    }
}
