package musicmachine.logic;

import java.util.Scanner;

/**
 * Luokka seuraa käyttäjän komentoja Scanner-luokan kautta
 */
public class Lukija {

    /**
     * Metodi antaa käyttäjälle mahdollisuuden antaa komennon
     *
     * @param lukija asetettu Scanner
     * @return käyttäjän asettama komento
     */
    public String annaKomento(Scanner lukija) {
        System.out.print("> ");
        return lukija.nextLine();
    }
}
