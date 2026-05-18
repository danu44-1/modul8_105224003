package com.rpg.arena;

public abstract class Karakter implements AksiBertarung { // abstract class sebagai blue print yang tidak bisa langsung dibuat objeknya yaitu Karakter dan dapat mengimplementasikan perilaku AksiBertarung.
    protected String nama;
    protected int hp;
    protected int baseDamage;
    protected boolean isDefending;

    public Karakter(String nama, int hp, int baseDamage) { // konstruktor untuk menginisialisasi setiap atribut.
        this.nama = nama;
        this.hp = hp;
        this.baseDamage = baseDamage;
        this.isDefending = false;
    }

    /*Getter setiap atribut, untuk mendapatkan/membaca nilai dari sebuah atribut*/
    public String getNama() {
        return nama;
    }

    public int getHp() {
        return hp;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public boolean getDefending() {
        return isDefending;
    }

    /*Setter setiap atribut, untuk mengakases/mengubah nilai dari sebuah atribut */
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }
    
    public void setDefending(boolean isDefending) {
        this.isDefending = isDefending;
    }


    public void terimaDamage(int damage) { // concrete method ketika menerima damage dan berisi jika dalam mode bertahan (isDefending), damage yang diterima hanya setengah damage aslinya. Kemudian HP berkurang jika menerima damage dan jika HP berkurang < 0, HP akan tetap ditetapkan di 0.
        if (isDefending == true) {
            damage = damage / 2;  
            isDefending = false;
        }

        this.hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }

    public abstract void tampilkanStatus(); // abstract method untuk menampilkan status dari setiap class yang mewarisinya dan agar setiap entitas yang berupa Karakter dapat menampilkan statusnya dengan bentuknya tersendiri.
}
