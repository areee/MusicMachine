package musicmachine.logic;

public class Musiikkitiedosto {

    private String tiedostopolku;
    private int kesto;

    public Musiikkitiedosto(String tiedosto) {
        this.tiedostopolku = tiedosto;
    }

    public String getTiedostopolku() {
        return tiedostopolku;
    }

    public void setTiedostopolku(String tiedosto) {
        this.tiedostopolku = tiedosto;
    }

    @Override
    public String toString() {
        return this.tiedostopolku;
    }

    public int getKesto() {
        return kesto;
    }

    public void setKesto(int kesto) {
        this.kesto = kesto;
    }

}
