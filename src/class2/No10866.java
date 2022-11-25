package class2;

import java.util.Scanner;

public class No10866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] deque = new int[20000];
        int front = 10000;
        int back = 9999;

        int N = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; ++i) {
            String order = scanner.next();

            switch (order) {
                case "push_front":
                    --front;
                    deque[front] = scanner.nextInt();
                    break;
                case "push_back":
                    ++ back;
                    deque[back] = scanner.nextInt();
                    break;
                case "pop_front":
                    if(front > back)
                        sb.append("-1\n");
                    else {
                        sb.append(deque[front]);
                        sb.append("\n");
                        ++front;
                    }
                    break;
                case "pop_back":
                    if(front > back)
                        sb.append("-1\n");
                    else {
                        sb.append(deque[back]);
                        sb.append("\n");
                        --back;
                    }
                    break;
                case "size":
                    sb.append(back - front + 1);
                    sb.append("\n");
                    break;
                case "empty":
                    if(front > back)
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case "front":
                    if(front > back)
                        sb.append("-1\n");
                    else {
                        sb.append(deque[front]);
                        sb.append("\n");
                    }
                    break;
                case "back":
                    if(front > back)
                        sb.append("-1\n");
                    else {
                        sb.append(deque[back]);
                        sb.append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}
