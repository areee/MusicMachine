package musicmachine.logic;

import java.util.Scanner;

public class Lukija {

    public String annaKomento(Scanner lukija) {
        System.out.print("> ");
        return lukija.nextLine();
    }
}
