-- Extension for creating uuid
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP SEQUENCE IF EXISTS sq_category_id;

create sequence sq_category_id increment by 1 minvalue 1 no maxvalue start with 1 cache 10 no cycle;
create table if not exists i_category
(
    id                                          bigint               default nextval('sq_category_id'),
    name                                        varchar(256)         not null,
    parent_id                                   bigint               default null,
    active                                      boolean              default true,
    created                                     timestamp   not null default now(),
    updated                                     timestamp   not null default now(),
    constraint pk_i_category primary key (id)
);
alter sequence sq_category_id owned by i_category.id;

create table if not exists i_product
(
    id                                          varchar(256)         not null,
    name                                        varchar(256)         not null,
    category_id                                 bigint               not null,
    store_id                                    bigint               not null,
    active                                      boolean              default true,
    created                                     timestamp   not null default now(),
    updated                                     timestamp   not null default now(),
    constraint pk_i_product primary key (id)
);

DROP SEQUENCE IF EXISTS sq_product_price_id;
create sequence sq_product_price_id increment by 1 minvalue 1 no maxvalue start with 1 cache 10 no cycle;
create table if not exists i_product_price
(
    id                                           bigint               default nextval('sq_product_price_id'),
    product_id                                   varchar(256)         not null,
    price                                        float                not null,
    active                                       boolean              default true,
    created                                      timestamp   not null default now(),
    constraint pk_i_product_price primary key (id)
);
alter sequence sq_product_price_id owned by i_product_price.id;

DROP SEQUENCE IF EXISTS sq_product_description_id;
create sequence sq_product_description_id increment by 1 minvalue 1 no maxvalue start with 1 cache 10 no cycle;
create table if not exists i_product_description
(
    id                                           bigint               default nextval('sq_product_description_id'),
    product_id                                   varchar(256)         not null,
    color                                        float                not null,
    image                                        float                not null,
    active                                       boolean              default true,
    created                                      timestamp   not null default now(),
    constraint pk_i_product_description primary key (id)
);
alter sequence sq_product_description_id owned by i_product_description.id;

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
