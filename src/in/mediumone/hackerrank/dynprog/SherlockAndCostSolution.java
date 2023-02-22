package in.mediumone.hackerrank.dynprog;

import java.util.*;

public class SherlockAndCostSolution {

    public static void main(String[] args) {
        List<Integer> input1 = Arrays.asList(3, 2, 1);
        List<Integer> input2 = Arrays.asList(10, 1, 10, 1, 10);
        List<Integer> input3 = Arrays.asList(12, 10, 12, 10, 12);
        List<Integer> input4 = Arrays.asList(11, 12, 13, 14, 15);
        List<Integer> input5 = Arrays.asList(11, 12, 13, 14);
        List<Integer> input6 = Arrays.asList(5, 22, 73, 4);
        List<Integer> input7 = Arrays.asList(5, 22, 55, 73, 4);
        List<Integer> input8 = Arrays.asList(100, 22, 100, 73, 4, 8);

        System.out.println(cost(input8));
        System.out.println("Invocation count: " + counter);

//        System.out.println(cost(input2));
//        System.out.println("Invocation count: " + counter);

//        System.out.println(cost(input7));
//        System.out.println("Invocation count: " + counter);

//        System.out.println(cost(input8));
//        System.out.println("Invocation count: " + counter);

//        System.out.println(cost(input3));
//        System.out.println(cost(input4));
//        System.out.println(cost(input5));
//        System.out.println(cost(input6));
//        System.out.println(cost(input7));
    }

    /*
     * Complete the 'cost' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY B as parameter.
     */
    public static int cost(List<Integer> input) {
        List<List<Integer>> allSubLists = getAllSubListsRecursion(input);

        System.out.println(allSubLists);

        List<Integer> listOfSumOfAbsDiff = new ArrayList<>(allSubLists.size());

        for (List<Integer> list : allSubLists) {
            int sumOfAbsDiff = getSumOfAbsDifference(list);
            listOfSumOfAbsDiff.add(sumOfAbsDiff);
        }

        return Collections.max(listOfSumOfAbsDiff);
    }

    private static int getSumOfAbsDifference(List<Integer> integers) {
        int sum = 0;

        for (int i = 0; i < (integers.size() - 1); i++) {
            sum += Math.abs(integers.get(i) - integers.get(i+1));
        }

        return sum;
    }

    private static Map<List<Integer>, List<List<Integer>>> recursionCache = new HashMap<>();

    private static int counter = 0;

    private static List<List<Integer>> getAllSubListsRecursion(List<Integer> input) {

        counter++;

//        System.out.println("SLR called with: " + input);

        if (recursionCache.containsKey(input)) {
            List<List<Integer>> output = recursionCache.get(input);
//            System.out.println("SLR called with: " + input + ", and returning from cache: " + output);
            return output;
        }

        List<List<Integer>> allSubLists = new ArrayList<>();

        if (input.size() == 1) {
            allSubLists.add(input);
//            System.out.println("SLR called with: " + input + ", and returning: " + allSubLists);
            recursionCache.put(input, allSubLists);
            return allSubLists;
        }

        //Get 'i'th element
        int ithElement = input.get(0);

        for (int j = ithElement; j >= 1; j--) {

            List<Integer> subListInput = input.subList(1, input.size());


            if (subListInput.isEmpty()) {
                continue;
            }

            List<List<Integer>> subLists = getAllSubListsRecursion(subListInput);

            for (List<Integer> eachSubList : subLists) {
                List<Integer> mainListEntry = new ArrayList<>(input.size());

                mainListEntry.add(j);
                mainListEntry.addAll(eachSubList);

                allSubLists.add(mainListEntry);
            }
        }

        recursionCache.put(input, allSubLists);
//        System.out.println("SLR called with: " + input + ", and returning: " + allSubLists);
        return allSubLists;
    }
}
