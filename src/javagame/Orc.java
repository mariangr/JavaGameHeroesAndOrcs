package javagame;

import java.util.Random;

public class Orc extends Entity {

    private static Random rand = new Random();
    private float berserkFactor = rand.nextFloat() * 2;

    public Orc(String name, int health, int x, int y) {
        super(name, health, x, y);
    }

    @Override
    public int attack() {
        if (hasWeapon()) {
            return (int) (this.berserkFactor * getWeapon().getDamage());
        }
        return 0;
    }

}
