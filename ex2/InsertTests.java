import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class InsertTests {
    SetCorrect setTest;
    @BeforeEach
    public void setUpSet(){
        setTest = new SetCorrect();
    }
    @Test
    public void testJustAdd(){ //exist the loop immediately
        assertEquals(0, setTest.toArray().length);
        setTest.insert(0);
        assertEquals(1, setTest.toArray().length);
        assertEquals(0, setTest.toArray()[0]);
    }
    @Test
    public void testAddDuplicate(){ //the else and then the if inside it
        setTest.insert(5); //tested above
        setTest.insert(5);
        assertEquals(1, setTest.toArray().length); //fails because code allows duplicates
        assertArrayEquals(new int[]{5}, setTest.toArray());
    }
    @Test
    public void testAddLower(){ //inside the first if
        setTest.insert(1);
        setTest.insert(-1);
        assertEquals(2, setTest.toArray().length); //fails because of a bug ()
        assertArrayEquals(new int[]{-1, 1}, setTest.toArray());
    }
    @Test
    public void testAddHigher(){ //the else but the if inside is false
        setTest.insert(0);
        setTest.insert(0);
        setTest.insert(-1000);
        setTest.insert(1000);
        setTest.insert(500);
        assertEquals(4, setTest.toArray().length); //fails because of test above
        assertArrayEquals(new int[]{-1000, 0, 500, 1000}, setTest.toArray());
    }
}
