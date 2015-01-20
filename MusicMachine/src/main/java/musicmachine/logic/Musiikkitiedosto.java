package musicmachine.logic;

public class Musiikkitiedosto {

    private String tiedostopolku;

    public Musiikkitiedosto(String tiedostopolku) {
        this.tiedostopolku = tiedostopolku;
    }

    public String getTiedostopolku() {
        return tiedostopolku;
    }

    public void setTiedostopolku(String tiedostopolku) {
        this.tiedostopolku = tiedostopolku;
    }

}
