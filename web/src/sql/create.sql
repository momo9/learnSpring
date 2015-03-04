drop table if exists articles;
create table articles (
    id int unsigned not null auto_increment,
    title char(64) not null,
    authorId int unsigned not null,
    primary key (id)
);

drop table if exists authors;
create table authors (
    id int unsigned not null auto_increment,
    name char(32) not null,
    primary key (id)
);

drop table if exists tags;
create table tags (
    id int unsigned not null auto_increment,
    tag char(64) not null,
    primary key (id)
);

drop table if exists articleTagMaps;
create table articleTagMaps (
    id int unsigned not null auto_increment,
    articleId int unsigned not null,
    tagId int unsigned not null,
    primary key (id)
);
