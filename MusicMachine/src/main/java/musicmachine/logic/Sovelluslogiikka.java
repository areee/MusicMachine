package musicmachine.logic;

import java.util.Scanner;
import musicmachine.ui.TekstiKayttoliittyma;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sovelluslogiikka {

    private String komento;

    public void kaynnista(Scanner lukija) {
        TekstiKayttoliittyma tekstiKayttoliittyma = new TekstiKayttoliittyma();

        OUTER:
        while (true) {
            tekstiKayttoliittyma.komennot();
            annaKomento(lukija);
            switch (komento) {
                case "1":
                    tekstiKayttoliittyma.valitseMusiikkitiedosto();
//                    annaKomento(lukija);
//                    Musiikkitiedosto tiedosto = new Musiikkitiedosto(komento);
                    Media media = new Media("Over_the_horizon.mp3"); // tiedosto.getTiedosto()
                    MediaPlayer player = new MediaPlayer(media);
                    player.play();
                    break;
                case "2":
                    tekstiKayttoliittyma.toistaMusiikkia();
                    break;
                case "3":
                    tekstiKayttoliittyma.asetaMusiikkiTauolle();
                    break;
                case "x":
                    tekstiKayttoliittyma.suljeOhjelma();
                    break OUTER;
            }
        }

    }

    private void annaKomento(Scanner lukija) {
        System.out.print("> ");
        komento = lukija.nextLine();
    }

}
