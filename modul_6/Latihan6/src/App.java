import game.*;

public class App {
    public static void main(String[] args) throws Exception {
        Hero[] hero = new Hero[2];
        hero[0] = new Hero("hero1", 100, 25);
        hero[1] = new Hero("hero2", 100, 35);

        hero[0].display();
        hero[1].display();

        hero[0].berlatih();
        hero[1].berlatih();

        hero[0].display();
        hero[1].display();
    }
}
