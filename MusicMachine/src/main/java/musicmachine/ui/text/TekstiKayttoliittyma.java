package musicmachine.ui.text;

import java.io.IOException;
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
     * @throws java.io.IOException
     */
    public void kaynnista() throws IOException {

        OUTER:
        while (true) {
            System.out.println(valikko(6));
            System.out.print(lukija);
            String komento = this.lukija.annaKomento();

            switch (komento) {
                case "1":
                    while (true) {
                        System.out.println("\n" + valitseAanitiedosto());
                        System.out.print(lukija);
                        komento = this.lukija.annaKomento();

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
                            System.out.println(toistaAanitiedostoa() + "\n");
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
                        System.out.println(asetaAanitiedostoTauolle());
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
     * @param montakoValikonKohtaa
     * @return palautettavaTeksti
     */
    public String valikko(int montakoValikonKohtaa) {
        String nimi = "MusicMachine";
        String toiminnot = "Valitse toiminto:";

        String palautettavaTeksti = "*** " + nimi + " ***\n"
                + toiminnot + "\n";
        for (int i = 1; i <= montakoValikonKohtaa; i++) {
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
            return "Valitse toistettava äänitiedosto";
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
     * Metodi äänitieodoston valintailmoitukselle
     *
     * @return komennot(1) + "\n(valitse \"?\", jos haluat ohjeen):"
     */
    public String valitseAanitiedosto() {
        return komennot(1) + "\n(syötä \"?\" tai [Enter], jos haluat ohjeen):";
    }

    /**
     * Metodi äänitiedoston valintaohjeelle
     *
     * @return ohje äänitiedoston valitsemiseen
     */
    public String ohje() {
        return "\nLinuxia tai Macia käyttäessäsi anna tiedostopolku muodossa\n"
                + "\"audio/tiedostonimi.tiedostomuoto\"\n"
                + "(esimerkiksi \"audio/Havetkaa!.aif\").\n"
                + "(Voit myös syöttää tiedostopolun muodossa\n"
                + "\"/Users/kayttajanimi/kansio/tiedostonimi.tiedostomuoto\".)\n"
                + "Ohjelma tukee WAV, MIDI ja AIFF-tiedostoja.";
    }

    /**
     * Metodi virheviestille
     *
     * @return "Virhe! Et ole valinnut äänitiedostoa toistettavaksi."
     */
    public String tiedostoaEiVoidaToistaa() {
        return "Virhe! Et ole valinnut äänitiedostoa toistettavaksi.";
    }

    /**
     * Metodi toistoilmoitukselle
     *
     * @return "Toistetaan..."
     */
    public String toistaAanitiedostoa() {
        return "Toistetaan...";
    }

    /**
     * Metodi toistoilmoitukselle
     *
     * @return "Tauko\n"
     */
    public String asetaAanitiedostoTauolle() {
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

    /**
     * Metodi äänitiedoston tietojen tulostamiseen
     *
     * @return nimi, tiedostopolku, kesto
     */
    public String tiedostonTiedot() {
        return "Nimi: " + sovelluslogiikka.tiedostonimi()
                + "\nTiedostopolku: " + sovelluslogiikka.tiedostopolku()
                + "\nKesto: " + sovelluslogiikka.kestoSekunteina() + " sekuntia\n";
    }
}
