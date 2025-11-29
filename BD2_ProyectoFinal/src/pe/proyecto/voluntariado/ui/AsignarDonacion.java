package pe.proyecto.voluntariado.ui;

import javax.swing.JOptionPane;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import pe.proyecto.voluntariado.dao.impl.DonacionDAOImpl;
import pe.proyecto.voluntariado.dao.impl.OrganizacionDAOImpl;
import pe.proyecto.voluntariado.dao.impl.TipoDonacionDAOImpl;
import pe.proyecto.voluntariado.dao.impl.VoluntarioDAOImpl;
import pe.proyecto.voluntariado.model.Donacion;
import pe.proyecto.voluntariado.model.Organizacion;
import pe.proyecto.voluntariado.model.TipoDonacion;
import pe.proyecto.voluntariado.model.Voluntario;

public class AsignarDonacion extends javax.swing.JFrame {

    List<Donacion> donaciones;
    Donacion donacionSeleccionada = new Donacion();
    DonacionDAOImpl donacionDAOImpl = new DonacionDAOImpl();
    VoluntarioDAOImpl voluntarioDAOImpl = new VoluntarioDAOImpl();
    OrganizacionDAOImpl organizacionDAOImpl = new OrganizacionDAOImpl();
    TipoDonacionDAOImpl tipoDonacionDAOImpl = new TipoDonacionDAOImpl();

