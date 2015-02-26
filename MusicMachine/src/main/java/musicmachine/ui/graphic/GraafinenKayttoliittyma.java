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
import javax.swing.JSlider;
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
    private Timer timer;

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

        timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timerActionPerformed(e);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lisaaMusatiedostoValitsija = new javax.swing.JFileChooser();
        avaaSoittolistaValitsija = new javax.swing.JFileChooser();
        tallennaSoittolistaValitsija = new javax.swing.JFileChooser();
        asetaToistorajat = new javax.swing.JFrame();
        play = new javax.swing.JButton();
        pysaytaPainike = new javax.swing.JButton();
        taukoPainike = new javax.swing.JButton();
        progress = new javax.swing.JSlider();
        tilanOhjeteksti = new javax.swing.JLabel();
        tilaTeksti = new javax.swing.JLabel();
        rullausPaneeli = new javax.swing.JScrollPane();
        soittolista = new javax.swing.JList();
        valitseTiedostoPainike = new javax.swing.JButton();
        soittolistaTeksti = new javax.swing.JLabel();
        poistaTiedostoPainike = new javax.swing.JButton();
        kelaaEteenpainPainike = new javax.swing.JButton();
        kelaaTaaksepainPainike = new javax.swing.JButton();
        tallennaSoittolistaPainike = new javax.swing.JButton();
        avaaSoittolistaPainike = new javax.swing.JButton();
        tyhjennaSoittolista = new javax.swing.JButton();
        luuppiCheckBox = new javax.swing.JCheckBox();
        tiedostonKokonaiskesto = new javax.swing.JLabel("--:--");
        time = new javax.swing.JLabel("--:--");

        lisaaMusatiedostoValitsija.setApproveButtonText("Lisää");
        lisaaMusatiedostoValitsija.setCurrentDirectory(new File(System.getProperty("user.dir")+"/audio"));
        lisaaMusatiedostoValitsija.setDialogTitle("Lisää musiikkitiedosto...");

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

        asetaToistorajat.setTitle("Aseta kappaleelle toistorajat...");

        javax.swing.GroupLayout asetaToistorajatLayout = new javax.swing.GroupLayout(asetaToistorajat.getContentPane());
        asetaToistorajat.getContentPane().setLayout(asetaToistorajatLayout);
        asetaToistorajatLayout.setHorizontalGroup(
            asetaToistorajatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        asetaToistorajatLayout.setVerticalGroup(
            asetaToistorajatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MusicMachine");

        play.setText("▶");
        play.setToolTipText("Toista");
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });

        pysaytaPainike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Stop-painike_4.png"))); // NOI18N
        pysaytaPainike.setToolTipText("Pysäytä");
        pysaytaPainike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pysaytaPainikeActionPerformed(evt);
            }
        });

        taukoPainike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Pause-painike.png"))); // NOI18N
        taukoPainike.setToolTipText("Tauko");
        taukoPainike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taukoPainikeActionPerformed(evt);
            }
        });

        progress.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                progressStateChanged(evt);
            }
        });

        tilanOhjeteksti.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        tilanOhjeteksti.setText("TILA:");

        tilaTeksti.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        tilaTeksti.setText("VALMIS");

        soittolista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        rullausPaneeli.setViewportView(soittolista);

        valitseTiedostoPainike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Add-painike.png"))); // NOI18N
        valitseTiedostoPainike.setToolTipText("Lisää musiikkitiedosto...");
        valitseTiedostoPainike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valitseTiedostoPainikeActionPerformed(evt);
            }
        });

        soittolistaTeksti.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        soittolistaTeksti.setText("Soittolista:");

        poistaTiedostoPainike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Delete-painike.png"))); // NOI18N
        poistaTiedostoPainike.setToolTipText("Poista musiikkitiedosto");
        poistaTiedostoPainike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poistaTiedostoPainikeActionPerformed(evt);
            }
        });

        kelaaEteenpainPainike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Ff-painike.png"))); // NOI18N
        kelaaEteenpainPainike.setToolTipText("Kelaa eteenpäin");
        kelaaEteenpainPainike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelaaEteenpainPainikeActionPerformed(evt);
            }
        });

        kelaaTaaksepainPainike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Rew-painike.png"))); // NOI18N
        kelaaTaaksepainPainike.setToolTipText("Kelaa taaksepäin");
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

        luuppiCheckBox.setText("Luuppaa");
        luuppiCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luuppiCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(progress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(valitseTiedostoPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(poistaTiedostoPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tallennaSoittolistaPainike)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(avaaSoittolistaPainike)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tyhjennaSoittolista))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(time)
                        .addGap(129, 129, 129)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(kelaaTaaksepainPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(play, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kelaaEteenpainPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(taukoPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pysaytaPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tiedostonKokonaiskesto)
                                .addGap(4, 4, 4)))))
                .addGap(0, 15, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(luuppiCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tilanOhjeteksti)
                    .addComponent(tilaTeksti))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soittolistaTeksti)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rullausPaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(valitseTiedostoPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE)
                        .addComponent(poistaTiedostoPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tallennaSoittolistaPainike)
                        .addComponent(avaaSoittolistaPainike)
                        .addComponent(tyhjennaSoittolista)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pysaytaPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taukoPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time)
                    .addComponent(tiedostonKokonaiskesto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(play, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kelaaTaaksepainPainike, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kelaaEteenpainPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(luuppiCheckBox))
        );

        getAccessibleContext().setAccessibleDescription("Toista musiikkia");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pysaytaPainikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pysaytaPainikeActionPerformed
        if (sovelluslogiikka.isTiedostoAsetettu()) {
            try {
                lopetaToisto();
            } catch (IOException ex) {
                tilaTeksti.setText(virhe + ex.getLocalizedMessage());
            }
        } else {
            tilaTeksti.setText("PYSÄTYS " + epaonnistui);
        }
    }//GEN-LAST:event_pysaytaPainikeActionPerformed

    private void lopetaToisto() throws IOException {
        sovelluslogiikka.lopeta();
        tilaTeksti.setText("PYSÄYTETTY");
        tiedostonKokonaiskesto.setText("--:--");
        time.setText("--:--");
        sovelluslogiikka.setTiedostoAsetettu(false);
        sovelluslogiikka.setTiedostoaToistetaan(false);
    }

    private void taukoPainikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taukoPainikeActionPerformed
        if (sovelluslogiikka.isTiedostoAsetettu() && sovelluslogiikka.isTiedostoaToistetaan()) {
            asetaTauolle();
        } else {
            tilaTeksti.setText("TAUKO " + epaonnistui);
        }
    }//GEN-LAST:event_taukoPainikeActionPerformed

    private void asetaTauolle() {
        timer.stop();
        sovelluslogiikka.tauko();
        play.setText("▶");
        play.setToolTipText("Toista");
//        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Toista-painike.png")));
        tilaTeksti.setText("TAUKO");
        sovelluslogiikka.setTiedostoaToistetaan(false);
    }

    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
        if (sovelluslogiikka.isTiedostoValittu() && sovelluslogiikka.isTiedostoAsetettu()
                && !sovelluslogiikka.isTiedostoaToistetaan()) {
            toistaTiedostoa();
        } else if (!sovelluslogiikka.isTiedostoaToistetaan() && sovelluslogiikka.isTiedostoValittu()
                && !sovelluslogiikka.isTiedostoAsetettu()) {
            try {
                asetaTiedostoToistovalmiiksi();
                if (sovelluslogiikka.isLuuppausPaalla()) {
                    sovelluslogiikka.luuppaa();
                } else {
                    toistaTiedostoa();
                }
            } catch (IOException | LineUnavailableException ex) {
                tilaTeksti.setText(virhe + ex.getLocalizedMessage());
            }
        } //        else if (sovelluslogiikka.isTiedostoaToistetaan() && !sovelluslogiikka.isLuuppausPaalla()) {
        //            sovelluslogiikka.lopetaLuuppaaminen();
        //        }
        else if (sovelluslogiikka.isTiedostoaToistetaan()) {
            asetaTauolle(); //testi, jolla voidaan pause-painike poistaa
//            tilaTeksti.setText("TIEDOSTOA TOISTETAAN JO!");
        } else {
            tilaTeksti.setText("TOISTO " + epaonnistui);
        }
    }//GEN-LAST:event_playActionPerformed

    private void asetaTiedostoToistovalmiiksi() throws IOException {
        // Asetetaan valittu tiedosto toistumaan:
        indeksi = valitunTiedostonIndeksi();
        String tiedostopolku = listamalli.get(indeksi);

        try {
            sovelluslogiikka.valitseTiedosto(tiedostopolku);
            sovelluslogiikka.setTiedostoAsetettu(true);
//            tiedostonKokonaiskesto.setText(sovelluslogiikka.
//                    kestoMinuutteinaJaSekunteina(sovelluslogiikka.kestoSekunteina()));
//            tiedostonToistokohta.setText(sovelluslogiikka.
//                    kestoMinuutteinaJaSekunteina(sovelluslogiikka.tiedostonToistokohtaSekunteina()));
//            etenemissaadin.setValue(0);

            //uutta koodia:
            progress.removeAll();
            progress = new JSlider(0, sovelluslogiikka.getAudioLength(), 0);

        } catch (LineUnavailableException ex) {
            tilaTeksti.setText(virhe);
        } catch (UnsupportedAudioFileException ex) {
            tilaTeksti.setText(epaonnistui + " TIEDOSTO EI TUETTU");
        }
    }

    private void toistaTiedostoa() {
        try {
            // Toistetaan asetettu tiedosto:
            sovelluslogiikka.toista();
            timer.start();
            play.setText("▮▮");
            play.setToolTipText("Tauko");
//            play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Pause-painike.png")));
            tilaTeksti.setText("TOISTETAAN...");
            sovelluslogiikka.setTiedostoaToistetaan(true);

        } catch (LineUnavailableException | IOException ex) {
            tilaTeksti.setText(virhe);
        }

    }

    private void toistoLuuppi() {
        while (sovelluslogiikka.isTiedostoaToistetaan()) {
            tiedostonKokonaiskesto.setText(sovelluslogiikka.
                    kestoMinuutteinaJaSekunteina(sovelluslogiikka.kestoSekunteina()));
            if (pysaytaPainike.isSelected() || taukoPainike.isSelected()) {
                break;
            }
        }
    }

    // Valitse tiedosto ja lisää se soittolistaan:
    private void valitseTiedostoPainikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valitseTiedostoPainikeActionPerformed
        lisaaMusatiedostoValitsija.setFileFilter(asetaMusatiedostonFiltteri());
        int valinta = lisaaMusatiedostoValitsija.showOpenDialog(this);
        if (valinta == JFileChooser.APPROVE_OPTION) {
            lisaaTiedostoSoittolistalle();
        } else {
            tilaTeksti.setText("TIEDOSTON VALINTA KESKEYTETTY");
        }
    }//GEN-LAST:event_valitseTiedostoPainikeActionPerformed

    private void lisaaTiedostoSoittolistalle() {
        File tiedosto = lisaaMusatiedostoValitsija.getSelectedFile();
        listamalli.addElement(tiedosto.getAbsolutePath());
        asetaViimeisinTiedostoValituksi();
    }

    /**
     * Metodi asettaa soittolistalla viimeisimpänä olevan musiikkitiedoston
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
     * @return new FileNameExtensionFilter("Musiikkitiedostot (*.wav, *.mid,
     * *.aif)", "wav", "mid", "aif")
     */
    public FileNameExtensionFilter asetaMusatiedostonFiltteri() {
        return new FileNameExtensionFilter(
                "Musiikkitiedostot (*.wav, *.mid, *.aif)", "wav", "mid", "aif");
    }

    private void poistaTiedostoPainikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poistaTiedostoPainikeActionPerformed
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
    }//GEN-LAST:event_poistaTiedostoPainikeActionPerformed

    private void kelaaEteenpainPainikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelaaEteenpainPainikeActionPerformed
        try {
            sovelluslogiikka.kelaaEteenpain();
        } catch (IOException | LineUnavailableException ex) {
            virheViesti();
        }
    }//GEN-LAST:event_kelaaEteenpainPainikeActionPerformed

    private void kelaaTaaksepainPainikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelaaTaaksepainPainikeActionPerformed
        try {
            sovelluslogiikka.kelaaTaaksepain();
        } catch (IOException | LineUnavailableException ex) {
            virheViesti();
        }
    }//GEN-LAST:event_kelaaTaaksepainPainikeActionPerformed

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

    private void luuppiCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luuppiCheckBoxActionPerformed
        if (luuppiCheckBox.isSelected()) {
            sovelluslogiikka.setLuuppausPaalla(true);
        } else {
            sovelluslogiikka.setLuuppausPaalla(false);
        }
    }//GEN-LAST:event_luuppiCheckBoxActionPerformed

    private void progressStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_progressStateChanged
