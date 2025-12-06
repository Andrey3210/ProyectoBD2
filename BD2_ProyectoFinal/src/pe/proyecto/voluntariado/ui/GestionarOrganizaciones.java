/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pe.proyecto.voluntariado.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import pe.proyecto.voluntariado.dao.OrganizacionDAO;
import pe.proyecto.voluntariado.dao.impl.OrganizacionDAOImpl;
import pe.proyecto.voluntariado.model.Organizacion;

public class GestionarOrganizaciones extends javax.swing.JFrame {

    List<Organizacion> organizacionesInactivas, organizacionesActivas;
    Organizacion organizacionSeleccionada = new Organizacion();
    OrganizacionDAO dao = new OrganizacionDAOImpl();

    public GestionarOrganizaciones() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Sistema de voluntariado integrado (SVI)");
        jToggleButtonTablaSwitch.setSelected(false);
        jToggleButtonTablaSwitch.setText("Mostrar organizaciones inactivas");
        jButtonCambiarEstado.setSelected(false);
        jButtonCambiarEstado.setText("Desactivar");

        try {
            organizacionesInactivas = dao.listarInactivas();
            organizacionesActivas = dao.listarActivas();
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Error al listar organizaciones: " + ex.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }

        listarActivas();

        jTableOrganizaciones.getSelectionModel().addListSelectionListener(evt -> {
            if (!evt.getValueIsAdjusting()) {
                int fila = jTableOrganizaciones.getSelectedRow();
                if (fila != -1) {
                    jTextFieldNombre.setText(jTableOrganizaciones.getValueAt(fila, 1).toString());
                    jTextFieldDireccion.setText(jTableOrganizaciones.getValueAt(fila, 2).toString());
                    jTextFieldTelefono.setText(jTableOrganizaciones.getValueAt(fila, 3).toString());
                    jTextFieldEmail.setText(jTableOrganizaciones.getValueAt(fila, 4).toString());
                    jTextFieldFecha.setText(jTableOrganizaciones.getValueAt(fila, 5).toString());

                    organizacionSeleccionada.setId((Integer) jTableOrganizaciones.getValueAt(fila, 0));
                    organizacionSeleccionada.setNombre(
                            jTableOrganizaciones.getValueAt(fila, 1).toString()
                    );
                    organizacionSeleccionada.setDireccion(
                            jTableOrganizaciones.getValueAt(fila, 2).toString()
                    );
                    organizacionSeleccionada.setTelefono(
                            jTableOrganizaciones.getValueAt(fila, 3).toString()
                    );
                    organizacionSeleccionada.setEmail(
                            jTableOrganizaciones.getValueAt(fila, 4).toString()
                    );
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
        jTableOrganizaciones = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jToggleButtonTablaSwitch = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldDireccion = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldFecha = new javax.swing.JTextField();
        jButtonCambiarEstado = new javax.swing.JButton();
        jButtonAgregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonModificar = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion de organizaciones");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Organizaciones activas:");

        jTableOrganizaciones.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null}
                },
                new String[]{
                    "ID", "Nombre", "Dirección", "Teléfono", "Email", "Fecha de registro"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableOrganizaciones);

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jToggleButtonTablaSwitch.setText("Mostrar organizaciones inactivas");
        jToggleButtonTablaSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonTablaSwitchActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre:");

        jLabel5.setText("Dirección:");

        jLabel6.setText("Teléfono:");

        jLabel7.setText("Email:");

        jLabel8.setText("Fecha de registro:");

        jTextFieldDireccion.setEditable(false);

        jTextFieldNombre.setEditable(false);

        jTextFieldTelefono.setEditable(false);

        jTextFieldEmail.setEditable(false);

        jTextFieldFecha.setEditable(false);

        jButtonCambiarEstado.setBackground(new java.awt.Color(255, 51, 51));
        jButtonCambiarEstado.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCambiarEstado.setText("Desactivar");
        jButtonCambiarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCambiarEstadoActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel2)
                                                .addGap(46, 46, 46)
                                                .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonBuscar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jToggleButtonTablaSwitch)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jButtonCambiarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jButtonAgregar)
                                                        .addComponent(jButtonModificar)
                                                        .addComponent(jLabel4))
                                                .addGap(12, 12, 12)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTextFieldDireccion)
                                                        .addComponent(jTextFieldNombre))))
                                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jToggleButtonTablaSwitch)
                                        .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonBuscar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(11, 11, 11)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButtonCambiarEstado)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButtonAgregar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButtonModificar)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new MenuPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jToggleButtonTablaSwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonTablaSwitchActionPerformed
        jToggleButtonTablaSwitch.setEnabled(false);
        jButtonCambiarEstado.setEnabled(false);
        limpiarCampos();
        try {
            if (jToggleButtonTablaSwitch.isSelected()) {
                listarInactivas();
                jToggleButtonTablaSwitch.setText("Mostrar organizaciones activas:");
                jLabel2.setText("Organizaciones inactivas");
                jButtonCambiarEstado.setText("Activar");
            } else {
                listarActivas();
                jToggleButtonTablaSwitch.setText("Mostrar organizaciones inactivas:");
                jLabel2.setText("Organizaciones activas");
                jButtonCambiarEstado.setText("Desactivar");
            }
        } finally {
            jToggleButtonTablaSwitch.setEnabled(true);
            jButtonCambiarEstado.setEnabled(true);
        }
    }//GEN-LAST:event_jToggleButtonTablaSwitchActionPerformed

    private void jButtonCambiarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCambiarEstadoActionPerformed
        if (organizacionSeleccionada.getId() == null || organizacionSeleccionada.getId() == 0) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Por favor, seleccione una organización de la tabla.",
                    "Advertencia",
                    javax.swing.JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        String accion = jToggleButtonTablaSwitch.isSelected() ? "activar" : "desactivar";
        String mensaje = String.format(
                "¿Está seguro de %s la organización:\n%s?",
                accion,
                organizacionSeleccionada.getNombre()
        );

        int confirmacion = javax.swing.JOptionPane.showConfirmDialog(
                this,
                mensaje,
                "Confirmar " + (jToggleButtonTablaSwitch.isSelected() ? "Activación" : "Desactivación"),
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE
        );

        if (confirmacion != javax.swing.JOptionPane.YES_OPTION) {
            return;
        }

        try {
            if (jToggleButtonTablaSwitch.isSelected()) {
                dao.activarOrganizacion(organizacionSeleccionada.getId());
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Organización activada correctamente.",
                        "Éxito",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                dao.desactivarOrganizacion(organizacionSeleccionada.getId());
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Organización desactivada correctamente.",
                        "Éxito",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE
                );
            }

            organizacionesInactivas = dao.listarInactivas();
            organizacionesActivas = dao.listarActivas();

            if (jToggleButtonTablaSwitch.isSelected()) {
                listarInactivas();
            } else {
                listarActivas();
            }

            limpiarCampos();

        } catch (Exception ex) {
            Logger.getLogger(GestionarOrganizaciones.class.getName()).log(Level.SEVERE, null, ex);
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Error al " + accion + " la organización:\n" + ex.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jButtonCambiarEstadoActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.GridLayout(5, 2, 10, 10));

        javax.swing.JTextField txtNombre = new javax.swing.JTextField(20);
        javax.swing.JTextField txtDireccion = new javax.swing.JTextField(20);
        javax.swing.JTextField txtTelefono = new javax.swing.JTextField(20);
        javax.swing.JTextField txtEmail = new javax.swing.JTextField(20);

        panel.add(new javax.swing.JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new javax.swing.JLabel("Dirección:"));
        panel.add(txtDireccion);
        panel.add(new javax.swing.JLabel("Teléfono:"));
        panel.add(txtTelefono);
        panel.add(new javax.swing.JLabel("Email:"));
        panel.add(txtEmail);
        panel.add(new javax.swing.JLabel(""));
        panel.add(new javax.swing.JLabel("* Todos los campos son obligatorios"));

        int resultado = javax.swing.JOptionPane.showConfirmDialog(
                this,
                panel,
                "Agregar Nueva Organización",
                javax.swing.JOptionPane.OK_CANCEL_OPTION,
                javax.swing.JOptionPane.PLAIN_MESSAGE
        );

        if (resultado == javax.swing.JOptionPane.OK_OPTION) {
            if (txtNombre.getText().trim().isEmpty()
                    || txtDireccion.getText().trim().isEmpty()
                    || txtTelefono.getText().trim().isEmpty()
                    || txtEmail.getText().trim().isEmpty()) {

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Todos los campos son obligatorios.",
                        "Advertencia",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if (!txtEmail.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "El formato del email no es válido.",
                        "Advertencia",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if (!txtTelefono.getText().matches("^[0-9]{7,15}$")) {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "El teléfono debe contener solo números (7-15 dígitos).",
                        "Advertencia",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            try {
                Organizacion nuevaOrg = new Organizacion();
                nuevaOrg.setNombre(txtNombre.getText().trim());
                nuevaOrg.setDireccion(txtDireccion.getText().trim());
                nuevaOrg.setTelefono(txtTelefono.getText().trim());
                nuevaOrg.setEmail(txtEmail.getText().trim());

                dao.insertar(nuevaOrg);

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Organización agregada correctamente.",
                        "Éxito",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE
                );

                organizacionesInactivas = dao.listarInactivas();
                organizacionesActivas = dao.listarActivas();

                if (jToggleButtonTablaSwitch.isSelected()) {
                    listarInactivas();
                } else {
                    listarActivas();
                }

                limpiarCampos();

            } catch (Exception ex) {
                Logger.getLogger(GestionarOrganizaciones.class.getName()).log(Level.SEVERE, null, ex);
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Error al agregar la organización:\n" + ex.getMessage(),
                        "Error",
                        javax.swing.JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        if (organizacionSeleccionada.getId() == null || organizacionSeleccionada.getId() == 0) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Por favor, seleccione una organización de la tabla.",
                    "Advertencia",
                    javax.swing.JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.GridLayout(5, 2, 10, 10));

        javax.swing.JTextField txtNombre = new javax.swing.JTextField(organizacionSeleccionada.getNombre(), 20);
        javax.swing.JTextField txtDireccion = new javax.swing.JTextField(organizacionSeleccionada.getDireccion(), 20);
        javax.swing.JTextField txtTelefono = new javax.swing.JTextField(organizacionSeleccionada.getTelefono(), 20);
        javax.swing.JTextField txtEmail = new javax.swing.JTextField(organizacionSeleccionada.getEmail(), 20);

        panel.add(new javax.swing.JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new javax.swing.JLabel("Dirección:"));
        panel.add(txtDireccion);
        panel.add(new javax.swing.JLabel("Teléfono:"));
        panel.add(txtTelefono);
        panel.add(new javax.swing.JLabel("Email:"));
        panel.add(txtEmail);
        panel.add(new javax.swing.JLabel(""));
        panel.add(new javax.swing.JLabel("* Campos obligatorios"));

        int resultado = javax.swing.JOptionPane.showConfirmDialog(
                this,
                panel,
                "Modificar Organización: " + organizacionSeleccionada.getNombre(),
                javax.swing.JOptionPane.OK_CANCEL_OPTION,
                javax.swing.JOptionPane.PLAIN_MESSAGE
        );

        if (resultado == javax.swing.JOptionPane.OK_OPTION) {
            if (txtNombre.getText().trim().isEmpty()
                    || txtDireccion.getText().trim().isEmpty()
                    || txtTelefono.getText().trim().isEmpty()
                    || txtEmail.getText().trim().isEmpty()) {

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Todos los campos son obligatorios.",
                        "Advertencia",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if (!txtEmail.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "El formato del email no es válido.",
                        "Advertencia",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if (!txtTelefono.getText().matches("^[0-9]{7,15}$")) {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "El teléfono debe contener solo números (7-15 dígitos).",
                        "Advertencia",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            int confirmacion = javax.swing.JOptionPane.showConfirmDialog(
                    this,
                    "¿Está seguro de modificar la organización:\n" + organizacionSeleccionada.getNombre() + "?",
                    "Confirmar Modificación",
                    javax.swing.JOptionPane.YES_NO_OPTION,
                    javax.swing.JOptionPane.QUESTION_MESSAGE
            );

            if (confirmacion != javax.swing.JOptionPane.YES_OPTION) {
                return;
            }

            try {
                Organizacion orgModificada = new Organizacion();
                orgModificada.setId(organizacionSeleccionada.getId());
                orgModificada.setNombre(txtNombre.getText().trim());
                orgModificada.setDireccion(txtDireccion.getText().trim());
                orgModificada.setTelefono(txtTelefono.getText().trim());
                orgModificada.setEmail(txtEmail.getText().trim());

                dao.modificar(orgModificada);

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Organización modificada correctamente.",
                        "Éxito",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE
                );

                organizacionesActivas = dao.listarActivas();
                organizacionesInactivas = dao.listarInactivas();

                if (jToggleButtonTablaSwitch.isSelected()) {
                    listarInactivas();
                } else {
                    listarActivas();
                }

                limpiarCampos();

            } catch (Exception ex) {
                Logger.getLogger(GestionarOrganizaciones.class.getName()).log(Level.SEVERE, null, ex);
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage(),
                        "Error",
                        javax.swing.JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        String textoBusqueda = jTextFieldBuscar.getText().trim().toLowerCase();

        if (textoBusqueda.isEmpty()) {
            if (jToggleButtonTablaSwitch.isSelected()) {
                listarInactivas();
            } else {
                listarActivas();
            }
            jLabel2.setText(jToggleButtonTablaSwitch.isSelected()
                    ? "Organizaciones inactivas:"
                    : "Organizaciones activas:");
            return;
        }

        List<Organizacion> listaActual = jToggleButtonTablaSwitch.isSelected()
                ? organizacionesInactivas
                : organizacionesActivas;

        List<Organizacion> resultados = buscarEnLista(listaActual, textoBusqueda);

        if (resultados.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "No se encontraron organizaciones que coincidan con: " + jTextFieldBuscar.getText(),
                    "Sin resultados",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE
            );
            DefaultTableModel modelo = (DefaultTableModel) jTableOrganizaciones.getModel();
            modelo.setRowCount(0);
        } else {
            mostrarResultados(resultados);
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCambiarEstado;
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
    private javax.swing.JTable jTableOrganizaciones;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTelefono;
    private javax.swing.JToggleButton jToggleButtonTablaSwitch;
    // End of variables declaration//GEN-END:variables

    private void listarActivas() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) jTableOrganizaciones.getModel();
            modelo.setRowCount(0);

            for (Organizacion org : organizacionesActivas) {
                modelo.addRow(new Object[]{
                    org.getId(),
                    org.getNombre(),
                    org.getDireccion(),
                    org.getTelefono(),
                    org.getEmail(),
                    org.getFechaRegistro()
                });
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Error al listar organizaciones: " + ex.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void listarInactivas() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) jTableOrganizaciones.getModel();
            modelo.setRowCount(0);

            for (Organizacion org : organizacionesInactivas) {
                modelo.addRow(new Object[]{
                    org.getId(),
                    org.getNombre(),
                    org.getDireccion(),
                    org.getTelefono(),
                    org.getEmail(),
                    org.getFechaRegistro()
                });
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Error al listar organizaciones: " + ex.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void limpiarCampos() {
        jTextFieldNombre.setText("");
        jTextFieldDireccion.setText("");
        jTextFieldTelefono.setText("");
        jTextFieldEmail.setText("");
        jTextFieldFecha.setText("");
        organizacionSeleccionada = new Organizacion();
    }

    private List<Organizacion> buscarEnLista(List<Organizacion> lista, String textoBusqueda) {
        List<Organizacion> resultados = new ArrayList<>();

        for (Organizacion org : lista) {
            boolean coincide = false;

            if (org.getNombre() != null
                    && org.getNombre().toLowerCase().contains(textoBusqueda)) {
                coincide = true;
            }

            if (org.getEmail() != null
                    && org.getEmail().toLowerCase().contains(textoBusqueda)) {
                coincide = true;
            }

            if (org.getDireccion() != null
                    && org.getDireccion().toLowerCase().contains(textoBusqueda)) {
                coincide = true;
            }

            if (org.getTelefono() != null
                    && org.getTelefono().contains(textoBusqueda)) {
                coincide = true;
            }

            try {
                int idBuscado = Integer.parseInt(textoBusqueda);
                if (org.getId() != null && org.getId() == idBuscado) {
                    coincide = true;
                }
            } catch (NumberFormatException e) {
            }

            if (coincide) {
                resultados.add(org);
            }
        }

        return resultados;
    }

    private void mostrarResultados(List<Organizacion> resultados) {
        DefaultTableModel modelo = (DefaultTableModel) jTableOrganizaciones.getModel();
        modelo.setRowCount(0);

        for (Organizacion org : resultados) {
            modelo.addRow(new Object[]{
                org.getId(),
                org.getNombre(),
                org.getDireccion(),
                org.getTelefono(),
                org.getEmail(),
                org.getFechaRegistro()
            });
        }

    }
}
