package musicmachine;

import musicmachine.ui.text.ValitseKayttoliittyma;

/**
 * Ohjelman pääluokka, josta ValitseKayttoliittyma-luokka käynnistyy
 */
public class MusicMachine {

    /**
     * Käynnistää ValitseKayttoliittyma-luokan kaynnista-metodin
     *
     * @param args mahdolliset argumentit taulukoituna
     * @throws Exception heittää mahdollisesti poikkeuksen
     */
    public static void main(String[] args) throws Exception {

        new ValitseKayttoliittyma().kaynnista();
    }

}
