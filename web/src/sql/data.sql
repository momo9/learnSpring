insert into
authors (name)
values
('Chenchi Liang'),
('Mona'),
('momo9');

insert into
articles (title, authorId)
values
('vector', 1),
('vim', 1),
('makeup', 2),
('final', 3),
('champion', 3);

insert into
tags (tag)
values
('c++'),
('technology'),
('makeup'),
('arsenal'),
('UEFA');

insert into
articleTagMaps (articleId, tagId)
values
(1, 1),
(1, 2),
(2, 2),
(3, 3),
(4, 4),
(5, 4),
(5, 5);
