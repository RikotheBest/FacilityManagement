package Gebaeude;

import Attribute.Adresse;
import Attribute.Groesse;
import Ausstattung.Brandschutz.Feuerloescher_Organisator;
import Ausstattung.Brandschutz.Rauchmelder_Organisator;
import Ausstattung.Moebel.Fenster_Organisator;
import Ausstattung.Moebel.Tisch_Organisator;
import Ausstattung.Moebel.Tuer_Organisator;

public class Gebaeude {
    private int nummer;
    private Groesse groesse;
    private Adresse adresse;
    private Rauchmelder_Organisator rauchmaelder;
    private Feuerloescher_Organisator feuerloescher;
    private Fenster_Organisator fenster;
    private Tisch_Organisator tische;
    private Tuer_Organisator tuere;

    public Gebaeude(int nummer, Groesse groesse, Adresse adresse, Rauchmelder_Organisator rauchmaelder, Feuerloescher_Organisator feuerloescher,
                    Fenster_Organisator fenster, Tisch_Organisator tische, Tuer_Organisator tuere) {
        this.nummer = nummer;
        this.groesse = groesse;
        this.adresse = adresse;
        this.rauchmaelder = rauchmaelder;
        this.feuerloescher = feuerloescher;
        this.fenster = fenster;
        this.tische = tische;
        this.tuere = tuere;
    }

    public Gebaeude(int nummer, Groesse groesse, Adresse adresse) {
        this.nummer = nummer;
        this.groesse = groesse;
        this.adresse = adresse;
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

    public Rauchmelder_Organisator getRauchmaelder() {
        return rauchmaelder;
    }

    public void setRauchmaelder(Rauchmelder_Organisator rauchmaelder) {
        this.rauchmaelder = rauchmaelder;
    }

    public Feuerloescher_Organisator getFeuerloescher() {
        return feuerloescher;
    }

    public void setFeuerloescher(Feuerloescher_Organisator feuerloescher) {
        this.feuerloescher = feuerloescher;
    }

    public Fenster_Organisator getFenster() {
        return fenster;
    }

    public void setFenster(Fenster_Organisator fenster) {
        this.fenster = fenster;
    }

    public Tisch_Organisator getTische() {
        return tische;
    }

    public void setTische(Tisch_Organisator tische) {
        this.tische = tische;
    }

    public Tuer_Organisator getTuere() {
        return tuere;
    }

    public void setTuere(Tuer_Organisator tuere) {
        this.tuere = tuere;
    }
}
