package in.mediumone.hackerrank.dynprog;

public class FibonacciRecursion {

    //Fibo(0) = 1, Fibo(1) = 1, Fibo(2) = 2, Fibo(3) = 3, Fibo(4) = 5, Fibo(5) = 8

    public static void main(String[] args) {
        int result = fibo(5);

        System.out.println(result);
    }

    private static int fibo(int i) {

        System.out.println("Fibo called for " + i);

        if(i <= 1) {
            return 1;
        } else {
            return fibo(i - 1) + fibo(i - 2);
        }
    }
}
