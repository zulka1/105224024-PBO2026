import game.Hero;
import game.HeroStrenght;

public class App {
    public static void main(String[] args) throws Exception {
        Hero hero1 = new Hero("hero1", 100, 25);
        HeroStrenght hero2 = new HeroStrenght("hero2", 100, 35, "Strenght");

        System.out.println("Hero 1 stats: ");
        hero1.display();
        System.out.println("Hero 2 stats: ");
        hero2.display();
        System.out.println();

        System.out.print("Hero 1: ");
        hero1.berlatih();
        System.out.print("Hero 2: ");
        hero2.berlatih();
        System.out.println();

        System.out.print("Hero 1: ");
        hero1.terimaSerangan(50);
        System.out.print("Hero 2: ");
        hero2.terimaSerangan(50);
        System.out.println();

        System.out.println("Hero 1 stats: ");
        hero1.display();
        System.out.println("Hero 2 stats: ");
        hero2.display();
    }
}
