INSERT INTO USERS (username, password, first_name, last_name, enabled, last_password_reset_date) VALUES ('user', '$2a$10$lbE2z83s2ujR3/zakPwuveo/SVQp0w7cyb1wBJ9NeFtP6K7zDD3sK', 'Marko', 'Markovic', true, '2021-01-30 19:59:58.108');
INSERT INTO USERS (username, password, first_name, last_name, enabled, last_password_reset_date) VALUES ('admin', '$2a$10$lbE2z83s2ujR3/zakPwuveo/SVQp0w7cyb1wBJ9NeFtP6K7zDD3sK', 'Nikola', 'Nikolic', true, '2021-01-30 19:59:58.108');

INSERT INTO AUTHORITY (name) VALUES ('ROLE_PATIENT');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_PHARMACIST');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_DERMATOLOGIST');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_PHADMIN');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_SYSADMIN');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_SUPPLIER');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 5);

INSERT INTO pharmacy(address, description, name)VALUES ('Ulica', 'Apoteka1', 'Pharmacy');
INSERT INTO USERS (username, password, first_name, last_name, enabled, last_password_reset_date) VALUES ('phAdmin', '$2a$10$jWhaJbtjUv1b5mSckilU2euzDh8oLYrQ77iEqkw1SMrQY1a3QVZW2', 'Pharmacy', 'Admin', true, '2021-01-30 19:59:58.108');
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (3, 4);
INSERT INTO pharmacy_ph_admins (pharmacy_id, ph_admins_id)VALUES (1, 3);
INSERT INTO medication(name)VALUES ('brufen');
INSERT INTO medication(name)VALUES ('rapidol');
INSERT INTO medication(name)VALUES ('andol');
INSERT INTO medication(name)VALUES ('gentamicin');
