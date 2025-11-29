package pe.proyecto.voluntariado.ui;

import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.proyecto.voluntariado.dao.impl.ActividadDAOImpl;
import pe.proyecto.voluntariado.dao.impl.CategoriaDAOImpl;
import pe.proyecto.voluntariado.dao.impl.OrganizacionDAOImpl;
import pe.proyecto.voluntariado.model.Actividad;
import pe.proyecto.voluntariado.model.Categoria;
import pe.proyecto.voluntariado.model.Organizacion;
import static pe.proyecto.voluntariado.service.ActividadUpdater.actualizarEstados;

public class GestionarActividades extends javax.swing.JFrame {

    List<Actividad> actividades;
    Actividad actividadSeleccionada = new Actividad();
    ActividadDAOImpl actividadDAOImpl = new ActividadDAOImpl();
    OrganizacionDAOImpl organizacionDAOImpl = new OrganizacionDAOImpl();
    CategoriaDAOImpl categoriaDAOImpl = new CategoriaDAOImpl();

    public GestionarActividades() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Sistema de voluntariado integrado (SVI)");
        jTextAreaDescripcion.setLineWrap(true);
        jTextAreaDescripcion.setWrapStyleWord(true);

        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    jButtonBuscarActionPerformed(null);
                }
            }
        });

        try {
            actividades = actividadDAOImpl.listarTodos();
            listarActividades();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error al listar actividades: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        jTableActividades.getSelectionModel().addListSelectionListener(evt -> {
            if (!evt.getValueIsAdjusting()) {
                int fila = jTableActividades.getSelectedRow();
                if (fila != -1) {
                    cargarDatosActividad(fila);
                }
            }
        });

        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    jButtonBuscarActionPerformed(null);
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
        jTableActividades = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldNombreOrganizacion = new javax.swing.JTextField();
        jTextFieldNombreActividad = new javax.swing.JTextField();
        jTextFieldNombreCategoria = new javax.swing.JTextField();
        jTextFieldFechaInicio = new javax.swing.JTextField();
        jButtonActualizar = new javax.swing.JButton();
        jButtonAgregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonModificar = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDescripcion = new javax.swing.JTextArea();
        jTextFieldFechaFin = new javax.swing.JTextField();
        jTextFieldEstado = new javax.swing.JTextField();
        jTextFieldUbicacion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion de actividades");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Actividades:");

        jTableActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Organización", "Categoria", "Nombre de la actividad", "Descripción", "Ubicación", "Fecha de inicio", "Fecha de fin", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableActividades);

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre de la actividad:");

        jLabel5.setText("Organización:");

        jLabel6.setText("Categoria:");

        jLabel7.setText("Descripción:");

        jLabel8.setText("Ubicación:");

        jTextFieldNombreOrganizacion.setEditable(false);

        jTextFieldNombreActividad.setEditable(false);

        jTextFieldNombreCategoria.setEditable(false);

        jTextFieldFechaInicio.setEditable(false);

        jButtonActualizar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

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

        jLabel9.setText("Fecha de inicio:");

        jLabel10.setText("Fecha de fin:");

        jLabel11.setText("Estado:");

        jTextAreaDescripcion.setEditable(false);
        jTextAreaDescripcion.setColumns(20);
        jTextAreaDescripcion.setRows(5);
        jTextAreaDescripcion.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextAreaDescripcion);

        jTextFieldFechaFin.setEditable(false);

        jTextFieldEstado.setEditable(false);

        jTextFieldUbicacion.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(17, 17, 17)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(46, 46, 46)
                        .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonBuscar)
                        .addGap(0, 920, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonModificar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel11))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldFechaFin, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldFechaInicio, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNombreActividad, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNombreOrganizacion, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNombreCategoria, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldUbicacion, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2)
                                    .addComponent(jTextFieldEstado))
                                .addContainerGap())))))
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
                            .addComponent(jTextFieldNombreActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNombreOrganizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAgregar)
                            .addComponent(jButtonModificar)
                            .addComponent(jButtonActualizar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new MenuPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        actualizarEstados();
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        javax.swing.JPanel panelPrincipal = new javax.swing.JPanel(new java.awt.GridLayout(8, 2, 10, 10));

        // Campos
        javax.swing.JTextField txtNombre = new javax.swing.JTextField(20);
        javax.swing.JTextArea txtDescripcion = new javax.swing.JTextArea(3, 20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        javax.swing.JScrollPane scrollDesc = new javax.swing.JScrollPane(txtDescripcion);
        javax.swing.JTextField txtUbicacion = new javax.swing.JTextField(20);

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
            Logger.getLogger(GestionarActividades.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,
                    "Error al cargar organizaciones: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // ComboBox de Categorías
        javax.swing.JComboBox<Categoria> cboCategoria = new javax.swing.JComboBox<>();
        try {
            List<Categoria> categorias = categoriaDAOImpl.listarTodos();
            DefaultComboBoxModel<Categoria> modeloCat = new DefaultComboBoxModel<>();
            for (Categoria cat : categorias) {
                modeloCat.addElement(cat);
            }
            cboCategoria.setModel(modeloCat);
        } catch (Exception ex) {
            Logger.getLogger(GestionarActividades.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,
                    "Error al cargar categorías: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // DateChoosers
        JDateChooser dateInicio = new JDateChooser();
        dateInicio.setDateFormatString("dd/MM/yyyy");
        JDateChooser dateFin = new JDateChooser();
        dateFin.setDateFormatString("dd/MM/yyyy");

        // Agregar componentes al panel
        panelPrincipal.add(new javax.swing.JLabel("* Nombre:"));
        panelPrincipal.add(txtNombre);
        panelPrincipal.add(new javax.swing.JLabel("* Organización:"));
        panelPrincipal.add(cboOrganizacion);
        panelPrincipal.add(new javax.swing.JLabel("* Categoría:"));
        panelPrincipal.add(cboCategoria);
        panelPrincipal.add(new javax.swing.JLabel("Ubicación:"));
        panelPrincipal.add(txtUbicacion);
        panelPrincipal.add(new javax.swing.JLabel("Descripción:"));
        panelPrincipal.add(scrollDesc);
        panelPrincipal.add(new javax.swing.JLabel("* Fecha Inicio:"));
        panelPrincipal.add(dateInicio);
        panelPrincipal.add(new javax.swing.JLabel("Fecha Fin:"));
        panelPrincipal.add(dateFin);
        panelPrincipal.add(new javax.swing.JLabel(""));
        panelPrincipal.add(new javax.swing.JLabel("* Campos obligatorios"));

        int resultado = JOptionPane.showConfirmDialog(this,
                panelPrincipal,
                "Agregar Nueva Actividad",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (resultado == JOptionPane.OK_OPTION) {
            // Validaciones
            if (txtNombre.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "El nombre de la actividad es obligatorio.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (cboOrganizacion.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this,
                        "Debe seleccionar una organización.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (cboCategoria.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this,
                        "Debe seleccionar una categoría.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (dateInicio.getDate() == null) {
                JOptionPane.showMessageDialog(this,
                        "La fecha de inicio es obligatoria.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Validar que fecha inicio no sea posterior a fecha fin
            if (dateFin.getDate() != null && dateInicio.getDate().after(dateFin.getDate())) {
                JOptionPane.showMessageDialog(this,
                        "La fecha de inicio no puede ser posterior a la fecha de fin.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                Actividad nueva = new Actividad();
                nueva.setNombre(txtNombre.getText().trim());
                nueva.setOrganizacionId(((Organizacion) cboOrganizacion.getSelectedItem()).getId());
                nueva.setCategoriaId(((Categoria) cboCategoria.getSelectedItem()).getId());
                nueva.setUbicacion(txtUbicacion.getText().trim().isEmpty()
                        ? null : txtUbicacion.getText().trim());
                nueva.setDescripcion(txtDescripcion.getText().trim().isEmpty()
                        ? null : txtDescripcion.getText().trim());
                nueva.setFechaInicio(dateInicio.getDate());
                nueva.setFechaFin(dateFin.getDate());

                actividadDAOImpl.insertar(nueva);

                JOptionPane.showMessageDialog(this,
                        "Actividad registrada correctamente.",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);

                // Recargar datos
                actividades = actividadDAOImpl.listarTodos();
                listarActividades();
                limpiarCampos();

            } catch (Exception ex) {
                Logger.getLogger(GestionarActividades.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this,
                        ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        if (actividadSeleccionada.getId() == null || actividadSeleccionada.getId() == 0) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione una actividad de la tabla antes de modificar.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Obtener datos actuales completos
            Actividad actual = actividadDAOImpl.buscarPorId(actividadSeleccionada.getId());

            if (actual == null) {
                JOptionPane.showMessageDialog(this,
                        "No se encontró la actividad seleccionada.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Panel principal
            javax.swing.JPanel panelPrincipal = new javax.swing.JPanel(new java.awt.GridLayout(8, 2, 10, 10));

            // Campos pre-llenados
            javax.swing.JTextField txtNombre = new javax.swing.JTextField(actual.getNombre(), 20);
            javax.swing.JTextArea txtDescripcion = new javax.swing.JTextArea(
                    actual.getDescripcion() != null ? actual.getDescripcion() : "", 3, 20);
            txtDescripcion.setLineWrap(true);
            txtDescripcion.setWrapStyleWord(true);
            javax.swing.JScrollPane scrollDesc = new javax.swing.JScrollPane(txtDescripcion);
            javax.swing.JTextField txtUbicacion = new javax.swing.JTextField(
                    actual.getUbicacion() != null ? actual.getUbicacion() : "", 20);

            // ComboBox de Organizaciones pre-seleccionado
            javax.swing.JComboBox<Organizacion> cboOrganizacion = new javax.swing.JComboBox<>();
            try {
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

                // Pre-seleccionar la organización actual
                if (orgActual != null) {
                    cboOrganizacion.setSelectedItem(orgActual);
                }
            } catch (Exception ex) {
                Logger.getLogger(GestionarActividades.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this,
                        "Error al cargar organizaciones: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // ComboBox de Categorías pre-seleccionado
            javax.swing.JComboBox<Categoria> cboCategoria = new javax.swing.JComboBox<>();
            try {
                List<Categoria> categorias = categoriaDAOImpl.listarTodos();
                DefaultComboBoxModel<Categoria> modeloCat = new DefaultComboBoxModel<>();

                Categoria catActual = null;
                for (Categoria cat : categorias) {
                    modeloCat.addElement(cat);
                    if (cat.getId().equals(actual.getCategoriaId())) {
                        catActual = cat;
                    }
                }
                cboCategoria.setModel(modeloCat);

                // Pre-seleccionar la categoría actual
                if (catActual != null) {
                    cboCategoria.setSelectedItem(catActual);
                }
            } catch (Exception ex) {
                Logger.getLogger(GestionarActividades.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this,
                        "Error al cargar categorías: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // DateChoosers pre-llenados
            JDateChooser dateInicio = new JDateChooser();
            dateInicio.setDateFormatString("dd/MM/yyyy");
            dateInicio.setDate(actual.getFechaInicio());

            JDateChooser dateFin = new JDateChooser();
            dateFin.setDateFormatString("dd/MM/yyyy");
            dateFin.setDate(actual.getFechaFin());

            // Agregar componentes al panel
            panelPrincipal.add(new javax.swing.JLabel("* Nombre:"));
            panelPrincipal.add(txtNombre);
            panelPrincipal.add(new javax.swing.JLabel("* Organización:"));
            panelPrincipal.add(cboOrganizacion);
            panelPrincipal.add(new javax.swing.JLabel("* Categoría:"));
            panelPrincipal.add(cboCategoria);
            panelPrincipal.add(new javax.swing.JLabel("Ubicación:"));
            panelPrincipal.add(txtUbicacion);
            panelPrincipal.add(new javax.swing.JLabel("Descripción:"));
            panelPrincipal.add(scrollDesc);
            panelPrincipal.add(new javax.swing.JLabel("* Fecha Inicio:"));
            panelPrincipal.add(dateInicio);
            panelPrincipal.add(new javax.swing.JLabel("Fecha Fin:"));
            panelPrincipal.add(dateFin);
            panelPrincipal.add(new javax.swing.JLabel(""));
            panelPrincipal.add(new javax.swing.JLabel("* Campos obligatorios"));

            int resultado = JOptionPane.showConfirmDialog(this,
                    panelPrincipal,
                    "Modificar Actividad: " + actual.getNombre(),
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE);

            if (resultado == JOptionPane.OK_OPTION) {
                // Validaciones
                if (txtNombre.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "El nombre de la actividad es obligatorio.",
                            "Advertencia",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (cboOrganizacion.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(this,
                            "Debe seleccionar una organización.",
                            "Advertencia",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (cboCategoria.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(this,
                            "Debe seleccionar una categoría.",
                            "Advertencia",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (dateInicio.getDate() == null) {
                    JOptionPane.showMessageDialog(this,
                            "La fecha de inicio es obligatoria.",
                            "Advertencia",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Validar que fecha inicio no sea posterior a fecha fin
                if (dateFin.getDate() != null && dateInicio.getDate().after(dateFin.getDate())) {
                    JOptionPane.showMessageDialog(this,
                            "La fecha de inicio no puede ser posterior a la fecha de fin.",
                            "Advertencia",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Confirmación
                int confirmacion = JOptionPane.showConfirmDialog(this,
                        "¿Está seguro de modificar la actividad:\n" + actual.getNombre() + "?",
                        "Confirmar Modificación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if (confirmacion != JOptionPane.YES_OPTION) {
                    return;
                }

                try {
                    Actividad modificada = new Actividad();
                    modificada.setId(actual.getId());
                    modificada.setNombre(txtNombre.getText().trim());
                    modificada.setOrganizacionId(((Organizacion) cboOrganizacion.getSelectedItem()).getId());
                    modificada.setCategoriaId(((Categoria) cboCategoria.getSelectedItem()).getId());
                    modificada.setUbicacion(txtUbicacion.getText().trim().isEmpty()
                            ? null : txtUbicacion.getText().trim());
                    modificada.setDescripcion(txtDescripcion.getText().trim().isEmpty()
                            ? null : txtDescripcion.getText().trim());
                    modificada.setFechaInicio(dateInicio.getDate());
                    modificada.setFechaFin(dateFin.getDate());

                    actividadDAOImpl.modificar(modificada);

                    JOptionPane.showMessageDialog(this,
                            "Actividad modificada correctamente.",
                            "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);

                    // Recargar datos
                    actividades = actividadDAOImpl.listarTodos();
                    listarActividades();
                    limpiarCampos();

                } catch (Exception ex) {
                    Logger.getLogger(GestionarActividades.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this,
                            ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(GestionarActividades.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,
                    "Error al cargar los datos de la actividad: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        String texto = jTextFieldBuscar.getText().trim();

        if (texto.isEmpty()) {
            listarActividades();
            return;
        }

        List<Actividad> resultados = actividades.stream()
                .filter(a
                        -> a.getNombre().toLowerCase().contains(texto.toLowerCase())
                || a.getNombreOrganizacion().toLowerCase().contains(texto.toLowerCase())
                || a.getNombreCategoria().toLowerCase().contains(texto.toLowerCase())
                || (a.getUbicacion() != null && a.getUbicacion().toLowerCase().contains(texto.toLowerCase()))
                || (a.getEstado() != null && a.getEstado().toLowerCase().contains(texto.toLowerCase()))
                )
                .collect(Collectors.toList());

        DefaultTableModel modelo = (DefaultTableModel) jTableActividades.getModel();
        modelo.setRowCount(0);

        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No se encontraron actividades con: \"" + texto + "\"",
                    "Sin resultados",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (Actividad a : resultados) {
                modelo.addRow(new Object[]{
                    a.getId(),
                    a.getNombreOrganizacion(),
                    a.getNombreCategoria(),
                    a.getNombre(),
                    a.getDescripcion(),
                    a.getUbicacion(),
                    a.getFechaInicio(),
                    a.getFechaFin(),
                    a.getEstado()
                });
            }
            jLabel2.setText("Actividades: (" + resultados.size() + " encontradas)");
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableActividades;
    private javax.swing.JTextArea jTextAreaDescripcion;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldEstado;
    private javax.swing.JTextField jTextFieldFechaFin;
    private javax.swing.JTextField jTextFieldFechaInicio;
    private javax.swing.JTextField jTextFieldNombreActividad;
    private javax.swing.JTextField jTextFieldNombreCategoria;
    private javax.swing.JTextField jTextFieldNombreOrganizacion;
    private javax.swing.JTextField jTextFieldUbicacion;
    // End of variables declaration//GEN-END:variables

    private void cargarDatosActividad(int fila) {
        int id = (int) jTableActividades.getValueAt(fila, 0);
        actividadSeleccionada = buscarPorId(id);

        if (actividadSeleccionada != null) {
            jTextFieldNombreActividad.setText(actividadSeleccionada.getNombre());
            jTextFieldNombreOrganizacion.setText(actividadSeleccionada.getNombreOrganizacion());
            jTextFieldNombreCategoria.setText(actividadSeleccionada.getNombreCategoria());
            jTextFieldUbicacion.setText(actividadSeleccionada.getUbicacion() != null
                    ? actividadSeleccionada.getUbicacion() : "");
            jTextAreaDescripcion.setText(actividadSeleccionada.getDescripcion() != null
                    ? actividadSeleccionada.getDescripcion() : "");

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            jTextFieldFechaInicio.setText(actividadSeleccionada.getFechaInicio() != null
                    ? sdf.format(actividadSeleccionada.getFechaInicio()) : "");
            jTextFieldFechaFin.setText(actividadSeleccionada.getFechaFin() != null
                    ? sdf.format(actividadSeleccionada.getFechaFin()) : "");
            jTextFieldEstado.setText(actividadSeleccionada.getEstado());
        }
    }

    private void listarActividades() {
        DefaultTableModel modelo = (DefaultTableModel) jTableActividades.getModel();
        modelo.setRowCount(0);

        for (Actividad a : actividades) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNombreOrganizacion(),
                a.getNombreCategoria(),
                a.getNombre(),
                a.getDescripcion(),
                a.getUbicacion(),
                a.getFechaInicio(),
                a.getFechaFin(),
                a.getEstado()
            });
        }

        jLabel2.setText("Actividades: (" + actividades.size() + ")");
    }

    private void limpiarCampos() {
        jTextFieldNombreActividad.setText("");
        jTextFieldNombreOrganizacion.setText("");
        jTextFieldNombreCategoria.setText("");
        jTextFieldUbicacion.setText("");
        jTextAreaDescripcion.setText("");
        jTextFieldFechaInicio.setText("");
        jTextFieldFechaFin.setText("");
        jTextFieldEstado.setText("");
        actividadSeleccionada = new Actividad();
    }

    private Actividad buscarPorId(int id) {
        for (Actividad a : actividades) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }
}
