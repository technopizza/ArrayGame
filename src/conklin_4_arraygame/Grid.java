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
public class Grid {

    private int width;
    private int height;
    private char fillChar;
    private char[][] gridMap;

    public Grid(int width, int height, char fillChar) {
        this.width = width;
        this.height = height;
        this.fillChar = fillChar;
        gridMap = new char[width][height];
    }

    public void print() {
        for (int i = 0; i < gridMap.length; i++) {
            System.out.println();
            for (int j = 0; j < gridMap[i].length; j++) {
                System.out.print(gridMap[i][j]);
            }
        }
    }
}
