package class2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class No10816 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N, M;
        Map<Integer, Integer> NCardsMap = new HashMap<>();
        ArrayList<Integer> MCards = new ArrayList<>();

        N = scanner.nextInt();
        for(int i = 0; i < N; i++) {
            int tempNum = scanner.nextInt();
            if (NCardsMap.containsKey(tempNum)) {
               NCardsMap.replace(tempNum, NCardsMap.get(tempNum) + 1);
            } else {
                NCardsMap.put(tempNum, 1);
            }
        }

        M = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int tempNum = scanner.nextInt();
            if (NCardsMap.containsKey(tempNum)) {
                stringBuilder.append(NCardsMap.get(tempNum));
            } else {
                stringBuilder.append(0);
            }
            stringBuilder.append(' ');
        }

        System.out.println(stringBuilder);
    }
}
