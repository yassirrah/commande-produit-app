package com.emsi.microservice_commandes.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("mes-configs")
@RefreshScope
public class ApplicationPropertiesConfiguration {
    private int lastDaysCommandes;
    public int getlastDaysCommandes() {
        return lastDaysCommandes;
    }
    public void setLastDaysCommandes(int lastDaysCommandes) {
        this.lastDaysCommandes = lastDaysCommandes;
    }
}
