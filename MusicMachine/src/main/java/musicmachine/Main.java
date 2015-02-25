package musicmachine;

import musicmachine.ui.text.ValitseKayttoliittyma;

/**
 * Ohjelman pääluokka, josta ValitseKayttoliittyma-luokka käynnistyy
 */
public class Main {

    /**
     * Käynnistää ValitseKayttoliittyma-luokan kaynnista-metodin
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        new ValitseKayttoliittyma().kaynnista();
    }

}
