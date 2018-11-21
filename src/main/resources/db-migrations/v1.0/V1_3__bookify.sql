CREATE TABLE public.author
(
    author_id serial PRIMARY KEY NOT NULL,
    first_name varchar NOT NULL,
    last_name varchar NOT NULL
);
CREATE UNIQUE INDEX author_author_id_uindex ON public.author (author_id);


alter table product rename to book
;


alter table book rename column product_id to book_id
;