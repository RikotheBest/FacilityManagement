package Gebaeude;

import java.util.ArrayList;

public class Gebaeude_Organisator {
    ArrayList<Gebaeude> gebaeude;

    public Gebaeude_Organisator() {
        gebaeude = new ArrayList<Gebaeude>();
    }
    public void add(Gebaeude g){
        gebaeude.add(g);
    }
}
