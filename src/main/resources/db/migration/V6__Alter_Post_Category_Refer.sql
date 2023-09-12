ALTER TABLE tb_post
    ADD COLUMN category_id BIGINT,
    ADD CONSTRAINT fk_post_category FOREIGN KEY (category_id) REFERENCES tb_category(id);
