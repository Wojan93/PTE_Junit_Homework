package money;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import static money.Currency.*;

public class MoneyTest {

    private Money m1;
    private Money m2;

    private Currency currency1 = Currency.EUR;
    private Currency currency2 = Currency.EUR;
    private int value1 = 12;
    private int value2 = 14;
  

    @BeforeEach
    public void setUp() throws Exception {

        m1 = new Money(value1, currency1);
        m2 = new Money(value2, currency2);
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void sumValueOfMoneyIsExpected() {
        Money expected = new Money(value1 + value2, currency1);
        Money result = m1.add(m2); 
        assertEquals(expected, result); 
    }

    @Test
    public void valueMoneyNotEqualNull() {
        assertNotEquals(m1, null);
    }

    @Test
    public void moneyCheckingEquality() {
        assertEquals(m1, new Money(value1, currency1));
        assertEquals(m1, m1);
        assertNotEquals(m1, m2);
        assertNotEquals(m1, Integer.parseInt("1"));
    }

    @Test
    public void zeroValueEqualZero() {
        assertEquals(new Money(0, currency1).amount(), 0);
    }



    @Test
    public void multiplyTestCheckResult() {
        int multiplier = 7;
        int multipliedValue = multiplier * value1;
        int resultValue = new Money(multipliedValue, currency1).amount();
        assertEquals(multipliedValue, resultValue);
    }

    @Test
    public void multipleByZero() {
        int multiplier = 0;
        int multipliedValue = multiplier * value1;
        int resultValue = new Money(multipliedValue, currency1).amount();
        assertEquals(multipliedValue, resultValue);
    }



    @Test
    public void equalityPlnAndUsd() {

        Money mPLN = new Money(38, PLN);
        Money mUSD = new Money(10, USD);
        Exchange e = new Exchange();
        Money fromUSD = Exchange.stock(mUSD, PLN);
        assertEquals(mPLN, fromUSD);
    }

    @Test
    public void equalityZeroPlnAndZeroUsd() {

        Money mPLN = new Money(0, PLN);
        Money mUSD = new Money(0, USD);
        Money fromUSD = Exchange.stock(mUSD, PLN);
        assertEquals(mPLN, fromUSD);
    }

    @Test
    public void compareValuePlnAndEur() {
        Money mPLN = new Money(427, PLN);
        Money mEUR = new Money(100, EUR);
        Money fromEur = Exchange.stock(mEUR, PLN);
        assertEquals(mPLN, fromEur);
    }

    @Test
    public void isFirstValueIsGreaterThanSecond() {
    	  Money mPLN = new Money(429, PLN);
          Money mEUR = new Money(100, EUR);
          assertTrue(Exchange.isGreaterThan(mPLN, mEUR));
    }


    @Test
    public void isFirstValueIsSmallerThanSecond() {
    	  Money mPLN = new Money(426, PLN);
          Money mEUR = new Money(100, EUR);
          assertTrue(Exchange.isSmallerThan(mPLN, mEUR));
    }

    
    

    @Test
    public void addPlnAndUsd() {

        Money mPLN = new Money(38, PLN);
        Money mUSD = new Money(10, USD);

        Money zeroPLN = new Money(0, PLN);

        assertEquals(zeroPLN.add(mUSD), mPLN);
    }

    @Test
    public void addUsdToZeroEur_returnEuro() {

        Money mEUR = new Money(0, EUR);
        Money mUSD = new Money(100, USD);

        Money mResult = mEUR.add(mUSD);
        Money mExpected = new Money (88, EUR);

        assertEquals(mResult, mExpected);
    }

    @Test
    public void addUsdValueToEuroValue_returnEuro() {

        Money mEUR = new Money(10, EUR);
        Money mUSD = new Money(100, USD);

        Money mResult = mEUR.add(mUSD);
        Money mExpected = new Money (98, EUR);

        assertEquals(mResult, mExpected);
    }
}