package fr.notavone;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date {
    private final int year;
    private final int month;
    private final int day;
    private final int hour;

    public Date(int nbJours, LocalDateTime date) {
        LocalDateTime retour = date.plusHours(nbJours * 24L);

        year = Integer.parseInt(DateTimeFormatter.ofPattern("yyyy").format(retour));
        month = Integer.parseInt(DateTimeFormatter.ofPattern("MM").format(retour));
        day = Integer.parseInt(DateTimeFormatter.ofPattern("dd").format(retour));
        hour = Integer.parseInt(DateTimeFormatter.ofPattern("HH").format(retour));
    }

    public Date() {
        this(0);
    }
    public Date(int nbJours) {
        this(nbJours, LocalDateTime.now());
    }

    public Date(int nbJours, Date date) {
        this(nbJours, LocalDateTime.of(date.year, date.month, date.day, new Date().hour, 0));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Date date = (Date) o;

        if (year != date.year) return false;
        if (month != date.month) return false;
        return day == date.day;
    }

    public boolean isAfter(Date date) {
        return date.hashCode() < hashCode();
    }

    public boolean isBefore(Date date) {
        return date.hashCode() > hashCode();
    }

    @Override
    public int hashCode() {
        int result = 365 * year;
        result = 31 * result + month;
        result = (result + day * 24) + hour;
        return result;
    }

    public int hourDifference(Date date) {
        return hashCode() - date.hashCode();
    }

    @Override
    public String toString() {
        return year + "/" + month + "/" + day + ":" + hour + "h";
    }
}
