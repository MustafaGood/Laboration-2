package Main.Java.Com.models;

// Klassen Treasure (Skatt) ärver från Item (Föremål)
public class Treasure extends Item {

    // Konstruktor för att skapa en skatt på en specifik position (x, y)
    public Treasure(int x, int y) {
        super(x, y);  // Anropar Item-klassen för att sätta positionen
    }

    // Överskriver (ersätter) use-metoden för att hantera vad som händer när spelaren hittar en skatt
    @Override
    public void use(Player player) {
        // Meddelande som skrivs ut när spelaren hittar skatten
        System.out.println("You found a treasure!");  // Text som visas när en skatt hittas

        // Lägg till skatten i spelarens inventarium (föremålssamling)
        player.addItem(this);  // Lägger till skatten (detta objekt) till spelarens föremål
    }
}
