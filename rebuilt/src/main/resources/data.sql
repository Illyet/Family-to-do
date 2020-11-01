INSERT INTO family (familyname) VALUES ('Amberboy');
INSERT INTO user (name, username, password, role, family_id) VALUES ('Tibor', 'tibor', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', 'ADMIN', 1);
INSERT INTO user (name, username, password, role, family_id) VALUES ('László', 'laszlo', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', 'USER', 1);
INSERT INTO user (name, username, password, role, family_id) VALUES ('Péter', 'peter', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', 'USER', 1);

INSERT INTO task (title, description, place, status, created_at, modified_at, creator_id) VALUES ('Rossz projektor', 'Nem kapcsol be a projektor', 'PC-209', 'NEW', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP(), 1);
INSERT INTO task (title, description, place, status, created_at, modified_at, creator_id) VALUES ('Rossz projektor', 'Nem kapcsol be a projektor', 'PC-209', 'DOING', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP(), 2);
INSERT INTO task (title, description, place, status, created_at, modified_at, creator_id) VALUES ('ZH mód', 'Bekapcsolva maradt a zh mód', 'PC-209', 'DONE', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP(), 1);



INSERT INTO message (body, created_at, task_id, creator_id) VALUES ('De nálam jó', CURRENT_TIMESTAMP(), 1, 1);

-- INSERT INTO label (text) VALUES ('projektor');
-- INSERT INTO label (text) VALUES ('zh mód');
-- INSERT INTO label (text) VALUES ('elromlott hallgatói gép');

-- INSERT INTO issue_labels (issues_id, labels_id) VALUES (1, 1);
-- INSERT INTO issue_labels (issues_id, labels_id) VALUES (1, 3);
-- INSERT INTO issue_labels (issues_id, labels_id) VALUES (3, 2);
