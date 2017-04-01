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

DROP TABLE IF EXISTS role CASCADE;
CREATE TABLE role (
  role_id BIGINT PRIMARY KEY NOT NULL,
  role_name varchar(45) NOT NULL
);

DROP TABLE IF EXISTS store_user CASCADE;
CREATE TABLE store_user (
  user_id BIGINT PRIMARY KEY NOT NULL,
  user_name varchar(255) NOT NULL,
  password varchar(255) NOT NULL
) ;

DROP TABLE IF EXISTS user_role CASCADE;
CREATE TABLE user_role (
  user_id BIGINT NOT NULL,
  role_id BIGINT NOT NULL,
  PRIMARY KEY (user_id,role_id),
  CONSTRAINT fk_user_role_roleid FOREIGN KEY (role_id) REFERENCES role (role_id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_user_role_userid FOREIGN KEY (user_id) REFERENCES store_user (user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

