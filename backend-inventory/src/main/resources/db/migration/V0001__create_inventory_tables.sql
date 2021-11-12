-- Extension for creating uuid
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


create table if not exists i_inventory
(
    id                                          bigint               GENERATED ALWAYS AS IDENTITY,
    name                                        varchar(256)         not null,
    parent_id                                   bigint               default null,
    active                                      boolean              default true,
    created                                     timestamp   not null default now(),
    updated                                     timestamp   not null default now(),
    constraint pk_i_category primary key (id)
);


create or replace function trigger_set_timestamp()
    returns trigger as
$trigger_set_timestamp$
begin
    new.created = now();
    return new;
end;
$trigger_set_timestamp$ language plpgsql;

create trigger inventory_set_timestamp
    before insert
    on i_inventory
    for each row
execute procedure trigger_set_timestamp();


