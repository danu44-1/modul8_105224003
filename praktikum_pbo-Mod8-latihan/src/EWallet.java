public class EWallet extends Pembayaran implements Keamanan {
    private String nomorHP;

    EWallet(String namaPembayar, double nominal, String nomorHP) {
        super(namaPembayar, nominal);
        this.nomorHP = nomorHP;
    }

    @Override
    void prosesPembayaran() {
        double total = nominal;

        System.out.println("Nomor HP : " + nomorHP);
        System.out.println("Total Tagihan : " + total);
    }

    @Override
    public boolean autentikasi() {
        System.out.println("Autentikasi Berhasil!");
        return true;
    }
    
}
