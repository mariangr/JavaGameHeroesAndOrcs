package javagame;

import java.util.Random;

public class Fight {
    private Hero hero;
    private Orc orc;
    private static Random rand = new Random();
    
    public Fight (Hero hero, Orc orc){
        this.hero=hero;
        this.orc=orc;
    }
    
    public void simulateFight(){
        int turn=0;
        int chance = rand.nextInt(100);
        if(chance < 50)
            turn = 1;
        while(hero.isAlive()&&orc.isAlive()){
            if(turn==0){
                int orcAttack = orc.attack();
                hero.takeDamage(orcAttack);
                System.out.println("The Orc attacked the Hero and took " + orcAttack + " damage.");
                System.out.println("The hero is left with " + hero.getHealth() + " health.");
                turn=1;
            }
            else{
                orc.takeDamage(hero.attack());
                System.out.println("The Hero attacked the Orc and took " + hero.attack() + " damage.");
                System.out.println("The Orc is left with " + orc.getHealth() + " health.");
                turn=0;
        
            }
        }
        if(hero.isAlive())System.out.println("The Orc was defeated.");
        else System.out.println("The Hero was defeated.");
    }
    
    
}
