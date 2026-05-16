abstract class Pembayaran {
    protected String namaPembayar;
    protected double nominal;
    
    Pembayaran(String namaPembayar, double nominal) {
        this.namaPembayar = namaPembayar;
        this.nominal = nominal;
    }

    public void tampilkanDetail() {
        System.out.println("Nama Pembayar : " + namaPembayar);
        System.out.println("Nominal Transaksi : " + nominal + "\n");
    }

    abstract void prosesPembayaran();
}
