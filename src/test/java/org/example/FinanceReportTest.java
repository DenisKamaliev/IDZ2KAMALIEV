package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FinanceReportTest {
    @Test
    public void FinanceReportTest() throws IllegalArgumentException {
        Payment payment = new Payment("Камалиев Денис Сергеевич", 4, 4, 2002, 30);
        Payment somePayment = new Payment();
        FinanceReport financeReport = new FinanceReport(2, 1, 1, 2021, "Кто-то");
        financeReport.setPayment(payment, 0);
        financeReport.setPayment(somePayment, 1);
        String expected = "FinanceReport{author='Кто-то', date=1.1.2021, quantityOfReports=2, reports=[Payment{name='Камалиев Денис Сергеевич', date=4.4.2002, amountOfPayment=30.коп}, Payment{name='noname', date=0.0.0, amountOfPayment=0.коп}]}";
        assertEquals(expected, financeReport.toString());
    }

    @Test
    public void defaultConstructorTest() {
        FinanceReport financeReport = new FinanceReport();
        String expected = "FinanceReport{author='noname', date=0.0.0, quantityOfReports=0, reports=[]}";
        assertEquals(expected, financeReport.toString());
    }

    @Test
    public void copyTest() {
        Payment payment = new Payment("Камалиев Денис Сергеевич", 4, 4, 2002, 30);
        Payment somePayment = new Payment();
        FinanceReport financeReport = new FinanceReport(2, 1, 1, 2021, "Кто-то");
        financeReport.setPayment(payment, 0);
        financeReport.setPayment(somePayment, 1);

        FinanceReport financeReportCopy = new FinanceReport(financeReport);

        assertEquals(true, financeReport.equals(financeReportCopy));

    }

    @Test
    public void setReportTest() {
        Payment payment = new Payment("Камалиев Денис Сергеевич", 4, 4, 2002, 30);
        Payment somePayment = new Payment();
        FinanceReport financeReport = new FinanceReport(2, 1, 1, 2021, "Кто-то");
        financeReport.setPayment(payment, 0);
        financeReport.setPayment(somePayment, 1);
        //set
        financeReport.setPayment(payment, 1);

        String expected = "FinanceReport{author='Кто-то', date=1.1.2021, quantityOfReports=2, reports=[Payment{name='Камалиев Денис Сергеевич', date=4.4.2002, amountOfPayment=30.коп}, Payment{name='Камалиев Денис Сергеевич', date=4.4.2002, amountOfPayment=30.коп}]}";
        assertEquals(expected, financeReport.toString());
    }

    @Test
    public void getReportTest() {
        Payment payment = new Payment("Камалиев Денис Сергеевич", 4, 4, 2002, 30);
        FinanceReport financeReport = new FinanceReport(2, 1, 1, 2021, "Кто-то");
        financeReport.setPayment(payment, 0);
        financeReport.setPayment(payment, 1);
        assertEquals(true, payment.equals(financeReport.getReport(0)));
    }

    @Test
    public void getQuantityOfReportsTest() {
        FinanceReport financeReport = new FinanceReport(2, 1, 1, 2021, "Кто-то");
        assertEquals(2, financeReport.getQuantityOfReports());
    }
}