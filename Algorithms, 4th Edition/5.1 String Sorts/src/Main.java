import java.util.ArrayList;
import java.util.Scanner;

class KeyValuePair {

    private Integer key;
    private String value;

    public KeyValuePair(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer key() {
        return this.key;
    }

    public String value() {
        return this.value;
    }

    public String toString() {
        return this.key.toString() + " -> " + this.value;
    }

}

class KeyIndexedCount {

    private KeyValuePair[] pairs;
    private KeyValuePair[] sorted_pairs;
    private int[] count;

    public KeyIndexedCount(KeyValuePair[] pairs, int max_key) {
        this.pairs = pairs.clone();
        this.sorted_pairs = new KeyValuePair[pairs.length];
        this.count = new int[max_key + 2]; // Use key+1 as index to make calc easier
        for (KeyValuePair pair : pairs) {
            count[pair.key() + 1]++;
        }
        int[] start_from = count.clone();
        for (int i = 0; i < start_from.length - 1; i++) {
            start_from[i + 1] += start_from[i];
        }
        for (KeyValuePair pair : pairs) {
            sorted_pairs[start_from[pair.key()]++] = pair;
        }
    }

    public KeyValuePair[] sorted() {
        return sorted_pairs;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (KeyValuePair pair : this.sorted()) {
            sb.append(pair.toString()).append("\n");
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer max_key = 0;
        ArrayList<KeyValuePair> a = new ArrayList<>();
        {
            Integer key;
            String value;
            String[] tokens;

            while (in.hasNextLine()) {
                tokens = in.nextLine().split(" ");

                key = Integer.parseInt(tokens[0]);
                if (key > max_key) {
                    max_key = key;
                }
                value = tokens[1];
                a.add(new KeyValuePair(key, value));
            }
        }
        KeyIndexedCount kic = new KeyIndexedCount(a.toArray(new KeyValuePair[0]), max_key);
        KeyValuePair[] sorted = kic.sorted();
        System.out.println(kic.toString());
    }
}