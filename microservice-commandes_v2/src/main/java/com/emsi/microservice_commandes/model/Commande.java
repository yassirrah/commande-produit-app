package com.emsi.microservice_commandes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private int quantite;
    private LocalDate date;
    private double montant;
    @Column(name = "id_produit", nullable = false)
    private Long idProduit;
}