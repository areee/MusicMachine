package musicmachine.ui.textUI;

import java.io.IOException;
import java.util.Scanner;
import musicmachine.logic.Lukija;
import musicmachine.logic.Sovelluslogiikka;
import musicmachine.ui.Kayttoliittyma;

public class TekstiKayttoliittyma implements Kayttoliittyma {

    private boolean tiedostoAsetettu;
    private Lukija lukija;
    private Sovelluslogiikka sovelluslogiikka;

    public TekstiKayttoliittyma() {
        this.lukija = new Lukija();
        this.sovelluslogiikka = new Sovelluslogiikka();
    }

    @Override
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

                        // jos komento joko kysymysmerkki tai tyhjä rivinvaihto, tulosta ohje:
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
                    } catch (Exception e) {
                        System.out.println(virheellinenTiedosto(e));
                    }

                    break;
                case "2":
                    if (tiedostoAsetettu) {
                        System.out.println(toistaMusiikkia() + "\n");
                        sovelluslogiikka.toista();
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

    public String suljeOhjelma() {
        return "Ohjelma sulkeutuu.";
    }

    public String valitseMusiikkitiedosto() {
        return komennot(1) + "\n(valitse \"?\", jos haluat ohjeen):";
    }

    public String ohje() {
        return "Anna tiedostonimi muodossa\n"
                + "\"/Users/ylhaart/Music/Elastinen_Eteen ja ylos.wav\"\n"
                + "tai \"/Users/ylhaart/Music/Rally_3D_title_music.mid\"";
    }

    public String tiedostoaEiVoidaToistaa() {
        return "Virhe! Et ole valinnut musiikkitiedostoa toistettavaksi.";
    }

    public String toistaMusiikkia() {
        return "Toistetaan...";
    }

    public String asetaMusiikkiTauolle() {
        return "Tauko\n";
    }

    public String lopetaToisto() {
        return "Toisto lopetettu.";
    }

    public String virheellinenTiedosto(Exception e) {
        return "Virheellinen tiedostopolku!\n"
                + e.getLocalizedMessage();
    }

    public String tiedostonTiedot() {
        return "Nimi: " + sovelluslogiikka.tiedostonimi()
                + "\nKesto: " + sovelluslogiikka.kesto() + " ms(?)\n";
    }
}
