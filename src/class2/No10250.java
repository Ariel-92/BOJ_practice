package class2;

import java.util.ArrayList;
import java.util.Scanner;

public class No10250 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T;
        ArrayList<Integer> H = new ArrayList<>();
        ArrayList<Integer> W = new ArrayList<>();
        ArrayList<Integer> N = new ArrayList<>();

        T = scanner.nextInt();

        for(int i = 0; i < T; i++) {
            H.add(scanner.nextInt());
            W.add(scanner.nextInt());
            N.add(scanner.nextInt());
        }

        for(int i = 0; i < T; i++) {
            int height = N.get(i) % H.get(i);
            int width = N.get(i) / H.get(i) + 1;
            if(height == 0) {
                height = H.get(i);
                width--;
            }

            System.out.println(height + String.format("%02d", width));
        }
    }
}