package logistica;

/**
 * Nodo de la cola. Guarda un camión y apunta al siguiente nodo.
 *
 * @author Dhenis
 */
public class NodoCola {

    Camion camion;
    NodoCola siguiente;

    public NodoCola(Camion camion) {
        this.camion = camion;
        this.siguiente = null;
    }
}
