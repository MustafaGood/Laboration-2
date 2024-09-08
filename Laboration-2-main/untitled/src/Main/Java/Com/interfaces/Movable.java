package Main.Java.Com.interfaces; // Paketet som innehåller interface (ett "kontrakt" för klasser)

import Main.Java.Com.models.Maze; // Importerar klassen Maze (labyrinten) för att använda den i interface

// Interface som beskriver att något kan röra på sig (t.ex. spelaren eller ett monster)
public interface Movable {

    // Metod som låter ett objekt röra sig.
    // dx och dy är förflyttningen i x- och y-led (höger/vänster och upp/ner)
    // maze är labyrinten som objektet rör sig inom, används för att kontrollera att objektet inte går genom väggar.
    void move(int dx, int dy, Maze maze);
}
