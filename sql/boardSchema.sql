drop table if exists board CASCADE;
create table board
(
    id        bigint generated by default as identity,
    user_id integer,
    user_name varchar,
    title varchar,
    category varchar,
    created_time timestamp,
    content    varchar,
    attachment_file varchar,
    popup     varchar,
    read_count integer,
    like_count integer,
    page_number  integer,

    primary key (id)
);
