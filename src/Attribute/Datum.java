package Attribute;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Datum {

    private LocalDate date;

    public Datum(int tag, int monat, int jahr) {
        date = LocalDate.of(jahr,monat,tag);
    }

    public Datum() {
        date = LocalDate.now();
    }

    public LocalDate getDate(){
        return date;
    }
    public void setDate(int tag, int monat, int jahr){
        date = LocalDate.of(jahr,monat,tag);
    }
    public String toString(){
        return date.toString();
    }


}