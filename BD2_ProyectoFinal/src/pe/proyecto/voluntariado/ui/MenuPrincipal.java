package pe.proyecto.voluntariado.ui;

public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Sistema de voluntariado integrado (SVI)");

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonGestionarOrganizaciones = new javax.swing.JButton();
        jButtonGestionarVoluntarios = new javax.swing.JButton();
        jButtonGestionarCategoria = new javax.swing.JButton();
        jButtonGestionarTipoDonacion = new javax.swing.JButton();
        jButtonGestionarActividades = new javax.swing.JButton();
        jButtonAsignarDonaciones = new javax.swing.JButton();
        jButtonAsignarActividades = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema de Voluntariado Integrado (SVI)");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione la función que desea realizar:");

        jPanel1.setBackground(java.awt.Color.lightGray);
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jButtonGestionarOrganizaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/proyecto/voluntariado/iconos/Organizacion.png"))); // NOI18N
        jButtonGestionarOrganizaciones.setText("Gestionar organizaciones");
        jButtonGestionarOrganizaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionarOrganizacionesActionPerformed(evt);
            }
        });

        jButtonGestionarVoluntarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/proyecto/voluntariado/iconos/voluntario.png"))); // NOI18N
        jButtonGestionarVoluntarios.setText("Gestionar voluntarios");
        jButtonGestionarVoluntarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionarVoluntariosActionPerformed(evt);
            }
        });

        jButtonGestionarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/proyecto/voluntariado/iconos/Categoria.png"))); // NOI18N
        jButtonGestionarCategoria.setText("Gestionar categoria de actividades");
        jButtonGestionarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionarCategoriaActionPerformed(evt);
            }
        });

        jButtonGestionarTipoDonacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/proyecto/voluntariado/iconos/TipoDonacion.png"))); // NOI18N
        jButtonGestionarTipoDonacion.setText("Gestionar tipo de donación");
        jButtonGestionarTipoDonacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionarTipoDonacionActionPerformed(evt);
            }
        });

        jButtonGestionarActividades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/proyecto/voluntariado/iconos/Actividades.png"))); // NOI18N
        jButtonGestionarActividades.setText("Gestionar actividades");
        jButtonGestionarActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionarActividadesActionPerformed(evt);
            }
        });

        jButtonAsignarDonaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/proyecto/voluntariado/iconos/Donacion.png"))); // NOI18N
        jButtonAsignarDonaciones.setText("Asignar donaciones");
        jButtonAsignarDonaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAsignarDonacionesActionPerformed(evt);
            }
        });

        jButtonAsignarActividades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/proyecto/voluntariado/iconos/AsignarActividades.png"))); // NOI18N
        jButtonAsignarActividades.setText("Asignar actividades");
        jButtonAsignarActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAsignarActividadesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonGestionarOrganizaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonGestionarVoluntarios, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonGestionarTipoDonacion, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAsignarActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonGestionarActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonGestionarCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAsignarDonaciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGestionarOrganizaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGestionarVoluntarios, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGestionarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGestionarTipoDonacion, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGestionarActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAsignarDonaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAsignarActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGestionarOrganizacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionarOrganizacionesActionPerformed
        try {
            GestionarOrganizaciones go = new GestionarOrganizaciones();
            go.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this,
                    "No se pudo abrir GestionarOrganizaciones: " + ex.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_jButtonGestionarOrganizacionesActionPerformed

    private void jButtonGestionarVoluntariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionarVoluntariosActionPerformed
        try {
            GestionarVoluntarios go = new GestionarVoluntarios();
            go.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this,
                    "No se pudo abrir GestionarVoluntarios: " + ex.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_jButtonGestionarVoluntariosActionPerformed

    private void jButtonGestionarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionarCategoriaActionPerformed
        try {
            GestionarCategoria go = new GestionarCategoria();
            go.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this,
                    "No se pudo abrir GestionarVoluntarios: " + ex.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_jButtonGestionarCategoriaActionPerformed

    private void jButtonGestionarTipoDonacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionarTipoDonacionActionPerformed
        try {
            GestionarTipoDonacion go = new GestionarTipoDonacion();
            go.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this,
                    "No se pudo abrir GestionarVoluntarios: " + ex.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_jButtonGestionarTipoDonacionActionPerformed

    private void jButtonGestionarActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionarActividadesActionPerformed
        try {
            GestionarActividades go = new GestionarActividades();
            go.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this,
                    "No se pudo abrir GestionarVoluntarios: " + ex.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_jButtonGestionarActividadesActionPerformed

    private void jButtonAsignarDonacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAsignarDonacionesActionPerformed
        try {
            AsignarDonacion go = new AsignarDonacion();
            go.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this,
                    "No se pudo abrir GestionarVoluntarios: " + ex.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_jButtonAsignarDonacionesActionPerformed

    private void jButtonAsignarActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAsignarActividadesActionPerformed
        try {
            AsignarActividad go = new AsignarActividad();
            go.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this,
                    "No se pudo abrir GestionarVoluntarios: " + ex.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_jButtonAsignarActividadesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAsignarActividades;
    private javax.swing.JButton jButtonAsignarDonaciones;
    private javax.swing.JButton jButtonGestionarActividades;
    private javax.swing.JButton jButtonGestionarCategoria;
    private javax.swing.JButton jButtonGestionarOrganizaciones;
    private javax.swing.JButton jButtonGestionarTipoDonacion;
    private javax.swing.JButton jButtonGestionarVoluntarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
