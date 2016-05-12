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
public class Player extends Creature {

    private int enemiesKilled;
    private int treasuresCollected;

    Player(char symbol, int health, int damage, int positionX, int positionY) {
        super(symbol, health, damage, positionX, positionY);
        enemiesKilled = 0;
        treasuresCollected = 0;
    }

    public int getEnemiesKilled() {
        return enemiesKilled;
    }

    public void setEnemiesKilled(int enemiesKilled) {
        this.enemiesKilled = enemiesKilled;
    }

    public int getTreasuresCollected() {
        return treasuresCollected;
    }

    public void setTreasuresCollected(int treasuresCollected) {
        this.treasuresCollected = treasuresCollected;
    }

}
