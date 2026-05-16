import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Pembayaran> transaksi = new ArrayList<>();

        transaksi.add(new KartuKredit("Dimas", 10000, "010101"));
        transaksi.add(new EWallet("Putra", 10000, "+620909"));

        for (Pembayaran daftarPembayaran : transaksi) {
            daftarPembayaran.tampilkanDetail();

            if (daftarPembayaran instanceof KartuKredit) {
                KartuKredit kartu = (KartuKredit) daftarPembayaran;
                if (kartu.autentikasi() == true) {
                    kartu.prosesPembayaran();
                }
            }
            else if (daftarPembayaran instanceof EWallet) {
                EWallet ewallet = (EWallet) daftarPembayaran;
                if (ewallet.autentikasi() == true) {
                    ewallet.prosesPembayaran();
                }
            }
        }
    }
}
