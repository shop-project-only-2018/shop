ALTER TABLE public.orders ADD done boolean DEFAULT false NOT NULL;
ALTER TABLE public.orders ADD address varchar NULL;

ALTER TABLE public.customer ADD cart_id int NULL;
ALTER TABLE public.customer
ADD CONSTRAINT customer_orders_order_id_fk
FOREIGN KEY (cart_id) REFERENCES public.orders (order_id) ON DELETE SET NULL;