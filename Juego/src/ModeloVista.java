import java.util.List;
import java.util.Scanner;

public class ModeloVista {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarEstado(String nombreJugador, Carta centro, List<Carta> mano) {
        System.out.println("\n TURNO DE: " + nombreJugador + " ---");
        System.out.println("Carta en mesa: " + centro);
        System.out.println("Tu mano:");
        for (int i = 0; i < mano.size(); i++) {
            System.out.println(i + ". " + mano.get(i));
        }
        System.out.println("99. Robar carta");
    }

    public int pedirOpcion() {
        System.out.print("Elige una opción: ");
        return scanner.nextInt();
    }
}
