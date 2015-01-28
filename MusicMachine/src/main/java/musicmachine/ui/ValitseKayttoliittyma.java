package musicmachine.ui;

import java.io.IOException;
import java.util.Scanner;
import musicmachine.logic.Lukija;

public class ValitseKayttoliittyma {

    public void kaynnista(Scanner lukija) throws IOException {
        while (true) {
            System.out.println("Valitse käyttöliittymä:\n"
                    + "1) Graafinen käyttöliittymä\n"
                    + "2) Tekstipohjainen käyttöliittymä\n"
                    + "x) Lopeta");

            String komento = new Lukija().annaKomento(lukija);
            if (komento.equals("1")) {
                new GraafinenKayttoliittyma().kaynnista(lukija);
                break;
            } else if (komento.equals("2")) {
                new TekstiKayttoliittyma().kaynnista(lukija);
                break;
            } else if (komento.equals("x")) {
                break;
            }
        }
    }

//    private String annaKomento(Scanner lukija) {
//        System.out.print("> ");
//        return lukija.nextLine();
//    }
}
