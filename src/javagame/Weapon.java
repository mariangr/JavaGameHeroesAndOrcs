package javagame;

import java.util.Random;

public class Weapon {
    private String type;
    private int damage;
    private float criticalStrikePercent;
    private static Random rand = new Random();
    
    
    public Weapon(String type, int damage){
        this.damage=damage;
        this.type=type;
    }
    
    public boolean criticalHit(){
        criticalStrikePercent = rand.nextFloat();
        return (criticalStrikePercent>=0.75f);
    }
    
    public int getDamage (){
        if (criticalHit())
            return 2*this.damage;
        
        return this.damage;
    }
     
    
}
