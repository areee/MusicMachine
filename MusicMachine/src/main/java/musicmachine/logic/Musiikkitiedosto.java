package musicmachine.logic;

/**
 * Luokka määrittelee sovelluslogiikan tarvitseman musiikkitiedoston.
 */
public class Musiikkitiedosto {

    private String tiedostopolku;
    private int kesto;

    /**
     * Asettaa musiikkitiedoston tiedostopolun.
     *
     * @param tiedosto musiikkitiedoston tiedostopolku
     */
    public Musiikkitiedosto(String tiedosto) {
        this.tiedostopolku = tiedosto;
        this.kesto = 0;
    }

    /**
     * Palauttaa tiedostopolun merkkijonona.
     *
     * @return tiedostopolku
     */
    public String getTiedostopolku() {
        return tiedostopolku;
    }

    /**
     * Asettaa musiikkitiedostolle tiedostopolun.
     *
     * @param tiedosto musiikkitiedoston tiedostopolku.
     */
    public void setTiedostopolku(String tiedosto) {
        this.tiedostopolku = tiedosto;
    }

    /**
     * Palauttaa musiikkitiedoston keston.
     *
     * @return kesto
     */
    public int getKesto() {
        return kesto;
    }

    /**
     * Asettaa musiikkitiedoston keston.
     *
     * @param kesto musiikkitiedoston kesto.
     */
    public void setKesto(int kesto) {
        this.kesto = kesto;
    }

}
