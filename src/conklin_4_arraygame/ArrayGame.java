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

    ArrayList<Entity> players = new ArrayList();
    ArrayList<Entity> enemies = new ArrayList();
    ArrayList<Entity> traps = new ArrayList();
    ArrayList<Entity> treasures = new ArrayList();

    public static void printEmptyLines(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("");
        }
    }

    public void moveEntities(Grid g, ArrayList<Entity> entities, char[] direction) {

        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).move(g, direction);
        }

    }

    public void updatePositions(Grid g, ArrayList<Entity> entities) {

        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).isAlive()) {
                g.setCharAt(entities.get(i).getPositionX(), entities.get(i).getPositionY(), entities.get(i).getSymbol());
            }

        }

    }

    public char[] userInputDirection() {
        System.out.println("Which direction do you want to travel?");
        String output = scanner.next();
        output = output.toUpperCase();
        return output.toCharArray();
    }

    public char[] getFollowDirection(Entity player, Entity enemy) {
        String direction = "";
        if (player.getPositionX() > enemy.getPositionX()) {
            direction += "E";
        } else if (player.getPositionX() < enemy.getPositionX()) {
            direction += "W";
        }
        if (player.getPositionY() > enemy.getPositionY()) {
            direction += "S";
        } else if (player.getPositionY() < enemy.getPositionY()) {
            direction += "N";
        }

        return direction.toCharArray();
    }

    public void squadMovement(Grid g, Entity player, ArrayList<Entity> squad) {
        for (int i = 0; i < squad.size(); i++) {
            squad.get(i).move(g, getFollowDirection(player, squad.get(i)));

        }
    }

    public boolean isIntersect(Entity entity1, Entity entity2) {
        if ((entity1.getPositionX() == entity2.getPositionX()) && (entity1.getPositionY() == entity2.getPositionY())
                && (entity1.isAlive() && entity2.isAlive())) {
            return true;
        }
        return false;
    }

    
    
    public void update(Grid g) {

        char[] direction = userInputDirection();
        moveEntities(g, players, direction);
        squadMovement(g, players.get(0), enemies);
        for (int i = 0; i < enemies.size(); i++) {
            char e = direction[i];
            
        }
        
        
        updatePositions(g, players);
        updatePositions(g, enemies);
        updatePositions(g, traps);
        updatePositions(g, treasures);

    }

}
