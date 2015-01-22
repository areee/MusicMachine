package musicmachine.ui;

public class TekstiKayttoliittyma {

    public String valikko() {
        String valikkoteksti = "*** MusicMachine *** \n\n"
                + "Valitse toiminto: \n"
                + "  1) Valitse toistettava musiikkitiedosto \n"
                + "  2) Toista \n"
                + "  3) Tauko \n"
                + "  4) Lopeta toisto \n"
                + "  x) Lopeta ohjelma\n";
        return valikkoteksti;
    }

    public String valitseMusiikkitiedosto() {
        String valitseMusiikkiOhje = "Valitse toistettava musiikkitiedosto.\n"
                + "Ohje: anna tiedostonimi muodossa "
                + "\"/Users/ylhaart/Music/Disney_Classics_asennusmusa.wav\"\n"
                + "tai \"/Users/ylhaart/Music/Rally_3D_title_music.mid\"";
        return valitseMusiikkiOhje;
    }

    public String toistaMusiikkia() {
        return "Toistetaan... \n";
    }

    public String asetaMusiikkiTauolle() {
        return "Tauko \n";
    }

    public String lopetaToisto() {
        return "Toisto lopetettu.\n";
    }

    public String suljeOhjelma() {
        return "Ohjelma sulkeutuu.";
    }

    public String tiedostoaEiVoidaToistaa() {
        return "Virhe! Et ole valinnut musiikkitiedostoa toistettavaksi.";
    }
}
