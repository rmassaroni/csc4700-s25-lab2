package lab2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

public class CurrencyConverter {

    protected static final int DECIMAL_DIGITS = 2;

    public static void main(String[] args) {
        System.out.println("Hello CC");
    }

    public BigDecimal convert(BigDecimal inputAmount, BigDecimal conversionRate) {
        BigDecimal result = inputAmount.multiply(conversionRate);
        return result.setScale(DECIMAL_DIGITS, RoundingMode.HALF_UP);
    }

    public boolean isValidRate(BigDecimal conversionRate) {
        return conversionRate.compareTo(BigDecimal.ZERO) > 0 && conversionRate.compareTo(BigDecimal.valueOf(100000.00)) <= 0;
    }
    
    public Money moneyConvert(Money input, BigDecimal rate, Currency currency) {
    	BigDecimal resultValue = input.getValue().multiply(rate).setScale(DECIMAL_DIGITS, RoundingMode.HALF_UP);
        return new Money(resultValue, currency);
    }
}