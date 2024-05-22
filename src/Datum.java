import java.util.Calendar;
import java.util.GregorianCalendar;
public class Datum{
    int tag;
    int monat;
    int jahr;

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


    public void print(){
        System.out.println(tag + "." + monat + "." + jahr);
    }
    public String toString(){
        return tag + "." + monat + "." + jahr;
    }



}
