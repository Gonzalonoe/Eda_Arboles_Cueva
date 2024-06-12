
package edaprueba2;

/**
 *
 * @author Gonzalo
 */
public class Tesoro {
    private String nombre;
    private int valor;

    public Tesoro(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return nombre + " (Valor: " + valor + ")";
    }
}

