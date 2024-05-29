package Attribute;

import Attribute.Datum;

public class ZeitRaum<T1 extends Datum, T2 extends Datum> {
   private T1 anfang;
   private T2 ende;

    public ZeitRaum(T1 anfang, T2 ende) {
        this.anfang = anfang;
        this.ende = ende;
    }

    public String toString() {
        return anfang.toString() + " - " + ende.toString();
    }

    public T1 getAnfang() {
        return anfang;
    }

    public void setAnfang(T1 anfang) {
        this.anfang = anfang;
    }

    public T2 getEnde() {
        return ende;
    }

    public void setEnde(T2 ende) {
        this.ende = ende;
    }
}
