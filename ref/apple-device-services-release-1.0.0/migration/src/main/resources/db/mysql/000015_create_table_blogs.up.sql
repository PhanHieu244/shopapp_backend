CREATE TABLE blogs
(
    `id`                int PRIMARY KEY AUTO_INCREMENT,
    `title`             text NOT NULL,
    `content`           longtext NOT NULL,
    `user_id`           int REFERENCES users (id),
    `status`            varchar(255) NOT NULL,
    created_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)ENGINE=InnoDB CHARSET=utf8;
