package musicmachine.ui.graphic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import musicmachine.logic.Sovelluslogiikka;

/**
 * MusicMachinen graafisen käyttöliittymän ulkoasuun keskittyvä luokka
 */
public class GraafinenKayttoliittyma extends javax.swing.JFrame {

    private final Sovelluslogiikka sovelluslogiikka;
    private final String virhe;
    private final String epaonnistui;
    private final DefaultListModel<String> listamalli;
    private int indeksi;
    private final Timer ajastin;

    /**
     * Määrittelee graafisen käyttöliittymän muuttujat
     */
    public GraafinenKayttoliittyma() {
        initComponents();
        sovelluslogiikka = new Sovelluslogiikka();
        virhe = "VIRHE!";
        epaonnistui = "EPÄONNISTUI!";
        listamalli = new DefaultListModel();
        soittolista.setModel(listamalli);
        indeksi = -1;

        ajastin = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerActionPerformed(e);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lisaaAanitiedostoValitsija = new javax.swing.JFileChooser();
        avaaSoittolistaValitsija = new javax.swing.JFileChooser();
        tallennaSoittolistaValitsija = new javax.swing.JFileChooser();
        toistaPainike = new javax.swing.JButton();
        pysaytaPainike = new javax.swing.JButton();
        etenemissaadin = new javax.swing.JSlider();
        tilanOhjeteksti = new javax.swing.JLabel();
        tilaTeksti = new javax.swing.JLabel();
        rullausPaneeli = new javax.swing.JScrollPane();
        soittolista = new javax.swing.JList();
        valitseAanitiedostoPainike = new javax.swing.JButton();
        soittolistaTeksti = new javax.swing.JLabel();
        poistaAanitiedostoPainike = new javax.swing.JButton();
        kelaaEteenpainPainike = new javax.swing.JButton();
        kelaaTaaksepainPainike = new javax.swing.JButton();
        tallennaSoittolistaPainike = new javax.swing.JButton();
        avaaSoittolistaPainike = new javax.swing.JButton();
        tyhjennaSoittolista = new javax.swing.JButton();
        luuppiValintalaatikko = new javax.swing.JCheckBox();
        tiedostonKokonaiskesto = new javax.swing.JLabel("--:--");
        tiedostonNykyinenToistokohta = new javax.swing.JLabel("--:--");

        lisaaAanitiedostoValitsija.setApproveButtonText("Lisää");
        lisaaAanitiedostoValitsija.setCurrentDirectory(new File(System.getProperty("user.dir") + "/audio"));
        lisaaAanitiedostoValitsija.setDialogTitle("Lisää äänitiedosto...");

        avaaSoittolistaValitsija.setApproveButtonText("Avaa");
        avaaSoittolistaValitsija.setCurrentDirectory(new File(System.getProperty("user.dir")));
        avaaSoittolistaValitsija.setDialogTitle("Avaa soittolista...");

        tallennaSoittolistaValitsija.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        tallennaSoittolistaValitsija.setApproveButtonText("Tallenna");
        tallennaSoittolistaValitsija.setApproveButtonToolTipText("Tallenna soittolista tekstitiedostoksi");
        tallennaSoittolistaValitsija.setCurrentDirectory(new File(System.getProperty("user.dir")));
        tallennaSoittolistaValitsija.setDialogTitle("Tallenna soittolista...");
        tallennaSoittolistaValitsija.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        tallennaSoittolistaValitsija.getAccessibleContext().setAccessibleName("Tallenna soittolista tekstitiedostona");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MusicMachine");

        toistaPainike.setText("▶");
        toistaPainike.setToolTipText("Toista");
        toistaPainike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toistaPainikeActionPerformed(evt);
            }
        });

        pysaytaPainike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Stop-painike_suurempi.png"))); // NOI18N
        pysaytaPainike.setToolTipText("Pysäytä");
        pysaytaPainike.setEnabled(false);
        pysaytaPainike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pysaytaPainikeActionPerformed(evt);
            }
        });

        etenemissaadin.setValue(0);
        etenemissaadin.setEnabled(false);
        etenemissaadin.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                etenemissaadinStateChanged(evt);
            }
        });

        tilanOhjeteksti.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        tilanOhjeteksti.setText("TILA:");

        tilaTeksti.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        tilaTeksti.setText("VALMIS");

        soittolista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        rullausPaneeli.setViewportView(soittolista);

        valitseAanitiedostoPainike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Add-painike.png"))); // NOI18N
        valitseAanitiedostoPainike.setToolTipText("Lisää äänitiedosto...");
        valitseAanitiedostoPainike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valitseAanitiedostoPainikeActionPerformed(evt);
            }
        });

        soittolistaTeksti.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        soittolistaTeksti.setText("Soittolista:");

        poistaAanitiedostoPainike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Delete-painike.png"))); // NOI18N
        poistaAanitiedostoPainike.setToolTipText("Poista äänitiedosto");
        poistaAanitiedostoPainike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poistaAanitiedostoPainikeActionPerformed(evt);
            }
        });

        kelaaEteenpainPainike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Ff-painike.png"))); // NOI18N
        kelaaEteenpainPainike.setToolTipText("Kelaa eteenpäin");
        kelaaEteenpainPainike.setEnabled(false);
        kelaaEteenpainPainike.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kelaaEteenpainPainikeMousePressed(evt);
            }
        });
        kelaaEteenpainPainike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelaaEteenpainPainikeActionPerformed(evt);
            }
        });

        kelaaTaaksepainPainike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Rew-painike.png"))); // NOI18N
        kelaaTaaksepainPainike.setToolTipText("Kelaa taaksepäin");
        kelaaTaaksepainPainike.setEnabled(false);
        kelaaTaaksepainPainike.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kelaaTaaksepainPainikeMousePressed(evt);
            }
        });
        kelaaTaaksepainPainike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelaaTaaksepainPainikeActionPerformed(evt);
            }
        });

        tallennaSoittolistaPainike.setText("Tallenna soittolista...");
        tallennaSoittolistaPainike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tallennaSoittolistaPainikeActionPerformed(evt);
            }
        });

        avaaSoittolistaPainike.setText("Avaa soittolista...");
        avaaSoittolistaPainike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avaaSoittolistaPainikeActionPerformed(evt);
            }
        });

        tyhjennaSoittolista.setText("Tyhjennä soittolista");
        tyhjennaSoittolista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyhjennaSoittolistaActionPerformed(evt);
            }
        });

        luuppiValintalaatikko.setText("Luuppaa");
        luuppiValintalaatikko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luuppiValintalaatikkoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etenemissaadin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rullausPaneeli)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(soittolistaTeksti)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tilanOhjeteksti)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tilaTeksti))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(valitseAanitiedostoPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(poistaAanitiedostoPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tallennaSoittolistaPainike)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(avaaSoittolistaPainike)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tyhjennaSoittolista))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(tiedostonNykyinenToistokohta)
                        .addGap(119, 119, 119)
                        .addComponent(kelaaTaaksepainPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(luuppiValintalaatikko)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(toistaPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pysaytaPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kelaaEteenpainPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tiedostonKokonaiskesto)
                        .addGap(4, 4, 4)))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tilanOhjeteksti)
                    .addComponent(tilaTeksti))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soittolistaTeksti)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rullausPaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(valitseAanitiedostoPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE)
                                .addComponent(poistaAanitiedostoPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tallennaSoittolistaPainike)
                                .addComponent(avaaSoittolistaPainike)
                                .addComponent(tyhjennaSoittolista)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etenemissaadin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tiedostonNykyinenToistokohta)
                            .addComponent(tiedostonKokonaiskesto))
                        .addGap(96, 96, 96))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(luuppiValintalaatikko)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(toistaPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(kelaaTaaksepainPainike, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(kelaaEteenpainPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pysaytaPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        getAccessibleContext().setAccessibleDescription("Toista äänitiedostoja helposti");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pysaytaPainikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pysaytaPainikeActionPerformed
        if (sovelluslogiikka.isTiedostoAsetettu()) {
            try {
                lopetaToisto();
            } catch (IOException ex) {
                tilaTeksti.setText(virhe);
                System.out.println(virhe + ":\n" + ex.getLocalizedMessage());
            }
        } else {
            tilaTeksti.setText("PYSÄTYS " + epaonnistui);
        }
    }//GEN-LAST:event_pysaytaPainikeActionPerformed

    private void lopetaToisto() throws IOException {
        sovelluslogiikka.lopeta();

        tilaTeksti.setText("PYSÄYTETTY");
        tiedostonKokonaiskesto.setText("--:--");
        tiedostonNykyinenToistokohta.setText("--:--");
        sovelluslogiikka.setTiedostoAsetettu(false);
        sovelluslogiikka.setTiedostoaToistetaan(false);
        etenemissaadin.setEnabled(false);
        pysaytaPainike.setEnabled(false);
        kelaaEteenpainPainike.setEnabled(false);
        kelaaTaaksepainPainike.setEnabled(false);
    }

    private void asetaTauolle() {
        ajastin.stop();
        sovelluslogiikka.tauko();
        toistaPainike.setText("▶");
        toistaPainike.setToolTipText("Toista");
        if (!sovelluslogiikka.onkoKlippiAktiivinen()) {
            tilaTeksti.setText("TOISTA UUDELLEEN");
        } else {
            tilaTeksti.setText("TAUKO");
        }
        sovelluslogiikka.setTiedostoaToistetaan(false);
    }

    private void toistaPainikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toistaPainikeActionPerformed
        // tiedosto jo valmiiksi valittuna ja asetettuna, mutta ei vielä toisteta:
        if (sovelluslogiikka.isTiedostoValittu() && sovelluslogiikka.isTiedostoAsetettu()
                && !sovelluslogiikka.isTiedostoaToistetaan()) {
            toistaTiedostoa();
        } // tiedosto jo valittu, muttei se ole vielä asetettu eikä sitä toisteta:
        else if (!sovelluslogiikka.isTiedostoaToistetaan() && sovelluslogiikka.isTiedostoValittu()
                && !sovelluslogiikka.isTiedostoAsetettu()) {
            try {
                asetaTiedostoToistovalmiiksi();
                toistaTiedostoa();

            } catch (IOException ex) {
                tilaTeksti.setText(virhe);
                System.out.println(virhe + ":\n" + ex.getLocalizedMessage());
            }
        } else if (sovelluslogiikka.isTiedostoaToistetaan()) {
            asetaTauolle();
        } else {
            tilaTeksti.setText("TOISTO " + epaonnistui);
        }
    }//GEN-LAST:event_toistaPainikeActionPerformed

    private void asetaTiedostoToistovalmiiksi() throws IOException {
        // Asetetaan valittu tiedosto toistovalmiiksi:
        indeksi = valitunTiedostonIndeksi();
        String tiedostopolku = listamalli.get(indeksi);

        try {
            sovelluslogiikka.valitseTiedosto(tiedostopolku);
            sovelluslogiikka.setTiedostoAsetettu(true);
            tiedostonKokonaiskesto.setText(sovelluslogiikka.
                    kestoMinuutteinaJaSekunteina(sovelluslogiikka.kestoSekunteina()));

            etenemissaadin.setEnabled(true);
            etenemissaadin.setMinimum(0);
            etenemissaadin.setMaximum(sovelluslogiikka.getAanitiedostonKesto());
            etenemissaadin.setValue(0);

            pysaytaPainike.setEnabled(true);
            kelaaEteenpainPainike.setEnabled(true);
            kelaaTaaksepainPainike.setEnabled(true);

        } catch (LineUnavailableException ex) {
            tilaTeksti.setText(virhe);
            System.out.println(virhe + ":\n" + ex.getLocalizedMessage());
        } catch (UnsupportedAudioFileException ex) {
            tilaTeksti.setText(epaonnistui + " TIEDOSTO EI TUETTU");
            System.out.println(epaonnistui + ":\n" + ex.getLocalizedMessage());
        }
    }

    private void toistaTiedostoa() {
        try {
            // Toistetaan toistovalmiiksi asetettu tiedosto:
            sovelluslogiikka.toista();
            ajastin.start();
            toistaPainike.setText("▮▮");
            toistaPainike.setToolTipText("Tauko");
            tilaTeksti.setText("TOISTETAAN...");
            sovelluslogiikka.setTiedostoaToistetaan(true);

        } catch (LineUnavailableException | IOException ex) {
            tilaTeksti.setText(virhe);
            System.out.println(virhe + ":\n" + ex.getLocalizedMessage());
        }

    }

    // Valitse tiedosto ja lisää se soittolistaan:
    private void valitseAanitiedostoPainikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valitseAanitiedostoPainikeActionPerformed
        lisaaAanitiedostoValitsija.setFileFilter(asetaAanitiedostonFiltteri());
        int valinta = lisaaAanitiedostoValitsija.showOpenDialog(this);
        if (valinta == JFileChooser.APPROVE_OPTION) {
            lisaaTiedostoSoittolistalle();
        } else {
            tilaTeksti.setText("TIEDOSTON VALINTA KESKEYTETTY");
        }
    }//GEN-LAST:event_valitseAanitiedostoPainikeActionPerformed

    private void lisaaTiedostoSoittolistalle() {
        File tiedosto = lisaaAanitiedostoValitsija.getSelectedFile();
        listamalli.addElement(tiedosto.getAbsolutePath());
        asetaViimeisinTiedostoValituksi();
    }

    /**
     * Metodi asettaa soittolistalla viimeisimpänä olevan äänitiedoston
     * valituksi
     */
    public void asetaViimeisinTiedostoValituksi() {
        indeksi = listamalli.getSize() - 1;
        valitseViimeisinTiedosto(indeksi);
        sovelluslogiikka.setTiedostoValittu(true);
        tilaTeksti.setText("TIEDOSTO VALITTU");
    }

    /**
     * Metodi palauttaa filtterinä ohjelman tukemat äänitiedostomuodot. Tuetut
     * tiedostomuodot ovat WAV, MIDI ja AIFF.
     *
     * @return new FileNameExtensionFilter("Äänitiedostot (*.wav, *.mid,
     * *.aif)", "wav", "mid", "aif")
     */
    public FileNameExtensionFilter asetaAanitiedostonFiltteri() {
        return new FileNameExtensionFilter(
                "Äänitiedostot (*.wav, *.mid, *.aif)", "wav", "mid", "aif");
    }

    private void poistaAanitiedostoPainikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poistaAanitiedostoPainikeActionPerformed
        if (listamalli.isEmpty()) {
            tilaTeksti.setText(epaonnistui + " SOITTOLISTA ON TYHJÄ");
        } else {
            indeksi = poistaTiedostoSoittolistalta();

            // Valitsee edellisen rivin poiston jälkeen, jos soittolista ei tyhjä:
            int koko = listamalli.getSize();
            if (koko != 0) {
                indeksi = pienennaIndeksiaYhdella(koko);
                valitseViimeisinTiedosto(indeksi);
            }
        }
    }//GEN-LAST:event_poistaAanitiedostoPainikeActionPerformed

    private void kelaaEteenpainPainikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelaaEteenpainPainikeActionPerformed
        kelaaEteenpain();
    }//GEN-LAST:event_kelaaEteenpainPainikeActionPerformed

    private void kelaaEteenpain() {
        sovelluslogiikka.asetaToistokohta(sovelluslogiikka.getAanenSijainti() + 50);
    }

    private void kelaaTaaksepainPainikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelaaTaaksepainPainikeActionPerformed
        kelaaTaaksepain();
    }//GEN-LAST:event_kelaaTaaksepainPainikeActionPerformed

    private void kelaaTaaksepain() {
        sovelluslogiikka.asetaToistokohta(sovelluslogiikka.getAanenSijainti() - 50);
    }

    private void tallennaSoittolistaPainikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tallennaSoittolistaPainikeActionPerformed
        tallennaSoittolistaValitsija.setFileFilter(asetaTekstitiedostoFiltteri());
        int valinta = this.tallennaSoittolistaValitsija.showSaveDialog(this);

        if (valinta == JFileChooser.APPROVE_OPTION) {

            File tiedosto = tallennaSoittolistaValitsija.getSelectedFile();

            if (!tiedosto.getName().endsWith(".txt")) {
                String tiedostopolku = tiedosto.getAbsolutePath();
                tiedosto = new File(tiedostopolku + ".txt");
            }
            try (FileWriter soittolistanKirjoittaja = new FileWriter(tiedosto)) {
                for (int i = 0; i < listamalli.size(); i++) {
                    soittolistanKirjoittaja.write(listamalli.get(i));
                    if (i != listamalli.size() - 1) {
                        soittolistanKirjoittaja.write("\n");
                    }
                }
                soittolistanKirjoittaja.close();
                tilaTeksti.setText("SOITTOLISTA TALLENNETTU");
            } catch (IOException ex) {
                virheViesti();
            }
        } else {
            tilaTeksti.setText("SOITTOLISTAN TALLENNUS KESKEYTETTY");
        }
    }//GEN-LAST:event_tallennaSoittolistaPainikeActionPerformed

    /**
     * Metodi palauttaa filtterinä ohjelman tukeman soittolistamuodon. Tuettu
     * tiedostomuoto on tekstitiedosto (*.txt).
     *
     * @return new FileNameExtensionFilter("Tekstitiedostot (*.txt)", "txt")
     */
    public FileNameExtensionFilter asetaTekstitiedostoFiltteri() {
        return new FileNameExtensionFilter("Tekstitiedostot (*.txt)", "txt");
    }

    private void avaaSoittolistaPainikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avaaSoittolistaPainikeActionPerformed
        avaaSoittolistaValitsija.setFileFilter(asetaTekstitiedostoFiltteri());
        int valinta = avaaSoittolistaValitsija.showOpenDialog(this);
        if (valinta == JFileChooser.APPROVE_OPTION) {
            avaaSoittolista();
        } else {
            tilaTeksti.setText("SOITTOLISTAN VALINTA KESKEYTETTY");
        }
    }//GEN-LAST:event_avaaSoittolistaPainikeActionPerformed

    private void tyhjennaSoittolistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tyhjennaSoittolistaActionPerformed
        listamalli.clear();
        tilaTeksti.setText("SOITTOLISTA TYHJENNETTY");
    }//GEN-LAST:event_tyhjennaSoittolistaActionPerformed

    private void luuppiValintalaatikkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luuppiValintalaatikkoActionPerformed
        if (luuppiValintalaatikko.isSelected()) {
            sovelluslogiikka.setLuuppausPaalla(true);
        } else {
            sovelluslogiikka.setLuuppausPaalla(false);
        }
    }//GEN-LAST:event_luuppiValintalaatikkoActionPerformed

    private void etenemissaadinStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_etenemissaadinStateChanged
        if (!etenemissaadin.getValueIsAdjusting()) {
            int toistokohta = etenemissaadin.getValue();

            int kestoSekunteina = toistokohta / 1000;
            String kestoMinuutteinaJaSekunteina = sovelluslogiikka.
                    kestoMinuutteinaJaSekunteina(kestoSekunteina);

            int sekunninSadasosat = (toistokohta % 1000) / 100;

            tiedostonNykyinenToistokohta.setText(kestoMinuutteinaJaSekunteina
                    + ":" + sekunninSadasosat);

            if (toistokohta != sovelluslogiikka.getAanenSijainti()) {
                sovelluslogiikka.asetaToistokohta(toistokohta);
            }
        }
    }//GEN-LAST:event_etenemissaadinStateChanged

    private void kelaaEteenpainPainikeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kelaaEteenpainPainikeMousePressed
        while (kelaaEteenpainPainike.isSelected()) {
            kelaaEteenpain();
        }
    }//GEN-LAST:event_kelaaEteenpainPainikeMousePressed

    private void kelaaTaaksepainPainikeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kelaaTaaksepainPainikeMousePressed
        while (kelaaTaaksepainPainike.isSelected()) {
            kelaaTaaksepain();
        }
    }//GEN-LAST:event_kelaaTaaksepainPainikeMousePressed

    /**
     * Metodi asettaa etenemissäätimen haluttuun kohtaan
     *
     * @param kohta haluttu kohta, johon halutaan siirtyä
     */
    public void asetaEtenemissaadinHaluttuunKohtaan(int kohta) {
        etenemissaadin.setValue(kohta);
    }

    private void avaaSoittolista() {
        try {
            File tiedosto = avaaSoittolistaValitsija.getSelectedFile();

            try (Scanner lukija = new Scanner(tiedosto, "UTF-8")) {
                while (lukija.hasNextLine()) {
                    String rivi = lukija.nextLine();
                    listamalli.addElement(rivi);
                }
            }
            asetaViimeisinTiedostoValituksi();
        } catch (FileNotFoundException ex) {
            virheViesti();
        }
    }

    /**
     * Metodi asettaa tilaTeksti-tekstikentän arvoksi virheviestin
     */
    public void virheViesti() {
        this.tilaTeksti.setText(virhe);
    }

    /**
     * Metodi pienentää soittolistan kappaleindeksiä yhdellä.
     *
     * @param koko soittolistan nykyinen koko
     * @return indeksin arvo
     */
    public int pienennaIndeksiaYhdella(int koko) {
        if (indeksi == koko) {
            indeksi--;
        }
        return indeksi;
    }

    private void valitseViimeisinTiedosto(int indeksi) {
        soittolista.setSelectedIndex(indeksi);
        soittolista.ensureIndexIsVisible(indeksi);
    }

    private int poistaTiedostoSoittolistalta() {
        indeksi = valitunTiedostonIndeksi();
        listamalli.remove(indeksi);
        tilaTeksti.setText("TIEDOSTO POISTETTU SOITTOLISTALTA");
        return indeksi;
    }

    private int valitunTiedostonIndeksi() {
        return soittolista.getSelectedIndex();
    }

    /**
     * Metodi siirtää etenemissäädintä äänitiedoston soidessa
     *
     */
    void ajastimenToimet() {
        if (sovelluslogiikka.onkoKlippiAktiivinen()) {
            sovelluslogiikka.tiedostonToistokohdanPaivittyminen();
            etenemissaadin.setValue(sovelluslogiikka.getAanenSijainti());
        } else {
            nollaa();
        }
    }

    /**
     * Metodi nollaa äänitiedoston ja etenemissäätimen
     */
    public void nollaa() {
        sovelluslogiikka.nollaaKlippi();
        sovelluslogiikka.setAanenSijainti(0);
        etenemissaadin.setValue(0);
        if (sovelluslogiikka.isLuuppausPaalla()) {
            toistaTiedostoa();
        } else {
            asetaTauolle();
        }
    }

    private void timerActionPerformed(java.awt.event.ActionEvent evt) {
        ajastimenToimet();
    }

    /**
     * GraafinenKayttoliittyma-luokkaa voidaan käyttää tarvittaessa pääluokkana
     *
     * @param args mahdolliset argumentit taulukoituna
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
            java.util.logging.Logger.getLogger(GraafinenKayttoliittyma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraafinenKayttoliittyma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraafinenKayttoliittyma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraafinenKayttoliittyma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GraafinenKayttoliittyma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton avaaSoittolistaPainike;
    private javax.swing.JFileChooser avaaSoittolistaValitsija;
    private javax.swing.JSlider etenemissaadin;
    private javax.swing.JButton kelaaEteenpainPainike;
    private javax.swing.JButton kelaaTaaksepainPainike;
    private javax.swing.JFileChooser lisaaAanitiedostoValitsija;
    private javax.swing.JCheckBox luuppiValintalaatikko;
    private javax.swing.JButton poistaAanitiedostoPainike;
    private javax.swing.JButton pysaytaPainike;
    private javax.swing.JScrollPane rullausPaneeli;
    private javax.swing.JList soittolista;
    private javax.swing.JLabel soittolistaTeksti;
    private javax.swing.JButton tallennaSoittolistaPainike;
    private javax.swing.JFileChooser tallennaSoittolistaValitsija;
    private javax.swing.JLabel tiedostonKokonaiskesto;
    private javax.swing.JLabel tiedostonNykyinenToistokohta;
    private javax.swing.JLabel tilaTeksti;
    private javax.swing.JLabel tilanOhjeteksti;
    private javax.swing.JButton toistaPainike;
    private javax.swing.JButton tyhjennaSoittolista;
    private javax.swing.JButton valitseAanitiedostoPainike;
    // End of variables declaration//GEN-END:variables
}
