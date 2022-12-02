import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class IntersectTests {
    SetCorrect a;
    SetCorrect b;
    SetCorrect c;
    SetCorrect d;
    SetCorrect e;
    SetCorrect f;


    @BeforeEach
    void testSets() {

        a = new SetCorrect();
        a.insert(0);
        a.insert(2);
        a.insert(4);
        a.insert(6);

        b = new SetCorrect();
        b.insert(1);
        b.insert(2);
        b.insert(3);
        b.insert(4);
        b.insert(5);

        c = new SetCorrect();
        c.insert(1);
        c.insert(3);
        c.insert(5);

        e = new SetCorrect();
        e.insert(3);
        e.insert(4);
        e.insert(5);

        d = new SetCorrect();

        f = new SetCorrect();
        f.insert(0);
        f.insert(5);

    }

    @Test
    void IntersectTests1() {
        a.intersect(b);
        int[] outcome = {2, 4};
        assertArrayEquals(outcome, a.toArray());
    }

    @Test
    void IntersectTests2() {
        a.intersect(c);
        int[] outcome = {};
        assertArrayEquals(outcome, a.toArray());
    }

    @Test
    void IntersectTests3() {
        a.intersect(d);
        int[] outcome = {};
        assertArrayEquals(outcome, a.toArray());
    }

    @Test
    void IntersectTests4() {
        a.intersect(e);
        int[] outcome = {4};
        assertArrayEquals(outcome, a.toArray());
    }

    @Test
    void IntersectTests5() {
        a.intersect(f);
        int[] outcome = {0};
        assertArrayEquals(outcome, a.toArray());
    }

    @Test
    void IntersectTests6() {
        b.intersect(a);
        int[] outcome = {2,4};
        assertArrayEquals(outcome, b.toArray());
    }

    @Test
    void IntersectTests7() {
        b.intersect(d);
        int[] outcome = {};
        assertArrayEquals(outcome, b.toArray());
    }

    @Test
    void IntersectTests8() {
        d.intersect(c);
        int[] outcome = {};
        assertArrayEquals(outcome, d.toArray());
    }

    @Test
    void IntersectTests9() {
        b.intersect(f);
        int[] outcome = {5};
        assertArrayEquals(outcome, b.toArray());
    }

    @Test
    void IntersectTests10() {
        c.intersect(f);
        int[] outcome = {5};
        assertArrayEquals(outcome, c.toArray());
    }

    @Test
    void IntersectTests11() {
        b.intersect(c);
        int[] outcome = {1, 3, 5};
        assertArrayEquals(outcome,b.toArray());
    }
}
