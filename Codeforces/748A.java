import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lanes = in.nextInt();
        int desks = in.nextInt();
        int deskNum = in.nextInt();
        int lane = (int) Math.ceil(deskNum / (desks * 2.0));
        int desksInLane = deskNum - (lane - 1) * (desks * 2);
        int desk = (int) Math.ceil(desksInLane / 2.0);
        char lr = (deskNum % 2 == 0) ? 'R' : 'L';
        System.out.println(lane + " " + desk + " " + lr);
    }
}