/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     December 21, 2025
 **************************************************************************** */

public class Huntingtons {
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int count = 0;
        int max = 0;
        int lastIndex = 0;
        int i = 0;
        while (i < dna.length() - 2) {
            if (dna.substring(i, i + 3).equals("CAG")) {
                if (lastIndex != i - 1) count = 0;
                count++;
                lastIndex = i + 2;
                max = Math.max(max, count);
                i = i + 3;
            }
            else i++;
        }
        return max;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        return s.replace("\n", "")
                .replace("\t", "")
                .replace(" ", "");
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats >= 10 && maxRepeats <= 35)
            return "normal";
        if (maxRepeats >= 36 && maxRepeats <= 39)
            return "high risk";
        if (maxRepeats >= 40 && maxRepeats <= 180)
            return "Huntington's";
        return "not human";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        String geneticSequence = in.readAll();
        geneticSequence = removeWhitespace(geneticSequence);
        int maxRepeats = maxRepeats(geneticSequence);
        System.out.printf("max repeats = %d\n", maxRepeats);
        System.out.println(diagnose(maxRepeats));
    }
}
