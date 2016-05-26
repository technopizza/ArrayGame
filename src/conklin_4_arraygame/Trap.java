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
public class Trap extends Entity{
    private int damage;
    private boolean hidden;

    public Trap(char symbol, int damage, boolean hidden,boolean alive) {
        this.symbol = symbol;
        this.damage = damage;
        this.hidden = hidden;
        this.alive = true;
    }

    
    
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    
}
