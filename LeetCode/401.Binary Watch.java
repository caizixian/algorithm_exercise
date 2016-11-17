import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    private List<List<Integer>> append_to_all(List<List<Integer>> ll, int i) {
        List<List<Integer>> result = new ArrayList<>();
        if (ll.size() == 0) {
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            result.add(temp);
        }
        for (List<Integer> l : ll) {
            List<Integer> temp = new ArrayList<>(l);
            temp.add(i);
            result.add(temp);
        }
        return result;
    }

    private List<List<Integer>> select(List<Integer> from_ori, int count) {
        List<Integer> from = new ArrayList<>(from_ori);
        if (count == 0) {
            return new ArrayList<>();
        }
        if (from.size() == count || from.size() == 1) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(from);
            return result;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> select_this = append_to_all(select(from.subList(1, from.size()), count - 1), from.get(0));
        List<List<Integer>> not_select = select(from.subList(1, from.size()), count);
        if (select_this.size() > 0) {
            result.addAll(select_this);
        }
        if (not_select.size() > 0) {
            result.addAll(not_select);
        }
        return result;
    }

    private HashSet<Integer> sumListofList(List<List<Integer>> ll) {
        HashSet<Integer> result = new HashSet<>();
        for (List<Integer> l : ll) {
            result.add(l.stream().mapToInt(Integer::intValue).sum());
        }
        return result;
    }

    private void addHourMin(List<String> l, Integer hour, Integer min) {
        if ((hour >= 0 && hour <= 11) && (min >= 0 && min <= 59)) {
            l.add(hour.toString() + ":" + (min >= 10 ? "" : "0") + min.toString());
        }
    }

    public List<String> readBinaryWatch(int num) {

        List<String> result = new ArrayList<>();
        if (num == 0) {
            result.add("0:00");
            return result;
        }
        for (int hour = 0; hour <= Math.min(num, 4); hour++) {
            if (num - hour > 6) {
                continue; // Cannot be displayed
            }
            List<List<Integer>> hours = select(Arrays.asList(1, 2, 4, 8), hour);
            List<List<Integer>> minutes = select(Arrays.asList(1, 2, 4, 8, 16, 32), num - hour);
            if (minutes.size() == 0) {
                for (Integer possbile_hour : sumListofList(hours)) {
                    addHourMin(result, possbile_hour, 0);
                }
            }
            if (hours.size() == 0) {
                for (Integer possbile_min : sumListofList(minutes)) {
                    addHourMin(result, 0, possbile_min);
                }
            }
            for (Integer possbile_hour : sumListofList(hours)) {
                for (Integer possbile_min : sumListofList(minutes)) {
                    addHourMin(result, possbile_hour, possbile_min);
                }
            }
        }
        return result;
    }
}