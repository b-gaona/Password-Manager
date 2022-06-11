package agregarEmailYApp;

import clasesDeTablas.EmailsOfUsers;
import controlador.ConexionABD;
import controlador.EncriptarYDesencriptarContra;
import controlador.PlaceHolder;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import vista.VentanaAppsYContra;
import vista.VentanaPrincipal;

public class AgregarApps extends javax.swing.JDialog {

    File archivo;
    boolean imagenEnPanel = false, activado = false;
    PlaceHolder placeholder;
    java.awt.Color color;
    public VentanaAppsYContra v1;
    boolean seleccionarFile = false; //Sirve para la modificacion de saber si se ha seleccionado otro archivo o no
    int idApp;

    public AgregarApps(java.awt.Frame parent, boolean modal, String nombreApp, int correo, String password, Icon icon, int idApp) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        EmailsOfUsers emails = new EmailsOfUsers();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(emails.mostrarEmails(VentanaPrincipal.idUser));
        comboCorreo.setModel(modelo);
        v1 = new VentanaAppsYContra();
        etiTitulo.setText("Modificar aplicación");
        botonAgregarAplicacion.setText("Modificar aplicación");
        comboCorreo.setSelectedIndex(correo);
        insertarNombreAplicacion.setText(nombreApp);
        insertarContra.setText(password);
        botonFondo.removeAll();
        botonFondo.setIcon(icon);
        this.idApp = idApp;
        repaint();
        revalidate();
    }

    public AgregarApps(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        placeholder = new PlaceHolder("Name of the application", insertarNombreAplicacion);
        placeholder = new PlaceHolder("Type your password", insertarContra);
        EmailsOfUsers emails = new EmailsOfUsers();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(emails.mostrarEmails(VentanaPrincipal.idUser));
        comboCorreo.setModel(modelo);
        v1 = new VentanaAppsYContra();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonVerContra2 = new javax.swing.JButton();
        insertarContra = new javax.swing.JPasswordField();
        etiContra = new javax.swing.JLabel();
        etiUsuario1 = new javax.swing.JLabel();
        insertarNombreAplicacion = new javax.swing.JTextField();
        etiUsuario = new javax.swing.JLabel();
        comboCorreo = new javax.swing.JComboBox<>();
        etiTitulo = new javax.swing.JLabel();
        botonAgregarAplicacion = new javax.swing.JButton();
        botonSeleccionarImagen = new javax.swing.JButton();
        botonFondo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 520));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 53, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 430));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 430));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonVerContra2.setBackground(new java.awt.Color(255, 255, 255));
        botonVerContra2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password.png"))); // NOI18N
        botonVerContra2.setBorder(null);
        botonVerContra2.setBorderPainted(false);
        botonVerContra2.setFocusPainted(false);
        botonVerContra2.setFocusable(false);
        botonVerContra2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerContra2ActionPerformed(evt);
            }
        });
        jPanel1.add(botonVerContra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 40, 30));

        insertarContra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        insertarContra.setBorder(BorderFactory.createCompoundBorder(
            insertarContra.getBorder(), 
            BorderFactory.createEmptyBorder(2, 8, 2, 5)));
    jPanel1.add(insertarContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 180, 30));

    etiContra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    etiContra.setForeground(new java.awt.Color(255, 255, 255));
    etiContra.setText("Contraseña:");
    jPanel1.add(etiContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, -1));

    etiUsuario1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    etiUsuario1.setForeground(new java.awt.Color(255, 255, 255));
    etiUsuario1.setText("Correo utilizado:");
    jPanel1.add(etiUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

    insertarNombreAplicacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    insertarNombreAplicacion.setBorder(BorderFactory.createCompoundBorder(
        insertarNombreAplicacion.getBorder(), 
        BorderFactory.createEmptyBorder(2, 8, 2, 5)));
jPanel1.add(insertarNombreAplicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 220, 30));

etiUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
etiUsuario.setForeground(new java.awt.Color(255, 255, 255));
etiUsuario.setText("Nombre de la aplicación:");
jPanel1.add(etiUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

comboCorreo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
jPanel1.add(comboCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 280, 30));

