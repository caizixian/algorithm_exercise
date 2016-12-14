import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

class Pair {
    final Integer x;
    final Integer y;
    final int idx1;
    final int idx2;

    Pair(int x, int y) {
        this.x = Math.min(x, y);
        this.y = Math.max(x, y);
        this.idx1 = 0;
        this.idx2 = 0;
    }

    Pair(int x, int y, int idx1, int idx2) {
        this.x = Math.min(x, y);
        this.y = Math.max(x, y);
        this.idx1 = idx1;
        this.idx2 = idx2;
    }

    public boolean conficts(int i) {
        return i == idx1 || i == idx2;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pair other = (Pair) obj;
        return other.x.equals(this.x) && other.y.equals(this.y);
    }


    public int hashCode() {
        return x.hashCode() * 31 + y.hashCode();
    }
}

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        HashMap<Integer, HashSet<Pair>> sum = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                sum.putIfAbsent(nums[i] + nums[j], new HashSet<>());
                sum.get(nums[i] + nums[j]).add(new Pair(nums[i], nums[j], i, j));
            }
        }
        HashSet<Pair> used = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            int n = nums[i];
            if (sum.containsKey(-n)) {
                HashSet<Pair> idxPair = sum.get(-n);
                for (Pair p : idxPair) {
                    Pair dup_check = new Pair(Math.min(n, p.x), Math.max(n, p.y));
                    if (!p.conficts(i) && !used.contains(dup_check)) {
                        LinkedList<Integer> combination = new LinkedList<>();
                        combination.add(n);
                        combination.add(p.x);
                        combination.add(p.y);
                        result.add(combination);
                        used.add(dup_check);
                    }
                }
            }
        }
        return result;
    }
}