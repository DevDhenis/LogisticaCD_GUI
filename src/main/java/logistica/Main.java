package logistica;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Formulario del sistema de gestión logística. Tiene una pestaña por
 * estructura y un área de texto donde salen los resultados. La lógica de cada
 * estructura está en su propia clase.
 *
 * @author Dhenis
 */
public class Main extends javax.swing.JFrame {

    // Árbol (ABB): el inventario, ordenado por código.
    private ArbolInventario inventario = new ArbolInventario();
    // Cola de camiones, hecha con nodos enlazados.
    private ColaCamiones cola = new ColaCamiones();
    // Grafo: las ciudades y sus rutas.
    private GrafoRutas grafo = new GrafoRutas();
    // ArrayList: el historial de entregas, en el orden en que se hicieron.
    private List<Entrega> historial = new ArrayList<>();
    private int contadorEntrega = 1;

    public Main() {
        initComponents();
        conectarBotones();
        setLocationRelativeTo(null);
    }

    private void conectarBotones() {
        btnInsertar.addActionListener(e -> btnInsertarActionPerformed(e));
        btnBuscar.addActionListener(e -> btnBuscarActionPerformed(e));
        btnMostrarInv.addActionListener(e -> btnMostrarInvActionPerformed(e));
        btnEncolar.addActionListener(e -> btnEncolarActionPerformed(e));
        btnDesencolar.addActionListener(e -> btnDesencolarActionPerformed(e));
        btnMostrarCola.addActionListener(e -> btnMostrarColaActionPerformed(e));
        btnAgregarCiudad.addActionListener(e -> btnAgregarCiudadActionPerformed(e));
        btnAgregarRuta.addActionListener(e -> btnAgregarRutaActionPerformed(e));
        btnMostrarRutas.addActionListener(e -> btnMostrarRutasActionPerformed(e));
        btnBfs.addActionListener(e -> btnBfsActionPerformed(e));
        btnRegistrar.addActionListener(e -> btnRegistrarActionPerformed(e));
        btnHistorial.addActionListener(e -> btnHistorialActionPerformed(e));
        btnLimpiar.addActionListener(e -> txtAreaSalida.setText(""));
        btnSalir.addActionListener(e -> btnSalirActionPerformed(e));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        pestanas = new javax.swing.JTabbedPane();
        pnlInventario = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblStock = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        btnInsertar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnMostrarInv = new javax.swing.JButton();
        pnlCamiones = new javax.swing.JPanel();
        lblPlaca = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        lblConductor = new javax.swing.JLabel();
        txtConductor = new javax.swing.JTextField();
        lblCapacidad = new javax.swing.JLabel();
        txtCapacidad = new javax.swing.JTextField();
        btnEncolar = new javax.swing.JButton();
        btnDesencolar = new javax.swing.JButton();
        btnMostrarCola = new javax.swing.JButton();
        pnlRutas = new javax.swing.JPanel();
        lblCiudad = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        lblOrigen = new javax.swing.JLabel();
        txtOrigen = new javax.swing.JTextField();
        lblDestinoRuta = new javax.swing.JLabel();
        txtDestinoRuta = new javax.swing.JTextField();
        lblKm = new javax.swing.JLabel();
        txtKm = new javax.swing.JTextField();
        btnAgregarCiudad = new javax.swing.JButton();
        btnAgregarRuta = new javax.swing.JButton();
        btnMostrarRutas = new javax.swing.JButton();
        btnBfs = new javax.swing.JButton();
        pnlEntregas = new javax.swing.JPanel();
        lblCodEntrega = new javax.swing.JLabel();
        txtCodEntrega = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblDestinoEntrega = new javax.swing.JLabel();
        txtDestinoEntrega = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaSalida = new javax.swing.JTextArea();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestión Logística - Centro de Distribución");

        lblCodigo.setText("Código:");

        lblNombre.setText("Nombre:");

        lblStock.setText("Stock:");

        btnInsertar.setText("Insertar producto");

        btnBuscar.setText("Buscar por código");

        btnMostrarInv.setText("Mostrar inventario ordenado");

        javax.swing.GroupLayout pnlInventarioLayout = new javax.swing.GroupLayout(pnlInventario);
        pnlInventario.setLayout(pnlInventarioLayout);
        pnlInventarioLayout.setHorizontalGroup(
            pnlInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventarioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInventarioLayout.createSequentialGroup()
                        .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInventarioLayout.createSequentialGroup()
                        .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnMostrarInv, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        pnlInventarioLayout.setVerticalGroup(
            pnlInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventarioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStock)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar)
                    .addComponent(btnBuscar)
                    .addComponent(btnMostrarInv))
                .addGap(15, 15, 15))
        );

        pestanas.addTab("Inventario (ABB)", pnlInventario);

        lblPlaca.setText("Placa:");

        lblConductor.setText("Conductor:");

        lblCapacidad.setText("Capacidad (tn):");

        btnEncolar.setText("Encolar camión");

        btnDesencolar.setText("Desencolar camión");

        btnMostrarCola.setText("Mostrar cola de camiones");

        javax.swing.GroupLayout pnlCamionesLayout = new javax.swing.GroupLayout(pnlCamiones);
        pnlCamiones.setLayout(pnlCamionesLayout);
        pnlCamionesLayout.setHorizontalGroup(
            pnlCamionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamionesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlCamionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCamionesLayout.createSequentialGroup()
                        .addComponent(lblPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCamionesLayout.createSequentialGroup()
                        .addComponent(btnEncolar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnDesencolar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnMostrarCola, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        pnlCamionesLayout.setVerticalGroup(
            pnlCamionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamionesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlCamionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlaca)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConductor)
                    .addComponent(txtConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCapacidad)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlCamionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEncolar)
                    .addComponent(btnDesencolar)
                    .addComponent(btnMostrarCola))
                .addGap(15, 15, 15))
        );

        pestanas.addTab("Camiones (Cola)", pnlCamiones);

        lblCiudad.setText("Ciudad:");

        lblOrigen.setText("Origen:");

        lblDestinoRuta.setText("Destino:");

        lblKm.setText("Distancia (km):");

        btnAgregarCiudad.setText("Agregar ciudad");

        btnAgregarRuta.setText("Agregar ruta");

        btnMostrarRutas.setText("Mostrar rutas");

        btnBfs.setText("BFS desde la ciudad");

        javax.swing.GroupLayout pnlRutasLayout = new javax.swing.GroupLayout(pnlRutas);
        pnlRutas.setLayout(pnlRutasLayout);
        pnlRutasLayout.setHorizontalGroup(
            pnlRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRutasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRutasLayout.createSequentialGroup()
                        .addComponent(lblCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRutasLayout.createSequentialGroup()
                        .addComponent(lblOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblDestinoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtDestinoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblKm, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtKm, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRutasLayout.createSequentialGroup()
                        .addComponent(btnAgregarCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnAgregarRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnMostrarRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnBfs, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        pnlRutasLayout.setVerticalGroup(
            pnlRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRutasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCiudad)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrigen)
                    .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDestinoRuta)
                    .addComponent(txtDestinoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKm)
                    .addComponent(txtKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarCiudad)
                    .addComponent(btnAgregarRuta)
                    .addComponent(btnMostrarRutas)
                    .addComponent(btnBfs))
                .addGap(15, 15, 15))
        );

        pestanas.addTab("Rutas (Grafo)", pnlRutas);

        lblCodEntrega.setText("Código del producto:");

        lblCantidad.setText("Cantidad:");

        lblDestinoEntrega.setText("Ciudad destino:");

        btnRegistrar.setText("Registrar entrega");

        btnHistorial.setText("Mostrar historial");

        javax.swing.GroupLayout pnlEntregasLayout = new javax.swing.GroupLayout(pnlEntregas);
        pnlEntregas.setLayout(pnlEntregasLayout);
        pnlEntregasLayout.setHorizontalGroup(
            pnlEntregasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEntregasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlEntregasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEntregasLayout.createSequentialGroup()
                        .addComponent(lblCodEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtCodEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblDestinoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtDestinoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEntregasLayout.createSequentialGroup()
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        pnlEntregasLayout.setVerticalGroup(
            pnlEntregasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEntregasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlEntregasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodEntrega)
                    .addComponent(txtCodEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidad)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDestinoEntrega)
                    .addComponent(txtDestinoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlEntregasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnHistorial))
                .addGap(15, 15, 15))
        );

        pestanas.addTab("Entregas (Integración)", pnlEntregas);

        txtAreaSalida.setEditable(false);
        txtAreaSalida.setColumns(60);
        txtAreaSalida.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        txtAreaSalida.setRows(13);
        jScrollPane1.setViewportView(txtAreaSalida);

        btnLimpiar.setText("Limpiar resultados");

        btnSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pestanas, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pestanas, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnSalir))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // ---- métodos de ayuda

    private void error(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Convierte el texto del campo a número. Si no es un número, devuelve null.
    private Integer entero(JTextField campo) {
        try {
            return Integer.parseInt(campo.getText().trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // mostrar() y mostrarRutas() imprimen con System.out.println. Aquí lo que
    // imprimen se manda al área de texto del formulario.
    private void mostrarSalida(Runnable accion) {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
        try {
            accion.run();
        } finally {
            System.setOut(original);
        }
        txtAreaSalida.append(buffer.toString(StandardCharsets.UTF_8));
    }

    // ---- Inventario (ABB)

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {
        Integer cod = entero(txtCodigo);
        Integer st = entero(txtStock);
        String nom = txtNombre.getText().trim();
        if (cod == null || st == null || nom.isEmpty() || st < 0) {
            error("Ingrese un código y un stock numéricos (stock no negativo) y un nombre.");
            return;
        }
        if (inventario.insertar(new Producto(cod, nom, st))) {
            txtAreaSalida.append("Producto insertado en el ABB: [" + cod + "] " + nom + " | stock=" + st + "\n");
            txtCodigo.setText("");
            txtNombre.setText("");
            txtStock.setText("");
            txtCodigo.requestFocus();
        } else {
            error("Ya existe un producto con el código " + cod + ".");
        }
    }

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        Integer cod = entero(txtCodigo);
        if (cod == null) {
            error("Ingrese un código numérico para buscar.");
            return;
        }
        Producto p = inventario.buscar(cod);
        txtAreaSalida.append(p != null ? "Encontrado: " + p + "\n"
                : "No existe un producto con el código " + cod + ".\n");
    }

    private void btnMostrarInvActionPerformed(java.awt.event.ActionEvent evt) {
        List<Producto> orden = new ArrayList<>();
        inventario.inOrden(orden);
        txtAreaSalida.append("--- Inventario ordenado por código ---\n");
        if (orden.isEmpty()) {
            txtAreaSalida.append("El inventario está vacío.\n");
        }
        for (Producto prod : orden) {
            txtAreaSalida.append(prod + "\n");
        }
        txtAreaSalida.append("Altura del árbol: " + inventario.altura() + "\n");
    }

    // ---- Camiones (cola)

    private void btnEncolarActionPerformed(java.awt.event.ActionEvent evt) {
        String placa = txtPlaca.getText().trim();
        String conductor = txtConductor.getText().trim();
        double cap;
        try {
            cap = Double.parseDouble(txtCapacidad.getText().trim());
        } catch (NumberFormatException e) {
            error("La capacidad debe ser un número (toneladas).");
            return;
        }
        if (placa.isEmpty() || conductor.isEmpty() || cap <= 0) {
            error("Ingrese placa, conductor y una capacidad mayor que 0.");
            return;
        }
        cola.encolar(new Camion(placa, conductor, cap));
        txtAreaSalida.append("Camión encolado: " + placa + "\n");
        txtPlaca.setText("");
        txtConductor.setText("");
        txtCapacidad.setText("");
        txtPlaca.requestFocus();
    }

    private void btnDesencolarActionPerformed(java.awt.event.ActionEvent evt) {
        Camion c = cola.desencolar();
        if (c == null) {
            error("La cola de camiones está vacía.");
            return;
        }
        txtAreaSalida.append("Desencolado: " + c + "\n");
    }

    private void btnMostrarColaActionPerformed(java.awt.event.ActionEvent evt) {
        if (cola.estaVacia()) {
            txtAreaSalida.append("Cola vacía.\n");
            return;
        }
        txtAreaSalida.append("--- Cola de camiones (orden de llegada) ---\n");
        mostrarSalida(() -> cola.mostrar());
    }

    // ---- Rutas (grafo)

    private void btnAgregarCiudadActionPerformed(java.awt.event.ActionEvent evt) {
        String ciudad = txtCiudad.getText().trim();
        if (ciudad.isEmpty()) {
            error("Ingrese el nombre de la ciudad.");
            return;
        }
        if (grafo.existeCiudad(ciudad)) {
            error("La ciudad " + ciudad + " ya está registrada.");
            return;
        }
        grafo.agregarCiudad(ciudad);
        txtAreaSalida.append("Ciudad agregada: " + ciudad + "\n");
        txtCiudad.setText("");
        txtCiudad.requestFocus();
    }

    private void btnAgregarRutaActionPerformed(java.awt.event.ActionEvent evt) {
        String origen = txtOrigen.getText().trim();
        String destino = txtDestinoRuta.getText().trim();
        Integer km = entero(txtKm);
        if (origen.isEmpty() || destino.isEmpty() || km == null || km <= 0) {
            error("Ingrese origen, destino y una distancia en km mayor que 0.");
            return;
        }
        if (!grafo.agregarRuta(origen, destino, km)) {
            error("El origen y el destino deben ser ciudades ya registradas.");
            return;
        }
        txtAreaSalida.append("Ruta agregada: " + origen + " -> " + destino + " (" + km + " km)\n");
        txtOrigen.setText("");
        txtDestinoRuta.setText("");
        txtKm.setText("");
    }

    private void btnMostrarRutasActionPerformed(java.awt.event.ActionEvent evt) {
        txtAreaSalida.append("--- Red de rutas ---\n");
        mostrarSalida(() -> grafo.mostrarRutas());
    }

    private void btnBfsActionPerformed(java.awt.event.ActionEvent evt) {
        String inicio = txtCiudad.getText().trim();
        if (!grafo.existeCiudad(inicio)) {
            error("Escriba en el campo Ciudad una ciudad registrada para iniciar el BFS.");
            return;
        }
        txtAreaSalida.append("BFS desde " + inicio + ": " + grafo.bfs(inicio) + "\n");
    }

    // ---- Entregas (usa las cuatro estructuras)

    // Primero se revisan todas las reglas y recién después se cambia algo. Así,
    // si la entrega se rechaza, el stock y la cola quedan igual.
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {
        Integer cod = entero(txtCodEntrega);
        Integer cant = entero(txtCantidad);
        String destino = txtDestinoEntrega.getText().trim();
        if (cod == null || cant == null || cant <= 0 || destino.isEmpty()) {
            error("Ingrese el código del producto, una cantidad mayor que 0 y la ciudad destino.");
            return;
        }
        Producto p = inventario.buscar(cod);                      // 1. Árbol: busca
        if (p == null) {
            error("El producto " + cod + " no existe en el inventario.");
            return;
        }
        if (p.getStock() < cant) {
            error("Stock insuficiente. Disponible: " + p.getStock());
            return;
        }
        if (grafo.bfs(destino).isEmpty()) {                       // 3. Grafo: verifica
            error("El destino " + destino + " no existe en el grafo.");
            return;
        }
        if (cola.estaVacia()) {
            error("No hay camiones disponibles en la cola.");
            return;
        }

        inventario.descontarStock(cod, cant);                     // 2. Árbol: descuenta
        Camion camion = cola.desencolar();                        // 4. Cola: asigna camión
        Entrega e = new Entrega(contadorEntrega++, p.getNombre(),
                camion.getPlaca(), destino, cant);
        historial.add(e);                                         // 5. ArrayList: guarda

        txtAreaSalida.append("Entrega registrada: " + e + "\n");
        txtAreaSalida.append("   Stock restante de " + p.getNombre() + ": " + p.getStock() + "\n");
        txtAreaSalida.append("   Ruta BFS desde " + destino + ": " + grafo.bfs(destino) + "\n");
        JOptionPane.showMessageDialog(this,
                "Entrega #" + e.getId() + " registrada.\nProducto: " + e.getProducto() + " x" + cant
                + "\nCamión: " + e.getCamion() + "\nDestino: " + destino,
                "Entrega registrada", JOptionPane.INFORMATION_MESSAGE);
    }

    // Recorre el historial con Iterator, de la primera entrega a la última.
    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {
        if (historial.isEmpty()) {
            txtAreaSalida.append("Sin entregas aún.\n");
            return;
        }
        txtAreaSalida.append("--- Historial de entregas (ArrayList) ---\n");
        Iterator<Entrega> it = historial.iterator();
        while (it.hasNext()) {
            txtAreaSalida.append(it.next() + "\n");
        }
    }

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCiudad;
    private javax.swing.JButton btnAgregarRuta;
    private javax.swing.JButton btnBfs;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDesencolar;
    private javax.swing.JButton btnEncolar;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMostrarCola;
    private javax.swing.JButton btnMostrarInv;
    private javax.swing.JButton btnMostrarRutas;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCapacidad;
    private javax.swing.JLabel lblCiudad;
    private javax.swing.JLabel lblCodEntrega;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblConductor;
    private javax.swing.JLabel lblDestinoEntrega;
    private javax.swing.JLabel lblDestinoRuta;
    private javax.swing.JLabel lblKm;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblOrigen;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblStock;
    private javax.swing.JTabbedPane pestanas;
    private javax.swing.JPanel pnlCamiones;
    private javax.swing.JPanel pnlEntregas;
    private javax.swing.JPanel pnlInventario;
    private javax.swing.JPanel pnlRutas;
    private javax.swing.JTextArea txtAreaSalida;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCodEntrega;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtConductor;
    private javax.swing.JTextField txtDestinoEntrega;
    private javax.swing.JTextField txtDestinoRuta;
    private javax.swing.JTextField txtKm;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOrigen;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
