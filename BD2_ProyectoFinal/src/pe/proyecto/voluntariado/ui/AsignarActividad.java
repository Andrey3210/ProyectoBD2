package pe.proyecto.voluntariado.ui;

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
import pe.proyecto.voluntariado.dao.impl.AsignacionActividadDAOImpl;
import pe.proyecto.voluntariado.dao.impl.ActividadDAOImpl;
import pe.proyecto.voluntariado.dao.impl.VoluntarioDAOImpl;
import pe.proyecto.voluntariado.model.AsignacionActividad;
import pe.proyecto.voluntariado.model.Actividad;
import pe.proyecto.voluntariado.model.Voluntario;

public class AsignarActividad extends javax.swing.JFrame {

    List<AsignacionActividad> asignaciones;
    AsignacionActividad asignacionSeleccionada = new AsignacionActividad();
    AsignacionActividadDAOImpl asignacionDAO = new AsignacionActividadDAOImpl();
    VoluntarioDAOImpl voluntarioDAO = new VoluntarioDAOImpl();
    ActividadDAOImpl actividadDAO = new ActividadDAOImpl();

    public AsignarActividad() {
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
            asignaciones = asignacionDAO.listarTodos();
            listarAsignaciones();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                "Error al listar asignaciones: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
        
        jTableActividadesAsignadas.getSelectionModel().addListSelectionListener(evt -> {
            if (!evt.getValueIsAdjusting()) {
                int fila = jTableActividadesAsignadas.getSelectedRow();
                if (fila != -1) {
                    cargarDatosAsignacion(fila);
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
        jTableActividadesAsignadas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldNombreOrganizacion = new javax.swing.JTextField();
        jTextFieldNombreTipoDonacion = new javax.swing.JTextField();
        jTextFieldVoluntario = new javax.swing.JTextField();
        jButtonAgregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonModificar = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jTextFieldFecha = new javax.swing.JTextField();
        jTextFieldCantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Asignar actividades");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Actividades:");

        jTableActividadesAsignadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Voluntario", "Actividad", "Fecha", "Estado", "Calificación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableActividadesAsignadas);

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Voluntario:");

        jLabel5.setText("Actividad:");

        jLabel6.setText("Fecha:");

        jLabel7.setText("Calificación:");

        jLabel8.setText("Estado:");

        jTextFieldNombreOrganizacion.setEditable(false);

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
                                    .addComponent(jLabel4))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldFecha, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldVoluntario, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNombreOrganizacion, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNombreTipoDonacion, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonModificar)))
                                .addGap(0, 89, Short.MAX_VALUE)))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAgregar)
                            .addComponent(jButtonModificar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new MenuPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        javax.swing.JPanel panelPrincipal = new javax.swing.JPanel(new java.awt.GridLayout(4, 2, 10, 10));
        
        // Buscador de Voluntario
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
                    List<Voluntario> voluntarios = voluntarioDAO.listarTodos().stream()
                        .filter(v -> 
                            v.getDni().contains(busqueda) ||
                            v.getNombres().toLowerCase().contains(busqueda.toLowerCase()) ||
                            v.getApellidos().toLowerCase().contains(busqueda.toLowerCase()) ||
                            (v.getNombres() + " " + v.getApellidos()).toLowerCase().contains(busqueda.toLowerCase())
                        )
                        .collect(Collectors.toList());
                    
                    if (voluntarios.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "No se encontraron voluntarios.");
                    } else if (voluntarios.size() == 1) {
                        voluntarioSeleccionado[0] = voluntarios.get(0);
                        txtVoluntarioBuscar.setText(voluntarioSeleccionado[0].getDni() + " - " + 
                            voluntarioSeleccionado[0].getNombres() + " " + 
                            voluntarioSeleccionado[0].getApellidos());
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
        
        // ComboBox de Actividades
        javax.swing.JComboBox<Actividad> cboActividad = new javax.swing.JComboBox<>();
        final Actividad[] actividadSeleccionada = {null};
        
        try {
            List<Actividad> actividades = actividadDAO.listarTodos();
            DefaultComboBoxModel<Actividad> modeloAct = new DefaultComboBoxModel<>();
            for (Actividad act : actividades) {
                modeloAct.addElement(act);
            }
            cboActividad.setModel(modeloAct);
            if (actividades.size() > 0) {
                actividadSeleccionada[0] = actividades.get(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(AsignarActividad.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al cargar actividades: " + ex.getMessage());
            return;
        }
        
        // Spinner para calificación con límite dinámico
        JSpinner spinCalificacion = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        javax.swing.JLabel lblCalificacionMax = new javax.swing.JLabel("(Máx: 100)");
        javax.swing.JPanel panelCalificacion = new javax.swing.JPanel(new java.awt.BorderLayout(5, 0));
        panelCalificacion.add(spinCalificacion, java.awt.BorderLayout.CENTER);
        panelCalificacion.add(lblCalificacionMax, java.awt.BorderLayout.EAST);
        
        // Listener para actualizar calificación máxima según actividad
        cboActividad.addActionListener(e -> {
            Actividad act = (Actividad) cboActividad.getSelectedItem();
            if (act != null) {
                actividadSeleccionada[0] = act;
                try {
                    Actividad completa = actividadDAO.buscarPorId(act.getId());
                    if (completa != null) {
                        // Obtener calificación máxima de la categoría
                        int maxCal = 100; // Valor por defecto
                        // Aquí deberías obtener calificacionMax de la categoría de la actividad
                        // desde la vista o hacer una consulta adicional
                        
                        ((SpinnerNumberModel)spinCalificacion.getModel()).setMaximum(maxCal);
                        int valorActual = (Integer)spinCalificacion.getValue();
                        if (valorActual > maxCal) {
                            spinCalificacion.setValue(maxCal);
                        }
                        lblCalificacionMax.setText("(Máx: " + maxCal + ")");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(AsignarActividad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        // Disparar evento inicial
        if (cboActividad.getItemCount() > 0) {
            cboActividad.setSelectedIndex(0);
        }
        
        // Agregar componentes
        panelPrincipal.add(new javax.swing.JLabel("* Voluntario:"));
        panelPrincipal.add(panelVoluntario);
        panelPrincipal.add(new javax.swing.JLabel("* Actividad:"));
        panelPrincipal.add(cboActividad);
        panelPrincipal.add(new javax.swing.JLabel("Calificación:"));
        panelPrincipal.add(panelCalificacion);
        panelPrincipal.add(new javax.swing.JLabel(""));
        panelPrincipal.add(new javax.swing.JLabel("* Campos obligatorios"));
        
        int resultado = JOptionPane.showConfirmDialog(this,
            panelPrincipal,
            "Asignar Voluntario a Actividad",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE);
        
        if (resultado == JOptionPane.OK_OPTION) {
            if (voluntarioSeleccionado[0] == null) {
                JOptionPane.showMessageDialog(this, 
                    "Debe buscar y seleccionar un voluntario.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if (cboActividad.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una actividad.", 
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            try {
                AsignacionActividad nueva = new AsignacionActividad();
                nueva.setVoluntarioId(voluntarioSeleccionado[0].getId());
                nueva.setActividadId(((Actividad)cboActividad.getSelectedItem()).getId());
                nueva.setCalificacion((Integer)spinCalificacion.getValue());
                
                asignacionDAO.insertar(nueva);
                
                JOptionPane.showMessageDialog(this,
                    "Asignación registrada correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
                
                asignaciones = asignacionDAO.listarTodos();
                listarAsignaciones();
                limpiarCampos();
                
            } catch (Exception ex) {
                Logger.getLogger(AsignarActividad.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        if (asignacionSeleccionada.getId() == null || asignacionSeleccionada.getId() == 0) {
            JOptionPane.showMessageDialog(this,
                "Seleccione una asignación de la tabla antes de modificar.",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            AsignacionActividad actual = asignacionDAO.buscarPorId(asignacionSeleccionada.getId());
            
            if (actual == null) {
                JOptionPane.showMessageDialog(this, "No se encontró la asignación seleccionada.");
                return;
            }
            
            javax.swing.JPanel panelPrincipal = new javax.swing.JPanel(new java.awt.GridLayout(5, 2, 10, 10));
            
            // Buscador de Voluntario pre-cargado
            javax.swing.JPanel panelVoluntario = new javax.swing.JPanel(new java.awt.BorderLayout(5, 0));
            javax.swing.JTextField txtVoluntarioBuscar = new javax.swing.JTextField();
            txtVoluntarioBuscar.setEditable(false);
            javax.swing.JButton btnBuscarVol = new javax.swing.JButton("🔍");
            panelVoluntario.add(txtVoluntarioBuscar, java.awt.BorderLayout.CENTER);
            panelVoluntario.add(btnBuscarVol, java.awt.BorderLayout.EAST);
            
            final Voluntario[] voluntarioSeleccionado = {null};
            try {
                voluntarioSeleccionado[0] = voluntarioDAO.buscarPorId(actual.getVoluntarioId());
                if (voluntarioSeleccionado[0] != null) {
                    txtVoluntarioBuscar.setText(voluntarioSeleccionado[0].getDni() + " - " + 
                        voluntarioSeleccionado[0].getNombres() + " " + 
                        voluntarioSeleccionado[0].getApellidos());
                }
            } catch (Exception ex) {
                Logger.getLogger(AsignarActividad.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            btnBuscarVol.addActionListener(e -> {
                // Similar al código de agregar...
            });
            
            // ComboBox de Actividades pre-seleccionado
            javax.swing.JComboBox<Actividad> cboActividad = new javax.swing.JComboBox<>();
            List<Actividad> actividades = actividadDAO.listarTodos();
            DefaultComboBoxModel<Actividad> modeloAct = new DefaultComboBoxModel<>();
            Actividad actActual = null;
            for (Actividad act : actividades) {
                modeloAct.addElement(act);
                if (act.getId().equals(actual.getActividadId())) {
                    actActual = act;
                }
            }
            cboActividad.setModel(modeloAct);
            if (actActual != null) cboActividad.setSelectedItem(actActual);
            
            // ComboBox de Estado
            String[] estados = {"Pendiente", "En proceso", "Completada"};
            javax.swing.JComboBox<String> cboEstado = new javax.swing.JComboBox<>(estados);
            if (actual.getEstado() != null) {
                cboEstado.setSelectedItem(actual.getEstado());
            }
            
            // Spinner de calificación
            JSpinner spinCalificacion = new JSpinner(new SpinnerNumberModel(
                actual.getCalificacion() != null ? actual.getCalificacion() : 0, 
                0, 100, 1));
            
            panelPrincipal.add(new javax.swing.JLabel("* Voluntario:"));
            panelPrincipal.add(panelVoluntario);
            panelPrincipal.add(new javax.swing.JLabel("* Actividad:"));
            panelPrincipal.add(cboActividad);
            panelPrincipal.add(new javax.swing.JLabel("* Estado:"));
            panelPrincipal.add(cboEstado);
            panelPrincipal.add(new javax.swing.JLabel("Calificación:"));
            panelPrincipal.add(spinCalificacion);
            panelPrincipal.add(new javax.swing.JLabel(""));
            panelPrincipal.add(new javax.swing.JLabel("* Campos obligatorios"));
            
            int resultado = JOptionPane.showConfirmDialog(this,
                panelPrincipal,
                "Modificar Asignación",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
            
            if (resultado == JOptionPane.OK_OPTION) {
                if (voluntarioSeleccionado[0] == null) {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar un voluntario.");
                    return;
                }
                
                AsignacionActividad modificada = new AsignacionActividad();
                modificada.setId(actual.getId());
                modificada.setVoluntarioId(voluntarioSeleccionado[0].getId());
                modificada.setActividadId(((Actividad)cboActividad.getSelectedItem()).getId());
                modificada.setEstado((String)cboEstado.getSelectedItem());
                modificada.setCalificacion((Integer)spinCalificacion.getValue());
                
                asignacionDAO.modificar(modificada);
                
                JOptionPane.showMessageDialog(this, "Asignación modificada correctamente.", 
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
                
                asignaciones = asignacionDAO.listarTodos();
                listarAsignaciones();
                limpiarCampos();
            }
            
        } catch (Exception ex) {
            Logger.getLogger(AsignarActividad.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        String texto = jTextFieldBuscar.getText().trim();
        
        if (texto.isEmpty()) {
            listarAsignaciones();
            return;
        }
        
        List<AsignacionActividad> resultados = asignaciones.stream()
            .filter(aa -> 
                aa.getNombreVoluntario().toLowerCase().contains(texto.toLowerCase()) ||
                aa.getNombreActividad().toLowerCase().contains(texto.toLowerCase()) ||
                (aa.getEstado() != null && aa.getEstado().toLowerCase().contains(texto.toLowerCase()))
            )
            .collect(Collectors.toList());
        
        DefaultTableModel modelo = (DefaultTableModel) jTableActividadesAsignadas.getModel();
        modelo.setRowCount(0);
        
        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "No se encontraron asignaciones con: \"" + texto + "\"",
                "Sin resultados",
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (AsignacionActividad aa : resultados) {
                modelo.addRow(new Object[]{
                    aa.getId(),
                    aa.getNombreVoluntario(),
                    aa.getNombreActividad(),
                    aa.getFecha(),
                    aa.getEstado(),
                    aa.getCalificacion()
                });
            }
            jLabel2.setText("Actividades asignadas: (" + resultados.size() + " encontradas)");
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed


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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableActividadesAsignadas;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldNombreOrganizacion;
    private javax.swing.JTextField jTextFieldNombreTipoDonacion;
    private javax.swing.JTextField jTextFieldVoluntario;
    // End of variables declaration//GEN-END:variables

    private void cargarDatosAsignacion(int fila) {
        int id = (int) jTableActividadesAsignadas.getValueAt(fila, 0);
        asignacionSeleccionada = buscarPorId(id);
        
        if (asignacionSeleccionada != null) {
            jTextFieldVoluntario.setText(asignacionSeleccionada.getNombreVoluntario());
            jTextFieldNombreOrganizacion.setText(asignacionSeleccionada.getNombreActividad());
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            jTextFieldNombreTipoDonacion.setText(asignacionSeleccionada.getFecha() != null ? 
                sdf.format(asignacionSeleccionada.getFecha()) : "");
            jTextFieldCantidad.setText(asignacionSeleccionada.getEstado() != null ? 
                asignacionSeleccionada.getEstado() : "");
            jTextFieldFecha.setText(asignacionSeleccionada.getCalificacion() != null ? 
                asignacionSeleccionada.getCalificacion().toString() : "");
        }
    }
    
    private void listarAsignaciones() {
        DefaultTableModel modelo = (DefaultTableModel) jTableActividadesAsignadas.getModel();
        modelo.setRowCount(0);
        
        for (AsignacionActividad aa : asignaciones) {
            modelo.addRow(new Object[]{
                aa.getId(),
                aa.getNombreVoluntario(),
                aa.getNombreActividad(),
                aa.getFecha(),
                aa.getEstado(),
                aa.getCalificacion()
            });
        }
        
        jLabel2.setText("Actividades asignadas: (" + asignaciones.size() + ")");
    }
    
    private void limpiarCampos() {
        jTextFieldVoluntario.setText("");
        jTextFieldNombreOrganizacion.setText("");
        jTextFieldNombreTipoDonacion.setText("");
        jTextFieldCantidad.setText("");
        jTextFieldFecha.setText("");
        asignacionSeleccionada = new AsignacionActividad();
    }
    
    private AsignacionActividad buscarPorId(int id) {
        for (AsignacionActividad aa : asignaciones) {
            if (aa.getId() == id) {
                return aa;
            }
        }
        return null;
    }
}
