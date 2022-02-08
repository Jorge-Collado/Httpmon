package psp.combat;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import psp.controllers.ConverterMoves;
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
    private List<PokemonMove> provisionalMovesFirst;
    private List<PokemonMove> provisionalmovesSecond;
    private List<PokemonMove> provisionalmovesThird;
    private List<PokemonMove> provisionalmovesFourth;
    private List<PokemonMove> provisionalmovesFifth;
    private List<PokemonMove> provisionalmovesSixth;
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
        initUI();
        this.equipoPJ = equipoPJ;
        inicializarListas();
        displayPokemon(selectedPokemon);
        this.setLocationRelativeTo(null);
    }

    private void initUI() {
        btnHecho.setBackground(Color.YELLOW);
        btnHecho.setContentAreaFilled(false);
        btnHecho.setOpaque(true);
    }

    private void inicializarListas() {
        provisionalMovesFirst = new ArrayList();
        provisionalmovesSecond = new ArrayList();
        provisionalmovesThird = new ArrayList();
        provisionalmovesFourth = new ArrayList();
        provisionalmovesFifth = new ArrayList();
        provisionalmovesSixth = new ArrayList();

        for (int i = 0; i < 4; i++) {
            provisionalMovesFirst.add(equipoPJ.get(0).getMoves().get(i));
            provisionalmovesSecond.add(equipoPJ.get(1).getMoves().get(i));
            provisionalmovesThird.add(equipoPJ.get(2).getMoves().get(i));
            provisionalmovesFourth.add(equipoPJ.get(3).getMoves().get(i));
            provisionalmovesFifth.add(equipoPJ.get(4).getMoves().get(i));
            provisionalmovesSixth.add(equipoPJ.get(5).getMoves().get(i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblPoke = new javax.swing.JLabel();
        lblNext = new javax.swing.JLabel();
        lblBehind = new javax.swing.JLabel();
        btnHecho = new javax.swing.JButton();
        cmbMove1 = new javax.swing.JComboBox<>();
        cmbMove2 = new javax.swing.JComboBox<>();
        cmbMove4 = new javax.swing.JComboBox<>();
        cmbMove3 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 0, 204));

        jPanel1.setBackground(new java.awt.Color(102, 0, 204));

        lblNext.setBackground(new java.awt.Color(153, 0, 255));
        lblNext.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblNext.setForeground(new java.awt.Color(255, 255, 255));
        lblNext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNext.setText(">");
        lblNext.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblNext.setOpaque(true);
        lblNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNextMouseExited(evt);
            }
        });

        lblBehind.setBackground(new java.awt.Color(153, 0, 255));
        lblBehind.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblBehind.setForeground(new java.awt.Color(255, 255, 255));
        lblBehind.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBehind.setText("<");
        lblBehind.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblBehind.setOpaque(true);
        lblBehind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBehindMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBehindMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBehindMouseExited(evt);
            }
        });

        btnHecho.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnHecho.setForeground(new java.awt.Color(0, 0, 0));
        btnHecho.setText("Hecho");
        btnHecho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHechoActionPerformed(evt);
            }
        });

        cmbMove1.setBackground(new java.awt.Color(153, 0, 255));
        cmbMove1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        cmbMove1.setForeground(new java.awt.Color(0, 0, 0));
        cmbMove1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbMove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMove1ActionPerformed(evt);
            }
        });

        cmbMove2.setBackground(new java.awt.Color(153, 0, 255));
        cmbMove2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        cmbMove2.setForeground(new java.awt.Color(0, 0, 0));
        cmbMove2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cmbMove4.setBackground(new java.awt.Color(153, 0, 255));
        cmbMove4.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        cmbMove4.setForeground(new java.awt.Color(0, 0, 0));
        cmbMove4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cmbMove3.setBackground(new java.awt.Color(153, 0, 255));
        cmbMove3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        cmbMove3.setForeground(new java.awt.Color(0, 0, 0));
        cmbMove3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBehind, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPoke, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNext, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbMove3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbMove4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbMove1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbMove2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnHecho, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblBehind, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNext, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPoke, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbMove1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbMove2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbMove3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbMove4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnHecho)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private List<PokemonMove> addMoves() {
        List<PokemonMove> movimientos = new ArrayList();

        PokemonMove pk1 = (PokemonMove) cmbMove1.getSelectedItem();
        PokemonMove pk2 = (PokemonMove) cmbMove2.getSelectedItem();
        PokemonMove pk3 = (PokemonMove) cmbMove3.getSelectedItem();
        PokemonMove pk4 = (PokemonMove) cmbMove4.getSelectedItem();

        movimientos.add(pk1);
        movimientos.add(pk2);
        movimientos.add(pk3);
        movimientos.add(pk4);
        /*
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
        }*/
        return movimientos;
    }

    private void lblNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextMouseClicked
        switch (selectedPokemon) {
            case 0 -> {
                provisionalMovesFirst = addMoves();
                selectedPokemon += 1;
                displayPokemon(selectedPokemon);
            }
            case 1 -> {
                movesSecond = new ArrayList();
                provisionalmovesSecond = addMoves();
                selectedPokemon += 1;
                displayPokemon(selectedPokemon);
            }
            case 2 -> {
                movesThird = new ArrayList();
                provisionalmovesThird = addMoves();
                selectedPokemon += 1;
                displayPokemon(selectedPokemon);
            }
            case 3 -> {
                movesFourth = new ArrayList();
                provisionalmovesFourth = addMoves();
                selectedPokemon += 1;
                displayPokemon(selectedPokemon);
            }
            case 4 -> {
                movesFifth = new ArrayList();
                provisionalmovesFifth = addMoves();
                selectedPokemon += 1;
                displayPokemon(selectedPokemon);
            }
            case 5 -> {
                movesSixth = new ArrayList();
                provisionalmovesSixth = addMoves();
                selectedPokemon = 0;
                displayPokemon(selectedPokemon);
            }
        }
    }//GEN-LAST:event_lblNextMouseClicked

    private void lblBehindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBehindMouseClicked
        switch (selectedPokemon) {
            case 0 -> {
                movesFirst = new ArrayList();
                provisionalMovesFirst = addMoves();
                selectedPokemon = 5;
                displayPokemon(selectedPokemon);
            }
            case 1 -> {
                movesSecond = new ArrayList();
                provisionalmovesSecond = addMoves();
                selectedPokemon -= 1;
                displayPokemon(selectedPokemon);
            }
            case 2 -> {
                movesThird = new ArrayList();
                provisionalmovesThird = addMoves();
                selectedPokemon -= 1;
                displayPokemon(selectedPokemon);
            }
            case 3 -> {
                movesFourth = new ArrayList();
                provisionalmovesFourth = addMoves();
                selectedPokemon -= 1;
                displayPokemon(selectedPokemon);
            }
            case 4 -> {
                movesFifth = new ArrayList();
                provisionalmovesFifth = addMoves();
                selectedPokemon -= 1;
                displayPokemon(selectedPokemon);
            }
            case 5 -> {
                movesSixth = new ArrayList();
                provisionalmovesSixth = addMoves();
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
                cp.setNombre(equipoPJ.get(i).getName());
                pedirMoves(i);
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

    private void lblNextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblNextMouseEntered

    private void lblNextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lblNextMouseExited

    private void lblBehindMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBehindMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblBehindMouseEntered

    private void lblBehindMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBehindMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lblBehindMouseExited

    private void cmbMove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMove1ActionPerformed
        System.out.println("pulsao");
    }//GEN-LAST:event_cmbMove1ActionPerformed

    private void pedirMoves(int i) {
        switch (i) {
            case 0 -> {
                movesFirst = new ArrayList(); 
                Moves moveFinal = new Moves();
                try {
                    for (PokemonMove move : provisionalMovesFirst) {
                        CloseableHttpClient httpClient = HttpClients.createDefault();

                        HttpGet request = new HttpGet(move.getMove().getUrl());

                        CloseableHttpResponse response = httpClient.execute(request);
                        HttpEntity entity = response.getEntity();
                        String result = EntityUtils.toString(entity);
                        Object data = ConverterMoves.fromJsonString(result, moveFinal);
                        moveFinal = (Moves) data;

                        movesFirst.add(moveFinal);

                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
            case 1 -> {
                movesSecond = new ArrayList(); 
                Moves moveFinal = new Moves();
                try {
                    for (PokemonMove move : provisionalmovesSecond) {
                        CloseableHttpClient httpClient = HttpClients.createDefault();

                        HttpGet request = new HttpGet(move.getMove().getUrl());

                        CloseableHttpResponse response = httpClient.execute(request);
                        HttpEntity entity = response.getEntity();
                        String result = EntityUtils.toString(entity);
                        Object data = ConverterMoves.fromJsonString(result, moveFinal);
                        moveFinal = (Moves) data;

                        movesSecond.add(moveFinal);

                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
            case 2 -> {
                movesThird = new ArrayList(); 
                Moves moveFinal = new Moves();
                try {
                    for (PokemonMove move : provisionalmovesThird) {
                        CloseableHttpClient httpClient = HttpClients.createDefault();

                        HttpGet request = new HttpGet(move.getMove().getUrl());

                        CloseableHttpResponse response = httpClient.execute(request);
                        HttpEntity entity = response.getEntity();
                        String result = EntityUtils.toString(entity);
                        Object data = ConverterMoves.fromJsonString(result, moveFinal);
                        moveFinal = (Moves) data;

                        movesThird.add(moveFinal);

                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
            case 3 -> {
                movesFourth = new ArrayList(); 
                Moves moveFinal = new Moves();
                try {
                    for (PokemonMove move : provisionalmovesFourth) {
                        CloseableHttpClient httpClient = HttpClients.createDefault();

                        HttpGet request = new HttpGet(move.getMove().getUrl());

                        CloseableHttpResponse response = httpClient.execute(request);
                        HttpEntity entity = response.getEntity();
                        String result = EntityUtils.toString(entity);
                        Object data = ConverterMoves.fromJsonString(result, moveFinal);
                        moveFinal = (Moves) data;

                        movesFourth.add(moveFinal);

                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
            case 4 -> {
                movesFifth = new ArrayList(); 
                Moves moveFinal = new Moves();
                try {
                    for (PokemonMove move : provisionalmovesFifth) {
                        CloseableHttpClient httpClient = HttpClients.createDefault();

                        HttpGet request = new HttpGet(move.getMove().getUrl());

                        CloseableHttpResponse response = httpClient.execute(request);
                        HttpEntity entity = response.getEntity();
                        String result = EntityUtils.toString(entity);
                        Object data = ConverterMoves.fromJsonString(result, moveFinal);
                        moveFinal = (Moves) data;

                        movesFifth.add(moveFinal);

                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
            case 5 -> {
                movesSixth = new ArrayList(); 
                Moves moveFinal = new Moves();
                try {
                    for (PokemonMove move : provisionalmovesSixth) {
                        CloseableHttpClient httpClient = HttpClients.createDefault();

                        HttpGet request = new HttpGet(move.getMove().getUrl());

                        CloseableHttpResponse response = httpClient.execute(request);
                        HttpEntity entity = response.getEntity();
                        String result = EntityUtils.toString(entity);
                        Object data = ConverterMoves.fromJsonString(result, moveFinal);
                        moveFinal = (Moves) data;

                        movesSixth.add(moveFinal);

                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
                
            }
        }
    }

    private void requestMoves(List<Moves> lista, List<PokemonMove> provisional) {
        Moves moveFinal = new Moves();
        try {
            for (PokemonMove move : provisional) {
                CloseableHttpClient httpClient = HttpClients.createDefault();

                HttpGet request = new HttpGet(move.getMove().getUrl());

                CloseableHttpResponse response = httpClient.execute(request);
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);
                Object data = ConverterMoves.fromJsonString(result, moveFinal);
                moveFinal = (Moves) data;
                if (!moveFinal.getDamageClass().getName().equals("status")) {
                    lista.add(moveFinal);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

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
            lblPoke.setIcon(resizImageIcon(img, 200));

            List<PokemonMove> movimientos = getMoves(poke);
            crearComboBox(movimientos);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private List<PokemonMove> getMoves(Pokemon poke) {
        List<PokemonMove> moves = poke.getMoves();
        List<PokemonMove> movimientos = new ArrayList<PokemonMove>();
        for (PokemonMove move : moves) {
            movimientos.add(move);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBehind;
    private javax.swing.JLabel lblNext;
    private javax.swing.JLabel lblPoke;
    // End of variables declaration//GEN-END:variables
}
