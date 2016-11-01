import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Solution {
    class Player {

        ArrayList<Score> history_score;
        Score current_score;

        Player() {
            this.history_score = new ArrayList<>();
            this.current_score = new Score();
        }

        void insert_new_score(int change, int round) {
            current_score = current_score.new_score(change, round);
            history_score.add(current_score);
        }

        int min_round_at_least_score(int target_score) {
            for (Score s : history_score) {
                if (s.score >= target_score) {
                    return s.round;
                }
            }
            return 9999; // Do not meat the target score.
        }

        int current_score() {
            return this.current_score.score;
        }

    }

    class Score {
        int score;
        int round;

        Score() {
            this.score = 0;
            this.round = 0;
        }

        Score(int score, int round) {
            this.score = score;
            this.round = round;
        }

        Score new_score(int change, int round) {
            return new Score(this.score + change, round);
        }

        public String toString() {
            return this.score + " at round " + this.round;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, Player> players = new HashMap<>();
        int rounds = Integer.parseInt(in.nextLine().trim());

        for (int i = 1; i <= rounds; i++) {
            String player_name = in.next();
            int change = in.nextInt();

            // Init a new Player if it doesn't exist
            if (!players.containsKey(player_name)) {
                players.put(player_name, new Solution().new Player());
            }

            // Get corresponding player
            Player current_player = players.get(player_name);

            // Change its score
            current_player.insert_new_score(change, i);
        }


        int max_score = 0;

        for (HashMap.Entry<String, Player> entry : players.entrySet()) {
            int c = entry.getValue().current_score();
            if (c > max_score) {
                max_score = c;
            }
        }


        int min_round = 9999;
        String best_player = "";
        // Find best player
        for (HashMap.Entry<String, Player> entry : players.entrySet()) {
            if (entry.getValue().current_score() != max_score) {
                continue; // Not better player
            }

            // Is better player, but is it best?
            int entry_min_round = entry.getValue().min_round_at_least_score(max_score);

            if (entry_min_round < min_round) {
                min_round = entry_min_round;
                best_player = entry.getKey();
            }
        }

        System.out.println(best_player);
    }
}