package com.KenanHavicipia.example.gui;

import com.KenanHavicipia.example.database.EmployeeDAO;
import com.KenanHavicipia.example.models.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.sql.SQLException;

public class AdminDashboard extends JFrame {
    private JPanel panel1;
    private JButton pregledSvihZaposlenihButton;
    private JList<String> pregledZaposlenihList;
    private JButton dodajNovogZaposlenogButton;
    private JTextField imeTextField;
    private JTextField pozicijaTextField;
    private JTextField korisnickoIme;
    private JTextField lozinka;
    private JTextField datumZaposlenjaTextField;
    private JComboBox<String> ulogaComboBox1;
    private JTextArea textArea1;
    private JButton potvrdiButton;
    private JButton brisanjeZaposlenogButton;
    private JList<String> brisanjeZaposlenogList;
    private JButton izbrišiButton;
    private JButton urediPodatkeZaposlenogButton;
    private JTextField urediImeZaposlenog;
    private JTextField urediPozicijuZaposlenog;
    private JTextField urediKorisnickoIme;
    private JPasswordField urediPassword;
    private JTextField urediDatumZaposlenja;
    private JTextArea pregledHistorijePrijavaTextArea;
    private JButton pregledHistorijePrijavaZaposlenihButton;
    private JButton otkažiButton;
    private JComboBox<String> urediUlogu;
    private JButton potvrdiIzmjeneButton;
    private JButton otkažiButton1;
    private JButton odjaviSeButton;
    private JTextField izbrišiKorisnika;
    private JTextField urediKorisnikaID;