    public AsignarDonacion() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Sistema de voluntariado integrado (SVI)");

        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    jButtonBuscarActionPerformed(null);
                }
            }
        });

        try {
            donaciones = donacionDAOImpl.listarTodos();
            listarDonaciones();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error al listar donaciones: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        jTableDonaciones.getSelectionModel().addListSelectionListener(evt -> {
            if (!evt.getValueIsAdjusting()) {
                int fila = jTableDonaciones.getSelectedRow();
                if (fila != -1) {
                    cargarDatosDonacion(fila);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDonaciones = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldNombreOrganizacion = new javax.swing.JTextField();
        jTextFieldCalificacion = new javax.swing.JTextField();
        jTextFieldNombreTipoDonacion = new javax.swing.JTextField();
        jTextFieldVoluntario = new javax.swing.JTextField();
        jButtonAgregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonModificar = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldFecha = new javax.swing.JTextField();
        jTextFieldCantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Asignar donaciones");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Donaciones:");

        jTableDonaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Voluntario", "Organización", "Tipo de donación", "Cantidad", "Fecha", "Calificación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableDonaciones);

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Voluntario:");

        jLabel5.setText("Organización:");

        jLabel6.setText("Tipo de donación:");

        jLabel7.setText("Fecha:");

        jLabel8.setText("Cantidad:");

        jTextFieldNombreOrganizacion.setEditable(false);

        jTextFieldCalificacion.setEditable(false);
        jTextFieldCalificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCalificacionActionPerformed(evt);
            }
        });

        jTextFieldNombreTipoDonacion.setEditable(false);

        jTextFieldVoluntario.setEditable(false);

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Acciones:");

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jLabel9.setText("Calificación:");

        jTextFieldFecha.setEditable(false);

        jTextFieldCantidad.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(99, 99, 99))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(46, 46, 46)
                        .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonBuscar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1094, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel4))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                    .addComponent(jTextFieldVoluntario, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNombreOrganizacion, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNombreTipoDonacion, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCalificacion, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonModificar)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldVoluntario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNombreOrganizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNombreTipoDonacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAgregar)
                            .addComponent(jButtonModificar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new MenuPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        javax.swing.JPanel panelPrincipal = new javax.swing.JPanel(new java.awt.GridLayout(6, 2, 10, 10));

        // Buscador de Voluntario con panel especial
        javax.swing.JPanel panelVoluntario = new javax.swing.JPanel(new java.awt.BorderLayout(5, 0));
        javax.swing.JTextField txtVoluntarioBuscar = new javax.swing.JTextField();
        txtVoluntarioBuscar.setEditable(false);
        javax.swing.JButton btnBuscarVol = new javax.swing.JButton("🔍");
        panelVoluntario.add(txtVoluntarioBuscar, java.awt.BorderLayout.CENTER);
        panelVoluntario.add(btnBuscarVol, java.awt.BorderLayout.EAST);

        final Voluntario[] voluntarioSeleccionado = {null};

        btnBuscarVol.addActionListener(e -> {
            String busqueda = JOptionPane.showInputDialog(this,
                    "Buscar por DNI o Nombre del voluntario:",
                    "Buscar Voluntario",
                    JOptionPane.QUESTION_MESSAGE);

            if (busqueda != null && !busqueda.trim().isEmpty()) {
                try {
                    List<Voluntario> voluntarios = voluntarioDAOImpl.listarTodos().stream()
                            .filter(v
                                    -> v.getDni().contains(busqueda)
                            || v.getNombres().toLowerCase().contains(busqueda.toLowerCase())
                            || v.getApellidos().toLowerCase().contains(busqueda.toLowerCase())
                            || (v.getNombres() + " " + v.getApellidos()).toLowerCase().contains(busqueda.toLowerCase())
                            )
                            .collect(Collectors.toList());

                    if (voluntarios.isEmpty()) {
                        JOptionPane.showMessageDialog(this,
                                "No se encontraron voluntarios con: " + busqueda,
                                "Sin resultados",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if (voluntarios.size() == 1) {
                        voluntarioSeleccionado[0] = voluntarios.get(0);
                        txtVoluntarioBuscar.setText(voluntarioSeleccionado[0].getDni() + " - "
                                + voluntarioSeleccionado[0].getNombres() + " "
                                + voluntarioSeleccionado[0].getApellidos());
                    } else {
                        // Mostrar lista para seleccionar
                        String[] opciones = voluntarios.stream()
                                .map(v -> v.getDni() + " - " + v.getNombres() + " " + v.getApellidos())
                                .toArray(String[]::new);

                        String seleccion = (String) JOptionPane.showInputDialog(this,
                                "Se encontraron " + voluntarios.size() + " voluntarios. Seleccione uno:",
                                "Voluntarios encontrados",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                opciones,
                                opciones[0]);

                        if (seleccion != null) {
                            String dni = seleccion.split(" - ")[0];
                            voluntarioSeleccionado[0] = voluntarios.stream()
                                    .filter(v -> v.getDni().equals(dni))
                                    .findFirst().orElse(null);

                            if (voluntarioSeleccionado[0] != null) {
                                txtVoluntarioBuscar.setText(seleccion);
                            }
                        }
                    }
                } catch (Exception ex) {
                    Logger.getLogger(AsignarDonacion.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Error al buscar: " + ex.getMessage());
                }
            }
        });

        // ComboBox de Organizaciones
        javax.swing.JComboBox<Organizacion> cboOrganizacion = new javax.swing.JComboBox<>();
        try {
            List<Organizacion> organizaciones = organizacionDAOImpl.listarActivas();
            DefaultComboBoxModel<Organizacion> modeloOrg = new DefaultComboBoxModel<>();
            for (Organizacion org : organizaciones) {
                modeloOrg.addElement(org);
            }
            cboOrganizacion.setModel(modeloOrg);
        } catch (Exception ex) {
            Logger.getLogger(AsignarDonacion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al cargar organizaciones: " + ex.getMessage());
            return;
        }

        // ComboBox de Tipos de Donación
        javax.swing.JComboBox<TipoDonacion> cboTipoDonacion = new javax.swing.JComboBox<>();
        final TipoDonacion[] tipoSeleccionado = {null};

        try {
            List<TipoDonacion> tipos = tipoDonacionDAOImpl.listarTodos();
            DefaultComboBoxModel<TipoDonacion> modeloTipo = new DefaultComboBoxModel<>();
            for (TipoDonacion tipo : tipos) {
                modeloTipo.addElement(tipo);
            }
            cboTipoDonacion.setModel(modeloTipo);
            if (tipos.size() > 0) {
                tipoSeleccionado[0] = tipos.get(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(AsignarDonacion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al cargar tipos de donación: " + ex.getMessage());
            return;
        }

        // Campo de cantidad
        javax.swing.JTextField txtCantidad = new javax.swing.JTextField(20);

        // Spinner para calificación con límite dinámico
        JSpinner spinCalificacion = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        javax.swing.JLabel lblCalificacionMax = new javax.swing.JLabel("(Máx: 100)");
        javax.swing.JPanel panelCalificacion = new javax.swing.JPanel(new java.awt.BorderLayout(5, 0));
        panelCalificacion.add(spinCalificacion, java.awt.BorderLayout.CENTER);
        panelCalificacion.add(lblCalificacionMax, java.awt.BorderLayout.EAST);

        // Listener para actualizar el máximo de calificación según tipo seleccionado
        cboTipoDonacion.addActionListener(e -> {
            TipoDonacion tipo = (TipoDonacion) cboTipoDonacion.getSelectedItem();
            if (tipo != null) {
                tipoSeleccionado[0] = tipo;
                int maxCal = tipo.getCalificacionMax() != null ? tipo.getCalificacionMax() : 100;

                // Actualizar el modelo del spinner
                ((SpinnerNumberModel) spinCalificacion.getModel()).setMaximum(maxCal);

                // Si el valor actual es mayor al nuevo máximo, ajustarlo
                int valorActual = (Integer) spinCalificacion.getValue();
                if (valorActual > maxCal) {
                    spinCalificacion.setValue(maxCal);
                }

                // Actualizar etiqueta
                lblCalificacionMax.setText("(Máx: " + maxCal + ")");
            }
        });

        // Disparar el evento inicial para configurar el primer tipo
        if (cboTipoDonacion.getItemCount() > 0) {
            cboTipoDonacion.setSelectedIndex(0);
        }

        // Agregar componentes
        panelPrincipal.add(new javax.swing.JLabel("* Voluntario:"));
        panelPrincipal.add(panelVoluntario);
        panelPrincipal.add(new javax.swing.JLabel("* Organización:"));
        panelPrincipal.add(cboOrganizacion);
        panelPrincipal.add(new javax.swing.JLabel("* Tipo de Donación:"));
        panelPrincipal.add(cboTipoDonacion);
        panelPrincipal.add(new javax.swing.JLabel("Cantidad:"));
        panelPrincipal.add(txtCantidad);
        panelPrincipal.add(new javax.swing.JLabel("Calificación:"));
        panelPrincipal.add(panelCalificacion);
        panelPrincipal.add(new javax.swing.JLabel(""));
        panelPrincipal.add(new javax.swing.JLabel("* Campos obligatorios"));

        int resultado = JOptionPane.showConfirmDialog(this,
                panelPrincipal,
                "Registrar Nueva Donación",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (resultado == JOptionPane.OK_OPTION) {
            // Validaciones
            if (voluntarioSeleccionado[0] == null) {
                JOptionPane.showMessageDialog(this,
                        "Debe buscar y seleccionar un voluntario.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (cboOrganizacion.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una organización.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (cboTipoDonacion.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de donación.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Validar cantidad si se ingresó
            Double cantidad = null;
            if (!txtCantidad.getText().trim().isEmpty()) {
                try {
                    cantidad = Double.parseDouble(txtCantidad.getText().trim());
                    if (cantidad <= 0) {
                        JOptionPane.showMessageDialog(this,
                                "La cantidad debe ser mayor a cero.",
                                "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this,
                            "La cantidad debe ser un número válido.",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            // Validar calificación según el tipo de donación
            int calificacion = (Integer) spinCalificacion.getValue();
            TipoDonacion tipoFinal = (TipoDonacion) cboTipoDonacion.getSelectedItem();
            if (tipoFinal.getCalificacionMax() != null && calificacion > tipoFinal.getCalificacionMax()) {
                JOptionPane.showMessageDialog(this,
                        "La calificación no puede ser mayor a " + tipoFinal.getCalificacionMax()
                        + " para el tipo de donación: " + tipoFinal.getNombre(),
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                Donacion nueva = new Donacion();
                nueva.setVoluntarioId(voluntarioSeleccionado[0].getId());
                nueva.setOrganizacionId(((Organizacion) cboOrganizacion.getSelectedItem()).getId());
                nueva.setTipoDonacionId(tipoFinal.getId());
                nueva.setCantidad(cantidad);
                nueva.setCalificacion(calificacion);

                donacionDAOImpl.insertar(nueva);

                JOptionPane.showMessageDialog(this,
                        "Donación registrada correctamente.",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);

                donaciones = donacionDAOImpl.listarTodos();
                listarDonaciones();
                limpiarCampos();

            } catch (Exception ex) {
                Logger.getLogger(AsignarDonacion.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        if (donacionSeleccionada.getId() == null || donacionSeleccionada.getId() == 0) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione una donación de la tabla antes de modificar.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Donacion actual = donacionDAOImpl.buscarPorId(donacionSeleccionada.getId());

            if (actual == null) {
                JOptionPane.showMessageDialog(this, "No se encontró la donación seleccionada.");
                return;
            }

            javax.swing.JPanel panelPrincipal = new javax.swing.JPanel(new java.awt.GridLayout(6, 2, 10, 10));

            // Buscador de Voluntario pre-cargado
            javax.swing.JPanel panelVoluntario = new javax.swing.JPanel(new java.awt.BorderLayout(5, 0));
            javax.swing.JTextField txtVoluntarioBuscar = new javax.swing.JTextField();
            txtVoluntarioBuscar.setEditable(false);
            javax.swing.JButton btnBuscarVol = new javax.swing.JButton("🔍");
            panelVoluntario.add(txtVoluntarioBuscar, java.awt.BorderLayout.CENTER);
            panelVoluntario.add(btnBuscarVol, java.awt.BorderLayout.EAST);

            // Cargar voluntario actual
            final Voluntario[] voluntarioSeleccionado = {null};
            try {
                voluntarioSeleccionado[0] = voluntarioDAOImpl.buscarPorId(actual.getVoluntarioId());
                if (voluntarioSeleccionado[0] != null) {
                    txtVoluntarioBuscar.setText(voluntarioSeleccionado[0].getDni() + " - "
                            + voluntarioSeleccionado[0].getNombres() + " "
                            + voluntarioSeleccionado[0].getApellidos());
                }
            } catch (Exception ex) {
                Logger.getLogger(AsignarDonacion.class.getName()).log(Level.SEVERE, null, ex);
            }

            btnBuscarVol.addActionListener(e -> {
                String busqueda = JOptionPane.showInputDialog(this,
                        "Buscar por DNI o Nombre del voluntario:",
                        "Buscar Voluntario",
                        JOptionPane.QUESTION_MESSAGE);

                if (busqueda != null && !busqueda.trim().isEmpty()) {
                    try {
                        List<Voluntario> voluntarios = voluntarioDAOImpl.listarTodos().stream()
                                .filter(v
                                        -> v.getDni().contains(busqueda)
                                || v.getNombres().toLowerCase().contains(busqueda.toLowerCase())
                                || v.getApellidos().toLowerCase().contains(busqueda.toLowerCase())
                                || (v.getNombres() + " " + v.getApellidos()).toLowerCase().contains(busqueda.toLowerCase())
                                )
                                .collect(Collectors.toList());

                        if (voluntarios.isEmpty()) {
                            JOptionPane.showMessageDialog(this, "No se encontraron voluntarios.");
                        } else if (voluntarios.size() == 1) {
                            voluntarioSeleccionado[0] = voluntarios.get(0);
                            txtVoluntarioBuscar.setText(voluntarioSeleccionado[0].getDni() + " - "
                                    + voluntarioSeleccionado[0].getNombres() + " "
                                    + voluntarioSeleccionado[0].getApellidos());
                        } else {
                            String[] opciones = voluntarios.stream()
                                    .map(v -> v.getDni() + " - " + v.getNombres() + " " + v.getApellidos())
                                    .toArray(String[]::new);

                            String seleccion = (String) JOptionPane.showInputDialog(this,
                                    "Seleccione un voluntario:",
                                    "Voluntarios encontrados",
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    opciones,
                                    opciones[0]);

                            if (seleccion != null) {
                                String dni = seleccion.split(" - ")[0];
                                voluntarioSeleccionado[0] = voluntarios.stream()
                                        .filter(v -> v.getDni().equals(dni))
                                        .findFirst().orElse(null);

                                if (voluntarioSeleccionado[0] != null) {
                                    txtVoluntarioBuscar.setText(seleccion);
                                }
                            }
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                    }
                }
            });

            // ComboBox de Organizaciones pre-seleccionado
            javax.swing.JComboBox<Organizacion> cboOrganizacion = new javax.swing.JComboBox<>();
            List<Organizacion> organizaciones = organizacionDAOImpl.listarActivas();
            DefaultComboBoxModel<Organizacion> modeloOrg = new DefaultComboBoxModel<>();
            Organizacion orgActual = null;
            for (Organizacion org : organizaciones) {
                modeloOrg.addElement(org);
                if (org.getId().equals(actual.getOrganizacionId())) {
                    orgActual = org;
                }
            }
            cboOrganizacion.setModel(modeloOrg);
            if (orgActual != null) {
                cboOrganizacion.setSelectedItem(orgActual);
            }

            // ComboBox de Tipos pre-seleccionado
            javax.swing.JComboBox<TipoDonacion> cboTipoDonacion = new javax.swing.JComboBox<>();
            List<TipoDonacion> tipos = tipoDonacionDAOImpl.listarTodos();
            DefaultComboBoxModel<TipoDonacion> modeloTipo = new DefaultComboBoxModel<>();
            TipoDonacion tipoActual = null;
            for (TipoDonacion tipo : tipos) {
                modeloTipo.addElement(tipo);
                if (tipo.getId().equals(actual.getTipoDonacionId())) {
                    tipoActual = tipo;
                }
            }
            cboTipoDonacion.setModel(modeloTipo);
            if (tipoActual != null) {
                cboTipoDonacion.setSelectedItem(tipoActual);
            }

            javax.swing.JTextField txtCantidad = new javax.swing.JTextField(
                    actual.getCantidad() != null ? actual.getCantidad().toString() : "", 20);

            // Configurar spinner con límite del tipo actual
            int maxCalActual = tipoActual != null && tipoActual.getCalificacionMax() != null
                    ? tipoActual.getCalificacionMax() : 100;
            JSpinner spinCalificacion = new JSpinner(new SpinnerNumberModel(
                    actual.getCalificacion() != null ? actual.getCalificacion() : 0,
                    0, maxCalActual, 1));

            javax.swing.JLabel lblCalificacionMax = new javax.swing.JLabel("(Máx: " + maxCalActual + ")");
            javax.swing.JPanel panelCalificacion = new javax.swing.JPanel(new java.awt.BorderLayout(5, 0));
            panelCalificacion.add(spinCalificacion, java.awt.BorderLayout.CENTER);
            panelCalificacion.add(lblCalificacionMax, java.awt.BorderLayout.EAST);

            // Listener para actualizar máximo dinámicamente
            cboTipoDonacion.addActionListener(e -> {
                TipoDonacion tipo = (TipoDonacion) cboTipoDonacion.getSelectedItem();
                if (tipo != null) {
                    int maxCal = tipo.getCalificacionMax() != null ? tipo.getCalificacionMax() : 100;
                    ((SpinnerNumberModel) spinCalificacion.getModel()).setMaximum(maxCal);
                    int valorActual = (Integer) spinCalificacion.getValue();
                    if (valorActual > maxCal) {
                        spinCalificacion.setValue(maxCal);
                    }
                    lblCalificacionMax.setText("(Máx: " + maxCal + ")");
                }
            });

            panelPrincipal.add(new javax.swing.JLabel("* Voluntario:"));
            panelPrincipal.add(panelVoluntario);
            panelPrincipal.add(new javax.swing.JLabel("* Organización:"));
            panelPrincipal.add(cboOrganizacion);
            panelPrincipal.add(new javax.swing.JLabel("* Tipo de Donación:"));
            panelPrincipal.add(cboTipoDonacion);
            panelPrincipal.add(new javax.swing.JLabel("Cantidad:"));
            panelPrincipal.add(txtCantidad);
            panelPrincipal.add(new javax.swing.JLabel("Calificación:"));
            panelPrincipal.add(panelCalificacion);
            panelPrincipal.add(new javax.swing.JLabel(""));
            panelPrincipal.add(new javax.swing.JLabel("* Campos obligatorios"));

            int resultado = JOptionPane.showConfirmDialog(this,
                    panelPrincipal,
                    "Modificar Donación",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE);

            if (resultado == JOptionPane.OK_OPTION) {
                if (voluntarioSeleccionado[0] == null) {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar un voluntario.");
                    return;
                }

                Double cantidad = null;
                if (!txtCantidad.getText().trim().isEmpty()) {
                    try {
                        cantidad = Double.parseDouble(txtCantidad.getText().trim());
                        if (cantidad <= 0) {
                            JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a cero.");
                            return;
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "La cantidad debe ser un número válido.");
                        return;
                    }
                }

                Donacion modificada = new Donacion();
                modificada.setId(actual.getId());
                modificada.setVoluntarioId(voluntarioSeleccionado[0].getId());
                modificada.setOrganizacionId(((Organizacion) cboOrganizacion.getSelectedItem()).getId());
                modificada.setTipoDonacionId(((TipoDonacion) cboTipoDonacion.getSelectedItem()).getId());
                modificada.setCantidad(cantidad);
                modificada.setCalificacion((Integer) spinCalificacion.getValue());

                donacionDAOImpl.modificar(modificada);

                JOptionPane.showMessageDialog(this, "Donación modificada correctamente.",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);

                donaciones = donacionDAOImpl.listarTodos();
                listarDonaciones();
                limpiarCampos();
            }

        } catch (Exception ex) {
            Logger.getLogger(AsignarDonacion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        String texto = jTextFieldBuscar.getText().trim();

        if (texto.isEmpty()) {
            listarDonaciones();
            return;
        }

        List<Donacion> resultados = donaciones.stream()
                .filter(d
                        -> d.getNombreVoluntario().toLowerCase().contains(texto.toLowerCase())
                || d.getNombreOrganizacion().toLowerCase().contains(texto.toLowerCase())
                || d.getNombreTipoDonacion().toLowerCase().contains(texto.toLowerCase())
                )
                .collect(Collectors.toList());

        DefaultTableModel modelo = (DefaultTableModel) jTableDonaciones.getModel();
        modelo.setRowCount(0);

        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No se encontraron donaciones con: \"" + texto + "\"",
                    "Sin resultados",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (Donacion d : resultados) {
                modelo.addRow(new Object[]{
                    d.getId(),
                    d.getNombreVoluntario(),
                    d.getNombreOrganizacion(),
                    d.getNombreTipoDonacion(),
                    d.getCantidad(),
                    d.getFecha(),
                    d.getCalificacion()
                });
            }
            jLabel2.setText("Donaciones: (" + resultados.size() + " encontradas)");
        }

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jTextFieldCalificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCalificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCalificacionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDonaciones;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldCalificacion;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldNombreOrganizacion;
    private javax.swing.JTextField jTextFieldNombreTipoDonacion;
    private javax.swing.JTextField jTextFieldVoluntario;
    // End of variables declaration//GEN-END:variables

    private void cargarDatosDonacion(int fila) {
        int id = (int) jTableDonaciones.getValueAt(fila, 0);
        donacionSeleccionada = buscarPorId(id);

        if (donacionSeleccionada != null) {
            jTextFieldVoluntario.setText(donacionSeleccionada.getNombreVoluntario());
            jTextFieldNombreOrganizacion.setText(donacionSeleccionada.getNombreOrganizacion());
            jTextFieldNombreTipoDonacion.setText(donacionSeleccionada.getNombreTipoDonacion());
            jTextFieldCantidad.setText(donacionSeleccionada.getCantidad() != null
                    ? donacionSeleccionada.getCantidad().toString() : "");

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            jTextFieldFecha.setText(donacionSeleccionada.getFecha() != null
                    ? sdf.format(donacionSeleccionada.getFecha()) : "");
            jTextFieldCalificacion.setText(donacionSeleccionada.getCalificacion() != null
                    ? donacionSeleccionada.getCalificacion().toString() : "");
        }
    }

    private void listarDonaciones() {
        DefaultTableModel modelo = (DefaultTableModel) jTableDonaciones.getModel();
        modelo.setRowCount(0);

        for (Donacion d : donaciones) {
            modelo.addRow(new Object[]{
                d.getId(),
                d.getNombreVoluntario(),
                d.getNombreOrganizacion(),
                d.getNombreTipoDonacion(),
                d.getCantidad(),
                d.getFecha(),
                d.getCalificacion()
            });
        }

        jLabel2.setText("Donaciones: (" + donaciones.size() + ")");
    }

    private void limpiarCampos() {
        jTextFieldVoluntario.setText("");
        jTextFieldNombreOrganizacion.setText("");
        jTextFieldNombreTipoDonacion.setText("");
        jTextFieldCantidad.setText("");
        jTextFieldFecha.setText("");
        jTextFieldCalificacion.setText("");
        donacionSeleccionada = new Donacion();
    }

    private Donacion buscarPorId(int id) {
        for (Donacion d : donaciones) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }
}
