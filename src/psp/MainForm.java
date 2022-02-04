package psp;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.TransferHandler;
import javax.swing.plaf.basic.BasicBorders;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import psp.components.PokemonDialog;
import psp.controllers.Converter;
import psp.controllers.ConverterList;
import psp.models.list.PokemonList;
import psp.models.list.Result;
import psp.models.pokemon.Pokemon;
import psp.models.pokemon.PokemonType;

/**
 * @author Georgeus
 */
public class MainForm extends javax.swing.JFrame {

    ArrayList<ImageIcon> icons96 = new ArrayList<>();
    ArrayList<ImageIcon> icons200 = new ArrayList<>();
    ArrayList<Pokemon> pokemons = new ArrayList<>();
    HashMap<String, String> tiposMap = new HashMap<>();
    int actualPage = 0;

    public MainForm() {
        try {
            initComponents();
            loadTipos();
            BufferedImage img = ImageIO.read(new File("src/psp/assets/pokeball.png"));
            lblPokedexImage.setIcon(resizImageIcon(img, 200));
            lblPokedexName.setText("POKEMON #???");
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadTipos() {
        tiposMap.put("normal", "src/psp/assets/tipos/normal.png");
        tiposMap.put("fighting", "src/psp/assets/tipos/lucha.png");
        tiposMap.put("flying", "src/psp/assets/tipos/volador.png");
        tiposMap.put("poison", "src/psp/assets/tipos/veneno.png");
        tiposMap.put("rock", "src/psp/assets/tipos/roca.png");
        tiposMap.put("bug", "src/psp/assets/tipos/bicho.png");
        tiposMap.put("ghost", "src/psp/assets/tipos/david.png");
        tiposMap.put("steel", "src/psp/assets/tipos/acero.png");
        tiposMap.put("fire", "src/psp/assets/tipos/fuego.png");
        tiposMap.put("water", "src/psp/assets/tipos/agua.png");
        tiposMap.put("grass", "src/psp/assets/tipos/planta.png");
        tiposMap.put("electric", "src/psp/assets/tipos/electrico.png");
        tiposMap.put("psychic", "src/psp/assets/tipos/psiquico.png");
        tiposMap.put("ice", "src/psp/assets/tipos/hielo.png");
        tiposMap.put("dragon", "src/psp/assets/tipos/dragon.png");
        tiposMap.put("dark", "src/psp/assets/tipos/siniestro.png");
        tiposMap.put("fairy", "src/psp/assets/tipos/hada.png");
        tiposMap.put("ground", "src/psp/assets/tipos/tierra.png");
    }

    private void loadByPage(int offset, int limit) {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
            HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/?offset=" + offset + "&limit=" + limit);

            CloseableHttpResponse response = httpClient.execute(request);
            try {
                System.out.println("PokemonList: " + response.getProtocolVersion());
                System.out.println("PokemonList: " + response.getStatusLine().getStatusCode());
                System.out.println("PokemonList: " + response.getStatusLine().getReasonPhrase());
                System.out.println("PokemonList: " + response.getStatusLine().toString());

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity);
                    PokemonList data = ConverterList.fromJsonString(result);

                    for (Result r : data.getResults()) {
                        pokemons.add(getPokemon(r.getUrl()));
                    }
                    System.out.println("Pkmn cargados");
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

    private Pokemon getPokemon(String url) {
        Pokemon poke = new Pokemon();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet request = new HttpGet(url);

            CloseableHttpResponse response = httpClient.execute(request);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity);
                    Pokemon p = new Pokemon();
                    Object data = Converter.fromJsonString(result, p);
                    poke = (Pokemon) data;
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
        return poke;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        paneContentPane = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        panePokedex = new javax.swing.JPanel();
        lblPokeName = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        scrDescription = new javax.swing.JScrollPane();
        paneDescription = new javax.swing.JPanel();
        lblPokedexName = new javax.swing.JLabel();
        lblPokedexImage = new javax.swing.JLabel();
        paneTypes = new javax.swing.JPanel();
        btnNextPage = new javax.swing.JButton();
        btnPreviousPage = new javax.swing.JButton();

        jLabel9.setText("Duskull");

        jLabel5.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        paneContentPane.setBackground(new java.awt.Color(102, 0, 204));
        paneContentPane.setPreferredSize(new java.awt.Dimension(800, 1150));

        jPanel2.setBackground(new java.awt.Color(153, 0, 255));
        jPanel2.setForeground(new java.awt.Color(51, 51, 51));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball96.jpg"))); // NOI18N
        jLabel19.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButton2.setText("Borrar");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball96.jpg"))); // NOI18N
        jLabel20.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball96.jpg"))); // NOI18N
        jLabel21.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball96.jpg"))); // NOI18N
        jLabel22.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball96.jpg"))); // NOI18N
        jLabel23.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball96.jpg"))); // NOI18N
        jLabel24.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panePokedex.setBackground(new java.awt.Color(0, 0, 0));
        panePokedex.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panePokedex.setForeground(new java.awt.Color(255, 255, 255));
        panePokedex.setPreferredSize(new java.awt.Dimension(390, 390));

        javax.swing.GroupLayout panePokedexLayout = new javax.swing.GroupLayout(panePokedex);
        panePokedex.setLayout(panePokedexLayout);
        panePokedexLayout.setHorizontalGroup(
            panePokedexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        panePokedexLayout.setVerticalGroup(
            panePokedexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );

        lblPokeName.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblPokeName.setForeground(new java.awt.Color(255, 255, 255));
        lblPokeName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton1.setText("jButton1");

        scrDescription.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        paneDescription.setBackground(new java.awt.Color(153, 0, 255));
        paneDescription.setMaximumSize(new java.awt.Dimension(400, 300));

        lblPokedexName.setFont(new java.awt.Font("ITC Eras", 0, 18)); // NOI18N
        lblPokedexName.setForeground(new java.awt.Color(255, 255, 255));
        lblPokedexName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPokedexName.setText("LUCARIO #448");

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

        javax.swing.GroupLayout paneDescriptionLayout = new javax.swing.GroupLayout(paneDescription);
        paneDescription.setLayout(paneDescriptionLayout);
        paneDescriptionLayout.setHorizontalGroup(
            paneDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDescriptionLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(paneDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPokedexImage, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(lblPokedexName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(paneTypes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(193, 193, 193))
        );
        paneDescriptionLayout.setVerticalGroup(
            paneDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneDescriptionLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblPokedexImage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPokedexName, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(500, Short.MAX_VALUE))
        );

        scrDescription.setViewportView(paneDescription);

        btnNextPage.setText(">");
        btnNextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextPageActionPerformed(evt);
            }
        });

        btnPreviousPage.setText("<");
        btnPreviousPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousPageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneContentPaneLayout = new javax.swing.GroupLayout(paneContentPane);
        paneContentPane.setLayout(paneContentPaneLayout);
        paneContentPaneLayout.setHorizontalGroup(
            paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneContentPaneLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneContentPaneLayout.createSequentialGroup()
                        .addComponent(btnPreviousPage, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNextPage, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panePokedex, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrDescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblPokeName, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(paneContentPaneLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        paneContentPaneLayout.setVerticalGroup(
            paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneContentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPokeName, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneContentPaneLayout.createSequentialGroup()
                        .addComponent(scrDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 427, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(38, 38, 38))
                    .addGroup(paneContentPaneLayout.createSequentialGroup()
                        .addComponent(panePokedex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNextPage)
                            .addComponent(btnPreviousPage))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneContentPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneContentPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        loadPokemons(0, 16);
    }//GEN-LAST:event_formWindowOpened

    private void loadPokemons(int offset, int limit) {
        if (pokemons.size() < ((16 * actualPage) + 16)) {
            loadByPage(offset, limit);
            searchIcons();
        }

        panePokedex.removeAll();
        int counter = (actualPage * 16);
        for (int j = 0; j < 4; j++) {
            int y = j * 100;
            for (int i = 0; i < 4; i++) {
                int x = i * 100;
                JLabel label = new JLabel();
                label.setIcon(icons96.get(counter));
                label.setEnabled(true);
                label.setIconTextGap(-10);
                label.setText(String.valueOf(counter));
                counter++;
                label.setBounds(10 + x, y, 96, 96);

                label.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnPokemonMouseEntered(evt);
                    }

                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnPokemonMouseExited(evt);
                    }

                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        if (evt.getClickCount() == 2) {
                            showInfo(evt);
                        } else {
                            teElijoATi(evt);
                        }
                    }
                });

                panePokedex.add(label);
            }
        }
        revalidate();
        repaint();
    }
    private void btnNextPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextPageActionPerformed
        try {
            BufferedImage img = ImageIO.read(new File("src/psp/assets/pokeball.png"));
            lblPokedexImage.setIcon(resizImageIcon(img, 200));
            lblPokedexName.setText("POKEMON #???");
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            actualPage++;
            int offset = 16 * actualPage;
            int limit = 16;
            loadPokemons(offset, limit);
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            System.out.println(icons200.size());
            System.out.println(pokemons.size());
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNextPageActionPerformed

    private void btnPreviousPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousPageActionPerformed
        try {
            if (actualPage != 0) {
                BufferedImage img = ImageIO.read(new File("src/psp/assets/pokeball.png"));
                lblPokedexImage.setIcon(resizImageIcon(img, 200));
                lblPokedexName.setText("POKEMON #???");
                this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                actualPage--;
                int offset = 16 * actualPage;
                int limit = 16;
                loadPokemons(offset, limit);
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                System.out.println(icons200.size());
                System.out.println(pokemons.size());
            }
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPreviousPageActionPerformed

    private void btnPokemonMouseEntered(MouseEvent evt) {
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JLabel label = (JLabel) evt.getSource();
        int index = Integer.parseInt(label.getText());
        Pokemon poke = pokemons.get(index);
        lblPokedexName.setText(String.format("%s #%d", poke.getName().toUpperCase(), poke.getId()));

        lblPokedexImage.setIcon(icons200.get(index));
        List<PokemonType> tipos = poke.getTypes();
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
        revalidate();
        repaint();
    }

    private void teElijoATi(MouseEvent evt) {
        if (evt.getSource() instanceof JButton) {
            JButton button = (JButton) evt.getSource();
            TransferHandler handler = button.getTransferHandler();
            handler.exportAsDrag(button, evt, TransferHandler.COPY);
        }
    }

    private void showInfo(MouseEvent evt) {
        PokemonDialog pd = new PokemonDialog(this, true);
        pd.setVisible(true);
    }

    private void btnPokemonMouseExited(MouseEvent evt) {
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        paneTypes.removeAll();
    }

    private void searchIcons() {
        try {
            int split = 16 * actualPage;
            for (int i = 0 + split; i < split + 16; i++) {
                Pokemon p = pokemons.get(i);
                BufferedImage img = ImageIO.read(new URL(p.getSprites().getFrontDefault()));
                icons96.add(resizImageIcon(img, 96));
                icons200.add(resizImageIcon(img, 200));
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNextPage;
    private javax.swing.JButton btnPreviousPage;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblPokeName;
    private javax.swing.JLabel lblPokedexImage;
    private javax.swing.JLabel lblPokedexName;
    private javax.swing.JPanel paneContentPane;
    private javax.swing.JPanel paneDescription;
    private javax.swing.JPanel panePokedex;
    private javax.swing.JPanel paneTypes;
    private javax.swing.JScrollPane scrDescription;
    // End of variables declaration//GEN-END:variables
}
