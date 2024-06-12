
package edaprueba2;


import java.util.Scanner;
/**
 *
 * @author Gonzalo
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // Crear los tesoros
        Tesoro tesoro1 = new Tesoro("Oro", 100);
        Tesoro tesoro2 = new Tesoro("Diamante", 200);
        Tesoro tesoro3 = new Tesoro("Rubí", 150);
        Tesoro tesoro4 = new Tesoro("Esmeralda", 250);
        Tesoro tesoro5 = new Tesoro("Plata", 50);
        Tesoro tesoro6 = new Tesoro("Zafiro", 180);
        Tesoro tesoro7 = new Tesoro("Perla", 130);
        Tesoro tesoro8 = new Tesoro("Ámbar", 75);
        Tesoro tesoro9 = new Tesoro("Cobre", 25);

        // Crear la estructura del árbol
        Nodo cueva = new Nodo("Cueva", null);
        Nodo nivel1 = new Nodo("Nivel 1", null);
        Nodo nivel2 = new Nodo("Nivel 2", null);
        Nodo nivel3 = new Nodo("Nivel 3", null);

        Nodo cueva1_1 = new Nodo("Cueva 1", tesoro1);
        Nodo cueva1_2 = new Nodo("Cueva 2", tesoro2);
        Nodo cueva1_3 = new Nodo("Cueva 3", tesoro3);

        Nodo cueva2_1 = new Nodo("Cueva 1", tesoro4);
        Nodo cueva2_2 = new Nodo("Cueva 2", tesoro5);
        Nodo cueva2_3 = new Nodo("Cueva 3", tesoro6);

        Nodo cueva3_1 = new Nodo("Cueva 1", tesoro7);
        Nodo cueva3_2 = new Nodo("Cueva 2", tesoro8);
        Nodo cueva3_3 = new Nodo("Cueva 3", tesoro9);

        nivel1.agregarHijo(cueva1_1);
        nivel1.agregarHijo(cueva1_2);
        nivel1.agregarHijo(cueva1_3);

        nivel2.agregarHijo(cueva2_1);
        nivel2.agregarHijo(cueva2_2);
        nivel2.agregarHijo(cueva2_3);

        nivel3.agregarHijo(cueva3_1);
        nivel3.agregarHijo(cueva3_2);
        nivel3.agregarHijo(cueva3_3);

        cueva.agregarHijo(nivel1);
        cueva.agregarHijo(nivel2);
        cueva.agregarHijo(nivel3);

        ArbolTernario arbol = new ArbolTernario(cueva);

        // Menú interactivo
        Scanner scanner = new Scanner(System.in);
        Nodo nodoActual = arbol.getRaiz();
        Tesoro tesoroMasValioso = null;

        while (true) {
            System.out.println("Estás en: " + nodoActual.getNombre());
            if (nodoActual.getTesoro() != null) {
                System.out.println("Tesoro encontrado: " + nodoActual.getTesoro());
                if (tesoroMasValioso == null || nodoActual.getTesoro().getValor() > tesoroMasValioso.getValor()) {
                    tesoroMasValioso = nodoActual.getTesoro();
                }
            }

            System.out.println("Opciones:");
            for (int i = 0; i < nodoActual.getHijos().size(); i++) {
                System.out.println((i + 1) + ". " + nodoActual.getHijos().get(i).getNombre());
            }
            System.out.println("0. Salir");
            if (nodoActual.getPadre() != null) {
                System.out.println("4. Volver al nivel anterior");
            }

            int opcion = scanner.nextInt();
            if (opcion == 0) {
                break;
            } else if (opcion > 0 && opcion <= nodoActual.getHijos().size()) {
                nodoActual = nodoActual.getHijos().get(opcion - 1);
            } else if (opcion == 4 && nodoActual.getPadre() != null) {
                nodoActual = nodoActual.getPadre();
            } else {
                System.out.println("Opción no válida");
            }
        }

        scanner.close();

        if (tesoroMasValioso != null) {
            System.out.println("El tesoro más valioso encontrado fue: " + tesoroMasValioso);
        } else {
            System.out.println("No se encontraron tesoros.");
        }
        System.out.println("El tesoro mas valioso en toda la cueva es: " + tesoro4 + "Se encontraba en el nivel 2, Cueva 1" );
    }
}


