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

    Player player = new Player('@', 5, 1, 0, 0, true);
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

    public void calculateDamage(Player player, ArrayList<Enemy> enemies, ArrayList<Trap> traps) {
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

        }
    }

    public void update(Grid g) {

        char[] direction = userInputDirection();
        player.move(g, direction);
        squadMovement(g, player, (Enemy[]) enemies.toArray());
        calculateDamage(player, enemies, traps);

        g.setCharAt(player.getPositionX(), player.getPositionY(), player.getSymbol());
        updatePositions(g, (Enemy[]) enemies.toArray());
        updatePositions(g, (Trap[]) traps.toArray());
        updatePositions(g, (Treasure[]) treasures.toArray());

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

    public void assignCoords(Grid g, Entity[] e) {
        boolean check;
        for (int i = 0; i < e.length; i++) {
            check = false;
            while (check) {
                e[i].setPositionX(random.nextInt(g.getWidth()));
                e[i].setPositionY(random.nextInt(g.getHeight()));
                for (int j = 0; j < coords.size(); j++) {
                    if (coords.get(j)[0] == e[i].getPositionX() && coords.get(j)[1] == e[i].getPositionY()) {
                        check = true;
                    }
                }

            }
            int[] currentCoord = new int[2];
            currentCoord[0] = e[i].getPositionX();
            currentCoord[1] = e[i].getPositionY();
            coords.add(currentCoord);

        }
    }

    public void init(Grid g) {
          assignCoords(g, (Entity []) enemies.toArray());
          assignCoords(g, (Entity []) traps.toArray());
          assignCoords(g, (Entity []) treasures.toArray());
    }

    public void runGame() {
        playgame = true;
        Grid grid = new Grid(15, 15, '.');
        while (playgame) {
            grid.print();
            printStats(player);
            update(grid);
            if (player.getTreasuresCollected() >= treasures.size() / 2) {
                endGame(false);
            }
            if (player.getHealth() <= 0) {
                endGame(false);
            }
        }
    }

}
