package fix;

import aksesdata.AksesDataPegawai;
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
import model.Pegawai;

public class MenuRegisterPegawai extends JFrame {

    AksesDataPegawai aksesDataPegawai;

    public MenuRegisterPegawai() throws SQLException {
        this.aksesDataPegawai = new AksesDataPegawai();
        JFrame frame = new JFrame();
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("REGISTER PEGAWAI");
        label.setFont(new Font("Times New Roman", Font.BOLD, 40));
        label.setBounds(200, 50, 500, 50);
        frame.add(label);

        JLabel labelId = new JLabel("ID PEGAWAI");
        labelId.setFont(new Font("Arial", Font.BOLD, 26));
        labelId.setBounds(70, 110, 170, 50);
        frame.add(labelId);
        JLabel labelId2 = new JLabel(":");
        labelId2.setFont(new Font("Arial", Font.BOLD, 26));
        labelId2.setBounds(250, 110, 100, 50);
        frame.add(labelId2);

        JLabel lb1 = new JLabel("NAMA");
        lb1.setFont(new Font("Arial", Font.BOLD, 26));
        lb1.setBounds(70, 170, 100, 50);
        frame.add(lb1);
        JLabel a = new JLabel(":");
        a.setFont(new Font("Arial", Font.BOLD, 26));
        a.setBounds(250, 170, 100, 50);
        frame.add(a);

        JLabel lb2 = new JLabel("PASSWORD");
        lb2.setFont(new Font("Arial", Font.BOLD, 26));
        lb2.setBounds(70, 230, 300, 50);
        frame.add(lb2);
        JLabel b = new JLabel(":");
        b.setFont(new Font("Arial", Font.BOLD, 26));
        b.setBounds(250, 230, 100, 50);
        frame.add(b);

        JLabel no = new JLabel("NO HP");
        no.setFont(new Font("Arial", Font.BOLD, 26));
        no.setBounds(70, 290, 300, 50);
        frame.add(no);
        JLabel c = new JLabel(":");
        c.setFont(new Font("Arial", Font.BOLD, 26));
        c.setBounds(250, 290, 100, 50);
        frame.add(c);

        JLabel labelAlamat = new JLabel("ALAMAT");
        labelAlamat.setFont(new Font("Arial", Font.BOLD, 26));
        labelAlamat.setBounds(70, 350, 300, 50);
        frame.add(labelAlamat);
        JLabel labelAlamat2 = new JLabel(":");
        labelAlamat2.setFont(new Font("Arial", Font.BOLD, 26));
        labelAlamat2.setBounds(250, 350, 100, 50);
        frame.add(labelAlamat2);

        JTextField tfId = new JTextField();
        tfId.setFont(new Font("Arial", Font.PLAIN, 26));
        tfId.setBounds(270, 110, 250, 50);
        tfId.setEditable(false);
        tfId.setEnabled(false);
        int idPegawaiOtomatis;
        tfId.setText(String.valueOf(this.aksesDataPegawai.getSequenceIdPegawai()));
        frame.add(tfId);

        JTextField tfNama = new JTextField();
        tfNama.setFont(new Font("Arial", Font.PLAIN, 26));
        tfNama.setBounds(270, 170, 250, 50);
        frame.add(tfNama);

        JTextField tfPassword = new JTextField();
        tfPassword.setFont(new Font("Arial", Font.PLAIN, 26));
        tfPassword.setBounds(270, 230, 250, 50);
        frame.add(tfPassword);

        JTextField tfNoHp = new JTextField();
        tfNoHp.setFont(new Font("Arial", Font.PLAIN, 26));
        tfNoHp.setBounds(270, 290, 250, 50);
        frame.add(tfNoHp);

        JTextField tfAlamat = new JTextField();
        tfAlamat.setFont(new Font("Arial", Font.PLAIN, 26));
        tfAlamat.setBounds(270, 350, 250, 50);
        frame.add(tfAlamat);

        JTable tblPegawai = new JTable();
        tblPegawai.setModel(this.viewTabel());

        JScrollPane scrollPane = new JScrollPane(tblPegawai);
        scrollPane.setBounds(530, 110, 400, 290);
        frame.add(scrollPane);

        JButton btnKembali = new JButton("kembali");
        btnKembali.setFont(new Font("Arial", Font.BOLD, 20));
        btnKembali.setBounds(70, 450, 180, 40);
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Fix balik = new Fix();
                frame.dispose();
            }
        });

        JButton btnDaftar = new JButton("Daftar");
        btnDaftar.setFont(new Font("Arial", Font.BOLD, 20));
        btnDaftar.setBounds(750, 450, 180, 40);
        btnDaftar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (tfNama.getText().equals("") || tfPassword.getText().equals("") || tfNoHp.getText().equals("")
                        || tfAlamat.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "data tidak lengkap");
                } else {
                    try {
                        String nama = tfNama.getText();
                        String password = tfPassword.getText();
                        String nomer = tfNoHp.getText();
                        String alamat = tfAlamat.getText();
                        aksesDataPegawai.create(nama, password, alamat, nomer);
                        JOptionPane.showMessageDialog(null, "data sudah terinput");
                        int idPegawaiOtomatis = aksesDataPegawai.getSequenceIdPegawai();
                        tfId.setText(String.valueOf(idPegawaiOtomatis));
                        tblPegawai.setModel(viewTabel());
                    } catch (SQLException ex) {
                        Logger.getLogger(MenuRegisterPegawai.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        });

        frame.add(btnDaftar);
        frame.add(btnKembali);
        frame.setVisible(true);

//         BUTTON UPDATE
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 20));
        btnUpdate.setBounds(520, 450, 180, 40);
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (tfNama.getText().equals("") || tfPassword.getText().equals("") || tfNoHp.getText().equals("")
                        || tfAlamat.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "data tidak lengkap");
                } else {
                    try {
                        String nama = tfNama.getText();
                        String password = tfPassword.getText();
                        String nomer = tfNoHp.getText();
                        String alamat = tfAlamat.getText();
                        aksesDataPegawai.update(nama, password, alamat, nomer);
                        JOptionPane.showMessageDialog(null, "data sudah terupdate");
                        tblPegawai.setModel(viewTabel());
                    } catch (SQLException ex) {
                        Logger.getLogger(MenuRegisterPegawai.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        frame.add(btnUpdate);
        frame.add(btnKembali);
        frame.setVisible(true);

//      BUTTON DELETE    
        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Arial", Font.BOLD, 20));
        btnDelete.setBounds(300, 450, 180, 40);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (tfNama.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Isi kolom nama pegawaiyang akan dihapus");
                } else {
                    try {
                        String nama = tfNama.getText();
                        aksesDataPegawai.delete(nama);
                        JOptionPane.showMessageDialog(null, "data sudah terhapus");
                        tblPegawai.setModel(viewTabel());
                    } catch (SQLException ex) {
                        Logger.getLogger(MenuRegisterPegawai.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        frame.add(btnDelete);
        frame.add(btnKembali);
        frame.setVisible(true);
    }

    public DefaultTableModel viewTabel() throws SQLException {
        DefaultTableModel dtmPegawai = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtmPegawai.addColumn("ID Pegawai");
        dtmPegawai.addColumn("Nama Pegawai");
        dtmPegawai.addColumn("Password");
        dtmPegawai.addColumn("Alamat");
        dtmPegawai.addColumn("No Telp");

        ArrayList<Pegawai> arrPegawai = this.aksesDataPegawai.read();
        for (int i = 0; i < arrPegawai.size(); i++) {
            Object[] temp = new Object[5];
            temp[0] = arrPegawai.get(i).getIdPegawai();
            temp[1] = arrPegawai.get(i).getNamaPegawai();
            temp[2] = arrPegawai.get(i).getPassword();
            temp[3] = arrPegawai.get(i).getAlamat();
            temp[4] = arrPegawai.get(i).getNoTelp();
            dtmPegawai.addRow(temp);
        }
        return dtmPegawai;
    }

}
