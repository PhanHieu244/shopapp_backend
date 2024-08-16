CREATE TABLE `products` (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            name TEXT NOT NULL,
                            code VARCHAR(20) NOT NULL,
                            description TEXT,
                            banner_img TEXT NOT NULL,
                            status VARCHAR(10) NOT NULL,
                            warranty_duration BIGINT NOT NULL,
                            type_id int NOT NULL,
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB CHARSET=utf8;

