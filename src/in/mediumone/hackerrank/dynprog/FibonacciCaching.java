package in.mediumone.hackerrank.dynprog;

import java.util.HashMap;
import java.util.Map;

public class FibonacciCaching {

    //Fibo(0) = 1, Fibo(1) = 1, Fibo(2) = 2, Fibo(3) = 3, Fibo(4) = 5, Fibo(5) = 8

    private static Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        int result = fibo(5);

        System.out.println(result);
    }

    private static int fibo(int i) {

        System.out.println("Fibo called for " + i);

        if(resultMap.containsKey(i)) {
            return resultMap.get(i);
        }

        int result;

        if(i <= 1) {
            result = 1;
        } else {
            result = fibo(i - 1) + fibo(i - 2);
        }

        resultMap.put(i, result);

        return result;
    }
}
