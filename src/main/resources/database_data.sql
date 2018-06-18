SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

INSERT INTO employee (id, modification_time, modified_by, active, deleted, email, first_name, last_name, password, username, department, picture) VALUES (1, '2018-01-12 14:59:22.723882', 'tomek', 'T', 'F', 'tomislav.hlevnjak@tbp.hr', 'Tomislav', 'Hlevnjak', '$2a$10$QIQgOVsr9cjXvEaROFSOk.QLiJpzEEnoFcNhXIyH/K9ZX772szgY6', 'tomek', 'tbp', NULL);

INSERT INTO id_gen (gen_key, gen_value) VALUES ('ITEM_ID', 18);

INSERT INTO permission (id, modification_time, modified_by, code, description, name) VALUES (13, '2018-01-12 14:59:22.723882', 'tomek', 'VIEW_DOC', NULL, 'Pregled dokumenata');
INSERT INTO permission (id, modification_time, modified_by, code, description, name) VALUES (12, '2018-01-12 14:59:22.723882', 'tomek', 'EDIT_DOC', NULL, 'Mijenjanje dokumenata');
INSERT INTO permission (id, modification_time, modified_by, code, description, name) VALUES (11, '2018-01-12 14:59:22.723882', 'tomek', 'REMOVE_DOC', NULL, 'Brisanje dokumenata');
INSERT INTO permission (id, modification_time, modified_by, code, description, name) VALUES (10, '2018-01-12 14:59:22.723882', 'tomek', 'ADD_DOC', NULL, 'Dodavanje dokumenata');
INSERT INTO permission (id, modification_time, modified_by, code, description, name) VALUES (9, '2018-01-12 14:59:22.723882', 'tomek', 'VIEW_CUSTOMER', NULL, 'Pregled korisnika');
INSERT INTO permission (id, modification_time, modified_by, code, description, name) VALUES (8, '2018-01-12 14:59:22.723882', 'tomek', 'EDIT_CUSTOMER', NULL, 'Mijenjanje korisnika');
INSERT INTO permission (id, modification_time, modified_by, code, description, name) VALUES (7, '2018-01-12 14:59:22.723882', 'tomek', 'REMOVE_CUSTOMER', NULL, 'Brisanje korisnika');
INSERT INTO permission (id, modification_time, modified_by, code, description, name) VALUES (6, '2018-01-12 14:59:22.723882', 'tomek', 'ADD_CUSTOM', NULL, 'Dodavanje korisnika');
