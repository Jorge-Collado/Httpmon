package psp;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
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
import javax.swing.UIManager;
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
 * @author Merce
 */
public class MainForm extends javax.swing.JFrame {

    ArrayList<ImageIcon> icons96 = new ArrayList<>();
    ArrayList<ImageIcon> icons200 = new ArrayList<>();
    ArrayList<Pokemon> pokemons = new ArrayList<>();
    HashMap<String, String> tiposMap = new HashMap<>();
    int actualPage = 0;

    public MainForm() {
        initComponents();
        loadUI();
        loadTipos();
    }

    private void loadUI() {
        try {
            BufferedImage icon = ImageIO.read(new File("src/psp/assets/frameIcon.png"));
            this.setIconImage(icon);
            
            btnBuscar.setBackground(Color.YELLOW);
            btnBuscar.setContentAreaFilled(false);
            btnBuscar.setOpaque(true);
            
            btnNextPage.setBackground(Color.YELLOW);
            btnNextPage.setContentAreaFilled(false);
            btnNextPage.setOpaque(true);
            
            btnPreviousPage.setBackground(Color.YELLOW);
            btnPreviousPage.setContentAreaFilled(false);
            btnPreviousPage.setOpaque(true);
            
            lblError.setVisible(false);
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
                    System.out.println(poke.getMoves());
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
        lblPokeBox1 = new javax.swing.JLabel();
        lblPokeBox2 = new javax.swing.JLabel();
        lblPokeBox5 = new javax.swing.JLabel();
        lblPokeBox3 = new javax.swing.JLabel();
        lblPokeBox6 = new javax.swing.JLabel();
        lblPokeBox4 = new javax.swing.JLabel();
        panePokedex = new javax.swing.JPanel();
        paneDescription = new javax.swing.JPanel();
        lblPokedexName = new javax.swing.JLabel();
        lblPokedexImage = new javax.swing.JLabel();
        paneTypes = new javax.swing.JPanel();
        btnNextPage = new javax.swing.JButton();
        btnPreviousPage = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBuscador = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

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

        lblPokeBox1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball96.jpg"))); // NOI18N
        lblPokeBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblPokeBox2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball96.jpg"))); // NOI18N
        lblPokeBox2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblPokeBox5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball96.jpg"))); // NOI18N
        lblPokeBox5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblPokeBox3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball96.jpg"))); // NOI18N
        lblPokeBox3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblPokeBox6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball96.jpg"))); // NOI18N
        lblPokeBox6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblPokeBox4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball96.jpg"))); // NOI18N
        lblPokeBox4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPokeBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPokeBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblPokeBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(lblPokeBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblPokeBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(lblPokeBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblPokeBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPokeBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblPokeBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPokeBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPokeBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPokeBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panePokedexLayout.setVerticalGroup(
            panePokedexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );

        paneDescription.setBackground(new java.awt.Color(153, 0, 255));
        paneDescription.setMaximumSize(new java.awt.Dimension(400, 300));

        lblPokedexName.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        lblPokedexName.setForeground(new java.awt.Color(255, 255, 255));
        lblPokedexName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPokedexName.setText("LUCARIO #448");

        lblPokedexImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        paneTypes.setBackground(new java.awt.Color(153, 0, 255));
        paneTypes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout paneTypesLayout = new javax.swing.GroupLayout(paneTypes);
        paneTypes.setLayout(paneTypesLayout);
        paneTypesLayout.setHorizontalGroup(
            paneTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
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
                .addGap(70, 70, 70)
                .addGroup(paneDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblPokedexImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPokedexName, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(paneTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );
        paneDescriptionLayout.setVerticalGroup(
            paneDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneDescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPokedexImage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPokedexName, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paneTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnNextPage.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        btnNextPage.setText(">");
        btnNextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextPageActionPerformed(evt);
            }
        });

        btnPreviousPage.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        btnPreviousPage.setText("<");
        btnPreviousPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousPageActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HTTPkmon");

        txtBuscador.setBackground(new java.awt.Color(153, 0, 255));
        txtBuscador.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtBuscador.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscador.setToolTipText("Busca un Pokémon por su nombre exacto o su número de la pokédex");
        txtBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscadorKeyTyped(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setOpaque(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblError.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 255, 255));
        lblError.setText("No se ha encontrado el Pokémon especificado.");

        javax.swing.GroupLayout paneContentPaneLayout = new javax.swing.GroupLayout(paneContentPane);
        paneContentPane.setLayout(paneContentPaneLayout);
        paneContentPaneLayout.setHorizontalGroup(
            paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneContentPaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panePokedex, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneContentPaneLayout.createSequentialGroup()
                        .addComponent(btnPreviousPage, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNextPage, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(paneDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneContentPaneLayout.setVerticalGroup(
            paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneContentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(paneContentPaneLayout.createSequentialGroup()
                        .addGroup(paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBuscador))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblError))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneContentPaneLayout.createSequentialGroup()
                        .addComponent(panePokedex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPreviousPage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNextPage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(paneDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneContentPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneContentPane, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        loadPokemons(0, 16);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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

    private void txtBuscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorKeyTyped
        if (evt.getKeyChar() == '\n') {
            btnBuscar.doClick();
        }
    }//GEN-LAST:event_txtBuscadorKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (!txtBuscador.getText().trim().equals("")) {
            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            Pokemon p = searchPokemon();
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            if (p.getName() != null) {
                PokemonDialog pd = new PokemonDialog(this, true, p);
                pd.setVisible(true);
                lblError.setVisible(false);
            } else {
                lblError.setText("No se ha encontrado el Pokémon especificado.");
                lblError.setVisible(true);
            }
        } else {
            lblError.setText("Introduce el nombre o el id del pokemon");
            lblError.setVisible(true);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private Pokemon searchPokemon() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        Pokemon pokemon = new Pokemon();
        try {
            HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/" + txtBuscador.getText().toLowerCase());

            CloseableHttpResponse response = httpClient.execute(request);
            try {
                System.out.println("PokemonList: " + response.getProtocolVersion());
                System.out.println("PokemonList: " + response.getStatusLine().getStatusCode());
                if (response.getStatusLine().getStatusCode() == 200) {
                    System.out.println("PokemonList: " + response.getStatusLine().getReasonPhrase());
                    System.out.println("PokemonList: " + response.getStatusLine().toString());

                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        String result = EntityUtils.toString(entity);
                        Pokemon p = new Pokemon();

                        Object data = Converter.fromJsonString(result, p);

                        pokemon = (Pokemon) data;
                        System.out.println("Pkmn cargado");
                        lblError.setVisible(false);
                    }
                } else {
                    lblError.setVisible(true);
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
        return pokemon;
    }

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
        JLabel label = (JLabel) evt.getSource();
        int index = Integer.parseInt(label.getText());
        Pokemon poke = pokemons.get(index);
        PokemonDialog pd = new PokemonDialog(this, true, poke);
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
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNextPage;
    private javax.swing.JButton btnPreviousPage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblPokeBox1;
    private javax.swing.JLabel lblPokeBox2;
    private javax.swing.JLabel lblPokeBox3;
    private javax.swing.JLabel lblPokeBox4;
    private javax.swing.JLabel lblPokeBox5;
    private javax.swing.JLabel lblPokeBox6;
    private javax.swing.JLabel lblPokedexImage;
    private javax.swing.JLabel lblPokedexName;
    private javax.swing.JPanel paneContentPane;
    private javax.swing.JPanel paneDescription;
    private javax.swing.JPanel panePokedex;
    private javax.swing.JPanel paneTypes;
    private javax.swing.JTextField txtBuscador;
    // End of variables declaration//GEN-END:variables
}
