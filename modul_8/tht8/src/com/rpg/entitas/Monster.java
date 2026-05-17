package com.rpg.entitas;
import com.rpg.arena.Karakter;

// Concrete class Monster — musuh yang dihadapi Pahlawan.
// Perilaku bertahan berbeda: monster memulihkan HP, bukan mengurangi damage.
public class Monster extends Karakter {
    private String jenisMonster;

    // constructor
    public Monster(String nama, int hp, int baseDamage, String jenisMonster) {
        super(nama, hp, baseDamage);
        this.jenisMonster = jenisMonster;
    }

    // getter setter
    public String getJenisMonster() { 
        return jenisMonster; 
    }
    public void setJenisMonster(String jenisMonster) { 
        this.jenisMonster = jenisMonster; 
    }

    // POLYMORPHISM — Method Overriding
    // Serangan monster: cukup baseDamage saja, tanpa modifier level 
    @Override
    public int serang() {
        System.out.println(nama + " menyerang! Damage: " + baseDamage);
        return baseDamage;
    }

    // Bertahan versi Monster: alih-alih mengurangi damage
    // monster justru memulihkan sedikit HP (regenerasi)
    @Override
    public void bertahan() {
        int heal = 10;
        hp += heal;
        System.out.println(nama + " beregenerasi! HP pulih +" + heal + ". HP sekarang: " + hp);
    }

    // Monster tidak menggunakan item —> tidak ada efek
    @Override
    public void gunakanItem() {
        System.out.println(nama + " tidak bisa menggunakan item.");
    }

    // Tampilkan status Monster 
    @Override
    public void tampilkanStatus() {
        System.out.println("--- [" + nama + " | " + jenisMonster + "] ---");
        System.out.println("  HP : " + hp);
    }
}
