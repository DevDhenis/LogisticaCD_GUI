package logistica;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Grafo de rutas con lista de adyacencia: cada ciudad tiene su lista de
 * rutas de salida. Van en un solo sentido, del origen al destino.
 *
 * @author Dhenis
 */
public class GrafoRutas {

    // Cada ciudad guarda su lista de rutas. Uso LinkedHashMap para que las
    // ciudades salgan en el orden en que se agregaron.
    private Map<String, LinkedList<Ruta>> adyacencia = new LinkedHashMap<>();

    public void agregarCiudad(String ciudad) {
        adyacencia.putIfAbsent(ciudad, new LinkedList<>());
    }

    // Sirve para comprobar que el destino existe antes de hacer una entrega.
    public boolean existeCiudad(String ciudad) {
        return adyacencia.containsKey(ciudad);
    }

    // Si el origen o el destino no están registrados, devuelve false.
    public boolean agregarRuta(String origen, String destino, int km) {
        if (!existeCiudad(origen) || !existeCiudad(destino)) {
            return false;
        }
        adyacencia.get(origen).add(new Ruta(destino, km));
        return true;
    }

    public void mostrarRutas() {
        for (String origen : adyacencia.keySet()) {
            System.out.print(origen + " -> ");
            for (Ruta r : adyacencia.get(origen)) {
                System.out.print(r + "  ");
            }
            System.out.println();
        }
    }

    // Recorrido en anchura (BFS): devuelve las ciudades a las que se puede
    // llegar, en el orden en que se visitan. La cola auxiliar es un ArrayDeque.
    public List<String> bfs(String inicio) {
        List<String> visitados = new ArrayList<>();
        if (!existeCiudad(inicio)) {
            return visitados;
        }
        Queue<String> cola = new ArrayDeque<>();
        Set<String> vistos = new HashSet<>();
        cola.add(inicio);
        vistos.add(inicio);
        while (!cola.isEmpty()) {
            String actual = cola.poll();
            visitados.add(actual);
            for (Ruta r : adyacencia.get(actual)) {
                if (!vistos.contains(r.getDestino())) {
                    vistos.add(r.getDestino());
                    cola.add(r.getDestino());
                }
            }
        }
        return visitados;
    }

    // Suma los km de un camino de ciudades seguidas. Si falta alguna ruta,
    // devuelve -1.
    public int distanciaRuta(List<String> camino) {
        int total = 0;
        for (int i = 0; i < camino.size() - 1; i++) {
            String origen = camino.get(i);
            String destino = camino.get(i + 1);
            boolean encontrada = false;
            if (existeCiudad(origen)) {
                for (Ruta r : adyacencia.get(origen)) {
                    if (r.getDestino().equals(destino)) {
                        total += r.getDistanciaKm();
                        encontrada = true;
                        break;
                    }
                }
            }
            if (!encontrada) {
                return -1;
            }
        }
        return total;
    }
}
