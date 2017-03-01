CREATE SCHEMA test;

SET SCHEMA 'test';

CREATE TABLE refs (
    user_id integer NOT NULL,
    manager_id integer NOT NULL
);

CREATE TABLE users (
    user_id integer NOT NULL,
    name character varying NOT NULL,
    address character varying
);

ALTER TABLE test.users
  ADD CONSTRAINT pk_users PRIMARY KEY(user_id);

ALTER TABLE test.refs
  ADD CONSTRAINT refs_pk PRIMARY KEY(user_id, manager_id);

ALTER TABLE test.refs
  ADD CONSTRAINT fk0_refs FOREIGN KEY (user_id)
      REFERENCES test.users (user_id);

ALTER TABLE test.refs
  ADD CONSTRAINT fk1_refs FOREIGN KEY (manager_id)
      REFERENCES test.users (user_id);

INSERT INTO users (user_id, name) VALUES (1, 'Tatiana', 'Grodno');
INSERT INTO users (user_id, name) VALUES (2, 'Inna', 'Minsk');
INSERT INTO users (user_id, name) VALUES (3, 'Aleksandr', 'Mogilev');
INSERT INTO users (user_id, name) VALUES (4, 'Igor', 'Vitebsk');
INSERT INTO users (user_id, name) VALUES (5, '5 User!', 'Gomel');

INSERT INTO refs (user_id, manager_id) VALUES (1, 4);
INSERT INTO refs (user_id, manager_id) VALUES (2, 1);
INSERT INTO refs (user_id, manager_id) VALUES (2, 4);
INSERT INTO refs (user_id, manager_id) VALUES (3, 1);
INSERT INTO refs (user_id, manager_id) VALUES (3, 4);
INSERT INTO refs (user_id, manager_id) VALUES (4, 4);
INSERT INTO refs (user_id, manager_id) VALUES (5, 4);
