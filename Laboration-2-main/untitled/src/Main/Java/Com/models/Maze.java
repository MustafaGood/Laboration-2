package Main.Java.Com.models;

public class Maze {
    // Skapar en tvådimensionell array som representerar labyrintens struktur
    private char[][] mazeStructure;

    // Konstruktor som skapar labyrinten
    public Maze(int width, int height) {
        mazeStructure = new char[width][height]; // Skapar en labyrint med specifik bredd och höjd

        // Skapar en enkel labyrint där ytterväggarna är 'W' och resten är gångar '.'
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i == 0 || i == width - 1 || j == 0 || j == height - 1) {
                    mazeStructure[i][j] = 'W'; // 'W' står för väggar
                } else {
                    mazeStructure[i][j] = '.'; // '.' står för gångar där spelaren kan gå
                }
            }
        }
    }

    // Kollar om en viss position i labyrinten är gångbar (alltså om spelaren kan gå dit)
    public boolean isWalkable(int x, int y) {
        // Kollar om positionen är utanför labyrintens gränser
        if (x < 0 || y < 0 || x >= mazeStructure.length || y >= mazeStructure[0].length) {
            return false; // Returnerar falskt om positionen är utanför
        }
        // Returnerar sant om spelaren kan gå till positionen, annars falskt
        return mazeStructure[x][y] == '.';
    }

    // Skriver ut labyrinten och spelarens position
    public void printMaze(Player player) {
        // Går igenom varje rad i labyrinten
        for (int i = 0; i < mazeStructure.length; i++) {
            // Går igenom varje kolumn i varje rad
            for (int j = 0; j < mazeStructure[i].length; j++) {
                // Om spelarens position är samma som (i, j), skriv ut 'P' för att visa var spelaren är
                if (i == player.getX() && j == player.getY()) {
                    System.out.print("P "); // 'P' står för spelaren
                } else {
                    // Annars skriv ut antingen en vägg ('W') eller en gång ('.') från labyrintens struktur
                    System.out.print(mazeStructure[i][j] + " ");
                }
            }
            System.out.println(); // Hoppar till nästa rad efter att en rad är utskriven
        }
    }
}
