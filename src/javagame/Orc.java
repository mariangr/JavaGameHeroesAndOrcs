package javagame;
public class Orc extends Entity{

    private float berserkFactor;
    
    public Orc(String name, int health, float berserk_factor){
        super(name, health);
        if (berserk_factor<1)
            this.berserkFactor=1f;
        else if (berserkFactor>2)
            this.berserkFactor=2f;
        else this.berserkFactor=berserk_factor;
        
    }
    
    @Override
    public int attack(){
        if (hasWeapon())
            return (int) (this.berserkFactor*getWeapon().getDamage());
        
        return 0;
    }
    
}
