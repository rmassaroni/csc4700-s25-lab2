package lab2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CurrencyConverterTest {
	
    private CurrencyConverter converter;
    
    @BeforeEach
    public void setUp() {
        this.converter = new CurrencyConverter();
    }

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	void testConvert() {
		BigDecimal conversionRate = BigDecimal.valueOf(2.70);
		BigDecimal inputAmount = BigDecimal.valueOf(100.00);
        BigDecimal expectedResult = BigDecimal.valueOf(270.00).setScale(CurrencyConverter.DECIMAL_DIGITS);
        BigDecimal actualResult = converter.convert(inputAmount, conversionRate);
        assertEquals(expectedResult, actualResult); // order by convention
	}
	
	@Test
    public void testConvertRounding() {
        BigDecimal conversionRate = BigDecimal.valueOf(0.055);
        BigDecimal inputAmount = BigDecimal.valueOf(99.99);
        BigDecimal expectedResult = BigDecimal.valueOf(5.50).setScale(CurrencyConverter.DECIMAL_DIGITS);
        BigDecimal actualResult = converter.convert(inputAmount, conversionRate);
        assertEquals(expectedResult, actualResult);
    }
	
	@Test
	public void testConvertNegativeAmount() {
	    BigDecimal conversionRate = BigDecimal.valueOf(1.50);
	    BigDecimal inputAmount = BigDecimal.valueOf(-20.00);
	    BigDecimal expectedResult = BigDecimal.valueOf(-30.00).setScale(CurrencyConverter.DECIMAL_DIGITS);
	    BigDecimal actualResult = converter.convert(inputAmount, conversionRate);
	    assertEquals(expectedResult, actualResult);
	}
	
	@Test
    public void testIsValidRate() {
//      BigDecimal conversionRate = BigDecimal.valueOf(100000); //returns true
//		BigDecimal conversionRate = BigDecimal.valueOf(100001); //returns false
        BigDecimal conversionRate = BigDecimal.valueOf(2.70);
        assertTrue(converter.isValidRate(conversionRate));
    }
}
