package vista;

import controlador.CifrarContraseña;
import controlador.ConexionABD;
import controlador.PlaceHolder;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.swing.JOptionPane;

public class AgregarCuenta extends javax.swing.JDialog {

    PlaceHolder placeHolder;

    public AgregarCuenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        placeHolder = new PlaceHolder("Type your email", insertarCorreo);
        placeHolder = new PlaceHolder("Type your username", insertarUsuario);
        placeHolder = new PlaceHolder("Type your password", insertarContra);
        placeHolder = new PlaceHolder("Type your password", insertarContraUsuario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        etiUsuario = new javax.swing.JLabel();
        insertarUsuario = new javax.swing.JTextField();
        etiContra = new javax.swing.JLabel();
        insertarContra = new javax.swing.JPasswordField();
        botonVerContra = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        etiNotaRecomendacion = new javax.swing.JLabel();
        botonInfo = new javax.swing.JButton();
        etiCuentaNueva = new javax.swing.JLabel();
        insertarCorreo = new javax.swing.JTextField();
        etiCorreo = new javax.swing.JLabel();
        etiContraUsuario = new javax.swing.JLabel();
        insertarContraUsuario = new javax.swing.JPasswordField();
        botonVerContraUsuario = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        etiNotaRecomendacion1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 29, 61));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etiUsuario.setForeground(new java.awt.Color(255, 255, 255));
        etiUsuario.setText("Usuario:");
        jPanel1.add(etiUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 225, -1, -1));

        insertarUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        insertarUsuario.setBorder(BorderFactory.createCompoundBorder(
            insertarUsuario.getBorder(), 
            BorderFactory.createEmptyBorder(2, 8, 2, 5)));
    insertarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            insertarUsuarioKeyReleased(evt);
        }
    });
    jPanel1.add(insertarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 225, 220, 30));

    etiContra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    etiContra.setForeground(new java.awt.Color(255, 255, 255));
    etiContra.setText("Contraseña:");
    jPanel1.add(etiContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

    insertarContra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    insertarContra.setBorder(BorderFactory.createCompoundBorder(
        insertarContra.getBorder(), 
        BorderFactory.createEmptyBorder(2, 8, 2, 5)));
insertarContra.addKeyListener(new java.awt.event.KeyAdapter() {
    public void keyReleased(java.awt.event.KeyEvent evt) {
        insertarContraKeyReleased(evt);
    }
    });
    jPanel1.add(insertarContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 180, 30));

    botonVerContra.setBackground(new java.awt.Color(255, 255, 255));
    botonVerContra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password.png"))); // NOI18N
    botonVerContra.setBorder(null);
    botonVerContra.setBorderPainted(false);
    botonVerContra.setFocusPainted(false);
    botonVerContra.setFocusable(false);
    botonVerContra.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botonVerContraActionPerformed(evt);
        }
    });
    jPanel1.add(botonVerContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 40, 30));

    botonAceptar.setBackground(new java.awt.Color(255, 195, 0));
    botonAceptar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    botonAceptar.setText("Aceptar");
    botonAceptar.setBorderPainted(false);
    botonAceptar.setFocusPainted(false);
    botonAceptar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botonAceptarActionPerformed(evt);
        }
    });
    jPanel1.add(botonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 335, 90, 30));

    etiNotaRecomendacion.setForeground(new java.awt.Color(255, 214, 10));
    etiNotaRecomendacion.setText("<html>Nota: La contraseña y el correo deben de ser originales, de una cuenta de outlook o de una de gmail.<html>");
    jPanel1.add(etiNotaRecomendacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 25, 370, 90));

    botonInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoInfo.png"))); // NOI18N
    botonInfo.setBorder(null);
    botonInfo.setBorderPainted(false);
    botonInfo.setContentAreaFilled(false);
    botonInfo.setFocusPainted(false);
    botonInfo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botonInfoActionPerformed(evt);
        }
    });
    jPanel1.add(botonInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

    etiCuentaNueva.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
    etiCuentaNueva.setForeground(new java.awt.Color(255, 255, 255));
    etiCuentaNueva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    etiCuentaNueva.setText("<html>Cuenta nueva de Password Manager <html>");
    jPanel1.add(etiCuentaNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, -20, 400, 80));

    insertarCorreo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    insertarCorreo.setBorder(BorderFactory.createCompoundBorder(
        insertarCorreo.getBorder(), 
        BorderFactory.createEmptyBorder(2, 8, 2, 5)));
insertarCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
    public void keyReleased(java.awt.event.KeyEvent evt) {
        insertarCorreoKeyReleased(evt);
    }
    });
    jPanel1.add(insertarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 220, 30));

    etiCorreo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    etiCorreo.setForeground(new java.awt.Color(255, 255, 255));
    etiCorreo.setText("Correo:");
    jPanel1.add(etiCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 100, -1, -1));

    etiContraUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    etiContraUsuario.setForeground(new java.awt.Color(255, 255, 255));
    etiContraUsuario.setText("Contraseña:");
    jPanel1.add(etiContraUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 275, -1, -1));

    insertarContraUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    insertarContraUsuario.setBorder(BorderFactory.createCompoundBorder(
        insertarContraUsuario.getBorder(), 
        BorderFactory.createEmptyBorder(2, 8, 2, 5)));
insertarContraUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
    public void keyReleased(java.awt.event.KeyEvent evt) {
        insertarContraUsuarioKeyReleased(evt);
    }
    });
    jPanel1.add(insertarContraUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 275, 180, 30));

    botonVerContraUsuario.setBackground(new java.awt.Color(255, 255, 255));
    botonVerContraUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password.png"))); // NOI18N
    botonVerContraUsuario.setBorder(null);
    botonVerContraUsuario.setBorderPainted(false);
    botonVerContraUsuario.setFocusPainted(false);
    botonVerContraUsuario.setFocusable(false);
    botonVerContraUsuario.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botonVerContraUsuarioActionPerformed(evt);
        }
    });
    jPanel1.add(botonVerContraUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 275, 40, 30));
    jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 360, 10));

    etiNotaRecomendacion1.setForeground(new java.awt.Color(255, 214, 10));
    etiNotaRecomendacion1.setText("<html>Nota: Se le recomienda registrarse con su correo personal debido a que ahí es donde se enviará el código de verificación cada que quiera ingresar a esta aplicación.<html>");
    jPanel1.add(etiNotaRecomendacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 370, 90));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dispose();
        new VentanaPrincipal().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void botonVerContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerContraActionPerformed
        if (insertarContra.getEchoChar() == '\u2022') {
            insertarContra.setEchoChar((char) 0);
        } else {
            insertarContra.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_botonVerContraActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        if (comprobarCampoVacioCorreo()) {
            JOptionPane.showMessageDialog(null, "Rellene el campo del correo");
        } else if (comprobarCampoVacioUsuario()) {
            JOptionPane.showMessageDialog(null, "Rellene el campo de la contraseña de su correo");
        } else if (comprobarCampoVacioContra()) {
            JOptionPane.showMessageDialog(null, "Rellene el campo del usuario");
        } else if (comprobarCampoVacioContraUsuario()) {
            JOptionPane.showMessageDialog(null, "Rellene el campo de la contraseña de su usuario");
        } else {
            if (comprobarCorreoYContraseña()) {
                comprobarUsuarioYCorreoYAgregar();
            }
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void comprobarUsuarioYCorreoYAgregar() {
        PreparedStatement ps; //Para ver los datos de Access
        ResultSet rs; //Para traer datos
        try {
            Connection conexion = ConexionABD.getConnection();
            boolean bandera = false;
            //Agregamos esto para que no se puedan agregar mas codigos con ese mismo nombre
            ps = conexion.prepareStatement("select email, username from Users");
            rs = ps.executeQuery();
            while (rs.next()) {
                if (insertarCorreo.getText().equals(rs.getString("email"))) {
                    bandera = true;
                }
                if (insertarUsuario.getText().equals(rs.getString("username"))) {
                    bandera = true;
                }
            }
            if (bandera) { //Si ya existe, no hacemos la insercion.Sino que solo indicamos que ese codigo ya existe.
                JOptionPane.showMessageDialog(null, "Ese nombre de usuario o correo ya está registrado");
                insertarCorreo.setText("");
                insertarUsuario.setText("");
            } else { //Hacemos el registro
                String password = CifrarContraseña.md5(String.valueOf(insertarContraUsuario.getPassword()));
                //Agregamos el registro con los 3 campos
                ps = conexion.prepareStatement("insert into Users (email, username, password) values (?, ?, ?)");
                ps.setString(1, insertarCorreo.getText());
                ps.setString(2, insertarUsuario.getText());
                ps.setString(3, password);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente!");
                limpiarCajas();
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
    }

    private void limpiarCajas() {
        insertarContra.setText("");
        insertarCorreo.setText("");
        insertarUsuario.setText("");
        insertarContraUsuario.setText("");
    }

    private void botonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInfoActionPerformed
        JOptionPane.showMessageDialog(null,
                "Si presenta errores a la hora de crear la cuenta, verificar"
                + "\nlos parámetros de seguridad de su correo personal, debido"
                + "\na que algunos restringen el uso de aplicaciones terceras"
                + "\npara su uso."
                + "\nUna vez permitiendo eso, ya podrá registrarse en la aplicación.");
    }//GEN-LAST:event_botonInfoActionPerformed

    private void botonVerContraUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerContraUsuarioActionPerformed
        if (insertarContraUsuario.getEchoChar() == '\u2022') {
            insertarContraUsuario.setEchoChar((char) 0);
        } else {
            insertarContraUsuario.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_botonVerContraUsuarioActionPerformed

    private void insertarCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_insertarCorreoKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!insertarCorreo.getText().equals("") && !String.valueOf(insertarContra.getPassword()).equals("")) {
                if (insertarUsuario.getText().equals("") && String.valueOf(insertarContraUsuario.getPassword()).equals("")) {
                    insertarUsuario.requestFocusInWindow();
                } else if (insertarUsuario.getText().equals("")) {
                    insertarUsuario.requestFocusInWindow();
                } else if (String.valueOf(insertarContraUsuario.getPassword()).equals("")) {
                    insertarContraUsuario.requestFocusInWindow();
                } else {
                    if (comprobarCorreoYContraseña()) {
                        comprobarUsuarioYCorreoYAgregar();
                    }
                }
            } else if (!insertarCorreo.getText().equals("") && String.valueOf(insertarContra.getPassword()).equals("")) {
                insertarContra.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_insertarCorreoKeyReleased

    private void insertarContraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_insertarContraKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!insertarCorreo.getText().equals("") && !String.valueOf(insertarContra.getPassword()).equals("")) {
                if (insertarUsuario.getText().equals("") && String.valueOf(insertarContraUsuario.getPassword()).equals("")) {
                    insertarUsuario.requestFocusInWindow();
                } else if (insertarUsuario.getText().equals("")) {
                    insertarUsuario.requestFocusInWindow();
                } else if (String.valueOf(insertarContraUsuario.getPassword()).equals("")) {
                    insertarContraUsuario.requestFocusInWindow();
                } else {
                    if (comprobarCorreoYContraseña()) {
                        comprobarUsuarioYCorreoYAgregar();
                    }
                }
            } else if (insertarCorreo.getText().equals("") && !String.valueOf(insertarContra.getPassword()).equals("")) {
                insertarCorreo.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_insertarContraKeyReleased

    private void insertarUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_insertarUsuarioKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!insertarUsuario.getText().equals("") && !String.valueOf(insertarContraUsuario.getPassword()).equals("")) {
                if (insertarCorreo.getText().equals("") && String.valueOf(insertarContra.getPassword()).equals("")) {
                    insertarCorreo.requestFocusInWindow();
                } else if (insertarCorreo.getText().equals("")) {
                    insertarCorreo.requestFocusInWindow();
                } else if (String.valueOf(insertarContra.getPassword()).equals("")) {
                    insertarContra.requestFocusInWindow();
                } else {
                    if (comprobarCorreoYContraseña()) {
                        comprobarUsuarioYCorreoYAgregar();
                    }
                }
            } else if (!insertarUsuario.getText().equals("") && String.valueOf(insertarContraUsuario.getPassword()).equals("")) {
                insertarContraUsuario.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_insertarUsuarioKeyReleased

    private void insertarContraUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_insertarContraUsuarioKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!insertarUsuario.getText().equals("") && !String.valueOf(insertarContraUsuario.getPassword()).equals("")) {
                if (insertarCorreo.getText().equals("") && String.valueOf(insertarContra.getPassword()).equals("")) {
                    insertarCorreo.requestFocusInWindow();
                } else if (insertarCorreo.getText().equals("")) {
                    insertarCorreo.requestFocusInWindow();
                } else if (String.valueOf(insertarContra.getPassword()).equals("")) {
                    insertarContra.requestFocusInWindow();
                } else {
                    if (comprobarCorreoYContraseña()) {
                        comprobarUsuarioYCorreoYAgregar();
                    }
                }
            } else if (insertarUsuario.getText().equals("") && !String.valueOf(insertarContraUsuario.getPassword()).equals("")) {
                insertarUsuario.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_insertarContraUsuarioKeyReleased

    private boolean comprobarCampoVacioCorreo() {
        return insertarCorreo.getText().equals("");
    }

    private boolean comprobarCampoVacioContra() {
        return String.valueOf(insertarContra.getPassword()).equals("");
    }

    private boolean comprobarCampoVacioContraUsuario() {
        return String.valueOf(insertarContraUsuario.getPassword()).equals("");
    }

    private boolean comprobarCampoVacioUsuario() {
        return insertarUsuario.getText().equals("");
    }

    private boolean comprobarCorreoYContraseña() {
        String correoEnvia = insertarCorreo.getText();
        String contrasena = String.valueOf(insertarContra.getPassword());

        Properties props = new Properties();
        if (correoEnvia.contains("gmail.com")) {
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
        } else {
            props.setProperty("mail.smtp.host", "smtp.live.com");
        }

        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.auth", "true");

        Session sesion = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(correoEnvia, contrasena);
            }
        });
        sesion.setDebug(false);

        Transport transport = null;

        try {
            transport = sesion.getTransport("smtp");
        } catch (javax.mail.NoSuchProviderException ex) {
            System.err.println(ex);
        }
        try {
            transport.connect();
            return true;
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(null, "La contraseña o el correo no existen o no tienen habilitados"
                    + "\nlos accesos para ser usados en aplicaciones terceras");
            limpiarCajas();
            return false;
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            AgregarCuenta dialog = new AgregarCuenta(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonInfo;
    private javax.swing.JButton botonVerContra;
    private javax.swing.JButton botonVerContraUsuario;
    private javax.swing.JLabel etiContra;
    private javax.swing.JLabel etiContraUsuario;
    private javax.swing.JLabel etiCorreo;
    private javax.swing.JLabel etiCuentaNueva;
    private javax.swing.JLabel etiNotaRecomendacion;
    private javax.swing.JLabel etiNotaRecomendacion1;
    private javax.swing.JLabel etiUsuario;
    private javax.swing.JPasswordField insertarContra;
    private javax.swing.JPasswordField insertarContraUsuario;
    private javax.swing.JTextField insertarCorreo;
    private javax.swing.JTextField insertarUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
