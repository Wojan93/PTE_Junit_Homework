package money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Exchange {

	Exchange() {

	}

	private static final Map<Currency, BigDecimal> stocRateMap = new HashMap<>();

	static {
		stocRateMap.put(Currency.PLN, BigDecimal.valueOf(1));
		stocRateMap.put(Currency.EUR, BigDecimal.valueOf(4.27));
		stocRateMap.put(Currency.USD, BigDecimal.valueOf(3.80));

	}

	public static Money stock(Money money, Currency fCurrency) {

		if (money.getCurrency().equals(fCurrency)) {
			return new Money(money.getAmount(), money.getCurrency());
		}
		// exchange to base currency
		BigDecimal tmpAmount = stocRateMap.get(money.getCurrency()).multiply(BigDecimal.valueOf(money.getAmount()));
		// exchange to new currency
		BigDecimal resultAmount = tmpAmount.divide(stocRateMap.get(fCurrency), RoundingMode.FLOOR);

		return new Money(resultAmount.intValue(), fCurrency);
	}

	public static boolean isGreaterThan(Money m1, Money m2) {
		BigDecimal tmpM1 = BigDecimal.valueOf(m1.getAmount()).multiply(stocRateMap.get(m1.getCurrency()));
		BigDecimal tmpM2 = BigDecimal.valueOf(m2.getAmount()).multiply(stocRateMap.get(m2.getCurrency()));
		if (tmpM1.compareTo(tmpM2) == 1) {
			return true;
		} else if (tmpM1.compareTo(tmpM2) == 0) {
			return false;
		} else
			return false;
	}
	
	public static boolean isSmallerThan(Money m1, Money m2) {
		BigDecimal tmpM1 = BigDecimal.valueOf(m1.getAmount()).multiply(stocRateMap.get(m1.getCurrency()));
		BigDecimal tmpM2 = BigDecimal.valueOf(m2.getAmount()).multiply(stocRateMap.get(m2.getCurrency()));
		if (tmpM1.compareTo(tmpM2) == 1) {
			return false;
		} else if (tmpM1.compareTo(tmpM2) == 0) {
			return false;
		} else
			return true;
	}

	public static void main(String[] args) {
		Money m1 = new Money(10, Currency.EUR);
		Money m2 = new Money(10, Currency.PLN);

		isGreaterThan(m1, m2);
	}
}
