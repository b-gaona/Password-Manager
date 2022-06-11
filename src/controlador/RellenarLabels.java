package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import vista.VentanaAppsYContra;

public class RellenarLabels extends javax.swing.JButton {

    Icon imagen;
    private int idAppAndPass;
    private String application;
    private String password;
    private int idEmails;
    private int idUser;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Icon getImagen() {
        return imagen;
    }

    public void setImagen(Icon imagen) {
        this.imagen = imagen;
    }

    public int getIdAppAndPass() {
        return idAppAndPass;
    }

    public void setIdAppAndPass(int idAppAndPass) {
        this.idAppAndPass = idAppAndPass;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdEmails() {
        return idEmails;
    }

    public void setIdEmails(int idEmails) {
        this.idEmails = idEmails;
    }

    public RellenarLabels(Icon imagen, int idAppAndPass, String application, String password, int idEmails, int idUser) {
        this.imagen = imagen;
        this.idAppAndPass = idAppAndPass;
        this.application = application;
        this.password = password;
        this.idEmails = idEmails;
        this.idUser = idUser;
        setBackground(new Color(0, 18, 51, 50));
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(true);
        setIcon(imagen);
        this.addActionListener(oyentedeAccion);
    }

    ActionListener oyentedeAccion = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            PreparedStatement ps;
            ResultSet rs;
            String correo = "";
            try {
                Connection conexion = ConexionABD.getConnection();
                ps = conexion.prepareStatement("select emails from EmailsOfUsers where idEmails=" + idEmails);
                rs = ps.executeQuery();
                while (rs.next()) {
                    correo = rs.getString("emails");
                }
                rs.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            //Hago visible todo el panel izquierdo
            VentanaAppsYContra.cajaDeCorreo.setVisible(true);
            VentanaAppsYContra.cajaDeContra.setVisible(true);
            VentanaAppsYContra.cajaDeNombreApp.setVisible(true);
            VentanaAppsYContra.etiContraApp.setVisible(true);
            VentanaAppsYContra.etiCorreoApp.setVisible(true);
            VentanaAppsYContra.etiNombreApp.setVisible(true);

            //Ingreso la informacion del boton presionado
            VentanaAppsYContra.cajaDeCorreo.setText(correo);
            VentanaAppsYContra.cajaDeContra.setText(EncriptarYDesencriptarContra.desencriptar(password, 3));
            VentanaAppsYContra.cajaDeNombreApp.setText(application);

            //Pongo los auxiliares de ids y la imagen
            VentanaAppsYContra.cajaIdEmail.setText(String.valueOf(idEmails));
            VentanaAppsYContra.cajaIdApp.setText(String.valueOf(idAppAndPass));
            VentanaAppsYContra.cajaImagenAux.setIcon(imagen);

            //Hago visibles los botones de eliminar, modificar y agregar
            VentanaAppsYContra.botonEliminarApp.setVisible(true);
            VentanaAppsYContra.botonModificarApp.setVisible(true);
        }
    };
}
