package com.KenanHavicipia.example.gui;

import com.KenanHavicipia.example.database.EmployeeDAO;
import com.KenanHavicipia.example.models.Employee;

import javax.swing.*;

public class EmployeeDashboard extends JFrame {
    private JPanel panel1;
    private JLabel imeLabel;
    private JTextField imeTextField;
    private JLabel vrijemePrijaveLabel;
    private JTextField vrijemePrijaveTextField;
    private JLabel pozicijaLabel;
    private JTextField pozicijaTextField;
    private JButton odjaviSeButton;

    public EmployeeDashboard(Employee employee) {
        setTitle("Zaposlenik");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imeTextField.setText(employee.getIme());
        pozicijaTextField.setText(employee.getPozicija());
        String vrijemePrijave = EmployeeDAO.getVrijemePrijave(employee.getId());
        vrijemePrijaveTextField.setText(vrijemePrijave != null ? vrijemePrijave : "Nema podataka");

        // Akcija za dugme "Odjavi se"
        odjaviSeButton.addActionListener(e -> {
            EmployeeDAO.odjavaSaPosla(employee.getId());
            JOptionPane.showMessageDialog(EmployeeDashboard.this, "Uspješno ste se odjavili!");

            JFrame loginFrame = new JFrame("Login");
            loginFrame.setContentPane(new LoginForm().panel1);
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.pack();
            loginFrame.setVisible(true);

            dispose();
        });

        pack();

        setVisible(true);
    }
}
