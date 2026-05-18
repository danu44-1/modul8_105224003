package com.rpg.main;
import com.rpg.entitas.Pahlawan;
import com.rpg.entitas.Monster;

import java.util.Scanner;


public class GameEngine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // deklarasi untuk input

        System.out.print("Masukkan Nama Pahlawan : ");
        String namaHero = input.nextLine(); // variabel namaHero yang menyimpan nilai input berupa string (huruf).

        Pahlawan hero = new Pahlawan(namaHero, 100, 10, 50, 1); // pembuatan objek pahlawan.

        /*Array yang berisi 3 objek monster*/
        Monster[] listMonster = {
            new Monster("Drag Lizard", 50, 10, "Normal"),
            new Monster("Wyvern", 70, 25, "Medium"),
            new Monster("Dragon", 100, 50, "Sulit")
        };

        for (Monster listM : listMonster) { // perulangan for untuk menulusuri array listMonster dengan variabel perulangan listM yang bertipe data Monster. 

            while (hero.getHp() > 0 && listM.getHp() > 0) { // nested loop, yang berulang selama hero memiliki HP lebih dari 0 dan monster yang ada memiliki HP lebih dari 0 (hidup)
                hero.tampilkanStatus();
                System.out.println("\n--------------------\n");
                listM.tampilkanStatus();

                System.out.println("\nPilih Aksi Anda:");
                System.out.println("1. Serang Biasa");
                System.out.println("2. Gunakan Skill (Casting Magic - Cost: 15 Mana)");
                System.out.println("3. Bertahan / Heal (+30 HP)");
                System.out.print("Pilih: ");
                int pilih = input.nextInt();

                int heroDamage = 0;

                /*Switch case dari 3 pilih aksi */
                switch (pilih) {
                    case 1:
                        heroDamage = hero.serang(); // ketika memilih menyerang, variabel heroDamage akan mengambil nilai integer dari method serang.
                        break;
                    
                    case 2:
                        heroDamage = hero.serang("Magic Slash", 15); // ketika memilih menyerang meenggunakan skill, variabel heroDamage akan mengambil nilai integer dari method serang yang berbentuk beda dari sebelumnya.
                        break;
                    
                    case 3:
                        hero.gunakanItem(); // ketika memilih bertahan, item akan langsung digunakan dan memulihkan HP hingga bertahan.
                        hero.bertahan();
                        break;
                    
                    default:
                        System.out.println("Pilihan tidak valid! giliran berakhir."); // akan keluar dari giliran pahlawan
                        break;
                }

                if (heroDamage > 0) { // jika heroDamage (damage dari hero ke monster) lebih dari 0, monster akan menerima damage dengan memanggil method terima damage.
                    listM.terimaDamage(heroDamage);
                }

                if (listM.getHp() <= 0) { // jika monster yang sedang dilawan memiliki HP kurang dari sama dengan 0, Monster berhasil dikalahkan.
                    System.out.println("\n" + listM.getNama() + " telah dikalahkan!");
                    break;
                }
                else {                      // jika masih memiliki HP, maka giliran monster
                    System.out.println("----------------------");
                    if (listM.getHp() < 20) { // dengan nested if, jika saat HP kurang dari 20 monster akan bertahan dan memulihkan sedikit HP
                        listM.bertahan();
                    }
                    else if (listM.getHp() < 35) { // dan akan menyerang, jika HP kurang dari 35 dan hero akan menerima damage dari variabel yang menyimpan damage monster.
                        int monsterDamage = listM.serang();
                        hero.terimaDamage(monsterDamage);
                    }
                }

                if (hero.getHp() <= 0) { // jika Pahlawan memiliki HP kurang dari sama dengan 0, Hero gugur
                    System.out.println("\n" + hero.getNama() + " telah gugur");
                    break;
                }
            }

            if (hero.getHp() > 0) { // jika perulangan while selesai, maka semua monster berhasil dikalahkan dan jika pahlawan memiliki HP yang lebih dari 0, maka pahlawan berhasil
                System.out.println("Pahlawan berhasil menamatkan Dungeon, Selamat Yuusha-sama : " + hero.getNama());
            }
            else { // jika kurang HP kurang dari itu, maka Game Over
                System.out.println("GAME OVER!");
            }
        }
        
    }
}
