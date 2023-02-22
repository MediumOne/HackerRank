package in.mediumone.hackerrank.dynprog;

import java.util.*;

public class SherlockAndCost {

    public static void main(String[] args) {
        List<Integer> input1 = Arrays.asList(1, 2, 3);
        List<Integer> input2 = Arrays.asList(10, 1, 10, 1, 10);
        List<Integer> input3 = Arrays.asList(12, 10, 12, 10, 12);
        List<Integer> input4 = Arrays.asList(11, 12, 13, 14, 15);
        List<Integer> input5 = Arrays.asList(11, 12, 13, 14);
        List<Integer> input6 = Arrays.asList(5, 22, 73, 4);
        List<Integer> input7 = Arrays.asList(5, 22, 55, 73, 4);
        List<Integer> input8 = Arrays.asList(100, 22, 100, 73, 4, 8);
        List<Integer> input9 = Arrays.asList(3, 15, 4, 12, 10); //50

        System.out.println(cost(input9));
    }

    /*
     * Complete the 'cost' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY B as parameter.
     */
    public static int cost(List<Integer> input) {

        int diffLeft = 0;
        int diffRight = 0;
        int maxDiff = 0;

        for (int i = 1; i < input.size(); i++) {

            int firstDiff = Math.max(diffLeft, (diffRight + Math.abs(input.get(i - 1) - 1)));

            int highDiff = Math.max((diffLeft + Math.abs(input.get(i) - 1)), (diffRight + Math.abs(input.get(i - 1) - input.get(i))));

            maxDiff = Math.max(firstDiff, highDiff);

            diffLeft = firstDiff;
            diffRight = highDiff;
        }

        return maxDiff;
    }
}
