public class PengirimanDarat extends LayananPengiriman implements LacakKargo {
    private String jenisTruk;
    private String statusSaatIni;

    PengirimanDarat(String noResi, double berat, double jarak, String jenisTruk) {
        super(noResi, berat, jarak);
        this.jenisTruk = jenisTruk;
        this.statusSaatIni = "Menunggu Kurir";
    }

    @Override
    double hitungOngkosKirim() {
        double total = (beratBarang * 5000) + (jarakTempuh * 2000);;
        if (jenisTruk.equalsIgnoreCase("Tronton")) {
            return total + 150000;
        }

        return total;
    }

    @Override
    public void updateStatus(String status) {
        this.statusSaatIni = status;
    }

    @Override
    public String cekLokasiTerkini() {
        return this.statusSaatIni;
    }
}
