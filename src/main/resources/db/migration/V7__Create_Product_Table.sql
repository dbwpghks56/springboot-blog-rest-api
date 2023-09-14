Create TABLE tb_product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    sku VARCHAR(255),
    description VARCHAR(255),
    active TINYINT(1) DEFAULT 0,
    image_url VARCHAR(255),
    created_at DATETIME,
    updated_at DATETIME,
    status INT DEFAULT 1
);