package javagame;

import java.util.Random;

public class Orc extends Entity{

    
    private static Random rand = new Random();
    private float berserkFactor = rand.nextFloat()*2;
    
    public Orc(String name, int health){
        super(name, health);
    }
    
    @Override
    public int attack(){
        if (hasWeapon())
            return (int) (this.berserkFactor*getWeapon().getDamage());
        return 0;
    }
    
}
