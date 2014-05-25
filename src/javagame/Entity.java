package javagame;
public abstract class Entity {
    private String name;
    private int health;
    private int maxHealth;
    private boolean hasWeapon;
    private Weapon weapon;
    
    public Entity(String name, int health) {
    this.name=name;
    this.health=health; 
    this.maxHealth=health;
    this.hasWeapon=false;
    }
    
    public String getName(){
        return this.name;
    }
        
    public int getHealth (){
        return health;
    }
    
    public boolean isAlive(){
        return (health > 0);
    }
    
    public void takeDamage(int damagePoints){
        this.health=this.health-damagePoints;
        if(health < 0)
            health = 0;
    }
    
    public boolean takeHealing(int healthPoints){
        if(isAlive()){
            System.out.println("False. It's too late to heal.");
            return false;
        }
        this.health += healthPoints;
        if(this.health > this.maxHealth)
            this.health = this.maxHealth;
        
        return true;
    }
    
    public boolean hasWeapon(){
        return hasWeapon;
    }
    
    public void equipWeapon (Weapon weapon){
    this.weapon=weapon;
    this.hasWeapon=true;
    }
    
    public abstract int attack();
    
    public Weapon getWeapon(){
        return this.weapon;
    }
}
