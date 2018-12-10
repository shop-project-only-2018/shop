ALTER TABLE public.customer ADD password varchar NOT NULL;
ALTER TABLE public.customer ADD username varchar NOT NULL;
CREATE UNIQUE INDEX customer_username_uindex ON public.customer (username);
CREATE TABLE public.roles
(
    role_id int PRIMARY KEY NOT NULL,
	description varchar not null
);
CREATE UNIQUE INDEX role_role_id_uindex ON public.roles (role_id);
ALTER TABLE public.customer ADD roles int NULL;

ALTER TABLE public.customer RENAME COLUMN roles TO role_id;
ALTER TABLE public.customer
ADD CONSTRAINT customer_roles_role_id_fk
FOREIGN KEY (role_id) REFERENCES public.roles (role_id);

-- ROLES
INSERT INTO roles(role_id, description) VALUES(1, 'USER');
INSERT INTO roles(role_id, description) VALUES(2, 'ADMIN');