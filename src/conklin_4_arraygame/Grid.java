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
        for (int i = 0; i < gridMap.length; i++) {
            for (int j = 0; j < gridMap[i].length; j++) {
                gridMap[i][j] = fillChar;
            }
            
        }
    }

    public void print() {
        System.out.print("┏");
        for (int i = 0; i < gridMap.length; i++) {
            System.out.print("━━");

        }
        System.out.print("┓");

        for (int i = 0; i < gridMap.length; i++) {
            System.out.println();
            System.out.print("┃");
            for (int j = 0; j < gridMap[i].length; j++) {
                System.out.print(gridMap[i][j] + " ");
            }
            System.out.print("┃");
        }

        System.out.print("\n┗");
        for (int i = 0; i < gridMap.length; i++) {
            System.out.print("━━");

        }
        System.out.print("┛\n");

    }

    public void clearGrid() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                setCharAt(i, j, fillChar);

            }

        }
    }

    public void setCharAt(int x, int y, char c) {
        gridMap[x][y] = c;
    }

    public char getCharAt(int x, int y) {
        return gridMap[x][y];
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char getFillChar() {
        return fillChar;
    }

    public void setFillChar(char fillChar) {
        this.fillChar = fillChar;
    }

    public char[][] getGridMap() {
        return gridMap;
    }

    public void setGridMap(char[][] gridMap) {
        this.gridMap = gridMap;
    }
}
