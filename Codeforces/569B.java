public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<Integer> numbers_to_use = new HashSet<>();
        int size = in.nextInt();
        for (int i = 1; i <= size; i++) {
            numbers_to_use.add(i);
        }
        int[] SN = new int[size];
        boolean[] need_to_renumber = new boolean[size];
        for (int i = 0; i < size; i++) {
            SN[i] = in.nextInt();
            if (numbers_to_use.contains(SN[i])) {
                numbers_to_use.remove(SN[i]);
            } else {
                need_to_renumber[i] = true;
            }
        }
        Integer[] renumbers = numbers_to_use.toArray(new Integer[numbers_to_use.size()]);
        int ptr = 0;
        for (int i = 0; i < size; i++) {
            if (need_to_renumber[i]) {
                System.out.print(renumbers[ptr]);
                ptr++;
            } else {
                System.out.print(SN[i]);
            }
            System.out.print(" ");
        }
    }
}