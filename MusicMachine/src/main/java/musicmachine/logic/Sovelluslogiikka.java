package musicmachine.logic;

import java.util.Scanner;
import musicmachine.ui.TekstiKayttoliittyma;

public class Sovelluslogiikka {

    public static void kaynnista(Scanner lukija) {
        TekstiKayttoliittyma tekstiKayttoliittyma = new TekstiKayttoliittyma();

        OUTER:
        while (true) {
            tekstiKayttoliittyma.komennot();
            System.out.print("> ");
            String komento = lukija.nextLine();
            switch (komento) {
                case "1":
                    tekstiKayttoliittyma.valitseMusiikkitiedosto();
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

}
