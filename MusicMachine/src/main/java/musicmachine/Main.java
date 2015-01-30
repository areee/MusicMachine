package musicmachine;

import java.util.Scanner;
import musicmachine.ui.textUI.ValitseKayttoliittyma;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner lukija = new Scanner(System.in);

        new ValitseKayttoliittyma().kaynnista(lukija);
    }

}
