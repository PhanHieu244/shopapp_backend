CREATE TABLE `types` (
                                 `id` int PRIMARY KEY AUTO_INCREMENT,
                                 `name` varchar(255) NOT NULL,
                                `code` varchar(50) NOT NULL UNIQUE ,
                                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)ENGINE=InnoDB CHARSET=utf8;