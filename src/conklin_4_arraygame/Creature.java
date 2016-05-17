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
    

    public Creature(char symbol, int health, int damage, int positionX, int positionY, boolean alive) {
        this.symbol = symbol;
        this.positionX = positionX;
        this.positionY = positionY;
        this.health = health;
        this.damage = damage;
        this.alive = alive;
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
