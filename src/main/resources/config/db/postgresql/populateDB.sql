
INSERT INTO public.phone (phone_id, phone_number, phone_type) VALUES (1, '507640498', 'Mobile');
INSERT INTO public.phone (phone_id, phone_number, phone_type) VALUES (2, '402305235', 'Mobile');

INSERT INTO public.address (address_id, city, state, street, zip_code) VALUES (1, 'Bengalore', 'KA', '1st Street', '560037');
INSERT INTO public.address (address_id, city, state, street, zip_code) VALUES (2, 'Bengalore', 'KA', '1st Street', '560037');

INSERT INTO public.category (category_id, category_name, description) VALUES (1, 'TV', 'Electronics');
INSERT INTO public.category (category_id, category_name, description) VALUES (2, 'Mobile', 'Handheld');

INSERT INTO public.product (product_id, description, product_name, category_id) VALUES (1, 'Samsung 52 inch', 'LED Smart TV', 1);
INSERT INTO public.product (product_id, description, product_name, category_id) VALUES (2, 'Samsung S4', 'Samsung', 2);

INSERT INTO public.customer (customer_id, customer_name, email, address_id, phone_id) VALUES (1, 'Arun', 'arun@nomanworld.com', 1, 1);
INSERT INTO public.customer (customer_id, customer_name, email, address_id, phone_id) VALUES (2, 'Mozhi', 'mozhi@nomanworld.com', 2, 1);

INSERT INTO public.storeorder (store_order_id, order_date, order_status, total_quantity, customer_id) VALUES (1, '2017-03-17 18:55:08.422000', 'Initiated', 1, 1);
INSERT INTO public.storeorder (store_order_id, order_date, order_status, total_quantity, customer_id) VALUES (2, '2017-03-17 18:55:10.000000', 'Initiated', 1, 2);

INSERT INTO public.orderitem (orderitem_id, quantity, unit_price, product_id, store_order_id) VALUES (1, 1, 12323.00, 1, 1);
INSERT INTO public.orderitem (orderitem_id, quantity, unit_price, product_id, store_order_id) VALUES (2, 1, 12323.00, 2, 2);

INSERT INTO role(role_id,role_name) VALUES (1,'ROLE_USER');

INSERT INTO user(user_id,user_name,password) VALUES (1,'admin','password');

INSERT INTO user_role(user_id,role_id) VALUES (1,1);
