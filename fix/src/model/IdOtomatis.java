package model;

public class IdOtomatis {

    private int idPegawai;
    private int idBeli;
    private int idJual;
    private int idPegawaiYangLogin;

    public IdOtomatis() {
        this.idPegawai = 1;
        this.idBeli = 1;
        this.idJual = 1;
    }

    public void setIncrementIdPegawai() {
        this.idPegawai = this.idPegawai + 1;
    }

    public int getIdPegawai() {
        return this.idPegawai;
    }

    public void setIncrementIdBeli() {
        this.idBeli = this.idBeli + 1;
    }

    public int getIdBeli() {
        return this.idBeli;
    }

    public void setIncrementIdJual() {
        this.idJual = this.idJual + 1;
    }

    public int getIdJual() {
        return this.idJual;
    }

    public void setIdPegawaiYangLogin(int idPegawaiYangLogin) {
        this.idPegawaiYangLogin = idPegawaiYangLogin;
    }

    public int getIdPegawaiYangLogin() {
        return this.idPegawaiYangLogin;
    }
}
