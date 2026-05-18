package com.rpg.entitas;
import com.rpg.arena.Karakter;

public class Pahlawan extends Karakter{ // concrete class yang mewarisi class Karakter karena perlu menerapkan standar perilaku (serang, bertahan, gunakanItem) yang dapat diakses dari Karakter yang mengimplementasikan AksiBertarung.
    protected int mana;
    protected int level;

    public Pahlawan(String nama, int hp, int baseDamage, int mana, int level) { // konstruktor untuk menginisialisasi setiap atribut.
        super(nama, hp, baseDamage);
        this.mana = mana;
        this.level = level;
    }

    /*Getter setiap atribut, untuk mendapatkan/membaca nilai dari sebuah atribut*/
    public int getMana() {
        return mana;
    }

    public int getLevel() {
        return level;
    }

    /*Setter setiap atribut, untuk mengakases/mengubah nilai dari sebuah atribut */
    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    @Override
    public int serang() { // menulis ulang method serang dengan bentuk yang berbeda dan mengembalikan nilai dari damage aslinya dikali (*) level dari Pahlawan.
        System.out.println("Pahlawan menyerang! Damage : " + baseDamage * level);
        return baseDamage * level;
    }

    @Override
    public void bertahan() { // menulis ulang method bertahan dengan bentuk yang berbeda dan mengubah nilai boolean isDefending menjadi true (dalam bertahan) serta mencetak "Pahlawan Bersiaga!".
        this.isDefending = true;
        System.out.println("Pahlawan Bersiaga!");
    }
    
    @Override
    public void tampilkanStatus() { // menulis ulang method dari abstract class untuk menampilkan status karakter Pahlawan.
        System.out.println("HP : " + hp);
        System.out.println("Mana : " + mana);
        System.out.println("Level : " + level);
    }

    @Override
    public void gunakanItem() { // menulis ulang method gunakanItem dengan bentuk yang berbeda dam akan menambah nilai HP sebesar 30.
        this.hp += 30;
        System.out.println("Menambah HP sebesar 30");
    }
    
    public int serang(String namaSkill, int manaCost) { // menambah method yang sama (serang()) dengan penambahan parameter dan bentuk yang berbeda (Method Overloading), ketika mana cukup akan mengurangi mana dan kembalikan damage besar.
        if (mana >= manaCost) {
            this.mana -= manaCost;
            System.out.println("Menyerang dengan skill : " + namaSkill + ",  Mana berkurang : " + manaCost);
            return baseDamage * level * 2;
        }
        else {
            System.out.println("Gagal Casting!");
            return 0;
        }
    }
}
