package javagame;

public class Hero extends Entity {

    private String nickname;

    public Hero(String name, int health, String nickname, int x, int y) {
        super(name, health, x, y);
        this.nickname = nickname;
    }

    public String knowsAs() {
        return this.getName() + " the " + nickname;
    }

    @Override
    public int attack() {
        if (hasWeapon()) {
            return getWeapon().getDamage();
        }

        return 0;
    }
}
