import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.next();
        String genomeSequence = in.next();
        if (genomeSequence.length() % 4 != 0) {
            System.out.println("==="); // Invalid sequence
            return;
        }
        HashMap<Character, Integer> nucleotideCnt = new HashMap<>();
        int countPerNucleotide = genomeSequence.length() / 4;

        for (char nucleotide : "AGCT".toCharArray()) {
            nucleotideCnt.put(nucleotide, countPerNucleotide); // Init count
        }

        for (char ch : genomeSequence.toCharArray()) {
            if (ch != '?') {
                nucleotideCnt.compute(ch, (_k, _v) -> _v - 1);
            }
        }

        for (char nucleotide : "AGCT".toCharArray()) {
            int countLeft = nucleotideCnt.get(nucleotide);
            if (countLeft < 0) {
                System.out.println("==="); // Invalid sequence
                return;
            }
            if (countLeft == 0) {
                nucleotideCnt.remove(nucleotide);
            }
        }

        for (char ch : genomeSequence.toCharArray()) {
            if (ch == '?') {
                char chosenNucleotide = (Character) nucleotideCnt.keySet().toArray()[0];
                System.out.print(chosenNucleotide);
                nucleotideCnt.compute(chosenNucleotide,
                        (_k, _v) -> (_v == 1) ? null : _v - 1);
            } else {
                System.out.print(ch);
            }
        }
    }
}