abstract class LayananPengiriman {
    protected String noResi;
    protected double beratBarang;
    protected double jarakTempuh;

    LayananPengiriman(String noResi, double berat, double jarak) {
        this.noResi = noResi;
        this.beratBarang = berat;
        this.jarakTempuh = jarak;
    }

    public void cetakResi() {
        System.out.println("Nomor Resi : " + noResi);
        System.out.println("Berat Barang : " + beratBarang);
        System.out.println("Jarak Tempuh : " + jarakTempuh);
    }

    abstract double hitungOngkosKirim();
}
