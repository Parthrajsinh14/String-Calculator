import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void testAddEmptyString() {
        Calculator calc = new Calculator();
        assertEquals(0, calc.add(""));
    }

    @Test
public void testSingleNumberReturnsValue() {
    Calculator calc = new Calculator();
    assertEquals(5, calc.add("5"));
}

} 
 