package money;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static money.Currency.*;

public class MoneyTest {

    private Money m1;
    private Money m2;

    private String currency = "CHF";
    private int value1 = 12;
    private int value2 = 14;
    private int sumValue = value1 + value2;

    @BeforeEach
    public void setUp() throws Exception {

        m1 = new Money(value1, currency);
        m2 = new Money(value2, currency);
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void whenAddedConcreteValueMoney_thenSumValueMoney() {
        Money expected = new Money(value1 + value2, currency);
        Money result = m1.add(m2); //
        assertEquals(expected, result); //
    }

    @Test
    public void whenNullMoney_thenNotEquelsAnyMoney_() {
        assertNotEquals(m1, null);
    }

    @Test
    public void moneyEqualsItself_() {
        assertEquals(m1, new Money(value1, currency));
        assertEquals(m1, m1);
        assertNotEquals(m1, m2);
        assertNotEquals(m1, Integer.parseInt("1"));
    }

    @Test
    public void whenZeroValue_thenZeroAmount() {
        assertEquals(new Money(0, currency).amount(), 0);
    }

    @Test
    public void whenNativeValue_thenNegativeAmount() {
        assertEquals(new Money(-10, currency).amount(), -10);
    }

    // zadanie A.1

    @Test
    public void whenMultipleValue_thenMultipleResult() {
        int multiplier = 7;
        int multipliedValue = multiplier * value1;
        int resultValue = new Money(multipliedValue, currency).amount();
        assertEquals(multipliedValue, resultValue);
    }

    @Test
    public void whenMultipleZero_thenZeroResult() {
        int multiplier = 0;
        int multipliedValue = multiplier * value1;
        int resultValue = new Money(multipliedValue, currency).amount();
        assertEquals(multipliedValue, resultValue);
    }

    @Test
    public void whenMultipleNagative_thenExpectedResult() {
        int multiplier = -10;
        int multipliedValue = multiplier * value1;
        int resultValue = new Money(multipliedValue, currency).amount();
        assertEquals(multipliedValue, resultValue);
    }

    // zadanie A.3

    @Test
    public void whenCompareConcretePlnAndUsd_thenExpectedResult() {

        Money mPLN = new Money(38, PLN.name());
        Money mUSD = new Money(10, USD.name());
        Money fromUSD = Exchange.exchanged(mUSD, PLN.name());
        assertEquals(mPLN, fromUSD);
    }

    @Test
    public void whenCompareZeroPlnAndUsd_thenZeroResult() {

        Money mPLN = new Money(0, PLN.name());
        Money mUSD = new Money(0, USD.name());
        Money fromUSD = Exchange.exchanged(mUSD, PLN.name());
        assertEquals(mPLN, fromUSD);
    }

    @Test
    public void whenCompareConcretePlnAndEur_thenExpectedResult() {

        Money mPLN = new Money(427, PLN.name());
        Money mEUR = new Money(100, EUR.name());
        Money fromEur = Exchange.exchanged(mEUR, PLN.name());
        assertEquals(mPLN, fromEur);
    }

    @Test
    public void whenCompare100CnyTo10Eur_thenGreater() {

        Money mCNY = new Money(100, CNY.name());
        Money mEUR = new Money(10, EUR.name());
        Money fromCNY = Exchange.exchanged(mCNY, EUR.name());

        assertTrue(fromCNY.getAmount() > mEUR.getAmount() );
    }


    // zadanie A.2

    @Test
    public void whenAddConcretePlnAndUsd_thenExpectedResult() {

        Money mPLN = new Money(38, PLN.name());
        Money mUSD = new Money(10, USD.name());

        Money zeroPLN = new Money(0, PLN.name());

        assertEquals(zeroPLN.add(mUSD), mPLN);
    }

    @Test
    public void whenAdd100UsdTo0Eur_then88EuroResult() {

        Money mEUR = new Money(0, EUR.name());
        Money mUSD = new Money(100, USD.name());

        Money mResult = mEUR.add(mUSD);
        Money mExpected = new Money (88, EUR.name());

        assertEquals(mResult, mExpected);
    }

    @Test
    public void whenAdd100UsdTo10Eur_then98EuroResult() {

        Money mEUR = new Money(10, EUR.name());
        Money mUSD = new Money(100, USD.name());

        Money mResult = mEUR.add(mUSD);
        Money mExpected = new Money (98, EUR.name());

        assertEquals(mResult, mExpected);
    }

    @Test
    public void whenAdd100CnyTo1Usd_then15UsdResult() {

        Money m1 = new Money(1, USD.name());
        Money m2 = new Money(100, CNY.name());

        Money mResult = m1.add(m2);
        Money mExpected = new Money (15, USD.name());

        assertEquals(mResult, mExpected);
    }

}