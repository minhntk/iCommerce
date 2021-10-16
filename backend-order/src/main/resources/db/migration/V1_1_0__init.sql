DROP SEQUENCE IF EXISTS sq_store_id;
DROP SEQUENCE IF EXISTS sq_delivery_transaction_id;

create sequence sq_store_id increment by 1 minvalue 1 no maxvalue start with 1 cache 10 no cycle;
create table if not exists store
(
    id                                          bigint               default nextval('sq_store_id'),
    store_name                                  varchar(256)         not null,
    active                                      boolean              default true,
    created                                     timestamp   not null default now(),
    updated                                     timestamp   not null default now(),
    constraint pk_store primary key (id)
);
alter sequence sq_store_id owned by store.id;

create table if not exists order_transaction
(
    id                                          varchar(64)          not null,
    order_by                                    bigint               not null,
    status                                      varchar(16)          not null,
    created                                     timestamp   not null default now(),
    constraint pk_order_transaction primary key (id)
);

create sequence sq_order_transaction_item_id increment by 1 minvalue 1 no maxvalue start with 1 cache 10 no cycle;
create table if not exists order_transaction_item
(
    id                                          bigint               default nextval('sq_order_transaction_item_id'),
    product_id                                  bigint               not null,
    store_id                                    bigint               not null,
    quantity                                    int                  not null,
    transaction_id                              varchar(64)          not null,
    created                                     timestamp   not null default now(),
    constraint pk_delivery_transaction primary key (id)
);
alter sequence sq_order_transaction_item_id owned by order_transaction_item.id;

create or replace function trigger_set_timestamp()
    returns trigger as
$trigger_set_timestamp$
begin
    new.updated = now();
    return new;
end;
$trigger_set_timestamp$ language plpgsql;

create trigger store_set_timestamp
    before update
    on store
    for each row
execute procedure trigger_set_timestamp();
