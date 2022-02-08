package psp.combat;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import psp.controllers.Converter;
import psp.controllers.ConverterList;
import psp.controllers.ConverterMoves;
import psp.models.list.PokemonList;
import psp.models.moves.Moves;
import psp.models.pokemon.Pokemon;
import psp.models.pokemon.PokemonMove;
import psp.models.pokemon.PokemonType;
import psp.models.pokemon.Stat;

/**
 * @author Georgeus
 */
public class ChooseMoveDialog extends javax.swing.JFrame {

    private ArrayList<Pokemon> equipoPJ;
    private int selectedPokemon = 0;
    private List<Moves> movesFirst;
    private List<Moves> movesSecond;
    private List<Moves> movesThird;
    private List<Moves> movesFourth;
    private List<Moves> movesFifth;
    private List<Moves> movesSixth;
    private List<CombatPokemon> combatTeamPJ;
    private List<CombatPokemon> combatTeamCOM;

    public void setEquipoPJ(ArrayList<Pokemon> equipoPJ) {
        this.equipoPJ = equipoPJ;
    }

    public ArrayList<Pokemon> getEquipoPJ() {
        return equipoPJ;
    }

    /**
     * Creates new form ChooseMoveDialog
     */
    public ChooseMoveDialog(ArrayList<Pokemon> equipoPJ) {
        initComponents();
        this.equipoPJ = equipoPJ;
        displayPokemon(selectedPokemon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPoke = new javax.swing.JLabel();
        lblNext = new javax.swing.JLabel();
        lblBehind = new javax.swing.JLabel();
        btnHecho = new javax.swing.JButton();
        cmbMove1 = new javax.swing.JComboBox<>();
        cmbMove2 = new javax.swing.JComboBox<>();
        cmbMove4 = new javax.swing.JComboBox<>();
        cmbMove3 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNext.setText(">");
        lblNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNextMouseClicked(evt);
            }
        });

        lblBehind.setText("<");
        lblBehind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBehindMouseClicked(evt);
            }
        });

        btnHecho.setText("Hecho");
        btnHecho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHechoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblBehind)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPoke, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNext)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(btnHecho, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbMove1, 0, 130, Short.MAX_VALUE)
                            .addComponent(cmbMove3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbMove4, 0, 130, Short.MAX_VALUE)
                            .addComponent(cmbMove2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblPoke, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lblBehind, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNext, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbMove1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbMove2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbMove4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbMove3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(57, 57, 57)
                .addComponent(btnHecho)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private List<Moves> addMoves() {
        List<Moves> movimientos = new ArrayList();
         Moves moveFinal = new Moves();
//        movimientos.add((Moves) cmbMove1.getSelectedItem());
//        movimientos.add((Moves) cmbMove2.getSelectedItem());
//        movimientos.add((Moves) cmbMove3.getSelectedItem());
//        movimientos.add((Moves) cmbMove4.getSelectedItem());
//        return movimientos;

        PokemonMove pk1 = (PokemonMove) cmbMove1.getSelectedItem();
        PokemonMove pk2 = (PokemonMove) cmbMove2.getSelectedItem();
        PokemonMove pk3 = (PokemonMove) cmbMove3.getSelectedItem();
        PokemonMove pk4 = (PokemonMove) cmbMove4.getSelectedItem();
        
        List<PokemonMove> movesFinal = new ArrayList();
        movesFinal.add(pk1);
        movesFinal.add(pk2);
        movesFinal.add(pk3);
        movesFinal.add(pk4);
        
        try {
            for (PokemonMove move : movesFinal) {
                CloseableHttpClient httpClient = HttpClients.createDefault();

                HttpGet request = new HttpGet(move.getMove().getUrl());

                CloseableHttpResponse response = httpClient.execute(request);
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);
                Object data = ConverterMoves.fromJsonString(result, moveFinal);
                moveFinal = (Moves) data;
                if (!moveFinal.getDamageClass().getName().equals("status")) {
                    movimientos.add(moveFinal);
                }
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return movimientos;
        
    }

    private void lblNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextMouseClicked
        switch (selectedPokemon) {
            case 0 -> {
                movesFirst = addMoves();
                selectedPokemon += 1;
                displayPokemon(selectedPokemon);
            }
            case 1 -> {
                movesSecond = new ArrayList();
                movesSecond = addMoves();
                selectedPokemon += 1;
                displayPokemon(selectedPokemon);
            }
            case 2 -> {
                movesThird = new ArrayList();
                movesThird = addMoves();
                selectedPokemon += 1;
                displayPokemon(selectedPokemon);
            }
            case 3 -> {
                movesFourth = new ArrayList();
                movesFourth = addMoves();
                selectedPokemon += 1;
                displayPokemon(selectedPokemon);
            }
            case 4 -> {
                movesFifth = new ArrayList();
                movesFifth = addMoves();
                selectedPokemon += 1;
                displayPokemon(selectedPokemon);
            }
            case 5 -> {
                movesSixth = new ArrayList();
                movesSixth = addMoves();
                selectedPokemon = 0;
                displayPokemon(selectedPokemon);
            }
        }

    }//GEN-LAST:event_lblNextMouseClicked

    private void lblBehindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBehindMouseClicked
        switch (selectedPokemon) {
            case 0 -> {
                movesFirst = new ArrayList();
                movesFirst = addMoves();
                selectedPokemon = 5;
                displayPokemon(selectedPokemon);
            }
            case 1 -> {
                movesSecond = new ArrayList();
                movesSecond = addMoves();
                selectedPokemon -= 1;
                displayPokemon(selectedPokemon);
            }
            case 2 -> {
                movesThird = new ArrayList();
                movesThird = addMoves();
                selectedPokemon -= 1;
                displayPokemon(selectedPokemon);
            }
            case 3 -> {
                movesFourth = new ArrayList();
                movesFourth = addMoves();
                selectedPokemon -= 1;
                displayPokemon(selectedPokemon);
            }
            case 4 -> {
                movesFifth = new ArrayList();
                movesFifth = addMoves();
                selectedPokemon -= 1;
                displayPokemon(selectedPokemon);
            }
            case 5 -> {
                movesSixth = new ArrayList();
                movesSixth = addMoves();
                selectedPokemon -= 1;
                displayPokemon(selectedPokemon);
            }
        }
    }//GEN-LAST:event_lblBehindMouseClicked

    private void btnHechoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHechoActionPerformed
        combatTeamPJ = new ArrayList();
        combatTeamCOM = new ArrayList();
        try {
            for (int i = 0; i < equipoPJ.size(); i++) {
                CombatPokemon cp = new CombatPokemon();
                CombatPokemon com = new CombatPokemon();
                cp.setNombre(equipoPJ.get(i).getName());
                setMoves(i, cp);
                setStats(i, cp);
                setTypes(i, cp);
                BufferedImage back = ImageIO.read(new URL(equipoPJ.get(i).getSprites().getBackDefault()));
                BufferedImage front = ImageIO.read(new URL(equipoPJ.get(i).getSprites().getFrontDefault()));
                cp.setFrontSprite(front);
                cp.setBackSprite(back);
                combatTeamPJ.add(cp);
                combatTeamCOM.add(cp);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        CombatForm cf = new CombatForm(combatTeamPJ, combatTeamCOM);
        cf.setVisible(true);
    }//GEN-LAST:event_btnHechoActionPerformed

    private void setMoves(int i, CombatPokemon cp) {
        switch (i) {
            case 0 -> {
                cp.setMoves(movesFirst);
            }
            case 1 -> {
                cp.setMoves(movesSecond);
            }
            case 2 -> {
                cp.setMoves(movesThird);
            }
            case 3 -> {
                cp.setMoves(movesFourth);
            }
            case 4 -> {
                cp.setMoves(movesFifth);
            }
            case 5 -> {
                cp.setMoves(movesSixth);
            }
        }
    }

    private void setStats(int i, CombatPokemon cp) {
        for (Stat s : equipoPJ.get(i).getStats()) {
            switch (s.getStat().getName().toLowerCase()) {
                case "hp" -> {
                    cp.setMaxHp((int) (s.getBaseStat() * 3));
                }
                case "attack" -> {
                    cp.setAtk((int) (s.getBaseStat() * 3));
                }
                case "defense" -> {
                    cp.setDef((int) (s.getBaseStat() * 3));
                }
                case "special-attack" -> {
                    cp.setSpAtk((int) (s.getBaseStat() * 3));
                }
                case "special-defense" -> {
                    cp.setSpDef((int) (s.getBaseStat() * 3));
                }
                case "speed" -> {
                    cp.setSpd((int) (s.getBaseStat() * 3));
                }
            }
        }
    }

    private void setTypes(int i, CombatPokemon cp) {
        List<PokemonType> types = equipoPJ.get(i).getTypes();

        cp.setTipo1(types.get(0).getType().getName());

        if (types.size() > 1) {
            cp.setTipo2(types.get(1).getType().getName());
        }
    }

    private void displayPokemon(int selectedPokemon) {
        try {
            Pokemon poke = equipoPJ.get(selectedPokemon);

            BufferedImage img = ImageIO.read(new URL(poke.getSprites().getFrontDefault()));
            lblPoke.setIcon(resizImageIcon(img, 96));
            /*ProcessMoves processMoves = new ProcessMoves(poke);
            Thread t = new Thread(processMoves);
            t.start();*/
            List<PokemonMove> movimientos = getMoves(poke);
            crearComboBox(movimientos);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    private List<PokemonMove> getMoves(Pokemon poke) {
        List<PokemonMove> moves = poke.getMoves();
//        Moves moveFinal = new Moves();
       List<PokemonMove> movimientos = new ArrayList<PokemonMove>();
//        try {
            for (PokemonMove move : moves) {
//                CloseableHttpClient httpClient = HttpClients.createDefault();
//
//                HttpGet request = new HttpGet(move.getMove().getUrl());
//
//                CloseableHttpResponse response = httpClient.execute(request);
//                HttpEntity entity = response.getEntity();
//                String result = EntityUtils.toString(entity);
//                Object data = ConverterMoves.fromJsonString(result, moveFinal);
//                moveFinal = (Moves) data;
//                if (!move.getMove()) {
                    movimientos.add(move);
//                }
//            }
//
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
        }
        return movimientos;
    }
    

    private ImageIcon resizImageIcon(BufferedImage originalImage, int size) {
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

    public void crearComboBox(List<PokemonMove> movimientos) {
        DefaultComboBoxModel<PokemonMove> model1 = new DefaultComboBoxModel();
        DefaultComboBoxModel<PokemonMove> model2 = new DefaultComboBoxModel();
        DefaultComboBoxModel<PokemonMove> model3 = new DefaultComboBoxModel();
        DefaultComboBoxModel<PokemonMove> model4 = new DefaultComboBoxModel();

        for (PokemonMove m : movimientos) {
            model1.addElement(m);
            model2.addElement(m);
            model3.addElement(m);
            model4.addElement(m);
        }
        cmbMove1.setModel(model1);
        cmbMove2.setModel(model2);
        cmbMove3.setModel(model3);
        cmbMove4.setModel(model4);
        revalidate();
        repaint();
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
            java.util.logging.Logger.getLogger(ChooseMoveDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseMoveDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseMoveDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseMoveDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHecho;
    private javax.swing.JComboBox<PokemonMove> cmbMove1;
    private javax.swing.JComboBox<PokemonMove> cmbMove2;
    private javax.swing.JComboBox<PokemonMove> cmbMove3;
    private javax.swing.JComboBox<PokemonMove> cmbMove4;
    private javax.swing.JLabel lblBehind;
    private javax.swing.JLabel lblNext;
    private javax.swing.JLabel lblPoke;
    // End of variables declaration//GEN-END:variables
}
