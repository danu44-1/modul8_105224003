public class KartuKredit extends Pembayaran implements Keamanan{
    private String nomorKartu;

    KartuKredit(String namaPembayar, double nominal, String nomorKartu) {
        super(namaPembayar, nominal);
        this.nomorKartu = nomorKartu;
    }

    @Override
    void prosesPembayaran() {
        double biayaAdmin = nominal * 0.2;
        double total = nominal + biayaAdmin;

        System.out.println("Nomor Kartu : " + nomorKartu);
        System.out.println("Biaya Admin : " + biayaAdmin);
        System.out.println("Total Tagihan : " + total + "\n");
    }

    @Override
    public boolean autentikasi() {
        System.out.println("Autentikasi PIN Berhasil!");
        return true;
    }
}
