package money;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Exchange {

    private static final Map<String, BigDecimal> rate = new HashMap<>();

    static {
        rate.put(Currency.PLN.name(), BigDecimal.valueOf(1));
        rate.put(Currency.EUR.name(), BigDecimal.valueOf(4.2788));
        rate.put(Currency.USD.name(), BigDecimal.valueOf(3.8041));
        rate.put(Currency.CNY.name(), BigDecimal.valueOf(0.5501));
        // etc
    }

    public static Money exchanged(Money money, String newCurrencyName) {

        if (money.getCurrency().equals(newCurrencyName)) {
            return new Money(money.getAmount(), money.getCurrency());
        }
        // exchange to base currency
        BigDecimal tmpAmount = rate.get(money.getCurrency()).multiply(BigDecimal.valueOf(money.getAmount()));
        // exchange to new currency
        BigDecimal resultAmount = tmpAmount.divide(rate.get(newCurrencyName), RoundingMode.FLOOR);

        return new Money(resultAmount.intValue(), newCurrencyName);
    }

}