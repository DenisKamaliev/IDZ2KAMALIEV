package org.example;
import java.util.Arrays;
import java.util.Objects;

public class Payment {
    private String fullName;
    private int day, month, year;
    private int[] date;
    private int amountOfPayment;

    Payment(String fullName, int day, int month, int year, int amountOfPayment) {

        this.fullName = fullName;

        boolean leap;

        if (((year % 4 == 0) && (year % 100) != 0) || (year % 400 == 0)) {
            this.year = year;
            leap = false;
        } else if (year > 0) {
            this.year = year;
            leap = true;
        } else {
            throw new IllegalArgumentException("Неккоректно введен год");
        }

        if (1 <= month && month <= 12) {
            this.month = month;
        } else {
            throw new IllegalArgumentException("Неккоректно введен месяц");
        }
        if (month == 2 && leap) {
            if (1 <= day && day <= 29) {
                this.day = day;
            } else {
                throw new IllegalArgumentException("Некорректно введен день");
            }
        } else {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (1 <= day && day <= 31) {
                    this.day = day;
                } else {
                    throw new IllegalArgumentException("Некорректно введен день");
                }
            } else {
                if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (1 <= day && day <= 30) {
                        this.day = day;
                    } else {
                        throw new IllegalArgumentException("Некорректно введен день");
                    }
                }
            }
        }
        if (amountOfPayment >= 0) {
            this.amountOfPayment = amountOfPayment;
        } else {
            throw new IllegalArgumentException("Некорректно введена сумма платежа");
        }

        this.date = new int[]{day, month, year};
    }

    Payment() {
        this.fullName = "noname";
        this.day = 0;
        this.month = 0;
        this.year = 0;
        this.amountOfPayment = 0;

        this.date = new int[]{day, month, year};
    }

    Payment(Payment p) {

        this.fullName = p.getFullName();
        this.day = p.getDay();
        this.month = p.getMonth();
        this.year = p.getYear();
        this.amountOfPayment = p.getAmountOfPayment();

        this.date = new int[]{day, month, year};

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public int[] getDate() {
        return date;
    }

    public void setDate(int[] _date) {
        this.date = _date;
        setDay(date[0]);
        setMonth(date[1]);
        setYear(date[2]);
    }

    public int getAmountOfPayment() {
        return amountOfPayment;
    }

    public void setAmountOfPayment(int amountOfPayment) {
        this.amountOfPayment = amountOfPayment;
    }

    private void updateDate() {
        date[0] = day;
        date[1] = month;
        date[2] = year;
    }


    @Override
    public String toString() {
        return "Payment{" +
                "name='" + fullName + '\'' +
                ", date=" + day + "." + month + "." + year +
                ", amountOfPayment=" + amountOfPayment + ".коп" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;
        return getDay() == payment.getDay() && getMonth() == payment.getMonth() && getYear() == payment.getYear() && getAmountOfPayment() == payment.getAmountOfPayment() && getFullName().equals(payment.getFullName()) && Arrays.equals(getDate(), payment.getDate());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getFullName(), getDay(), getMonth(), getYear(), getAmountOfPayment());
        result = 31 * result + Arrays.hashCode(getDate());
        return result;
    }

}
