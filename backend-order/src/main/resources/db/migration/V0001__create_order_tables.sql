DROP SEQUENCE IF EXISTS sq_delivery_transaction_id;

create table i_order_status
(
    id                          int,
    name                        varchar(64),
    constraint pk_order_status primary key (id)
);

insert into i_order_status (id, name)
values (1, 'IN_PROGRESS'),
       (2, 'SHIPPING'),
       (3, 'COMPLETED'),
       (4, 'DENY');


create table if not exists i_order
(
    id                                          varchar(256)         not null,
    order_by                                    varchar(256)         not null,
    order_email                                 varchar(256)         not null,
    order_phone                                 varchar(16)          not null,
    status                                      int                  not null default 1,
    created                                     timestamp   not null default now(),
    constraint pk_order_transaction primary key (id),
    constraint fk_order_status foreign key (status) references i_order_status (id)
);

create table i_order_item_status
(
    id                                          int,
    name                                        varchar(64),
    constraint pk_order_item_status primary key (id)
);

insert into i_order_item_status (id, name)
values (1, 'AVAILABLE'),
       (2, 'OUT_OF_STOCK'),
       (3, 'DENY');

create table if not exists i_order_item
(
    id                                          bigint               GENERATED ALWAYS AS IDENTITY,
    product_id                                  varchar(256)         not null,
    order_transaction_id                        varchar(256)         not null,
    quantity                                    float                not null,
    status                                      int                  not null default 1,
    created                                     timestamp            not null default now(),
    updated                                     timestamp            not null default now(),
    constraint pk_order_item primary key (id)
);

create or replace function trigger_set_timestamp()
    returns trigger as
$trigger_set_timestamp$
begin
    new.created = now();
    return new;
end;
$trigger_set_timestamp$ language plpgsql;

create trigger order_set_timestamp
    before insert
    on i_order
    for each row
execute procedure trigger_set_timestamp();

create trigger order_item_set_timestamp
    before insert
    on i_order_item
    for each row
execute procedure trigger_set_timestamp();
