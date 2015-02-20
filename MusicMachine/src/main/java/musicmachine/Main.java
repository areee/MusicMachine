package musicmachine;

import musicmachine.ui.textUI.ValitseKayttoliittyma;

/**
 * Ohjelman Main-luokka, josta ValitseKayttoliittyma-luokka käynnistyy.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        new ValitseKayttoliittyma().kaynnista();
    }

}
