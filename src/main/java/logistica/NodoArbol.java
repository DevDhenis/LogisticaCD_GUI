package logistica;

/**
 * Nodo del árbol. Guarda un producto y sus dos hijos: a la izquierda va el
 * código menor y a la derecha el mayor.
 *
 * @author Dhenis
 */
public class NodoArbol {

    Producto producto;
    NodoArbol izquierdo;
    NodoArbol derecho;

    public NodoArbol(Producto producto) {
        this.producto = producto;
        this.izquierdo = null;
        this.derecho = null;
    }
}
