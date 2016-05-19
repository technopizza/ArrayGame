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

    Player player = new Player('@', 5, 1, 0, 0, true);
    ArrayList<Enemy> enemies = new ArrayList();
    ArrayList<Trap> traps = new ArrayList();
    ArrayList<Treasure> treasures = new ArrayList();

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

    public void updatePositions(Grid g, Entity[] entities) {

        for (int i = 0; i < entities.length; i++) {
            if (entities[i].isAlive()) {
                g.setCharAt(entities[i].getPositionX(), entities[i].getPositionY(), entities[i].getSymbol());
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

    public void squadMovement(Grid g, Entity player, Entity[] squad) {
        for (int i = 0; i < squad.length; i++) {
            squad[i].move(g, getFollowDirection(player, squad[i]));

        }
    }

    public boolean isIntersect(Entity entity1, Entity entity2) {
        if ((entity1.getPositionX() == entity2.getPositionX()) && (entity1.getPositionY() == entity2.getPositionY())
                && (entity1.isAlive() && entity2.isAlive())) {
            return true;
        }
        return false;
    }

    public void calculateDamage(Player player, ArrayList<Enemy> enemies, ArrayList<Trap> traps){
        for (int i = 0; i < enemies.size(); i++) {
            if(isIntersect(player, enemies.get(i))){
                enemies.get(i).setAlive(false);
                player.setHealth(player.getHealth() - enemies.get(i).getDamage());
            }
            for (int j = 0; j < traps.size(); j++) {
                if(isIntersect(traps.get(j), enemies.get(i))){
                    traps.get(j).setAlive(false);
                    enemies.get(i).setHealth(enemies.get(i).getHealth() - traps.get(j).getDamage());
                }
                
            }
            
        }
    }
    
    public void update(Grid g) {

        char[] direction = userInputDirection();
        player.move(g, direction);
        squadMovement(g, player, enemies.toArray());
        calculateDamage(player, enemies, traps);
        
        
        g.setCharAt(player.getPositionX(), player.getPositionY(), player.getSymbol());
        updatePositions(g, enemies.toArray());
        updatePositions(g, traps.toArray());
        updatePositions(g, treasures.toArray());

    }

}