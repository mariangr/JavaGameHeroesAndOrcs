package javagame;

public class JavaGame {
     
    public static Map map = Map.readFromFile("map.txt");
    
    public static void main(String[] args) {
        System.out.println(map);
        
        Hero hero = new Hero("Byron",100,"Black",0,0);
        Orc orc = new Orc("Smeagle",100,5,5);
        
        Weapon heroWeapon = new Weapon("Needle",5);
        Weapon orcWeapon = new Weapon("Boomerang",5);
        
        hero.equipWeapon(heroWeapon);
        orc.equipWeapon(orcWeapon);
        
        map.placeEntity(hero);
        map.placeEntity(orc);
        
        Fight game = new Fight(hero,orc);
        game.moveOnMap();
        
    }
}
