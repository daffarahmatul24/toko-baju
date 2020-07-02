/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Te {

    public static void main(String[] args) {
        String namaPegawai = "aaa";
        String password = "bbb";
        String noTelp = "22221111";
        String alamat = "Peneleh";
        String sql = "INSERT INTO pegawai_07027 (id_pegawai, nama_pegawai, password, alamat, no_telp) VALUES "
                + "(id_pegawai.NEXTVAL, '" + namaPegawai + "', '" + password+ "', '" + alamat + "', '"
                + noTelp + "')";
        System.out.println(sql);
    }

}
