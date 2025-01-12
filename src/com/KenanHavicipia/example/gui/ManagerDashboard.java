package com.KenanHavicipia.example.gui;

import com.KenanHavicipia.example.database.EmployeeDAO;
import com.KenanHavicipia.example.models.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ManagerDashboard extends JFrame {
    private JButton pregledZaposlenih;
    private JPanel panel1;
    private JList<String> list1;
    private JButton odjaviSe;

    private boolean isZaposleniPrikazani = false;

    public ManagerDashboard(Employee manager) {

        setTitle("Manager Dashboard");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        pregledZaposlenih.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isZaposleniPrikazani) {

                    panel1.remove(list1);
                    panel1.add(pregledZaposlenih);
                    panel1.add(odjaviSe);

                    panel1.revalidate();
                    panel1.repaint();

                    isZaposleniPrikazani = false;
                } else {
                    List<Employee> zaposlenici = EmployeeDAO.getAllEmployees();

                    DefaultListModel<String> listModel = new DefaultListModel<>();
                    for (Employee emp : zaposlenici) {
                        listModel.addElement(emp.getIme() + " - " + emp.getPozicija());
                    }

                    list1.setModel(listModel);

                    panel1.remove(pregledZaposlenih);
                    panel1.add(list1);
                    panel1.add(odjaviSe);

                    panel1.revalidate();
                    panel1.repaint();

                    isZaposleniPrikazani = true;
                }
            }
        });

        odjaviSe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                JFrame loginFrame = new JFrame("Login");
                loginFrame.setContentPane(new LoginForm().panel1);
                loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginFrame.pack();
                loginFrame.setVisible(true);
            }
        });

        if (manager != null) {
            System.out.println("Ulogovan menadžer: " + manager.getIme() + " (" + manager.getPozicija() + ")");
        } else {
            System.out.println("Greška: Menadžer nije pronađen.");
        }

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        String korisnickoIme = "menadzerKorisnik";
        Employee manager = EmployeeDAO.getManagerByUsername(korisnickoIme);

        if (manager != null) {
            new ManagerDashboard(manager);
        } else {
            System.out.println("Greška: Menadžer nije pronađen sa korisničkim imenom: " + korisnickoIme);
        }
    }
}
