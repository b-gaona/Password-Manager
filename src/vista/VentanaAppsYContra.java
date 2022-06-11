package vista;

import controlador.ConexionABD;
import agregarEmailYApp.AgregarApps;
import agregarEmailYApp.AgregarEmail;
import agregarEmailYApp.EliminarEmail;
import clasesDeTablas.AppsAndPaswords;
import clasesDeTablas.EmailsOfUsers;
import controlador.RellenarLabels;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Popup;
import javax.swing.PopupFactory;

public class VentanaAppsYContra extends javax.swing.JFrame {

    private Popup popup;
    private boolean eliminar = false;

    public VentanaAppsYContra() {
        initComponents();
        this.setLocationRelativeTo(null);
        agregarInfoAPanelIzquierdo();
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(12);
        Icono();
    }

    public void agregarInfoAPanelIzquierdo() {
        if (eliminar) {
            panelIzquierdo.removeAll();
            eliminar = false;
        }
        ponerEtiquetaDeTitulo();
        panelIzquierdo.repaint();
        panelIzquierdo.revalidate();

        if (contarAplicaciones() == 0) {
            panelIzquierdo.setPreferredSize(new Dimension(591, 495));
            hacerInvisiblePanelDerecho();
        } else {
            int numApps = contarAplicaciones();
            int numFilas = (int) Math.ceil(numApps / 3d);
            int largoDelPanel = (numFilas * 210) + 80;
            int posicionX = 20, posicionY = 90;
            int auxNumApps = 0;

            panelIzquierdo.setPreferredSize(new Dimension(591, largoDelPanel));
            int cont = 0;
            for (int i = 0; i < numFilas * 3; i++) {
                if (numApps != auxNumApps) {
                    RellenarLabels botonCreado;
                    AppsAndPaswords apps = new AppsAndPaswords();
                    String nombreAplicacion = apps.mostrarAppsAndPasswords(VentanaPrincipal.idUser).elementAt((auxNumApps + 1)).getApplication();
                    String password = apps.mostrarAppsAndPasswords(VentanaPrincipal.idUser).elementAt((auxNumApps + 1)).getPassword();
                    int idEmail = apps.mostrarAppsAndPasswords(VentanaPrincipal.idUser).elementAt((auxNumApps + 1)).getIdEmails();
                    int idAppAndPass = apps.mostrarAppsAndPasswords(VentanaPrincipal.idUser).elementAt((auxNumApps + 1)).getIdAppAndPass();
                    Icon imagen = devolverImagenDeApplicacion((auxNumApps + 1));

                    botonCreado = new RellenarLabels(imagen, idAppAndPass, nombreAplicacion, password, idEmail, VentanaPrincipal.idUser);

                    crearLabelDeApp(posicionX, posicionY, (auxNumApps + 1));
                    panelIzquierdo.add(botonCreado, new org.netbeans.lib.awtextra.AbsoluteConstraints(posicionX, posicionY, 165, 165));
                    posicionX += 190;
                    auxNumApps++;
                }
                cont++;
                if (cont == 3) {
                    posicionX = 20;
                    posicionY += 210;
                    cont = 0;
                }
            }
        }
    }

