package clasesDeTablas;

import controlador.ConexionABD;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

public class AppsAndPaswords {

    private int idAppAndPass;
    private String application;
    private String password;
    private int idEmails;
    private InputStream image;
    private int idUser;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return application;
    }

    public Vector<AppsAndPaswords> mostrarAppsAndPasswords(int idUser) {
        PreparedStatement ps;
        ResultSet rs;
        Vector<AppsAndPaswords> vectorApps = new Vector<>();
        AppsAndPaswords app = null;

        try {
            Connection conexion = ConexionABD.getConnection();
            ps = conexion.prepareStatement("select * from AppAndPasswords where idUser=" + idUser);
            rs = ps.executeQuery();
            app = new AppsAndPaswords();
            app.setIdAppAndPass(0);
            app.setApplication("");
            app.setIdUser(0);
            vectorApps.add(app);
            while (rs.next()) {
                app = new AppsAndPaswords();
                app.setIdAppAndPass(rs.getInt("idAppAndPass"));
                app.setApplication(rs.getString("application"));
                app.setPassword(rs.getString("password"));
                app.setIdEmails(rs.getInt("idEmails"));
                app.setImage(rs.getBinaryStream("image"));
                app.setIdUser(rs.getInt("idUser"));
                vectorApps.add(app);
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return vectorApps;
    }
}
