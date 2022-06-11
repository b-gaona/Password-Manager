package agregarEmailYApp;

import clasesDeTablas.EmailsOfUsers;
import controlador.PlaceHolder;
import javax.swing.DefaultComboBoxModel;
import vista.VentanaPrincipal;

public class EliminarEmail extends javax.swing.JDialog {

    PlaceHolder placeholder;
    
    public EliminarEmail(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        EmailsOfUsers emails = new EmailsOfUsers();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(emails.mostrarEmails(VentanaPrincipal.idUser));
        comboCorreos.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        etiCorreoAEliminar = new javax.swing.JLabel();
        etiTitulo = new javax.swing.JLabel();
        botonEliminarCorreo = new javax.swing.JButton();
        comboCorreos = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(440, 200));
        setPreferredSize(new java.awt.Dimension(440, 200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 53, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(440, 200));
        jPanel1.setPreferredSize(new java.awt.Dimension(440, 200));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiCorreoAEliminar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etiCorreoAEliminar.setForeground(new java.awt.Color(255, 255, 255));
        etiCorreoAEliminar.setText("Correo a a eliminar:");
        jPanel1.add(etiCorreoAEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        etiTitulo.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        etiTitulo.setForeground(new java.awt.Color(255, 214, 10));
        etiTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiTitulo.setText("Eliminar correo");
        jPanel1.add(etiTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 50));

        botonEliminarCorreo.setBackground(new java.awt.Color(255, 214, 10));
        botonEliminarCorreo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        botonEliminarCorreo.setText("Eliminar correo");
        botonEliminarCorreo.setBorderPainted(false);
        botonEliminarCorreo.setFocusPainted(false);
        jPanel1.add(botonEliminarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, 30));

        comboCorreos.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jPanel1.add(comboCorreos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 240, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            EliminarEmail dialog = new EliminarEmail(new javax.swing.JFrame(), true);
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
    public javax.swing.JButton botonEliminarCorreo;
    public javax.swing.JComboBox<String> comboCorreos;
    private javax.swing.JLabel etiCorreoAEliminar;
    private javax.swing.JLabel etiTitulo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
