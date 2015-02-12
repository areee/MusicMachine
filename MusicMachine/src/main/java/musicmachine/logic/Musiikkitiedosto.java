package musicmachine.logic;

import java.io.File;

/**
 * Luokka määrittelee sovelluslogiikan tarvitseman musiikkitiedoston
 */
public class Musiikkitiedosto {

    private File tiedosto;
    private int kesto;

    /**
     * Asettaa musiikkitiedoston tiedostopolun
     *
     * @param tiedosto musiikkitiedoston tiedostopolku
     */
    public Musiikkitiedosto(File tiedosto) {
        this.tiedosto = tiedosto;
        this.kesto = 0;
    }

    /**
     * Palauttaa tiedostopolun merkkijonona
     *
     * @return tiedostopolku
     */
    public File getTiedosto() {
        return tiedosto;
    }

    /**
     * Asettaa musiikkitiedostolle tiedostopolun
     *
     * @param tiedosto musiikkitiedoston tiedostopolku
     */
    public void setTiedosto(File tiedosto) {
        this.tiedosto = tiedosto;
    }

    /**
     * Palauttaa musiikkitiedoston keston
     *
     * @return kesto
     */
    public int getKesto() {
        return kesto;
    }

    /**
     * Asettaa musiikkitiedoston keston
     *
     * @param kesto musiikkitiedoston kesto
     */
    public void setKesto(int kesto) {
        this.kesto = kesto;
    }

}
