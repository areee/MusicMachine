package musicmachine.ui;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import musicmachine.logic.Musiikkitiedosto;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class TekstiKayttoliittyma {

    private Musiikkitiedosto musiikkitiedosto;
    private InputStream input;
    private AudioStream audioStream;
    private boolean tiedostoAsetettu;

    public void kaynnistaTekstiKali(Scanner lukija) throws IOException {

        OUTER:
        while (true) {
            System.out.println(valikko());
            String komento = annaKomento(lukija);
            switch (komento) {
                case "1":

                    while (true) {
                        System.out.println(valitseMusiikkitiedosto());
                        komento = annaKomento(lukija);
                        if (komento.equals("?")) {
                            System.out.println(ohje());
                        } else {
                            System.out.println("");
                            break;
                        }
                    }
                    try {
                        musiikkitiedosto = new Musiikkitiedosto(komento);
                        input = new FileInputStream(musiikkitiedosto.getTiedosto());
                        audioStream = new AudioStream(input);
                        tiedostoAsetettu = true;
                    } catch (Exception e) {
                        System.out.println(virheellinenTiedosto(e));
                    }

                    break;
                case "2":
                    if (tiedostoAsetettu) {
                        System.out.println(toistaMusiikkia());
                        AudioPlayer.player.start(audioStream);
                    } else {
                        System.out.println(tiedostoaEiVoidaToistaa());
                    }

                    break;
                case "3":
                    if (tiedostoAsetettu) {
                        System.out.println(asetaMusiikkiTauolle());
                        AudioPlayer.player.stop(audioStream);
                    } else {
                        System.out.println(tiedostoaEiVoidaToistaa());
                    }
                    break;
                case "4":
                    if (tiedostoAsetettu) {
                        System.out.println(tiedostonTiedot());
                    } else {
                        System.out.println(tiedostoaEiVoidaToistaa());
                    }
                    break;
                case "5":
                    if (tiedostoAsetettu) {
                        System.out.println(lopetaToisto());
                        AudioPlayer.player.stop(audioStream);
                        audioStream.close();
                        tiedostoAsetettu = false;
                    } else {
                        System.out.println(tiedostoaEiVoidaToistaa());
                    }
                    break;
                case "6":
                    System.out.println(suljeOhjelma());
                    break OUTER;
            }
        }

    }

    private String annaKomento(Scanner lukija) {
        System.out.print("> ");
        return lukija.nextLine();
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
        return komennot(1) + "\n(valitse \"?\", jos haluat ohjeen):\n";
    }

    public String ohje() {
        return "Anna tiedostonimi muodossa\n"
                + "\"/Users/ylhaart/Music/Elastinen_Eteen ja ylos.wav\"\n"
                + "tai \"/Users/ylhaart/Music/Rally_3D_title_music.mid\"\n";
    }

    public String tiedostoaEiVoidaToistaa() {
        return "Virhe! Et ole valinnut musiikkitiedostoa toistettavaksi.\n";
    }

    public String toistaMusiikkia() {
        return "Toistetaan...";
    }

    public String asetaMusiikkiTauolle() {
        return "Tauko";
    }

    public String lopetaToisto() {
        return "Toisto lopetettu.";
    }

    public String virheellinenTiedosto(Exception e) {
        return "Virheellinen tiedostopolku!\n"
                + e.getLocalizedMessage();
    }

    public String tiedostonTiedot() {
        return "Nimi: " + musiikkitiedosto.getTiedosto() + "\n Kesto: " + audioStream.getLength();
    }

}
