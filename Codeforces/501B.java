import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        HashMap<String, String> new_to_old = new HashMap<>();
        int count = 0;
        for (int i = 0; i < size; i++) {

            String old_username = in.next();
            String new_username = in.next();

            if (new_to_old.containsKey(old_username)) {
                String original = new_to_old.get(old_username);
                new_to_old.remove(old_username);
                new_to_old.put(new_username, original);
            } else {
                new_to_old.put(new_username, old_username);
                count++;
            }
        }

        System.out.println(count);
        for (HashMap.Entry<String, String> entry : new_to_old.entrySet()) {
            System.out.printf("%s %s\n", entry.getValue(), entry.getKey());
        }
    }
}