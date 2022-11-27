import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MemberTests {
    static SetCorrect setTest;
    @BeforeAll
    static void setUpSet(){
        setTest = new SetCorrect();
        setTest.insert(0);
        setTest.insert(1);
        setTest.insert(6);
        setTest.insert(3);
    }
    @Test
    public void testEmptyArray(){
        SetCorrect set = new SetCorrect();
        assertNotNull(set);
        for (int i: List.of(-1000, -1, 4, 1000, 9999)){
            assertFalse(set.member(i));
        }
    }
    @Test
    public void testMemberSmallest(){
        assertTrue(setTest.member(0));
    }
    @Test
    public void testMemberHighest(){
        assertTrue(setTest.member(6));
    }
    @Test
    public void testNonMemberMiddle(){
        assertFalse(setTest.member(2));
    }
}
