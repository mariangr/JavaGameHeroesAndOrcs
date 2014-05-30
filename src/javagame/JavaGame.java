package javagame;

public class JavaGame {
     
    public static Map map = new Map(10);
    
    public static void main(String[] args) {
        Map map = Map.readFromFile("C:\\Users\\Hueco Mundo\\Desktop\\map.txt");
        System.out.println(map);
        /*
        Hero hero = new Hero("Byron",100,"Black",0,0);
        Orc orc = new Orc("Smeagle",100,5,5);
        
        
        Weapon heroWeapon = new Weapon("Needle",5);
        Weapon orcWeapon = new Weapon("Boomerang",5);
        
        hero.equipWeapon(heroWeapon);
        orc.equipWeapon(orcWeapon);
        
        map.addEntity(0, 0, hero);
        map.addEntity(5, 5, orc);
        
        System.out.println(map);
        
        hero.move(3, 2);
        map.addObsticle(3, 3);
        
        System.out.println(map);
        Fight game = new Fight(hero,orc);
        game.simulateFight();
                */
    }
}
