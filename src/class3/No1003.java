package class3;

import java.util.ArrayList;
import java.util.Scanner;

public class No1003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            numbers.add(scanner.nextInt());
        }

        int[] countZero = new int[41];
        int[] countOne = new int[41];

        countZero[0] = 1;
        countZero[1] = 0;
        countOne[0] = 0;
        countOne[1] = 1;

        for(int i = 2; i < 41; i++) {
            countZero[i] = countZero[i - 1] + countZero[i - 2];
            countOne[i] = countOne[i - 1] + countOne[i - 2];
        }

        for(int i = 0; i < T; i++) {
            System.out.println(countZero[numbers.get(i)] + " " + countOne[numbers.get(i)]);
        }
    }
}
