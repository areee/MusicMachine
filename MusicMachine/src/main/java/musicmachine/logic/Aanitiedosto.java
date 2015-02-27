package musicmachine.logic;

import java.io.File;

/**
 * Luokka määrittelee sovelluslogiikan tarvitseman musiikkitiedoston
 */
public class Aanitiedosto {

    private File tiedosto;
    private int kesto;

    /**
     * Luo musiikkitiedoston, johon asettaa musiikkitiedoston tiedostopolun
     *
     * @param tiedostopolku musiikkitiedoston tiedostopolku
     */
    public Aanitiedosto(String tiedostopolku) {
        this.tiedosto = new File(tiedostopolku);
        this.kesto = 0;
    }

    /**
     * Palauttaa musiikkitiedoston
     *
     * @return musiikkitiedosto
     */
    public File getTiedosto() {
        return tiedosto;
    }

    /**
     * Asettaa musiikkitiedoston
     *
     * @param tiedosto musiikkitiedosto
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
