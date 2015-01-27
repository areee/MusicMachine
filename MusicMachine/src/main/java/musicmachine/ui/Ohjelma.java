package musicmachine.ui;

import java.util.Date;

public class Ohjelma {

    private String nimi;
    private double versioNro;

    public Ohjelma(String nimi, double versioNro) {
        this.nimi = nimi;
        this.versioNro = versioNro;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public double getVersioNro() {
        return versioNro;
    }

    public void setVersioNro(double versioNro) {
        this.versioNro = versioNro;
    }
}
