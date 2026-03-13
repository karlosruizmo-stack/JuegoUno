import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controlador {
    private List<Carta> mazo;
    private List<Jugador> jugadores;
    private Carta cartaEnMesa;
    private ModeloVista vista;
    private int turnoActual = 0;

    public Controlador(ModeloVista vista) {
        this.vista = vista;
        this.mazo = generarMazo();
        this.jugadores = new ArrayList<>();
        Collections.shuffle(mazo);//El suffel sirve para mezclar las cartas
    }
//Aqui nos crea las cartas
    private List<Carta> generarMazo() {
        List<Carta> nuevoMazo = new ArrayList<>();
        String[] colores = {"Rojo", "Azul", "Verde", "Amarillo"};
        String[] valores = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (String c : colores) {
            for (String v : valores) {
                nuevoMazo.add(new Carta(c, v));
            }
        }
        return nuevoMazo;
    }

    public void iniciarJuego() {
        jugadores.add(new Jugador("Jugador 1"));
        jugadores.add(new Jugador("Jugador 2"));

        // Esto nos reparte las 7 cartas
        for (Jugador j : jugadores) {
            for (int i = 0; i < 7; i++) j.recibirCarta(mazo.remove(0));
        }

        cartaEnMesa = mazo.remove(0);
//Esto es lo que genera el bucle hasta que alguien gana
        while (true) {
            Jugador actual = jugadores.get(turnoActual);
            vista.mostrarEstado(actual.getNombre(), cartaEnMesa, actual.getMano());
            int opc = vista.pedirOpcion();
//Interfaz
            if (opc == 99) {
                actual.recibirCarta(mazo.remove(0));
            } else if (opc >= 0 && opc < actual.getMano().size()) {
                Carta elegida = actual.getMano().get(opc);
                if (validarJugada(elegida)) {
                    cartaEnMesa = actual.jugarCarta(opc);
                    if (actual.getMano().isEmpty()) {
                        vista.mostrarMensaje("¡" + actual.getNombre() + " HA GANADO!");
                        break;
                    }
                } else {
                    vista.mostrarMensaje("No puedes hacer eso");
                    continue;
                }
            }
            turnoActual = (turnoActual + 1) % jugadores.size();
        }
    }
//Aqui se hace la validación para que coincida en el juego
    private boolean validarJugada(Carta elegida) {
        return elegida.getColor().equals(cartaEnMesa.getColor()) ||
                elegida.getValor().equals(cartaEnMesa.getValor());
    }
}
