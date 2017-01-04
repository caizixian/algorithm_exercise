import java.util.*;

public class Solution {
    public static int optimize(int durabilityLeft, PriorityQueue<Integer> durations) {
        int count = 0;
        while (!durations.isEmpty()) {
            int dur = durations.peek();
            if (dur <= durabilityLeft) {
                durabilityLeft -= durations.poll();
                count += 2;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int winterDays = in.nextInt();
        int tireDura = in.nextInt();
        int coldDays = 0;

        List<Integer> durations = new ArrayList<>();
        List<Boolean> isWarms = new ArrayList<>();

        int duration = 0; // Also act as dummy value for summer days
        boolean isWarm = true;
        for (int i = 0; i < winterDays; i++) {
            int temperature = in.nextInt();
            if (temperature < 0) {
                coldDays++;
            }

            if ((temperature >= 0) != isWarm) {
                durations.add(duration);
                isWarms.add(isWarm);

                isWarm = temperature >= 0;
                duration = 1;
            } else {
                duration++;
            }
        }
        durations.add(duration);
        isWarms.add(isWarm);

        int originalNeed = isWarms.size() - 1;
        if (originalNeed == 0) {
            // We don't need to change tier
            System.out.println(0);
            return;
        }

        PriorityQueue<Integer> warmDurations = new PriorityQueue<>();
        for (int i = 1; i < isWarms.size() - 1; i++) {
            if (isWarms.get(i)) {
                warmDurations.add(durations.get(i));
            }
        }
        PriorityQueue<Integer> warmDurationsC = new PriorityQueue<>(warmDurations);

        // Only use tire on cold days
        int durabilityLeft = tireDura - coldDays;
        if (durabilityLeft < 0) {
            // The durability of the tier is not sufficient
            System.out.println(-1);
            return;
        }

        // Optimization we can achieve ignoring ending segment
        int optimization = 0;
        optimization += optimize(durabilityLeft, warmDurations);

        if (isWarms.get(isWarms.size() - 1)) {
            // Considering the ending segment
            int durabilityLeftC = tireDura - coldDays;
            int optimizationC = 0;
            if (durations.get(isWarms.size() - 1) <= durabilityLeftC) {
                optimizationC++;
                durabilityLeftC -= durations.get(isWarms.size() - 1);
                optimizationC += optimize(durabilityLeftC, warmDurationsC);
            }
            optimization = Math.max(optimization, optimizationC);
        }

        System.out.println(originalNeed - optimization);
    }
}