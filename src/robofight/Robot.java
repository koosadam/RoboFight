package robofight;

public interface Robot {
    
    public Field getOwnPosition();
    public Field getEnemyPosition();
    public int[] getSizeArena();
    public int getOwnArmour();
    public int getEnemyArmour();
    
    public void move(Direction dir);
    public void attack(Direction dir);
    public void defend(Direction dir);
    public void stand();
    
}
