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
    public void whenAddedConcreteValueMoney_thenSumValueMoney() {
        Money expected = new Money(value1 + value2, currency1);
        Money result = m1.add(m2); 
        assertEquals(expected, result); 
    }

    @Test
    public void whenNullMoney_thenNotEquelsAnyMoney_() {
        assertNotEquals(m1, null);
    }

    @Test
    public void moneyEqualsItself_() {
        assertEquals(m1, new Money(value1, currency1));
        assertEquals(m1, m1);
        assertNotEquals(m1, m2);
        assertNotEquals(m1, Integer.parseInt("1"));
    }

    @Test
    public void whenZeroValue_thenZeroAmount() {
        assertEquals(new Money(0, currency1).amount(), 0);
    }

    @Test
    public void whenNativeValue_thenNegativeAmount() {
        assertEquals(new Money(-10, currency1).amount(), -10);
    }

    // zadanie A.1

    @Test
    public void whenMultipleValue_thenMultipleResult() {
        int multiplier = 7;
        int multipliedValue = multiplier * value1;
        int resultValue = new Money(multipliedValue, currency1).amount();
        assertEquals(multipliedValue, resultValue);
    }

    @Test
    public void whenMultipleZero_thenZeroResult() {
        int multiplier = 0;
        int multipliedValue = multiplier * value1;
        int resultValue = new Money(multipliedValue, currency1).amount();
        assertEquals(multipliedValue, resultValue);
    }

    @Test
    public void whenMultipleNagative_thenExpectedResult() {
        int multiplier = -10;
        int multipliedValue = multiplier * value1;
        int resultValue = new Money(multipliedValue, currency1).amount();
        assertEquals(multipliedValue, resultValue);
    }

    // zadanie A.3

    @Test
    public void whenCompareConcretePlnAndUsd_thenExpectedResult() {

        Money mPLN = new Money(38, PLN);
        Money mUSD = new Money(10, USD);
        Money fromUSD = Exchange.exchanged(mUSD, PLN);
        assertEquals(mPLN, fromUSD);
    }

    @Test
    public void whenCompareZeroPlnAndUsd_thenZeroResult() {

        Money mPLN = new Money(0, PLN);
        Money mUSD = new Money(0, USD);
        Money fromUSD = Exchange.exchanged(mUSD, PLN);
        assertEquals(mPLN, fromUSD);
    }

    @Test
    public void whenCompareConcretePlnAndEur_thenExpectedResult() {

        Money mPLN = new Money(427, PLN);
        Money mEUR = new Money(100, EUR);
        Money fromEur = Exchange.exchanged(mEUR, PLN);
        assertEquals(mPLN, fromEur);
    }

    @Test
    public void whenCompare100CnyTo10Eur_thenGreater() {

        Money mCNY = new Money(100, CNY);
        Money mEUR = new Money(10, EUR);
        Money fromCNY = Exchange.exchanged(mCNY, EUR);

        assertTrue(fromCNY.getAmount() > mEUR.getAmount() );
    }


    // zadanie A.2

    @Test
    public void whenAddConcretePlnAndUsd_thenExpectedResult() {

        Money mPLN = new Money(38, PLN);
        Money mUSD = new Money(10, USD);

        Money zeroPLN = new Money(0, PLN);

        assertEquals(zeroPLN.add(mUSD), mPLN);
    }

    @Test
    public void whenAdd100UsdTo0Eur_then88EuroResult() {

        Money mEUR = new Money(0, EUR);
        Money mUSD = new Money(100, USD);

        Money mResult = mEUR.add(mUSD);
        Money mExpected = new Money (88, EUR);

        assertEquals(mResult, mExpected);
    }

    @Test
    public void whenAdd100UsdTo10Eur_then98EuroResult() {

        Money mEUR = new Money(10, EUR);
        Money mUSD = new Money(100, USD);

        Money mResult = mEUR.add(mUSD);
        Money mExpected = new Money (98, EUR);

        assertEquals(mResult, mExpected);
    }

    @Test
    public void whenAdd100CnyTo1Usd_then15UsdResult() {

        Money m1 = new Money(1, USD);
        Money m2 = new Money(100, CNY);

        Money mResult = m1.add(m2);
        Money mExpected = new Money (15, USD);

        assertEquals(mResult, mExpected);
    }

}