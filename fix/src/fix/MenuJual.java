package fix;

import aksesdata.AksesDataBeli;
import aksesdata.AksesDataJual;
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
import javax.swing.table.TableColumn;
import model.AllObjek;
import model.Baju;
import model.Beli;
import model.Jual;

public class MenuJual {

    String merk;
    int idBeli, idJual, idPegawai, idBaju, hargajual, hargaBeli;
    AksesDataJual aksesDataJual;
    AksesDataBeli aksesDataBeli;

    public MenuJual() throws SQLException {
        this.aksesDataJual = new AksesDataJual();
        this.aksesDataBeli = new AksesDataBeli();

        JFrame frame = new JFrame();
        frame.setSize(519, 655);;
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("jual baju");

        JLabel labelIdJual = new JLabel("ID Jual");
        JTextField textIdJual = new JTextField();
        labelIdJual.setBounds(120, 10, 100, 30);
        textIdJual.setEditable(false);
        textIdJual.setBounds(200, 10, 200, 30);
        textIdJual.setText(String.valueOf(this.aksesDataJual.getSequenceIdJual()));
        frame.add(labelIdJual);
        frame.add(textIdJual);

        JLabel labelIdBeli = new JLabel("ID Beli");
        labelIdBeli.setBounds(120, 50, 100, 30);
        frame.add(labelIdBeli);
        JTextField textIdBeli = new JTextField();
        textIdBeli.setBounds(200, 50, 200, 30);
        frame.add(textIdBeli);

        JLabel labelIdPegawai = new JLabel("ID Pegawai");
        labelIdPegawai.setBounds(120, 90, 100, 30);
        frame.add(labelIdPegawai);
        JTextField textIdPegawai = new JTextField();
        textIdPegawai.setEditable(false);
        textIdPegawai.setBounds(200, 90, 200, 30);
        textIdPegawai.setText(String.valueOf(AllObjek.idPegawai));
        frame.add(textIdPegawai);

        JLabel labelIdBaju = new JLabel("ID Baju");
        labelIdBaju.setBounds(120, 130, 100, 30);
        frame.add(labelIdBaju);
        JTextField textIdBaju = new JTextField();
        textIdBaju.setEditable(false);
        textIdBaju.setBounds(200, 130, 200, 30);
        frame.add(textIdBaju);

        JLabel label_merk_kiri = new JLabel("Merk Baju");
        label_merk_kiri.setBounds(120, 170, 100, 30);
        frame.add(label_merk_kiri);
        JTextField text_merk_kiri = new JTextField();
        text_merk_kiri.setEditable(false);
        text_merk_kiri.setBounds(200, 170, 200, 30);
        frame.add(text_merk_kiri);

        JLabel label_harga_jual_kiri = new JLabel("Harga Jual");
        JTextField text_harga_jual_kiri = new JTextField();
        label_harga_jual_kiri.setBounds(120, 210, 100, 30);
        text_harga_jual_kiri.setBounds(200, 210, 200, 30);
        frame.add(label_harga_jual_kiri);
        frame.add(text_harga_jual_kiri);

        JButton button_cari = new JButton("Cari Data");
        button_cari.setBounds(20, 250, 150, 40);
        button_cari.setFont(new Font("Arial", Font.BOLD, 12));
        frame.add(button_cari);

        JButton button_tambah = new JButton("Insert");
        button_tambah.setBounds(175, 250, 150, 40);
        button_tambah.setFont(new Font("Arial", Font.BOLD, 12));
        frame.add(button_tambah);

        JButton button_refresh = new JButton("Refresh Kolom Isian");
        button_refresh.setBounds(330, 250, 150, 40);
        button_refresh.setFont(new Font("Arial", Font.BOLD, 12));
        frame.add(button_refresh);

        JTable tabel_jual = new JTable();

        JScrollPane scroll_pane_kiri = new JScrollPane(tabel_jual);
        scroll_pane_kiri.setBounds(10, 350, 480, 260);
        frame.add(scroll_pane_kiri);

        JButton btn1 = new JButton("kembali");
        btn1.setFont(new Font("Arial", Font.BOLD, 12));
        btn1.setBounds(175, 300, 150, 40);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MenuPegawai balik = new MenuPegawai();
                frame.dispose();
            }
        });

        frame.add(btn1);
        button_cari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean ketemu = false;
                if (textIdBeli.getText().equals("")) {
                    idBeli = Integer.parseInt(textIdBeli.getText());
                    JOptionPane.showMessageDialog(null, "Isi dulu ID beli");
                } else {
                    try {
                        if (!aksesDataBeli.cekDataBeliKosong()) {
                            idBeli = Integer.parseInt(textIdBeli.getText());
                            Beli beli = aksesDataBeli.cariDataBeli(idBeli);
                            if (beli != null) {
                                if (beli.getJual() != null) {
                                    ketemu = true;
                                    JOptionPane.showMessageDialog(null, "Data beli tersebut telah terjual");
                                } else {
                                    text_merk_kiri.setText(beli.getBaju().getMerk());
                                    textIdBaju.setText(String.valueOf(beli.getBaju().getIdBaju()));
                                    ketemu = true;
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Belum ada baju yang dibeli");
                        }
                        if (!ketemu && !aksesDataBeli.cekDataBeliKosong()) {
                            JOptionPane.showMessageDialog(null, "Data beli tidak ditemukan");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(MenuJual.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
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
                    hargajual = Integer.parseInt(text_harga_jual_kiri.getText());
                    ulang = false;
                } catch (NumberFormatException a) {
                    JOptionPane.showMessageDialog(null, "error :" + a);
                }
                if (!ulang) {
                    try {
                        aksesDataJual.create(idBeli, idBaju, merk, hargajual);
                        JOptionPane.showMessageDialog(null, "data berhasil ditambahkan");
                        textIdJual.setText(String.valueOf(aksesDataJual.getSequenceIdJual()));
                        tabel_jual.setModel(viewTabel());
                    } catch (SQLException ex) {
                        Logger.getLogger(MenuBeli.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });

        button_refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                text_merk_kiri.setText("");
                textIdBaju.setText("");
                textIdBeli.setText("");
                text_harga_jual_kiri.setText("");
            }
        });
        tabel_jual.setModel(this.viewTabel());
        frame.setVisible(true);
    }

    public DefaultTableModel viewTabel() throws SQLException {
        DefaultTableModel dtmJual = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtmJual.addColumn("ID Jual");
        dtmJual.addColumn("ID Beli");
        dtmJual.addColumn("ID Pegawai");
        dtmJual.addColumn("Harga Jual");

        ArrayList<Jual> arrJual = this.aksesDataJual.read();
        for (int i = 0; i < arrJual.size(); i++) {
            Object[] temp = new Object[4];
            temp[0] = arrJual.get(i).getIdJual();
            temp[1] = arrJual.get(i).getBeli().getIdBeli();
            temp[2] = arrJual.get(i).getPegawai().getIdPegawai();
            temp[3] = arrJual.get(i).getHargaJual();
            dtmJual.addRow(temp);
        }
        return dtmJual;
    }

}
