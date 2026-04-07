package game;

public class HeroStrenght extends Hero {
    String Strenght = "default";

    public HeroStrenght(String nama, double health, double attackPower, String Strenght) {
        super(nama, health, attackPower);
        this.Strenght = Strenght;
    }

    @Override
    public void display() {
        System.out.println("Nama: " + this.nama);
        System.out.println("Health: " + this.health);
        System.out.println("Attack Power: " + this.attackPower);
        System.out.println("Strenght: " + this.Strenght);
    }

    @Override
    public void terimaSerangan(double damage) {
        this.health -= (damage * 0.50);
        System.out.println("Karakter menerima serangan sebesar " + damage);
    }
}
