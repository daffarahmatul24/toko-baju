package fix;

import aksesdata.AksesDataLaporan;
import model.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MenuLaporan {

    AksesDataLaporan aksesDataLaporan;

    public MenuLaporan() throws SQLException {
        this.aksesDataLaporan = new AksesDataLaporan();

        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JTable tabelLaporan = new JTable();
        tabelLaporan.setModel(this.viewTabel());
        JScrollPane sc = new JScrollPane(tabelLaporan);
        sc.setBounds(10, 10, 450, 530);
        frame.add(sc);

        JTextField totalKeuntungan = new JTextField();
        totalKeuntungan.setBounds(500, 40, 200, 30);
        totalKeuntungan.setText(String.valueOf(this.aksesDataLaporan.getTotalKeuntungan()));
        frame.add(totalKeuntungan);
        JLabel keuntungan1 = new JLabel("Total Keuntungan");
        keuntungan1.setBounds(500, 10, 200, 30);
        keuntungan1.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(keuntungan1);

        JButton btn = new JButton("kembali");
        btn.setFont(new Font("Arial", Font.BOLD, 12));
        btn.setBounds(500, 500, 100, 40);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Fix balik = new Fix();

                frame.dispose();
            }
        });
        frame.add(btn);
        frame.setVisible(true);
    }

    public DefaultTableModel viewTabel() throws SQLException {
        DefaultTableModel dtmLaporan = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtmLaporan.addColumn("ID Laporan");
        dtmLaporan.addColumn("ID Pegawai");
        dtmLaporan.addColumn("ID Jual");
        dtmLaporan.addColumn("Keuntungan");

        ArrayList<Laporan> arrLaporan = this.aksesDataLaporan.read();
        for (int i = 0; i < arrLaporan.size(); i++) {
            Object[] temp = new Object[4];
            temp[0] = arrLaporan.get(i).getIdLaporan();
            temp[1] = arrLaporan.get(i).getPegawai().getIdPegawai();
            temp[2] = arrLaporan.get(i).getJual().getIdJual();
            temp[3] = arrLaporan.get(i).getKeuntungan();
            dtmLaporan.addRow(temp);
        }
        return dtmLaporan;
    }
}
