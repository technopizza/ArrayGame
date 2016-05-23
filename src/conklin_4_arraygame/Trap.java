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

    public Trap(char symbol, int damage, boolean alive) {
        this.symbol = symbol;
        this.damage = damage;
        this.alive = true;
    }

    
    
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
}
