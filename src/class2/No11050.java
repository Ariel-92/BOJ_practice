package class2;

import java.util.Scanner;

public class No11050 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int temp = 1;

        if (K > N - K) {
            for (int i = K + 1; i <= N; i++)
                temp *= i;
            for (int i = 2; i <= N - K; i++)
                temp /= i;
        } else {
            for (int i = N - K + 1; i <= N; i++)
                temp *= i;
            for (int i = 2; i <= K; i++)
                temp /= i;
        }

        System.out.println(temp);
    }
}
