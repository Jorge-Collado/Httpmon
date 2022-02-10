package psp.combat;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * @author merce
 */
public class ErrorDialog extends javax.swing.JDialog {

    /**
     * Creates new form ErrorDialog
     */
    public ErrorDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            initComponents();
            this.setLocationRelativeTo(null);
            btnOK.setBackground(Color.YELLOW);
            btnOK.setContentAreaFilled(false);
            btnOK.setOpaque(true);
            BufferedImage icon = ImageIO.read(new File("src/psp/assets/frameIcon.png"));
            this.setIconImage(icon);
        } catch (IOException ex) {
            Logger.getLogger(ErrorDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblMessage = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 204));
        jPanel1.setLayout(null);

        lblMessage.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(255, 255, 255));
        lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMessage.setText("<html>\n<head>\n<style>\np {text-align: center;}\n</style>\n</head>\n<body>\n\n<p width = 300>Los movimientos de estado no están implementados, porfavor elige un movimiento de ataque.</p>\n</body></html>");
        jPanel1.add(lblMessage);
        lblMessage.setBounds(6, 6, 311, 147);

        btnOK.setBackground(new java.awt.Color(255, 255, 0));
        btnOK.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnOK.setForeground(new java.awt.Color(0, 0, 0));
        btnOK.setText("OK");
        btnOK.setContentAreaFilled(false);
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        jPanel1.add(btnOK);
        btnOK.setBounds(94, 159, 135, 27);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ErrorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ErrorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ErrorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ErrorDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ErrorDialog dialog = new ErrorDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMessage;
    // End of variables declaration//GEN-END:variables
}
