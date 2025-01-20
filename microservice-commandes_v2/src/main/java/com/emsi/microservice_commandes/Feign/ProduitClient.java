package com.emsi.microservice_commandes.Feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//, fallback = ProduitClientFallbackFactory.class
@FeignClient(name = "microservice-produit", fallbackFactory = ProduitClientFallback.class) // Service name registered in Eureka
public interface ProduitClient {

    @GetMapping("/Produits/exists/{id}")
    @CircuitBreaker(name = "productService", fallbackMethod = "productServiceFallback")
    Boolean checkIfProduitExists(@PathVariable("id") Long id);

    default Boolean productServiceFallback(Long id, Throwable throwable) {
        System.out.println("Fallback executed due to: " + throwable.getMessage());
        return false; // Default response when the service fails
    }

}
