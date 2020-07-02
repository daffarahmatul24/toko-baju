package fix;

import aksesdata.AksesDataBeli;
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
import javax.swing.table.TableColumn;
import model.Beli;

public class view {

    AksesDataBeli aksesDataBeli;
    
    public view() throws SQLException {
        this.aksesDataBeli = new AksesDataBeli();
        
        JFrame frame = new JFrame();
        frame.setSize(519, 655);;
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("view");
        JLabel label_id_kiri = new JLabel("ID Baju");
        JLabel label_merk_kiri = new JLabel("Merk Baju");
        JLabel label_harga_beli_kiri = new JLabel("Harga beli");
        JTextField text_id_kiri = new JTextField();
        JTextField text_merk_kiri = new JTextField();
        JTextField text_harga_beli_kiri = new JTextField();
        String[] field_beli = {"ID Baju", "Merk Baju", "Harga beli"};
        DefaultTableModel tabel_model_beli = new DefaultTableModel(field_beli, 0);
        JTable tabel_beli = new JTable(tabel_model_beli);
        TableColumn tc1_kiri = new TableColumn(), tc2_kiri = new TableColumn(),
                tc3_kiri = new TableColumn();
        JScrollPane scroll_pane_kiri = new JScrollPane(tabel_beli);

        tc1_kiri = tabel_beli.getColumnModel().getColumn(0);
        tc2_kiri = tabel_beli.getColumnModel().getColumn(1);
        tc3_kiri = tabel_beli.getColumnModel().getColumn(2);
        tc1_kiri.setPreferredWidth(80);
        tc2_kiri.setPreferredWidth(96);
        tc3_kiri.setPreferredWidth(96);
        scroll_pane_kiri.setBounds(10, 10, 480, 490);

        tabel_beli.setModel(this.viewTabel());

        JButton btn1 = new JButton("kembali");
        btn1.setFont(new Font("Arial", Font.BOLD, 12));
        btn1.setBounds(175, 530, 150, 40);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MenuPegawai balik = new MenuPegawai();
                frame.dispose();
            }
        });

        frame.add(scroll_pane_kiri);
        frame.add(label_id_kiri);
        frame.add(label_merk_kiri);
        frame.add(label_harga_beli_kiri);
        frame.add(text_id_kiri);
        frame.add(text_merk_kiri);
        frame.add(text_harga_beli_kiri);
        frame.add(btn1);
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
