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
public abstract class Entity {
    
    char symbol;
    int positionX;
    int positionY;
    boolean alive;
    
    public void move(Grid grid, char[] direction){
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

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    
}
