CREATE DATABASE EmployeeAttendance;
USE EmployeeAttendance;

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ime VARCHAR(255) NOT NULL,
    pozicija VARCHAR(255) NOT NULL,
    datum_zaposlenja DATE NOT NULL,
    korisnicko_ime VARCHAR(255) NOT NULL UNIQUE,
    lozinka VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL DEFAULT 'User',
    prijava_vrijeme TIMESTAMP NULL DEFAULT NULL,
    odjava_vrijeme TIMESTAMP NULL DEFAULT NULL
);

INSERT INTO employees (ime, pozicija, datum_zaposlenja, korisnicko_ime, lozinka, role) VALUES
('Amir Hasanović', 'Software Engineer', '2024-01-15', 'amir.h', 'amir123', 'Employee'),
('Selma Dedić', 'HR Manager', '2024-02-20', 'selma.d', 'selma456', 'Employee'),
('Nedim Kovačević', 'Accountant', '2024-03-10', 'nedim.k', 'nedim789', 'Employee'),
('Lejla Hasić', 'Marketing Specialist', '2024-04-22', 'lejla.h', 'lejla101', 'Employee'),
('Tarik Milić', 'Sales Representative', '2024-05-13', 'tarik.m', 'tarik202', 'Employee'),
('Azra Alić', 'Product Manager', '2024-06-30', 'azra.a', 'azra303', 'Employee'),
('Adnan Mujagić', 'Graphic Designer', '2024-07-05', 'adnan.m', 'adnan404', 'Employee'),
('Amra Begić', 'Operations Manager', '2024-08-12', 'amra.b', 'amra505', 'Employee'),
('Ibrahim Čengić', 'System Administrator', '2024-09-02', 'ibrahim.c', 'ibrahim606', 'Employee'),
('Sabina Mešić', 'Project Coordinator', '2024-10-25', 'sabina.m', 'sabina707', 'Employee'),
('Mirsad Zukić', 'Legal Advisor', '2024-11-15', 'mirsad.z', 'mirsad808', 'Employee'),
('Amina Mekić', 'Public Relations Officer', '2024-12-01', 'amina.m', 'amina909', 'Employee'),
('Jasmin Latić', 'Financial Analyst', '2024-01-20', 'jasmin.l', 'jasmin010', 'Employee'),
('Emina Salkić', 'Marketing Director', '2024-02-10', 'emina.s', 'emina111', 'Employee'),
('Faruk Karamustafić', 'Data Scientist', '2024-03-30', 'faruk.k', 'faruk212', 'Employee'),
('Maja Salihović', 'UX/UI Designer', '2024-04-15', 'maja.s', 'maja313', 'Employee'),
('Haris Bešić', 'Software Architect', '2024-05-05', 'haris.b', 'haris414', 'Employee'),
('Dženita Kalac', 'HR Assistant', '2024-06-01', 'dzenita.k', 'dzenita515', 'Employee'),
('Muhamed Omerović', 'Business Development Manager', '2024-07-25', 'muhamed.o', 'muhamed616', 'Employee'),
('Elma Salkić', 'Senior Developer', '2024-08-10', 'elma.s', 'elma717', 'Employee'),

('Kenan Havic', 'Manager', '2024-01-01', 'kenan.h', 'kenan202', 'Manager'),
('Admin', 'SuperAdmin', '2024-01-01', 'admin', 'admin123', 'SuperAdmin');




SELECT * FROM employees;
SELECT * FROM employees;
SELECT id, korisnicko_ime, role FROM employees;


DESCRIBE employees;



