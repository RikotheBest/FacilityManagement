package Vertraege.Spezial;

import Vertraege.Vertrag;
import Attribute.*;

public class Wartungsvertrag extends Vertrag {
    private String wartungsFirma;
    private int intervall;
    private int kosten;

    public Wartungsvertrag(ZeitRaum dauer, String wartungsFirma, int intervall, int kosten) {
        super(dauer);
        this.wartungsFirma = wartungsFirma;
        this.intervall = intervall;
        this.kosten = kosten;
    }

    public String getWartungsFirma() {
        return wartungsFirma;
    }

    public void setWartungsFirma(String wartungsFirma) {
        this.wartungsFirma = wartungsFirma;
    }

    public int getIntervall() {
        return intervall;
    }

    public void setIntervall(int intervall) {
        this.intervall = intervall;
    }

    public int getKosten() {
        return kosten;
    }

    public void setKosten(int kosten) {
        this.kosten = kosten;
    }

}