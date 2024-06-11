package Gebaeude;

import Attribute.Adresse;
import Attribute.Groesse;
import Ausstattung.Ausstattung_Organisator;


public class Gebaeude {
    private int nummer;
    private Groesse groesse;
    private Adresse adresse;
    private Ausstattung_Organisator austattung;

    public Gebaeude(int nummer, Groesse groesse, Adresse adresse, Ausstattung_Organisator austattung) {
        this.nummer = nummer;
        this.groesse = groesse;
        this.adresse = adresse;
        this.austattung = austattung;
    }




    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
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

    public Ausstattung_Organisator getAustattung() {
        return austattung;
    }

    public void setAustattung(Ausstattung_Organisator austattung) {
        this.austattung = austattung;
    }
}


