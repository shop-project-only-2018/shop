-- USERS
INSERT INTO customer(customer_id, first_name, last_name, username, "password") VALUES(100, 'Admin', 'Admin', 'admin', '$2a$10$x8rXPNhpk2XVq37tg4lhTeAiAkhcRRwubhtYxoRudnKZB3f29pJp2');
INSERT INTO customer(customer_id, first_name, last_name, username, "password") VALUES(101, 'User', 'User', 'user', '$2a$10$x8rXPNhpk2XVq37tg4lhTeAiAkhcRRwubhtYxoRudnKZB3f29pJp2');

-- BOOKS
INSERT INTO book(book_id, "name", price, quantity, "category_id") VALUES(100, 'On the Origin of Species', 100, 100, null);
INSERT INTO book(book_id, "name", price, quantity, "category_id") VALUES(101, 'On the Origin of Species 2', 100, 100, null);
INSERT INTO book(book_id, "name", price, quantity, "category_id") VALUES(102, 'On the Origin of Species 3', 100, 100, null);
INSERT INTO book(book_id, "name", price, quantity, "category_id") VALUES(103, 'On the Origin of Species 4', 100, 100, null);
INSERT INTO book(book_id, "name", price, quantity, "category_id") VALUES(104, 'On the Origin of Species 5', 100, 100, null);
INSERT INTO book(book_id, "name", price, quantity, "category_id") VALUES(105, 'On the Origin of Species 6', 100, 100, null);
INSERT INTO book(book_id, "name", price, quantity, "category_id") VALUES(106, 'On the Origin of Species 7', 100, 100, null);
INSERT INTO book("name", price, quantity, "category_id") VALUES('On the Origin of Species 8', 100, 100, null);
INSERT INTO book("name", price, quantity, "category_id") VALUES('On the Origin of Species 9', 100, 100, null);
INSERT INTO book("name", price, quantity, "category_id") VALUES('On the Origin of Species 10', 100, 100, null);

-- CATEGORIES
INSERT INTO "category"("name", parent_id) VALUES('Tragedy', null);
INSERT INTO "category"("name", parent_id) VALUES('Science fiction', null);
INSERT INTO "category"("name", parent_id) VALUES('Fantasy', null);
INSERT INTO "category"("name", parent_id) VALUES('Mythology', null);
INSERT INTO "category"("name", parent_id) VALUES('Adventure', null);
INSERT INTO "category"("name", parent_id) VALUES('Mystery', null);
INSERT INTO "category"("name", parent_id) VALUES('Drama', null);
INSERT INTO "category"("name", parent_id) VALUES('Romance', null);
INSERT INTO "category"("name", parent_id) VALUES('Action', null);
INSERT INTO "category"("name", parent_id) VALUES('Satire', null);
INSERT INTO "category"("name", parent_id) VALUES('Horror', null);
INSERT INTO "category"("name", parent_id) VALUES('Tragic comedy', null);
INSERT INTO "category"("name", parent_id) VALUES('Dystopia', null);
INSERT INTO "category"("name", parent_id) VALUES('Action thriller', null);