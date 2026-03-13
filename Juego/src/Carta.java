public class Carta {
    private  String color;
    private  String valor;

    public Carta(String color, String valor) {
        this.color = color;
        this.valor = valor;//Constructores
    }

    public String getColor() { return color; }
    public String getValor() { return valor; }//Getters

    @Override
    public String toString() {
        return "[" + color + " " + valor + "]";
    }
}
