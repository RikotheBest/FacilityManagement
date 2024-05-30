package Kunden;

import Gebaeude.Gebaeude_Organisator;

public class Kunde {
    private String name;
    private Gebaeude_Organisator gebaeude;

    public Kunde(String name, Gebaeude_Organisator gebaeude) {
        this.name = name;
        this.gebaeude = gebaeude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gebaeude_Organisator getGebaeude() {
        return gebaeude;
    }

    public void setGebaeude(Gebaeude_Organisator gebaeude) {
        this.gebaeude = gebaeude;
    }
}
