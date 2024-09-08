// Ett interface som representerar hinder (som väggar eller andra blockeringar) i spelet
// Interface betyder att alla klasser som implementerar detta interface
// måste ha en metod som heter isBlocking().

package Main.Java.Com.interfaces;

public interface Obstacle {

    // En metod som returnerar true eller false.
    // Om metoden returnerar true betyder det att hindret blockerar vägen.
    // Om metoden returnerar false betyder det att det inte blockerar.
    boolean isBlocking();
}
