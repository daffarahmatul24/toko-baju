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

public class MenuAdmin {

    public MenuAdmin() {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("ADMIN");
        label.setFont(new Font("Times New Roman", Font.BOLD, 40));
        label.setBounds(320, 50, 300, 40);
        frame.add(label);

        JButton btnLoginAdmin = new JButton("Login Admin");
        btnLoginAdmin.setFont(new Font("Arial", Font.BOLD, 26));
        btnLoginAdmin.setBounds(70, 200, 300, 150);
        frame.add(btnLoginAdmin);
        btnLoginAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MenuLoginAdmin adm = new MenuLoginAdmin();
                frame.dispose();
            }
        });
        JButton btnHasilPenjualan = new JButton("Hasil Penjualan");
        btnHasilPenjualan.setFont(new Font("Arial", Font.BOLD, 26));
        btnHasilPenjualan.setBounds(420, 200, 300, 150);
        frame.add(btnHasilPenjualan);
        btnHasilPenjualan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    MenuLaporan pgw = new MenuLaporan();
                } catch (SQLException ex) {
                    Logger.getLogger(MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
                frame.dispose();
            }
        });

        JButton btnKembali = new JButton("kembali");
        btnKembali.setFont(new Font("Arial", Font.BOLD, 12));
        btnKembali.setBounds(320, 450, 150, 70);
        frame.add(btnKembali);
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Fix balik = new Fix();
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}
