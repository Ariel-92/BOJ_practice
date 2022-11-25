package class2;

import java.math.BigInteger;
import java.util.Scanner;

public class No15829 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int L = scanner.nextInt();
        int[] str = new int[50];

        String temp_str = scanner.next();

        for (int i = 0; i < L; ++i) {
            str[i] = (int) temp_str.charAt(i) - (int) 'a' + 1;
        }

        BigInteger hash = new BigInteger("0");
        for (int i = 0; i < L; ++i) {
            hash = hash.add(new BigInteger(Integer.toString(str[i])).multiply(new BigInteger("31").pow(i)));
        }

        hash = hash.mod(new BigInteger("1234567891"));
        System.out.println(hash);
    }
}
