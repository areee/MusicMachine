package musicmachine.ui.textUI;

import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import musicmachine.logic.Lukija;
import musicmachine.logic.Sovelluslogiikka;

/**
 * MusicMachinen tekstikäyttöliittymän ulkoasuun keskittyvä luokka
 */
public class TekstiKayttoliittyma {

    private boolean tiedostoAsetettu;
    private final Lukija lukija;
    private final Sovelluslogiikka sovelluslogiikka;

    /**
     * Määrittelee tekstikäyttöliittymän muuttujat
     */
    public TekstiKayttoliittyma() {
        this.lukija = new Lukija();
        this.sovelluslogiikka = new Sovelluslogiikka();
    }

    /**
     * Käynnistää tekstipohjaisen käyttöliittymän
     *
     * @param lukija käyttäjän kirjoittamia valintoja seuraava skanneri
     * @throws java.io.IOException
     */
    public void kaynnista(Scanner lukija) throws IOException {

        OUTER:
        while (true) {
            System.out.println(valikko());
            String komento = this.lukija.annaKomento(lukija);

            switch (komento) {
                case "1":
                    while (true) {
                        System.out.println("\n" + valitseMusiikkitiedosto());
                        komento = this.lukija.annaKomento(lukija);

                        // jos komento joko kysymysmerkki tai tyhjä rivinvaihto,
                        // tulosta ohje:
                        if (komento.equals("?") || komento.equals("")) {
                            System.out.println(ohje());
                        } else {
                            System.out.println("");
                            break;
                        }
                    }

                    try {
                        sovelluslogiikka.valitseTiedosto(komento);
                        tiedostoAsetettu = true;
                    } catch (IOException | LineUnavailableException |
                            UnsupportedAudioFileException e) {
                        System.out.println(virheellinenTiedosto(e));
                    }

                    break;
                case "2":
                    if (tiedostoAsetettu) {
                        try {
                            System.out.println(toistaMusiikkia() + "\n");
                            sovelluslogiikka.toista();
                        } catch (LineUnavailableException ex) {
                            tiedostonToistoEpaonnistui();
                        }
                    } else {
                        tiedostonToistoEpaonnistui();
                    }

                    break;
                case "3":
                    if (tiedostoAsetettu) {
                        System.out.println(asetaMusiikkiTauolle());
                        sovelluslogiikka.tauko();
                    } else {
                        tiedostonToistoEpaonnistui();
                    }
                    break;
                case "4":
                    if (tiedostoAsetettu) {
                        System.out.println(tiedostonTiedot());
                    } else {
                        tiedostonToistoEpaonnistui();
                    }
                    break;
                case "5":
                    if (tiedostoAsetettu) {
                        System.out.println(lopetaToisto());
                        sovelluslogiikka.lopeta();
                        tiedostoAsetettu = false;
                    } else {
                        tiedostonToistoEpaonnistui();
                    }
                    break;
                case "6":
                    System.out.println(suljeOhjelma());
                    break OUTER;
            }
        }
    }

    private void tiedostonToistoEpaonnistui() {
        System.out.println(tiedostoaEiVoidaToistaa() + "\n");
    }

    /**
     * Metodi, joka tulostaa päävalikon
     *
     * @return palautettavaTeksti
     */
    public String valikko() {
        String nimi = "MusicMachine";
        String toiminnot = "Valitse toiminto:";

        String palautettavaTeksti = "*** " + nimi + " ***\n"
                + toiminnot + "\n";
        for (int i = 1; i <= 6; i++) {
            palautettavaTeksti += "  " + i + ") " + komennot(i) + "\n";
        }
        return palautettavaTeksti;
    }

    /**
     * Metodi, joka tulostaa päävalikon komennot
     *
     * @param mones monesko päävalikon kohde on kyseessä
     * @return päävalikon komento
     */
    public String komennot(int mones) {
        if (mones == 1) {
            return "Valitse toistettava musiikkitiedosto";
        } else if (mones == 2) {
            return "Toista";
        } else if (mones == 3) {
            return "Tauko";
        } else if (mones == 4) {
            return "Toistettavan tiedoston tiedot";
        } else if (mones == 5) {
            return "Lopeta toisto";
        } else {
            return "Lopeta ohjelma";
        }
    }

    /**
     * Metodi ohjelman sulkeutumisilmoitukselle
     *
     * @return "Ohjelma sulkeutuu."
     */
    public String suljeOhjelma() {
        return "Ohjelma sulkeutuu.";
    }

    /**
     * Metodi musiikkitieodoston valintailmoitukselle
     *
     * @return komennot(1) + "\n(valitse \"?\", jos haluat ohjeen):"
     */
    public String valitseMusiikkitiedosto() {
        return komennot(1) + "\n(valitse \"?\", jos haluat ohjeen):";
    }

    /**
     * Metodi musiikkitieodoston valintaohjeelle
     *
     * @return ohje musiikkitiedoston valitsemiseen
     */
    public String ohje() {
        return "Anna tiedostonimi esim. muodossa\n"
                + "\"audio/SND_4985_1.WAV\"\n"
                + "tai \"/Users/kayttajanimi/Music/tiedostonimi.mid\"";
    }

    /**
     * Metodi virheviestille
     *
     * @return "Virhe! Et ole valinnut musiikkitiedostoa toistettavaksi."
     */
    public String tiedostoaEiVoidaToistaa() {
        return "Virhe! Et ole valinnut musiikkitiedostoa toistettavaksi.";
    }

    /**
     * Metodi toistoilmoitukselle
     *
     * @return "Toistetaan..."
     */
    public String toistaMusiikkia() {
        return "Toistetaan...";
    }

    /**
     * Metodi toistoilmoitukselle
     *
     * @return "Tauko\n"
     */
    public String asetaMusiikkiTauolle() {
        return "Tauko\n";
    }

    /**
     * Metodi toiston lopetusilmoitukselle
     *
     * @return "Toisto lopetettu."
     */
    public String lopetaToisto() {
        return "Toisto lopetettu.";
    }

    /**
     * Metodi virheellisen tiedostopolun ilmoittamiseen
     *
     * @param e poikkeus
     * @return "Virheellinen tiedostopolku!\n" + e.getLocalizedMessage() + "\n"
     */
    public String virheellinenTiedosto(Exception e) {
        return "Virheellinen tiedostopolku!\n"
                + e.getLocalizedMessage() + "\n";
    }

    /** Metodi musiikkitiedoston tietojen tulostamiseen
     *
     * @return nimi, tiedostopolku, kesto
     */
    public String tiedostonTiedot() {
        return "Nimi: " + sovelluslogiikka.tiedostonimi()
                + "\nTiedostopolku: " + sovelluslogiikka.tiedostopolku()
                + "\nKesto: " + sovelluslogiikka.kestoSekunteina() + " sekuntia\n";
    }
}
