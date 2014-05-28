package javagame;

import java.io.PrintStream;
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
            int healingChance =0;
            int hchance = rand.nextInt(100);
            if (hchance<=25)
                healingChance=1;
            int healing = rand.nextInt(15);
            
            if(turn==0){
                int orcAttack = orc.attack();
                hero.takeDamage(orcAttack);
                System.out.printf("%s attacked %s and took " + orcAttack + " damage.\n", orc.getName(),hero.getName());
                System.out.printf("%s is left with " + hero.getHealth() + " health.\n", hero.getName());
                
                if(healingChance==1){
                    boolean aliveHero = hero.takeHealing(healing);
                    if(aliveHero)System.out.printf("%s took healing and is now with %s health.\n", hero.getName(), hero.getHealth());
                }
                turn=1;
            }
            else{
                orc.takeDamage(hero.attack());
                System.out.printf("%s attacked the %s and took " + hero.attack() + " damage.\n", hero.getName(),orc.getName());
                System.out.printf("%s is left with " + orc.getHealth() + " health.\n",orc.getName());
                turn=0;
                if(healingChance==1){
                    boolean aliveOrc = orc.takeHealing(healing);
                    if(aliveOrc){
                        System.out.printf("%s took healing and is now with %s health.\n", orc.getName(), orc.getHealth());
                        
                    }
                }        
        
            }
        }
        if(hero.isAlive())System.out.println("The Orc was defeated.");
        else System.out.println("The Hero was defeated.");
    }
    
    
}
