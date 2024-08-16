CREATE TABLE inventories
(
    `id`                int PRIMARY KEY AUTO_INCREMENT,
    `product_detail_id` int NOT NULL,
    `amount`            int NOT NULL,
    `available`         int,
    `sold`              int       default 0,
    created_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)ENGINE=InnoDB CHARSET=utf8;