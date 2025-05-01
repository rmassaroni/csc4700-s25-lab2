package lab2;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
        // TODO Auto-generated method stub
        return false;
    }

}