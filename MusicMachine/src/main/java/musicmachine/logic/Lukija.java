package musicmachine.logic;

import java.util.Scanner;

/**
 * Luokka seuraa käyttäjän komentoja Scanner-luokan kautta
 */
public class Lukija {

    private Scanner lukija;

    public Lukija() {
        lukija = new Scanner(System.in);
    }

    /**
     * Metodi antaa käyttäjälle mahdollisuuden antaa komennon
     *
     * @return käyttäjän asettama komento
     */
    public String annaKomento() {
//        System.out.print("> ");
        return lukija.nextLine();
    }

    /**
     * Metodi palauttaa suurempi kuin -merkin, jonka perään käyttäjä voi
     * kirjoittaa komennon
     *
     * @return kirjoituskohta
     */
    @Override
    public String toString() {
        return "> ";
    }

    public Scanner getLukija() {
        return lukija;
    }

    public void setLukija(Scanner lukija) {
        this.lukija = lukija;
    }

}
