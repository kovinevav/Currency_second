import kovynev.bl.Cash;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CashTest {
    Cash cash = new Cash();
    @Test
    public void buyUSDShouldGetFalse(){
        Assertions.assertFalse(cash.buyUSD(1000,72));
    }
    @Test
    public void buyUSDShouldGetTrue(){
        Assertions.assertTrue(cash.buyUSD(1,72));
    }
    @Test
    public void sellUSDShouldGetFalse(){
        Assertions.assertFalse(cash.sellUSD(100000,75));
    }
}
