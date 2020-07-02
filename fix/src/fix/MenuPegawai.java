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

public class MenuPegawai {

    public MenuPegawai() {
        JFrame frame = new JFrame();
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("Pegawai");
        label.setFont(new Font("Times New Roman", Font.BOLD, 40));
        label.setBounds(70, 200, 200, 100);
        frame.add(label);

        JButton btnBeli = new JButton("Beli");
        btnBeli.setFont(new Font("Arial", Font.BOLD, 26));
        btnBeli.setBounds(60, 200, 180, 100);
        frame.add(btnBeli);
        btnBeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    MenuBeli adm = new MenuBeli();
                } catch (SQLException ex) {
                    Logger.getLogger(MenuPegawai.class.getName()).log(Level.SEVERE, null, ex);
                }
                frame.dispose();
            }
        });
        JButton btnJual = new JButton("Jual");
        btnJual.setFont(new Font("Arial", Font.BOLD, 26));
        btnJual.setBounds(260, 200, 180, 100);
        frame.add(btnJual);
        btnJual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    MenuJual pgw = new MenuJual();
                } catch (SQLException ex) {
                    Logger.getLogger(MenuPegawai.class.getName()).log(Level.SEVERE, null, ex);
                }
                frame.dispose();
            }
        });

        JButton btnKembali = new JButton("kembali");
        btnKembali.setFont(new Font("Arial", Font.BOLD, 12));
        btnKembali.setBounds(170, 440, 160, 60);
        btnKembali.setFont(new Font("Arial", Font.BOLD, 20));
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Fix balik = new Fix();

                frame.dispose();
            }
        });
        frame.add(btnKembali);
        frame.setVisible(true);
    }
}
