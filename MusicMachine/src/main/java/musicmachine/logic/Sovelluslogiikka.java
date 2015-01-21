package musicmachine.logic;

import java.util.Scanner;
import musicmachine.ui.TekstiKayttoliittyma;
import java.io.*;
import sun.audio.*;

public class Sovelluslogiikka {

    private String komento;
    private InputStream input;
    private AudioStream audioStream;

    public void kaynnista(Scanner lukija) throws Exception {
        TekstiKayttoliittyma tekstiKayttoliittyma = new TekstiKayttoliittyma();

        OUTER:
        while (true) {
            tekstiKayttoliittyma.komennot();
            annaKomento(lukija);
            switch (komento) {
                case "1":
                    try {
                        tekstiKayttoliittyma.valitseMusiikkitiedosto();
                        annaKomento(lukija);
                        Musiikkitiedosto tiedosto = new Musiikkitiedosto(komento);
                        input = new FileInputStream(tiedosto.getTiedosto());
                        audioStream = new AudioStream(input);
                    } catch (Exception e) {
                        System.out.println("Virheellinen tiedostopolku!\n" + e.getLocalizedMessage());
                    }

                    break;
                case "2":
                    tekstiKayttoliittyma.toistaMusiikkia();
                    AudioPlayer.player.start(audioStream);
                    break;
                case "3":
                    tekstiKayttoliittyma.asetaMusiikkiTauolle();
                    AudioPlayer.player.stop(audioStream);
                    break;

                case "x":
                    tekstiKayttoliittyma.suljeOhjelma();
                    AudioPlayer.player.stop(audioStream);
                    break OUTER;
            }
        }

    }

    private void annaKomento(Scanner lukija) {
        System.out.print("> ");
        komento = lukija.nextLine();
    }

}
