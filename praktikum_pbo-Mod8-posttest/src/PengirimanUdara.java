public class PengirimanUdara extends LayananPengiriman implements LacakKargo, AsuransiKhusus {
    private String nomorPenerbangan;
    private String statusSaatIni;
    private double nilaiBarang;
    
    PengirimanUdara(String noResi, double berat, double jarak, String nomorPenerbangan, double nilaiBarang) {
        super(noResi, berat, jarak);
        this.nomorPenerbangan = nomorPenerbangan;
        this.statusSaatIni = "Menunggu Jadwal Penerbangan";
        this.nilaiBarang = nilaiBarang;
    }

    public double getNilaiBarang() {
        return nilaiBarang;
    }

    @Override
    double hitungOngkosKirim() {
        double total = (beratBarang * 25000) + (jarakTempuh * 5000);
        return total;
    }

    @Override
    public double hitungPremi(double nilaiBarang) {
        return nilaiBarang * 0.03;
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
