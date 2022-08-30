package CLASS1;

import java.math.BigInteger;
import java.util.Scanner;

public class No1271 {
    public static void main(String[] args){
        BigInteger A, B;
        Scanner scanner = new Scanner(System.in);

        A = scanner.nextBigInteger();
        B = scanner.nextBigInteger();

        System.out.println(A.divide(B));
        System.out.println(A.mod(B));
    }
}
