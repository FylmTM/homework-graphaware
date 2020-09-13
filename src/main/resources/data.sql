INSERT INTO pizzeria_user (id, name, username, password, email, roles) VALUES (1, 'Alfonso Capone', 'alcapone', '$2y$11$QtP.wOVMy6Bd9j0cbi5DQ.6j34nqbB/j/vks8dvwLcrzDPvSQa5gy', 'al@capone.net', '["CUSTOMER"]') ON CONFLICT DO NOTHING;
INSERT INTO pizzeria_user (id, name, username, password, email, roles) VALUES (2, 'Master cheff', 'cheff', '$2y$11$QtP.wOVMy6Bd9j0cbi5DQ.6j34nqbB/j/vks8dvwLcrzDPvSQa5gy', 'someone@cheff.it', '["PIZZA_MAKER"]') ON CONFLICT DO NOTHING;
INSERT INTO pizzeria_user (id, name, username, password, email, roles) VALUES (3, 'Pelé', 'pele', '$2a$11$0Ykt5/rC6pm0heECrgXIIeiQOSCR0DEVNzN2mCL8VIV1GmFxa9Sy.', 'other@capone.net', '["CUSTOMER", "PIZZA_MAKER"]') ON CONFLICT DO NOTHING;

-- password is 'pwd'

INSERT INTO pizza (id, name, toppings, price) VALUES (3, 'Cheese', '["Parmigiano", "mozzarella", "Cheddar"]', 12.0) ON CONFLICT DO NOTHING;
INSERT INTO pizza (id, name, toppings, price) VALUES (1, 'Margherita', '["Tomato", "mozzarella"]', 13.0) ON CONFLICT DO NOTHING;
INSERT INTO pizza (id, name, toppings, price) VALUES (2, 'Pepperoni', '["Tomato", "mozzarella", "pepperoni"]', 14.0) ON CONFLICT DO NOTHING;
