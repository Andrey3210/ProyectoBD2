package pe.proyecto.voluntariado.ui;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.proyecto.voluntariado.dao.impl.CategoriaDAOImpl;
import pe.proyecto.voluntariado.model.Categoria;

public class GestionarCategoria extends javax.swing.JFrame {
    List<Categoria> categorias;
    Categoria categoriaSeleccionada = new Categoria();
    CategoriaDAOImpl categoriaDAOImpl = new CategoriaDAOImpl();

    public GestionarCategoria() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Sistema de voluntariado integrado (SVI)");
        
        jTextFieldDNI.setName("jTextFieldNombre");
        jTextFieldNombres.setName("jTextFieldDescripcion");
        jTextFieldApellidos.setName("jTextFieldCalificacion");
        
        try {
            categorias = categoriaDAOImpl.listarTodos();
            listarCategorias();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                this,
                "Error al listar categorías: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
        
        // Listener para selección en la tabla
        jTableCategoria.getSelectionModel().addListSelectionListener(evt -> {
            if (!evt.getValueIsAdjusting()) {
                int fila = jTableCategoria.getSelectedRow();
                if (fila != -1) {
                    cargarDatosCategoria(fila);
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

        jButtonModificar = new javax.swing.JButton();
        jButtonAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelTituloTabla = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCategoria = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jTextFieldNombres = new javax.swing.JTextField();
        jTextFieldDNI = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion de categorias de actividades");

        jLabelTituloTabla.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelTituloTabla.setText("Categorias");

        jTableCategoria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableCategoria);

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre:");

        jLabel5.setText("Descripción:");

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jTextFieldNombres.setEditable(false);

        jTextFieldDNI.setEditable(false);

        jTextFieldApellidos.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Acciones:");

        jLabel6.setText("Calificación máxima:");

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
                                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNombres)
                                    .addComponent(jTextFieldDNI)))
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
                            .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAgregar)
                            .addComponent(jButtonModificar))
                        .addGap(0, 227, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        if (categoriaSeleccionada.getId() == null || categoriaSeleccionada.getId() == 0) {
            JOptionPane.showMessageDialog(
                this,
                "Por favor, seleccione una categoría de la tabla.",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        try {
            Categoria actual = categoriaDAOImpl.buscarPorId(categoriaSeleccionada.getId());
            
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
                "Modificar Categoría: " + actual.getNombre(),
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
                    "¿Está seguro de modificar la categoría:\n" + actual.getNombre() + "?",
                    "Confirmar Modificación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                
                if (confirmacion != JOptionPane.YES_OPTION) {
                    return;
                }
                
                Categoria modificada = new Categoria();
                modificada.setId(actual.getId());
                modificada.setNombre(txtNombre.getText().trim());
                modificada.setDescripcion(txtDescripcion.getText().trim().isEmpty() ? 
                    null : txtDescripcion.getText().trim());
                modificada.setCalificacionMax((Integer) spinCalificacion.getValue());
                
                categoriaDAOImpl.modificar(modificada);
                
                JOptionPane.showMessageDialog(
                    this,
                    "Categoría modificada correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
                );
                
                categorias = categoriaDAOImpl.listarTodos();
                listarCategorias();
                limpiarCampos();
            }
            
        } catch (Exception ex) {
            Logger.getLogger(GestionarCategoria.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                this,
                ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

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
            "Agregar Nueva Categoría",
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
                Categoria nueva = new Categoria();
                nueva.setNombre(txtNombre.getText().trim());
                nueva.setDescripcion(txtDescripcion.getText().trim().isEmpty() ? 
                    null : txtDescripcion.getText().trim());
                nueva.setCalificacionMax((Integer) spinCalificacion.getValue());
                
                categoriaDAOImpl.insertar(nueva);
                
                JOptionPane.showMessageDialog(
                    this,
                    "Categoría registrada correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
                );
                
                categorias = categoriaDAOImpl.listarTodos();
                listarCategorias();
                limpiarCampos();
                
            } catch (Exception ex) {
                Logger.getLogger(GestionarCategoria.class.getName()).log(Level.SEVERE, null, ex);
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

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        String textoBusqueda = jTextFieldBuscar.getText().trim();
        
        if (textoBusqueda.isEmpty()) {
            try {
                categorias = categoriaDAOImpl.listarTodos();
                listarCategorias();
            } catch (Exception ex) {
                Logger.getLogger(GestionarCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
        
        try {
            categorias = categoriaDAOImpl.buscar(textoBusqueda);
            
            if (categorias.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "No se encontraron categorías que coincidan con: " + textoBusqueda,
                    "Sin resultados",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
            
            listarCategorias();
            
        } catch (Exception ex) {
            Logger.getLogger(GestionarCategoria.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(
                this,
                "Error al buscar: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed


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
    private javax.swing.JTable jTableCategoria;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldDNI;
    private javax.swing.JTextField jTextFieldNombres;
    // End of variables declaration//GEN-END:variables

    private void cargarDatosCategoria(int fila) {
        jTextFieldDNI.setText(jTableCategoria.getValueAt(fila, 1).toString());
        jTextFieldNombres.setText(jTableCategoria.getValueAt(fila, 2) != null ? 
            jTableCategoria.getValueAt(fila, 2).toString() : "");
        jTextFieldApellidos.setText(jTableCategoria.getValueAt(fila, 3) != null ? 
            jTableCategoria.getValueAt(fila, 3).toString() : "");
        
        categoriaSeleccionada.setId((Integer) jTableCategoria.getValueAt(fila, 0));
        categoriaSeleccionada.setNombre(jTableCategoria.getValueAt(fila, 1).toString());
    }
    
    private void listarCategorias() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) jTableCategoria.getModel();
            modelo.setRowCount(0);
            
            for (Categoria c : categorias) {
                modelo.addRow(new Object[]{
                    c.getId(),
                    c.getNombre(),
                    c.getDescripcion(),
                    c.getCalificacionMax()
                });
            }
            
            jLabelTituloTabla.setText("Categorías: (" + categorias.size() + ")");
            
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                this,
                "Error al listar categorías: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    private void limpiarCampos() {
        jTextFieldDNI.setText("");
        jTextFieldNombres.setText("");
        jTextFieldApellidos.setText("");
        categoriaSeleccionada = new Categoria();
    }
}
