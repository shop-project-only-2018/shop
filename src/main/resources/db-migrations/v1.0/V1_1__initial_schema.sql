create table organization
(
	name varchar not null,
	organization_id serial not null
		constraint organizations_pkey
			primary key
)
;

alter table organization owner to postgres
;

create unique index organizations_id_uindex
	on organization (organization_id)
;

create table person
(
	person_id serial not null
		constraint person_pkey
			primary key,
	first_name varchar not null,
	last_name varchar not null
)
;

alter table person owner to postgres
;

create unique index person_id_uindex
	on person (person_id)
;

create table phone
(
	number varchar not null,
	phone_id serial not null
		constraint phone_pk
			primary key
		constraint phone_person_person_id_fk
			references person
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

create table status_code
(
	status_code_id serial not null
		constraint status_pkey
			primary key,
	status varchar not null
)
;

alter table status_code owner to postgres
;

create unique index status_id_uindex
	on status_code (status_code_id)
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
			primary key
		constraint child_fk
			references category
				on delete cascade,
	name varchar not null
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
		constraint customer_person_id_fk
			references person
				on delete cascade
)
;

alter table customer owner to postgres
;

create table address
(
	address_id serial not null
		constraint addresses_pkey
			primary key
		constraint address_customer_customer_id_fk
			references customer
				on delete cascade,
	address varchar not null
)
;

alter table address owner to postgres
;

create unique index addresses_id_uindex
	on address (address_id)
;

create unique index customer_id_uindex
	on customer (customer_id)
;

create table "order"
(
	order_id serial not null
		constraint order_pkey
			primary key
		constraint order_customer_customer_id_fk
			references customer
		constraint order_payment_method_id_fk
			references payment_method
		constraint order_status_code_status_code_id_fk
			references status_code,
	added timestamp not null
)
;

alter table "order" owner to postgres
;

create unique index order_order_id_uindex
	on "order" (order_id)
;

create table product
(
	product_id serial not null
		constraint product_pkey
			primary key
		constraint product_category_category_id_fk
			references category,
	name varchar not null,
	price numeric(10,4) not null,
	quantity integer not null
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
			primary key
		constraint order_item_order_order_id_fk
			references "order"
		constraint order_item_product_product_id_fk
			references product,
	quantity integer not null
)
;

alter table order_item owner to postgres
;

create unique index order_item_order_item_id_uindex
	on order_item (order_item_id)
;

