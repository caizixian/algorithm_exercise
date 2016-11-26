public class Solution {
    public int overlap(int a, int b, int c, int d) {
        // a<b, c<d
        if (b <= c || d <= a) {
            return 0;
        }
        return Math.min(b, d) - Math.max(a, c);
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // 1st rectangle SW (A,B) NE (C,D)
        // 2nd rectangle SW (E,F) NE (G,H)
        // Overlap = overlap((A,C),(E,G)) * overlap((B,D),(F,H))

        // if 1 contains 2 or 2 contains 1
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);

        return area1 + area2 - overlap(A, C, E, G) * overlap(B, D, F, H);
    }
}