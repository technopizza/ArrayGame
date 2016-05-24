/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conklin_4_arraygame;

/**
 *
 * @author jconklin2391
 */
public class Creature extends Entity {

    private int positionXPrevious;
    private int positionYPrevious;

    private int health;
    private int damage;
    

    public Creature(char symbol, int health, int damage, boolean alive) {
        this.symbol = symbol;
        this.health = health;
        this.damage = damage;
        this.alive = alive;
    }
    @Override
      public void move(Grid grid, char[] direction){
         this.setPositionXPrevious(this.getPositionX());
         this.setPositionYPrevious(this.getPositionY());
        for (int i = 0; i < direction.length; i++) {
            switch (direction[i]) {
                case 'N':
                    if (!((getPositionX() - 1) < 0)) {
                        setPositionX(getPositionX() - 1);
                    }

                    break;
                case 'S':
                    if (!((getPositionX() + 1) > grid.getHeight() - 1)) {
                        setPositionX(getPositionX() + 1);
                    }
                    break;
                case 'E':
                    if (!((getPositionY() + 1) > grid.getWidth() - 1)) {
                        setPositionY(getPositionY() + 1);
                    }
                    break;
                case 'W':
                    if (!((getPositionY() - 1) < 0)) {
                        setPositionY(getPositionY() - 1);
                    }
                    break;
                default:
                    break;
            }
            
        }
    }
    
    
    public int getPositionXPrevious() {
        return positionXPrevious;
    }

    public void setPositionXPrevious(int positionXPrevious) {
        this.positionXPrevious = positionXPrevious;
    }

    public int getPositionYPrevious() {
        return positionYPrevious;
    }

    public void setPositionYPrevious(int positionYPrevious) {
        this.positionYPrevious = positionYPrevious;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

}
