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

    Player(char symbol, int health, int damage, boolean alive) {
        super(symbol, health, damage, alive);
        enemiesKilled = 0;
        treasuresCollected = 0;
    }

    @Override
    public void move(Grid grid, char[] direction) {
        this.setPositionXPrevious(this.getPositionX());
        this.setPositionYPrevious(this.getPositionY());
        for (int i = 0; i < direction.length; i++) {
            switch (direction[i]) {
                case 'R':
                    if (this.getTreasuresCollected() > 0) {
                        this.setTreasuresCollected(this.getTreasuresCollected() - 1);

                        ArrayGame.revealCounter = 5;
                    }

                    break;
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
