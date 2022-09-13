create sequence bm_id_seq start 1 increment 50;

create table bookmark (
    id bigint default nextval('bm_id_seq') not null,
    created_at timestamp,
    title varchar(255) not null,
    url varchar(255) not null,
    primary key (id)
);