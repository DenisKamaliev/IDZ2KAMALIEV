package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PaymentTest {
    @Test
    public void defaultConstructorTest() {
        Payment a = new Payment();
        assertEquals("Payment{name='noname', date=0.0.0, amountOfPayment=0.коп}", a.toString());
    }

    @Test
    public void copyTest() throws IllegalArgumentException {
        Payment a = new Payment("Камалиев Денис Сергеевич", 4, 4, 2002, 20);
        Payment b = new Payment(a);
        assertEquals(true, a.equals(b));

    }

    @Test
    public void equalsTest() throws IllegalArgumentException {
        Payment a = new Payment("Камалиев Денис Сергеевич", 4, 4, 2002, 20);
        Payment b = new Payment("Камалиев Денис Сергеевич", 4, 4, 2002, 20);
        assertEquals(true, a.equals(b));

    }

    @Test
    public void toStringTest() throws IllegalArgumentException {
        Payment a = new Payment("Камалиев Денис Сергеевич", 4, 4, 2002, 30);
        assertEquals("Payment{name='Камалиев Денис Сергеевич', date=4.4.2002, amountOfPayment=30.коп}", a.toString());

    }

    @Test
    public void hashCodeTest() {
        Payment a = new Payment("Камалиев Денис Сергеевич", 4, 4, 2002, 30);
        assertEquals(-1147220061, a.hashCode());
    }


}