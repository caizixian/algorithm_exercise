import java.util.HashMap;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, Integer> users = new HashMap<>();

        int user_count = Integer.parseInt(in.nextLine().trim());

        for (int i=0;i<user_count;i++){
            String expected_username = in.nextLine().trim();

            if (!users.containsKey(expected_username)){
                users.put(expected_username, 0);
                System.out.println("OK");
            }else{
                int origin_count = users.get(expected_username);
                origin_count++;
                System.out.printf("%s%d\n", expected_username, origin_count);
                users.put(expected_username, origin_count);
            }
        }
    }
}