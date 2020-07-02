package aksesdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import koneksi.Koneksi;
import model.Pegawai;

public class AksesDataPegawai {

    private Koneksi koneksi;

    public AksesDataPegawai() {
        this.koneksi = new Koneksi();
    }

    public int getSequenceIdPegawai() throws SQLException {
        String sql = "SELECT last_number FROM user_sequences WHERE sequence_name LIKE 'ID_PEGAWAI'";
        ResultSet rs = this.koneksi.GetData(sql);
        rs.next();
        return rs.getInt("last_number");
    }

    public void create(String namaPegawai, String password, String alamat, String noTelp) {
        String sql = "INSERT INTO pegawai_07027 (id_pegawai, nama_pegawai, password, alamat, no_telp) VALUES "
                + "(id_pegawai.NEXTVAL, '" + namaPegawai + "', '" + password + "', '" + alamat + "', '"
                + noTelp + "')";
        this.koneksi.ManipulasiData(sql);
    }

    public ArrayList<Pegawai> read() throws SQLException {
        ArrayList<Pegawai> arrPegawai = new ArrayList<>();
        String sql = "SELECT * FROM list_pegawai";
        ResultSet rs = this.koneksi.GetData(sql);
        while (rs.next()) {
            Pegawai pegawai = new Pegawai();
            pegawai.setIdPegawai(rs.getInt("id_pegawai"));
            pegawai.setNamaPegawai(rs.getString("nama_pegawai"));
            pegawai.setPassword(rs.getString("password"));
            pegawai.setAlamat(rs.getString("alamat"));
            pegawai.setNoTelp(rs.getString("no_telp"));

            arrPegawai.add(pegawai);
        }
        return arrPegawai;
    }

    public void update(String namaPegawai, String password, String alamat, String noTelp) {
        String sql = "UPDATE pegawai_07027 SET password = '" + password + "', alamat = '" + alamat + "', no_telp = '"
                + noTelp + "' WHERE nama_pegawai = '" + namaPegawai + "'";
        this.koneksi.ManipulasiData(sql);
    }

    public void delete(String namaPegawai) {
        String sql = "DELETE FROM pegawai_07027 WHERE nama_pegawai LIKE '" + namaPegawai + "'";
        this.koneksi.ManipulasiData(sql);
    }

    public boolean cekLoginBenar(String namaPegawai, String password) throws SQLException {
        String sql = "SELECT * FROM pegawai_07027 WHERE nama_pegawai LIKE '" + namaPegawai + "' AND "
                + "password LIKE '" + password + "'";
        ResultSet rs = this.koneksi.GetData(sql);
        if (rs.next()) {
            return namaPegawai.equals(rs.getString("nama_pegawai")) && password.equals(rs.getString("password"));
        } else {
            return false;
        }
    }

    public int cariIdPegawai(String namaPegawai) throws SQLException {
        String sql = "SELECT id_pegawai FROM pegawai_07027 WHERE nama_pegawai LIKE '" + namaPegawai + "'";
        ResultSet rs = this.koneksi.GetData(sql);
        rs.next();
        return rs.getInt("id_pegawai");
    }
}
