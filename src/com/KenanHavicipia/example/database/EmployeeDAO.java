package com.KenanHavicipia.example.database;

import com.KenanHavicipia.example.models.Employee;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // Metoda za unos novog zaposlenog sa ulogom
    public static void addEmployee(Employee employee) {
        String query = "INSERT INTO employees (ime, pozicija, datum_zaposlenja, korisnicko_ime, lozinka, role) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, employee.getIme());
            statement.setString(2, employee.getPozicija());
            statement.setString(3, employee.getDatumZaposlenja());
            statement.setString(4, employee.getKorisnickoIme());
            statement.setString(5, employee.getLozinka());
            statement.setString(6, employee.getRole());

            statement.executeUpdate();
            System.out.println("Zaposleni je uspešno dodat!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metoda za dobijanje svih zaposlenih
    public static List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";

        try (Connection connection = DatabaseConnection.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String ime = resultSet.getString("ime");
                String pozicija = resultSet.getString("pozicija");
                String datumZaposlenja = resultSet.getString("datum_zaposlenja");
                String korisnickoIme = resultSet.getString("korisnicko_ime");
                String lozinka = resultSet.getString("lozinka");
                String role = resultSet.getString("role");

                Employee employee = new Employee(id, ime, pozicija, datumZaposlenja, korisnickoIme, lozinka, role);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static boolean urediZaposlenogPoID(int id, String ime, String pozicija, String datumZaposlenja, String lozinka, String uloga) {
        String query = "UPDATE employees SET ime = ?, pozicija = ?, datum_zaposlenja = ?, lozinka = ?, role = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Postavi parametre u SQL upitu
            statement.setString(1, ime);
            statement.setString(2, pozicija);
            statement.setString(3, datumZaposlenja);
            statement.setString(4, lozinka);
            statement.setString(5, uloga);
            statement.setInt(6, id);

            int rowsAffected = statement.executeUpdate();

            // Vraćam true ako je bar jedan red ažuriran
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    // Metoda za dobijanje historije prijava i odjava zaposlenih
    public static List<String> getHistorijaPrijava() {
        List<String> istorijaPrijava = new ArrayList<>();
        String query = "SELECT ime, pozicija, prijava_vrijeme, odjava_vrijeme " +
                "FROM employees " +
                "WHERE prijava_vrijeme IS NOT NULL " +
                "ORDER BY prijava_vrijeme DESC";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String ime = resultSet.getString("ime");
                String pozicija = resultSet.getString("pozicija");
                Timestamp prijavaVrijeme = resultSet.getTimestamp("prijava_vrijeme");
                Timestamp odjavaVrijeme = resultSet.getTimestamp("odjava_vrijeme");

                String zapis = "Ime: " + ime + ", Pozicija: " + pozicija +
                        ", Prijava: " + (prijavaVrijeme != null ? prijavaVrijeme.toString() : "N/A") +
                        ", Odjava: " + (odjavaVrijeme != null ? odjavaVrijeme.toString() : "N/A");
                istorijaPrijava.add(zapis);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return istorijaPrijava;
    }


    // Metoda za dobijanje admina prema korisničkom imenu
    public static Employee getAdminByUsername(String korisnickoIme) {
        String query = "SELECT * FROM employees WHERE korisnicko_ime = ? AND role = 'Admin'";
        Employee admin = null;

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, korisnickoIme);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String ime = resultSet.getString("ime");
                String pozicija = resultSet.getString("pozicija");
                String datumZaposlenja = resultSet.getString("datum_zaposlenja");
                String lozinka = resultSet.getString("lozinka");
                String role = resultSet.getString("role");

                admin = new Employee(id, ime, pozicija, datumZaposlenja, korisnickoIme, lozinka, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }

    // Metoda za provjeru logina (korisničko ime i lozinka)
    public static Employee checkLogin(String korisnickoIme, String lozinka) {
        String query = "SELECT * FROM employees WHERE korisnicko_ime = ? AND lozinka = ?";
        Employee employee = null;

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, korisnickoIme);
            statement.setString(2, lozinka);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String ime = resultSet.getString("ime");
                String pozicija = resultSet.getString("pozicija");
                String datumZaposlenja = resultSet.getString("datum_zaposlenja");
                String role = resultSet.getString("role");

                employee = new Employee(id, ime, pozicija, datumZaposlenja, korisnickoIme, lozinka, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }

    // Metoda za prijavu na posao
    public static void prijavaNaPosao(int employeeId) {
        String query = "UPDATE employees SET prijava_vrijeme = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            statement.setInt(2, employeeId);

            statement.executeUpdate();
            System.out.println("Zaposleni je uspješno prijavljen na posao!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metoda za dobijanje vremena prijave zaposlenog
    public static String getVrijemePrijave(int employeeId) {
        String query = "SELECT prijava_vrijeme FROM employees WHERE id = ?";
        Timestamp prijavaVrijeme = null;
        String vrijemePrijave = null;

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, employeeId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                prijavaVrijeme = resultSet.getTimestamp("prijava_vrijeme");
                // Formatiranje Timestamp u String
                if (prijavaVrijeme != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    vrijemePrijave = sdf.format(prijavaVrijeme);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vrijemePrijave;
    }

    // Metoda za brisanje zaposlenog prema ID-u
    public static void obrisiZaposlenogPoID(int id) {
        String query = "DELETE FROM employees WHERE id = ?";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id); // Postavi ID kao parametar
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Zaposleni je uspješno obrisan!");
            } else {
                System.out.println("Zaposleni sa ID " + id + " nije pronađen.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Employee getEmployeeByKorisnickoIme(String korisnickoIme) {
        List<Employee> zaposleni = getAllEmployees();

        for (Employee emp : zaposleni) {
            if (emp.getKorisnickoIme().equals(korisnickoIme)) {
                return emp; //Ako je pronađen zaposleni
            }
        }
        return null;
    }

    public static Employee getAdmin() {
        return new Employee(1, "Admin", "Administrator", "2025-01-01", "admin", "admin123", "admin");
    }

    // Metoda za odjavu sa posla
    public static void odjavaSaPosla(int employeeId) {
        String query = "UPDATE employees SET odjava_vrijeme = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            statement.setInt(2, employeeId);

            statement.executeUpdate();
            System.out.println("Zaposleni je uspješno odjavljen sa posla!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Metoda za dobijanje menadžera prema korisničkom imenu
    public static Employee getManagerByUsername(String korisnickoIme) {
        String query = "SELECT * FROM employees WHERE korisnicko_ime = ? AND role = 'Manager'";
        Employee manager = null;

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, korisnickoIme);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String ime = resultSet.getString("ime");
                String pozicija = resultSet.getString("pozicija");
                String datumZaposlenja = resultSet.getString("datum_zaposlenja");
                String lozinka = resultSet.getString("lozinka");
                String role = resultSet.getString("role");

                manager = new Employee(id, ime, pozicija, datumZaposlenja, korisnickoIme, lozinka, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return manager;
    }


    // Metoda za dobijanje vremena odjave zaposlenog
    public static String getVrijemeOdjave(int employeeId) {
        String query = "SELECT odjava_vrijeme FROM employees WHERE id = ?";
        Timestamp odjavaVrijeme = null;
        String vrijemeOdjave = null;

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, employeeId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                odjavaVrijeme = resultSet.getTimestamp("odjava_vrijeme");
                // Formatiranje Timestamp u String
                if (odjavaVrijeme != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    vrijemeOdjave = sdf.format(odjavaVrijeme);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vrijemeOdjave;
    }
}
