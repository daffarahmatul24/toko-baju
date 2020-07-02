package aksesdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import koneksi.Koneksi;
import model.Baju;
import model.Beli;
import model.Pegawai;

public class AksesDataBeli {

    private Koneksi koneksi;

    public AksesDataBeli() {
        this.koneksi = new Koneksi();
    }

    public int getSequenceIdBeli() throws SQLException {
        String sql = "SELECT last_number FROM user_sequences WHERE sequence_name LIKE 'ID_BELI'";
        ResultSet rs = this.koneksi.GetData(sql);
        rs.next();
        return rs.getInt("last_number");
    }

    public void create(int idBaju, int idPegawai, int hargaBeli) {
        String sql = "INSERT INTO beli_07027 (id_beli, id_baju, id_pegawai, harga_beli) VALUES "
                + "(id_beli.NEXTVAL, '" + idBaju + "', '" + idPegawai + "', '" + hargaBeli + "')";
        this.koneksi.ManipulasiData(sql);
    }

    public ArrayList<Beli> read() throws SQLException {
        ArrayList<Beli> arrBeli = new ArrayList<>();
        String sql = "SELECT a.id_beli, a.harga_beli, "
                + "b.id_baju, b.merk, "
                + "c.id_pegawai, c.nama_pegawai, "
                + "c.password, c.alamat, "
                + "c.no_telp "
                + "FROM beli_07027 a "
                + "JOIN baju_07027 b "
                + "ON a.id_baju = b.id_baju "
                + "JOIN pegawai_07027 c "
                + "ON a.id_pegawai = c.id_pegawai";
        ResultSet rs = this.koneksi.GetData(sql);
        while (rs.next()) {
            Baju baju = new Baju();
            baju.setIdBaju(rs.getInt("id_baju"));
            baju.setMerk(rs.getString("merk"));

            Pegawai pegawai = new Pegawai();
            pegawai.setIdPegawai(rs.getInt("id_pegawai"));
            pegawai.setNamaPegawai(rs.getString("nama_pegawai"));
            pegawai.setPassword(rs.getString("password"));
            pegawai.setAlamat(rs.getString("alamat"));
            pegawai.setNoTelp(rs.getString("no_telp"));

            Beli beli = new Beli();
            beli.setIdBeli(rs.getInt("id_beli"));
            beli.setBaju(baju);
            beli.setPegawai(pegawai);
            beli.setHargaBeli(rs.getInt("harga_beli"));

            arrBeli.add(beli);
        }
        return arrBeli;
    }

    public Beli cariDataBeli(int idBeli) throws SQLException {
        Beli beli = null;
        String sql = "SELECT a.id_beli, a.harga_beli, "
                + "b.id_baju, b.merk, "
                + "c.id_pegawai, c.nama_pegawai, "
                + "c.password, c.alamat, "
                + "c.no_telp "
                + "FROM beli_07027 a "
                + "JOIN baju_07027 b "
                + "ON a.id_baju = b.id_baju "
                + "JOIN pegawai_07027 c "
                + "ON a.id_pegawai = c.id_pegawai "
                + "WHERE id_beli = " + idBeli;
        ResultSet rs = this.koneksi.GetData(sql);
        while (rs.next()) {
            Baju baju = new Baju();
            baju.setIdBaju(rs.getInt("id_baju"));
            baju.setMerk(rs.getString("merk"));

            Pegawai pegawai = new Pegawai();
            pegawai.setIdPegawai(rs.getInt("id_pegawai"));
            pegawai.setNamaPegawai(rs.getString("nama_pegawai"));
            pegawai.setPassword(rs.getString("password"));
            pegawai.setAlamat(rs.getString("alamat"));
            pegawai.setNoTelp(rs.getString("no_telp"));

            beli = new Beli();
            beli.setIdBeli(rs.getInt("id_beli"));
            beli.setBaju(baju);
            beli.setPegawai(pegawai);
            beli.setHargaBeli(rs.getInt("harga_beli"));
        }
        
        return beli;
    }

    public boolean cekDataBeliKosong() throws SQLException {
        String sql = "SELECT * FROM beli_07027";
        ResultSet rs = this.koneksi.GetData(sql);
        boolean kosong = !rs.next();
        return kosong;
    }
}
