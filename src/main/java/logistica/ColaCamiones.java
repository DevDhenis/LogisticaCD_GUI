package logistica;

/**
 * Cola de camiones hecha con nodos enlazados. El primero que llega es el
 * primero que sale.
 *
 * @author Dhenis
 */
public class ColaCamiones {

    private NodoCola frente;
    private NodoCola fin;

    // Pone el camión al final de la cola.
    public void encolar(Camion c) {
        NodoCola nuevo = new NodoCola(c);
        if (fin == null) {
            frente = nuevo;
            fin = nuevo;
            return;
        }
        fin.siguiente = nuevo;
        fin = nuevo;
    }

    // Saca el camión del frente. Si la cola está vacía, devuelve null.
    public Camion desencolar() {
        if (frente == null) {
            return null;
        }
        Camion c = frente.camion;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        return c;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    // Muestra los camiones en el orden en que llegaron.
    public void mostrar() {
        NodoCola aux = frente;
        int i = 1;
        while (aux != null) {
            System.out.println("  " + i + ". " + aux.camion);
            aux = aux.siguiente;
            i++;
        }
    }
}
