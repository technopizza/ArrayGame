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
    boolean playgame;

    int numberOfEnemies = 2;
    int numberOfTraps = 10;
    int numberOfTreasures = 10;

    Player player = new Player('☺', 5, 1, true);
    ArrayList<Enemy> enemies = new ArrayList();
    ArrayList<Trap> traps = new ArrayList();
    ArrayList<Treasure> treasures = new ArrayList();
    ArrayList<int[]> coords = new ArrayList();

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

    
    
    public void updatePositions(Grid g, Entity entity) {

        if (entity.isAlive()) {
            g.setCharAt(entity.getPositionX(), entity.getPositionY(), entity.getSymbol());
        }
        //g.setCharAt(entity.getPositionX(), entity.getPositionY(), entity.getSymbol());

    }
    
    public void updatePositions(Grid g, Creature entity) {

        if (entity.isAlive()) {
            g.setCharAt(entity.getPositionX(), entity.getPositionY(), entity.getSymbol());
        }
        if(!(entity.getPositionXPrevious() == entity.getPositionX() && entity.getPositionYPrevious() == entity.getPositionY())){
            g.setCharAt(entity.getPositionXPrevious(), entity.getPositionYPrevious(), g.getFillChar());
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

    public void squadMovement(Grid g, Entity player, Entity squadmember) {
        
            squadmember.move(g, getFollowDirection(player, squadmember));

        
    }

    public boolean isIntersect(Entity entity1, Entity entity2) {
        if ((entity1.getPositionX() == entity2.getPositionX()) && (entity1.getPositionY() == entity2.getPositionY())
                && (entity1.isAlive() && entity2.isAlive())) {
            return true;
        }
        return false;
    }

    public void calculateDamage(Player player, ArrayList<Enemy> enemies, ArrayList<Trap> traps) {
        
        
        for (int j = 0; j < traps.size(); j++) {
                if (isIntersect(traps.get(j), player)) {
                    traps.get(j).setAlive(false);
                    player.setHealth(player.getHealth() - traps.get(j).getDamage());
                }

            }
            for (int j = 0; j < treasures.size(); j++) {
                if (isIntersect(treasures.get(j), player)) {
                    treasures.get(j).setAlive(false);
                    player.setTreasuresCollected(player.getTreasuresCollected() + 1);
                }

            }
        
        for (int i = 0; i < enemies.size(); i++) {
            if (isIntersect(player, enemies.get(i))) {
                enemies.get(i).setAlive(false);
                player.setHealth(player.getHealth() - enemies.get(i).getDamage());
            }
            for (int j = 0; j < traps.size(); j++) {
                if (isIntersect(traps.get(j), enemies.get(i))) {
                    traps.get(j).setAlive(false);
                    enemies.get(i).setHealth(enemies.get(i).getHealth() - traps.get(j).getDamage());
                }

            }
            for (int j = 0; j < treasures.size(); j++) {
                if (isIntersect(treasures.get(j), enemies.get(i))) {
                    treasures.get(j).setAlive(false);
                    
                }

            }

        }
    }

    public void update(Grid g) {

        char[] direction = userInputDirection();
        player.move(g, direction);
        for (int i = 0; i < numberOfEnemies; i++) {
            squadMovement(g, player, enemies.get(i));
            
        }
        
        calculateDamage(player, enemies, traps);

        
    }

    public void updateChars(Grid g) {

        

        updatePositions(g, player);
        for (int i = 0; i < numberOfEnemies; i++) {

            updatePositions(g, enemies.get(i));

        }
        for (int i = 0; i < numberOfTreasures; i++) {

            updatePositions(g, treasures.get(i));

        }

        for (int i = 0; i < numberOfTraps; i++) {

            updatePositions(g, traps.get(i));

        }
    }
    
    public void endGame(boolean win) {
        printEmptyLines(10);
        if (win) {
            System.out.println("\\ \\ / / _ \\| | | | \\ \\      / /_ _| \\ | |\n"
                    + " \\ V / | | | | | |  \\ \\ /\\ / / | ||  \\| |\n"
                    + "  | || |_| | |_| |   \\ V  V /  | || |\\  |\n"
                    + "  |_| \\___/ \\___/     \\_/\\_/  |___|_| \\_|");
        } else {

            System.out.print("\\ \\ / / _ \\| | | | | |   / _ \\/ ___|| ____|\n"
                    + " \\ V / | | | | | | | |  | | | \\___ \\|  _|  \n"
                    + "  | || |_| | |_| | | |__| |_| |___) | |___ \n"
                    + "  |_| \\___/ \\___/  |_____\\___/|____/|_____|");
        }
        playgame = false;
    }

    public static void printStats(Player p) {
        System.out.println("Health: " + p.getHealth() + "\nEnemies Killed: " + p.getEnemiesKilled() + "\nTreasures Collected: " + p.getTreasuresCollected());
    }

    public void assignCoords(Grid g, Entity e) {
        boolean check;

        check = true;
        while (check) {
            check = false;
            e.setPositionX(random.nextInt(g.getWidth()));
            e.setPositionY(random.nextInt(g.getHeight()));
            if (!coords.isEmpty()) {
                for (int j = 0; j < coords.size(); j++) {
                    if (coords.get(j)[0] == e.getPositionX() && coords.get(j)[1] == e.getPositionY()) {
                        check = true;
                    }
                }
                

            }
        }
        int[] currentCoord = new int[2];
        currentCoord[0] = e.getPositionX();
        currentCoord[1] = e.getPositionY();
        coords.add(currentCoord);

    }

    public void init(Grid g) {

        assignCoords(g, player);
        
        for (int i = 0; i < numberOfEnemies; i++) {

            enemies.add(new Enemy('▲', 1, 1, true));
            assignCoords(g, enemies.get(i));

        }
        for (int i = 0; i < numberOfTreasures; i++) {

            treasures.add(new Treasure('⚑', 1, true));
            assignCoords(g, treasures.get(i));

        }

        for (int i = 0; i < numberOfTraps; i++) {

            traps.add(new Trap('☒', 1, true));
            assignCoords(g, traps.get(i));

        }
    }

    public void runGame() {
        playgame = true;
        Grid grid = new Grid(15, 15, '□');

        init(grid);
updateChars(grid);
        while (playgame) {
            grid.print();
            printStats(player);
            update(grid);
            updateChars(grid);
            if (player.getTreasuresCollected() >= treasures.size() / 2) {
                endGame(false);
            }
            if (player.getHealth() <= 0) {
                endGame(false);
            }
        }
    }

}
