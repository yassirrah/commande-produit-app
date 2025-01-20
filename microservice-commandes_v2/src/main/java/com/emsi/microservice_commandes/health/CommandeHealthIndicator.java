package com.emsi.microservice_commandes.health;

import com.emsi.microservice_commandes.dao.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;


@Component
public class CommandeHealthIndicator implements HealthIndicator {

    private CommandeRepository commandeRepository;

    @Autowired
    public CommandeHealthIndicator(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public Health health() {
        long count = commandeRepository.count();

        if (count > 0) {
            return Health.up().withDetail("message", "Commandes disponibles").withDetail("count", count).build();
        } else {
            return Health.down().withDetail("message", "Aucune commande disponible").build();
        }
    }

    @Override
    public Health getHealth(boolean includeDetails) {
        return HealthIndicator.super.getHealth(includeDetails);
    }
}
