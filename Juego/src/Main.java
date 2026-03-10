public class Main {
    public static void main(String[] args) {
        ModeloVista vista = new ModeloVista();
        Controlador juego = new Controlador(vista);
        juego.iniciarJuego();
    }
}