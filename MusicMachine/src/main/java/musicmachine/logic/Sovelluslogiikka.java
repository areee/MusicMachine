package musicmachine.logic;

import java.util.Scanner;
import musicmachine.ui.TekstiKayttoliittyma;
import java.io.*;
import sun.audio.*;

public class Sovelluslogiikka {

    private String komento;
    private InputStream input;
    private AudioStream audioStream;
    private boolean tiedostoAsetettu;

    public void kaynnista(Scanner lukija) throws Exception {
        TekstiKayttoliittyma tekstiKali = new TekstiKayttoliittyma();
        tiedostoAsetettu = false;

        OUTER:
        while (true) {
            valikko(tekstiKali, lukija);

            switch (komento) {
                case "1":
                    try {
                        valitseMusiikkitiedosto(tekstiKali, lukija);
                    } catch (Exception e) {
                        virheTiedostopolussa(e);
                    }
                    break;
                case "2":
                    if (tiedostoAsetettu) {
                        toistaMusiikkia(tekstiKali);
                    } else {
                        tiedostonToistoEpaonnistui(tekstiKali);
                    }
                    break;
                case "3":
                    if (tiedostoAsetettu) {
                        asetaMusiikkiTauolle(tekstiKali);
                    } else {
                        tiedostonToistoEpaonnistui(tekstiKali);
                    }

                    break;

                case "4":
                    if (tiedostoAsetettu) {
                        lopetaToisto(tekstiKali);
                    } else {
                        tiedostonToistoEpaonnistui(tekstiKali);
                    }

                    break;

                case "x":
                    suljeOhjelma(tekstiKali);
                    break OUTER;
            }
        }

    }

    private void tiedostonToistoEpaonnistui(TekstiKayttoliittyma tekstiKali) {
        System.out.println(tekstiKali.tiedostoaEiVoidaToistaa());
    }

    private void virheTiedostopolussa(Exception e) {
        System.out.println("Virheellinen tiedostopolku!\n"
                + e.getLocalizedMessage());
    }

    private void valikko(TekstiKayttoliittyma tekstiKali,
            Scanner lukija) {
        System.out.println(tekstiKali.valikko());
        annaKomento(lukija);
    }

    private void valitseMusiikkitiedosto(TekstiKayttoliittyma tekstiKali,
            Scanner lukija) throws FileNotFoundException, IOException {
        System.out.println(tekstiKali.valitseMusiikkitiedosto());
        annaKomento(lukija);
        Musiikkitiedosto tiedosto = new Musiikkitiedosto(komento);

        input = new FileInputStream(tiedosto.getTiedosto());
        audioStream = new AudioStream(input);
        System.out.println("Tiedoston kesto: " + tiedostonKesto() + " s");
        tiedostoAsetettu = true;
    }

    private void suljeOhjelma(TekstiKayttoliittyma tekstiKali) throws IOException {
        System.out.println(tekstiKali.suljeOhjelma());
        suljeTiedosto();
    }

    private void lopetaToisto(TekstiKayttoliittyma tekstiKali) throws IOException {
        System.out.println(tekstiKali.lopetaToisto());
        suljeTiedosto();
    }

    private void asetaMusiikkiTauolle(TekstiKayttoliittyma tekstiKali) {
        System.out.println(tekstiKali.asetaMusiikkiTauolle());
        AudioPlayer.player.stop(audioStream);
    }

    private void toistaMusiikkia(TekstiKayttoliittyma tekstiKali) {
        System.out.println(tekstiKali.toistaMusiikkia());
        AudioPlayer.player.start(audioStream);
    }

    private void suljeTiedosto() throws IOException {
        AudioPlayer.player.stop(audioStream);
        audioStream.close();
        tiedostoAsetettu = false;
    }

    private void annaKomento(Scanner lukija) {
        System.out.print("> ");
        komento = lukija.nextLine();
    }

    private int tiedostonKesto() {
        return audioStream.getLength() / 85000;
    }

}
