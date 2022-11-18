import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class NextIncompleteTest {
    WorkSchedule schedule = new WorkSchedule(15);
    List<String> tempEmployees = Arrays.asList("Felix", "Jonas", "Mo");
    // 0 <= currenttime < size (15)    -  this is the possible input space (domain) for currenttime

    @Test
    public void nextIncompleteTest(){
        schedule.setRequiredNumber(3, 0, 14);
        for (int j = 0; j < 15; j++){
            if (Arrays.asList(1, 3, 4, 10).contains(j)){
                continue;
            }
            for (String tempEmployee : tempEmployees) {
                schedule.addWorkingPeriod(tempEmployee, j, j);
            }
        }

        assertEquals(1, schedule.nextIncomplete(0));  // results in test fail
        assertEquals(3, schedule.nextIncomplete(3));  // results in test fail
        assertEquals(10, schedule.nextIncomplete(5));

        assertEquals(-1, schedule.nextIncomplete(14));

        for (int i = 0; i < 15; i++){  //This is a test for the "and" condition
            assertEquals(3, schedule.readSchedule(i).requiredNumber);

            if (Arrays.asList(1, 3, 4, 10).contains(i)){
                assertEquals(0, schedule.readSchedule(i).workingEmployees.length);
                continue;
            }
            assertEquals(3, schedule.readSchedule(i).workingEmployees.length);
        }
    }

}
