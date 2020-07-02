package fix;

import aksesdata.AksesDataBaju;
import aksesdata.AksesDataBeli;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.AllObjek;
import model.Beli;

public class MenuBeli {

    String merk;
    int idBeli, idBaju, idPegawai, hargabeli;
    private AksesDataBaju aksesDataBaju;
    private AksesDataBeli aksesDataBeli;

    public MenuBeli() throws SQLException {
        this.aksesDataBaju = new AksesDataBaju();
        this.aksesDataBeli = new AksesDataBeli();

        JFrame frame = new JFrame();
        frame.setSize(515, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("beli baju");
        //bagian deklarasi
        JLabel labelIdBeli = new JLabel("ID Beli");
        JLabel label_id_kiri = new JLabel("ID Baju");
        JLabel label_merk_kiri = new JLabel("Merk Baju");
        JLabel label_harga_beli_kiri = new JLabel("Harga Beli");
        JLabel labelIdPegawai = new JLabel("ID Pegawai");
        JTextField textIdBeli = new JTextField();
        JTextField textIdBaju = new JTextField();
        JTextField text_merk_kiri = new JTextField();
        JTextField text_harga_beli_kiri = new JTextField();
        JTextField textIdPegawai = new JTextField();
        JButton button_tambah = new JButton("Tambahkan Data");
        button_tambah.setFont(new Font("Arial", Font.BOLD, 12));
        JButton button_refresh = new JButton("Refresh Kolom Isian");
        button_refresh.setFont(new Font("Arial", Font.BOLD, 12));
        JTable tabel_beli = new JTable();
        JScrollPane scroll_pane = new JScrollPane(tabel_beli);

        // set komponen
        labelIdBeli.setBounds(10, 10, 100, 30);
        label_id_kiri.setBounds(10, 50, 100, 30);
        label_merk_kiri.setBounds(10, 90, 100, 30);
        label_harga_beli_kiri.setBounds(10, 130, 100, 30);
        labelIdPegawai.setBounds(10, 170, 100, 30);
        textIdPegawai.setBounds(120, 170, 370, 30);
        textIdPegawai.setEditable(false);
        textIdPegawai.setText(String.valueOf(AllObjek.idPegawai));
        textIdBeli.setBounds(120, 10, 370, 30);
        textIdBeli.setEditable(false);
        textIdBeli.setText(String.valueOf(this.aksesDataBeli.getSequenceIdBeli()));
        textIdBaju.setBounds(120, 50, 370, 30);
        textIdBaju.setEditable(false);
        textIdBaju.setText(String.valueOf(this.aksesDataBaju.getSequenceIdBaju()));
        text_merk_kiri.setBounds(120, 90, 370, 30);
        text_harga_beli_kiri.setBounds(120, 130, 370, 30);
        button_tambah.setBounds(80, 210, 160, 40);
        button_refresh.setBounds(260, 210, 160, 40);
        tabel_beli.setModel(this.viewTabel());
        scroll_pane.setBounds(10, 310, 480, 240);

        JButton btn1 = new JButton("kembali");
        btn1.setFont(new Font("Arial", Font.BOLD, 12));
        btn1.setBounds(170, 260, 160, 40);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MenuPegawai balik = new MenuPegawai();
                frame.dispose();
            }
        });
        button_tambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean ulang = true;
                idBaju = Integer.parseInt(textIdBaju.getText());
                idBeli = Integer.parseInt(textIdBeli.getText());
                idPegawai = Integer.parseInt(textIdPegawai.getText());
                merk = text_merk_kiri.getText();

                try {
                    hargabeli = Integer.parseInt(text_harga_beli_kiri.getText());
                    ulang = false;
                } catch (NumberFormatException a) {
                    JOptionPane.showMessageDialog(null, "error :" + a);
                }
                if (!ulang) {
                    try {
                        aksesDataBaju.create(merk);
                        aksesDataBeli.create(idBaju, idPegawai, hargabeli);
                        JOptionPane.showMessageDialog(null, "data berhasil ditambahkan");
                        textIdBaju.setText(String.valueOf(aksesDataBaju.getSequenceIdBaju()));
                        textIdBeli.setText(String.valueOf(aksesDataBeli.getSequenceIdBeli()));
                        tabel_beli.setModel(viewTabel());
                    } catch (SQLException ex) {
                        Logger.getLogger(MenuBeli.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        button_refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                text_harga_beli_kiri.setText("");
                text_merk_kiri.setText("");
                textIdBaju.setText("");
            }
        });

        // bagian add
        frame.add(labelIdBeli);
        frame.add(label_id_kiri);
        frame.add(label_merk_kiri);
        frame.add(label_harga_beli_kiri);
        frame.add(labelIdPegawai);
        frame.add(textIdBeli);
        frame.add(textIdBaju);
        frame.add(text_merk_kiri);
        frame.add(text_harga_beli_kiri);
        frame.add(textIdPegawai);
        frame.add(button_tambah);
        frame.add(button_refresh);
        frame.add(btn1);
        frame.add(scroll_pane);

        frame.setVisible(true);
    }

    public DefaultTableModel viewTabel() throws SQLException {
        DefaultTableModel dtmBeli = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtmBeli.addColumn("ID Beli");
        dtmBeli.addColumn("ID Baju");
        dtmBeli.addColumn("Merk");
        dtmBeli.addColumn("Harga Beli");

        ArrayList<Beli> arrBeli = this.aksesDataBeli.read();
        for (int i = 0; i < arrBeli.size(); i++) {
            Object[] temp = new Object[4];
            temp[0] = arrBeli.get(i).getIdBeli();
            temp[1] = arrBeli.get(i).getBaju().getIdBaju();
            temp[2] = arrBeli.get(i).getPegawai().getIdPegawai();
            temp[3] = arrBeli.get(i).getHargaBeli();
            dtmBeli.addRow(temp);
        }
        return dtmBeli;
    }

}
