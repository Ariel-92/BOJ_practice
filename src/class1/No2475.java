package CLASS1;

import java.util.Scanner;

public class No2475 {
    public static void main(String[] args) {
        int[] array = new int[5];
        Scanner scanner = new Scanner(System.in);
        int result = 0;

        for (int i = 0; i < 5; i++) {
            array[i] = scanner.nextInt() % 10;
            array[i] *= array[i];
            result += array[i];
        }

        System.out.println(result % 10);
    }
}
