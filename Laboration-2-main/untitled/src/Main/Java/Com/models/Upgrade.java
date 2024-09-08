package Main.Java.Com.models;

// Klassen "Upgrade" ärver från "Item" och representerar en uppgradering som spelaren kan hitta
public class Upgrade extends Item {

    // Konstruktor för att skapa en uppgradering på en specifik position (x, y)
    public Upgrade(int x, int y) {
        super(x, y);  // Anropar "Item"-klassens konstruktor för att sätta positionen
    }

    @Override
    public void use(Player player) {
        // När spelaren använder uppgraderingen, skrivs ett meddelande ut
        System.out.println("You found an upgrade!");  // Skriv ut meddelande på skärmen
        // Här kan du uppgradera spelarens egenskaper, till exempel att öka spelarens styrka
        // Du kan lägga till kod här för att ändra spelarens attribut, t.ex. player.increaseStrength();
    }
}
