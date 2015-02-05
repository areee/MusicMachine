package musicmachine.ui.graphicUI;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import musicmachine.logic.Sovelluslogiikka;

public class GraafinenKayttoliittyma extends javax.swing.JFrame {

    private final Sovelluslogiikka sovelluslogiikka;
//    private final String valmis;
    private final String virhe;
    private boolean tiedostoAsetettu;
    private final String epaonnistui;

    public GraafinenKayttoliittyma() {
        initComponents();
        sovelluslogiikka = new Sovelluslogiikka();
//        valmis = "VALMIS";
        virhe = "VIRHE!";
        epaonnistui = "EPÄONNISTUI!";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tiedostonValitsija = new javax.swing.JFileChooser();
        toistaPainike = new javax.swing.JButton();
        pysaytaPainike = new javax.swing.JButton();
        taukoPainike = new javax.swing.JButton();
        tiedostopolkuKentta = new javax.swing.JTextField();
        ohjeteksti = new javax.swing.JLabel();
        asetaPainike = new javax.swing.JButton();
        etenemissaadin = new javax.swing.JSlider();
        tilanOhjeteksti = new javax.swing.JLabel();
        tilaTeksti = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        soittolista = new javax.swing.JList();
        valitseTiedostoPainike = new javax.swing.JButton();

        tiedostonValitsija.setCurrentDirectory(new java.io.File("/Users/ylhaart/Music"));
        tiedostonValitsija.setDialogTitle("Valitse musiikkitiedosto...");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MusicMachine");

        toistaPainike.setIcon(new javax.swing.ImageIcon("/Users/ylhaart/Google Drive/Aineopintojen harjoitustyö – Ohjelmointi/Play-painike.png")); // NOI18N
        toistaPainike.setToolTipText("Toista");
        toistaPainike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toistaPainikeActionPerformed(evt);
            }
        });

        pysaytaPainike.setIcon(new javax.swing.ImageIcon("/Users/ylhaart/Google Drive/Aineopintojen harjoitustyö – Ohjelmointi/Stop-painike.png")); // NOI18N
        pysaytaPainike.setToolTipText("Pysäytä");
        pysaytaPainike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pysaytaPainikeActionPerformed(evt);
            }
        });

        taukoPainike.setIcon(new javax.swing.ImageIcon("/Users/ylhaart/Google Drive/Aineopintojen harjoitustyö – Ohjelmointi/Pause-painike.png")); // NOI18N
        taukoPainike.setToolTipText("Tauko");
        taukoPainike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taukoPainikeActionPerformed(evt);
            }
        });

        tiedostopolkuKentta.setToolTipText("tiedostopolku");
        tiedostopolkuKentta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiedostopolkuKenttaActionPerformed(evt);
            }
        });

        ohjeteksti.setText("Syötä musiikkitiedoston polku:");

        asetaPainike.setText("Aseta");
        asetaPainike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asetaPainikeActionPerformed(evt);
            }
        });

        etenemissaadin.setValue(0);

        tilanOhjeteksti.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        tilanOhjeteksti.setText("TILA:");

        tilaTeksti.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        tilaTeksti.setText("VALMIS");

        soittolista.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(soittolista);

        valitseTiedostoPainike.setText("Valitse tiedosto...");
        valitseTiedostoPainike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valitseTiedostoPainikeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(taukoPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(pysaytaPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tiedostopolkuKentta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valitseTiedostoPainike))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(toistaPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ohjeteksti)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(asetaPainike))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tilanOhjeteksti)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tilaTeksti)))
                        .addGap(0, 160, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(etenemissaadin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tilanOhjeteksti)
                    .addComponent(tilaTeksti))
                .addGap(12, 12, 12)
                .addComponent(ohjeteksti, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tiedostopolkuKentta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valitseTiedostoPainike))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(asetaPainike)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(etenemissaadin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(taukoPainike, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pysaytaPainike, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toistaPainike, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pysaytaPainikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pysaytaPainikeActionPerformed
        if (tiedostoAsetettu) {
            try {
                sovelluslogiikka.lopeta();
                tilaTeksti.setText("PYSÄYTETTY");
                tiedostoAsetettu = false;
            } catch (IOException ex) {
                tilaTeksti.setText(virhe);
//            Logger.getLogger(GraafinenKayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            tilaTeksti.setText(epaonnistui);
        }

    }//GEN-LAST:event_pysaytaPainikeActionPerformed

    private void asetaPainikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asetaPainikeActionPerformed
        try {
            sovelluslogiikka.valitseTiedosto(tiedostopolkuKentta.getText());
            tiedostoAsetettu = true;
            tilaTeksti.setText("TIEDOSTO ASETETTU");
        } catch (IOException ex) {
            tilaTeksti.setText(virhe);
//            Logger.getLogger(GraafinenKayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_asetaPainikeActionPerformed

    private void taukoPainikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taukoPainikeActionPerformed
        if (tiedostoAsetettu) {
            sovelluslogiikka.tauko();
            tilaTeksti.setText("TAUKO");
        } else {
            tilaTeksti.setText(epaonnistui);
        }
    }//GEN-LAST:event_taukoPainikeActionPerformed

    private void toistaPainikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toistaPainikeActionPerformed
        if (tiedostoAsetettu) {
            sovelluslogiikka.toista();
            tilaTeksti.setText("TOISTETAAN...");
        } else {
            tilaTeksti.setText(epaonnistui);
        }
    }//GEN-LAST:event_toistaPainikeActionPerformed

    private void tiedostopolkuKenttaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiedostopolkuKenttaActionPerformed

    }//GEN-LAST:event_tiedostopolkuKenttaActionPerformed

    private void valitseTiedostoPainikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valitseTiedostoPainikeActionPerformed
        FileNameExtensionFilter filtteri = new FileNameExtensionFilter(
                "WAV- ja MIDI-tiedostot", "wav", "mid");
        tiedostonValitsija.setFileFilter(filtteri);

        int returnVal = tiedostonValitsija.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            tiedostopolkuKentta.setText(tiedostonValitsija.getSelectedFile()
                    .getAbsolutePath());
            tilaTeksti.setText("TIEDOSTO VALITTU");
        } else {
            tilaTeksti.setText("TIEDOSTON VALINTA KESKEYTETTY");
        }

    }//GEN-LAST:event_valitseTiedostoPainikeActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GraafinenKayttoliittyma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton asetaPainike;
    private javax.swing.JSlider etenemissaadin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel ohjeteksti;
    private javax.swing.JButton pysaytaPainike;
    private javax.swing.JList soittolista;
    private javax.swing.JButton taukoPainike;
    private javax.swing.JFileChooser tiedostonValitsija;
    private javax.swing.JTextField tiedostopolkuKentta;
    private javax.swing.JLabel tilaTeksti;
    private javax.swing.JLabel tilanOhjeteksti;
    private javax.swing.JButton toistaPainike;
    private javax.swing.JButton valitseTiedostoPainike;
    // End of variables declaration//GEN-END:variables
}
