package com.rpg.entitas;
import com.rpg.arena.Karakter;

// Concrete class Pahlawan — karakter yang dikendalikan pemain.
// Menambahkan atribut mana & level, serta overloading metode serang().
public class Pahlawan extends Karakter {

    // Atribut tambahan khusus Pahlawan
    private int mana;
    private int level;

    // constructor
    public Pahlawan(String nama, int hp, int baseDamage, int mana, int level) {
        super(nama, hp, baseDamage); // panggil constructor Karakter
        this.mana = mana;
        this.level = level;
    }

    // getter setter
    public int  getMana()        { return mana; }
    public void setMana(int mana){ this.mana = mana; }

    public int  getLevel()         { return level; }
    public void setLevel(int level){ this.level = level; }

    // POLYMORPHISM — method Overriding
    // Serangan dasar: damage = baseDamage * level
    // Override dari AksiBertarung (via Karakter)
    @Override
    public int serang() {
        int damage = baseDamage * level;
        System.out.println(nama + " menyerang! Damage: " + damage);
        return damage;
    }

    // Bertahan: aktifkan isDefending agar damage berikutnya terpotong 50%.
    @Override
    public void bertahan() {
        isDefending = true;
        System.out.println(nama + " bersiaga! Damage berikutnya akan berkurang 50%.");
    }
    // Menggunakan item: pulihkan HP sebesar 30.
    @Override
    public void gunakanItem() {
        hp += 30;
        System.out.println(nama + " menggunakan Health Potion! HP pulih +30. HP sekarang: " + hp);
    }

    // Tampilkan status lengkap Pahlawan.
    @Override
    public void tampilkanStatus() {
        System.out.println("--- [" + nama + " | Level " + level + "] ---");
        System.out.println("  HP   : " + hp);
        System.out.println("  Mana : " + mana);
    }


    // POLYMORPHISM — Method Overloading
    // Versi kedua serang() dengan parameter skill
    public int serang(String namaSkill, int manaCost) {
        // namaSkill  nama skill yang digunakan (untuk display)
        // manaCost   biaya mana skill tersebut
        if (mana >= manaCost) {     // Serangan skill: damage = baseDamage * level * 2, mengkonsumsi mana.
            mana -= manaCost; // kurangi mana
            int damage = baseDamage * level * 2;
            System.out.println(nama + " menggunakan skill [" + namaSkill + "]! Damage: " + damage + " | Mana tersisa: " + mana);
            return damage;      // damage besar jika berhasil
        } else {
            // Mana tidak cukup → aksi gagal
            System.out.println(nama + " gagal menggunakan skill [" + namaSkill + "]! Mana tidak cukup. (Mana: " + mana + "/" + manaCost + ")");
            return 0;       // return 0 jika mana tidak cukup
        }
    }
}
