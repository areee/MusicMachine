package musicmachine.ui;

public class TekstiKayttoliittyma {

    public void komennot() {
        System.out.println("*** MusicMachine *** \n\n"
                + "Valitse toiminto: \n"
                + "  1) Valitse toistettava musiikkitiedosto \n"
                + "  2) Toista \n"
                + "  3) Tauko \n"
                + "  4) Lopeta toisto \n"
                + "  x) Lopeta ohjelma\n");
    }

    public void valitseMusiikkitiedosto() {
        System.out.println("Valitse toistettava musiikkitiedosto");
        System.out.println("Ohje: anna tiedostonimi muodossa "
                + "\"/Users/ylhaart/Music/Disney_Classics_asennusmusa.wav\"");
    }

    public void toistaMusiikkia() {
        System.out.println("Toistetaan... \n");
    }
    public void asetaMusiikkiTauolle(){
        System.out.println("Tauko \n");
    }
    
    public void lopetaToisto(){
        System.out.println("Toisto lopetettu.\n");
    }
    
    public void suljeOhjelma(){
        System.out.println("Ohjelma sulkeutuu.");
    }

}
