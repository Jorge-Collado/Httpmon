package psp.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import psp.MainForm;
import psp.Types;
import psp.controllers.Converter;
import psp.controllers.ConverterEvolution;
import psp.controllers.ConverterSpecies;
import psp.models.evolution.Chain;
import psp.models.evolution.EvolutionChain;
import psp.models.pokemon.Pokemon;
import psp.models.pokemon.PokemonType;
import psp.models.species.SpeciesFlavorTextEntry;
import psp.models.species.Species;

/**
 * @author merce
 */
public class PokemonDialog extends javax.swing.JDialog {

    Pokemon pokemon;
    Species specie;
    EvolutionChain evolution;
    HashMap<String, String> tiposMap;
    ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

    public PokemonDialog(java.awt.Frame parent, boolean modal, Pokemon pokemon) {
        super(parent, modal);
        initComponents();
        Types t = new Types();
        tiposMap = t.getTiposMap();
        this.pokemon = pokemon;
        loadUI();

        this.specie = loadPokemonData();
        this.evolution = loadEvolutionData();
        loadInfo();
        loadTypes();
        loadData();
        loadFirstChain();
        loadChain(evolution.getChain().getEvolvesTo());
        addChain();
        this.setLocationRelativeTo(null);
    }

    private void loadFirstChain() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/" + evolution.getChain().getSpecies().getName());
            CloseableHttpResponse response = httpClient.execute(request);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    Pokemon p = new Pokemon();
                    String result = EntityUtils.toString(entity);
                    Object data = Converter.fromJsonString(result, p);
                    p = (Pokemon) data;
                    pokemons.add(p);
                }
            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                response.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadChain(List<Chain> cadena) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        if (cadena.size() != 0) {
            try {
                for (int i = 0; i < cadena.size(); i++) {
                    HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/" + cadena.get(i).getSpecies().getName());
                    CloseableHttpResponse response = httpClient.execute(request);
                    try {
                        HttpEntity entity = response.getEntity();
                        if (entity != null) {
                            Pokemon p = new Pokemon();
                            String result = EntityUtils.toString(entity);
                            Object data = Converter.fromJsonString(result, p);
                            p = (Pokemon) data;
                            pokemons.add(p);
                            if (cadena.get(i).getEvolvesTo().size() > 0) {
                                loadChain(cadena.get(i).getEvolvesTo());
                            }
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        response.close();
                    }
                }

            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void addChain() {
        paneChain.removeAll();
        for (int i = 0; i < pokemons.size(); i++) {
            Pokemon p = pokemons.get(i);
            try {
                JLabel lblPoke = new JLabel();
                BufferedImage img = ImageIO.read(new URL(p.getSprites().getFrontDefault()));
                lblPoke.setBounds(i * 100, 0, 96, 96);
                lblPoke.setIcon(resizImageIcon(img, 96));
                lblPoke.setText(String.valueOf(i));
                lblPoke.setIconTextGap(-10);
                paneChain.add(lblPoke);
                scrChain.setBounds(paneChain.getBounds());

                lblPoke.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        if (evt.getClickCount() == 2) {
                            showInfo(evt);
                        }
                    }

                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnPokemonMouseEntered(evt);
                    }

                    @Override
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnPokemonMouseExited(evt);
                    }
                });
            } catch (MalformedURLException ex) {
                Logger.getLogger(PokemonDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PokemonDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void btnPokemonMouseEntered(MouseEvent evt) {
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void btnPokemonMouseExited(MouseEvent evt) {
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private void showInfo(MouseEvent evt) {
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        JLabel label = (JLabel) evt.getSource();
        int index = Integer.parseInt(label.getText());
        Pokemon poke = pokemons.get(index);
        PokemonDialog pd = new PokemonDialog((MainForm) this.getParent(), true, poke);
        this.dispose();
        pd.setVisible(true);
    }

    private void loadData() {
        long cicle = specie.getHatchCounter();
        long steps = cicle * 250;
        lblHuevo.setText(String.format("Huevo: %d (%d pasos).", cicle, steps));
        lblHapiness.setText("Felicidad base: " + specie.getBaseHappiness());
        String[] splitter = specie.getGeneration().getName().split("-");
        String gen = splitter[1].toUpperCase();
        lblGen.setText("Generación " + gen);
        double femaleRatio = specie.getGenderRate() * 12.5;
        double maleRatio = 100 - femaleRatio;
        lblHembra.setText("Hembra ratio: " + femaleRatio);
        lblMacho.setText("Macho ratio: " + maleRatio);
    }

    private void loadInfo() {
        String resultText = "";
        for (int i = 0; i < specie.getFlavorTextEntries().size(); i++) {
            SpeciesFlavorTextEntry text = specie.getFlavorTextEntries().get(i);
            if (text.getLanguage().getName().equals("es")) {
                resultText += text.getFlavorText() + "\n\n";
            }
        }
        txtInfo.setText(resultText);
    }

    private void loadTypes() {
        List<PokemonType> tipos = pokemon.getTypes();
        for (int i = 0; i < tipos.size(); i++) {
            try {
                JLabel lblType = new JLabel();
                PokemonType type = tipos.get(i);
                if (tipos.size() > 1) {
                    lblType.setBounds(20 + (i * 100), 3, 64, 64);
                } else {
                    lblType.setBounds(70, 3, 64, 64);
                }
                String imagePath = tiposMap.get(type.getType().getName());
                BufferedImage img = ImageIO.read(new File(imagePath));
                lblType.setIcon(resizImageIcon(img, 64));
                lblType.setBackground(Color.red);

                lblType.setIconTextGap(-10);
                paneTypes.add(lblType);
            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void loadUI() {
        try {
            this.setTitle(pokemon.getName().toUpperCase());
            BufferedImage img = ImageIO.read(new URL(pokemon.getSprites().getFrontDefault()));
            this.setIconImage(img);
            lblImage.setIcon(resizImageIcon(img, 200));
            lblName.setText(String.format("%s #%d", pokemon.getName().toUpperCase(), pokemon.getId()));
            btnAddEquipo.setBackground(Color.YELLOW);
            btnAddEquipo.setContentAreaFilled(false);
            btnAddEquipo.setOpaque(true);
        } catch (MalformedURLException ex) {
            Logger.getLogger(PokemonDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PokemonDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Species loadPokemonData() {
        Species sp = new Species();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet request = new HttpGet(pokemon.getSpecies().getUrl());

            CloseableHttpResponse response = httpClient.execute(request);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity);
                    Object data = ConverterSpecies.fromJsonString(result, sp);
                    sp = (Species) data;
                }
            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                response.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sp;
    }

    private EvolutionChain loadEvolutionData() {
        EvolutionChain ec = new EvolutionChain();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet request = new HttpGet(specie.getEvolutionChain().getUrl());

            CloseableHttpResponse response = httpClient.execute(request);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity);
                    Object data = ConverterEvolution.fromJsonString(result, ec);
                    ec = (EvolutionChain) data;
                }
            } catch (IOException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                response.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ec;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextArea();
        paneTypes = new javax.swing.JPanel();
        lblHuevo = new javax.swing.JLabel();
        lblHapiness = new javax.swing.JLabel();
        lblGen = new javax.swing.JLabel();
        lblHembra = new javax.swing.JLabel();
        lblMacho = new javax.swing.JLabel();
        scrChain = new javax.swing.JScrollPane();
        paneChain = new javax.swing.JPanel();
        btnAddEquipo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 204));

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblName.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("Pokémon #???");

        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Información:");

        txtInfo.setEditable(false);
        txtInfo.setBackground(new java.awt.Color(153, 0, 255));
        txtInfo.setColumns(20);
        txtInfo.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        txtInfo.setForeground(new java.awt.Color(255, 255, 255));
        txtInfo.setLineWrap(true);
        txtInfo.setRows(5);
        txtInfo.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtInfo);

        paneTypes.setBackground(new java.awt.Color(153, 0, 255));
        paneTypes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout paneTypesLayout = new javax.swing.GroupLayout(paneTypes);
        paneTypes.setLayout(paneTypesLayout);
        paneTypesLayout.setHorizontalGroup(
            paneTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        paneTypesLayout.setVerticalGroup(
            paneTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        lblHuevo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblHuevo.setForeground(new java.awt.Color(255, 255, 255));
        lblHuevo.setText("Huevo:");

        lblHapiness.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblHapiness.setForeground(new java.awt.Color(255, 255, 255));
        lblHapiness.setText("Felicidad base: ");

        lblGen.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblGen.setForeground(new java.awt.Color(255, 255, 255));
        lblGen.setText("Generación");

        lblHembra.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblHembra.setForeground(new java.awt.Color(255, 255, 255));
        lblHembra.setText("Hembra ratio: ");

        lblMacho.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblMacho.setForeground(new java.awt.Color(255, 255, 255));
        lblMacho.setText("Macho ratio: ");

        scrChain.setBackground(new java.awt.Color(0, 0, 0));
        scrChain.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        scrChain.setForeground(new java.awt.Color(0, 0, 0));
        scrChain.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        paneChain.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout paneChainLayout = new javax.swing.GroupLayout(paneChain);
        paneChain.setLayout(paneChainLayout);
        paneChainLayout.setHorizontalGroup(
            paneChainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1138, Short.MAX_VALUE)
        );
        paneChainLayout.setVerticalGroup(
            paneChainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        scrChain.setViewportView(paneChain);

        btnAddEquipo.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        btnAddEquipo.setText("TE ELIJO A TI!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(paneTypes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHapiness, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblHuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblHembra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMacho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrChain, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(btnAddEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(paneTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblHuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHapiness)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHembra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMacho)))
                .addGap(46, 46, 46)
                .addComponent(scrChain, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddEquipo)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PokemonDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PokemonDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PokemonDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PokemonDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEquipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGen;
    private javax.swing.JLabel lblHapiness;
    private javax.swing.JLabel lblHembra;
    private javax.swing.JLabel lblHuevo;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblMacho;
    private javax.swing.JLabel lblName;
    private javax.swing.JPanel paneChain;
    private javax.swing.JPanel paneTypes;
    private javax.swing.JScrollPane scrChain;
    private javax.swing.JTextArea txtInfo;
    // End of variables declaration//GEN-END:variables
}