//        if (!progress.getValueIsAdjusting()) {
//            try {
        int value = progress.getValue();

        time.setText(value / 1000 + "."
                + (value % 1000) / 100);

        if (value != sovelluslogiikka.getAudioPosition()) {
            progress.setValue(sovelluslogiikka.asetaToistokohta(value)); //sovelluslogiikka.asetaToistokohta(value)
        }

//                sovelluslogiikka.asetaToistokohta(valittuKohta);
//                tiedostonToistokohta.setText(sovelluslogiikka.
//                        kestoMinuutteinaJaSekunteina(sovelluslogiikka.
//                                tiedostonToistokohtaSekunteina()));
//            } catch (IOException ex) {
//                Logger.getLogger(GraafinenKayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_progressStateChanged

    /**
     * Metodi asettaa etenemissäätimen haluttuun kohtaan
     *
     * @param kohta
     */
    public void asetaEtenemissaadinHaluttuunKohtaan(int kohta) {
        progress.setValue(kohta);
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
     * @param koko
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

    void tick() {
        if (sovelluslogiikka.onkoKlippiAktiivinen()) {
            System.out.println(timer.getDelay()); //testaukseen
            sovelluslogiikka.tiedostonToistokohdanPaivittyminen();
            progress.setValue(sovelluslogiikka.getAudioPosition());
        } else {
            reset();
        }
    }

    public void reset() {
        asetaTauolle();
        sovelluslogiikka.nollaaKlippi();
        sovelluslogiikka.setAudioPosition(0);
        progress.setValue(0);
    }

    private void timerActionPerformed(java.awt.event.ActionEvent evt) {
        tick();
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
    private javax.swing.JFrame asetaToistorajat;
    private javax.swing.JButton avaaSoittolistaPainike;
    private javax.swing.JFileChooser avaaSoittolistaValitsija;
    private javax.swing.JButton kelaaEteenpainPainike;
    private javax.swing.JButton kelaaTaaksepainPainike;
    private javax.swing.JFileChooser lisaaMusatiedostoValitsija;
    private javax.swing.JCheckBox luuppiCheckBox;
    private javax.swing.JButton play;
    private javax.swing.JButton poistaTiedostoPainike;
    private javax.swing.JSlider progress;
    private javax.swing.JButton pysaytaPainike;
    private javax.swing.JScrollPane rullausPaneeli;
    private javax.swing.JList soittolista;
    private javax.swing.JLabel soittolistaTeksti;
    private javax.swing.JButton tallennaSoittolistaPainike;
    private javax.swing.JFileChooser tallennaSoittolistaValitsija;
    private javax.swing.JButton taukoPainike;
    private javax.swing.JLabel tiedostonKokonaiskesto;
    private javax.swing.JLabel tilaTeksti;
    private javax.swing.JLabel tilanOhjeteksti;
    private javax.swing.JLabel time;
    private javax.swing.JButton tyhjennaSoittolista;
    private javax.swing.JButton valitseTiedostoPainike;
    // End of variables declaration//GEN-END:variables
}
