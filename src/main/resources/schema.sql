CREATE TABLE shop
(
    id           BIGINT PRIMARY KEY auto_increment,
    identifier   VARCHAR NOT NULL,
    status       VARCHAR NOT NULL,
    creation_date DATE
);

CREATE TABLE shop_item
(
    id                 BIGINT PRIMARY KEY auto_increment,
    product_identifier VARCHAR(100) NOT NULL,
    amout              INT          NOT NULL,
    price              FLOAT        NOT NULL,
    shop_id            BIGINT REFERENCES shop (id)
);