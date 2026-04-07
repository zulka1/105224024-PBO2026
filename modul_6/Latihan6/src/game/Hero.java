package game;

public class Hero {
    String nama;
    double health;
    double attackPower;

    public Hero(String nama, double health, double attackPower) {
        this.nama = nama;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void display() {
        System.out.println("Nama: " + this.nama);
        System.out.println("Health: " + this.health);
        System.out.println("Attack Power: " + this.attackPower);
    }

    public void berlatih() {
        this.attackPower += 10;
        System.out.println("Karakter sedang berlatih");

    }

    void terimaSerangan(double damage) {
        this.health -= damage;
        System.out.println("Karakter menerima serangan sebesar " + damage);
    }
}