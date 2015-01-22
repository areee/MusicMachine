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
    private Musiikkitiedosto musiikkitiedosto;
    private TekstiKayttoliittyma tekstiKali;

    public void kaynnista(Scanner lukija) throws Exception {
        tekstiKali = new TekstiKayttoliittyma();
        tiedostoAsetettu = false;
        musiikkitiedosto = new Musiikkitiedosto();

        OUTER:
        while (true) {
            valikko(lukija);

            switch (komento) {
                case "1":
                    try {
                        valitseMusiikkitiedosto(lukija);
                    } catch (Exception e) {
                        virheTiedostopolussa(e);
                    }
                    break;
                case "2":
                    if (tiedostoAsetettu) {
                        toistaMusiikkia();
                    } else {
                        tiedostonToistoEpaonnistui();
                    }
                    break;
                case "3":
                    if (tiedostoAsetettu) {
                        asetaMusiikkiTauolle();
                    } else {
                        tiedostonToistoEpaonnistui();
                    }
                    break;

                case "4":
                    if (tiedostoAsetettu) {
                        lopetaToisto();
                    } else {
                        tiedostonToistoEpaonnistui();
                    }
                    break;

                case "x":
                    suljeOhjelma();
                    break OUTER;
            }
        }

    }

    private void tiedostonToistoEpaonnistui() {
        System.out.println(tekstiKali.tiedostoaEiVoidaToistaa());
    }

    private void virheTiedostopolussa(Exception e) {
        System.out.println("Virheellinen tiedostopolku!\n"
                + e.getLocalizedMessage());
    }

    private void valikko(Scanner lukija) {
        System.out.println(tekstiKali.valikko());
        annaKomento(lukija);
    }

    private void valitseMusiikkitiedosto(Scanner lukija)
            throws FileNotFoundException, IOException {
        System.out.println(tekstiKali.valitseMusiikkitiedosto());
        annaKomento(lukija);
        musiikkitiedosto.setTiedosto(komento);

        input = new FileInputStream(musiikkitiedosto.getTiedosto());
        audioStream = new AudioStream(input);
        System.out.println("Tiedoston kesto: " + tiedostonKesto() + " s");
        tiedostoAsetettu = true;
    }

    private void suljeOhjelma() throws IOException {
        System.out.println(tekstiKali.suljeOhjelma());
        suljeTiedosto();
    }

    private void lopetaToisto() throws IOException {
        System.out.println(tekstiKali.lopetaToisto());
        suljeTiedosto();
    }

    private void asetaMusiikkiTauolle() {
        System.out.println(tekstiKali.asetaMusiikkiTauolle());
        AudioPlayer.player.stop(audioStream);
    }

    private void toistaMusiikkia() {
        System.out.println(tekstiKali.toistaMusiikkia());
        AudioPlayer.player.start(audioStream);
    }

    private void suljeTiedosto() throws IOException {
        AudioPlayer.player.stop(audioStream);
        audioStream.close();
        musiikkitiedosto.nollaaMusiikkitiedosto();
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
