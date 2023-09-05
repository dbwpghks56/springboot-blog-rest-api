CREATE TABLE tb_post (
    id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    created_at DATETIME,
    updated_at DATETIME,
    status INT DEFAULT 1,
    PRIMARY KEY (id),
    UNIQUE KEY uk_post_title (title)
);