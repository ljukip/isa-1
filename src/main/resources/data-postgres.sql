INSERT INTO USERS (username, password, first_name, last_name, enabled, last_password_reset_date) VALUES ('user', '$2a$10$lbE2z83s2ujR3/zakPwuveo/SVQp0w7cyb1wBJ9NeFtP6K7zDD3sK', 'Marko', 'Markovic', true, '2021-01-30 19:59:58.108');
INSERT INTO USERS (username, password, first_name, last_name, enabled, last_password_reset_date) VALUES ('admin', '$2a$10$lbE2z83s2ujR3/zakPwuveo/SVQp0w7cyb1wBJ9NeFtP6K7zDD3sK', 'Nikola', 'Nikolic', true, '2021-01-30 19:59:58.108');

--INSERT INTO AUTHORITY (name) VALUES ('ROLE_USER');
--INSERT INTO AUTHORITY (name) VALUES ('ROLE_ADMIN');

--INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
--INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 1);
--INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 2);

INSERT INTO AUTHORITY (name) VALUES ('ROLE_PATIENT');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_PHARMACIST');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_DERMATOLOGIST');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_PHADMIN');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_SYSADMIN');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_SUPPLIER');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 5);
