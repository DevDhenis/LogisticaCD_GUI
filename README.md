# LogisticaCD_GUI

Sistema de gestión logística para un centro de distribución, con interfaz gráfica en Java (Swing). Práctica calificada 3 de Algoritmos y Estructuras de Datos.

El formulario tiene una pestaña por estructura de datos y un área de texto común para los resultados:

- Inventario: árbol binario de búsqueda ordenado por código de producto (`ArbolInventario`, `NodoArbol`).
- Camiones: cola FIFO con nodos enlazados a mano (`ColaCamiones`, `NodoCola`).
- Rutas: grafo con lista de adyacencia, con `HashMap<String, LinkedList<Ruta>>` y BFS (`GrafoRutas`).
- Entregas: la opción "Registrar entrega" usa las cuatro estructuras en un solo flujo y guarda el resultado en un `ArrayList<Entrega>`. Si una regla falla, muestra un `JOptionPane` con el error y no modifica nada.

## Estructura

```
src/main/java/logistica/
  Producto, Camion, Ruta, Entrega        (objetos de dominio)
  NodoArbol, ArbolInventario             (ABB)
  NodoCola, ColaCamiones                 (cola)
  GrafoRutas                             (grafo)
  Main                                   (formulario y lógica de interacción)
```

## Cómo ejecutarlo

Abrir la carpeta como proyecto Maven en NetBeans y ejecutar `logistica.Main` (Java 21).
