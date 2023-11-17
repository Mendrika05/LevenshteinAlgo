public class LevenshteinAlgo {
    public static int[][] levenshtein(String word1, String word2) {
        int l1 = word1.length() + 1;
        int l2 = word2.length() + 1;
        int[][] distanceArray = new int[l1][l2];

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (i == 0) {
                    distanceArray[i][j] = j;
                } else if (j == 0) {
                    distanceArray[i][j] = i;
                } else {
                    distanceArray[i][j] = min(distanceArray[i - 1][j] + 1, distanceArray[i][j - 1] + 1,
                            distanceArray[i - 1][j - 1] + cost(word1.charAt(i - 1), word2.charAt(j - 1)));
                }
            }
        }

        matrix(l1, l2, distanceArray);
        return distanceArray;
    }

    public static void distance(int[][] distanceArray, String word1, String word2) {
        int i = word1.length();
        int j = word2.length();
        int value = distanceArray[i][j];
        System.out.println("Distance (" + word1 + ", " + word2 + ") = " + value);
    }

    public static void matrix(int l1, int l2, int[][] tab) {
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                System.out.print(tab[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static int min(int a, int b, int c) {
        return a > b ? (b > c ? c : b) : (a > c ? c : a);
    }

    public static int cost(int a, int b) {
        return (a == b) ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
        String word1 = "PAPA";
        String word2 = "MAMAN";
        int[][] distanceArray = levenshtein(word1, word2);
        distance(distanceArray, "PAPA", "MAMAN");
    }
}
