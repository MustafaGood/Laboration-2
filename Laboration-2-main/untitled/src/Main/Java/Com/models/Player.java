package Main.Java.Com.models;

import Main.Java.Com.interfaces.Movable;
import java.util.ArrayList;

// Klassen Player representerar spelaren och implementerar Movable, vilket betyder att spelaren kan röra sig.
public class Player implements Movable {
    // Attribut (egenskaper) för spelaren: namn, position (x, y), hälsa, styrka, och en lista över objekt (inventory)
    private String name; // Spelarens namn
    private int x, y; // Spelarens position i labyrinten (x är horisontellt, y är vertikalt)
    private int health; // Spelarens hälsa (100 från början)
    private int strength; // Spelarens styrka (hur mycket skada spelaren kan göra)
    private ArrayList<Item> inventory; // Spelarens "ryggsäck" där föremål (Items) lagras

    // Konstruktor för att skapa en ny spelare med ett namn och startposition (x, y)
    public Player(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.health = 100; // Startar med 100 hälsopoäng
        this.strength = 10; // Startar med styrkan 10
        this.inventory = new ArrayList<>(); // Skapar en tom lista för att lagra föremål
    }

    // Metod för att lägga till ett objekt (Item) i spelarens inventarium
    public void addItem(Item item) {
        inventory.add(item); // Lägger till föremålet i spelarens "ryggsäck"
    }

    // Överskuggar (override) metoden move från Movable-interfacet
    // dx och dy anger hur långt spelaren ska flytta sig i x- och y-led
    @Override
    public void move(int dx, int dy, Maze maze) {
        // Kollar om spelaren kan gå till den nya positionen i labyrinten
        if (maze.isWalkable(x + dx, y + dy)) {
            this.x += dx; // Uppdaterar spelarens x-position
            this.y += dy; // Uppdaterar spelarens y-position
            System.out.println(name + " flyttade till (" + x + ", " + y + ")");
        } else {
            System.out.println(name + " gick in i en vägg!"); // Meddelande om spelaren försökte gå in i en vägg
        }
    }

    // Metod för att spelaren ska attackera ett monster
    public void attack(Monster monster) {
        System.out.println(name + " attackerar monstret med styrka " + strength);
        monster.decreaseHealth(strength); // Minskar monstrens hälsa med spelarens styrka
    }

    // Metod för att spelaren ska ta skada
    public void takeDamage(int damage) {
        this.health -= damage; // Minskar spelarens hälsa
        System.out.println(name + " tar " + damage + " i skada, återstående hälsa: " + health);
    }

    // Getter-metod för att få spelarens hälsa
    public int getHealth() {
        return health;
    }

    // Setter-metod för att ändra spelarens hälsa
    public void setHealth(int health) {
        this.health = health;
    }

    // Getter-metod för att få spelarens styrka
    public int getStrength() {
        return strength;
    }

    // Setter-metod för att ändra spelarens styrka
    public void setStrength(int strength) {
        this.strength = strength;
    }

    // Getter-metod för att få spelarens x-position
    public int getX() {
        return x;
    }

    // Getter-metod för att få spelarens y-position
    public int getY() {
        return y;
    }

    // Metod för att visa föremålen i spelarens inventarium
    public void showInventory() {
        System.out.println("Inventarium:");
        for (Item item : inventory) {
            System.out.println(item.getClass().getSimpleName()); // Skriver ut namnet på varje objekt i inventariet
        }
    }
}
