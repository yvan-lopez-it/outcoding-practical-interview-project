import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Project03_Test {
    @Test
    public void combinationSum_Test1() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 10;
        List<List<Integer>> expectedResult = new ArrayList<>();

        List<Integer> combination1 = new ArrayList<>();
        combination1.add(1);
        combination1.add(2);
        combination1.add(3);
        combination1.add(4);
        expectedResult.add(combination1);

        List<Integer> combination2 = new ArrayList<>();
        combination2.add(5);
        combination2.add(5);
        expectedResult.add(combination2);

        List<List<Integer>> result = Project03_.combinationSum(nums, target);
        assertTrue(result.contains(combination1));
        assertTrue(result.contains(combination2));
    }

    @Test
    public void combinationSum_Test2() {
        int[] nums = {1, 2, 3};
        int target = 6;
        List<List<Integer>> expectedResult = new ArrayList<>();

        List<Integer> combination1 = new ArrayList<>();
        combination1.add(1);
        combination1.add(2);
        combination1.add(3);
        expectedResult.add(combination1);

        List<List<Integer>> result = Project03_.combinationSum(nums, target);
        assertTrue(result.contains(combination1));
    }
}
