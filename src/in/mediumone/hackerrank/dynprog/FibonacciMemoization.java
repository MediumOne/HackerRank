package in.mediumone.hackerrank.dynprog;

public class FibonacciMemoization {

    public static void main(String[] args) {
        int n = 9;

        int[] fibNumbers = new int[n+1];

        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        // 1, 1, 2, 3, 5, 8,13,21,34,55,89

        fibNumbers[0] = 0;
        fibNumbers[1] = 1;

        for(int i = 2; i <= n; i++) {
            fibNumbers[i] = fibNumbers[i-1] + fibNumbers[i-2];
        }

        System.out.println(fibNumbers[n]);
    }
}
