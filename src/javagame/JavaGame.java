package javagame;

import java.util.Random;

public class JavaGame {
     
    public static Map map = Map.readFromFile("map.txt");
    public static Random rand = new Random();
    
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
        
        int chance = rand.nextInt(100);
        int turn = 0;
        if(chance < 50) {
            turn = 1;
        }
        
        while(!map.areClose(hero, orc)) {
            if (turn==1){
                System.out.printf("%s moved.\n",hero.knowsAs());
                hero.automaticMove();
                turn = 0;
            } else if (turn==0){
                System.out.printf("%s moved.\n",orc.getName());
                orc.automaticMove();
                turn = 1;
            }
            System.out.println(JavaGame.map);
        }
        
        Fight game = new Fight(hero,orc);
        game.simulateFight();
        
    }
}
