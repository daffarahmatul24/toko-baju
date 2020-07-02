package model;

public class Laporan {

    private int idLaporan;
    private Pegawai pegawai;
    private Jual jual;
    private int keuntungan;

    public int getIdLaporan() {
        return idLaporan;
    }

    public void setIdLaporan(int idLaporan) {
        this.idLaporan = idLaporan;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public Jual getJual() {
        return jual;
    }

    public void setJual(Jual jual) {
        this.jual = jual;
    }

    public int getKeuntungan() {
        return keuntungan;
    }

    public void setKeuntungan(int keuntungan) {
        this.keuntungan = keuntungan;
    }

}
