package com.rpg.entitas;
import com.rpg.arena.Karakter;

public class Monster extends Karakter{ // concrete class yang mewarisi class Karakter karena perlu menerapkan standar perilaku (serang, bertahan, gunakanItem) yang dapat diakses dari Karakter yang mengimplementasikan AksiBertarung.
    protected String jenisMonster;

    public Monster(String nama, int hp, int baseDamage, String jenisMonster) { // konstruktor untuk menginisialisasi setiap atribut.
        super(nama, hp, baseDamage);
        this.jenisMonster = jenisMonster;
    }

    /*Getter setiap atribut, untuk mendapatkan/membaca nilai dari sebuah atribut*/
    public String getJenisMonster() {
        return jenisMonster;
    }

    /*Setter setiap atribut, untuk mengakases/mengubah nilai dari sebuah atribut */
    public void setJenisMonster(String jenisMonster) {
        this.jenisMonster = jenisMonster;
    }


    @Override
    public void bertahan() { // menulis ulang method bertahan dengan bentuk lain yang saat bertahan HP akan bertambah.
        this.hp += 10;
        System.out.println("Monster Bertahan dan Memulihkan HP!");
    }

    @Override
    public int serang() { // menulis ulang method serang dengan bentuk lain yang mengembalikan nilai dari damage aslinya.
        System.out.println("Monster menyerang! Damage : " + baseDamage);
        return baseDamage;
    }

    @Override
    public void gunakanItem() { // menulis ulang method gunakanItem dengan bentuk lain yang akan menambah damage saat monster dapat mengguankan item.
        this.baseDamage += 10;
        System.out.println("Monster Menggunakan Item! Damage akan bertambah!");
    }

    @Override
    public void tampilkanStatus() { // menulis ulang method dari abstract class untuk menampilkan status karakter Monster.
        System.out.println("Nama Monster : " + nama);
        System.out.println("Jenis Monster : " + jenisMonster);
        System.out.println("HP : " + hp);
        System.out.println("Damage : " + baseDamage);
    }
}
