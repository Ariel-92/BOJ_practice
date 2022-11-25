package class2;

import java.util.Scanner;

public class No10828 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] stack = new int[10000];
        int lastIndex = -1;
        StringBuilder sb = new StringBuilder();

        int N = scanner.nextInt();
        for(int i = 0; i < N; ++i) {
            String order = scanner.next();

            switch (order) {
                case "push" :
                    int temp = scanner.nextInt();
                    ++lastIndex;
                    stack[lastIndex] = temp;
                    break;
                case "pop" :
                    if(lastIndex < 0)
                        sb.append("-1\n");
                    else {
                        sb.append(stack[lastIndex]);
                        sb.append("\n");
                        --lastIndex;
                    }
                    break;
                case "size" :
                    sb.append(lastIndex + 1);
                    sb.append("\n");
                    break;
                case "empty" :
                    if(lastIndex < 0)
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case "top" :
                    if(lastIndex < 0)
                        sb.append("-1\n");
                    else {
                        sb.append(stack[lastIndex]);
                        sb.append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}
