
package org.example;
import java.util.Arrays;
import java.util.Objects;

public class FinanceReport {


    private String author;
    private int[] date;
    private int quantityOfReports;
    private Payment[] payments;
    private int day, month, year;

    //конструкторы
    public FinanceReport(int quantityOfReports, int day, int month, int year, String author) {
        this.quantityOfReports = quantityOfReports;
        payments = new Payment[quantityOfReports];
        this.day = day;
        this.month = month;
        this.year = year;
        this.author = author;
        this.date = new int[]{day, month, year};


    }

    public FinanceReport() {
        this.quantityOfReports = 0;
        payments = new Payment[quantityOfReports];
        this.day = 0;
        this.month = 0;
        this.year = 0;
        this.author = "noname";
        this.date = new int[]{day, month, year};
    }

    public FinanceReport(FinanceReport f) {
        this.quantityOfReports = f.getQuantityOfReports();
        payments = f.getPayments();
        this.day = f.getDay();
        this.month = f.getMonth();
        this.year = f.getYear();
        this.author = f.getAuthor();
        this.date = new int[]{day, month, year};
    }

    public FinanceReport(int quantityOfReports) {
        this.quantityOfReports = quantityOfReports;
        payments = new Payment[quantityOfReports];
        this.day = 0;
        this.month = 0;
        this.year = 0;
        this.author = "noname";
        this.date = new int[]{day, month, year};
    }



    public Payment getReport(int i) {
        return payments[i];
    }

    public void setPayment(Payment report, int i) {
        this.payments[i] = report;
    }

    public int getQuantityOfReports() {
        return payments.length;
    }

    public Payment[] getPayments() {
        return payments;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
        updateDate();
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
        updateDate();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
        updateDate();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private void updateDate() {
        date[0] = day;
        date[1] = month;
        date[2] = year;
    }

    @Override
    public String toString() {
        return "FinanceReport{" +
                "author='" + author + '\'' +
                ", date=" + day + "." + month + "." + year +
                ", quantityOfReports=" + quantityOfReports +
                ", reports=" + Arrays.toString(payments) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinanceReport that)) return false;
        return getQuantityOfReports() == that.getQuantityOfReports() && getDay() == that.getDay() && getMonth() == that.getMonth() && getYear() == that.getYear() && getAuthor().equals(that.getAuthor()) && Arrays.equals(date, that.date) && Arrays.equals(getPayments(), that.getPayments());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getAuthor(), getQuantityOfReports(), getDay(), getMonth(), getYear());
        result = 31 * result + Arrays.hashCode(date);
        result = 31 * result + Arrays.hashCode(getPayments());
        return result;
    }
}