package musicmachine.ui.textUI;

import java.io.IOException;
import musicmachine.logic.Lukija;
import musicmachine.ui.graphicUI.GraafinenKayttoliittyma;

/**
 * Tekstikäyttöliittymä, jolla valitaan, halutaanko avata MusicMachinen
 * graafinen vai tekstipohjainen käyttöliittymä
 */
public class ValitseKayttoliittyma {

    private final Lukija lukija;

    public ValitseKayttoliittyma() {
        lukija = new Lukija();
    }

    /**
     * Käynnistää käyttäjän valinnan mukaan joko tekstipohjaisen tai graafisen
     * käyttöliittymän
     *
     * @throws java.io.IOException
     */
    public void kaynnista() throws IOException {

        OUTER:
        while (true) {
            System.out.println("Valitse käyttöliittymä:\n"
                    + "1) Graafinen käyttöliittymä\n"
                    + "2) Tekstikäyttöliittymä\n"
                    + "x) Lopeta");
            System.out.print(lukija);
            String komento = lukija.annaKomento();
            switch (komento) {
                case "1":
                    new GraafinenKayttoliittyma().setVisible(true);
                    break OUTER;
                case "2":
                    new TekstiKayttoliittyma().kaynnista();
                    break OUTER;
                case "x":
                    break OUTER;
            }
        }
    }
}
