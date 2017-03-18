DROP TABLE IF EXISTS phone CASCADE;
CREATE TABLE phone
(
    phone_id BIGINT PRIMARY KEY NOT NULL,
    phone_number VARCHAR(255),
    phone_type VARCHAR(255)
);

DROP TABLE IF EXISTS address CASCADE ;
CREATE TABLE address
(
    address_id BIGINT PRIMARY KEY NOT NULL,
    city VARCHAR(255),
    state VARCHAR(255),
    street VARCHAR(255),
    zip_code VARCHAR(255)
);

DROP TABLE IF EXISTS category CASCADE;
CREATE TABLE category
(
    category_id BIGINT PRIMARY KEY NOT NULL,
    category_name VARCHAR(255),
    description VARCHAR(255)
);

DROP TABLE IF EXISTS customer CASCADE;
CREATE TABLE customer
(
    customer_id BIGINT PRIMARY KEY NOT NULL,
    customer_name VARCHAR(255),
    email VARCHAR(255),
    address_id BIGINT,
    phone_id BIGINT,
    CONSTRAINT fk_customer_address FOREIGN KEY (address_id) REFERENCES address (address_id),
    CONSTRAINT fk_customer_phone FOREIGN KEY (phone_id) REFERENCES phone (phone_id)
);

DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product
(
    product_id BIGINT PRIMARY KEY NOT NULL,
    description VARCHAR(255),
    product_name VARCHAR(255),
    category_id BIGINT,
    CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES category (category_id)
);

DROP TABLE IF EXISTS storeorder CASCADE;
CREATE TABLE storeorder
(
    store_order_id BIGINT PRIMARY KEY NOT NULL,
    order_date TIMESTAMP,
    order_status VARCHAR(255),
    total_quantity INTEGER,
    customer_id BIGINT,
    CONSTRAINT fk_storeorder_customer FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
);

DROP TABLE IF EXISTS orderitem CASCADE;
CREATE TABLE orderitem
(
    orderitem_id BIGINT PRIMARY KEY NOT NULL,
    quantity INTEGER,
    unit_price NUMERIC(19,2),
    product_id BIGINT,
    store_order_id BIGINT,
    CONSTRAINT fk_orderitem_product FOREIGN KEY (product_id) REFERENCES product (product_id),
    CONSTRAINT fk_orderitem_store_order FOREIGN KEY (store_order_id) REFERENCES storeorder (store_order_id)
);

DROP TABLE IF EXISTS order_orderitem CASCADE;
CREATE TABLE order_orderitem
(
    order_order_id BIGINT NOT NULL,
    orderitem_orderitem_id BIGINT NOT NULL,
    CONSTRAINT order_orderitem_pkey PRIMARY KEY (order_order_id, orderitem_orderitem_id)
);
CREATE UNIQUE INDEX uk_orderitem ON order_orderitem (orderitem_orderitem_id);



DROP sequence IF EXISTS hibernate_sequence CASCADE;
