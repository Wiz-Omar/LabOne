//import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class WorkScheduleTest {
    WorkSchedule schedule = new WorkSchedule(10);

    @BeforeEach
    public void resetSchedule(){
        schedule = new WorkSchedule(10);
    }

    @Test
    public void testStartTimeIsHigher(){
        //condition: starttime > endtime
        schedule.setRequiredNumber(2, 5, 0);
        for (int i = 0; i <= 9; i++) {
            assertEquals(0, schedule.readSchedule(i).requiredNumber);
        }
    }

    @Test
    public void testEndTimeIsHigherAndNotWorkingEmpIsHigherThanRequired(){
        //condition: !(workingEmployees > nemployee) && (starttime < endtime)
        schedule.setRequiredNumber(3, 1, 5);
        Integer[] changedHours = new Integer[]{1, 2, 3, 4, 5};

        for (int i = 1; i <= 5; i++) {
            assertEquals(3, schedule.readSchedule(i).requiredNumber);
            assertEquals(0, schedule.workingEmployees(i, i).length);
        }

        for (int i = 0; i <= 9; i++){ //This is a test for the "and" condition
            if (List.of(changedHours).contains(i)){
                continue;
            }
            assertEquals(0, schedule.readSchedule(i).requiredNumber);
            assertEquals(0, schedule.readSchedule(i).workingEmployees.length);
        }
    }

    @Test
    public void testEndTimeIsHigherAndWorkingEmpIsHigherThanRequired(){
        //condition: (workingEmployees > nemployee) && (starttime < endtime)
        schedule.setRequiredNumber(2, 1, 1); //ensured to be working in the test above

        assertTrue(schedule.addWorkingPeriod("Felix", 1, 1));
        assertTrue(schedule.addWorkingPeriod("Jonas", 1, 1));
        schedule.setRequiredNumber(1, 0, 7);
        Integer[] changedHours = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7};

        for (int i = 0; i <= 7; i++) {
            assertEquals(1, schedule.readSchedule(i).requiredNumber);
        }
        assertEquals(1, schedule.workingEmployees(1, 1).length); //fails because of a bug in the code that
                                    // Arrays.copyof() is sent the wrong new length.. It shouldn't have -1 maybe??

        for (int i = 0; i <= 9; i++){  //This is a test for the "and" condition
            if (List.of(changedHours).contains(i)){
                continue;
            }
            assertEquals(0, schedule.readSchedule(i).requiredNumber);
            assertEquals(0, schedule.readSchedule(i).workingEmployees.length);
        }
    }
}
