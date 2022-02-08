/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package psp.combat;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import psp.models.pokemon.Pokemon;

/**
 *
 * @author Georgeus
 */
public class CombatForm extends javax.swing.JFrame {

    private List<CombatPokemon> equipoPJ;
    private List<CombatPokemon> equipoCOM;
    private int pokemonActual = 0;
    private CombatPokemon pokemonAliado;
    private CombatPokemon pokemonRival;

    public CombatPokemon getPokemonAliado() {
        return pokemonAliado;
    }

    public void setPokemonAliado(CombatPokemon pokemonAliado) {
        this.pokemonAliado = pokemonAliado;
    }

    public CombatPokemon getPokemonRival() {
        return pokemonRival;
    }

    public void setPokemonRival(CombatPokemon pokemonRival) {
        this.pokemonRival = pokemonRival;
    }

    public void setEquipoPJ(List<CombatPokemon> equipoPJ) {
        this.equipoPJ = equipoPJ;
    }

    public void setEquipoCOM(List<CombatPokemon> equipoCOM) {
        this.equipoCOM = equipoCOM;
    }

    /**
     * Creates new form CombatForm
     */
    public CombatForm(List<CombatPokemon> equipoPJ, List<CombatPokemon> equipoCOM) {
        initComponents();
        this.equipoPJ = equipoPJ;
        this.equipoCOM = equipoCOM;
        iniciarCombate(pokemonActual);
    }

    private void iniciarCombate(int pokemonActual) {
        lblPokemonAliado.setIcon(resizeImageIcon(equipoPJ.get(pokemonActual).getBackSprite(), 96));
        lblPokemonRival.setIcon(resizeImageIcon(equipoCOM.get(pokemonActual).getFrontSprite(), 96));
        
        setPokemonAliado(equipoPJ.get(pokemonActual));
        setPokemonRival(equipoCOM.get(pokemonActual));
        
        btnMove1.setText(equipoPJ.get(pokemonActual).getMoves().get(0).getName());
        btnMove2.setText(equipoPJ.get(pokemonActual).getMoves().get(1).getName());
        btnMove3.setText(equipoPJ.get(pokemonActual).getMoves().get(2).getName());
        btnMove4.setText(equipoPJ.get(pokemonActual).getMoves().get(3).getName());
        
        lblPokemon1.setIcon(resizeImageIcon(equipoPJ.get(0).getFrontSprite(), 64));
        lblPokemon2.setIcon(resizeImageIcon(equipoPJ.get(1).getFrontSprite(), 64));
        lblPokemon3.setIcon(resizeImageIcon(equipoPJ.get(2).getFrontSprite(), 64));
        lblPokemon4.setIcon(resizeImageIcon(equipoPJ.get(3).getFrontSprite(), 64));
        lblPokemon5.setIcon(resizeImageIcon(equipoPJ.get(4).getFrontSprite(), 64));
        lblPokemon6.setIcon(resizeImageIcon(equipoPJ.get(5).getFrontSprite(), 64));
        
        pokemonAliado.setActualHp(pokemonAliado.getMaxHp());
        pokemonRival.setActualHp(pokemonRival.getMaxHp());
        
        lblVidaPokemonPJ.setText(pokemonAliado.getActualHp() + "/" + pokemonAliado.getMaxHp());
        lblVidaPokemonCOM.setText(pokemonRival.getActualHp() + "/" + pokemonRival.getMaxHp());
    }

