DROP TABLE IF EXISTS Product;
CREATE TABLE Product (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         titre VARCHAR(255) NOT NULL,
                         description TEXT,
                         image VARCHAR(255),
                         prix DOUBLE
);
--
-- INSERT INTO Product (titre, description, image, prix) VALUES
--                                                           ('Laptop', 'High-performance laptop for gaming and work', 'https://example.com/laptop.jpg', 1200.99),
--                                                           ('Smartphone', 'Latest model smartphone with high-resolution camera', 'https://example.com/phone.jpg', 799.99),
--                                                           ('Headphones', 'Noise-cancelling over-ear headphones', 'https://example.com/headphones.jpg', 199.99);
