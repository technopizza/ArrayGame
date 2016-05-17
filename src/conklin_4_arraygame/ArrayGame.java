/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conklin_4_arraygame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jconklin2391
 */
public class ArrayGame {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    ArrayList players = new ArrayList();
    ArrayList enemies = new ArrayList();
    ArrayList traps = new ArrayList();
    ArrayList treasures = new ArrayList();

    public static void printEmptyLines(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("");
        }
    }

    public void moveEntities(Grid g, ArrayList<Entity> entities) {

        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).isAlive()) {
                g.setCharAt(entities.get(i).getPositionX(), entities.get(i).getPositionY(), entities.get(i).getSymbol());
            }

        }

    }
    
    public void updatePositions(Grid g, ArrayList<Entity> entities) {

        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).isAlive()) {
                g.setCharAt(entities.get(i).getPositionX(), entities.get(i).getPositionY(), entities.get(i).getSymbol());
            }

        }

    }

    public void update(Grid g) {

        
        
        updatePositions(g, players);
        updatePositions(g, enemies);
        updatePositions(g, traps);
        updatePositions(g, treasures);

    }

}
