/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aksesdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import koneksi.Koneksi;
import model.Baju;
import model.Beli;
import model.Jual;
import model.Laporan;
import model.Pegawai;

/**
 *
 * @author daffa
 */
public class AksesDataLaporan {

    private Koneksi koneksi;

    public AksesDataLaporan() {
        this.koneksi = new Koneksi();
    }

    public int getSequenceIdLaporan() throws SQLException {
        String sql = "SELECT last_number FROM user_sequences WHERE sequence_name LIKE 'ID_LAPORAN'";
        ResultSet rs = this.koneksi.GetData(sql);
        rs.next();
        return rs.getInt("last_number");
    }

    public void create(int idJual) throws SQLException {
        String sql = "SELECT id_pegawai, id_beli, harga_jual FROM jual_07027 WHERE id_jual = " + idJual;
        ResultSet rs = this.koneksi.GetData(sql);
        rs.next();
        String sql2 = "SELECT harga_beli FROM beli_07027 WHERE id_beli = " + rs.getInt("id_beli");
        ResultSet rs2 = this.koneksi.GetData(sql2);
        rs2.next();
        int keuntungan = rs2.getInt("harga_jual") - rs.getInt("harga_beil");
        String sql3 = "INSERT INTO laporan_07027 (id_laporan, id_pegawai, id_jual, keuntungan) "
                + "VALUES (id_laporan.NEXTVAL, '" + rs.getString("id_pegawai") + "', '" + idJual + "', '" + keuntungan + "')";
        this.koneksi.ManipulasiData(sql3);
    }

    public ArrayList<Laporan> read() throws SQLException {
        ArrayList<Laporan> arrLaporan = new ArrayList<>();
        String sql = "SELECT a.id_laporan, a.keuntungan, "
                + "b.id_pegawai, b.nama_pegawai, "
                + "b.password, b.alamat, b.no_telp, "
                + "c.id_jual, c.harga_jual, "
                + "d.id_beli, d.harga_beli, "
                + "e.id_baju, e.merk "
                + "FROM laporan_07027 a "
                + "JOIN pegawai_07027 b "
                + "ON a.id_pegawai = b.id_pegawai "
                + "JOIN jual_07027 c "
                + "ON a.id_jual = c.id_jual "
                + "JOIN beli_07027 d "
                + "ON c.id_jual = d.id_jual "
                + "JOIN baju_07027 e "
                + "ON e.id_baju = d.id_baju";
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

            Laporan laporan = new Laporan();
            laporan.setIdLaporan(rs.getInt("id_laporan"));
            laporan.setPegawai(pegawai);
            laporan.setJual(jual);
            laporan.setKeuntungan(rs.getInt("keuntungan"));
            arrLaporan.add(laporan);
        }
        return arrLaporan;
    }

    public int getTotalKeuntungan() throws SQLException {
        String sql = "SELECT SUM(keuntungan) AS total_keuntungan FROM laporan_07027";
        ResultSet rs = this.koneksi.GetData(sql);
        rs.next();
        return rs.getInt("total_keuntungan");
    }
}
