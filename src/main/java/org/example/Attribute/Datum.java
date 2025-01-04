package org.example.Attribute;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Die Klasse Datum repräsentiert ein Datum und bietet verschiedene
 * Konstruktoren und Methoden zum Abrufen und Setzen des Datums.
 */
public class Datum {
/**
 * Konstruktor zum Initialisieren eines Datums mit Tag, Monat und Jahr.
 *
 * @param tag Der Tag des Datums.
 * @param monat Der Monat des Datums.
 * @param jahr Das Jahr des Datums.
 */
    private LocalDate date;

    public Datum(int tag, int monat, int jahr) {
    	 try {
             date = LocalDate.of(jahr, monat, tag);
         } catch (DateTimeException e) {
             throw new IllegalArgumentException("Ungültiges Datum: " + tag + "/" + monat + "/" + jahr, e);
         }
    }
    public Datum(String datum){
    	try {
            this.date = LocalDate.parse(datum);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Ungültiges Datum: " + datum, e);
        }
    }

    public Datum() {
        date = LocalDate.now();
    }

    public LocalDate getDate(){
        return date;
    }
    public void setDate(int tag, int monat, int jahr){
    	 try {
             date = LocalDate.of(jahr, monat, tag);
         } catch (DateTimeException e) {
             throw new IllegalArgumentException("Ungültiges Datum: " + tag + "/" + monat + "/" + jahr, e);
         }
    }
    public String toString(){
        return date.toString();
    }
    public String getTag(){
        return date.getDayOfMonth() + "";
    }
    public String getMonth(){
        return date.getMonthValue() + "";
    }
    public String getYear(){
        return date.getYear() + "";
    }

}
