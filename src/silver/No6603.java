package silver;

import java.util.*;

public class No6603 {
    static List<Integer[]> answer = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            int k = scanner.nextInt();

            if(k == 0) break;
            if(!answer.isEmpty()) answer.add(new Integer[0]);

            List<Integer> input = new LinkedList<>();
            for(int i = 0; i < k; i++) {
                input.add(scanner.nextInt());
            }

            input.sort(Comparator.naturalOrder());

            combinations(input, new LinkedList<>(), new boolean[13], 0, k, 6);
        }

        answer.forEach((list) -> {
            for (int j : list) {
                System.out.print(j);
                System.out.print(" ");
            }
            System.out.println();
        });
    }

    static void combinations(List<Integer> input, List<Integer> arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            int arrSize = arr.size();
            Integer[] temp = arr.toArray(new Integer[0]);
            answer.add(temp);
            arr.remove(5);
            return;
        }

        for(int i = start; i < n; i++) {
            visited[i] = true;
            arr.add(input.get(i));
            combinations(input, arr, visited, i + 1, n, r - 1);
            visited[i] = false;
            if(arr.size() > 6 - r) arr.remove(6 - r);
        }
    }
}
