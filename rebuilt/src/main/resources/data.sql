INSERT INTO family (familyname) VALUES ('Amberboy');
insert into Family (familyname) values('Dezso');
insert into Family (familyname) values('Branczik');
insert into Family (familyname) values('Kertai');

INSERT INTO user (username, password,  role, family_id) VALUES ('benedek', 'benedek', 'ROLE_ADMIN', 1);
INSERT INTO user (username, password,  role, family_id) VALUES ('levente', 'levente', 'ROLE_USER', 1);
INSERT INTO user (username, password,  role, family_id) VALUES ( 'balint', 'balint', 'ROLE_ADMIN', 2);
INSERT INTO user (username, password,  role, family_id) VALUES ( 'irimias', 'irimias', 'ROLE_USER', 2);

INSERT INTO task (title, description, place, status, created_at, modified_at) VALUES ('Mosogatas', 'Megint nem pakoltad ki a mosogatogepet', 'konyha', 'NEW', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
INSERT INTO task (title, description, place, status, created_at, modified_at) VALUES ('Takaritas', 'Nappali porszivozas', 'nappali', 'DOING', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
INSERT INTO task (title, description, place, status, created_at, modified_at) VALUES ('Rendrakas', 'Szobadban rakj rendet minden ruhad a foldon van', 'benedekszoba', 'DONE', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());

INSERT INTO message (body, created_at, task_id) VALUES ('De a levi már megigerte hogy megcsinalja..', CURRENT_TIMESTAMP(), 1);
INSERT INTO message (body, created_at, task_id) VALUES ('De a levi már megigerte hogy megcsinalja..', CURRENT_TIMESTAMP(), 2);
INSERT INTO message (body, created_at, task_id) VALUES ('De a levi már megigerte hogy megcsinalja..', CURRENT_TIMESTAMP(), 3);
INSERT INTO message (body, created_at, task_id) VALUES ('Levi tegnap elköltözött', CURRENT_TIMESTAMP(), 1);

insert into task_users (tasks_id, users_id) values (1, 1);
insert into task_users (tasks_id, users_id) values (2, 3);
insert into task_users (tasks_id, users_id) values (3, 3);
insert into task_users (tasks_id, users_id) values (2, 4);