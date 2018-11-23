-- USERS
INSERT INTO customer(customer_id, first_name, last_name, username, "password") VALUES(100, 'Admin', 'Admin', 'admin', '$2a$10$x8rXPNhpk2XVq37tg4lhTeAiAkhcRRwubhtYxoRudnKZB3f29pJp2');
INSERT INTO customer(customer_id, first_name, last_name, username, "password") VALUES(101, 'User', 'User', 'user', '$2a$10$x8rXPNhpk2XVq37tg4lhTeAiAkhcRRwubhtYxoRudnKZB3f29pJp2');

-- COVERS
INSERT INTO image(image_id) VALUES(1);
INSERT INTO image(image_id) VALUES(2);
INSERT INTO image(image_id) VALUES(3);

-- AUTHORS
INSERT INTO author(author_id, first_name, last_name) VALUES(2000, 'Charles', 'Darwin');

-- BOOKS
INSERT INTO book("name", price, quantity, cover_id, author_id, description) VALUES( 'On the Origin of Species', 100, 100, 1, 2000, 'On the Origin of Species, published on 24 November 1859, is a work of scientific literature by Charles Darwin which is considered to be the foundation of evolutionary biology.');
INSERT INTO book("name", price, quantity, cover_id, author_id, description) VALUES( 'On the Origin of Species 1', 100, 100, 2, 2000, 'On the Origin of Species, published on 24 November 1859, is a work of scientific literature by Charles Darwin which is considered to be the foundation of evolutionary biology.');
INSERT INTO book("name", price, quantity, cover_id, author_id, description) VALUES( 'On the Origin of Species 2', 100, 100, 3, 2000, 'On the Origin of Species, published on 24 November 1859, is a work of scientific literature by Charles Darwin which is considered to be the foundation of evolutionary biology.');
INSERT INTO book("name", price, quantity, cover_id, author_id, description) VALUES( 'On the Origin of Species 3', 100, 100, 1, 2000, 'On the Origin of Species, published on 24 November 1859, is a work of scientific literature by Charles Darwin which is considered to be the foundation of evolutionary biology.');

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