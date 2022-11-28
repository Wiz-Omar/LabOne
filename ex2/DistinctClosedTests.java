import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.function.IntBinaryOperator;
import static org.junit.jupiter.api.Assertions.*;

public class DistinctClosedTests {
    static SetCorrect setTest;
    static IntBinaryOperator operatorSum = Integer::sum;
    static IntBinaryOperator operatorSub = (left, right) -> left-right;

    @BeforeAll
    static void setUpSet(){
        setTest = new SetCorrect();
        setTest.insert(3);
        setTest.insert(2);
        setTest.insert(1000);
        setTest.insert(6);
        // setTest: {2, 3, 6, 1000}
    }
    /*
    The pairs
    2,3
    2,6
    2,1000
    3,6
    3,1000
    6,1000
    */
    @Test
    public void testEmptySet(){
        assertFalse(new SetCorrect().distinctClosed(operatorSub));
        assertFalse(new SetCorrect().distinctClosed(operatorSum));
    }

    @Test
    public void testFalse(){
        assertFalse(setTest.distinctClosed(operatorSum));
        assertFalse(setTest.distinctClosed(operatorSub));
    }
    @Test
    public void testTrue(){
        setTest.insert(1006);
        setTest.insert(-998);
        assertTrue(setTest.distinctClosed(operatorSum));
        assertTrue(setTest.distinctClosed(operatorSub));
    }
    /*
    The pairs
    -998,2
    -998,3
    -998,6
    -998,1000
    -998,1006
    2,3
    2,6
    2,1000
    2,1006
    3,6
    3,1000
    3,1006
    6,1000
    6,1006
    */
}
