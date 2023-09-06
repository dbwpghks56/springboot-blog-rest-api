CREATE TABLE comment_seq(
    next_val BIGINT
);

insert into comment_seq values (1);

CREATE TABLE tb_comment(
    id BIGINT Not Null,
    post_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    body VARCHAR(255) NOT NULL,
    created_at DATETIME,
    updated_at DATETIME,
    status INT DEFAULT 1,
    PRIMARY KEY (id),
    FOREIGN KEY (post_id) REFERENCES tb_post(id)
);
