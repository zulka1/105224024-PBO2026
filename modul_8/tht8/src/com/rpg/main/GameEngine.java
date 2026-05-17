package com.rpg.main;
import com.rpg.entitas.Monster;
import com.rpg.entitas.Pahlawan;
import java.util.Scanner;

// Kelas utama: GameEngine
public class GameEngine {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Masukkan nama Pahlawan: ");
        String namaPahlawan = scanner.nextLine();

        // Buat objek Pahlawan (nama, hp, baseDamage, mana, level)
        Pahlawan pahlawan = new Pahlawan(namaPahlawan, 150, 20, 100, 3);

        // Array monster (Survival Mode: 3 musuh)
        Monster[] dungeon = new Monster[] {
            new Monster("Goblin",    60,  12, "Goblin"),
            new Monster("Ork",      100,  20, "Ork Prajurit"),
            new Monster("Naga",     180,  35, "Naga Bosses")
        };

        System.out.println("==============================");
        System.out.println("  SELAMAT DATANG DI DUNGEON  ");
        System.out.println("==============================");

        // Nested loop:
        // - for  -> iterasi monster dari array satu per satu
        // - while -> battle loop selama HP pahlawan & monster masih ada
        for (int i = 0; i < dungeon.length; i++) {
            Monster monster = dungeon[i];

            System.out.println(">>> BABAK " + (i + 1) + ": " + monster.getNama() + " muncul! <<<");

            // Battle Loop: berjalan selama kedua pihak masih hidup
            while (pahlawan.getHp() > 0 && monster.getHp() > 0) {

                // Tampilkan status keduanya setiap giliran
                System.out.println();
                pahlawan.tampilkanStatus();
                monster.tampilkanStatus();
                System.out.println();

                // menu aksi pemain
                System.out.println("Pilih aksi:");
                System.out.println("  1. Serang");
                System.out.println("  2. Gunakan Skill (Cost: 30 Mana)");
                System.out.println("  3. Bertahan / Heal");
                System.out.print("Pilihan: ");

                int pilihan;
                pilihan = scanner.nextInt();
                scanner.nextLine();

                int damageKePahlawan;
                int damageKeMonster;

                // Switch case untuk aksi pemain
                switch (pilihan) {
                    case 1: // Serang biasa
                        damageKeMonster = pahlawan.serang();
                        monster.terimaDamage(damageKeMonster);
                        break;

                    case 2: // Gunakan Skill (method overloading serang)
                        damageKeMonster = pahlawan.serang("Fireball", 30);
                        monster.terimaDamage(damageKeMonster);
                        break;

                    case 3: // Bertahan sekaligus heal
                        pahlawan.bertahan();
                        pahlawan.gunakanItem(); // sekaligus heal +30 HP
                        break;

                    default:
                        System.out.println("Aksi tidak dikenali. Giliran dilewati.");
                        break;
                }

                // Giliran monster membalas (jika masih hidup)
                if (monster.getHp() > 0) {
                    System.out.println();
                    damageKePahlawan = monster.serang();
                    pahlawan.terimaDamage(damageKePahlawan);
                }
            }

            // Cek hasil battle per monster
            if (pahlawan.getHp() <= 0) {
                break; // Pahlawan mati → keluar dari for loop
            } else {
                System.out.println(monster.getNama() + " telah dikalahkan!");
            }
        }

        // Kondisi akhir game (setelah keluar dari nested loop)
        System.out.println("==============================");
        if (pahlawan.getHp() > 0) {
            // Pahlawan masih hidup setelah mengalahkan semua monster
            System.out.println("DUNGEON CLEAR!");
            System.out.println("  " + pahlawan.getNama() + " berhasil menamatkan Dungeon!");
            System.out.println("  HP tersisa: " + pahlawan.getHp());
        } else {
            // Pahlawan gugur di tengah jalan
            System.out.println("GAME OVER");
            System.out.println("  " + pahlawan.getNama() + " gugur di dalam Dungeon...");
        }
        System.out.println("==============================");

        scanner.close();
    }
}
