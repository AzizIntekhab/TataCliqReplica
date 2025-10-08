CREATE TABLE categories
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    name       VARCHAR(255)          NULL,
    is_deleted BIT(1)                NOT NULL,
    created_at datetime              NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

CREATE TABLE products
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255)          NULL,
    is_deleted    BIT(1)                NOT NULL,
    created_at    datetime              NULL,
    `description` VARCHAR(255)          NULL,
    category_id   BIGINT                NULL,
    price         DOUBLE                NULL,
    image_url     VARCHAR(255)          NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES categories (id);