etiTitulo.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
etiTitulo.setForeground(new java.awt.Color(255, 214, 10));
etiTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
etiTitulo.setText("Agregar aplicación");
jPanel1.add(etiTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 60));

botonAgregarAplicacion.setBackground(new java.awt.Color(255, 214, 10));
botonAgregarAplicacion.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
botonAgregarAplicacion.setText("Agregar aplicación");
botonAgregarAplicacion.setBorderPainted(false);
botonAgregarAplicacion.setFocusPainted(false);
botonAgregarAplicacion.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        botonAgregarAplicacionActionPerformed(evt);
    }
    });
    jPanel1.add(botonAgregarAplicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 435, 150, 30));

    botonSeleccionarImagen.setBackground(new java.awt.Color(255, 214, 10));
    botonSeleccionarImagen.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
    botonSeleccionarImagen.setText("Seleccionar imagen");
    botonSeleccionarImagen.setBorderPainted(false);
    botonSeleccionarImagen.setFocusPainted(false);
    botonSeleccionarImagen.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botonSeleccionarImagenActionPerformed(evt);
        }
    });
    jPanel1.add(botonSeleccionarImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 240, 150, 30));

    botonFondo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    botonFondo.setFocusPainted(false);
    botonFondo.setBackground(new Color(0, 18, 51, 50));
    jPanel1.add(botonFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 65, 165, 165));

    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 520));

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVerContra2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerContra2ActionPerformed
        if (insertarContra.getEchoChar() == '\u2022') {
            insertarContra.setEchoChar((char) 0);
        } else {
            insertarContra.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_botonVerContra2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (!activado) {
            v1.setVisible(true);
            v1.setAutoRequestFocus(true);
            v1.setAlwaysOnTop(true);
        } else {
            activado = false;
        }
    }//GEN-LAST:event_formWindowClosing

    private void botonAgregarAplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarAplicacionActionPerformed
        JFrame jf = new JFrame();
        jf.setAlwaysOnTop(true);
        if (botonAgregarAplicacion.getText().equals("Modificar aplicación")) {
            if (comprobarCampoVacioAplicacion()) {
                JOptionPane.showMessageDialog(jf, "Rellene el campo del nombre de la aplicación. ");
            } else if (comprobarCampoVacioCorreoSeleccionado()) {
                JOptionPane.showMessageDialog(jf, "Rellene el campo del correo utilizado. ");
            } else if (comprobarCampoVacioContra()) {
                JOptionPane.showMessageDialog(jf, "Rellene el campo de contraseña. ");
            } else {
                modificarAplicacion();
                dispose();
                new VentanaAppsYContra().setVisible(true);
                activado = true;
            }
        } else {
            if (comprobarCampoVacioAplicacion()) {
                JOptionPane.showMessageDialog(jf, "Rellene el campo del nombre de la aplicación. ");
            } else if (comprobarCampoVacioCorreoSeleccionado()) {
                JOptionPane.showMessageDialog(jf, "Rellene el campo del correo utilizado. ");
            } else if (comprobarCampoVacioContra()) {
                JOptionPane.showMessageDialog(jf, "Rellene el campo de contraseña. ");
            } else if (!imagenEnPanel) {
                int reply = JOptionPane.showConfirmDialog(jf, "¿Está seguro que no quiere agregar imagenes?", "Verificación de imagen",
                        JOptionPane.YES_NO_OPTION);
                if (reply == 0) { //Si respondio que si
                    dispose();
                    agregarAplicacionSinImagen();
                    dispose();
                    new VentanaAppsYContra().setVisible(true);
                    activado = true;
                } else {
                    JOptionPane.showMessageDialog(jf, "Presione el botón de seleccionar imagen");
                }
            } else {
                agregarAplicacionConImagen();
                dispose();
                new VentanaAppsYContra().setVisible(true);
                activado = true;
            }
        }
    }//GEN-LAST:event_botonAgregarAplicacionActionPerformed

    private void botonSeleccionarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeleccionarImagenActionPerformed
        JFileChooser escoger = new JFileChooser(); //Se crea la carpeta para escoger
        escoger.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); //Que seleccione archivos y directorios
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.png", "png"); //Filtras el tipo de dato que acepte el FileChooser
        FileNameExtensionFilter filtro2 = new FileNameExtensionFilter("*.jpg", "jpg");
        escoger.setFileFilter(filtro2);
        escoger.setFileFilter(filtro);
        int seleccion = escoger.showOpenDialog(this); //Darnos cuenta cual ha sido la opcion que el usuario escogio dentro del Dialog

        if (seleccion == JFileChooser.APPROVE_OPTION) { //Darnos cuenta si el usuario escogio ACEPTAR
            repaint();
            seleccionarFile = true;
            imagenEnPanel = true;
            archivo = escoger.getSelectedFile(); //Obtenemos el archivo que se selecciono
            try {
                //Creamos un archivo de tipo binario donde guardamos el archivo seleccionado
                BufferedImage buffimg = ImageIO.read(archivo);
                ImageIcon imagen = new ImageIcon(buffimg);
                botonFondo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(165, 165, Image.SCALE_REPLICATE)));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_botonSeleccionarImagenActionPerformed

    private void modificarAplicacion() {
        JFrame jf = new JFrame();
        jf.setAlwaysOnTop(true);
        if (seleccionarFile) {
            try {
                PreparedStatement ps;
                EmailsOfUsers email = (EmailsOfUsers) comboCorreo.getSelectedItem();
                Connection conexion = ConexionABD.getConnection();
                //Creamos un archivo de tipo binario donde guardamos el archivo seleccionado
                FileInputStream archivoEntrada = new FileInputStream(archivo);
                ps = conexion.prepareStatement("update AppAndPasswords set application=?, password=?, idEmails=?, image=? where idAppAndPass=?");
                ps.setString(1, insertarNombreAplicacion.getText());
                ps.setString(2, EncriptarYDesencriptarContra.encriptar(String.valueOf(insertarContra.getPassword()), 3));
                ps.setInt(3, email.getIdEmails());
                ps.setBinaryStream(4, archivoEntrada, (int) archivo.length());
                ps.setInt(5, this.idApp);

                int resultado = ps.executeUpdate(); //Ejecutamos la modificacion dentro de la BD
                if (resultado > 0) { //Si el resultado es mas de 0 quiere decir que se pudo realizar
                    //JOptionPane.showMessageDialog(jf, "Modificación exitosa");
                } else {
                    JOptionPane.showMessageDialog(jf, "Error al hacer la modificación");
                }

                //Aqui eliminamos todo lo seleccionado
                imagenEnPanel = false;
                repaint();
                insertarContra.setText("");
                insertarNombreAplicacion.setText("");
                comboCorreo.setSelectedIndex(0);
                seleccionarFile = false; //Se regresa a su estado original
            } catch (HeadlessException | FileNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            try {
                PreparedStatement ps;
                EmailsOfUsers email = (EmailsOfUsers) comboCorreo.getSelectedItem();
                Connection conexion = ConexionABD.getConnection();
                //Creamos un archivo de tipo binario donde guardamos el archivo seleccionado
                ps = conexion.prepareStatement("update AppAndPasswords set application=?, password=?, idEmails=? where idAppAndPass=?");
                ps.setString(1, insertarNombreAplicacion.getText());
                ps.setString(2, EncriptarYDesencriptarContra.encriptar(String.valueOf(insertarContra.getPassword()), 3));
                ps.setInt(3, email.getIdEmails());
                ps.setInt(4, this.idApp);
                int resultado = ps.executeUpdate(); //Ejecutamos la modificacion dentro de la BD
                if (resultado > 0) { //Si el resultado es mas de 0 quiere decir que se pudo realizar
                    //JOptionPane.showMessageDialog(jf, "Modificación exitosa");
                } else {
                    JOptionPane.showMessageDialog(jf, "Error al hacer la modificación");
                }

                //Aqui eliminamos todo lo seleccionado
                imagenEnPanel = false;
                repaint();
                insertarContra.setText("");
                insertarNombreAplicacion.setText("");
                comboCorreo.setSelectedIndex(0);
                seleccionarFile = false; //Se regresa a su estado original
            } catch (HeadlessException | SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    private void agregarAplicacionSinImagen() {
        JFrame jf = new JFrame();
        jf.setAlwaysOnTop(true);
        try {
            PreparedStatement ps;
            EmailsOfUsers email = (EmailsOfUsers) comboCorreo.getSelectedItem();
            Connection conexion = ConexionABD.getConnection();
            //Creamos un archivo de tipo binario donde guardamos el archivo seleccionado
            ps = conexion.prepareStatement("insert into AppAndPasswords (application, password, idEmails, image, idUser) values (?, ?, ?, ?, ?)");
            ps.setString(1, insertarNombreAplicacion.getText());
            ps.setString(2, EncriptarYDesencriptarContra.encriptar(String.valueOf(insertarContra.getPassword()), 3));
            ps.setInt(3, email.getIdEmails());
            ps.setInt(5, email.getIdUsers());
            InputStream stream = getClass().getResourceAsStream("/images/logoCryptoKey.png");
            ps.setBinaryStream(4, stream);
            ps.executeUpdate();
            //Aqui eliminamos todo lo seleccionado
            imagenEnPanel = false;
            repaint();
            insertarContra.setText("");
            insertarNombreAplicacion.setText("");
            comboCorreo.setSelectedIndex(0);
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void agregarAplicacionConImagen() {
        JFrame jf = new JFrame();
        jf.setAlwaysOnTop(true);
        try {
            PreparedStatement ps;
            EmailsOfUsers email = (EmailsOfUsers) comboCorreo.getSelectedItem();
            Connection conexion = ConexionABD.getConnection();
            //Creamos un archivo de tipo binario donde guardamos el archivo seleccionado
            FileInputStream archivoEntrada = new FileInputStream(archivo);
            ps = conexion.prepareStatement("insert into AppAndPasswords (application, password, idEmails, image, idUser) values (?, ?, ?, ?, ?)");
            /*
                Primero que nada se inicializa en setBinaryStream porque se registrara binario, despues se le pone el
                archivoEntrada porque este es el que ya esta convertido en binario. Y por ultimo de tipo int se debe de pasar
                la longitud o peso del archivo.
             */
            ps.setString(1, insertarNombreAplicacion.getText());
            ps.setString(2, EncriptarYDesencriptarContra.encriptar(String.valueOf(insertarContra.getPassword()), 3));
            ps.setInt(3, email.getIdEmails());
            ps.setBinaryStream(4, archivoEntrada, (int) archivo.length());
            ps.setInt(5, email.getIdUsers());
            ps.executeUpdate();
            //Aqui eliminamos todo lo seleccionado
            imagenEnPanel = false;
            repaint();
            insertarContra.setText("");
            insertarNombreAplicacion.setText("");
            comboCorreo.setSelectedIndex(0);
        } catch (HeadlessException | FileNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private boolean comprobarCampoVacioCorreoSeleccionado() {
        return comboCorreo.getSelectedIndex() == 0;
    }

    private boolean comprobarCampoVacioAplicacion() {
        return insertarNombreAplicacion.getText().equals("");
    }

    private boolean comprobarCampoVacioContra() {
        return String.valueOf(insertarContra.getPassword()).equals("");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            AgregarApps dialog = new AgregarApps(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botonAgregarAplicacion;
    private javax.swing.JButton botonFondo;
    private javax.swing.JButton botonSeleccionarImagen;
    private javax.swing.JButton botonVerContra2;
    private javax.swing.JComboBox<String> comboCorreo;
    private javax.swing.JLabel etiContra;
    private javax.swing.JLabel etiTitulo;
    private javax.swing.JLabel etiUsuario;
    private javax.swing.JLabel etiUsuario1;
    private javax.swing.JPasswordField insertarContra;
    private javax.swing.JTextField insertarNombreAplicacion;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
