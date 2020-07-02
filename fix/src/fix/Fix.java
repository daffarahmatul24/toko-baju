package fix;

import koneksi.Koneksi;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fix {

    public Fix() {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("TOKO BAJU");
        label.setFont(new Font("Times New Roman", Font.BOLD, 40));
        label.setBounds(280, 50, 300, 40);
        frame.add(label);

        JButton btn1 = new JButton("Admin");
        btn1.setFont(new Font("Arial", Font.BOLD, 26));
        btn1.setBounds(70, 200, 300, 150);
        frame.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MenuAdmin adm = new MenuAdmin();
                frame.dispose();
            }
        });
        JButton btn2 = new JButton("Pegawai");
        btn2.setFont(new Font("Arial", Font.BOLD, 26));
        btn2.setBounds(400, 200, 300, 150);
        frame.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MenuLoginPegawai pgw = new MenuLoginPegawai();
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) throws SQLException, ParseException {
        Fix tes = new Fix();
    }

}
