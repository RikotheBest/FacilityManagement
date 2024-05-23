import java.util.Calendar;
import java.util.GregorianCalendar;
public class Datum implements Comparable<Datum>{
    private int tag;
    private int monat;
    private int jahr;

    public Datum(int tag, int monat, int jahr) {
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }

    public Datum() {
        Calendar cal = new GregorianCalendar();
        this.tag = Calendar.DAY_OF_MONTH;
        this.jahr = Calendar.YEAR;
        this.monat = Calendar.MONTH + 1;
    }

    public String toString(){
        return tag + "." + monat + "." + jahr;
    }


    public int compareTo(Datum o) {
        if(this.jahr < o.jahr) return 1;
        else if (this.monat < o.monat) return 1;
        else if (this.tag < o.tag) return 1;
        else return -1;

    }
}
