package com.rpg.arena;

// kelas abstrak sebagai blueprint semua karakter dalam game.
public abstract class Karakter implements AksiBertarung {

    // atribut
    // protected agar bisa diakses subclass di package lain, tapi tetap tersembunyi
    protected String nama;                      
    protected int hp;                           
    protected int baseDamage;
    protected boolean isDefending; // status bertahan

    // constructor
    public Karakter(String nama, int hp, int baseDamage) {
        this.nama = nama;
        this.hp = hp;
        this.baseDamage = baseDamage;
        this.isDefending = false; // default: tidak sedang bertahan
    }

    // getter setter
    public String getNama() {
        return nama; 

    }
    public void setNama(String nama) { 
        this.nama = nama; 
    }

    public int  getHp() { 
        return hp; 
    }
    public void setHp(int hp){ 
        this.hp = hp; 
    }

    public int  getBaseDamage() { 
        return baseDamage; 
    }
    public void setBaseDamage(int baseDamage) { 
        this.baseDamage = baseDamage; 
    }

    public boolean isDefending() { 
        return isDefending; 

    }
    public void setDefending(boolean defend) { 
        this.isDefending = defend; 
    }

    // metode terimaDamage
    // Mengurangi HP karakter berdasarkan damage yang masuk.
    // Jika sedang bertahan (isDefending = true), damage dipotong 50%.
    // HP tidak boleh turun di bawah 0.
    public void terimaDamage(int damage) {
        if (isDefending) {          // Mode bertahan aktif → damage dikurangi setengah
            damage = damage / 2;
            System.out.println("  [BERTAHAN] Damage berkurang 50%! Hanya menerima " + damage + " damage.");
            isDefending = false; // reset status bertahan setelah satu serangan
        }

        hp -= damage;

        if (hp < 0) {       // HP tidak boleh negatif
            hp = 0;
        }
    }

    // mwtode abstrak
    // Wajib di-override subclass karena tampilan status berbeda tiap karakter
    public abstract void tampilkanStatus();
}
