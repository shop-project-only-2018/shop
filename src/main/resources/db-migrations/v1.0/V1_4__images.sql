CREATE TABLE public.image
(
    image_id serial PRIMARY KEY NOT NULL
);
CREATE UNIQUE INDEX image_image_id_uindex ON public.image (image_id);

ALTER TABLE public.book ADD cover_id int NULL;
ALTER TABLE public.book
ADD CONSTRAINT book_image_image_id_fk
FOREIGN KEY (cover_id) REFERENCES public.image (image_id) ON DELETE SET NULL;