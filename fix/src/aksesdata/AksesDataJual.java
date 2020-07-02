package aksesdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import koneksi.Koneksi;
import model.Baju;
import model.Beli;
import model.Jual;
import model.Pegawai;

public class AksesDataJual {

    private Koneksi koneksi;

    public AksesDataJual() {
        this.koneksi = new Koneksi();
    }

    public int getSequenceIdJual() throws SQLException {
        String sql = "SELECT last_number FROM user_sequences WHERE sequence_name LIKE 'ID_JUAL'";
        ResultSet rs = this.koneksi.GetData(sql);
        rs.next();
        return rs.getInt("last_number");
    }

    public void create(int idBeli, int idPegawai, String merk, int hargaJual) {
        String sql = "INSERT INTO jual_07027 (id_jual, id_beli, id_pegawai, harga_jual) "
                + "VALUES (id_jual.NEXTVAL, '" + idBeli + "', '" + idPegawai + "', '" + hargaJual + "')";
        this.koneksi.ManipulasiData(sql);
    }

    public ArrayList<Jual> read() throws SQLException {
        ArrayList<Jual> arrJual = new ArrayList<>();
        String sql = "SELECT a.id_jual, a.harga_jual, "
                + "b.id_beli, b.harga_beli, "
                + "c.id_baju, c.merk, "
                + "d.id_pegawai, d.nama_pegawai, "
                + "d.password, d.alamat, d.no_telp "
                + "FROM jual_07027 a "
                + "JOIN beli_07027 b ON a.id_beli = b.id_beli "
                + "JOIN baju_07027 c ON b.id_baju = c.id_baju "
                + "JOIN pegawai_07027 d ON a.id_pegawai = d.id_pegawai";
        ResultSet rs = this.koneksi.GetData(sql);
        while (rs.next()) {
            Pegawai pegawai = new Pegawai();
            pegawai.setIdPegawai(rs.getInt("id_pegawai"));
            pegawai.setNamaPegawai(rs.getString("nama_pegawai"));
            pegawai.setPassword(rs.getString("password"));
            pegawai.setAlamat(rs.getString("alamat"));
            pegawai.setNoTelp(rs.getString("no_telp"));

            Baju baju = new Baju();
            baju.setIdBaju(rs.getInt("id_baju"));
            baju.setMerk(rs.getString("merk"));

            Beli beli = new Beli();
            beli.setIdBeli(rs.getInt("id_beli"));
            beli.setBaju(baju);
            beli.setPegawai(pegawai);
            beli.setHargaBeli(rs.getInt("harga_beli"));

            Jual jual = new Jual();
            jual.setIdJual(rs.getInt("id_jual"));
            jual.setBeli(beli);
            jual.setPegawai(pegawai);
            jual.setHargaJual(rs.getInt("harga_jual"));

            arrJual.add(jual);
        }
        return arrJual;
    }
}
