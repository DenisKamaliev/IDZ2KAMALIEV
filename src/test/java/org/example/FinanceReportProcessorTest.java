package org.example;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FinanceReportProcessorTest {
    @Test
    public void byCharTest() {
        Payment payment = new Payment("Камалиев Денис Сергеевич", 4, 4, 2002, 30);
        Payment somePayment = new Payment();
        FinanceReport financeReport = new FinanceReport(2, 1, 1, 2021, "Кто-то");
        financeReport.setPayment(payment, 0);
        financeReport.setPayment(somePayment, 1);
        String expected = "FinanceReport{author='noname', date=0.0.0, quantityOfReports=2, reports=[Payment{name='Камалиев Денис Сергеевич', date=4.4.2002, amountOfPayment=30.коп}, null]}";
        assertEquals(expected, FinanceReportProcessor.ConfigureByCharReport(financeReport, 'к').toString());
    }

    @Test
    public void bySumTest() {
        Payment payment = new Payment("Камалиев Денис Сергеевич", 4, 4, 2002, 30);
        Payment somePayment = new Payment();
        FinanceReport financeReport = new FinanceReport(2, 1, 1, 2022, "Бухгалтер Лена");
        financeReport.setPayment(payment, 0);
        financeReport.setPayment(somePayment, 1);
        int sum = 20;
        String expected = "FinanceReport{author='noname', date=0.0.0, quantityOfReports=2, reports=[Payment{name='noname', date=0.0.0, amountOfPayment=0.коп}, null]}";
        assertEquals(expected, FinanceReportProcessor.ConfigureBySumReports(financeReport, sum).toString());
    }
}