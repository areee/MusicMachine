package musicmachine.logic;

public class Musiikkitiedosto {

    private String tiedostopolku;
    private int kesto;

    public Musiikkitiedosto(String tiedosto) {
        this.tiedostopolku = tiedosto;
        this.kesto = 0;
    }

    public String getTiedostopolku() {
        return tiedostopolku;
    }

    public void setTiedostopolku(String tiedosto) {
        this.tiedostopolku = tiedosto;
    }

    public int getKesto() {
        return kesto;
    }

    public void setKesto(int kesto) {
        this.kesto = kesto;
    }

}
