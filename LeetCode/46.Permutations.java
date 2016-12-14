import java.util.LinkedList;
import java.util.List;

public class Solution {
    private int[] nums;
    private List<List<Integer>> result;
    private LinkedList<Integer> combination;
    private boolean[] usedIdx;

    private void search() {
        boolean complete = true;
        for (int i = 0; i < nums.length; i++) {
            if (!usedIdx[i]) {
                complete = false;
                usedIdx[i] = true;
                combination.add(nums[i]);
                search();
                combination.pollLast();
                usedIdx[i] = false;
            }
        }
        if (complete) {
            result.add((LinkedList) combination.clone());
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.result = new LinkedList<>();
        this.combination = new LinkedList<>();
        this.usedIdx = new boolean[nums.length];
        search();
        return result;
    }
}