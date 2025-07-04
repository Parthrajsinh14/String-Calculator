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

@Test
public void testTwoNumbersCommaDelimited() {
    Calculator calc = new Calculator();
    assertEquals(8, calc.add("3,5"));
}

@Test
public void testUnknownNumberOfNumbers() {
    Calculator calc = new Calculator();
    assertEquals(15, calc.add("1,2,3,4,5"));
}


} 
 