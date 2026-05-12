public class Programmer extends Karyawan{
    private double gajiPokok;
    
    Programmer(double gajiPokok, String nama) {
        super(nama);
        this.gajiPokok = gajiPokok;
    }

    double hitungGanjil() {
        return gajiPokok;
    }
}
