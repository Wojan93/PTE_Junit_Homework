package money;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Exchange {

    private static final Map<Currency, BigDecimal> rate = new HashMap<>();

    static {
        rate.put(Currency.PLN, BigDecimal.valueOf(1));
        rate.put(Currency.EUR, BigDecimal.valueOf(4.2788));
        rate.put(Currency.USD, BigDecimal.valueOf(3.8041));
        rate.put(Currency.CNY, BigDecimal.valueOf(0.5501));
        // etc
    }

    public static Money exchanged(Money money, Currency fCurrency) {

        if (money.getCurrency().equals(fCurrency)) {
            return new Money(money.getAmount(), money.getCurrency());
        }
        // exchange to base currency
        BigDecimal tmpAmount = rate.get(money.getCurrency()).multiply(BigDecimal.valueOf(money.getAmount()));
        // exchange to new currency
        BigDecimal resultAmount = tmpAmount.divide(rate.get(fCurrency), RoundingMode.FLOOR);

        return new Money(resultAmount.intValue(), fCurrency);
    }

}