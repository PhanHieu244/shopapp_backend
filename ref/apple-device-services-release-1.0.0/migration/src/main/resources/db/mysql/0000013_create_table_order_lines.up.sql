CREATE TABLE order_lines
(
    `id`                int PRIMARY KEY AUTO_INCREMENT,
    `order_id`          int REFERENCES orders (id),
    `code`              varchar(255) NOT NULL,
    `quantity`          int          NOT NULL,
    `product_detail_id` int          NOT NULL REFERENCES product_details (id),
    created_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)ENGINE=InnoDB CHARSET=utf8;