    private void ponerEtiquetaDeTitulo() {
        javax.swing.JLabel etiTitulo = new javax.swing.JLabel("Aplicaciones registradas");
        etiTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        etiTitulo.setForeground(new java.awt.Color(255, 214, 10));
        etiTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiTitulo.setText("Aplicaciones registradas");
        panelIzquierdo.add(etiTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 50));
    }

    private void crearLabelDeApp(int posicionX, int posicionY, int positionOfArray) {
        AppsAndPaswords apps = new AppsAndPaswords();
        String nombreAplicacion = apps.mostrarAppsAndPasswords(VentanaPrincipal.idUser).elementAt(positionOfArray).getApplication();
        javax.swing.JLabel label = new javax.swing.JLabel(nombreAplicacion);
        label.setForeground(new Color(255, 214, 10));
        label.setFont(new Font("Tahoma", 1, 16));
        label.setBackground(new Color(0, 53, 102));
        label.setOpaque(true);
        label.setHorizontalAlignment(javax.swing.JLabel.HORIZONTAL);
        panelIzquierdo.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(posicionX, posicionY - 30, 165, 20));
    }

    private Icon devolverImagenDeApplicacion(int positionOfArray) {
        try {
            AppsAndPaswords apps = new AppsAndPaswords();
            InputStream imagen = apps.mostrarAppsAndPasswords(VentanaPrincipal.idUser).elementAt(positionOfArray).getImage();
            BufferedImage buffing = ImageIO.read(imagen);
            ImageIcon imagenIcono = new ImageIcon(buffing);
            return new ImageIcon(imagenIcono.getImage().getScaledInstance(165, 165, Image.SCALE_REPLICATE));
        } catch (IOException ex) {
            System.err.println(ex);
            return null;
        }
    }

    private int contarAplicaciones() {
        PreparedStatement ps;
        ResultSet rs;
        int i = 0;
        try {
            Connection conexion = ConexionABD.getConnection();
            //Obtenemos el conteo de cuantos id existen con el nombreusuario que mandemos como parametro
            ps = conexion.prepareStatement("select count (*) as conteo from AppAndPasswords where idUser=" + VentanaPrincipal.idUser);
            rs = ps.executeQuery();
            if (rs.next()) { //Si si hubo algo que leer, quiere decir que si hay uno con ese
                i = Integer.parseInt(rs.getString("conteo"));
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
            return i;
        }
        return i;
    }

    private int contarEmails() {
        PreparedStatement ps;
        ResultSet rs;
        int i = 0;
        try {
            Connection conexion = ConexionABD.getConnection();
            //Obtenemos el conteo de cuantos id existen con el nombreusuario que mandemos como parametro
            ps = conexion.prepareStatement("select count (*) as conteo from EmailsOfUsers");
            rs = ps.executeQuery();
            if (rs.next()) { //Si si hubo algo que leer, quiere decir que si hay uno con ese
                i = Integer.parseInt(rs.getString("conteo"));
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
            return i;
        }
        return i;
    }

    private void eventoParaPopupEnterered(java.awt.event.MouseEvent evt, int x, int y, String textToWrite) {
        JLabel text = new JLabel(textToWrite);
        text.setFont(new Font("Arial", 0, 15));
        text.setOpaque(true);
        text.setBackground(new Color(0, 18, 51));
        text.setForeground(new Color(0xFFD60A));
        popup = PopupFactory.getSharedInstance().getPopup(evt.getComponent(), text, this.getX() + x, this.getY() + y);
        popup.show();
    }

    private void limpiarCajasPanelDerecho() {
        cajaDeContra.setText("");
        cajaDeCorreo.setText("");
        cajaDeNombreApp.setText("");
        cajaIdApp.setText("");
        cajaIdEmail.setText("");
    }

    private void hacerInvisiblePanelDerecho() {
        cajaDeContra.setVisible(false);
        cajaDeCorreo.setVisible(false);
        cajaDeNombreApp.setVisible(false);
        etiContraApp.setVisible(false);
        etiCorreoApp.setVisible(false);
        etiNombreApp.setVisible(false);
        botonModificarApp.setVisible(false);
        botonEliminarApp.setVisible(false);
    }

    private void eliminarApp() {
        try {
            PreparedStatement ps;
            Connection conexion = ConexionABD.getConnection();
            ps = conexion.prepareStatement("delete from AppAndPasswords where idAppAndPass=?");
            ps.setInt(1, Integer.parseInt(cajaIdApp.getText()));
            int resultado = ps.executeUpdate(); //Ejecutamos la eliminacion

            if (resultado > 0) { //Si el resultado es mas de 0 quiere decir que se pudo realizar
                JFrame jf = new JFrame();
                jf.setAlwaysOnTop(true);
                eliminar = true;
            } else {
                JFrame jf = new JFrame();
                jf.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(jf, "Error al eliminar el registro");
            }
        } catch (HeadlessException | NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDerecho = new javax.swing.JPanel();
        etiOpciones = new javax.swing.JLabel();
        botonAgregarApp = new javax.swing.JButton();
        botonAgregarCorreo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        etiContraApp = new javax.swing.JLabel();
        etiCorreoApp = new javax.swing.JLabel();
        etiNombreApp = new javax.swing.JLabel();
        cajaDeContra = new javax.swing.JTextField();
        cajaDeCorreo = new javax.swing.JTextField();
        cajaDeNombreApp = new javax.swing.JTextField();
        cajaIdEmail = new javax.swing.JTextField();
        cajaIdApp = new javax.swing.JTextField();
        botonEliminarApp = new javax.swing.JButton();
        botonModificarApp = new javax.swing.JButton();
        cajaImagenAux = new javax.swing.JLabel();
        botonEliminarCorreo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelIzquierdo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(880, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelDerecho.setBackground(new java.awt.Color(0, 18, 51));
        panelDerecho.setMinimumSize(new java.awt.Dimension(192, 500));
        panelDerecho.setPreferredSize(new java.awt.Dimension(192, 500));
        panelDerecho.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiOpciones.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        etiOpciones.setForeground(new java.awt.Color(255, 255, 255));
        etiOpciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiOpciones.setText("Opciones del usuario");
        panelDerecho.add(etiOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 270, -1));

        botonAgregarApp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addApp.png"))); // NOI18N
        botonAgregarApp.setBorderPainted(false);
        botonAgregarApp.setContentAreaFilled(false);
        botonAgregarApp.setFocusPainted(false);
        botonAgregarApp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonAgregarAppMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonAgregarAppMouseExited(evt);
            }
        });
        botonAgregarApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarAppActionPerformed(evt);
            }
        });
        panelDerecho.add(botonAgregarApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 60, 60));

        botonAgregarCorreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addEmail.png"))); // NOI18N
        botonAgregarCorreo.setBorderPainted(false);
        botonAgregarCorreo.setContentAreaFilled(false);
        botonAgregarCorreo.setFocusPainted(false);
        botonAgregarCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonAgregarCorreoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonAgregarCorreoMouseExited(evt);
            }
        });
        botonAgregarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarCorreoActionPerformed(evt);
            }
        });
        panelDerecho.add(botonAgregarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 60, 60));
        panelDerecho.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 250, 20));

        etiContraApp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etiContraApp.setForeground(new java.awt.Color(255, 214, 10));
        etiContraApp.setText("Contraseña:");
        etiContraApp.setVisible(false);
        panelDerecho.add(etiContraApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        etiCorreoApp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etiCorreoApp.setForeground(new java.awt.Color(255, 214, 10));
        etiCorreoApp.setText("Correo:");
        etiCorreoApp.setVisible(false);
        panelDerecho.add(etiCorreoApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        etiNombreApp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etiNombreApp.setForeground(new java.awt.Color(255, 214, 10));
        etiNombreApp.setText("Nombre de la aplicación:");
        etiNombreApp.setVisible(false);
        panelDerecho.add(etiNombreApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        cajaDeContra.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cajaDeContra.setEditable(false);
        cajaDeContra.setVisible(false);
        panelDerecho.add(cajaDeContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 230, 25));

        cajaDeCorreo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cajaDeCorreo.setEditable(false);
        cajaDeCorreo.setVisible(false);
        panelDerecho.add(cajaDeCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 230, 25));

        cajaDeNombreApp.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cajaDeNombreApp.setEditable(false);
        cajaDeNombreApp.setVisible(false);
        panelDerecho.add(cajaDeNombreApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 230, 25));

        cajaIdEmail.setVisible(false);
        panelDerecho.add(cajaIdEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 30, 30));

        cajaIdApp.setVisible(false);
        panelDerecho.add(cajaIdApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 30, 30));

        botonEliminarApp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/basurita.png"))); // NOI18N
        botonEliminarApp.setFocusPainted(false);
        botonEliminarApp.setBackground(new Color(0, 18, 51, 50));
        botonEliminarApp.setVisible(false);
        botonEliminarApp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonEliminarAppMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonEliminarAppMouseExited(evt);
            }
        });
        botonEliminarApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarAppActionPerformed(evt);
            }
        });
        panelDerecho.add(botonEliminarApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 40, 40));

        botonModificarApp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_app.png"))); // NOI18N
        botonModificarApp.setFocusPainted(false);
        botonModificarApp.setBackground(new Color(0, 18, 51, 50));
        botonModificarApp.setVisible(false);
        botonModificarApp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonModificarAppMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonModificarAppMouseExited(evt);
            }
        });
        botonModificarApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarAppActionPerformed(evt);
            }
        });
        panelDerecho.add(botonModificarApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 40, 40));

        cajaImagenAux.setOpaque(true);
        cajaImagenAux.setVisible(false);
        panelDerecho.add(cajaImagenAux, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 30, 30));

        botonEliminarCorreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminarCorreo (1).png"))); // NOI18N
        botonEliminarCorreo.setBorderPainted(false);
        botonEliminarCorreo.setContentAreaFilled(false);
        botonEliminarCorreo.setFocusPainted(false);
        botonEliminarCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonEliminarCorreoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonEliminarCorreoMouseExited(evt);
            }
        });
        botonEliminarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarCorreoActionPerformed(evt);
            }
        });
        panelDerecho.add(botonEliminarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 60, 60, 60));

        getContentPane().add(panelDerecho, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 270, 500));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panelIzquierdo.setBackground(new java.awt.Color(0, 53, 102));
        panelIzquierdo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane2.setViewportView(panelIzquierdo);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarAppActionPerformed
        if (contarEmails() == 0) {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,
                    "Primero debe agregar un correo, debido"
                    + "\na que no puede agregar aplicaciones"
                    + "\nsi no tiene registrado algún correo.");
        } else {
            AgregarApps ventanaAgregarApps = new AgregarApps(this, true);
            dispose();
            ventanaAgregarApps.setVisible(true);
        }
    }//GEN-LAST:event_botonAgregarAppActionPerformed

    private void botonAgregarCorreoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAgregarCorreoMouseEntered
        eventoParaPopupEnterered(evt, 635, 160, "Agregar correo");
    }//GEN-LAST:event_botonAgregarCorreoMouseEntered

    private void botonAgregarCorreoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAgregarCorreoMouseExited
        popup.hide();
    }//GEN-LAST:event_botonAgregarCorreoMouseExited

    private void botonAgregarAppMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAgregarAppMouseEntered
        eventoParaPopupEnterered(evt, 755, 160, "Agregar aplicación");
    }//GEN-LAST:event_botonAgregarAppMouseEntered

    private void botonAgregarAppMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAgregarAppMouseExited
        popup.hide();
    }//GEN-LAST:event_botonAgregarAppMouseExited

    private void botonAgregarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarCorreoActionPerformed
        AgregarEmail ventanaEmail = new AgregarEmail(this, true);
        ventanaEmail.setVisible(true);
    }//GEN-LAST:event_botonAgregarCorreoActionPerformed

    private void botonEliminarAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarAppActionPerformed
        if (cajaDeCorreo.getText().equals("")) {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Debe seleccionar una aplicación para poder eliminarla");
        } else {
            int reply = JOptionPane.showConfirmDialog(null, "¿Está seguro que quiere eliminar " + cajaDeNombreApp.getText() + "?", "Eliminar aplicación",
                    JOptionPane.YES_NO_OPTION);
            if (reply == 0) { //Si respondio que si
                eliminarApp();
                agregarInfoAPanelIzquierdo();
                limpiarCajasPanelDerecho();
                hacerInvisiblePanelDerecho();
            }
        }
    }//GEN-LAST:event_botonEliminarAppActionPerformed

    private void botonModificarAppMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonModificarAppMouseEntered
        eventoParaPopupEnterered(evt, 685, 445, "Editar datos de la app");
    }//GEN-LAST:event_botonModificarAppMouseEntered

    private void botonModificarAppMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonModificarAppMouseExited
        popup.hide();
    }//GEN-LAST:event_botonModificarAppMouseExited

    private void botonEliminarAppMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarAppMouseEntered
        eventoParaPopupEnterered(evt, 755, 445, "Eliminar aplicación");
    }//GEN-LAST:event_botonEliminarAppMouseEntered

    private void botonEliminarAppMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarAppMouseExited
        popup.hide();
    }//GEN-LAST:event_botonEliminarAppMouseExited

    private void botonModificarAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarAppActionPerformed
        if (cajaDeNombreApp.getText().equals("")) {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Debe seleccionar una aplicación para poder hacer modificaciones.");
        } else {
            AgregarApps ventanaAgregarApps = new AgregarApps(this, true, cajaDeNombreApp.getText(), Integer.parseInt(cajaIdEmail.getText()), cajaDeContra.getText(), cajaImagenAux.getIcon(), Integer.parseInt(cajaIdApp.getText()));
            dispose();
            ventanaAgregarApps.setVisible(true);
        }
    }//GEN-LAST:event_botonModificarAppActionPerformed

    private void botonEliminarCorreoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarCorreoMouseEntered
        eventoParaPopupEnterered(evt, 710, 160, "Eliminar correo");
    }//GEN-LAST:event_botonEliminarCorreoMouseEntered

    private void botonEliminarCorreoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarCorreoMouseExited
        popup.hide();
    }//GEN-LAST:event_botonEliminarCorreoMouseExited

    private void botonEliminarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarCorreoActionPerformed
        if (contarEmails() == 0) {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,
                    "Primero debe agregar un correo, debido"
                    + "\na que no puede eliminar un correo"
                    + "\nsi no tiene registrado ninguno.");
        } else {
            EliminarEmail ventanaEmail = new EliminarEmail(this, true);
            ActionListener oyentedeboton = (ActionEvent e) -> {
                if (ventanaEmail.comboCorreos.getSelectedIndex() == 0) {
                    JFrame jf = new JFrame();
                    jf.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(jf, "Seleccione el correo que desea eliminar");
                } else {
                    int reply = JOptionPane.showConfirmDialog(null, "¿Está seguro que quiere eliminar este correo?"
                            + "\nAl eliminarlo usted perderá la información de todas las"
                            + "\naplicaciones vinculadas con ese correo.", "Verificación de eliminar correo",
                            JOptionPane.YES_NO_OPTION);
                    if (reply == 0) { //Si respondio que si
                        eliminarEmails(ventanaEmail);
                        agregarInfoAPanelIzquierdo();
                        hacerInvisiblePanelDerecho();
                    } else {
                        JFrame jf = new JFrame();
                        jf.setAlwaysOnTop(true);
                        JOptionPane.showMessageDialog(jf, "Seleccione el correo a eliminar");
                    }

                }
            };
            ventanaEmail.botonEliminarCorreo.addActionListener(oyentedeboton);
            ventanaEmail.setVisible(true);
        }
    }//GEN-LAST:event_botonEliminarCorreoActionPerformed

    private void eliminarEmails(EliminarEmail ventanaEmail) {
        try {
            PreparedStatement ps;
            Connection conexion = ConexionABD.getConnection();
            EmailsOfUsers emails = (EmailsOfUsers) ventanaEmail.comboCorreos.getSelectedItem();
            ps = conexion.prepareStatement("delete from EmailsOfUsers where idEmails=?");
            ps.setInt(1, emails.getIdEmails());
            int resultado = ps.executeUpdate(); //Ejecutamos la eliminacion

            if (resultado > 0) { //Si el resultado es mas de 0 quiere decir que se pudo realizar
                JFrame jf = new JFrame();
                jf.setAlwaysOnTop(true);
                eliminar = true;
                ventanaEmail.comboCorreos.setSelectedIndex(0);
            } else {
                JFrame jf = new JFrame();
                jf.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(jf, "Error al eliminar el registro");
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
    }

    public void Icono() {
        Image icon = new ImageIcon(getClass().getResource("/images/logoCryptoKey.png")).getImage();
        setIconImage(icon);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new VentanaAppsYContra().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarApp;
    private javax.swing.JButton botonAgregarCorreo;
    public static javax.swing.JButton botonEliminarApp;
    private javax.swing.JButton botonEliminarCorreo;
    public static javax.swing.JButton botonModificarApp;
    public static javax.swing.JTextField cajaDeContra;
    public static javax.swing.JTextField cajaDeCorreo;
    public static javax.swing.JTextField cajaDeNombreApp;
    public static javax.swing.JTextField cajaIdApp;
    public static javax.swing.JTextField cajaIdEmail;
    public static javax.swing.JLabel cajaImagenAux;
    public static javax.swing.JLabel etiContraApp;
    public static javax.swing.JLabel etiCorreoApp;
    public static javax.swing.JLabel etiNombreApp;
    private javax.swing.JLabel etiOpciones;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelDerecho;
    private javax.swing.JPanel panelIzquierdo;
    // End of variables declaration//GEN-END:variables
}
