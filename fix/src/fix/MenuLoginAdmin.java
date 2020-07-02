package fix;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MenuLoginAdmin {

    String nama = "daffa";
    String password = "123";

    public MenuLoginAdmin() {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("LOGIN ADMIN");
        label.setFont(new Font("Times New Roman", Font.BOLD, 40));
        label.setBounds(300, 50, 300, 40);
        frame.add(label);

        JLabel lb1 = new JLabel("NAMA");
        lb1.setFont(new Font("Arial", Font.BOLD, 26));
        lb1.setBounds(70, 200, 100, 150);
        frame.add(lb1);
        JLabel a = new JLabel(":");
        a.setFont(new Font("Arial", Font.BOLD, 26));
        a.setBounds(250, 200, 100, 150);
        frame.add(a);

        JLabel lb2 = new JLabel("PASSWORD");
        lb2.setFont(new Font("Arial", Font.BOLD, 26));
        lb2.setBounds(70, 250, 300, 150);
        frame.add(lb2);
        JLabel b = new JLabel(":");
        b.setFont(new Font("Arial", Font.BOLD, 26));
        b.setBounds(250, 250, 100, 150);
        frame.add(b);

        JTextField tfNama = new JTextField();
        tfNama.setFont(new Font("Arial", Font.PLAIN, 26));
        tfNama.setBounds(270, 255, 450, 40);
        frame.add(tfNama);

        JTextField tfPassword = new JTextField();
        tfPassword.setFont(new Font("Arial", Font.PLAIN, 26));
        tfPassword.setBounds(270, 305, 450, 40);
        frame.add(tfPassword);

        JButton btnKembali = new JButton("kembali");
        btnKembali.setFont(new Font("Arial", Font.BOLD, 20));
        btnKembali.setBounds(70, 400, 180, 40);
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MenuAdmin balik = new MenuAdmin();
                frame.dispose();
            }
        });

        JButton btnLogin = new JButton("login");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 20));
        btnLogin.setBounds(540, 400, 180, 40);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (tfNama.getText().equals(nama) && tfPassword.getText().equals(password)) {
                    try {
                        MenuRegisterPegawai pertama = new MenuRegisterPegawai();
                        frame.dispose();
                    } catch (SQLException ex) {
                        Logger.getLogger(MenuLoginAdmin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "nama dan passwoard salah");
                }
            }
        });
        frame.add(btnLogin);
        frame.add(btnKembali);
        frame.setVisible(true);
    }
}
