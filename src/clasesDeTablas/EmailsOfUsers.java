package clasesDeTablas;

import controlador.ConexionABD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class EmailsOfUsers {

    private int idEmails;
    private String emails;
    private int idUsers;

    public int getIdEmails() {
        return idEmails;
    }

    public void setIdEmails(int idEmails) {
        this.idEmails = idEmails;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    @Override
    public String toString() {
        return emails;
    }

    public Vector<EmailsOfUsers> mostrarEmails(Integer idUsers) {
        PreparedStatement ps;
        ResultSet rs;
        Vector<EmailsOfUsers> vectorEmails = new Vector<>();
        EmailsOfUsers email = null;
        
        try {
            Connection conexion = ConexionABD.getConnection();
            ps = conexion.prepareStatement("select * from EmailsOfUsers where idUsers=" + idUsers);
            rs = ps.executeQuery();
            email = new EmailsOfUsers();
            email.setIdEmails(0);
            email.setEmails("");
            vectorEmails.add(email);
            while (rs.next()) {
                email = new EmailsOfUsers();
                email.setIdEmails(rs.getInt("idEmails"));
                email.setEmails(rs.getString("emails"));
                email.setIdUsers(rs.getInt("idUsers"));
                vectorEmails.add(email);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error " + ex);
        }
        return vectorEmails;
    }
}
