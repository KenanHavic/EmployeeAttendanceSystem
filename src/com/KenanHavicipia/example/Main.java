package com.KenanHavicipia.example;

import com.KenanHavicipia.example.database.EmployeeDAO;
import com.KenanHavicipia.example.models.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO.addEmployee(new Employee(0, "Amir Hasanović", "Software Engineer", "2024-01-15", "amir.h", "amir123", "Employee"));
        EmployeeDAO.addEmployee(new Employee(0, "Selma Dedić", "HR Manager", "2024-02-20", "selma.d", "selma456", "Employee"));
        EmployeeDAO.addEmployee(new Employee(0, "Nedim Kovačević", "Accountant", "2024-03-10", "nedim.k", "nedim789", "Employee"));
        EmployeeDAO.addEmployee(new Employee(0, "Lejla Hasić", "Marketing Specialist", "2024-04-22", "lejla.h", "lejla101", "Employee"));
        EmployeeDAO.addEmployee(new Employee(0, "Tarik Milić", "Sales Representative", "2024-05-13", "tarik.m", "tarik202", "Employee"));
        EmployeeDAO.addEmployee(new Employee(0, "Azra Alić", "Product Manager", "2024-06-30", "azra.a", "azra303", "Employee"));
        EmployeeDAO.addEmployee(new Employee(0, "Adnan Mujagić", "Graphic Designer", "2024-07-05", "adnan.m", "adnan404", "Employee"));
        EmployeeDAO.addEmployee(new Employee(0, "Amra Begić", "Operations Manager", "2024-08-12", "amra.b", "amra505", "Employee"));
        EmployeeDAO.addEmployee(new Employee(0, "Ibrahim Čengić", "System Administrator", "2024-09-02", "ibrahim.c", "ibrahim606", "Employee"));
        EmployeeDAO.addEmployee(new Employee(0, "Sabina Mešić", "Project Coordinator", "2024-10-25", "sabina.m", "sabina707", "Employee"));
        EmployeeDAO.addEmployee(new Employee(0, "Mirsad Zukić", "Legal Advisor", "2024-11-15", "mirsad.z", "mirsad808", "Employee"));
        EmployeeDAO.addEmployee(new Employee(0, "Amina Mekić", "Public Relations Officer", "2024-12-01", "amina.m", "amina909", "Employee"));
        EmployeeDAO.addEmployee(new Employee(0, "Jasmin Latić", "Financial Analyst", "2024-01-20", "jasmin.l", "jasmin010", "Employee"));
        EmployeeDAO.addEmployee(new Employee(0, "Emina Salkić", "Marketing Director", "2024-02-10", "emina.s", "emina111", "Employee"));
        EmployeeDAO.addEmployee(new Employee(0, "Faruk Karamustafić", "Data Scientist", "2024-03-30", "faruk.k", "faruk212", "Employee"));
        EmployeeDAO.addEmployee(new Employee(0, "Maja Salihović", "UX/UI Designer", "2024-04-15", "maja.s", "maja313", "Employee"));
        EmployeeDAO.addEmployee(new Employee(0, "Haris Bešić", "Software Architect", "2024-05-05", "haris.b", "haris414", "Employee"));
        EmployeeDAO.addEmployee(new Employee(0, "Dženita Kalac", "HR Assistant", "2024-06-01", "dzenita.k", "dzenita515", "Employee"));
        EmployeeDAO.addEmployee(new Employee(0, "Muhamed Omerović", "Business Development Manager", "2024-07-25", "muhamed.o", "muhamed616", "Employee"));
        EmployeeDAO.addEmployee(new Employee(0, "Elma Salkić", "Senior Developer", "2024-08-10", "elma.s", "elma717", "Employee"));

        EmployeeDAO.addEmployee(new Employee(0, "Kenan Havic", "Manager", "2024-01-01", "kenan.h", "kenan202", "Manager"));
        EmployeeDAO.addEmployee(new Employee(0, "Admin", "SuperAdmin", "2024-01-01", "admin", "admin123", "SuperAdmin"));

        List<Employee> zaposleni = EmployeeDAO.getAllEmployees();
        for (Employee zaposleniOsoba : zaposleni) {
            System.out.println("ID: " + zaposleniOsoba.getId() +
                    ", Ime: " + zaposleniOsoba.getIme() +
                    ", Pozicija: " + zaposleniOsoba.getPozicija() +
                    ", Datum zaposlenja: " + zaposleniOsoba.getDatumZaposlenja() +
                    ", Korisničko ime: " + zaposleniOsoba.getKorisnickoIme() +
                    ", Lozinka: " + zaposleniOsoba.getLozinka() +
                    ", Uloga: " + zaposleniOsoba.getRole());
        }
    }
}
