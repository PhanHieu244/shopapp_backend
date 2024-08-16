CREATE TABLE carts
(
    `id`                int PRIMARY KEY AUTO_INCREMENT,
   `user_id`            int NOT NULL,
    `product_detail_id` int NOT NULL,
    `quantity`          int NOT NULL,
    created_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)ENGINE=InnoDB CHARSET=utf8;
