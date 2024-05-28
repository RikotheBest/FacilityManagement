import java.util.ArrayList;
import java.util.Collections;

public class Vertrag {
    private Intervall dauer;


    public Vertrag() {
    }

    public Vertrag(Intervall dauer) {
        this.dauer = dauer;
    }


    public Intervall getDauer() {
        return dauer;
    }

    public void setDauer(Intervall dauer) {
        this.dauer = dauer;
    }
}
