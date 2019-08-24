package hackerrank;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Handshake {

    /*
     * Complete the handshake function below.
     */
    static int handshake(int n) {
        /*
         * Write your code here.
         */
        //return (int) (((float)n / 2) * (n-1));
        long handshakes = 0;
        for(int i = 0; i < n; i++) {
            handshakes += i;
        }
        return (int)handshakes;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BufferedWriter bufferedWriter = null;
        try {
    //        bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
            bufferedWriter = new BufferedWriter(new FileWriter("./resources/data/handshake.txt"));


        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            int result = handshake(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
