import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private List<Carta> mano;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
    }

    public void recibirCarta(Carta c) { mano.add(c); }

    public List<Carta> getMano() { return mano; }

    public String getNombre() { return nombre; }

    public Carta jugarCarta(int indice) {
        return mano.remove(indice);
    }
}
