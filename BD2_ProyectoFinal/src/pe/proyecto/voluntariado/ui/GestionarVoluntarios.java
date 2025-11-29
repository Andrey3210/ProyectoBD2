package pe.proyecto.voluntariado.ui;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.proyecto.voluntariado.dao.impl.VoluntarioDAOImpl;
import pe.proyecto.voluntariado.model.Voluntario;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class GestionarVoluntarios extends javax.swing.JFrame {

    List<Voluntario> voluntarios;
    Voluntario voluntarioSeleccionado = new Voluntario();
    VoluntarioDAOImpl voluntarioDAOImpl = new VoluntarioDAOImpl();

    public GestionarVoluntarios() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Sistema de voluntariado integrado (SVI)");

        try {
            voluntarios = voluntarioDAOImpl.listarTodos();
            listarVoluntarios();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    this,
                    "Error al listar voluntarios: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        jTableVoluntarios.getSelectionModel().addListSelectionListener(evt -> {
            if (!evt.getValueIsAdjusting()) {
                int fila = jTableVoluntarios.getSelectedRow();
                if (fila != -1) {
                    cargarDatosVoluntario(fila);
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

        jLabel7 = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        jTextFieldNombres = new javax.swing.JTextField();
        jTextFieldDNI = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jTextFieldFechaNacimiento = new javax.swing.JTextField();
        jTextFieldEdad = new javax.swing.JTextField();
        jButtonAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelTituloTabla = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVoluntarios = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonModificar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jTextFieldEstadoCivil = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setText("Fecha de nacimiento:");

        jLabel8.setText("Edad:");

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jTextFieldNombres.setEditable(false);

        jTextFieldDNI.setEditable(false);

        jTextFieldApellidos.setEditable(false);

        jTextFieldFechaNacimiento.setEditable(false);

        jTextFieldEdad.setEditable(false);

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion de voluntarios");

        jLabelTituloTabla.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelTituloTabla.setText("Voluntarios:");

        jTableVoluntarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DNI", "Nombres completos", "Edad", "Email", "Teléfono", "Dirección", "Estado civil", "Fecha de registro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableVoluntarios);

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("DNI:");

        jLabel5.setText("Nombres:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Acciones:");

        jLabel6.setText("Apellidos:");

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jLabel9.setText("Email:");

        jLabel10.setText("Teléfono:");

        jLabel11.setText("Dirección:");

        jLabel12.setText("Estado civil:");

        jTextFieldEmail.setEditable(false);

        jTextFieldTelefono.setEditable(false);

        jTextFieldDireccion.setEditable(false);

        jTextFieldEstadoCivil.setEditable(false);

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
                        .addComponent(jLabelTituloTabla)
                        .addGap(46, 46, 46)
                        .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldEdad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                    .addComponent(jTextFieldFechaNacimiento, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldNombres)
                                    .addComponent(jTextFieldDNI)
                                    .addComponent(jTextFieldEmail)
                                    .addComponent(jTextFieldTelefono)
                                    .addComponent(jTextFieldDireccion)
                                    .addComponent(jTextFieldEstadoCivil)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonModificar)
                                .addGap(0, 0, Short.MAX_VALUE)))))
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
                    .addComponent(jLabelTituloTabla)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextFieldEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextFieldEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAgregar)
                            .addComponent(jButtonModificar))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        String texto = jTextFieldBuscar.getText().trim();

        if (texto.isEmpty()) {
            listarVoluntarios();
            return;
        }

        List<Voluntario> resultados = voluntarios.stream()
                .filter(v
                        -> v.getDni().contains(texto)
                || (v.getNombres() + " " + v.getApellidos()).toLowerCase().contains(texto.toLowerCase())
                || v.getNombres().toLowerCase().contains(texto.toLowerCase())
                || v.getApellidos().toLowerCase().contains(texto.toLowerCase())
                || (v.getEmail() != null && v.getEmail().toLowerCase().contains(texto.toLowerCase()))
                )
                .collect(Collectors.toList());

        DefaultTableModel modelo = (DefaultTableModel) jTableVoluntarios.getModel();
        modelo.setRowCount(0);

        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No se encontraron voluntarios con: \"" + texto + "\"",
                    "Sin resultados",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (Voluntario v : resultados) {
                String nombreCompleto = v.getNombres() + " " + v.getApellidos();
                modelo.addRow(new Object[]{
                    v.getId(),
                    v.getDni(),
                    nombreCompleto,
                    v.getEdad(),
                    v.getEmail(),
                    v.getTelefono(),
                    v.getDireccion(),
                    v.getEstadoCivil(),
                    v.getFechaRegistro()
                });
            }
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.GridLayout(9, 2, 10, 10));

        // Crear campos
        javax.swing.JTextField txtDNI = new javax.swing.JTextField(20);
        javax.swing.JTextField txtNombres = new javax.swing.JTextField(20);
        javax.swing.JTextField txtApellidos = new javax.swing.JTextField(20);
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");
        javax.swing.JTextField txtEmail = new javax.swing.JTextField(20);
        javax.swing.JTextField txtTelefono = new javax.swing.JTextField(20);
        javax.swing.JTextField txtDireccion = new javax.swing.JTextField(20);
        javax.swing.JComboBox<String> cboEstadoCivil = new javax.swing.JComboBox<>(
                new String[]{"Soltero", "Casado", "Divorciado", "Viudo"}
        );

        // Agregar componentes
        panel.add(new javax.swing.JLabel("* DNI:"));
        panel.add(txtDNI);
        panel.add(new javax.swing.JLabel("* Nombres:"));
        panel.add(txtNombres);
        panel.add(new javax.swing.JLabel("* Apellidos:"));
        panel.add(txtApellidos);
        panel.add(new javax.swing.JLabel("Fecha de Nacimiento:"));
        panel.add(dateChooser);
        panel.add(new javax.swing.JLabel("Email:"));
        panel.add(txtEmail);
        panel.add(new javax.swing.JLabel("Teléfono:"));
        panel.add(txtTelefono);
        panel.add(new javax.swing.JLabel("Dirección:"));
        panel.add(txtDireccion);
        panel.add(new javax.swing.JLabel("Estado Civil:"));
        panel.add(cboEstadoCivil);
        panel.add(new javax.swing.JLabel(""));
        panel.add(new javax.swing.JLabel("* Campos obligatorios"));

        int resultado = JOptionPane.showConfirmDialog(
                this,
                panel,
                "Agregar Nuevo Voluntario",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (resultado == JOptionPane.OK_OPTION) {
            // Validar campos obligatorios
            if (txtDNI.getText().trim().isEmpty()
                    || txtNombres.getText().trim().isEmpty()
                    || txtApellidos.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "DNI, Nombres y Apellidos son obligatorios.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            // Validar DNI (8 dígitos)
            if (!txtDNI.getText().matches("^[0-9]{8}$")) {
                JOptionPane.showMessageDialog(
                        this,
                        "El DNI debe tener exactamente 8 dígitos.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            // Validar email si se proporciona
            if (!txtEmail.getText().trim().isEmpty()
                    && !txtEmail.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                JOptionPane.showMessageDialog(
                        this,
                        "El formato del email no es válido.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            try {
                Voluntario nuevo = new Voluntario();
                nuevo.setDni(txtDNI.getText().trim());
                nuevo.setNombres(txtNombres.getText().trim());
                nuevo.setApellidos(txtApellidos.getText().trim());
                nuevo.setFechaNacimiento(dateChooser.getDate());
                nuevo.setEmail(txtEmail.getText().trim().isEmpty() ? null : txtEmail.getText().trim());
                nuevo.setTelefono(txtTelefono.getText().trim().isEmpty() ? null : txtTelefono.getText().trim());
                nuevo.setDireccion(txtDireccion.getText().trim().isEmpty() ? null : txtDireccion.getText().trim());
                nuevo.setEstadoCivil(cboEstadoCivil.getSelectedItem().toString());

                voluntarioDAOImpl.insertar(nuevo);

                JOptionPane.showMessageDialog(
                        this,
                        "Voluntario registrado correctamente.",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE
                );

                voluntarios = voluntarioDAOImpl.listarTodos();
                listarVoluntarios();
                limpiarCampos();

            } catch (Exception ex) {
                Logger.getLogger(GestionarVoluntarios.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new MenuPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        if (voluntarioSeleccionado.getId() == 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione un voluntario de la tabla antes de modificar.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.GridLayout(9, 2, 10, 10));

        javax.swing.JTextField txtDNI = new javax.swing.JTextField(voluntarioSeleccionado.getDni(), 20);
        javax.swing.JTextField txtNombres = new javax.swing.JTextField(voluntarioSeleccionado.getNombres(), 20);
        javax.swing.JTextField txtApellidos = new javax.swing.JTextField(jTextFieldApellidos.getText(), 20);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");
        dateChooser.setDate(voluntarioSeleccionado.getFechaNacimiento());

        dateChooser.setDate(voluntarioSeleccionado.getFechaNacimiento());

        javax.swing.JTextField txtEmail = new javax.swing.JTextField(jTextFieldEmail.getText(), 20);
        javax.swing.JTextField txtTelefono = new javax.swing.JTextField(jTextFieldTelefono.getText(), 20);
        javax.swing.JTextField txtDireccion = new javax.swing.JTextField(jTextFieldDireccion.getText(), 20);

        javax.swing.JComboBox<String> cboEstadoCivil = new javax.swing.JComboBox<>(
                new String[]{"Soltero", "Casado", "Divorciado", "Viudo"}
        );
        cboEstadoCivil.setSelectedItem(jTextFieldEstadoCivil.getText());

        panel.add(new javax.swing.JLabel("* DNI:"));
        panel.add(txtDNI);
        panel.add(new javax.swing.JLabel("* Nombres:"));
        panel.add(txtNombres);
        panel.add(new javax.swing.JLabel("* Apellidos:"));
        panel.add(txtApellidos);
        panel.add(new javax.swing.JLabel("Fecha de Nacimiento:"));
        panel.add(dateChooser);
        panel.add(new javax.swing.JLabel("Email:"));
        panel.add(txtEmail);
        panel.add(new javax.swing.JLabel("Teléfono:"));
        panel.add(txtTelefono);
        panel.add(new javax.swing.JLabel("Dirección:"));
        panel.add(txtDireccion);
        panel.add(new javax.swing.JLabel("Estado Civil:"));
        panel.add(cboEstadoCivil);
        panel.add(new javax.swing.JLabel(""));
        panel.add(new javax.swing.JLabel("* Campos obligatorios"));

        int resultado = JOptionPane.showConfirmDialog(
                this,
                panel,
                "Modificar Voluntario",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (resultado == JOptionPane.OK_OPTION) {

            // Validaciones
            if (txtDNI.getText().trim().isEmpty()
                    || txtNombres.getText().trim().isEmpty()
                    || txtApellidos.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "DNI, Nombres y Apellidos son obligatorios.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if (!txtDNI.getText().matches("^[0-9]{8}$")) {
                JOptionPane.showMessageDialog(
                        this,
                        "El DNI debe tener exactamente 8 dígitos.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if (!txtEmail.getText().trim().isEmpty()
                    && !txtEmail.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {

                JOptionPane.showMessageDialog(
                        this,
                        "El formato del email no es válido.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            try {
                Voluntario editado = new Voluntario();
                editado.setId(voluntarioSeleccionado.getId());
                editado.setDni(txtDNI.getText().trim());
                editado.setNombres(txtNombres.getText().trim());
                editado.setApellidos(txtApellidos.getText().trim());
                editado.setFechaNacimiento(dateChooser.getDate());
                editado.setEmail(txtEmail.getText().trim().isEmpty() ? null : txtEmail.getText().trim());
                editado.setTelefono(txtTelefono.getText().trim().isEmpty() ? null : txtTelefono.getText().trim());
                editado.setDireccion(txtDireccion.getText().trim().isEmpty() ? null : txtDireccion.getText().trim());
                editado.setEstadoCivil(cboEstadoCivil.getSelectedItem().toString());

                voluntarioDAOImpl.modificar(editado);

                JOptionPane.showMessageDialog(
                        this,
                        "Datos actualizados correctamente.",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE
                );

                voluntarios = voluntarioDAOImpl.listarTodos();
                listarVoluntarios();
                limpiarCampos();

            } catch (Exception ex) {
                Logger.getLogger(GestionarVoluntarios.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTituloTabla;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVoluntarios;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldDNI;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldEdad;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEstadoCivil;
    private javax.swing.JTextField jTextFieldFechaNacimiento;
    private javax.swing.JTextField jTextFieldNombres;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables

    private void cargarDatosVoluntario(int fila) {
        int id = (int) jTableVoluntarios.getValueAt(fila, 0);
        voluntarioSeleccionado = buscarPorId(id);

        if (voluntarioSeleccionado != null) {
            jTextFieldDNI.setText(voluntarioSeleccionado.getDni());
            jTextFieldNombres.setText(voluntarioSeleccionado.getNombres());
            jTextFieldApellidos.setText(voluntarioSeleccionado.getApellidos());

            if (voluntarioSeleccionado.getFechaNacimiento() != null) {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                jTextFieldFechaNacimiento.setText(sdf.format(voluntarioSeleccionado.getFechaNacimiento()));
            } else {
                jTextFieldFechaNacimiento.setText("");
            }

            jTextFieldEdad.setText(voluntarioSeleccionado.getEdad() != null ? voluntarioSeleccionado.getEdad().toString() : "");
            jTextFieldEmail.setText(voluntarioSeleccionado.getEmail() != null ? voluntarioSeleccionado.getEmail() : "");
            jTextFieldTelefono.setText(voluntarioSeleccionado.getTelefono() != null ? voluntarioSeleccionado.getTelefono() : "");
            jTextFieldDireccion.setText(voluntarioSeleccionado.getDireccion() != null ? voluntarioSeleccionado.getDireccion() : "");
            jTextFieldEstadoCivil.setText(voluntarioSeleccionado.getEstadoCivil() != null ? voluntarioSeleccionado.getEstadoCivil() : "");
        }
    }

    private void listarVoluntarios() {
        DefaultTableModel modelo = (DefaultTableModel) jTableVoluntarios.getModel();
        modelo.setRowCount(0);

        for (Voluntario v : voluntarios) {
            String nombreCompleto = v.getNombres() + " " + v.getApellidos();

            modelo.addRow(new Object[]{
                v.getId(),
                v.getDni(),
                nombreCompleto,
                v.getEdad(),
                v.getEmail(),
                v.getTelefono(),
                v.getDireccion(),
                v.getEstadoCivil(),
                v.getFechaRegistro()
            });
        }
    }

    private void limpiarCampos() {
        jTextFieldDNI.setText("");
        jTextFieldNombres.setText("");
        jTextFieldApellidos.setText("");
        jTextFieldFechaNacimiento.setText("");
        jTextFieldEdad.setText("");
        jTextFieldEmail.setText("");
        jTextFieldTelefono.setText("");
        jTextFieldDireccion.setText("");
        jTextFieldEstadoCivil.setText("");
        voluntarioSeleccionado = new Voluntario();
    }

    private Object getCol(int fila, int col) {
        int max = jTableVoluntarios.getColumnCount() - 1;
        if (col > max) {
            col = max;
        }
        return jTableVoluntarios.getValueAt(fila, col);
    }

    private Voluntario buscarPorId(int id) {
        for (Voluntario v : voluntarios) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }
}
