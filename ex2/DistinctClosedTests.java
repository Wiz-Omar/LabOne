import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
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
        assertTrue(new SetCorrect().distinctClosed(operatorSub));
        assertTrue(new SetCorrect().distinctClosed(operatorSum));
    }

    @Test
    public void testFalseFirstPair(){
        assertFalse(setTest.distinctClosed(operatorSum));
        assertFalse(setTest.distinctClosed(operatorSub));
    }
    @Test
    public void testFalseRandomPair(){
        SetCorrect set = new SetCorrect();
        set.insert(-1007);
        set.insert(0);
        set.insert(1007);
        set.insert(1008);
        assertFalse(set.distinctClosed(operatorSum));
        assertFalse(set.distinctClosed(operatorSub));
    }
    @Test
    public void testTrue(){
        SetCorrect set = new SetCorrect();
        set.insert(-998);
        set.insert(0);
        set.insert(998);
        //setTest: {-998, 0, 998}
        assertTrue(set.distinctClosed(operatorSum));
    }
}
