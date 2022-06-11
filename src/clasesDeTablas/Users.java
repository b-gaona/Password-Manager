package clasesDeTablas;

import controlador.ConexionABD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Users {

    private int idUsers;
    private String email;
    private String username;
    private String password;

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return username;
    }

    public Vector<Users> mostrarFA() {
        PreparedStatement ps;
        ResultSet rs;
        Vector<Users> vectorUsers = new Vector<>();
        Users user = null;

        try {
            Connection conexion = ConexionABD.getConnection();
            ps = conexion.prepareStatement("select * from Users");
            rs = ps.executeQuery();
            user = new Users();
            user.setUsername("");
            vectorUsers.add(user);
            user.setIdUsers(0);
            while (rs.next()) {
                user = new Users();
                user.setIdUsers(rs.getInt("idUsers"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                vectorUsers.add(user);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error " + ex);
        }
        return vectorUsers;
    }
}
