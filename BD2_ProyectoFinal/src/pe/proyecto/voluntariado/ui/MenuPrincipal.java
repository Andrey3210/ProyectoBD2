package pe.proyecto.voluntariado.ui;

import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Sistema de voluntariado integrado (SVI)");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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
        // 1. Declaramos el nuevo botón
        jButtonReportes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema de Voluntariado Integrado (SVI)");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel2.setText("Seleccione la función que desea realizar:");

        jPanel1.setBackground(java.awt.Color.lightGray);
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        // --- BOTONES EXISTENTES ---
        jButtonGestionarOrganizaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/proyecto/voluntariado/iconos/Organizacion.png")));
        jButtonGestionarOrganizaciones.setText("Gestionar organizaciones");
        jButtonGestionarOrganizaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionarOrganizacionesActionPerformed(evt);
            }
        });

        jButtonGestionarVoluntarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/proyecto/voluntariado/iconos/voluntario.png")));
        jButtonGestionarVoluntarios.setText("Gestionar voluntarios");
        jButtonGestionarVoluntarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionarVoluntariosActionPerformed(evt);
            }
        });

        jButtonGestionarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/proyecto/voluntariado/iconos/Categoria.png")));
        jButtonGestionarCategoria.setText("Gestionar categoria de actividades");
        jButtonGestionarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionarCategoriaActionPerformed(evt);
            }
        });

        jButtonGestionarTipoDonacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/proyecto/voluntariado/iconos/TipoDonacion.png")));
        jButtonGestionarTipoDonacion.setText("Gestionar tipo de donación");
        jButtonGestionarTipoDonacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionarTipoDonacionActionPerformed(evt);
            }
        });

        jButtonGestionarActividades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/proyecto/voluntariado/iconos/Actividades.png")));
        jButtonGestionarActividades.setText("Gestionar actividades");
        jButtonGestionarActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionarActividadesActionPerformed(evt);
            }
        });

        jButtonAsignarDonaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/proyecto/voluntariado/iconos/Donacion.png")));
        jButtonAsignarDonaciones.setText("Asignar donaciones");
        jButtonAsignarDonaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAsignarDonacionesActionPerformed(evt);
            }
        });

        jButtonAsignarActividades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/proyecto/voluntariado/iconos/AsignarActividades.png")));
        jButtonAsignarActividades.setText("Asignar actividades");
        jButtonAsignarActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAsignarActividadesActionPerformed(evt);
            }
        });

        // --- 2. CONFIGURACIÓN DEL NUEVO BOTÓN DE REPORTES ---
        // Intenta cargar icono, si no existe no falla
        try {
            jButtonReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/proyecto/voluntariado/iconos/Reportes.png")));
        } catch (Exception e) {
            // Si no hay icono, no pasa nada
        }
        jButtonReportes.setText("Reportes y Métricas");
        jButtonReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportesActionPerformed(evt);
            }
        });

        // --- LAYOUT ACTUALIZADO ---
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButtonGestionarOrganizaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButtonGestionarVoluntarios, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButtonGestionarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButtonGestionarTipoDonacion, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButtonGestionarActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButtonAsignarDonaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                // Aquí agregamos el nuevo botón a la fila de abajo
                                                .addComponent(jButtonAsignarActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButtonReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // Ajustamos la altura vertical para que quepan todos los botones iguales
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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonAsignarActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // Layout del JFrame
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
    }// </editor-fold>                        

    // --- ACCIONES DE LOS BOTONES ---
    private void jButtonGestionarOrganizacionesActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            GestionarOrganizaciones go = new GestionarOrganizaciones();
            go.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            mostrarError("GestionarOrganizaciones", ex);
        }
        this.dispose();
    }

    private void jButtonGestionarVoluntariosActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            GestionarVoluntarios go = new GestionarVoluntarios();
            go.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            mostrarError("GestionarVoluntarios", ex);
        }
        this.dispose();
    }

    private void jButtonGestionarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            GestionarCategoria go = new GestionarCategoria();
            go.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            mostrarError("GestionarCategoria", ex);
        }
        this.dispose();
    }

    private void jButtonGestionarTipoDonacionActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            GestionarTipoDonacion go = new GestionarTipoDonacion();
            go.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            mostrarError("GestionarTipoDonacion", ex);
        }
        this.dispose();
    }

    private void jButtonGestionarActividadesActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            GestionarActividades go = new GestionarActividades();
            go.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            mostrarError("GestionarActividades", ex);
        }
        this.dispose();
    }

    private void jButtonAsignarDonacionesActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            AsignarDonacion go = new AsignarDonacion();
            go.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            mostrarError("AsignarDonacion", ex);
        }
        this.dispose();
    }

    private void jButtonAsignarActividadesActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            AsignarActividad go = new AsignarActividad();
            go.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            mostrarError("AsignarActividad", ex);
        }
        this.dispose();
    }

    // 3. NUEVA ACCIÓN PARA EL BOTÓN DE REPORTES
    private void jButtonReportesActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            GestionarReportes go = new GestionarReportes();
            go.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            mostrarError("GestionarReportes", ex);
        }
        this.dispose();
    }

    // Método auxiliar para no repetir código de error
    private void mostrarError(String modulo, Exception ex) {
        JOptionPane.showMessageDialog(this,
                "No se pudo abrir " + modulo + ": " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    // Declaración de variables
    private javax.swing.JButton jButtonAsignarActividades;
    private javax.swing.JButton jButtonAsignarDonaciones;
    private javax.swing.JButton jButtonGestionarActividades;
    private javax.swing.JButton jButtonGestionarCategoria;
    private javax.swing.JButton jButtonGestionarOrganizaciones;
    private javax.swing.JButton jButtonGestionarTipoDonacion;
    private javax.swing.JButton jButtonGestionarVoluntarios;
    private javax.swing.JButton jButtonReportes; // Nueva variable
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
}
