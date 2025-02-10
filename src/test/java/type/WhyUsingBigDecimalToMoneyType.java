package type;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhyUsingBigDecimalToMoneyType {
    @Test
    public void compareDoubleType() {
        double x = 100.0000000005;
        double y = 100.0000000004;
        double expected = 90.0000000001;

        assertEquals(expected, x - y);

    }

    @Test
    public void compareBigDecimalType() {
        BigDecimal x = BigDecimal.valueOf(100.0000000005);
        BigDecimal y = BigDecimal.valueOf(10.0000000004);
        BigDecimal expected = BigDecimal.valueOf(90.0000000001);

        assertEquals(expected, x.subtract(y));
    }
}
