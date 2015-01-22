package musicmachine.logic;

import java.util.Scanner;
import musicmachine.ui.TekstiKayttoliittyma;
import java.io.*;
import javafx.scene.media.MediaPlayer;
import sun.audio.*;

public class Sovelluslogiikka {

    private String komento;
    private InputStream input;
    private AudioStream audioStream;

    private MediaPlayer mediaPlayer = null;
    private boolean isPaused = false;
    private boolean isStop = true;

    String filePath = null;
    String productName = null;
    long durationInMillis = -1;

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
                        System.out.println(audioStream.getLength() / 85000);
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

                case "4":
                    tekstiKayttoliittyma.lopetaToisto();
                    suljeTiedosto();
                    break;

                case "x":
                    tekstiKayttoliittyma.suljeOhjelma();
                    suljeTiedosto();
                    break OUTER;
            }
        }

    }

    private void suljeTiedosto() throws IOException {
        AudioPlayer.player.stop(audioStream);
        audioStream.close();
    }

    private void annaKomento(Scanner lukija) {
        System.out.print("> ");
        komento = lukija.nextLine();
    }

}
