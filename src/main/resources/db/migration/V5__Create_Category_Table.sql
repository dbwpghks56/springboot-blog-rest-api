Create TABLE tb_category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    created_at DATETIME,
    updated_at DATETIME,
    status INT DEFAULT 1
);
