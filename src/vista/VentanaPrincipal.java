package vista;

import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import controlador.CifrarContraseña;
import controlador.ConexionABD;
import controlador.PlaceHolder;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Popup;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class VentanaPrincipal extends javax.swing.JFrame {

    public static int idUser;
    private Popup popup;
    private PlaceHolder placeholder;
    private String claveMandada;

    //https://coolors.co/000814-001d3d-003566-ffc300-ffd60a
    public VentanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        placeholder = new PlaceHolder("Type your username", insertarUsuario);
        placeholder = new PlaceHolder("Type your password", insertarContra);
        placeholder = new PlaceHolder("Type the code", insertarCodigo);
        etiCodigo.setVisible(false);
        insertarCodigo.setVisible(false);
        botonVerCodigo.setVisible(false);
        etiAvisoDeCorreoEnviado.setVisible(false);
        Icono();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogIn = new javax.swing.JPanel();
        botonAceptar = new javax.swing.JButton();
        insertarUsuario = new javax.swing.JTextField();
        etiContra = new javax.swing.JLabel();
        etiUsuario = new javax.swing.JLabel();
        botonCrearCuenta = new javax.swing.JButton();
        insertarContra = new javax.swing.JPasswordField();
        botonVerContra = new javax.swing.JButton();
        etiImagenUser = new javax.swing.JLabel();
        etiIniciarSesion = new javax.swing.JLabel();
        etiCodigo = new javax.swing.JLabel();
        insertarCodigo = new javax.swing.JPasswordField();
        botonVerCodigo = new javax.swing.JButton();
        etiAvisoDeCorreoEnviado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 8, 20));
        setUndecorated(true);
        setResizable(false);

        panelLogIn.setBackground(new java.awt.Color(0, 29, 61));
        panelLogIn.setMinimumSize(new java.awt.Dimension(400, 500));
        panelLogIn.setPreferredSize(new java.awt.Dimension(400, 450));
        panelLogIn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonAceptar.setBackground(new java.awt.Color(255, 195, 0));
        botonAceptar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonAceptar.setText("Confirmar");
        botonAceptar.setBorderPainted(false);
        botonAceptar.setFocusPainted(false);
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });
        panelLogIn.add(botonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 90, 30));

        insertarUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        insertarUsuario.setBorder(BorderFactory.createCompoundBorder(
            insertarUsuario.getBorder(), 
            BorderFactory.createEmptyBorder(2, 8, 2, 5)));
    insertarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            insertarUsuarioKeyReleased(evt);
        }
    });
    panelLogIn.add(insertarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 220, 30));

    etiContra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    etiContra.setForeground(new java.awt.Color(255, 255, 255));
    etiContra.setText("Contraseña:");
    panelLogIn.add(etiContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 290, -1, -1));

    etiUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    etiUsuario.setForeground(new java.awt.Color(255, 255, 255));
    etiUsuario.setText("Usuario:");
    panelLogIn.add(etiUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

    botonCrearCuenta.setBackground(new java.awt.Color(0, 53, 102));
    botonCrearCuenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    botonCrearCuenta.setForeground(new java.awt.Color(255, 214, 10));
    botonCrearCuenta.setText("Crear una nueva cuenta");
    botonCrearCuenta.setBorderPainted(false);
    botonCrearCuenta.setFocusPainted(false);
    botonCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botonCrearCuentaActionPerformed(evt);
        }
    });
    panelLogIn.add(botonCrearCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 200, 30));

    insertarContra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    insertarContra.setBorder(BorderFactory.createCompoundBorder(
        insertarContra.getBorder(), 
        BorderFactory.createEmptyBorder(2, 8, 2, 5)));
insertarContra.addKeyListener(new java.awt.event.KeyAdapter() {
    public void keyReleased(java.awt.event.KeyEvent evt) {
        insertarContraKeyReleased(evt);
    }
    });
    panelLogIn.add(insertarContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 180, 30));

    botonVerContra.setBackground(new java.awt.Color(255, 255, 255));
    botonVerContra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password.png"))); // NOI18N
    botonVerContra.setBorderPainted(false);
    botonVerContra.setFocusPainted(false);
    botonVerContra.setFocusable(false);
    botonVerContra.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botonVerContraActionPerformed(evt);
        }
    });
    panelLogIn.add(botonVerContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 40, 30));

    etiImagenUser.setBackground(new java.awt.Color(204, 204, 204));
    etiImagenUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    etiImagenUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
    panelLogIn.add(etiImagenUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 400, 148));

    etiIniciarSesion.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
    etiIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
    etiIniciarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    etiIniciarSesion.setText("<html>Iniciar sesión<html>");
    panelLogIn.add(etiIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 400, 40));

    etiCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    etiCodigo.setForeground(new java.awt.Color(255, 255, 255));
    etiCodigo.setText("Código:");
    panelLogIn.add(etiCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 260, -1, -1));

    insertarCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    insertarCodigo.setBorder(BorderFactory.createCompoundBorder(
        insertarCodigo.getBorder(), 
        BorderFactory.createEmptyBorder(2, 8, 2, 5)));
insertarCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
    public void keyReleased(java.awt.event.KeyEvent evt) {
        insertarCodigoKeyReleased(evt);
    }
    });
    panelLogIn.add(insertarCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 180, 30));

    botonVerCodigo.setBackground(new java.awt.Color(255, 255, 255));
    botonVerCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password.png"))); // NOI18N
    botonVerCodigo.setBorderPainted(false);
    botonVerCodigo.setFocusPainted(false);
    botonVerCodigo.setFocusable(false);
    botonVerCodigo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botonVerCodigoActionPerformed(evt);
        }
    });
    panelLogIn.add(botonVerCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 40, 30));

    etiAvisoDeCorreoEnviado.setForeground(new java.awt.Color(255, 214, 10));
    etiAvisoDeCorreoEnviado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    etiAvisoDeCorreoEnviado.setText("!Se le ha enviado el código de verificacón a su correo!");
    panelLogIn.add(etiAvisoDeCorreoEnviado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 315, 400, -1));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(panelLogIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(panelLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVerContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerContraActionPerformed
        if (insertarContra.getEchoChar() == '\u2022') {
            insertarContra.setEchoChar((char) 0);
        } else {
            insertarContra.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_botonVerContraActionPerformed

    private void botonCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearCuentaActionPerformed
        dispose();
        AgregarCuenta addAccount = new AgregarCuenta(this, true);
        addAccount.setVisible(true);
    }//GEN-LAST:event_botonCrearCuentaActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        if (comprobarCampoVacioUsuario()) {
            JOptionPane.showMessageDialog(null, "Rellene el campo de usuario. ");
        } else if (comprobarCampoVacioContra()) {
            JOptionPane.showMessageDialog(null, "Rellene el campo de contraseña. ");
        } else if (botonAceptar.getText().equalsIgnoreCase("Confirmar")) {
            if (comprobarUsuarioYContraEnBD()) {
                insertarUsuario.setEditable(false);
                mandarPasswordACorreo();
                botonAceptar.setText("Aceptar");
                hacerVisibleCodigo();
            } else {
                JOptionPane.showMessageDialog(null, "El nombre de usuario o la contraseña está incorrecto.");
                limpiarCajas();
            }
        } else if (botonAceptar.getText().equalsIgnoreCase("Aceptar")) {
            if (claveMandada.equalsIgnoreCase(String.valueOf(insertarCodigo.getPassword()))) {
                abrirVentanaAppsYContra();
            } else {
                JOptionPane.showMessageDialog(null, "Error en el código de verificación");
            }
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void abrirVentanaAppsYContra() {
        dispose();
        new VentanaAppsYContra().setVisible(true);
    }

    private void hacerVisibleCodigo() {
        etiCodigo.setVisible(true);
        insertarCodigo.setVisible(true);
        botonVerCodigo.setVisible(true);
        etiContra.setVisible(false);
        etiUsuario.setVisible(false);
        insertarContra.setVisible(false);
        insertarUsuario.setVisible(false);
        botonVerContra.setVisible(false);
    }

    private void botonVerCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerCodigoActionPerformed
        if (insertarCodigo.getEchoChar() == '\u2022') {
            insertarCodigo.setEchoChar((char) 0);
        } else {
            insertarCodigo.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_botonVerCodigoActionPerformed

    private void insertarCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_insertarCodigoKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (claveMandada.equalsIgnoreCase(String.valueOf(insertarCodigo.getPassword()))) {
                abrirVentanaAppsYContra();
            } else {
                JOptionPane.showMessageDialog(null, "Error en el código de verificación");
            }
        }
    }//GEN-LAST:event_insertarCodigoKeyReleased

    private void insertarUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_insertarUsuarioKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!insertarUsuario.getText().equals("") && !String.valueOf(insertarContra.getPassword()).equals("")) {
                if (comprobarUsuarioYContraEnBD()) {
                    insertarUsuario.setEditable(false);
                    mandarPasswordACorreo();
                    botonAceptar.setText("Aceptar");
                    hacerVisibleCodigo();
                } else {
                    JOptionPane.showMessageDialog(null, "El nombre de usuario o la contraseña está incorrecto.");
                    limpiarCajas();
                }
            } else if (!insertarUsuario.getText().equals("") && String.valueOf(insertarContra.getPassword()).equals("")) {
                insertarContra.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_insertarUsuarioKeyReleased

    private void insertarContraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_insertarContraKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!insertarUsuario.getText().equals("") && !String.valueOf(insertarContra.getPassword()).equals("")) {
                if (comprobarUsuarioYContraEnBD()) {
                    insertarUsuario.setEditable(false);
                    mandarPasswordACorreo();
                    botonAceptar.setText("Aceptar");
                    hacerVisibleCodigo();
                } else {
                    JOptionPane.showMessageDialog(null, "El nombre de usuario o la contraseña está incorrecto.");
                    limpiarCajas();
                }
            } else if (!String.valueOf(insertarContra.getPassword()).equals("") && insertarUsuario.getText().equals("")) {
                insertarUsuario.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_insertarContraKeyReleased

    private void limpiarCajas() {
        insertarContra.setText("");
        insertarUsuario.setText("");
    }

    private boolean comprobarUsuarioYContraEnBD() {
        PreparedStatement ps; //Para ver los datos de Acces
        ResultSet rs; //Para traer datos
        boolean bandera = false;

        try {
            String password = CifrarContraseña.md5(String.valueOf(insertarContra.getPassword()));

            Connection conexion = ConexionABD.getConnection();
            //Agregamos esto para que no se puedan agregar mas codigos con ese mismo nombre
            ps = conexion.prepareStatement("select username, password, idUsers from Users");
            rs = ps.executeQuery();
            while (rs.next()) {
                if (insertarUsuario.getText().equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
                    idUser = rs.getInt("idUsers");
                    bandera = true;
                }
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
        return bandera;
    }

    private boolean comprobarCampoVacioUsuario() {
        return insertarUsuario.getText().equals("");
    }

    private boolean comprobarCampoVacioContra() {
        return String.valueOf(insertarContra.getPassword()).equals("");
    }

    private void mandarPasswordACorreo() {
        this.claveMandada = generarPassword(6);

        String asunto = "Código de verificación";
        String destinatario = obtenerEmailDelUsuario();
        String mensajeAEnviar = "Código de verificación de la app: " + claveMandada;
        String correoEnvia = "verificacionclaveapp@gmail.com";
        String passwordCorreoEnvia = "verificacionclaveapp10";

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
                return new PasswordAuthentication(correoEnvia, passwordCorreoEnvia);
            }
        });
        sesion.setDebug(false);

        try {
            MimeMessage mail = new MimeMessage(sesion);
            mail.setFrom(new InternetAddress(correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mail.setSubject(asunto);
            mail.setText(mensajeAEnviar);

            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEnvia, passwordCorreoEnvia);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
            etiAvisoDeCorreoEnviado.setVisible(true);

        } catch (AddressException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String generarPassword(int length) {
        String contra = "";
        String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String minusculas = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "12345678901234567890";
        String conjunto = mayusculas + minusculas + numeros;
        for (int i = 1; i <= length; i++) {
            Random aleatorio = new Random();
            contra += conjunto.charAt(aleatorio.nextInt(conjunto.length()));
        }
        return contra;
    }

    private String obtenerEmailDelUsuario() {
        String destinatario = "";
        PreparedStatement ps; //Para ver los datos de Acces
        ResultSet rs; //Para traer datos

        try {
            Connection conexion = ConexionABD.getConnection();
            //Agregamos esto para que no se puedan agregar mas codigos con ese mismo nombre
            ps = conexion.prepareStatement("select username, email from Users");
            rs = ps.executeQuery();
            while (rs.next()) {
                if (insertarUsuario.getText().equals(rs.getString("username"))) {
                    destinatario = rs.getString("email");
                }
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
        return destinatario;
    }

    private static void lookAndFeel() {
        Properties props = new Properties();
        props.put("logoString", " Menú");
        GraphiteLookAndFeel.setCurrentTheme(props);
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Icono() {
        Image icon = new ImageIcon(getClass().getResource("/images/logoCryptoKey.png")).getImage();
        setIconImage(icon);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            lookAndFeel();
            new VentanaPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCrearCuenta;
    private javax.swing.JButton botonVerCodigo;
    private javax.swing.JButton botonVerContra;
    private javax.swing.JLabel etiAvisoDeCorreoEnviado;
    private javax.swing.JLabel etiCodigo;
    private javax.swing.JLabel etiContra;
    private javax.swing.JLabel etiImagenUser;
    private javax.swing.JLabel etiIniciarSesion;
    private javax.swing.JLabel etiUsuario;
    private javax.swing.JPasswordField insertarCodigo;
    private javax.swing.JPasswordField insertarContra;
    private javax.swing.JTextField insertarUsuario;
    private javax.swing.JPanel panelLogIn;
    // End of variables declaration//GEN-END:variables
}
