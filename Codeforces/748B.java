import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    private static boolean isMatch(char expect, char get) {
        if (get != expect) {
            System.out.print(-1);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String pattern1 = in.next();
        String pattern2 = in.next();
        HashMap<Character, Character> mapping = new HashMap<>();
        int mapToSelfCnt = 0;
        int mappingCnt = 0;
        for (int i = 0; i < pattern1.length(); i++) {
            char char1 = pattern1.charAt(i);
            char char2 = pattern2.charAt(i);
            if (mapping.containsKey(char1)) {
                if (!isMatch(mapping.get(char1), char2)) {
                    return;
                }
            } else if (mapping.containsKey(char2)) {
                if (!isMatch(mapping.get(char2), char1)) {
                    return;
                }
            } else {
                // Both char1 and char2 don't have mapping
                mapping.put(char1, char2);
                mapping.put(char2, char1);
                // Created a new mapping
                mappingCnt++;
                if (char1 == char2) {
                    // Map to self
                    mapToSelfCnt++;
                }
            }
        }
        HashSet<Character> printed = new HashSet<>();
        System.out.println(mappingCnt - mapToSelfCnt);
        for (Map.Entry<Character, Character> entry : mapping.entrySet()) {
            // Only print distinct pairs
            if (!printed.contains(entry.getKey()) && !printed.contains(entry.getValue())) {
                if (entry.getKey() != entry.getValue()) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }
                printed.add(entry.getKey());
                printed.add(entry.getValue());
            }
        }
    }
}