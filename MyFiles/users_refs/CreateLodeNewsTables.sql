CREATE SCHEMA lodegro;

SET SCHEMA 'lodegro';

DROP TABLE IF EXISTS news CASCADE;

CREATE TABLE news (
    news_id serial NOT NULL,
    title varchar(256) NOT NULL,
    text text NOT NULL
);

ALTER TABLE lodegro.news
  ADD CONSTRAINT news_pk PRIMARY KEY(news_id);

INSERT INTO news (news_id, title, text) VALUES (1, 'First news', 'This is a 1 news');
INSERT INTO news (news_id, title, text) VALUES (2, '2 news', 'This is a 2 news');
INSERT INTO news (news_id, title, text) VALUES (3, '3 news', 'This is a 3 news');
INSERT INTO news (news_id, title, text) VALUES (4, '4 news', 'This is a 4 news');
INSERT INTO news (news_id, title, text) VALUES (5, '5 news', 'This is a 5 news');
