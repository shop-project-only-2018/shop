-- ROLES
INSERT INTO roles(role_id, description) VALUES(1, 'USER');
INSERT INTO roles(role_id, description) VALUES(2, 'ADMIN');

-- USERS
INSERT INTO customer(customer_id, role_id, first_name, last_name, username, "password") VALUES(100, 2, 'Admin', 'Admin', 'admin', '$2a$10$x8rXPNhpk2XVq37tg4lhTeAiAkhcRRwubhtYxoRudnKZB3f29pJp2');
INSERT INTO customer(customer_id, role_id, first_name, last_name, username, "password") VALUES(101, 1, 'User', 'User', 'user', '$2a$10$x8rXPNhpk2XVq37tg4lhTeAiAkhcRRwubhtYxoRudnKZB3f29pJp2');

-- COVERS C:\images\*.jpg
INSERT INTO image(image_id) VALUES(nextval('image_image_id_seq'::regclass));
INSERT INTO image(image_id) VALUES(nextval('image_image_id_seq'::regclass));
INSERT INTO image(image_id) VALUES(nextval('image_image_id_seq'::regclass));
INSERT INTO image(image_id) VALUES(nextval('image_image_id_seq'::regclass));
INSERT INTO image(image_id) VALUES(nextval('image_image_id_seq'::regclass));
INSERT INTO image(image_id) VALUES(nextval('image_image_id_seq'::regclass));
--INSERT INTO image(image_id) VALUES(null);
--INSERT INTO image(image_id) VALUES(null);
--INSERT INTO image(image_id) VALUES(null);
--INSERT INTO image(image_id) VALUES(null);

-- AUTHORS
INSERT INTO author(author_id, first_name, last_name) VALUES(2000, 'Charles', 'Darwin');
INSERT INTO author(author_id, first_name, last_name) VALUES(2001, 'Sudhir', 'Kumar');
INSERT INTO author(author_id, first_name, last_name) VALUES(2002, 'Matt', 'Ridley');
INSERT INTO author(author_id, first_name, last_name) VALUES(2003, 'Richard', 'Dawkins');

-- BOOKS
INSERT INTO book("name", price, quantity, cover_id, author_id, description) VALUES( 'On the Origin of Species', 179, 99, 1, 2000, 'On the Origin of Species, published on 24 November 1859, is a work of scientific literature by Charles Darwin which is considered to be the foundation of evolutionary biology.');
INSERT INTO book("name", price, quantity, cover_id, author_id, description) VALUES( 'On the Origin of Species 1', 49, 100, 2, 2000, 'On the Origin of Species, published on 24 November 1859, is a work of scientific literature by Charles Darwin which is considered to be the foundation of evolutionary biology.');
INSERT INTO book("name", price, quantity, cover_id, author_id, description) VALUES( 'On the Origin of Species 2', 99, 100, 3, 2000, 'On the Origin of Species, published on 24 November 1859, is a work of scientific literature by Charles Darwin which is considered to be the foundation of evolutionary biology.');
INSERT INTO book("name", price, quantity, cover_id, author_id, description) VALUES( 'Molecular Biology and Evolution', 249, 299, 4, 2001, 'Molecular Biology and Evolution is a monthly peer-reviewed scientific journal published by Oxford University Press on behalf of the Society for Molecular Biology and Evolution. It publishes work in the intersection of molecular biology and evolutionary biology.');
INSERT INTO book("name", price, quantity, cover_id, author_id, description) VALUES( 'Genome: The Autobiography of a Species in 23 Chapters', 199, 299, 5, 2002, 'Genome: The Autobiography of a Species in 23 Chapters is a 1999 popular science book by the science writer Matt Ridley, published by Fourth Estate. The chapters are numbered for the pairs of human chromosomes, one pair being the X and Y sex chromosomes, so the numbering goes up to 22.');
INSERT INTO book("name", price, quantity, cover_id, author_id, description) VALUES( 'The Selfish Gene', 299, 299, 6, 2003, 'The Selfish Gene is a 1976 book on evolution by Richard Dawkins. Dawkins uses the term "selfish gene" as a way of expressing the gene-centred view of evolution as opposed to the views focused on the organism and the group, popularising ideas developed during the 1960s by W. D. Hamilton and others. From the gene-centred view, it follows that the more two individuals are genetically related, the more sense (at the level of the genes) it makes for them to behave selflessly with each other.');


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