    public AdminDashboard(Employee admin) {
        setTitle("Admin Dashboard");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        pregledSvihZaposlenihButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Employee> zaposleni = EmployeeDAO.getAllEmployees();
                DefaultListModel<String> listModel = new DefaultListModel<>();
                for (Employee emp : zaposleni) {
                    // Dodaj ID, ime i poziciju u listu
                    listModel.addElement("ID: " + emp.getId() + " | " + emp.getIme() + " - " + emp.getPozicija());
                }
                pregledZaposlenihList.setModel(listModel);
            }
        });

        // ActionListener za dodavanje novog zaposlenog
        dodajNovogZaposlenogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ime = imeTextField.getText();
                String pozicija = pozicijaTextField.getText();
                String korisnickoImeText = korisnickoIme.getText();
                String lozinkaText = lozinka.getText();
                String datumZaposlenja = datumZaposlenjaTextField.getText();
                String uloga = (String) ulogaComboBox1.getSelectedItem();

                if (!ime.isEmpty() && !pozicija.isEmpty() && !korisnickoImeText.isEmpty() && !lozinkaText.isEmpty()) {
                    Employee employee = new Employee(ime, pozicija, datumZaposlenja, korisnickoImeText, lozinkaText, uloga);
                    EmployeeDAO.addEmployee(employee);
                    JOptionPane.showMessageDialog(AdminDashboard.this, "Uspješno ste dodali novog zaposlenog!");
                } else {
                    JOptionPane.showMessageDialog(AdminDashboard.this, "Molimo popunite sve podatke.");
                }
            }
        });

        // ActionListener za otkazivanje podataka
        otkažiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imeTextField.setText("");
                pozicijaTextField.setText("");
                korisnickoIme.setText("");
                lozinka.setText("");
                datumZaposlenjaTextField.setText("");
                ulogaComboBox1.setSelectedIndex(0);
                urediImeZaposlenog.setText("");
                urediPozicijuZaposlenog.setText("");
                urediKorisnickoIme.setText("");
                urediPassword.setText("");
                urediDatumZaposlenja.setText("");
                pregledHistorijePrijavaTextArea.setText("");
                brisanjeZaposlenogList.clearSelection();
            }
        });

        // ActionListener za potvrdu izmjena
        potvrdiIzmjeneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(urediKorisnikaID.getText().trim());

                    String ime = urediImeZaposlenog.getText();
                    String pozicija = urediPozicijuZaposlenog.getText();
                    String datumZaposlenja = urediDatumZaposlenja.getText();
                    String lozinkaText = new String(urediPassword.getPassword());
                    String uloga = (String) urediUlogu.getSelectedItem();

                    if (!ime.isEmpty() && !pozicija.isEmpty() && !datumZaposlenja.isEmpty() && !lozinkaText.isEmpty()) {
                        EmployeeDAO.urediZaposlenogPoID(id, ime, pozicija, datumZaposlenja, lozinkaText, uloga);
                        JOptionPane.showMessageDialog(AdminDashboard.this, "Podaci zaposlenog su uspješno ažurirani!");
                    } else {
                        JOptionPane.showMessageDialog(AdminDashboard.this, "Molimo popunite sve podatke.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AdminDashboard.this, "Molimo unesite validan ID!");
                }
            }
        });


        //ActionListener za otkazivanje izmjena
        otkažiButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                urediImeZaposlenog.setText("");
                urediPozicijuZaposlenog.setText("");
                urediKorisnickoIme.setText("");
                urediPassword.setText("");
                urediDatumZaposlenja.setText("");
                urediUlogu.setSelectedIndex(0);
            }
        });

        izbrišiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(izbrišiKorisnika.getText().trim());

                    EmployeeDAO.obrisiZaposlenogPoID(id);

                    JOptionPane.showMessageDialog(AdminDashboard.this, "Zaposleni sa ID " + id + " je uspešno obrisan!");

                    pregledSvihZaposlenihButton.doClick();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AdminDashboard.this, "Molimo unesite validan ID!");
                }
            }
        });

        urediPodatkeZaposlenogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String idText = urediKorisnikaID.getText().trim();
                    if (idText.isEmpty()) {
                        JOptionPane.showMessageDialog(AdminDashboard.this, "Polje ID ne sme biti prazno!");
                        return;
                    }
                    int id = Integer.parseInt(idText);

                    String ime = urediImeZaposlenog.getText();
                    String pozicija = urediPozicijuZaposlenog.getText();
                    String datumZaposlenja = urediDatumZaposlenja.getText();
                    String lozinkaText = new String(urediPassword.getPassword());
                    String role = (String) urediUlogu.getSelectedItem();

                    if (ime.isEmpty() || pozicija.isEmpty() || datumZaposlenja.isEmpty() || lozinkaText.isEmpty()) {
                        JOptionPane.showMessageDialog(AdminDashboard.this, "Molimo popunite sva polja.");
                        return;
                    }

                    // Ažuriraj zaposlenog
                    boolean uspeh = EmployeeDAO.urediZaposlenogPoID(id, ime, pozicija, datumZaposlenja, lozinkaText, role);
                    if (uspeh) {
                        JOptionPane.showMessageDialog(AdminDashboard.this, "Podaci zaposlenog su uspešno ažurirani!");
                    } else {
                        JOptionPane.showMessageDialog(AdminDashboard.this, "Zaposleni sa unetim ID-jem nije pronađen u bazi.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AdminDashboard.this, "ID mora biti broj! Molimo unesite ispravan ID.");
                }
            }
        });




        odjaviSeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                odjaviSe();
            }
        });

        // ActionListener za pregled historije prijava i odjava
        pregledHistorijePrijavaZaposlenihButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> historijaPrijava = EmployeeDAO.getHistorijaPrijava();
                StringBuilder sb = new StringBuilder();

                for (String historija : historijaPrijava) {
                    sb.append(historija).append("\n");
                }

                pregledHistorijePrijavaTextArea.setText(sb.toString());
            }
        });


        pack(); // Automatski podešava veličinu prozora
        setLocationRelativeTo(null);
        setVisible(true); // Prikazivanje prozora
    }

    // Metoda za odjavu
    private void odjaviSe() {
        int response = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da želite da izađete?", "Odjava", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            dispose();

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new LoginForm();
                }
            });
        }
    }
}



