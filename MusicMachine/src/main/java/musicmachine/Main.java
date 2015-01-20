package musicmachine;

import java.util.Scanner;
import musicmachine.logic.Sovelluslogiikka;

public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        Sovelluslogiikka.kaynnista(lukija);
    }

}
