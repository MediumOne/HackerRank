package in.mediumone.hackerrank;

import java.io.*;
import java.util.*;

public class CatsAndMouse {

    // 1 2 3 - Cat B
    // 1 3 2 - Mouse C

    // Complete the catAndMouse function below.
    static String catAndMouse(int x, int y, int z) {
        
        int cat1Distance = Math.abs(z - x);
        
        int cat2Distance = Math.abs(z - y);
        
        if(cat1Distance == cat2Distance) {
            return "Mouse C";
        } else if (cat1Distance > cat2Distance) {
            return "Cat B";
        } else {
            return "Cat A";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
