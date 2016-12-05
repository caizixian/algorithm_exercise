import java.util.ArrayList;

public class Solution {
    enum Status {
        Original, Increase, Equal, Decrease;
    }

    private Status status(int a, int b) {
        if (b > a) {
            return Status.Increase;
        } else if (b == a) {
            return Status.Equal;
        }
        return Status.Decrease;
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int profit = 0;
        ArrayList<Integer> turningPoints = new ArrayList<>();
        Status pre_status = Status.Original;
        for (int i = 1; i < prices.length; i++) {
            Status status = status(prices[i - 1], prices[i]);
            if (status != pre_status) {
                turningPoints.add(prices[i - 1]);
            }
            pre_status = status;
        }
        turningPoints.add(prices[prices.length - 1]); // End
        System.out.println(turningPoints);
        for (int i = 1; i < turningPoints.size(); i++) {
            if (turningPoints.get(i) > turningPoints.get(i - 1)) {
                profit += turningPoints.get(i) - turningPoints.get(i - 1);
            }
        }
        return profit;
    }
}
