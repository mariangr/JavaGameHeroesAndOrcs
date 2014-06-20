package javagame;

import java.util.Random;

public abstract class Entity {

    private String name;
    private int health;
    private int maxHealth;
    private boolean hasWeapon;
    private Weapon weapon;
    private int x;
    private int y;
    private static Random rand = new Random();

    public Entity(String name, int health, int x, int y) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.hasWeapon = false;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return (health > 0);
    }

    public void takeDamage(int damagePoints) {
        this.health = this.health - damagePoints;
        if (health < 0) {
            health = 0;
        }
    }

    public boolean takeHealing(int healthPoints) {
        if (!isAlive()) {
            System.out.println("False. It's too late to heal.");
            return false;
        }
        this.health += healthPoints;
        if (this.health > this.maxHealth) {
            this.health = this.maxHealth;
        }

        return true;
    }

    public boolean hasWeapon() {
        return hasWeapon;
    }

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
        this.hasWeapon = true;
    }

    public abstract int attack();

    public Weapon getWeapon() {
        return this.weapon;
    }

    public boolean move(int x, int y) {
        if (JavaGame.map.isFree(x, y)) {
            JavaGame.map.removeEntity(this.x, this.y);
            JavaGame.map.addEntity(x, y, this);
            this.x = x;
            this.y = y;
            return true;
        }
        return false;
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getXCoord() {
        return this.x;
    }

    public int getYCoord() {
        return this.y;
    }

    public void automaticMove() {
        boolean success = false;
        int chance;

        while (!success) {
            chance = rand.nextInt(100);
            if (chance < 25) {
                success = this.move(this.x - 1, this.y);
            }
            if (chance >= 25 && chance < 50) {
                success = this.move(this.x + 1, this.y);
            }
            if (chance >= 50 && chance < 75) {
                success = this.move(this.x, this.y - 1);
            }
            if (chance >= 75) {
                success = this.move(this.x, this.y - 1);
            }
        }

    }

}
