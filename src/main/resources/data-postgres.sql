INSERT INTO public.users(
	id, address, city, country, enabled, firstname, lastname, lastpasswordresetdate, password, phone, role, username)
	VALUES (14, '', '', '', true, '', '', '2021-01-30 19:59:58.108', '$2a$10$lbE2z83s2ujR3/zakPwuveo/SVQp0w7cyb1wBJ9NeFtP6K7zDD3sK', '', 'PATIENT', 'user');

INSERT INTO public.users(
	id, address, city, country, enabled, firstname, lastname, lastpasswordresetdate, password, phone, role, username)
	VALUES (15, '', '', '', true, 'pera', 'peric', '2021-01-30 19:59:58.108', '$2a$10$lbE2z83s2ujR3/zakPwuveo/SVQp0w7cyb1wBJ9NeFtP6K7zDD3sK', '', 'DERMATOLOGIST', 'dermatologist2');

INSERT INTO public.users(
	id, address, city, country, enabled, firstname, lastname, lastpasswordresetdate, password, phone, role, username)
	VALUES (16, '', '', '', true, 'jova', 'jovic', '2021-01-30 19:59:58.108', '$2a$10$lbE2z83s2ujR3/zakPwuveo/SVQp0w7cyb1wBJ9NeFtP6K7zDD3sK', '', 'DERMATOLOGIST', 'dermatologist1');

	
INSERT INTO public.appointmentdermatology(
	id, dates, dermatologistid, duration, patientid, price, times, dermatologist)
	VALUES (2, '2021-01-30 19:59:58.108', 'dermatologist1', 30, 'user', 30, '7:30', null);
	
INSERT INTO public.appointmentdermatology(
	id, dates, dermatologistid, duration, patientid, price, times, dermatologist)
	VALUES (3, '2023-01-30 19:59:58.108', 'dermatologist2', 30, 'user', 30, '7:30', null);
	
INSERT INTO public.appointmentdermatology(
	id, dates, dermatologistid, duration, patientid, price, times, dermatologist)
	VALUES (4, '2023-01-30 19:59:58.108', 'dermatologist1', 30, '', 30, '7:30', null);












INSERT INTO USERS (username, password, first_name, last_name, enabled, last_password_reset_date) VALUES ('user', '$2a$10$lbE2z83s2ujR3/zakPwuveo/SVQp0w7cyb1wBJ9NeFtP6K7zDD3sK', 'Marko', 'Markovic2', true, '2021-01-30 19:59:58.108');
INSERT INTO USERS (username, password, first_name, last_name, enabled, last_password_reset_date) VALUES ('admin', '$2a$10$lbE2z83s2ujR3/zakPwuveo/SVQp0w7cyb1wBJ9NeFtP6K7zDD3sK', 'Nikola', 'Nikolic', true, '2021-01-30 19:59:58.108');
INSERT INTO appointmentdermatology(
	id, dates, dermatologistid, duration, patientid, price, times)
	VALUES (2, '2022-01-30 19:59:58.108', 1, 30, 'user', 30, '7:30');
	
INSERT INTO appointmentdermatology(
	id, dates, dermatologistid, duration, patientid, price, times)
	VALUES (3, '2022-01-30 19:59:58.108', 1, 30, 'user', 30, '7:30');

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
