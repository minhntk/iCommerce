-- Extension for creating uuid
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


create table if not exists i_category
(
    id                                          bigint               GENERATED ALWAYS AS IDENTITY,
    name                                        varchar(256)         not null,
    parent_id                                   bigint               default null,
    active                                      boolean              default true,
    created                                     timestamp   not null default now(),
    updated                                     timestamp   not null default now(),
    constraint pk_i_category primary key (id)
);
insert into i_category (name, parent_id)
values ('Book', null),
       ('Baby & Toddler Toys', null),
       ('Beauty & Personal Care', null),
       ('Fiction', 1),
       ('Skin Care', 3),
       ('Oral Care', 3);

create table if not exists i_product
(
    id                                          UUID                 not null DEFAULT uuid_generate_v1(),
    name                                        varchar(256)         not null,
    category_id                                 bigint               not null,
    store_id                                    bigint               not null,
    description                                 text                 not null,
    active                                      boolean              default true,
    created                                     timestamp   not null default now(),
    updated                                     timestamp   not null default now(),
    constraint pk_i_product primary key (id)
);

insert into i_product (id, name, category_id, store_id, description)
values ('a17febf5-f307-4b85-a3c4-ba85a098b72d', 'Spring in action', 1, 1, 'Spring books for Java developers'),
       ('4957c4f0-930f-4629-a932-43157255d610', 'Marvel Rise of the Domo', 2, 3, 'Lego bricks'),
       ('ba67f53d-f6a6-48e3-998c-742cbc4dfa7f', 'Bio-Oil Skincare Oil', 5, 4, 'Give your skin a break while stuck inside!');

create table if not exists i_store
(
    id                                          bigint               GENERATED ALWAYS AS IDENTITY,
    name                                        varchar(256)         not null,
    description                                 text                 not null,
    owner                                       varchar(256)         not null,
    active                                      boolean              default true,
    created                                     timestamp   not null default now(),
    updated                                     timestamp   not null default now(),
    constraint pk_i_store primary key (id)
);

insert into i_store (name, description, owner)
values ('Alpha Book Store', 'Book Store Description', 'a827306b-68d6-4bab-824e-8ddbb05927c2'),
       ('Flower Store', 'Flower Store Description', '8a6e45b0-13b8-4a73-af47-1b698d841f31'),
       ('XYZ Grocery', 'XYZ Grocery description', '92cc539a-5a71-4aa2-9a18-2ac55e176fa5'),
       ('Bio-Oil Store', 'Bio-Oil Store description', 'ce4d0a43-0b3e-472d-ae0e-1aea52e6d325');


create table if not exists i_product_price
(
    id                                           bigint               GENERATED ALWAYS AS IDENTITY,
    product_id                                   uuid                 not null,
    price                                        numeric              not null,
    active                                       boolean              default true,
    created                                      timestamp   not null default now(),
    constraint pk_i_product_price primary key (id)
);
insert into i_product_price (product_id, price)
values ('a17febf5-f307-4b85-a3c4-ba85a098b72d', 15.8),
       ('4957c4f0-930f-4629-a932-43157255d610', 255),
       ('ba67f53d-f6a6-48e3-998c-742cbc4dfa7f', 18.7);

create table if not exists i_product_description
(
    id                                           bigint               GENERATED ALWAYS AS IDENTITY,
    product_id                                   uuid                 not null,
    color                                        varchar(32)          not null,
    image                                        varchar(256)         ,
    active                                       boolean              default true,
    created                                      timestamp            not null default now(),
    constraint pk_i_product_description primary key (id)
);

insert into i_product_description (product_id, color, image)
values ('a17febf5-f307-4b85-a3c4-ba85a098b72d', 'red', null),
       ('a17febf5-f307-4b85-a3c4-ba85a098b72d', 'blue', null),
       ('4957c4f0-930f-4629-a932-43157255d610', 'orange', null),
       ('ba67f53d-f6a6-48e3-998c-742cbc4dfa7f', 'green', null);

create or replace function trigger_set_timestamp()
    returns trigger as
$trigger_set_timestamp$
begin
    new.created = now();
    return new;
end;
$trigger_set_timestamp$ language plpgsql;

create trigger product_set_timestamp
    before insert
    on i_product
    for each row
execute procedure trigger_set_timestamp();

create trigger category_set_timestamp
    before insert
    on i_category
    for each row
execute procedure trigger_set_timestamp();
