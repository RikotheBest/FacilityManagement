public class Vertrag {
    private ZeitRaum dauer;


    public Vertrag() {
    }

    public Vertrag(ZeitRaum dauer) {
        this.dauer = dauer;
    }


    public ZeitRaum getDauer() {
        return dauer;
    }

    public void setDauer(ZeitRaum dauer) {
        this.dauer = dauer;
    }
}
