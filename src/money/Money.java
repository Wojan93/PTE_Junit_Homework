package money;

class Money {
	private int fAmount;
	private Currency fCurrency;

	public Money(int amount, Currency cur) {
		fAmount = amount;
		fCurrency = cur;
	}

	public int amount() {
		return fAmount;
	}

	public Currency currency() {
		return fCurrency;
	}

	public Money add(Money m) {
		Money newMoney = Exchange.stock(m, fCurrency);
		newMoney.setAmount(newMoney.getAmount() + fAmount);
		return newMoney;
	}

	@Override
	public boolean equals(Object anObject) {
		if (anObject instanceof Money) {
			Money a = (Money) anObject;
			return a.currency().equals(currency()) && amount() == a.amount();
		} else
			return false;

	}


	
	
	public int getAmount() {
		return fAmount;
	}

	public void setAmount(int Amount) {
		this.fAmount = Amount;
	}

	public Currency getCurrency() {
		return fCurrency;
	}
}