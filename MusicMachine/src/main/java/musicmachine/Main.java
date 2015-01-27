package musicmachine;

import java.util.Scanner;
import musicmachine.logic.Sovelluslogiikka;
import musicmachine.ui.Kayttoliittyma;
import musicmachine.ui.TekstiKayttoliittyma;
import musicmachine.ui.ValitseKayttoliittyma;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner lukija = new Scanner(System.in);

        new ValitseKayttoliittyma().kaynnista(lukija);
    }

}
