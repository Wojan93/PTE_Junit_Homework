package money; 
class Money {
    private int fAmount;
    private String fCurrency;

    public Money(int amount, String currency) {
        fAmount = amount;
        fCurrency = currency;
    }

    public int amount() {
        return fAmount;
    }

    public String currency() {
        return fCurrency;
    }

    public Money add(Money m) {
        Money newMoney = Exchange.exchanged(m, fCurrency);
        newMoney.setAmount(newMoney.getAmount() + fAmount);
        return newMoney;
    }




    @Override
    public boolean equals(Object anObject) {
        if (anObject instanceof Money) {
            Money a = (Money) anObject;
            return a.currency().equals(currency()) && amount() == a.amount();
        }
        return false;
    }

    public int getAmount() {
        return fAmount;
    }

    public void setAmount(int Amount) {
        this.fAmount = Amount;
    }

    public String getCurrency() {
        return fCurrency;
    }
}