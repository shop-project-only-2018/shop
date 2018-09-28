create table status
(
	status_id serial not null
		constraint status_pkey
			primary key,
	status varchar not null
)
;

alter table status owner to postgres
;

create unique index status_id_uindex
	on status (status_id)
;

create table payment_method
(
	payment_method_id serial not null
		constraint payment_method_pkey
			primary key,
	description varchar not null
)
;

alter table payment_method owner to postgres
;

create unique index payment_method_id_uindex
	on payment_method (payment_method_id)
;

create table category
(
	category_id serial not null
		constraint category_pkey
			primary key,
	name varchar not null,
	parent_id integer
		constraint category_category_category_id_fk
			references category
)
;

alter table category owner to postgres
;

create unique index category_id_uindex
	on category (category_id)
;

create table customer
(
	customer_id serial not null
		constraint customer_pkey
			primary key
)
;

alter table customer owner to postgres
;

create unique index customer_id_uindex
	on customer (customer_id)
;

create table person
(
	first_name varchar not null,
	last_name varchar not null,
	customer_id integer not null
		constraint person_pk
			primary key
		constraint person_customer_customer_id_fk
			references customer
				on delete cascade
)
;

alter table person owner to postgres
;

create table organization
(
	name varchar not null,
	customer_id integer not null
		constraint organization_pk
			primary key
		constraint organization_customer_customer_id_fk
			references customer
				on delete cascade
)
;

alter table organization owner to postgres
;

create table phone
(
	number varchar not null,
	phone_id serial not null
		constraint phone_pk
			primary key,
	customer_id integer not null
		constraint phone_customer_customer_id_fk
			references customer
				on delete cascade
)
;

alter table phone owner to postgres
;

create unique index phones_number_uindex
	on phone (number)
;

create unique index phone_phone_id_uindex
	on phone (phone_id)
;

create table address
(
	address varchar not null,
	customer_id integer not null
		constraint address_customer_customer_id_fk
			references customer
				on delete cascade,
	address_id serial not null
		constraint address_pk
			primary key
)
;

alter table address owner to postgres
;

create unique index address_address_id_uindex
	on address (address_id)
;

create table orders
(
	order_id serial not null
		constraint order_pkey
			primary key,
	added timestamp default now() not null,
	customer_id integer
		constraint order_customer_customer_id_fk
			references customer,
	payment_method_id integer default 1 not null
		constraint order_payment_method_payment_method_id_fk
			references payment_method,
	status_id integer default 1
		constraint order_status_status_id_fk
			references status,
	price numeric
)
;

alter table orders owner to postgres
;

create unique index order_order_id_uindex
	on orders (order_id)
;

create table product
(
	product_id serial not null
		constraint product_pkey
			primary key,
	name varchar not null,
	price numeric(10,4) not null,
	quantity integer not null,
	category_id integer
		constraint product_category_category_id_fk
			references category
)
;

alter table product owner to postgres
;

create unique index product_product_id_uindex
	on product (product_id)
;

create table order_item
(
	order_item_id serial not null
		constraint order_item_pkey
			primary key,
	quantity integer not null,
	order_id integer not null
		constraint order_item_order_order_id_fk
			references orders
				on delete cascade,
	product_id integer not null
		constraint order_item_product_product_id_fk
			references product,
	price numeric not null
)
;

alter table order_item owner to postgres
;

create unique index order_item_order_item_id_uindex
	on order_item (order_item_id)
;

