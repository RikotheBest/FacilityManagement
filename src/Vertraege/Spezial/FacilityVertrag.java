package Vertraege.Spezial;

import Vertraege.Vertrag;
import Attribute.*;


public class FacilityVertrag extends Vertrag {
    Groesse groesse;
    Adresse adresse;

    public FacilityVertrag(ZeitRaum dauer, Groesse groesse, Adresse adresse) {
        super(dauer);
        this.groesse = groesse;
        this.adresse = adresse;
    }

    public Groesse getGroesse() {
        return groesse;
    }

    public void setGroesse(Groesse groesse) {
        this.groesse = groesse;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}
