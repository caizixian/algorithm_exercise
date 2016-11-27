import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class Solution {
    public int compareVersion(String version1, String version2) {
        Stream<Integer> ver1 = Arrays.stream(version1.split("[.]")).map(Integer::parseInt);
        Stream<Integer> ver2 = Arrays.stream(version2.split("[.]")).map(Integer::parseInt);
        Iterator<Integer> iter1 = ver1.iterator();
        Iterator<Integer> iter2 = ver2.iterator();
        while (iter1.hasNext() || iter2.hasNext()) {
            Integer a, b;
            if (iter1.hasNext()) {
                a = iter1.next();
            } else {
                a = 0;
            }
            if (iter2.hasNext()) {
                b = iter2.next();
            } else {
                b = 0;
            }
            if (a.compareTo(b) != 0) {
                return a.compareTo(b);
            }
        }
        return 0;
    }
}