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
public class Wall extends Entity {
     public Wall(char symbol, boolean alive) {
        this.symbol = symbol;
        this.alive = true;
    }
}
