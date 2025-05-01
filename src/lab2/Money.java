package lab2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

public class Money {
	private BigDecimal value;
    private final Currency currencyIdentifier;
    
    public Money(BigDecimal value, Currency currencyIdentifier) {
        this.value = value.setScale(currencyIdentifier.getDefaultFractionDigits(), RoundingMode.HALF_UP);
        this.currencyIdentifier = currencyIdentifier;
    }

    public BigDecimal getValue() {
        return value;
    }
    
    public BigDecimal setValue(BigDecimal newValue) {
    	value = newValue;
    	return value;
    }
    
    public Currency getCurrencyIdentifier() {
        return currencyIdentifier;
    }
    
    @Override
    public String toString() {
        return currencyIdentifier.getCurrencyCode() + " " + value.toPlainString();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return value.equals(money.value) && currencyIdentifier.equals(money.currencyIdentifier);
    }
}
