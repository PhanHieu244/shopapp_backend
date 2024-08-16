CREATE TABLE `product_details` (
                                   `id` int primary key AUTO_INCREMENT,
                                   `product_id` int,
                                   `color_id` int,
                                   `storage_id` int,
                                   `unit_price` float NOT NULL,
                                   `price` float NOT NULL,
                                   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                   updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE `image_details` (
                                 `id` int PRIMARY KEY AUTO_INCREMENT,
                                 `product_detail_id` int,
                                 `img` text,
                                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE `storages` (
                            `id` int PRIMARY KEY AUTO_INCREMENT,
                            `volumne` int NOT NULL ,
                            `unit` varchar(50) NOT NULL,
                            `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE `colors` (
                          `id` int PRIMARY KEY AUTO_INCREMENT,
                          `name` varchar(50) NOT NULL,
                          `code` varchar(20) NOT NULL UNIQUE,
                          `description` text,
                          `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB CHARSET=utf8;

ALTER TABLE `product_details` ADD FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

ALTER TABLE `product_details` ADD FOREIGN KEY (`color_id`) REFERENCES `colors` (`id`);

ALTER TABLE `product_details` ADD FOREIGN KEY (`storage_id`) REFERENCES `storages` (`id`);

ALTER TABLE `image_details` ADD FOREIGN KEY (`product_detail_id`) REFERENCES `product_details` (`id`);

ALTER TABLE `storages`
    ADD CONSTRAINT `unique_volumne_unit` UNIQUE (`volumne`, `unit`);