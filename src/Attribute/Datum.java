package Attribute;

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
        Calendar.getInstance();
        this.tag = cal.get(Calendar.DATE);
        this.jahr = cal.get(Calendar.YEAR);
        this.monat = cal.get(Calendar.MONTH)+1;
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

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getMonat() {
        return monat;
    }

    public void setMonat(int monat) {
        this.monat = monat;
    }

    public int getJahr() {
        return jahr;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }
}
