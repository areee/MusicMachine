package musicmachine.logic;

public class Musiikkitiedosto {

    private String tiedosto;

    public Musiikkitiedosto(String tiedosto) {
        this.tiedosto = tiedosto;
    }

    public String getTiedosto() {
        return tiedosto;
    }

    public void setTiedosto(String tiedosto) {
        this.tiedosto = tiedosto;
    }

    public void nollaaMusiikkitiedosto() {
        this.tiedosto = null;
    }

}
