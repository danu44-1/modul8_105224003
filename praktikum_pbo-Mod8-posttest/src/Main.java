public class Main {
    public static void main(String[] args) throws Exception {
        PengirimanDarat paket1 = new PengirimanDarat("DRT-001", 50, 100, "Tronton");
        PengirimanUdara paket2 = new PengirimanUdara("UDR-999", 10, 800, "GA-123", 5000000);

        paket1.updateStatus("Sedang di jalan tol Cipali");
        paket2.updateStatus("Transit di Bandara Soekarno-Hatta");

        LayananPengiriman[] daftarPengiriman = {paket1, paket2};

        for (LayananPengiriman Pengiriman : daftarPengiriman) {
            Pengiriman.cetakResi();

            if (Pengiriman instanceof LacakKargo) {
                LacakKargo terlacak = (LacakKargo) Pengiriman;
                System.out.println("Status Terlacak : " + terlacak.cekLokasiTerkini());
            }

            double totalTagihan = Pengiriman.hitungOngkosKirim();

            System.out.println("Ongkos Kirim : Rp." + totalTagihan);

            if (Pengiriman instanceof AsuransiKhusus) {
                System.out.println("-------------------------------------");
                AsuransiKhusus asuransi = (AsuransiKhusus) Pengiriman;
                asuransi.cetakPolis();

                if (Pengiriman instanceof PengirimanUdara) {
                    PengirimanUdara armadaUdara = (PengirimanUdara) Pengiriman;
                    double nilaiBarang = armadaUdara.getNilaiBarang();
                    double premi = armadaUdara.hitungPremi(nilaiBarang);

                    System.out.println("Biaya Premi 3% : Rp." + premi);
                    totalTagihan += premi;
                }
            }
            
            System.out.println("Total Tagihan : Rp." + totalTagihan + "\n-------------------------------------\n");
            
        }
    }
}
