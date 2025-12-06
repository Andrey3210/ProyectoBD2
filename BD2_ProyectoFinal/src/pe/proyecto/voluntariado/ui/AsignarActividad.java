package pe.proyecto.voluntariado.ui;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.proyecto.voluntariado.dao.impl.ActividadDAOImpl;
import pe.proyecto.voluntariado.dao.impl.AsignacionActividadDAOImpl;
import pe.proyecto.voluntariado.dao.impl.VoluntarioDAOImpl;
import pe.proyecto.voluntariado.model.Actividad;
import pe.proyecto.voluntariado.model.AsignacionActividad;
import pe.proyecto.voluntariado.model.Voluntario;

public class AsignarActividad extends javax.swing.JFrame {

    // DAOs necesarios
    private AsignacionActividadDAOImpl asignacionDAO = new AsignacionActividadDAOImpl();
    private VoluntarioDAOImpl voluntarioDAO = new VoluntarioDAOImpl();
    private ActividadDAOImpl actividadDAO = new ActividadDAOImpl();

    private AsignacionActividad seleccionada = new AsignacionActividad();

    public AsignarActividad() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Asignación de Actividades - SVI");

        cargarTabla();

        // Listener para la tabla
        jTableAsignaciones.getSelectionModel().addListSelectionListener(evt -> {
            if (!evt.getValueIsAdjusting()) {
                int fila = jTableAsignaciones.getSelectedRow();
                if (fila != -1) {
                    cargarDatosSeleccion(fila);
                }
            }
        });
    }

    private void cargarTabla() {
        try {
            List<AsignacionActividad> lista = asignacionDAO.listarTodos();
            DefaultTableModel modelo = (DefaultTableModel) jTableAsignaciones.getModel();
            modelo.setRowCount(0);

            for (AsignacionActividad a : lista) {
                modelo.addRow(new Object[]{
                    a.getId(),
                    a.getNombreVoluntario(), // Asegúrate que tu modelo tenga esto
                    a.getNombreActividad(), // Asegúrate que tu modelo tenga esto
                    a.getFecha(),
                    a.getEstado(),
                    a.getCalificacion() == 0 ? "-" : a.getCalificacion()
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al listar: " + ex.getMessage());
        }
    }

    private void cargarDatosSeleccion(int fila) {
        // Cargar datos visuales en los campos de la derecha
        int id = (int) jTableAsignaciones.getValueAt(fila, 0);
        try {
            seleccionada = asignacionDAO.buscarPorId(id);
            if (seleccionada != null) {
                txtVoluntario.setText(seleccionada.getNombreVoluntario());
                txtActividad.setText(seleccionada.getNombreActividad());
                txtEstado.setText(seleccionada.getEstado());
                // Formatear calificación
                txtCalificacion.setText(seleccionada.getCalificacion() > 0
                        ? String.valueOf(seleccionada.getCalificacion()) : "");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAsignaciones = new javax.swing.JTable();
        jPanelDetalle = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtVoluntario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtActividad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCalificacion = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setText("Asignar Actividades");

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new MenuPrincipal().setVisible(true);
                dispose();
            }
        });

        jTableAsignaciones.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Voluntario", "Actividad", "Fecha", "Estado", "Calificación"}
        ) {
            boolean[] canEdit = new boolean[]{false, false, false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableAsignaciones);

        jPanelDetalle.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de Asignación"));

        jLabel2.setText("Voluntario:");
        txtVoluntario.setEditable(false);

        jLabel3.setText("Actividad:");
        txtActividad.setEditable(false);

        jLabel4.setText("Estado:");
        txtEstado.setEditable(false);

        jLabel5.setText("Calificación:");
        txtCalificacion.setEditable(false);

        javax.swing.GroupLayout jPanelDetalleLayout = new javax.swing.GroupLayout(jPanelDetalle);
        jPanelDetalle.setLayout(jPanelDetalleLayout);
        jPanelDetalleLayout.setHorizontalGroup(
                jPanelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelDetalleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtVoluntario)
                                        .addComponent(txtActividad)
                                        .addComponent(txtEstado)
                                        .addComponent(txtCalificacion)
                                        .addGroup(jPanelDetalleLayout.createSequentialGroup()
                                                .addGroup(jPanelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5))
                                                .addGap(0, 150, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanelDetalleLayout.setVerticalGroup(
                jPanelDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelDetalleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtVoluntario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAgregar.setText("Nueva Asignación");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar Estado/Nota");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
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
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButtonVolver))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanelDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jButtonVolver))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanelDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {
        // Crear panel para el popup
        javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.GridLayout(0, 1));

        // Combos
        javax.swing.JComboBox<Voluntario> cboVol = new javax.swing.JComboBox<>();
        javax.swing.JComboBox<Actividad> cboAct = new javax.swing.JComboBox<>();

        try {
            // Llenar voluntarios
            for (Voluntario v : voluntarioDAO.listarTodos()) {
                cboVol.addItem(v);
            }
            // Llenar actividades
            for (Actividad a : actividadDAO.listarTodos()) {
                cboAct.addItem(a);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error cargando listas: " + e.getMessage());
            return;
        }

        panel.add(new javax.swing.JLabel("Seleccione Voluntario:"));
        panel.add(cboVol);
        panel.add(new javax.swing.JLabel("Seleccione Actividad:"));
        panel.add(cboAct);

        int res = JOptionPane.showConfirmDialog(this, panel, "Nueva Asignación", JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            try {
                AsignacionActividad nueva = new AsignacionActividad();
                nueva.setVoluntarioId(((Voluntario) cboVol.getSelectedItem()).getId());
                nueva.setActividadId(((Actividad) cboAct.getSelectedItem()).getId());
                // Calificación 0 por defecto
                nueva.setCalificacion(0);

                asignacionDAO.insertar(nueva);
                JOptionPane.showMessageDialog(this, "Asignación creada!");
                cargarTabla();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {
        if (seleccionada.getId() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila primero");
            return;
        }

        javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.GridLayout(0, 1));
        javax.swing.JComboBox<String> cboEstado = new javax.swing.JComboBox<>(new String[]{"Pendiente", "Completada", "Cancelada"});
        javax.swing.JTextField txtNota = new javax.swing.JTextField(String.valueOf(seleccionada.getCalificacion()));

        cboEstado.setSelectedItem(seleccionada.getEstado());

        panel.add(new javax.swing.JLabel("Estado:"));
        panel.add(cboEstado);
        panel.add(new javax.swing.JLabel("Calificación (0-10):"));
        panel.add(txtNota);

        int res = JOptionPane.showConfirmDialog(this, panel, "Modificar Asignación", JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            try {
                seleccionada.setEstado((String) cboEstado.getSelectedItem());
                seleccionada.setCalificacion(Integer.parseInt(txtNota.getText()));

                asignacionDAO.modificar(seleccionada);
                JOptionPane.showMessageDialog(this, "Actualizado!");
                cargarTabla();
                cargarDatosSeleccion(jTableAsignaciones.getSelectedRow());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al actualizar: " + ex.getMessage());
            }
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanelDetalle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAsignaciones;
    private javax.swing.JTextField txtActividad;
    private javax.swing.JTextField txtCalificacion;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtVoluntario;
    // End of variables declaration                   
}
