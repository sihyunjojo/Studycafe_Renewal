drop table if exists board CASCADE;
create table board
(
    id        bigint generated by default as identity,
    user_id varchar,
    user_name varchar,
    title varchar,
    kind     varchar,
    created_date timestamp,
    content    varchar,
    attachment_file varchar,
    popup     varchar,
    read_count integer,
    page_number  integer,

    primary key (id)
);
