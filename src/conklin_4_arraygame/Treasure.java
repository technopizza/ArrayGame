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
public class Treasure extends Entity {
    private int score;

    public Treasure(char symbol, int score, boolean alive) {
        this.symbol = symbol;
        this.score = score;
        this.alive = true;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
}
