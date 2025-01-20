package com.emsi.microservice_commandes.Feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProduitClientFallbackFactory implements FallbackFactory<ProduitClient> {

    private static final Logger log = LoggerFactory.getLogger(ProduitClientFallbackFactory.class);

    @Override
    public ProduitClient create(Throwable cause) {
        return new ProduitClientFallback(cause);
    }
}