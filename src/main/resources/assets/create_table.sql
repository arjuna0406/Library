create table author
(
    id            bigserial not null
        constraint author_pkey
            primary key,
    description   varchar(500),
    created_by    varchar(100),
    created_date  timestamp,
    modified_by   varchar(100),
    modified_date timestamp,
    deleted       boolean,
    version       integer,
    address       varchar(50),
    gender        varchar(1),
    name          varchar(25)
);

alter table author
    owner to postgres;

