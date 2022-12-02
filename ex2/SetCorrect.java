import java.util.*;
import java.util.function.IntBinaryOperator;

public class SetCorrect {
    private ArrayList<Integer> a;
    public SetCorrect() {
        a = new ArrayList<Integer>();
    }
    public int[] toArray() {
        int[] ia = new int[a.size()];
        for (int i = 0; i < ia.length; i++) {
            ia[i] = a.get(i);
        }
        return ia;
    }
    public void insert(int x) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == x) {
                return;
            } else if (a.get(i) > x) {
                a.add(i, x);
                return;
            }
        }
        a.add(x);
    }
    public boolean member(int x) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > x) {
                return false;
            } else if (a.get(i) == x) {
                return true;
            }
        }
        return false;
    }
    public void intersect(SetCorrect s) {
        ArrayList<Integer> tempList = new ArrayList<>();

        for (Integer integer : a) {
            if (!(s.member(integer))) {
                tempList.add(integer);
            }
        }
        for (Integer num : tempList) {
            a.remove(num);
        }
    }
    // Try with:
    //   (a, b) -> a + b;
    //   (a, b) -> a - b;
    public boolean distinctClosed(IntBinaryOperator f) {
        for (Integer integerOne: a) {
            for (Integer integerTwo : a) {
                if (!member(f.applyAsInt(integerOne, integerTwo)) && !integerOne.equals(integerTwo))
                    return false;
            }
        }
        return true;
    }
}