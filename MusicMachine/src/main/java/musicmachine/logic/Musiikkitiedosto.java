package musicmachine.logic;

import java.io.File;

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

}
