CREATE TABLE commande (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          description VARCHAR(255) NOT NULL,
                          quantite INT NOT NULL,
                          date DATE NOT NULL,
                          montant DECIMAL(10, 2) NOT NULL,
                          id_produit BIGINT NOT NULL

);
