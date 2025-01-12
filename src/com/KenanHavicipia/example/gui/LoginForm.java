package com.KenanHavicipia.example.gui;

import com.KenanHavicipia.example.database.EmployeeDAO;
import com.KenanHavicipia.example.models.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm {
    public JPanel panel1;
    private JTextField korisnickoIme;
    private JPasswordField lozinkaLabel;
    private JButton PrijaviSe;

    public LoginForm() {
        korisnickoIme.setColumns(15);
        lozinkaLabel.setColumns(15);

        //ActionListener na dugme "Prijavi Se"
        PrijaviSe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String korisnickoImeInput = korisnickoIme.getText();
                char[] lozinkaArray = lozinkaLabel.getPassword();
                String lozinkaInput = new String(lozinkaArray);

                Employee loggedInEmployee = EmployeeDAO.checkLogin(korisnickoImeInput, lozinkaInput);

                if (loggedInEmployee != null) {
                    JOptionPane.showMessageDialog(null, "Uspješno ste se prijavili kao " + loggedInEmployee.getRole() + "!");

                    EmployeeDAO.prijavaNaPosao(loggedInEmployee.getId());

                    if ("Employee".equals(loggedInEmployee.getRole())) {
                        new EmployeeDashboard(loggedInEmployee);
                    } else if ("Manager".equals(loggedInEmployee.getRole())) {
                        new ManagerDashboard(loggedInEmployee);
                    } else if ("SuperAdmin".equals(loggedInEmployee.getRole())) {
                        new AdminDashboard(loggedInEmployee);
                    } else {
                        JOptionPane.showMessageDialog(null, "Pristup nije dozvoljen za ovu ulogu.");
                    }

                    SwingUtilities.getWindowAncestor(panel1).dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Pogrešno korisničko ime ili lozinka.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Prijava");
        frame.setContentPane(new LoginForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}