package psp.combat;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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

    public CombatForm(List<CombatPokemon> equipoPJ, List<CombatPokemon> equipoCOM) {
        try {
            initComponents();
            this.equipoPJ = equipoPJ;
            this.equipoCOM = equipoCOM;
            
            lblVidaPokemonPJ.setForeground(new Color(0, 153, 0));
            lblVidaPokemonCOM.setForeground(new Color(0, 153, 0));
            
            iniciarCombate(pokemonActual);
            this.setLocationRelativeTo(null);
            this.setTitle("TU PADRE DESPUÉS DE PERDER EL MADRID");
            BufferedImage icon = ImageIO.read(new File("src/psp/assets/frameIcon.png"));
            this.setIconImage(icon);
        } catch (IOException ex) {
            Logger.getLogger(CombatForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void iniciarCombate(int pokemonActual) {
        lblPokemonAliado.setIcon(resizeImageIcon(equipoPJ.get(pokemonActual).getBackSprite(), 96));
        lblPokemonRival.setIcon(resizeImageIcon(equipoCOM.get(pokemonActual).getFrontSprite(), 96));

        setPokemonAliado(equipoPJ.get(pokemonActual));
        setPokemonRival(equipoCOM.get(pokemonActual));

        btnMove1.setText(equipoPJ.get(pokemonActual).getMoves().get(0).getName().toUpperCase());
        btnMove2.setText(equipoPJ.get(pokemonActual).getMoves().get(1).getName().toUpperCase());
        btnMove3.setText(equipoPJ.get(pokemonActual).getMoves().get(2).getName().toUpperCase());
        btnMove4.setText(equipoPJ.get(pokemonActual).getMoves().get(3).getName().toUpperCase());

        lblPokemon1.setIcon(resizeImageIcon(equipoPJ.get(0).getFrontSprite(), 64));
        lblPokemon2.setIcon(resizeImageIcon(equipoPJ.get(1).getFrontSprite(), 64));
        lblPokemon3.setIcon(resizeImageIcon(equipoPJ.get(2).getFrontSprite(), 64));
        lblPokemon4.setIcon(resizeImageIcon(equipoPJ.get(3).getFrontSprite(), 64));
        lblPokemon5.setIcon(resizeImageIcon(equipoPJ.get(4).getFrontSprite(), 64));
        lblPokemon6.setIcon(resizeImageIcon(equipoPJ.get(5).getFrontSprite(), 64));

        pokemonAliado.setActualHp(pokemonAliado.getMaxHp());

        equipoPJ.get(1).setActualHp(equipoPJ.get(1).getMaxHp());
        equipoPJ.get(2).setActualHp(equipoPJ.get(2).getMaxHp());
        equipoPJ.get(3).setActualHp(equipoPJ.get(3).getMaxHp());
        equipoPJ.get(4).setActualHp(equipoPJ.get(4).getMaxHp());
        equipoPJ.get(5).setActualHp(equipoPJ.get(5).getMaxHp());

        setPokemonRival(equipoCOM.get(pokemonActual));
        lblPokemonRival.setIcon(resizeImageIcon(equipoCOM.get(pokemonActual).getFrontSprite(), 96));
        pokemonRival.setActualHp(pokemonRival.getMaxHp());

        lblVidaPokemonPJ.setText(pokemonAliado.getActualHp() + " / " + pokemonAliado.getMaxHp());
        lblVidaPokemonCOM.setText(pokemonRival.getActualHp() + " / " + pokemonRival.getMaxHp());
    }

    private void cambiarPokemon(int index) {
        setPokemonAliado(equipoPJ.get(index));
        lblPokemonAliado.setIcon(resizeImageIcon(pokemonAliado.getBackSprite(), 96));
        btnMove1.setText(pokemonAliado.getMoves().get(0).getName().toUpperCase());
        btnMove2.setText(pokemonAliado.getMoves().get(1).getName().toUpperCase());
        btnMove3.setText(pokemonAliado.getMoves().get(2).getName().toUpperCase());
        btnMove4.setText(pokemonAliado.getMoves().get(3).getName().toUpperCase());

        if (pokemonAliado.getActualHp() > (pokemonAliado.getMaxHp() / 2)) {
            lblVidaPokemonPJ.setForeground(new Color(0, 153, 0));
        }
        if (pokemonAliado.getActualHp() < (pokemonAliado.getMaxHp() / 2)) {
            lblVidaPokemonPJ.setForeground(new Color(230, 86, 14));
        }
        if (pokemonAliado.getActualHp() < (pokemonAliado.getMaxHp() / 4)) {
            lblVidaPokemonPJ.setForeground(Color.RED);
        }
        lblVidaPokemonPJ.setText(pokemonAliado.getActualHp() + "/" + pokemonAliado.getMaxHp());
    }

    private ImageIcon resizeImageIcon(ImageIcon icon, int size) {
        Image image = icon.getImage();  
        Image newimg = image.getScaledInstance(size, size, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        return icon;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblPokemonRival = new javax.swing.JLabel();
        lblPokemonAliado = new javax.swing.JLabel();
        lblVidaPokemonPJ = new javax.swing.JLabel();
        lblVidaPokemonCOM = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblPokemon3 = new javax.swing.JLabel();
        lblPokemon1 = new javax.swing.JLabel();
        lblPokemon2 = new javax.swing.JLabel();
        lblPokemon6 = new javax.swing.JLabel();
        lblPokemon5 = new javax.swing.JLabel();
        lblPokemon4 = new javax.swing.JLabel();
        btnMove2 = new javax.swing.JButton();
        btnMove4 = new javax.swing.JButton();
        btnMove1 = new javax.swing.JButton();
        btnMove3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 310));

        jPanel1.setBackground(new java.awt.Color(102, 0, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(621, 456));
        jPanel1.setLayout(null);

        lblPokemonRival.setForeground(new java.awt.Color(0, 0, 0));
        lblPokemonRival.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblPokemonRival);
        lblPokemonRival.setBounds(370, 90, 96, 96);

        lblPokemonAliado.setForeground(new java.awt.Color(0, 0, 0));
        lblPokemonAliado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblPokemonAliado);
        lblPokemonAliado.setBounds(140, 180, 96, 96);

        lblVidaPokemonPJ.setBackground(new java.awt.Color(204, 204, 204));
        lblVidaPokemonPJ.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lblVidaPokemonPJ.setForeground(new java.awt.Color(0, 0, 0));
        lblVidaPokemonPJ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVidaPokemonPJ.setText("asdfasdfasdf");
        lblVidaPokemonPJ.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblVidaPokemonPJ.setOpaque(true);
        jPanel1.add(lblVidaPokemonPJ);
        lblVidaPokemonPJ.setBounds(43, 136, 90, 30);

        lblVidaPokemonCOM.setBackground(new java.awt.Color(204, 204, 204));
        lblVidaPokemonCOM.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lblVidaPokemonCOM.setForeground(new java.awt.Color(0, 0, 0));
        lblVidaPokemonCOM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVidaPokemonCOM.setText("asdfasdfasdf");
        lblVidaPokemonCOM.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblVidaPokemonCOM.setOpaque(true);
        jPanel1.add(lblVidaPokemonCOM);
        lblVidaPokemonCOM.setBounds(470, 70, 90, 30);

        jPanel2.setBackground(new java.awt.Color(153, 0, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        lblPokemon3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lblPokemon3.setForeground(new java.awt.Color(0, 0, 0));
        lblPokemon3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPokemon3MouseClicked(evt);
            }
        });
        jPanel2.add(lblPokemon3);
        lblPokemon3.setBounds(190, 10, 64, 64);

        lblPokemon1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lblPokemon1.setForeground(new java.awt.Color(0, 0, 0));
        lblPokemon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPokemon1MouseClicked(evt);
            }
        });
        jPanel2.add(lblPokemon1);
        lblPokemon1.setBounds(10, 10, 64, 64);

        lblPokemon2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lblPokemon2.setForeground(new java.awt.Color(0, 0, 0));
        lblPokemon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPokemon2MouseClicked(evt);
            }
        });
        jPanel2.add(lblPokemon2);
        lblPokemon2.setBounds(100, 10, 64, 64);

        lblPokemon6.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lblPokemon6.setForeground(new java.awt.Color(0, 0, 0));
        lblPokemon6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPokemon6MouseClicked(evt);
            }
        });
        jPanel2.add(lblPokemon6);
        lblPokemon6.setBounds(190, 80, 64, 64);

        lblPokemon5.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lblPokemon5.setForeground(new java.awt.Color(0, 0, 0));
        lblPokemon5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPokemon5MouseClicked(evt);
            }
        });
        jPanel2.add(lblPokemon5);
        lblPokemon5.setBounds(100, 80, 64, 64);

        lblPokemon4.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lblPokemon4.setForeground(new java.awt.Color(0, 0, 0));
        lblPokemon4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPokemon4MouseClicked(evt);
            }
        });
        jPanel2.add(lblPokemon4);
        lblPokemon4.setBounds(10, 80, 64, 64);

        btnMove2.setBackground(new java.awt.Color(255, 255, 51));
        btnMove2.setFont(new java.awt.Font("Segoe UI Black", 3, 12)); // NOI18N
        btnMove2.setForeground(new java.awt.Color(0, 0, 0));
        btnMove2.setText("THUNDER-PUNCH");
        btnMove2.setContentAreaFilled(false);
        btnMove2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMove2.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnMove2.setOpaque(true);
        btnMove2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMove2ActionPerformed(evt);
            }
        });
        jPanel2.add(btnMove2);
        btnMove2.setBounds(290, 90, 140, 50);

        btnMove4.setBackground(new java.awt.Color(255, 255, 51));
        btnMove4.setFont(new java.awt.Font("Segoe UI Black", 3, 12)); // NOI18N
        btnMove4.setForeground(new java.awt.Color(0, 0, 0));
        btnMove4.setText("THUNDER-PUNCH");
        btnMove4.setContentAreaFilled(false);
        btnMove4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMove4.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnMove4.setOpaque(true);
        btnMove4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMove4ActionPerformed(evt);
            }
        });
        jPanel2.add(btnMove4);
        btnMove4.setBounds(450, 90, 140, 50);

        btnMove1.setBackground(new java.awt.Color(255, 255, 51));
        btnMove1.setFont(new java.awt.Font("Segoe UI Black", 3, 12)); // NOI18N
        btnMove1.setForeground(new java.awt.Color(0, 0, 0));
        btnMove1.setText("THUNDER-PUNCH");
        btnMove1.setContentAreaFilled(false);
        btnMove1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMove1.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnMove1.setOpaque(true);
        btnMove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMove1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnMove1);
        btnMove1.setBounds(290, 20, 140, 50);

        btnMove3.setBackground(new java.awt.Color(255, 255, 51));
        btnMove3.setFont(new java.awt.Font("Segoe UI Black", 3, 12)); // NOI18N
        btnMove3.setForeground(new java.awt.Color(0, 0, 0));
        btnMove3.setText("THUNDER-PUNCH");
        btnMove3.setContentAreaFilled(false);
        btnMove3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMove3.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnMove3.setOpaque(true);
        btnMove3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMove3ActionPerformed(evt);
            }
        });
        jPanel2.add(btnMove3);
        btnMove3.setBounds(450, 20, 140, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball.jpg"))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(100, 80, 64, 64);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball.jpg"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 80, 64, 64);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball.jpg"))); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 10, 64, 64);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball.jpg"))); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(100, 10, 64, 64);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball.jpg"))); // NOI18N
        jPanel2.add(jLabel6);
        jLabel6.setBounds(190, 10, 64, 64);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball.jpg"))); // NOI18N
        jPanel2.add(jLabel7);
        jLabel7.setBounds(190, 80, 64, 64);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 320, 610, 160);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/scenary1.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 10, 650, 290);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
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
        if (equipoPJ.get(0).getActualHp() > 0) {
            cambiarPokemon(0);
            btnMove1.setEnabled(true);
            btnMove2.setEnabled(true);
            btnMove3.setEnabled(true);
            btnMove4.setEnabled(true);
        }
    }//GEN-LAST:event_lblPokemon1MouseClicked

    private void lblPokemon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokemon2MouseClicked
        if (equipoPJ.get(1).getActualHp() > 0) {
            cambiarPokemon(1);
            btnMove1.setEnabled(true);
            btnMove2.setEnabled(true);
            btnMove3.setEnabled(true);
            btnMove4.setEnabled(true);
        }
    }//GEN-LAST:event_lblPokemon2MouseClicked

    private void lblPokemon3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokemon3MouseClicked
        if (equipoPJ.get(2).getActualHp() > 0) {
            cambiarPokemon(2);
            btnMove1.setEnabled(true);
            btnMove2.setEnabled(true);
            btnMove3.setEnabled(true);
            btnMove4.setEnabled(true);
        }
    }//GEN-LAST:event_lblPokemon3MouseClicked

    private void lblPokemon4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokemon4MouseClicked
        if (equipoPJ.get(3).getActualHp() > 0) {
            cambiarPokemon(3);
            btnMove1.setEnabled(true);
            btnMove2.setEnabled(true);
            btnMove3.setEnabled(true);
            btnMove4.setEnabled(true);
        }
    }//GEN-LAST:event_lblPokemon4MouseClicked

    private void lblPokemon5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokemon5MouseClicked
        if (equipoPJ.get(4).getActualHp() > 0) {
            cambiarPokemon(4);
            btnMove1.setEnabled(true);
            btnMove2.setEnabled(true);
            btnMove3.setEnabled(true);
            btnMove4.setEnabled(true);
        }
    }//GEN-LAST:event_lblPokemon5MouseClicked

    private void lblPokemon6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokemon6MouseClicked
        if (equipoPJ.get(5).getActualHp() > 0) {
            cambiarPokemon(5);
            btnMove1.setEnabled(true);
            btnMove2.setEnabled(true);
            btnMove3.setEnabled(true);
            btnMove4.setEnabled(true);
        }
    }//GEN-LAST:event_lblPokemon6MouseClicked

    private void calcularDmgRival() {
        if (pokemonAliado.getAtk() > pokemonRival.getDef()) {
            pokemonRival.setActualHp(pokemonRival.getActualHp() - ((pokemonAliado.getAtk() + 20) - pokemonRival.getDef()));
            if (rivalFainted()) {
                cambiarPokemonRival();
            } else {
                movimientoRival();
            }
        } else {
            pokemonRival.setActualHp(pokemonRival.getActualHp() - 10);
            if (rivalFainted()) {
                cambiarPokemonRival();
            } else {
                movimientoRival();
            }
        }

        if (pokemonRival.getActualHp() > (pokemonRival.getMaxHp() / 2)) {
            lblVidaPokemonCOM.setForeground(new Color(0, 153, 0));
        }
        if (pokemonRival.getActualHp() < (pokemonRival.getMaxHp() / 2)) {
            lblVidaPokemonCOM.setForeground(new Color(230, 86, 14));
        }
        if (pokemonRival.getActualHp() < (pokemonRival.getMaxHp() / 4)) {
            lblVidaPokemonCOM.setForeground(Color.RED);
        }
        lblVidaPokemonCOM.setText(pokemonRival.getActualHp() + " / " + pokemonRival.getMaxHp());
    }

    private boolean rivalFainted() {
        if (pokemonRival.getActualHp() < 1) {
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
            if (pokemonRival.getActualHp() > (pokemonRival.getMaxHp() / 2)) {
                lblVidaPokemonCOM.setForeground(new Color(0, 153, 0));
            }
            if (pokemonRival.getActualHp() < (pokemonRival.getMaxHp() / 2)) {
                lblVidaPokemonCOM.setForeground(new Color(230, 86, 14));
            }
            if (pokemonRival.getActualHp() < (pokemonRival.getMaxHp() / 4)) {
                lblVidaPokemonCOM.setForeground(Color.RED);
            }
            lblVidaPokemonCOM.setText(pokemonRival.getActualHp() + " / " + pokemonRival.getMaxHp());
        } else {
            dispose();
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

        if (pokemonAliado.getActualHp() > (pokemonAliado.getMaxHp() / 2)) {
            lblVidaPokemonPJ.setForeground(new Color(0, 153, 0));
        }
        if (pokemonAliado.getActualHp() < (pokemonAliado.getMaxHp() / 2)) {
            lblVidaPokemonPJ.setForeground(new Color(230, 86, 14));
        }
        if (pokemonAliado.getActualHp() < (pokemonAliado.getMaxHp() / 4)) {
            lblVidaPokemonPJ.setForeground(Color.RED);
        }
        lblVidaPokemonPJ.setText(pokemonAliado.getActualHp() + " / " + pokemonAliado.getMaxHp());
    }

    private boolean aliadoFainted() {
        if (pokemonAliado.getActualHp() < 1) {
            return true;
        }

        return false;
    }

    private void aliadoDebilitado() {

        ImageIcon img = new ImageIcon("src/psp/assets/fantasmaPocho.png");
        lblPokemonAliado.setIcon(resizeImageIcon(img, 96));

        btnMove1.setEnabled(false);
        btnMove2.setEnabled(false);
        btnMove3.setEnabled(false);
        btnMove4.setEnabled(false);
    }

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
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMove1;
    private javax.swing.JButton btnMove2;
    private javax.swing.JButton btnMove3;
    private javax.swing.JButton btnMove4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
