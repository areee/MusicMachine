package musicmachine.ui.textUI;

import java.io.IOException;
import java.util.Scanner;
import musicmachine.logic.Lukija;
import musicmachine.ui.graphicUI.GraafinenKayttoliittyma;

/**
 * Tekstikäyttöliittymä, jolla valitaan, halutaanko avata MusicMachinen
 * graafinen vai tekstipohjainen käyttöliittymä
 */
public class ValitseKayttoliittyma {

    private final Lukija lukija;

    public ValitseKayttoliittyma() {
        this.lukija = new Lukija();
    }

    /**
     * Käynnistää käyttäjän valinnan mukaan joko tekstipohjaisen tai graafisen
     * käyttöliittymän
     *
     * @param lukija käyttäjän kirjoittamia komentoja seuraava skanneri
     * @throws java.io.IOException
     */
    public void kaynnista(Scanner lukija) throws IOException {

        OUTER:
        while (true) {
            System.out.println("Valitse käyttöliittymä:\n"
                    + "1) Graafinen käyttöliittymä\n"
                    + "2) Tekstikäyttöliittymä\n"
                    + "x) Lopeta");
            String komento = this.lukija.annaKomento(lukija);
            switch (komento) {
                case "1":
                    new GraafinenKayttoliittyma().setVisible(true);
                    break OUTER;
                case "2":
                    new TekstiKayttoliittyma().kaynnista(lukija);
                    break OUTER;
                case "x":
                    break OUTER;
            }
        }
    }
}
