create table categories
(
    id integer primary key auto_increment,
    description varchar(100) not null
);
create table products
(
    id integer primary key auto_increment,
    price       float         not null,
    description varchar(100)    not null,
    category_id int             not null,
    foreign key (category_id) references categories(id)
);
