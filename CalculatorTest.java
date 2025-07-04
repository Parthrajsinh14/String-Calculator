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

@Test
public void testNewlineAsDelimiter() {
    Calculator calc = new Calculator();
    assertEquals(6, calc.add("1\n2,3"));
}

@Test
public void testCustomDelimiter() {
    Calculator calc = new Calculator();
    assertEquals(3, calc.add("//;\n1;2"));
}

@Test(expected = IllegalArgumentException.class)
public void testNegativeNumberThrowsException() {
    Calculator calc = new Calculator();
    calc.add("1,-2,3,-5");
}

@Test
public void testIgnoreNumbersGreaterThan1000() {
    Calculator calc = new Calculator();
    assertEquals(2, calc.add("2,1001"));
}

@Test
public void testLongDelimiter() {
    Calculator calc = new Calculator();
    assertEquals(6, calc.add("//[***]\n1***2***3"));
}

@Test
public void testMultipleDelimiters() {
    Calculator calc = new Calculator();
    assertEquals(6, calc.add("//[*][%]\n1*2%3"));
}


} 
 