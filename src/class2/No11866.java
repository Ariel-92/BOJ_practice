package class2;

import java.util.Scanner;

public class No11866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int last = -1;
        int kill_count = 0;
        int death_count = 0;
        int[] mans = new int[1000];

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        while (true) {
            if (death_count >= N)
                break;
            ++last;

            if(last >= N)
                last = 0;

            if(mans[last] == 0)
                ++kill_count;

            if (kill_count == K) {
                kill_count = 0;
                ++death_count;
                mans[last] = 1;
                sb.append(last + 1);
                sb.append(", ");
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");

        System.out.println(sb);
    }
}
