package agregarEmailYApp;

import controlador.ConexionABD;
import controlador.PlaceHolder;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import vista.VentanaPrincipal;

public class AgregarEmail extends javax.swing.JDialog {

    PlaceHolder placeholder;

    public AgregarEmail(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        placeholder = new PlaceHolder("Type your email", insertarCorreo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        insertarCorreo = new javax.swing.JTextField();
        etiUsuario1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        botonAgregarCorreo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(440, 200));
        setPreferredSize(new java.awt.Dimension(440, 200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 53, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        insertarCorreo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        insertarCorreo.setBorder(BorderFactory.createCompoundBorder(
            insertarCorreo.getBorder(), 
            BorderFactory.createEmptyBorder(2, 8, 2, 5)));
    insertarCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            insertarCorreoKeyReleased(evt);
        }
    });
    jPanel1.add(insertarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 220, 30));

    etiUsuario1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    etiUsuario1.setForeground(new java.awt.Color(255, 255, 255));
    etiUsuario1.setText("Correo a agregar:");
    jPanel1.add(etiUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 214, 10));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Agregar correo");
    jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 50));

    botonAgregarCorreo.setBackground(new java.awt.Color(255, 214, 10));
    botonAgregarCorreo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
    botonAgregarCorreo.setText("Agregar correo");
    botonAgregarCorreo.setBorderPainted(false);
    botonAgregarCorreo.setFocusPainted(false);
    botonAgregarCorreo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botonAgregarCorreoActionPerformed(evt);
        }
    });
    jPanel1.add(botonAgregarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, 30));

    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 450));

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarEmail() {
        try {
            PreparedStatement ps;
            ResultSet rs;
            Connection conexion = ConexionABD.getConnection();
            boolean bandera = false;

            ps = conexion.prepareStatement("select emails from EmailsOfUsers where idUsers="+VentanaPrincipal.idUser);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (insertarCorreo.getText().equals(rs.getString("emails"))) {
                    bandera = true;
                }
            }
            if (bandera) { //Si ya existe, no hacemos la insercion.Sino que solo indicamos que ese codigo ya existe.
                JOptionPane.showMessageDialog(null, "Ese nombre de usuario o correo ya está registrado");
                insertarCorreo.setText("");
            } else {
                ps = conexion.prepareStatement("insert into EmailsOfUsers (emails, idUsers) values (?, ?)");
                ps.setString(1, insertarCorreo.getText());
                ps.setInt(2, VentanaPrincipal.idUser);
                ps.executeUpdate();
                insertarCorreo.setText("");
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void insertarCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_insertarCorreoKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            agregarEmail();
        }
    }//GEN-LAST:event_insertarCorreoKeyReleased

    private void botonAgregarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarCorreoActionPerformed
        if (insertarCorreo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Rellene el campo con el correo que desea agregar");
        } else {
            agregarEmail();
        }
    }//GEN-LAST:event_botonAgregarCorreoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            AgregarEmail dialog = new AgregarEmail(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botonAgregarCorreo;
    private javax.swing.JLabel etiUsuario1;
    private javax.swing.JTextField insertarCorreo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
