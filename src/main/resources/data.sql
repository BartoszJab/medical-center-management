INSERT INTO ROLE (id, role_type)
VALUES
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_EMPLOYEE'),
    (3, 'ROLE_PATIENT');

INSERT INTO USER (id, username, password)
VALUES
    (1, 'admin', '$2a$10$RcZQfMXg9c0XNMlj4hyBXOpooF3n2Uq9U6YtfHvSjFYwwK1OJ5uWm'),
    (2, 'employee', '$2a$10$Qesp0essR4/i1Fyx1Moz..s0SrJtw00eI0NI7cq8m744vIx4Ugkl.'),
    (3, 'patient', '$2a$10$LP3Bvwr/7f8GO7PSXgaeE.Wl7QqORrhLXmqpd3SWkdPJVtz/SbboK');

INSERT INTO USER_ROLE (role_id, user_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

INSERT INTO CONTACT_DETAILS (id, address, email, phone_number)
VALUES
    (1, 'Wasilkowa 8, 11-111', 'jj.ww@gmail.com', '111222333'),
    (2, 'Chicago 10', 'test@test.com', '333222111');

INSERT INTO PATIENT (id, first_name, last_name, date_of_birth, gender, contact_details_id, user_id)
VALUES
    (1, 'Jan', 'Kowalski', '1985-01-12', 'MALE', NULL, NULL),
    (2, 'Kasia', 'Kowalska', '1999-04-14', 'FEMALE', 1, 2),
    (3, 'Robert', 'Kowalski', '2000-05-20', 'MALE', 2, NULL);

INSERT INTO RESEARCH_PROJECT (id, title, description)
VALUES
    (1, 'Grypa Maxima', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    (2, 'Covid Delta XX', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    (3, 'ZZZZZZZ', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');

INSERT INTO AGREEMENT (patient_id, project_id)
VALUES
    (2, 1),
    (3, 3);

INSERT INTO LABORATORY_TEST_ORDER (id, research_date, patient_id, project_id)
VALUES
    (1, '2020-01-12T14:30:00', 2, 1),
    (2, '2021-01-24T11:30:00', 3, 3);

INSERT INTO TEST_RESULT (test_type, result_description, order_id)
VALUES
    ('Test type1', 'Description 1', 1),
    ('Test type2', 'Description 2', 2);