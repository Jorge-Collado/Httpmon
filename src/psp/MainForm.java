package psp;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
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
import javax.swing.UIManager;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import psp.combat.ChooseMoveDialog;
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
    ArrayList<JLabel> cajaPokemon = new ArrayList<>();
    HashMap<String, String> tiposMap;
    int actualPage = 0;
    int contador = 0;
    ArrayList<Pokemon> equipoPJ;
    ArrayList<Boolean> cajaOcupada = new ArrayList<>();

    public MainForm() {
        initComponents();
        loadUI();
        Types t = new Types();
        tiposMap = t.getTiposMap();
        this.setLocationRelativeTo(null);
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    private void loadUI() {
        try {
            this.setTitle("HTTPkmon");
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

            btnFight.setBackground(Color.YELLOW);
            btnFight.setContentAreaFilled(false);
            btnFight.setOpaque(true);

            lblError.setVisible(false);
            BufferedImage img = ImageIO.read(new File("src/psp/assets/pokeball.png"));
            lblPokedexImage.setIcon(resizImageIcon(img, 200));
            lblPokedexName.setText("POKEMON #???");

            cajaPokemon.add(lblPokeBox1);
            cajaPokemon.add(lblPokeBox2);
            cajaPokemon.add(lblPokeBox3);
            cajaPokemon.add(lblPokeBox4);
            cajaPokemon.add(lblPokeBox5);
            cajaPokemon.add(lblPokeBox6);

            cajaOcupada.add(false);
            cajaOcupada.add(false);
            cajaOcupada.add(false);
            cajaOcupada.add(false);
            cajaOcupada.add(false);
            cajaOcupada.add(false);
            
            equipoPJ = new ArrayList<>();
            equipoPJ.add(null);
            equipoPJ.add(null);
            equipoPJ.add(null);
            equipoPJ.add(null);
            equipoPJ.add(null);
            equipoPJ.add(null);
            
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        buttonGroup1 = new javax.swing.ButtonGroup();
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
        btnFight = new javax.swing.JButton();
        lblTeamSize = new javax.swing.JLabel();
        chkTeamSelector = new javax.swing.JCheckBox();

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

        lblPokeBox1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblPokeBox1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball96.jpg"))); // NOI18N
        lblPokeBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lblPokeBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPokeBox1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPokeBox1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPokeBox1MouseExited(evt);
            }
        });

        lblPokeBox2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblPokeBox2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball96.jpg"))); // NOI18N
        lblPokeBox2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lblPokeBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPokeBox2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPokeBox2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPokeBox2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblPokeBox2MousePressed(evt);
            }
        });

        lblPokeBox5.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblPokeBox5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball96.jpg"))); // NOI18N
        lblPokeBox5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lblPokeBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPokeBox5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPokeBox5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPokeBox5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblPokeBox1MousePressed(evt);
            }
        });

        lblPokeBox3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblPokeBox3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball96.jpg"))); // NOI18N
        lblPokeBox3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lblPokeBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPokeBox3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPokeBox3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPokeBox3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblPokeBox1MousePressed(evt);
            }
        });

        lblPokeBox6.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblPokeBox6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball96.jpg"))); // NOI18N
        lblPokeBox6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lblPokeBox6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPokeBox6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPokeBox6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPokeBox6MouseExited(evt);
            }
        });

        lblPokeBox4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblPokeBox4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psp/assets/pokeball96.jpg"))); // NOI18N
        lblPokeBox4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lblPokeBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPokeBox4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPokeBox4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPokeBox4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblPokeBox1MousePressed(evt);
            }
        });

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

        lblPokedexName.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
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
                    .addComponent(lblPokedexName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        btnNextPage.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnNextPage.setText(">");
        buttonGroup1.add(btnNextPage);
        btnNextPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNextPageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNextPageMouseExited(evt);
            }
        });
        btnNextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextPageActionPerformed(evt);
            }
        });

        btnPreviousPage.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnPreviousPage.setText("<");
        buttonGroup1.add(btnPreviousPage);
        btnPreviousPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPreviousPageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPreviousPageMouseExited(evt);
            }
        });
        btnPreviousPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousPageActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HTTPkmon");

        txtBuscador.setBackground(new java.awt.Color(153, 0, 255));
        txtBuscador.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtBuscador.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscador.setToolTipText("Busca un Pok??mon por su nombre exacto o su n??mero de la pok??dex");
        txtBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscadorKeyTyped(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        buttonGroup1.add(btnBuscar);
        btnBuscar.setOpaque(false);
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarMouseExited(evt);
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblError.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 255, 255));
        lblError.setText("No se ha encontrado el Pok??mon especificado.");

        btnFight.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnFight.setForeground(new java.awt.Color(0, 0, 0));
        btnFight.setText("A pelear!");
        buttonGroup1.add(btnFight);
        btnFight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFightMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFightMouseExited(evt);
            }
        });
        btnFight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFightActionPerformed(evt);
            }
        });

        lblTeamSize.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblTeamSize.setForeground(new java.awt.Color(255, 255, 255));
        lblTeamSize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        chkTeamSelector.setBackground(new java.awt.Color(102, 0, 204));
        chkTeamSelector.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        chkTeamSelector.setForeground(new java.awt.Color(255, 255, 255));
        chkTeamSelector.setText("Modo selecci??n de equipo.");
        chkTeamSelector.setToolTipText("Entra en modo selecci??n para crear tu propio equipo, con solo un click!");
        chkTeamSelector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                chkTeamSelectorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                chkTeamSelectorMouseExited(evt);
            }
        });

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
                        .addComponent(btnPreviousPage, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNextPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paneDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(paneContentPaneLayout.createSequentialGroup()
                        .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTeamSize, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkTeamSelector)
                    .addComponent(btnFight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        paneContentPaneLayout.setVerticalGroup(
            paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneContentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(paneContentPaneLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblError))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(paneContentPaneLayout.createSequentialGroup()
                        .addComponent(panePokedex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPreviousPage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNextPage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(paneContentPaneLayout.createSequentialGroup()
                        .addComponent(paneDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTeamSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneContentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneContentPaneLayout.createSequentialGroup()
                        .addComponent(chkTeamSelector)
                        .addGap(20, 20, 20)
                        .addComponent(btnFight, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        lblTeamSize.setVisible(false);
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
                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnPokemonMouseEntered(evt);
                    }

                    @Override
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnPokemonMouseExited(evt);
                    }

                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        if (evt.getClickCount() == 2) {
                            setCursor(new Cursor(Cursor.WAIT_CURSOR));
                            showInfo(evt);
                        }
                        if (chkTeamSelector.isSelected()) {
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
                lblError.setText("No se ha encontrado el Pok??mon especificado.");
                lblError.setVisible(true);
            }
        } else {
            lblError.setText("Introduce el nombre o el id del pokemon");
            lblError.setVisible(true);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnFightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFightActionPerformed
        if (equipoPJ.size() == 6) {
            lblError.setVisible(false);
            lblTeamSize.setVisible(false);
            ChooseMoveDialog cmd = new ChooseMoveDialog(equipoPJ);
            cmd.setVisible(true);
        } else {
            lblTeamSize.setVisible(true);
            lblTeamSize.setText("El equipo debe ser de 6");
        }
    }//GEN-LAST:event_btnFightActionPerformed

    private void btnBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnBuscarMouseEntered

    private void btnBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnBuscarMouseExited

    private void btnFightMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFightMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnFightMouseEntered

    private void btnFightMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFightMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnFightMouseExited

    private void btnNextPageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextPageMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnNextPageMouseEntered

    private void btnNextPageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextPageMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnNextPageMouseExited

    private void btnPreviousPageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPreviousPageMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnPreviousPageMouseEntered

    private void btnPreviousPageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPreviousPageMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnPreviousPageMouseExited

    private void chkTeamSelectorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkTeamSelectorMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_chkTeamSelectorMouseEntered

    private void chkTeamSelectorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkTeamSelectorMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_chkTeamSelectorMouseExited

    private void lblPokeBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokeBox1MouseClicked
        try {
            if (evt.getClickCount() <= 1) {
                if (cajaOcupada.get(0)) {
                    cajaOcupada.set(0, false);
                    BufferedImage img = ImageIO.read(new File("src/psp/assets/pokeball96.jpg"));
                    lblPokeBox1.setIcon(resizImageIcon(img, 96));
                    equipoPJ.set(0, null);
                    contador--;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblPokeBox1MouseClicked

    private void lblPokeBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokeBox2MouseClicked
        try {
            if (evt.getClickCount() <= 1) {
                if (cajaOcupada.get(1)) {
                    cajaOcupada.set(1, false);
                    BufferedImage img = ImageIO.read(new File("src/psp/assets/pokeball96.jpg"));
                    lblPokeBox2.setIcon(resizImageIcon(img, 96));
                    equipoPJ.set(1, null);
                    contador--;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblPokeBox2MouseClicked

    private void lblPokeBox3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokeBox3MouseClicked
        try {
            if (evt.getClickCount() <= 1) {
                if (cajaOcupada.get(2)) {
                    cajaOcupada.set(2, false);
                    BufferedImage img = ImageIO.read(new File("src/psp/assets/pokeball96.jpg"));
                    lblPokeBox3.setIcon(resizImageIcon(img, 96));
                    equipoPJ.set(2, null);
                    contador--;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblPokeBox3MouseClicked

    private void lblPokeBox4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokeBox4MouseClicked
        try {
            if (evt.getClickCount() <= 1) {
                if (cajaOcupada.get(3)) {
                    cajaOcupada.set(3, false);
                    BufferedImage img = ImageIO.read(new File("src/psp/assets/pokeball96.jpg"));
                    lblPokeBox4.setIcon(resizImageIcon(img, 96));
                    equipoPJ.set(3, null);
                    contador--;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblPokeBox4MouseClicked

    private void lblPokeBox5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokeBox5MouseClicked
        try {
            if (evt.getClickCount() <= 1) {
                if (cajaOcupada.get(4)) {
                    cajaOcupada.set(4, false);
                    BufferedImage img = ImageIO.read(new File("src/psp/assets/pokeball96.jpg"));
                    lblPokeBox5.setIcon(resizImageIcon(img, 96));
                    equipoPJ.set(4, null);
                    contador--;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblPokeBox5MouseClicked

    private void lblPokeBox6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokeBox6MouseClicked
        try {
            if (evt.getClickCount() <= 1) {
                if (cajaOcupada.get(5)) {
                    cajaOcupada.set(5, false);
                    BufferedImage img = ImageIO.read(new File("src/psp/assets/pokeball96.jpg"));
                    lblPokeBox6.setIcon(resizImageIcon(img, 96));
                    equipoPJ.set(5, null);
                    contador--;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblPokeBox6MouseClicked

    private void lblPokeBox1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokeBox1MouseEntered
        if (chkTeamSelector.isSelected()) {
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }//GEN-LAST:event_lblPokeBox1MouseEntered

    private void lblPokeBox1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokeBox1MouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lblPokeBox1MouseExited

    private void lblPokeBox2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokeBox2MouseEntered
        if (chkTeamSelector.isSelected()) {
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }//GEN-LAST:event_lblPokeBox2MouseEntered

    private void lblPokeBox2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokeBox2MouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lblPokeBox2MouseExited

    private void lblPokeBox3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokeBox3MouseEntered
        if (chkTeamSelector.isSelected()) {
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }//GEN-LAST:event_lblPokeBox3MouseEntered

    private void lblPokeBox3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokeBox3MouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lblPokeBox3MouseExited

    private void lblPokeBox4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokeBox4MouseEntered
        if (chkTeamSelector.isSelected()) {
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }//GEN-LAST:event_lblPokeBox4MouseEntered

    private void lblPokeBox4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokeBox4MouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lblPokeBox4MouseExited

    private void lblPokeBox5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokeBox5MouseEntered
        if (chkTeamSelector.isSelected()) {
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }//GEN-LAST:event_lblPokeBox5MouseEntered

    private void lblPokeBox5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokeBox5MouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lblPokeBox5MouseExited

    private void lblPokeBox6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokeBox6MouseEntered
        if (chkTeamSelector.isSelected()) {
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }//GEN-LAST:event_lblPokeBox6MouseEntered

    private void lblPokeBox6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokeBox6MouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lblPokeBox6MouseExited

    private void lblPokeBox2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokeBox2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblPokeBox2MousePressed

    private void lblPokeBox1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPokeBox1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblPokeBox1MousePressed

    private Pokemon searchPokemon() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        Pokemon pokemon = new Pokemon();
        try {
            HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/" + txtBuscador.getText().toLowerCase().replace(' ', '-'));

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
        if (evt.getSource() instanceof JLabel) {
            JLabel label = (JLabel) evt.getSource();
            
            if (contador < 6) {
                for(int i = 0; i < equipoPJ.size(); i++) {
                    if(equipoPJ.get(i) == null) {
                        equipoPJ.set(i, pokemons.get(Integer.parseInt(label.getText())));
                        contador++;
                        break;
                    }
                }
                
                for (int i = 0; i < cajaOcupada.size(); i++) {
                    if (cajaOcupada.get(i) == false) {
                        cajaPokemon.get(i).setIcon(icons96.get(Integer.parseInt(label.getText())));
                        cajaOcupada.set(i, true);
                        return;
                    }
                }

                repaint();
            } else {
                lblTeamSize.setVisible(true);
                lblTeamSize.setText("Ya tienes 6 pokemons en tu equipo");
            }
        }
    }

    public void teElijoATiDialog(Pokemon pokemon, ImageIcon icon) {
        for(int i = 0; i < equipoPJ.size(); i++) {
            if(equipoPJ.get(i) == null && contador < 6) {
                equipoPJ.set(i, pokemon);
                contador++;
                break;
            }
        }
        
        for (int i = 0; i < cajaOcupada.size(); i++) {
            if (cajaOcupada.get(i) == false) {
                cajaPokemon.get(i).setIcon(icon);
                cajaOcupada.set(i, true);
                return;
            }
        }

        repaint();
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
    private javax.swing.JButton btnFight;
    private javax.swing.JButton btnNextPage;
    private javax.swing.JButton btnPreviousPage;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkTeamSelector;
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
    private javax.swing.JLabel lblTeamSize;
    private javax.swing.JPanel paneContentPane;
    private javax.swing.JPanel paneDescription;
    private javax.swing.JPanel panePokedex;
    private javax.swing.JPanel paneTypes;
    private javax.swing.JTextField txtBuscador;
    // End of variables declaration//GEN-END:variables
}
