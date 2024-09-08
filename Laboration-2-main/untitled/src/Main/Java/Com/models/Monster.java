package Main.Java.Com.models;

import Main.Java.Com.interfaces.Movable;
import Main.Java.Com.interfaces.Obstacle;

// Klassen Monster ärver från Item och implementerar Movable (rörlig) och Obstacle (hinder)
public class Monster extends Item implements Movable, Obstacle {
    // Attribut för monstret
    private int health;   // Monstrets hälsa
    private int strength; // Monstrets styrka

    // Konstruktor för att skapa ett monster på en viss plats (x, y)
    public Monster(int x, int y) {
        super(x, y);  // Anropar konstruktorn i Item (x, y)
        this.health = 50;   // Sätter monstrets start-hälsa till 50
        this.strength = 15; // Sätter monstrets start-styrka till 15
    }

    // Implementerar metoden för att flytta monstret (från Movable)
    @Override
    public void move(int dx, int dy, Maze maze) {
        // Här kommer logiken för att flytta monstret
    }

    // Minskar monstrets hälsa när det tar skada
    public void decreaseHealth(int damage) {
        this.health -= damage;  // Drar av skadan från monstrets hälsa
        System.out.println("Monstret tar " + damage + " skada, återstående hälsa: " + this.health);

        // Om hälsan går under eller lika med 0, är monstret besegrat
        if (this.health <= 0) {
            System.out.println("Monstret är besegrat!");
        }
    }

    // Implementerar hur monstret används när spelaren stöter på det (från Obstacle)
    @Override
    public void use(Player player) {
        System.out.println("Du möter ett monster!");
        player.takeDamage(this.strength); // Spelaren tar skada baserat på monstrets styrka
        System.out.println("Monstret attackerar med styrka " + this.strength);
    }

    // Implementerar om monstret fungerar som ett hinder (från Obstacle)
    @Override
    public boolean isBlocking() {
        return true; // Monstret blockerar vägen (är ett hinder)
    }
}
