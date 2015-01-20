package musicmachine;

import java.util.Scanner;
import musicmachine.logic.Sovelluslogiikka;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner lukija = new Scanner(System.in);

        new Sovelluslogiikka().kaynnista(lukija);
    }

}
