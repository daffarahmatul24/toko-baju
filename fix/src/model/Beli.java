package model;

public class Beli {

    private int idBeli;
    private Baju baju;
    private Pegawai pegawai;
    private int hargaBeli;
    private Jual jual;

    public int getIdBeli() {
        return idBeli;
    }

    public void setIdBeli(int idBeli) {
        this.idBeli = idBeli;
    }

    public Baju getBaju() {
        return baju;
    }

    public void setBaju(Baju baju) {
        this.baju = baju;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public int getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(int hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public Jual getJual() {
        return jual;
    }

    public void setJual(Jual jual) {
        this.jual = jual;
    }

}
