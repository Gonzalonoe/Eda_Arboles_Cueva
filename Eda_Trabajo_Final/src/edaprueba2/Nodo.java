
package edaprueba2;

/**
 *
 * @author Gonzalo
 */
import java.util.ArrayList;
import java.util.List;

public class Nodo {
    private String nombre;
    private Tesoro tesoro;
    private List<Nodo> hijos;
    private Nodo padre; // Agregado para volver al nivel anterior

    public Nodo(String nombre, Tesoro tesoro) {
        this.nombre = nombre;
        this.tesoro = tesoro;
        this.hijos = new ArrayList<>();
        this.padre = null;
    }

    public String getNombre() {
        return nombre;
    }

    public Tesoro getTesoro() {
        return tesoro;
    }

    public List<Nodo> getHijos() {
        return hijos;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void agregarHijo(Nodo hijo) {
        hijo.padre = this; // Establecer el padre del nodo hijo
        hijos.add(hijo);
    }
}

