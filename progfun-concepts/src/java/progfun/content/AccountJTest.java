package java.progfun.content;

import java.math.BigDecimal;

/**
 * <p>Java Test class to calculate interest rate based on account balance.</p>
 *
 * Created by saumil on 2014/04/24.
 */
public class AccountJTest {
    private static final BigDecimal PRIME_RATE = new BigDecimal("0.09");

    public static void Main( String[] args ){
        final BigDecimal balance = new BigDecimal("9234.23");
        final AccountClassification aType = AccountClassification.POOR;
        final BigDecimal interestRate;

        switch ( aType ) {
            case POOR:
                interestRate = PRIME_RATE;
                break;
            case WORKING:
                interestRate = PRIME_RATE.subtract(new BigDecimal("0.015"));
                break;
            case RICH:
                interestRate = PRIME_RATE.subtract(new BigDecimal("0.02"));
                break;
            default:
                throw new IllegalArgumentException("Unknown account type found: " + aType);
        }

        System.out.println("Interest Rate per Month = R" + balance.multiply(interestRate) );
    }
}
