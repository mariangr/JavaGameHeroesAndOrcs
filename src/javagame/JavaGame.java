package javagame;
public class JavaGame {
    public static void main(String[] args) {
        Hero hero = new Hero("Byron",100,"Black");
        Orc orc = new Orc("Smeagle",100,1.5f);
        Weapon heroWeapon = new Weapon("Needle",5);
        Weapon orcWeapon = new Weapon("Boomerang",5);
        hero.equipWeapon(heroWeapon);
        orc.equipWeapon(orcWeapon);
        Fight game = new Fight(hero,orc);
        game.simulateFight();
    
}
}
