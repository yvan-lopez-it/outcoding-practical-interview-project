import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Project03_ {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        combinationSum(nums, 10);
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, target, 0);
        result.stream()
                .map(combination -> combination.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")))
                .forEach(System.out::println);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> combination, int[] nums, int target, int start) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(combination));
        } else {
            for (int i = start; i < nums.length; i++) {
                combination.add(nums[i]);
                backtrack(result, combination, nums, target - nums[i], i);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
