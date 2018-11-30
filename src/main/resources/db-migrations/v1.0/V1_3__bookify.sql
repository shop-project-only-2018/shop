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

ALTER TABLE public.book ADD author_id int NULL;
ALTER TABLE public.book
ADD CONSTRAINT book_author_author_id_fk
FOREIGN KEY (author_id) REFERENCES public.author (author_id);

ALTER TABLE public.book ADD description varchar NULL;

alter sequence product_product_id_seq rename to book_book_id_seq
;
