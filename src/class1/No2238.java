package CLASS1;

import java.math.BigInteger;
import java.util.Scanner;

public class No2238 {
    public static void main(String[] args){
        BigInteger A, B;
        Scanner scanner = new Scanner(System.in);

        A = scanner.nextBigInteger();
        B = scanner.nextBigInteger();

        System.out.println(A.add(B));
        System.out.println(A.subtract(B));
        System.out.println(A.multiply(B));
    }
}
