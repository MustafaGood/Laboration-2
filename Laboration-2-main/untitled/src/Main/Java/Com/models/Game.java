package Main.Java.Com.models;

import java.util.Scanner;

public class Game {
    // Maze- och Player-objekten som representerar labyrinten och spelaren
    private Maze maze;
    private Player player;

    // Konstruktor för att skapa ett nytt spel med en viss storlek på labyrinten
    public Game(int size) {
        // Skapa en ny Maze (labyrint) av given storlek
        this.maze = new Maze(size, size);
        // Skapa en ny Player (spelare) som startar på position (1, 1) i labyrinten
        this.player = new Player("Hero", 1, 1);
    }

    // Metod för att starta spelet och hantera spelets huvudloop
    public void startGame() {
        // Try-with-resources används för att säkerställa att scannern stängs korrekt efter spelets slut
        try (Scanner scanner = new Scanner(System.in)) {
            // Skriver ut labyrinten och spelarens position
            maze.printMaze(player);

            // En oändlig loop för att hantera spelarens rörelser tills spelet avslutas
            while (true) {
                // Fråga spelaren efter ett drag: W, A, S, D för rörelser eller EXIT för att avsluta
                System.out.println("Enter move (W, A, S, D or EXIT to quit): ");
                String move = scanner.nextLine().toUpperCase(); // Läser in användarens inmatning och gör den versal

                // Om spelaren skriver "EXIT" avslutas spelet
                if (move.equals("EXIT")) {
                    System.out.println("Exiting the game...");
                    break;
                }

                // Initialisera förflyttningsvärdena till 0
                int dx = 0, dy = 0;

                // Bestäm riktning baserat på användarens inmatning
                switch (move) {
                    case "W": // Flytta uppåt
                        dy = -1;
                        break;
                    case "S": // Flytta neråt
                        dy = 1;
                        break;
                    case "A": // Flytta vänster
                        dx = -1;
                        break;
                    case "D": // Flytta höger
                        dx = 1;
                        break;
                    default:
                        // Om inmatningen inte är giltig, visa felmeddelande
                        System.out.println("Invalid move");
                        continue; // Hoppa över resten av loopen och fråga om ny inmatning
                }

                // Flytta spelaren i den riktning som användaren valde
                player.move(dx, dy, maze);

                // Skriv ut labyrinten igen efter varje förflyttning
                maze.printMaze(player);
            }
        } // Scannern stängs automatiskt när try-blocket avslutas
    }

    public static void main(String[] args) {
        Game game = new Game(10);  // Starta spelet med en labyrint av storlek 10x10
        game.startGame();          // Starta spelets loop
    }
}

