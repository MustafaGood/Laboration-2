package Main.Java.Com.models;

// En abstrakt klass som beskriver ett föremål i spelet.
// Eftersom klassen är abstrakt kan vi inte skapa objekt direkt från den,
// men andra klasser (som t.ex. Skatt eller Uppgradering) kan ärva från den och lägga till sina egna detaljer.
public abstract class Item {

    // Dessa variabler (x och y) visar föremålets position i labyrinten.
    // De är skyddade, vilket betyder att de kan användas av andra klasser som ärver från Item.
    protected int x, y;

    // Konstruktorn sätter var föremålet är i labyrinten med hjälp av x- och y-koordinater.
    // Alla klasser som ärver från Item behöver använda denna konstruktor för att placera föremålet.
    public Item(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // En abstrakt metod som måste skrivas av alla klasser som ärver från Item.
    // Metoden beskriver vad som händer när föremålet används av spelaren.
    // T.ex. kan klassen "Skatt" göra så att spelaren plockar upp skatten när metoden används.
    public abstract void use(Player player);
}
