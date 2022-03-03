create table if not exists customers (
    id serial not null primary key,
    first_name varchar(250) not null,
    last_name varchar(250) not null,
    pesel varchar(250) not null );

create table if not exists credits (
    credit_id serial not null primary key,
    credit_name varchar(250) not null,
    value double precision,
    customer_id serial not null,
    constraint fk_customer_id foreign key (customer_id) references customers(id) );
