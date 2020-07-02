package aksesdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import koneksi.Koneksi;
import model.Baju;

public class AksesDataBaju {

    private Koneksi koneksi;

    public AksesDataBaju() {
        this.koneksi = new Koneksi();
    }

    public int getSequenceIdBaju() throws SQLException {
        String sql = "SELECT last_number FROM user_sequences WHERE sequence_name LIKE 'ID_BAJU'";
        ResultSet rs = this.koneksi.GetData(sql);
        rs.next();
        return rs.getInt("last_number");
    }

    public void create(String merk) {
        String sql = "INSERT INTO baju_07027 (id_baju, merk) VALUES (id_baju.NEXTVAL, '" + merk + "')";
        this.koneksi.ManipulasiData(sql);
    }

    public ArrayList<Baju> read() throws SQLException {
        ArrayList<Baju> arrBaju = new ArrayList<>();
        String sql = "SELECT * FROM baju_07027";
        ResultSet rs = this.koneksi.GetData(sql);
        while (rs.next()) {
            Baju baju = new Baju();
            baju.setIdBaju(rs.getInt("id_baju"));
            baju.setMerk(rs.getString("merk"));
            arrBaju.add(baju);
        }
        return arrBaju;
    }
}