    private ImageIcon resizeImageIcon(BufferedImage originalImage, int size) {
        int desiredHeight = 0;
        int desiredWidth = 0;
        float aspectRatio = (float) originalImage.getWidth() / originalImage.getHeight();
        if (originalImage.getWidth() < originalImage.getHeight()) {
            desiredWidth = Math.round(size * aspectRatio);
            desiredHeight = size;
        } else {
            desiredHeight = Math.round(size / aspectRatio);
            desiredWidth = size;
        }

        Image resultingImage = originalImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        BufferedImage outputImage = new BufferedImage(desiredWidth, desiredHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);

        ImageIcon icon = new ImageIcon(outputImage);
        return icon;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPokemonRival = new javax.swing.JLabel();
        lblPokemonAliado = new javax.swing.JLabel();
        lblPokemon4 = new javax.swing.JLabel();
        lblPokemon1 = new javax.swing.JLabel();
        lblPokemon2 = new javax.swing.JLabel();
        lblPokemon6 = new javax.swing.JLabel();
        lblPokemon3 = new javax.swing.JLabel();
        lblPokemon5 = new javax.swing.JLabel();
        btnMove1 = new javax.swing.JButton();
        btnMove2 = new javax.swing.JButton();
        btnMove3 = new javax.swing.JButton();
        btnMove4 = new javax.swing.JButton();
        lblVidaPokemonPJ = new javax.swing.JLabel();
        lblVidaPokemonCOM = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblPokemon4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPokemon4MouseClicked(evt);
            }
        });

        lblPokemon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPokemon1MouseClicked(evt);
            }
        });

        lblPokemon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPokemon2MouseClicked(evt);
            }
        });

        lblPokemon6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPokemon6MouseClicked(evt);
            }
        });

        lblPokemon3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPokemon3MouseClicked(evt);
            }
        });

        lblPokemon5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPokemon5MouseClicked(evt);
            }
        });

        btnMove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMove1ActionPerformed(evt);
            }
        });

        btnMove2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMove2ActionPerformed(evt);
            }
        });

        btnMove3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMove3ActionPerformed(evt);
            }
        });

        btnMove4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMove4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblVidaPokemonCOM, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPokemonRival, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(lblPokemonAliado, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblVidaPokemonPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPokemon1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPokemon4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPokemon2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPokemon5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPokemon3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPokemon6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMove1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMove2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMove3, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(btnMove4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVidaPokemonCOM, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPokemonRival, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(lblPokemonAliado, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblVidaPokemonPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPokemon1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPokemon2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPokemon3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(btnMove3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(11, 11, 11)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPokemon4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPokemon6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPokemon5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMove2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMove4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnMove1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMove1ActionPerformed
        calcularDmgRival();
    }//GEN-LAST:event_btnMove1ActionPerformed

    private void btnMove3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMove3ActionPerformed
        calcularDmgRival();
    }//GEN-LAST:event_btnMove3ActionPerformed

    private void btnMove2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMove2ActionPerformed
        calcularDmgRival();
    }//GEN-LAST:event_btnMove2ActionPerformed

    private void btnMove4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMove4ActionPerformed
        calcularDmgRival();
    }//GEN-LAST:event_btnMove4ActionPerformed

    private void lblPokemon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokemon1MouseClicked
        if (equipoPJ.get(0).getActualHp() > 0)
            cambioAliado(0, evt);
    }//GEN-LAST:event_lblPokemon1MouseClicked

    private void lblPokemon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokemon2MouseClicked
        if (equipoPJ.get(1).getActualHp() > 0)
            cambioAliado(1, evt);
    }//GEN-LAST:event_lblPokemon2MouseClicked

    private void lblPokemon3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokemon3MouseClicked
        if (equipoPJ.get(2).getActualHp() > 0)
            cambioAliado(2, evt);
    }//GEN-LAST:event_lblPokemon3MouseClicked

    private void lblPokemon4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokemon4MouseClicked
        if (equipoPJ.get(3).getActualHp() > 0)
            cambioAliado(3, evt);
    }//GEN-LAST:event_lblPokemon4MouseClicked

    private void lblPokemon5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokemon5MouseClicked
        if (equipoPJ.get(4).getActualHp() > 0)
            cambioAliado(4, evt);
    }//GEN-LAST:event_lblPokemon5MouseClicked

    private void lblPokemon6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokemon6MouseClicked
        if (equipoPJ.get(5).getActualHp() > 0)
            cambioAliado(5, evt);
    }//GEN-LAST:event_lblPokemon6MouseClicked

    private void cambioAliado(int index, MouseEvent evt) {
        if (evt.getSource() instanceof JLabel) {
            JLabel label = (JLabel) evt.getSource();
            lblPokemonAliado.setIcon(resizeImageIcon(equipoPJ.get(index).getBackSprite(), 96));
            setPokemonAliado(equipoPJ.get(index));
            btnMove1.setText(equipoPJ.get(index).getMoves().get(0).getName());
            btnMove2.setText(equipoPJ.get(index).getMoves().get(1).getName());
            btnMove3.setText(equipoPJ.get(index).getMoves().get(2).getName());
            btnMove4.setText(equipoPJ.get(index).getMoves().get(3).getName());
        }
    }

    private void calcularDmgRival() {
        if (pokemonAliado.getAtk() > pokemonRival.getDef()) {
            pokemonRival.setActualHp(pokemonRival.getActualHp() - (pokemonAliado.getAtk() - pokemonRival.getDef()));
            if (rivalFainted()) {
                cambiarPokemonRival();
            } else {
                movimientoRival();
            }
        } else {
            pokemonRival.setActualHp(pokemonRival.getActualHp() - 1);
            if (rivalFainted()) {
                cambiarPokemonRival();
            } else {
                movimientoRival();
            }
        }

        lblVidaPokemonPJ.setText(pokemonAliado.getActualHp() + "/" + pokemonAliado.getMaxHp());
        lblVidaPokemonCOM.setText(pokemonRival.getActualHp() + "/" + pokemonRival.getMaxHp());

    }

    private boolean rivalFainted() {
        if (pokemonRival.getActualHp() <= 0) {
            return true;
        }

        return false;
    }

    private void cambiarPokemonRival() {
        if (pokemonActual < equipoCOM.size()) {
            pokemonActual += 1;
            setPokemonRival(equipoCOM.get(pokemonActual));
            lblPokemonRival.setIcon(resizeImageIcon(pokemonRival.getFrontSprite(), 96));
            pokemonRival.setActualHp(pokemonRival.getMaxHp());
            lblVidaPokemonCOM.setText(pokemonRival.getActualHp() + "/" + pokemonRival.getMaxHp());
        }
    }

    private void movimientoRival() {
        if (pokemonRival.getAtk() > pokemonAliado.getDef()) {
            pokemonAliado.setActualHp(pokemonAliado.getActualHp() - (pokemonRival.getAtk() - pokemonAliado.getDef()));
            if (aliadoFainted()) {
                aliadoDebilitado();
            }
        } else {
            pokemonAliado.setActualHp(pokemonAliado.getActualHp() - 1);
            if (aliadoFainted()) {
                cambiarPokemonRival();
            }
        }

        lblVidaPokemonPJ.setText(pokemonAliado.getActualHp() + "/" + pokemonAliado.getMaxHp());
        lblVidaPokemonCOM.setText(pokemonRival.getActualHp() + "/" + pokemonRival.getMaxHp());

    }

    private boolean aliadoFainted() {
        if (pokemonAliado.getActualHp() <= 0) {
            return true;
        }

        return false;
    }

    private void aliadoDebilitado() {
        try {
            BufferedImage img = ImageIO.read(new File("src/psp/assets/lavender_ghost.png"));
            lblPokemonAliado.setIcon(resizeImageIcon(img, 96));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        btnMove1.setEnabled(false);
        btnMove2.setEnabled(false);
        btnMove3.setEnabled(false);
        btnMove4.setEnabled(false);
    }

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
            java.util.logging.Logger.getLogger(CombatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CombatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CombatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CombatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMove1;
    private javax.swing.JButton btnMove2;
    private javax.swing.JButton btnMove3;
    private javax.swing.JButton btnMove4;
    private javax.swing.JLabel lblPokemon1;
    private javax.swing.JLabel lblPokemon2;
    private javax.swing.JLabel lblPokemon3;
    private javax.swing.JLabel lblPokemon4;
    private javax.swing.JLabel lblPokemon5;
    private javax.swing.JLabel lblPokemon6;
    private javax.swing.JLabel lblPokemonAliado;
    private javax.swing.JLabel lblPokemonRival;
    private javax.swing.JLabel lblVidaPokemonCOM;
    private javax.swing.JLabel lblVidaPokemonPJ;
    // End of variables declaration//GEN-END:variables
}
