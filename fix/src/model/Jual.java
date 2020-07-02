package model;

public class Jual {

    private int idJual;
    private Beli beli;
    private Pegawai pegawai;
    private String merk;
    private int hargaJual;

    public int getIdJual() {
        return idJual;
    }

    public void setIdJual(int idJual) {
        this.idJual = idJual;
    }

    public Beli getBeli() {
        return beli;
    }

    public void setBeli(Beli beli) {
        this.beli = beli;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public int getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(int hargaJual) {
        this.hargaJual = hargaJual;
    }

}
