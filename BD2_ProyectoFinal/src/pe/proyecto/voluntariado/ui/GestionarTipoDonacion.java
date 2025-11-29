package pe.proyecto.voluntariado.ui;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.proyecto.voluntariado.dao.impl.TipoDonacionDAOImpl;
import pe.proyecto.voluntariado.model.TipoDonacion;


public class GestionarTipoDonacion extends javax.swing.JFrame {
    
    List<TipoDonacion> tiposDonacion;
    TipoDonacion tipoDonacionSeleccionado = new TipoDonacion();
    TipoDonacionDAOImpl tipoDonacionDAOImpl = new TipoDonacionDAOImpl();


    public GestionarTipoDonacion() {
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
        
        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    jButtonBuscarActionPerformed(null);
                }
            }
        });
        
        try {
            tiposDonacion = tipoDonacionDAOImpl.listarTodos();
            listarTiposDonacion();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                this,
                "Error al listar tipos de donación: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
        
        // Listener para selección en la tabla
        jTableDonacion.getSelectionModel().addListSelectionListener(evt -> {
            if (!evt.getValueIsAdjusting()) {
                int fila = jTableDonacion.getSelectedRow();
                if (fila != -1) {
                    cargarDatosTipoDonacion(fila);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTituloTabla = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDonacion = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonModificar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldCalificacion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTituloTabla.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelTituloTabla.setText("Tipos de donación:");

        jTableDonacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripción", "Calificación máxima"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableDonacion);

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre:");

        jLabel5.setText("Descripción:");

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

        jTextFieldDescripcion.setEditable(false);

        jTextFieldNombre.setEditable(false);

        jTextFieldCalificacion.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Acciones:");

        jLabel6.setText("Calificación máxima:");

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion de tipos de donación");

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
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCalificacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                    .addComponent(jTextFieldDescripcion)
                                    .addComponent(jTextFieldNombre)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonAgregar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonModificar)))
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAgregar)
                            .addComponent(jButtonModificar))
                        .addGap(0, 196, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new MenuPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        if (tipoDonacionSeleccionado.getId() == null || tipoDonacionSeleccionado.getId() == 0) {
            JOptionPane.showMessageDialog(
                this,
                "Seleccione un tipo de donación de la tabla antes de modificar.",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        try {
            TipoDonacion actual = tipoDonacionDAOImpl.buscarPorId(tipoDonacionSeleccionado.getId());
            
            javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.GridLayout(4, 2, 10, 10));
            
            javax.swing.JTextField txtNombre = new javax.swing.JTextField(actual.getNombre(), 20);
            javax.swing.JTextArea txtDescripcion = new javax.swing.JTextArea(
                actual.getDescripcion() != null ? actual.getDescripcion() : "", 3, 20);
            txtDescripcion.setLineWrap(true);
            txtDescripcion.setWrapStyleWord(true);
            javax.swing.JScrollPane scrollDesc = new javax.swing.JScrollPane(txtDescripcion);
            javax.swing.JSpinner spinCalificacion = new javax.swing.JSpinner(
                new javax.swing.SpinnerNumberModel(
                    actual.getCalificacionMax() != null ? actual.getCalificacionMax() : 100, 
                    0, 100, 1)
            );
            
            panel.add(new javax.swing.JLabel("* Nombre:"));
            panel.add(txtNombre);
            panel.add(new javax.swing.JLabel("Descripción:"));
            panel.add(scrollDesc);
            panel.add(new javax.swing.JLabel("Calificación máxima:"));
            panel.add(spinCalificacion);
            panel.add(new javax.swing.JLabel(""));
            panel.add(new javax.swing.JLabel("* Campos obligatorios"));
            
            int resultado = JOptionPane.showConfirmDialog(
                this,
                panel,
                "Modificar Tipo de Donación: " + actual.getNombre(),
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );
            
            if (resultado == JOptionPane.OK_OPTION) {
                if (txtNombre.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(
                        this,
                        "El nombre es obligatorio.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
                
                int confirmacion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Está seguro de modificar el tipo de donación:\n" + actual.getNombre() + "?",
                    "Confirmar Modificación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                
                if (confirmacion != JOptionPane.YES_OPTION) {
                    return;
                }
                
                TipoDonacion modificado = new TipoDonacion();
                modificado.setId(actual.getId());
                modificado.setNombre(txtNombre.getText().trim());
                modificado.setDescripcion(txtDescripcion.getText().trim().isEmpty() ? 
                    null : txtDescripcion.getText().trim());
                modificado.setCalificacionMax((Integer) spinCalificacion.getValue());
                
                tipoDonacionDAOImpl.modificar(modificado);
                
                JOptionPane.showMessageDialog(
                    this,
                    "Tipo de donación modificado correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
                );
                
                tiposDonacion = tipoDonacionDAOImpl.listarTodos();
                listarTiposDonacion();
                limpiarCampos();
            }
            
        } catch (Exception ex) {
            Logger.getLogger(GestionarTipoDonacion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                this,
                ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        String texto = jTextFieldBuscar.getText().trim();
        
        if (texto.isEmpty()) {
            listarTiposDonacion();
            return;
        }
        
        List<TipoDonacion> resultados = tiposDonacion.stream()
            .filter(td -> 
                td.getNombre().toLowerCase().contains(texto.toLowerCase()) ||
                (td.getDescripcion() != null && td.getDescripcion().toLowerCase().contains(texto.toLowerCase()))
            )
            .collect(Collectors.toList());
        
        DefaultTableModel modelo = (DefaultTableModel) jTableDonacion.getModel();
        modelo.setRowCount(0);
        
        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "No se encontraron tipos de donación con: \"" + texto + "\"",
                "Sin resultados",
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (TipoDonacion td : resultados) {
                modelo.addRow(new Object[]{
                    td.getId(),
                    td.getNombre(),
                    td.getDescripcion(),
                    td.getCalificacionMax()
                });
            }
            jLabelTituloTabla.setText("Tipos de donación: (" + resultados.size() + " encontrados)");
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.GridLayout(4, 2, 10, 10));
        
        javax.swing.JTextField txtNombre = new javax.swing.JTextField(20);
        javax.swing.JTextArea txtDescripcion = new javax.swing.JTextArea(3, 20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        javax.swing.JScrollPane scrollDesc = new javax.swing.JScrollPane(txtDescripcion);
        javax.swing.JSpinner spinCalificacion = new javax.swing.JSpinner(
            new javax.swing.SpinnerNumberModel(100, 0, 100, 1)
        );
        
        panel.add(new javax.swing.JLabel("* Nombre:"));
        panel.add(txtNombre);
        panel.add(new javax.swing.JLabel("Descripción:"));
        panel.add(scrollDesc);
        panel.add(new javax.swing.JLabel("Calificación máxima:"));
        panel.add(spinCalificacion);
        panel.add(new javax.swing.JLabel(""));
        panel.add(new javax.swing.JLabel("* Campos obligatorios"));
        
        int resultado = JOptionPane.showConfirmDialog(
            this,
            panel,
            "Agregar Nuevo Tipo de Donación",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );
        
        if (resultado == JOptionPane.OK_OPTION) {
            if (txtNombre.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "El nombre es obligatorio.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            
            try {
                TipoDonacion nuevo = new TipoDonacion();
                nuevo.setNombre(txtNombre.getText().trim());
                nuevo.setDescripcion(txtDescripcion.getText().trim().isEmpty() ? 
                    null : txtDescripcion.getText().trim());
                nuevo.setCalificacionMax((Integer) spinCalificacion.getValue());
                
                tipoDonacionDAOImpl.insertar(nuevo);
                
                JOptionPane.showMessageDialog(
                    this,
                    "Tipo de donación registrado correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
                );
                
                tiposDonacion = tipoDonacionDAOImpl.listarTodos();
                listarTiposDonacion();
                limpiarCampos();
                
            } catch (Exception ex) {
                Logger.getLogger(GestionarTipoDonacion.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelTituloTabla;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDonacion;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldCalificacion;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables

    private void cargarDatosTipoDonacion(int fila) {
        int id = (int) jTableDonacion.getValueAt(fila, 0);
        tipoDonacionSeleccionado = buscarPorId(id);
        
        if (tipoDonacionSeleccionado != null) {
            jTextFieldNombre.setText(tipoDonacionSeleccionado.getNombre());
            jTextFieldDescripcion.setText(tipoDonacionSeleccionado.getDescripcion() != null ? 
                tipoDonacionSeleccionado.getDescripcion() : "");
            jTextFieldCalificacion.setText(tipoDonacionSeleccionado.getCalificacionMax() != null ? 
                tipoDonacionSeleccionado.getCalificacionMax().toString() : "");
        }
    }
    
    private void listarTiposDonacion() {
        DefaultTableModel modelo = (DefaultTableModel) jTableDonacion.getModel();
        modelo.setRowCount(0);
        
        for (TipoDonacion td : tiposDonacion) {
            modelo.addRow(new Object[]{
                td.getId(),
                td.getNombre(),
                td.getDescripcion(),
                td.getCalificacionMax()
            });
        }
        
        jLabelTituloTabla.setText("Tipos de donación: (" + tiposDonacion.size() + ")");
    }
    
    private void limpiarCampos() {
        jTextFieldNombre.setText("");
        jTextFieldDescripcion.setText("");
        jTextFieldCalificacion.setText("");
        tipoDonacionSeleccionado = new TipoDonacion();
    }
    
    private TipoDonacion buscarPorId(int id) {
        for (TipoDonacion td : tiposDonacion) {
            if (td.getId() == id) {
                return td;
            }
        }
        return null;
    }
}
