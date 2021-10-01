DROP TABLE IF EXISTS category CASCADE;
CREATE TABLE category (
      id SERIAL,
      name text,
      PRIMARY KEY (id)
);

DROP TABLE IF EXISTS orders CASCADE;
CREATE TABLE orders (
  id SERIAL,
  order_date date,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product (
       id SERIAL,
       name TEXT,
       price numeric,
       category_id int,
       PRIMARY KEY (id)
);

ALTER TABLE ONLY product
    ADD CONSTRAINT category_id FOREIGN KEY (category_id)
    REFERENCES category(id) ON DELETE CASCADE;

DROP TABLE IF EXISTS product_basket CASCADE;
CREATE TABLE product_basket (
  id SERIAL,
  product_id int,
  amount int,
  order_id int,
  PRIMARY KEY (id)
);


ALTER TABLE ONLY product_basket
    ADD CONSTRAINT product_id FOREIGN KEY (product_id)
    REFERENCES product(id) ON DELETE CASCADE;

ALTER TABLE ONLY product_basket
    ADD CONSTRAINT order_id FOREIGN KEY (order_id)
    REFERENCES orders(id) ON DELETE CASCADE;

DROP TABLE IF EXISTS tag CASCADE;
CREATE TABLE tag (
        id SERIAL,
        name TEXT,
        PRIMARY KEY (id)

);

DROP TABLE IF EXISTS product_tag CASCADE;
CREATE TABLE product_tag (
      product_id int,
      tag_id int,
      PRIMARY KEY (product_id, tag_id)
);

ALTER TABLE ONLY product_tag
    ADD CONSTRAINT product_id FOREIGN KEY (product_id)
    REFERENCES product(id) ON DELETE CASCADE;

ALTER TABLE ONLY product_tag
    ADD CONSTRAINT tag_id FOREIGN KEY (tag_id)
    REFERENCES tag(id) ON DELETE CASCADE;