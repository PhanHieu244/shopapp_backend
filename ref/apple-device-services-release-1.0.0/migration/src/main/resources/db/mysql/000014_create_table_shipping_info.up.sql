CREATE TABLE shipping_infos
(
    `id`                int PRIMARY KEY AUTO_INCREMENT,
    `user_id`           int REFERENCES users (id),
    `gender`             varchar(255) NOT NULL,
    `received_name`     varchar(255) NOT NULL,
    `phone`             varchar(255) NOT NULL,
    `address`           varchar(255) NOT NULL,
    `province_code`     varchar(255) NOT NULL,
    `district_code`     varchar(255) NOT NULL,
    `ward_code`         varchar(255) NOT NULL,
    `note`              varchar(255) NOT NULL,
    created_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE provinces
(
    `id`       int PRIMARY KEY AUTO_INCREMENT,
    `code`     varchar(255) NOT NULL,
    `name`     varchar(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE districts
(
    `id`       int PRIMARY KEY AUTO_INCREMENT,
    `code`     varchar(255) NOT NULL,
    `province_code` varchar(255) NOT NULL REFERENCES provinces (code),
    `name`     varchar(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE wards
(
    `id`       int PRIMARY KEY AUTO_INCREMENT,
    `code`     varchar(255) NOT NULL,
    `district_code` varchar(255) NOT NULL REFERENCES districts (code),
    `name`     varchar(255) NOT NULL,
    `level`    varchar(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)ENGINE=InnoDB CHARSET=utf8;