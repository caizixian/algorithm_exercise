import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.HashSet;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toCollection(HashSet::new));
        HashSet<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toCollection(HashSet::new));
        set2.retainAll(set1); // Only retain intersection
        return set2.stream().mapToInt(i -> i).toArray();
    }
}